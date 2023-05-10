/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dao;

import java.util.List;

/**
 *
 * @author Tommy
 */
public interface IDAO<T> {
    
  public void create(T obj) throws Exception;
  public void delete(T obj);
  public void delete();
  public void update(T obj);
  public T find(int id);
  public List<T> findAll();
}

