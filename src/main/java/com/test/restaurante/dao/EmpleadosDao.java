package com.test.restaurante.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.restaurante.entity.Empleados;

@Repository
public interface EmpleadosDao extends JpaRepository<Empleados, Long>{

}
