/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import java.util.List;

/**
 *
 * @author Tommy
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Categorie.findProduitByCate" , query = "SELECT c FROM Categorie c WHERE c.nomCate = :nomCate"),
    @NamedQuery(name = "Categorie.findAllCate" , query = "SELECT c FROM Categorie c"),
})
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomCate;
    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits;
    
//    public Categorie(Integer id, String nomCate) {
//        this.id = id;
//        this.nomCate = nomCate;
//    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomCate() {
        return nomCate;
    }

    public void setNomCate(String nomCate) {
        this.nomCate = nomCate;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", nomCate=" + nomCate + ", produits=" + produits + '}';
    }

    
    
}
