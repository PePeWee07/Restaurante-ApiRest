package com.test.restaurante.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_menu")
	private Long id_menu;
	
	@Column(name = "nombre_plato", length = 30)
	private String nombre_plato;
	
	
	@Column(name = "descripcion", length = 30)
	private String descripcion;
	
	
	@Column(name = "precio")
	private BigDecimal precio;
	
	
	@Column(name = "categoria", length = 30)
	private String categoria;
	
	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Valoraciones> valoraciones;
	
	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Orden> ordenes;

	public Long getId_menu() {
		return id_menu;
	}

	public void setId_menu(Long id_menu) {
		this.id_menu = id_menu;
	}

	public String getNombre_plato() {
		return nombre_plato;
	}

	public void setNombre_plato(String nombre_plato) {
		this.nombre_plato = nombre_plato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
