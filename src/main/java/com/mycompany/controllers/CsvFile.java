/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.dao.AdditifDAO;
import com.mycompany.dao.AllergeneDAO;
import com.mycompany.dao.CategorieDAO;
import com.mycompany.dao.MarqueDAO;
import com.mycompany.dao.ProduitDAO;
import com.mycompany.models.Additif;
import com.mycompany.models.Produit;
import com.mycompany.models.Allergene;
import com.mycompany.models.Categorie;
import com.mycompany.models.NutriScore;
import com.mycompany.models.Marque;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tommy
 */
public class CsvFile {
    private static CsvFile instance;

    private String csvFile = "C:\\Users\\Tommy\\OneDrive - RDK Solutions\\open-food-facts.csv";
    private String line;
    private String csvSeparator = "\\|";
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
            
            
            for (line = br.readLine(); line != null; line = br.readLine()) {
                String[] values = line.split(csvSeparator);
                Produit produit = new Produit();
                Additif ad = new Additif();
                Allergene al = new Allergene();
                Categorie cat = new Categorie();
                //NutriScore nScore = new NutriScore();
                Marque marque = new Marque();
                
                for(int i = 0; i<values.length ;i++){
                   switch(i){
                        case 0:
                           produit.setNomProd(values[i]);
                           break;
                        case 1:
                            produit.setInfoProd(values[i]);
                            break;
                        case 2:
                            produit.setListIngréProd(values[i]);
                            break;
                            
                        case 3:
                            try{
                                produit.setEnergProd(Integer.parseInt(values[i]));
                            }catch(NumberFormatException e){
                                continue;
                            }
                            break;
                        case 4:
                            try{
                                produit.setQuantGraisse(Float.valueOf(values[i]));
                            }catch(NumberFormatException e){
                                continue;
                            } 
                            break;
                        case 5:
                            ad.setNomAdditif(values[i]);
                            break;
                        case 6:
                            al.setNomAllergene(values[i]);
                            //al.setProduits(produit);
                            break;
                        case 7:
                            cat.setNomCate(values[i]);
                            //cat.setProduits(produit);
                            break;
                        case 8:
                            break;
                        case 9:
                            marque.setMarque(values[i]);
                            break;
                        default:
                            
                   }
                   
                   
                }
                produitDAO.save(produit);
                allergeneDAO.save(al);
                additifDAO.save(ad);
                categorieDAO.save(cat);
                marqueDAO.save(marque);
            }
//            int i = 0;
//            for (line = br.readLine(); line != null; line = br.readLine()) {
//                if (i > 99) {
//                    break;
//                }
//                String[] values = line.split(csvSeparator);
//            }
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
