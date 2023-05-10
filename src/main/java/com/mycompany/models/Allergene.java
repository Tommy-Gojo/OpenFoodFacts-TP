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
@NamedQueries({
    @NamedQuery(name = "Allergene.findAll", query = "SELECT al FROM Allergene al"),
    @NamedQuery(name = "Allergene.findByName", query = "SELECT al FROM Allergene al WHERE al.nomAllergene = :nomAllergene")
})
public class Allergene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomAllergene;
    
    /**
     * Relation ManyToMany entre la table allergene et produit
     */
    @ManyToMany(mappedBy = "allergenes")
    private List<Produit> produits = new ArrayList<>();

//    public Allergene(int id, String nomAllergene, List<Produit> produits) {
//        this.id = id;
//        this.nomAllergene = nomAllergene;
//        this.produits = produits;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomAllergene() {
        return nomAllergene;
    }

    public void setNomAllergene(String nomAllergene) {
        this.nomAllergene = nomAllergene;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
    
}
