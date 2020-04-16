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
@Table(name = "reg_tributario")
public class RegimenTributario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegTrib;
	
	@NotNull(message="La descripcion del regimen tributario no puede ser nulo")
	@Length(message="La descripcion del regimen tributario no puede exceder de 80 caracteres", min=0, max=80)
	@Column(name = "descripcion", nullable = false, length = 80)
	private String descripcion;

	public Integer getIdRegTrib() {
		return idRegTrib;
	}

	public void setIdRegTrib(Integer idRegTrib) {
		this.idRegTrib = idRegTrib;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
