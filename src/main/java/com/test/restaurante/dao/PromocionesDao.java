package com.test.restaurante.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.restaurante.entity.promociones;

@Repository
public interface PromocionesDao extends JpaRepository<promociones, Long>{

}
