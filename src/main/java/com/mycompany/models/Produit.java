/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import java.util.ArrayList;
import java.util.List;

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
  
    
    /**
    *
    * Je selectionne : Tout les elements dans Produit au index ci -------------------------------|
    * et la requete se fera quand j'appelerai ce qu'il y a dans le name.                         v
    */
    @NamedQuery(name = "Produit.findProduitByIngre" , query = "SELECT p FROM Produit p WHERE p.listIngréProd = :listIngréProd"),
    
    
})
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nomProd;
    private String infoProd;
    private String listIngréProd;
    private int energProd;
    private Float quantGraisse;
    
    // #####################
    // Debut des relations #
    // #####################
    
    @ManyToMany
    private List<Allergene> allergenes = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(
        name = "produit_additif",
        joinColumns = @JoinColumn(name = "produit_id"),
        inverseJoinColumns = @JoinColumn(name = "additif_id")
    )
    private List<Additif> additifProd = new ArrayList<>();
    
    
    @ManyToOne
    private Categorie categorie;
    
    
    @Enumerated(EnumType.STRING)
    private NutriScore nutriScore;
    
    @ManyToMany
    private List<Marque> marque;

    

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

    public int getEnergProd() {
        return energProd;
    }

    public void setEnergProd(int energProd) {
        this.energProd = energProd;
    }

    public Float getQuantGraisse() {
        return quantGraisse;
    }

    public void setQuantGraisse(Float quantGraisse) {
        this.quantGraisse = quantGraisse;
    }

    public List<Allergene> getAllergenes() {
        return allergenes;
    }

    public void setAllergenes(List<Allergene> allergenes) {
        this.allergenes = allergenes;
    }

    

    public List<Additif> getAdditifProd() {
        return additifProd;
    }

    public void setAdditifProd(List<Additif> additifProd) {
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

    public List<Marque> getMarque() {
        return marque;
    }

    public void setMarque(List<Marque> marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nomProd=" + nomProd + ", infoProd=" + infoProd + ", listIngr\u00e9Prod=" + listIngréProd + ", energProd=" + energProd + ", quantGraisse=" + quantGraisse + ", allergenes=" + allergenes + ", additifProd=" + additifProd + ", categorie=" + categorie + ", nutriScore=" + nutriScore + ", marque=" + marque + '}';
    }

    

    

    

    

}
