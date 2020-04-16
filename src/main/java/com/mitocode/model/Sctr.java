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
@Table(name = "sctr")
public class Sctr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSctr;
	
	@NotNull(message="La descripcion del Seguro Complementario de Trabajo de Riesgo no debe estar vacio")
	@Length(message="La desripcion del Seguro Complementario de Trabajo de Riesgo no debe exceder los 50 caracteres",min=0,max=50)
	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;
	
	@Column(name = "tipo", nullable = false)
	private Integer tipo;

	public int getIdSctr() {
		return idSctr;
	}

	public void setIdSctr(int idSctr) {
		this.idSctr = idSctr;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	
	
}
