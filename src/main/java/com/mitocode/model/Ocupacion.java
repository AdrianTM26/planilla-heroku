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
@Table(name = "ocupacion")
public class Ocupacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOcupacion;

	@NotNull(message="La descripcion de la ocupacion no debe estar vacio")
	@Length(message="La desripcion de la ocupacion no debe exceder los 120 caracteres",min=0,max=120)
	@Column(name = "descripcion", nullable = false, length = 120)
	private String descripcion;

	public Integer getIdOcupacion() {
		return idOcupacion;
	}

	public void setIdOcupacion(Integer idOcupacion) {
		this.idOcupacion = idOcupacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
