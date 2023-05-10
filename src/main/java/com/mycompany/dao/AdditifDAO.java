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
import com.mycompany.models.Additif;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.TypedQuery;
public class AdditifDAO {
        EntityManager em = JPAUtils.getInstance().getEntityManager();


    public List<Additif> getAll(){
        List<Additif> additifs = em.createNamedQuery("Additif.findAll", Additif.class).getResultList();
     
        return additifs;
    }
    
    public Additif getByNomAdiitif(String nomAdditif){
        TypedQuery<Additif> nameAdditifQuery = em.createNamedQuery("Additif.findByName" , Additif.class);
        nameAdditifQuery.setParameter("nomAdditif", nomAdditif);
        List<Additif> nomAdditifs = nameAdditifQuery.getResultList();
        if (!nomAdditifs.isEmpty()) {
            return nomAdditifs.get(0);
        }
        return null;
    }
    
    public Additif getById(int id){
        return null;
    }

    public void save(Additif additifs){
        em.getTransaction().begin();
        em.persist(additifs);
        em.getTransaction().commit();
    }

    public void update(Additif additifs){
        
    }

    public void delete(int id){
        
    }
}
