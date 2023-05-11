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
import com.mycompany.models.Allergene;
import jakarta.persistence.TypedQuery;
public class AllergeneDAO {
        EntityManager em = JPAUtils.getInstance().getEntityManager();


    public List<Allergene> getAll(){
        List<Allergene> allergenes = em.createNamedQuery("Allergene.findAll", Allergene.class).getResultList();
     
        return allergenes;
    }
    
    public Allergene getByNomAllergene(String nomAllergene){
        TypedQuery<Allergene> nameAllergeneQuery = em.createNamedQuery("Allergene.findByName" , Allergene.class);
        nameAllergeneQuery.setParameter("nomAllergene", nomAllergene);
        List<Allergene> nomAllergenes = nameAllergeneQuery.getResultList();
        if (!nomAllergenes.isEmpty()) {
            return nomAllergenes.get(0);
        }
        return null;
    }
    
    
    public Allergene getById(int id){
        return null;
    }

    public void save(Allergene allergenes){
        em.getTransaction().begin();
        em.persist(allergenes);
        em.getTransaction().commit();
    }

    public void update(Allergene allergenes){
        
    }

    public void delete(int id){
        
    }
}
