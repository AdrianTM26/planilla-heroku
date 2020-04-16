package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trabajador_descuento")
public class TrabDescuento {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idTrabDsct;
	
	@NotNull(message="El estado del descuento del trabajador no puede estar vacio")
	@Column(nullable=false)
	private Integer estado;
	
	@ManyToOne
	@JoinColumn(name = "id_trabajador", nullable = false)
	private Trabajador trabajador;
	
	@ManyToOne
	@JoinColumn(name = "id_descuento", nullable = false)
	private Descuentos descuentos;

	public Integer getIdTrabDsct() {
		return idTrabDsct;
	}

	public void setIdTrabDsct(Integer idTrabDsct) {
		this.idTrabDsct = idTrabDsct;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public Descuentos getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(Descuentos descuentos) {
		this.descuentos = descuentos;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
}
