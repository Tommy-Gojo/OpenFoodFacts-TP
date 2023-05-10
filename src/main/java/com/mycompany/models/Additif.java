/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tommy
 */
@Entity
// TODO Faire les NamedQueries and NamedQuery
@NamedQueries({
    @NamedQuery(name = "Additif.findAll", query = "SELECT ad FROM Additif ad"),
    @NamedQuery(name = "Additif.findByName", query = "SELECT ad FROM Additif ad WHERE ad.nomAdditif = :nomAdditif")
})
public class Additif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomAdditif;
    
    /*
     *  Relation ManyToMany entre additif et produits
     */
    
    @ManyToMany(mappedBy = "additifProd")
    private List<Produit> produits = new ArrayList<>();

//    public Additif(int id, String nomAdditif, List<Produit> produits) {
//        this.id = id;
//        this.nomAdditif = nomAdditif;
//        this.produits = produits;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomAdditif() {
        return nomAdditif;
    }

    public void setNomAdditif(String nomAdditif) {
        this.nomAdditif = nomAdditif;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
    
}