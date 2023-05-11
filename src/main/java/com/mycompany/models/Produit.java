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
    @NamedQuery(name = "Produit.findProduitByIngre" , query = "SELECT p FROM Produit p WHERE p.listIngreProd = :listIngreProd"),
    
    
})
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nomProd;
    @Column(length = 1024)
    private String listIngreProd;
    private Float energProd;
    private Float quantGraisse;
    private Float sucres;
    private Float fibres;
    private Float proteines;
    private Double sel;
    private Double calcium;
    private Double magnesium;
    private Double iron;
    private Double vitA;
    private Double vitD;
    private Double vitE;
    private Double vitC;
    private Double vitK;
    private Double vitB1;
    private Double vitB2;
    private Double vitPP;
    private Double vitB6;
    private Double vitB9;
    private Double vitB12;
    private Double fer;
    private Double betaCarotene;
    private Boolean presenceHuilePalme;
    
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

    public String getListIngreProd() {
        return listIngreProd;
    }

    public void setListIngreProd(String listIngreProd) {
        this.listIngreProd = listIngreProd;
    }

    public Float getEnergProd() {
        return energProd;
    }

    public void setEnergProd(Float energProd) {
        this.energProd = energProd;
    }

    public Float getQuantGraisse() {
        return quantGraisse;
    }

    public void setQuantGraisse(Float quantGraisse) {
        this.quantGraisse = quantGraisse;
    }

    public Float getSucres() {
        return sucres;
    }

    public void setSucres(Float sucres) {
        this.sucres = sucres;
    }

    public Float getFibres() {
        return fibres;
    }

    public void setFibres(Float fibres) {
        this.fibres = fibres;
    }

    public Float getProteines() {
        return proteines;
    }

    public void setProteines(Float proteines) {
        this.proteines = proteines;
    }

    public Double getSel() {
        return sel;
    }

    public void setSel(Double sel) {
        this.sel = sel;
    }

    public Double getCalcium() {
        return calcium;
    }

    public void setCalcium(Double calcium) {
        this.calcium = calcium;
    }

    public Double getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(Double magnesium) {
        this.magnesium = magnesium;
    }

    public Double getIron() {
        return iron;
    }

    public void setIron(Double iron) {
        this.iron = iron;
    }

    public Double getVitA() {
        return vitA;
    }

    public void setVitA(Double vitA) {
        this.vitA = vitA;
    }

    public Double getVitD() {
        return vitD;
    }

    public void setVitD(Double vitD) {
        this.vitD = vitD;
    }

    public Double getVitE() {
        return vitE;
    }

    public void setVitE(Double vitE) {
        this.vitE = vitE;
    }

    public Double getVitC() {
        return vitC;
    }

    public void setVitC(Double vitC) {
        this.vitC = vitC;
    }

    public Double getVitK() {
        return vitK;
    }

    public void setVitK(Double vitK) {
        this.vitK = vitK;
    }

    public Double getVitB1() {
        return vitB1;
    }

    public void setVitB1(Double vitB1) {
        this.vitB1 = vitB1;
    }

    public Double getVitB2() {
        return vitB2;
    }

    public void setVitB2(Double vitB2) {
        this.vitB2 = vitB2;
    }

    public Double getVitPP() {
        return vitPP;
    }

    public void setVitPP(Double vitPP) {
        this.vitPP = vitPP;
    }

    public Double getVitB6() {
        return vitB6;
    }

    public void setVitB6(Double vitB6) {
        this.vitB6 = vitB6;
    }

    public Double getVitB9() {
        return vitB9;
    }

    public void setVitB9(Double vitB9) {
        this.vitB9 = vitB9;
    }

    public Double getVitB12() {
        return vitB12;
    }

    public void setVitB12(Double vitB12) {
        this.vitB12 = vitB12;
    }

    public Double getFer() {
        return fer;
    }

    public void setFer(Double fer) {
        this.fer = fer;
    }

    public Double getBetaCarotene() {
        return betaCarotene;
    }

    public void setBetaCarotene(Double betaCarotene) {
        this.betaCarotene = betaCarotene;
    }

    public Boolean getPresenceHuilePalme() {
        return presenceHuilePalme;
    }

    public void setPresenceHuilePalme(Boolean presenceHuilePalme) {
        this.presenceHuilePalme = presenceHuilePalme;
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
        return "Produit{" + "id=" + id + ", nomProd=" + nomProd + ", listIngr\u00e9Prod=" + listIngreProd + ", energProd=" + energProd + ", quantGraisse=" + quantGraisse + ", sucres=" + sucres + ", fibres=" + fibres + ", proteines=" + proteines + ", sel=" + sel + ", calcium=" + calcium + ", magnesium=" + magnesium + ", iron=" + iron + ", vitA=" + vitA + ", vitD=" + vitD + ", vitE=" + vitE + ", vitC=" + vitC + ", vitK=" + vitK + ", vitB1=" + vitB1 + ", vitB2=" + vitB2 + ", vitPP=" + vitPP + ", vitB6=" + vitB6 + ", vitB9=" + vitB9 + ", vitB12=" + vitB12 + ", fer=" + fer + ", betaCarotene=" + betaCarotene + ", presenceHuilePalme=" + presenceHuilePalme + ", allergenes=" + allergenes + ", additifProd=" + additifProd + ", categorie=" + categorie + ", nutriScore=" + nutriScore + ", marque=" + marque + '}';
    }

    
    
    

    
    
    

    

    

}
