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
@Table(name = "valoraciones")
public class Valoraciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_valoracion")
	private Long id_valoracion;
	
	@Column(name = "fecha_valoracion", length = 30)
	private Date fecha_valoracion;
	
	@Column(name = "hora_valoracion", length = 30)
	private String hora_valoracion;
	
	@Column(name = "comentario", length = 30)
	private String comentario;
	
	@ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu menu;

	public Long getId_valoracion() {
		return id_valoracion;
	}

	public void setId_valoracion(Long id_valoracion) {
		this.id_valoracion = id_valoracion;
	}

	public Date getFecha_valoracion() {
		return fecha_valoracion;
	}

	public void setFecha_valoracion(Date fecha_valoracion) {
		this.fecha_valoracion = fecha_valoracion;
	}

	public String getHora_valoracion() {
		return hora_valoracion;
	}

	public void setHora_valoracion(String hora_valoracion) {
		this.hora_valoracion = hora_valoracion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
    
    


}
