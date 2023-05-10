/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

/**
 *
 * @author Tommy
 */
import java.util.List;
import com.mycompany.models.Produit;
import jakarta.persistence.EntityManager;
public class ProduitDAO {
    
    EntityManager em = JPAUtils.getInstance().getEntityManager();

    public List<Produit> getAll(){

        List<Produit> produits =  em.createNamedQuery("Produit.findAll", Produit.class).getResultList();
     
        return produits;
        
    }

    public Produit getById(int id){
        return null;
    }

    public void save(Produit produits) {
       em.getTransaction().begin();
       em.persist(produits);
       em.getTransaction().commit();
    }

    public void update(Produit produit){
        
    }

    public void delete(int id) {
        
    }
}
