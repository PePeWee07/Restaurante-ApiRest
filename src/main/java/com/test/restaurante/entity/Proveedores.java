package com.test.restaurante.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
@Table(name = "proveedores")
public class Proveedores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
	private Long id_proveedor;
	
	@Column(name = "nombre_proveedor", length = 30)
	private String nombre_proveedor;
	
	@Column(name = "direccion", length = 30)
	private String direccion;
	
	@Column(name = "telefono")
	private int telefono;
	
	@Column(name = "correo_electronico", length = 30)
	private String correo_electronico;
	
	@Column(name = "productos", length = 100)
	private String productos;
	
	@OneToMany(mappedBy = "proveedores", cascade = CascadeType.ALL)
    private List<Ingredientes> ingredientes;
	
	// Constructores, getters y setters

	public Long getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(Long id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getProductos() {
		return productos;
	}

	public void setProductos(String productos) {
		this.productos = productos;
	}
	
	
	
	
}
