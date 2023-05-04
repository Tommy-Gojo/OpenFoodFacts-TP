/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Tommy
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Produit.findProduitByCate" , query = "SELECT c FROM Categorie c WHERE c.nomCate = :nomCate"),
})
public class Categorie {
    @Id
    private Integer id;
    private String nomCate;

    public Categorie(Integer id, String nomCate) {
        this.id = id;
        this.nomCate = nomCate;
    }
    
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

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", nomCate=" + nomCate + '}';
    }
    
}
