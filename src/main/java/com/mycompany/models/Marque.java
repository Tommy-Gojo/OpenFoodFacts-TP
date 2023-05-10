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
import java.util.List;

/**
 *
 * @author Tommy
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Marque.findAll", query = "SELECT m FROM Marque m")
})
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Marque;
    @ManyToMany(mappedBy = "marque")
    private List<Produit> produit;

//    public Marque(Integer id, String Marque, List<Produit> produit) {
//        this.id = id;
//        this.Marque = Marque;
//        this.produit = produit;
//    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String Marque) {
        this.Marque = Marque;
    }

    public List<Produit> getProduit() {
        return produit;
    }

    public void setProduit(List<Produit> produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Marque{" + "id=" + id + ", Marque=" + Marque + ", produit=" + produit + '}';
    }

    

    
    
    
    
    
}
