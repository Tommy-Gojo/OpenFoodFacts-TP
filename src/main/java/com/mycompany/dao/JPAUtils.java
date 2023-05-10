/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

/**
 *
 * @author Tommy
 */
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtils {
   private final static JPAUtils INSTANCE = new JPAUtils();
   private JPAUtils(){}
   public static JPAUtils getInstance(){
    return INSTANCE;
    }
   
   //JPA
   
   private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory( "OpenFoodFact");
   private final static EntityManager EM = EMF.createEntityManager();
   
   public EntityManager getEntityManager(){
       return EM;
   }
}
