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

@Entity
@Table(name="tipo_permisos")
public class TipoPermiso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTipoPermiso;
	
	@NotNull(message="La descripcion del tipo de Permiso no puede estar vacio")
	@Column(name="descripcion", nullable=false)
	private String descripcion;
	
	@Column(name="dias_permiso", nullable=true)
	private Integer diasPermiso;
	
	@NotNull(message="El estado del tipo de Permiso no puede estar vacio")
	@Column(name="estado", nullable=false)
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name="id_empresa",nullable=false)
	private Empresa empresa;

	public Integer getIdTipoPermiso() {
		return idTipoPermiso;
	}
	
	

	public Empresa getEmpresa() {
		return empresa;
	}



	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}



	public void setIdTipoPermiso(Integer idTipoPermiso) {
		this.idTipoPermiso = idTipoPermiso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getDiasPermiso() {
		return diasPermiso;
	}

	public void setDiasPermiso(Integer diasPermiso) {
		this.diasPermiso = diasPermiso;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}
