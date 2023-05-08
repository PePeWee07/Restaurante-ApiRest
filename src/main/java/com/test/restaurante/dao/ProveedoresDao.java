package com.test.restaurante.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.restaurante.entity.Proveedores;

@Repository
public interface ProveedoresDao extends JpaRepository<Proveedores, Long> {

}
