package com.test.restaurante.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.restaurante.entity.Ingredientes;

@Repository
public interface IngredientesDao extends JpaRepository<Ingredientes, Long>{

}
