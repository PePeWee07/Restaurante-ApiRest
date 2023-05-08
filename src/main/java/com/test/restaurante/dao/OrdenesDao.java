package com.test.restaurante.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.restaurante.entity.Orden;

@Repository
public interface OrdenesDao extends JpaRepository<Orden, Long>{

}
