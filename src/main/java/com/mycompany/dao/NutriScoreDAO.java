/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

/**
 *
 * @author Tommy
 */
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import com.mycompany.models.Produit;
//public class ProduitDAO {
//    private Connection connection;
//
//    public ProduitDAO(Connection connection) {
//        this.connection = connection;
//    }
//
//    public List<ProduitDAO> getAll() throws SQLException {
//        List<ProduitDAO> produits = new ArrayList<>();
//        try (Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery("SELECT * FROM Produit")) {
//            while (resultSet.next()) {
//                Integer id = resultSet.getInt("id");
//                String nameProd = resultSet.getString("nameProd");
//                String infoProd = resultSet.getString("infoProd");
//                String listIngreProd = resultSet.getString("listIngreProd");
//                String energProd = resultSet.getString("energProd");
//                String quantGraisse = resultSet.getString("quantGraisse");
//                String allergeneProd = resultSet.getString("allergeneProd");
//                String additifProd = resultSet.getString("additifProd");
//                Categorie categorie = resultSet.getObject("categorie",Categorie<t> categorie);
//                NutriScore nutriScore = resultSet.getNutriScore("nutriScore");
//                List<Marque> marque = resultSet.getMarque("marque");
//                Produit produit = new Produit(id, nameProd, infoProd, listIngreProd, energProd, quantGraisse, allergeneProd, additifProd, categorie, nutriScore, marque);
//                produits.add(produit);
//            }
//        }
//        return produits;
//    }
//
//    public Produit getById(int id) throws SQLException {
//        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Produit WHERE id = ?")) {
//            statement.setInt(1, id);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    String nameProd = resultSet.getString("nameProd");
//                    String infoProd = resultSet.getString("infoProd");
//                    String listIngreProd = resultSet.getString("listIngreProd");
//                    String energProd = resultSet.getString("energProd");
//                    String quantGraisse = resultSet.getString("quantGraisse");
//                    String allergeneProd = resultSet.getString("allergeneProd");
//                    String additifProd = resultSet.getString("additifProd");
//                    Categorie categorie = resultSet.getString("categorie_id");
//                    NutriScore nutriScore = resultSet.getNutriScore("nutriScore");
//                    List<Marque> marque = resultSet.getMarque("marque");
//                    return new Produit(id, infoProd, infoProd, listIngreProd, energProd, quantGraisse, allergeneProd, additifProd, categorie, nutriScore, marque);
//                } else {
//                    return null;
//                }
//            }
//        }
//    }
//
//    public void save(Produit produit) throws SQLException {
//        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Produit (id, name, infoProd, listIngreProd, energProd, quantGraisse, allergeneProd, additifProd, categorie_id, nutriScore, marque) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
//            statement.setInt(1, produit.getId());
//            statement.setString(2, produit.getNomProd());
//            statement.setString(3, produit.getInfoProd());
//            statement.setString(4, produit.getListIngréProd());
//            statement.setString(5, produit.getEnergProd());
//            statement.setString(6, produit.getQuantGraisse());
//            statement.setString(7, produit.getAllergeneProd());
//            statement.setString(8, produit.getAdditifProd());
//            statement.setString(9, produit.getCategorie());
//            statement.setString(10, produit.getNutriScore());
//            statement.setString(11, produit.getMarque());
//            statement.executeUpdate();
//        }
//    }
//
//    public void update(Produit produit) throws SQLException {
//        try (PreparedStatement statement = connection.prepareStatement("UPDATE Produit SET nomProd = ?, infoProd = ?, listIngréProd = ?, energProd = ?, quantGraisse = ?, allergeneProd = ?, additifProd = ?, categorie = ?, nutriScore = ?, marque = ? WHERE id = ?")) {
//            statement.setInt(1, produit.getId());
//            statement.setString(2, produit.getNomProd());
//            statement.setString(3, produit.getInfoProd());
//            statement.setString(4, produit.getListIngréProd());
//            statement.setString(5, produit.getEnergProd());
//            statement.setString(6, produit.getQuantGraisse());
//            statement.setString(7, produit.getAllergeneProd());
//            statement.setString(8, produit.getAdditifProd());
//            statement.setString(9, produit.getCategorie());
//            statement.setString(10, produit.getNutriScore());
//            statement.setString(11, produit.getMarque());
//            statement.executeUpdate();
//        }
//    }
//
//    public void delete(int id) throws SQLException {
//        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM Produit WHERE id = ?")) {
//            statement.setInt(1, id);
//            statement.executeUpdate();
//        }
//    }
//}
