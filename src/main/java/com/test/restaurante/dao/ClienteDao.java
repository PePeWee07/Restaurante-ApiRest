package com.test.restaurante.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.restaurante.entity.Cliente;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long>{

}
