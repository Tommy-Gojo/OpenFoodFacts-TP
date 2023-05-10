/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.models;

import jakarta.persistence.ManyToMany;
import java.util.List;

/**
 *
 * @author Tommy
 */
public enum NutriScore {
    A(1, "A"),
    B(2, "B"),
    C(3, "C"),
    D(4, "D"),
    E(5, "E");

    private int id;
    private String nutriScore;
    

    private NutriScore(int id, String nutriScore) {
        this.id = id;
        this.nutriScore = nutriScore;
        
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNutriScore() {
        return nutriScore;
    }

    public void setNutriScore(String nutriScore) {
        this.nutriScore = nutriScore;
    }

    
}
