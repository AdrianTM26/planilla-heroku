package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "situacion")
public class Situacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSituacion;

	@NotNull(message="La descripcion de la situacion del trabajador no debe estar vacio")
	@Length(message="La desripcion de la situacion del trabajador no debe exceder los 60 caracteres",min=0,max=60)
	@Column(name = "descripcion", nullable = false, length = 60)
	private String descripcion;

	public Integer getIdSituacion() {
		return idSituacion;
	}

	public void setIdSituacion(Integer idSituacion) {
		this.idSituacion = idSituacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
