package com.test.restaurante.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "promociones")
public class promociones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_promocion")
	private Long id_promocion;
	
	@Column(name = "descripcion", length = 30)
	private String descripcion;
	
	@Column(name = "porcentaje_descuento", length = 30)
	private String porcentaje_descuento;
	
	@Column(name = "fecha_inicio")
	private Date fecha_inicio;
	
	@Column(name = "fecha_fin")
	private Date fecha_fin;
	
	// Constructores, getters y setters
	

	public Long getId_promocion() {
		return id_promocion;
	}


	public void setId_promocion(Long id_promocion) {
		this.id_promocion = id_promocion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPorcentaje_descuento() {
		return porcentaje_descuento;
	}

	public void setPorcentaje_descuento(String porcentaje_descuento) {
		this.porcentaje_descuento = porcentaje_descuento;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	
	
	

}
