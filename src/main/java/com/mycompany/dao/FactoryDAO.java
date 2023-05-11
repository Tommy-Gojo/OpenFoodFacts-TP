/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import jakarta.persistence.EntityManager;

/**
 *
 * @author Etudiant
 */
public class FactoryDAO {
    private static FactoryDAO INSTANCE = new FactoryDAO();
    private EntityManager em = JPAUtils.getInstance().getEntityManager();
    
    private FactoryDAO() {}
    
    public static FactoryDAO getInstance() 
    {
        return INSTANCE ;
    }
    
    public ProduitDAO getDAOProduit() 
    {
        return new ProduitDAO();
    }
    
    public CategorieDAO getDAOCategorie() 
    {
        return new CategorieDAO();
    }
    
    public MarqueDAO getDAOMarque() 
    {
        return new MarqueDAO();
    }
    
    
    public AllergeneDAO getDAOAllergene() 
    {
        return new AllergeneDAO();
    }
    public AdditifDAO getDAOAdditif() 
    {
        return new AdditifDAO();
    }
    
    public void close() 
    {
        em.close();
    }

    
}
