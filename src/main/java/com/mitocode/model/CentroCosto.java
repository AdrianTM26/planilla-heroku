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

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="centro_costo")
public class CentroCosto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCentroCosto;
	
	@NotNull(message="La descripcion del centro de costo no debe estar vacio")
	@Length(message="La desripcion del centro de costo no debe exceder los 60 caracteres",min=0,max=60)
	@Column(name="descripcion", nullable = false, length=60)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="id_empresa", nullable = true)
	private Empresa empresa;

	public Integer getIdCentroCosto() {
		return idCentroCosto;
	}

	public void setIdCentroCosto(Integer idCentroCosto) {
		this.idCentroCosto = idCentroCosto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
