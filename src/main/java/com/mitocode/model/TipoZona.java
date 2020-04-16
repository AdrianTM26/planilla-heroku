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
@Table(name = "tipo_zona")
public class TipoZona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoZona;

	@NotNull(message="La descripcion del tipo de zona no debe estar vacio")
	@Length(message="La desripcion del tipo de zona no debe exceder los 60 caracteres",min=0,max=60)
	@Column(name = "descripcion", nullable = false, length = 60)
	private String descripcion;

	public Integer getIdTipoZona() {
		return idTipoZona;
	}

	public void setIdTipoZona(Integer idTipoZona) {
		this.idTipoZona = idTipoZona;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
