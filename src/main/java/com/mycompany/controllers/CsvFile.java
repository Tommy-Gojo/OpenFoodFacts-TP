/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.dao.AdditifDAO;
import com.mycompany.dao.AllergeneDAO;
import com.mycompany.dao.CategorieDAO;
import com.mycompany.dao.FactoryDAO;
import com.mycompany.dao.JPAUtils;
import com.mycompany.dao.MarqueDAO;
import com.mycompany.dao.ProduitDAO;
import com.mycompany.models.Additif;
import com.mycompany.models.Produit;
import com.mycompany.models.Allergene;
import com.mycompany.models.Categorie;
import com.mycompany.models.Marque;
import com.mycompany.models.NutriScore;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tommy
 */
public class CsvFile {
    private static CsvFile instance;

    private String csvFile = "C:\\Users\\Etudiant\\OneDrive - RDK Solutions\\open-food-facts.csv";
    private String line;
    private String csvSeparator = "\\|";
    private String csvDigit = "\\\\d+(\\\\.\\\\d+)?%";
    private List<String> produit = new ArrayList<>();
    private BufferedReader br;

    public CsvFile() {
        try {
            br = new BufferedReader(new FileReader(csvFile, Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {

    }

    public void parse() {
        try {
            line = br.readLine();
            String[] columns;
            columns = line.split(csvSeparator);
            
            ProduitDAO produitDAO = new ProduitDAO();
            AdditifDAO additifDAO = new AdditifDAO();
            AllergeneDAO allergeneDAO = new AllergeneDAO();            
            CategorieDAO categorieDAO = new CategorieDAO();
            MarqueDAO marqueDAO = new MarqueDAO();
//            FactoryDAO factoryDAO = new FactoryDAO();
            int count = 0;
            
            for (line = br.readLine(); line != null; line = br.readLine()) {
                if(count == 0){
                    count++;
                    continue;
                }
                String[] values = line.split(csvSeparator);
                Produit produit = new Produit();
                
                
                //NutriScore nScore = new NutriScore();
                
                for(int i = 0; i<values.length ;i++){
                    if(values[i].trim().length() == 0){
                        count++;
                        continue;
                    }
                    switch(i){
                        case 0:
                            Categorie categorie = categorieDAO.getByNomCategorie(values[i].trim());
                            
                            if (categorie == null) {
                                categorie = new Categorie();
                                categorie.setNomCate(values[i].trim());
                                categorieDAO.save(categorie);
                            }
                            produit.setCategorie(categorie);
                           break;
                        case 1:
                            Marque marque = new Marque();
                            marque.setMarque(values[i]);
                            marqueDAO.save(marque);
                            break;
                        case 2:
                            produit.setNomProd(values[i]);
                            produitDAO.save(produit);
                            break;
                            
                        case 3:
                            // nutrisionGrade
                            produit.setNutriScore(NutriScore.valueOf(values[i].toUpperCase()));
                            produitDAO.save(produit);
                            break;
                        case 4:
                            // ingrédient
                            values[i] = values[i].replaceAll("\\d+(\\.\\d+)?%", "");
                            values[i] = values[i].replaceAll("\\d+(\\.\\d+)?_", "");
                            produit.setListIngreProd(values[i]);
                            break;
                        case 5:
                            // energie100G
                            produit.setEnergProd(Float.valueOf(values[i]));
                            produitDAO.save(produit);
                            break;
                        case 6:
                            produit.setQuantGraisse(Float.valueOf(values[i]));
                            produitDAO.save(produit);
//                            Graisse100g
                            break;
                        case 7:
//                            Sucre100G
                            produit.setSucres(Float.valueOf(values[i].trim()));
                            produitDAO.save(produit);
                            break;
                        case 8:
                            // fibres
                            try{
                                produit.setFibres(Float.valueOf(values[i].trim()));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                        
                            
                            break;
                        case 9:
//                            proteines
                            produit.setProteines(Float.valueOf(values[i]));
                            produitDAO.save(produit);
                            break;
                        case 10:
//                           sel 
                            produit.setSel(Double.valueOf(values[i]));
                            produitDAO.save(produit);
                            break;
                        case 11:
//                           Vita 
                            try{
                                produit.setVitA(Double.valueOf(values[i]));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                            
                            break;
                        case 12:
//                            vitD
                            try{
                                produit.setVitD(Double.valueOf(values[i]));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                            break;
                        case 13:
                            //vitE
                            try{
                                produit.setVitE(Double.valueOf(values[i]));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                           break;
                        case 14:
                            //vitK
                            try{
                                produit.setVitK(Double.valueOf(values[i]));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                            break;
                        case 15:
                            //vitC
                            try{
                                produit.setVitC(Double.valueOf(values[i]));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                            break;
                            
                        case 16:
//                            vitb1
                            try{
                                produit.setVitB1(Double.valueOf(values[i]));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                            break;
                        case 17:
//                            vitb2
                            try{
                                produit.setVitB2(Double.valueOf(values[i]));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                            break;
                        case 18:
//                           vitPP 
                            try{
                                produit.setVitPP(Double.valueOf(values[i]));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                            break;
                        case 19:
//                           vitb6 
                            try{
                                produit.setVitB6(Double.valueOf(values[i]));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                            break;
                        case 20:
//                           vitb9 
                            try{
                                produit.setVitB9(Double.valueOf(values[i]));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                            break;
                        case 21:
//                           vitb12 
                            try{
                                produit.setVitB12(Double.valueOf(values[i]));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                            break;
                        case 22:
//                           calcium
                            try{
                                produit.setCalcium(Double.valueOf(values[i]));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                            break;
                        case 23:
//                            magnesium
                            try{
                                produit.setMagnesium(Double.valueOf(values[i]));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                            break;
                        case 24:
//                           iron 
                            try{
                                produit.setIron(Double.valueOf(values[i]));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                            break;
                        case 25:
//                           fer 
                            try{
                                produit.setFer(Double.valueOf(values[i]));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                            break;
                        case 26:
//                           betacarotone 
                            try{
                                produit.setBetaCarotene(Double.valueOf(values[i]));
                                produitDAO.save(produit);
                            }catch(NumberFormatException e){
                                continue;
                            }
                            break;
                        case 27:
//                            presencepalme
                            produit.setPresenceHuilePalme(Boolean.valueOf(values[i]));
                            produitDAO.save(produit);
                            break;
                        case 28:
//                            allergene
                            String[] allergeneTab = values[i].trim().split(",");
                            for (String all : allergeneTab) {

                                Allergene allergene = allergeneDAO.getByNomAllergene(all);
                                if (allergene == null) {
                                    allergene = new Allergene();
                                    allergene.setNomAllergene(all);
                                    allergeneDAO.save(allergene);
                                }
                                produit.getAllergenes().add(allergene);
                            }
                            break;
                        case 29:
                            //additif
                            String[] additifTab = values[i].trim().split(",");
                            for (String addit : additifTab) {
                                String code = addit.substring(0,addit.indexOf(" "));
                                String nom = addit.substring(addit.indexOf("-")+ 1).trim();
                                Additif additif = additifDAO.getByNomAdiitif(code);

                                if (additif == null ) {
                                    additif = new Additif();
                                    additif.setNomAdditif(nom);
                                    additif.setCode(code);
                                    additifDAO.save(additif);
                                }

                                produit.getAdditifProd().add(additif);
                            }
                            break;
                        default:
                            
                   }
                   
                   
                }
//                produitDAO.save(produit);
//                allergeneDAO.save(al);
//                additifDAO.save(ad);
                           count++;
                        if (count == 100) {
                        break;
                        }
                
            }
//            int i = 0;

                
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
//    public void addBdd() {
//        try{
//            line = br.readLine();
//            Produit prod = new Produit();
//            for (line = br.readLine(); line != null; line = br.readLine()) {
//                String[] values = line.split(csvSeparator);
//                prod.setNomProd(values[1]);
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
