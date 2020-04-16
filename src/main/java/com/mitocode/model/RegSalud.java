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
@Table(name = "reg_salud")
public class RegSalud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegSalud;

	@NotNull(message="La descripcion del Regimen de Salud no debe estar vacio")
	@Length(message="La desripcion del Regimen de Salud no debe exceder los 50 caracteres",min=0,max=50)
	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;

	public Integer getIdRegSalud() {
		return idRegSalud;
	}

	public void setIdRegSalud(Integer idRegSalud) {
		this.idRegSalud = idRegSalud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
