/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

/**
 *
 * @author Tommy
 */
import java.util.ArrayList;
import java.util.List;
import com.mycompany.models.Produit;
import jakarta.persistence.EntityManager;
import com.mycompany.dao.JPAUtils;
import com.mycompany.models.Categorie;
public class CategorieDAO {
        EntityManager em = JPAUtils.getInstance().getEntityManager();


    public List<Categorie> getAll(){
        List<Categorie> categories = em.createNamedQuery("Categorie.findAllCate", Categorie.class).getResultList();
     
        return categories;
    }
    
    public Produit getById(int id){
        return null;
    }

    public void save(Categorie categories){
        em.getTransaction().begin();
        em.persist(categories);
        em.getTransaction().commit();
    }

    public void update(Produit produit){
        
    }

    public void delete(int id){
        
    }
}
