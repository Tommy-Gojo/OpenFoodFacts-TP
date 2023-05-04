/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Tommy
 */
@Entity
@NamedQueries({
    /**
    *
    * Je selectionne : Tout les elements dans Produit 
    * et la requete se fera quand j'appelerai ce qu'il y a dans le name.
    */
    @NamedQuery(name = "Produit.findAll" , query = "SELECT p FROM Produit p"),
    /**
    *
    * Je selectionne : Tout les elements dans Produit au index ci --------------------|
    * et la requete se fera quand j'appelerai ce qu'il y a dans le name.              |
    *                                                                                 v
    */
    @NamedQuery(name = "Produit.findProduitById" , query = "SELECT p FROM Produit p WHERE p.id = :id"),
    /**
    *
    * Je selectionne : Tout les elements dans Produit au index ci -------------------------------|
    * et la requete se fera quand j'appelerai ce qu'il y a dans le name.                         v
    */
    @NamedQuery(name = "Produit.findProduitByMarque" , query = "SELECT p FROM Produit p WHERE p.nomProd = :marque"),
    @NamedQuery(name = "Produit.findProduitByMarqueAndCategorie" , query = "SELECT p FROM Produit p WHERE p.Marque = :marque"),
    /**
    *
    * Je selectionne : Tout les elements dans Produit au index ci -------------------------------|
    * et la requete se fera quand j'appelerai ce qu'il y a dans le name.                         v
    */
    @NamedQuery(name = "Produit.findProduitByIngre" , query = "SELECT p FROM Produit p WHERE p.listIngréProd = :listIngréProd"),
    @NamedQuery(name = "Produit.findProduitByAllergene" , query = "SELECT p FROM Produit p WHERE p.AllergeneProd = :AllergeneProd"),
    @NamedQuery(name = "Produit.findProduitByAllergene" , query = "SELECT p FROM Produit p WHERE p.additifProd = :additifProd"),
    
})
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomProd;
    private String infoProd;
    private String listIngréProd;
    private String energProd;
    private Integer quantGraisse;
    private String AllergeneProd;
    private String additifProd;
    private Categorie categorie;
    private NutriScore nutriScore;
    private Marque marque;

    public Produit(Integer id, String nomProd, String infoProd, String listIngréProd, String energProd, Integer quantGraisse, String AllergeneProd, String additifProd, Categorie categorie, NutriScore nutriScore, Marque marque) {
        this.id = id;
        this.nomProd = nomProd;
        this.infoProd = infoProd;
        this.listIngréProd = listIngréProd;
        this.energProd = energProd;
        this.quantGraisse = quantGraisse;
        this.AllergeneProd = AllergeneProd;
        this.additifProd = additifProd;
        this.categorie = categorie;
        this.nutriScore = nutriScore;
        this.marque = marque;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public String getInfoProd() {
        return infoProd;
    }

    public void setInfoProd(String infoProd) {
        this.infoProd = infoProd;
    }

    public String getListIngréProd() {
        return listIngréProd;
    }

    public void setListIngréProd(String listIngréProd) {
        this.listIngréProd = listIngréProd;
    }

    public String getEnergProd() {
        return energProd;
    }

    public void setEnergProd(String energProd) {
        this.energProd = energProd;
    }

    public Integer getQuantGraisse() {
        return quantGraisse;
    }

    public void setQuantGraisse(Integer quantGraisse) {
        this.quantGraisse = quantGraisse;
    }

    public String getAllergeneProd() {
        return AllergeneProd;
    }

    public void setAllergeneProd(String AllergeneProd) {
        this.AllergeneProd = AllergeneProd;
    }

    public String getAdditifProd() {
        return additifProd;
    }

    public void setAdditifProd(String additifProd) {
        this.additifProd = additifProd;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public NutriScore getNutriScore() {
        return nutriScore;
    }

    public void setNutriScore(NutriScore nutriScore) {
        this.nutriScore = nutriScore;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nomProd=" + nomProd + ", infoProd=" + infoProd + ", listIngr\u00e9Prod=" + listIngréProd + ", energProd=" + energProd + ", quantGraisse=" + quantGraisse + ", AllergeneProd=" + AllergeneProd + ", additifProd=" + additifProd + ", categorie=" + categorie + ", nutriScore=" + nutriScore + ", marque=" + marque + '}';
    }

}
