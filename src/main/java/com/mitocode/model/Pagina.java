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
@Table(name="pagina")
public class Pagina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pagina")
	private Integer idPagina;

	@NotNull(message="La descripcion de la pagina no puede estar vacio")
	@Length(message="La descripcion de la pagina no puede exceder los 100 caracteres",min=0,max=100)
	@Column(name = "descripcion", nullable = false, length = 100)
	private String descripcion;
	
	@NotNull(message="La URL de la pagina no puede estar vacio")
	@Length(message="La URL de la pagina no puede exceder los 100 caracteres",min=0,max=100)
	@Column(name = "url", nullable = false, length = 100)
	private String url;
	
	@NotNull(message="EL parametro de la pagina no puede estar vacio")
	@Length(message="El parametro de la pagina no puede exceder los 150 caracteres",min=0,max=150)
	@Column(name = "parametros", nullable = false, length = 150)
	private String parametros;
	
	@NotNull(message="El icono de la pagina no puede estar vacio")
	@Length(message="El icono de la pagina no puede exceder los 100 caracteres",min=0,max=100)
	@Column(name = "icono", nullable = false, length = 100)
	private String icono;
	
	@NotNull(message="El estado de la pagina no puede estar vacio")
	@Column(name = "estado", nullable = false)
	private Integer estado;
	
	@NotNull(message="El orden de la pagina no puede estar vacio")
	@Column(name = "orden", nullable = false)
	private Integer orden;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_modulo", nullable = false)
	private Modulo modulo;

	public Integer getIdPagina() {
		return idPagina;
	}

	public void setIdPagina(Integer idPagina) {
		this.idPagina = idPagina;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParametros() {
		return parametros;
	}

	public void setParametros(String parametros) {
		this.parametros = parametros;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	
}
