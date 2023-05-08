package com.test.restaurante.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingredientes")
public class Ingredientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ingrediente")
	private Long id_ingrediente;
	
	@ManyToOne
    @JoinColumn(name = "id_proveedor")
	private Proveedores proveedores;
	
	@Column(name = "nombre_ingrediente", length = 30)
	private String nombre_ingrediente;
	
	@Column(name = "cantidad_disponible", length = 30)
	private int cantidad_disponible;
	
	@Column(name = "fecha_caducidad")
	private Date fecha_caducidad;
	
	// Constructores, getters y setters

	public Long getId_ingrediente() {
		return id_ingrediente;
	}

	public void setId_ingrediente(Long id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}

	public Proveedores getProveedores() {
		return proveedores;
	}

	public void setProveedores(Proveedores proveedores) {
		this.proveedores = proveedores;
	}

	public String getNombre_ingrediente() {
		return nombre_ingrediente;
	}

	public void setNombre_ingrediente(String nombre_ingrediente) {
		this.nombre_ingrediente = nombre_ingrediente;
	}

	public int getCantidad_disponible() {
		return cantidad_disponible;
	}

	public void setCantidad_disponible(int cantidad_disponible) {
		this.cantidad_disponible = cantidad_disponible;
	}

	public Date getFecha_caducidad() {
		return fecha_caducidad;
	}

	public void setFecha_caducidad(Date fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}
	
	
	
	
	 

}
