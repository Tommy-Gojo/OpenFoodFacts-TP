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
import jakarta.persistence.EntityManager;
import com.mycompany.models.Marque;
public class MarqueDAO {
        EntityManager em = JPAUtils.getInstance().getEntityManager();


    public List<Marque> getAll(){
        List<Marque> marques = em.createNamedQuery("Marque.findAll", Marque.class).getResultList();
     
        return marques;
    }

    public Marque getById(int id){
        return null;
    }

    public void save(Marque marques){
        em.getTransaction().begin();
        em.persist(marques);
        em.getTransaction().commit();
    }

    public void update(Marque marques){
        
    }

    public void delete(int id){
        
    }
}
