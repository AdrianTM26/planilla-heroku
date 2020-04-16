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
@Table(name = "trabajador_remuneracion")
public class TrabRemuneracion {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idTrabaRemu;
	
	@NotNull(message="El estado de la remuneracion del Trabajador no puede estar vacio")
	@Column(nullable=false)
	private Integer estado;
	
	@ManyToOne
	@JoinColumn(name = "id_trabajador", nullable = false)
	private Trabajador trabajador;
	
	@ManyToOne
	@JoinColumn(name = "id_remuneracion",nullable = false)
	private Remuneraciones remuneraciones;

	public Integer getIdTrabaRemu() {
		return idTrabaRemu;
	}

	public void setIdTrabaRemu(Integer idTrabaRemu) {
		this.idTrabaRemu = idTrabaRemu;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public Remuneraciones getRemuneraciones() {
		return remuneraciones;
	}

	public void setRemuneraciones(Remuneraciones remuneraciones) {
		this.remuneraciones = remuneraciones;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
