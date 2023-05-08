package com.test.restaurante.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.restaurante.entity.Reservas;

@Repository
public interface ReservasDao extends JpaRepository<Reservas, Long>{

}
