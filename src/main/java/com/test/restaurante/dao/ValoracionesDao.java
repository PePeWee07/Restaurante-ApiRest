package com.test.restaurante.dao;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.restaurante.entity.Valoraciones;

@Repository
public interface ValoracionesDao extends JpaRepository<Valoraciones, Long>{

}
