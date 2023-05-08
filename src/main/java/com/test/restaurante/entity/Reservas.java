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
@Table(name = "reservas")
public class Reservas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva")
	private Long id_reserva;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@Column(name = "num_mesa")
	private int num_mesa;
	
	@Column(name = "fecha_reserva")
	private Date fecha_reserva;
	
	@Column(name = "hora_reserva", length = 30)
	private String hora_reserva;
	
	@Column(name = "telefono_cliente")
	private int telefono_cliente;

	public Long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Long id_reserva) {
		this.id_reserva = id_reserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNum_mesa() {
		return num_mesa;
	}

	public void setNum_mesa(int num_mesa) {
		this.num_mesa = num_mesa;
	}

	public Date getFecha_reserva() {
		return fecha_reserva;
	}

	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}

	public String getHora_reserva() {
		return hora_reserva;
	}

	public void setHora_reserva(String hora_reserva) {
		this.hora_reserva = hora_reserva;
	}

	public int getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(int telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}
	
	

}
