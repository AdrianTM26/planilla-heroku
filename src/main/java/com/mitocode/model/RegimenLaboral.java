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
@Table(name="regimen_laboral")
public class RegimenLaboral {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegLaboral;
	
	@NotNull(message="La descripcion del Regimen Laboral no debe estar vacio")
	@Length(message="La desripcion del Regimen Laboral no debe exceder los 120 caracteres",min=0,max=120)
	@Column(name="descripcion",nullable=false, length = 120)
	private String descripcion;

	public Integer getIdRegLaboral() {
		return idRegLaboral;
	}

	public void setIdRegLaboral(Integer idRegLaboral) {
		this.idRegLaboral = idRegLaboral;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
