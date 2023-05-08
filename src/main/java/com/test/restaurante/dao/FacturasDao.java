package com.test.restaurante.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.restaurante.entity.Facturas;

@Repository
public interface FacturasDao extends JpaRepository<Facturas, Long>{

}
