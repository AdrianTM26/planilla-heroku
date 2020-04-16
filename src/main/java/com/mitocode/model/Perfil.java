package com.mitocode.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="perfil")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_perfil")
	private Integer idPerfil;
	
	@NotNull(message="El nombre del perfil no puede estar vacio")
	@Length(message="El nombre del perfil no puede exceder los 50 caracteres",min=0,max=50)
	@Column(name="nombres", nullable = false, length=50)
	private String nombres;
	
	@NotNull(message="El ambito del perfil no puede estar vacio")
	@Column(name="ambito", nullable = false)
	private Integer ambito;
	
	@NotNull(message="El estado del perfil no puede estar vacio")
	@Column(name="estado", nullable = false)
	private Boolean estado;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "perfiles_pagina", joinColumns = @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil"), inverseJoinColumns = @JoinColumn(name = "id_pagina", referencedColumnName = "id_pagina"))
	private List<Pagina> lspaginas;

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Integer getAmbito() {
		return ambito;
	}

	public void setAmbito(Integer ambito) {
		this.ambito = ambito;
	}


	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public List<Pagina> getLspaginas() {
		return lspaginas;
	}

	public void setLspaginas(List<Pagina> lspaginas) {
		this.lspaginas = lspaginas;
	}
	
	
}
