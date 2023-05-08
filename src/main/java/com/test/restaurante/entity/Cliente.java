package com.test.restaurante.entity;

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
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id_cliente;
	
	@Column(name = "nombre_cliente", length = 30)
	private String nombre_cliente;
	
	@Column(name = "correo_electronico", length = 30)
	private String correo_electronico;
	
	@Column(name = "contrasena", length = 30)
	private String contrasena;
	
	@Column(name = "telefono")
	private int telefono;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Reservas> reservas;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Facturas> facturas;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Valoraciones> valoraciones;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Orden> ordenes;

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	
	

}
