package com.mitocode.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="tipo_planilla")
public class TipoPlanilla {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoPlanilla;

	private String descripcion;
	
	@Column(name="categoria_planilla")
	private Integer categoriaPlanilla;
	
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPlanilla")
	private List<TipoPlanillaPerfil> lstipoPlanillaPerfil;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPlanilla")
	private List<TipoPlanillaDetalle> lstipoPlanillaDetalle;
	
	public Integer getIdTipoPlanilla() {
		return idTipoPlanilla;
	}
	public void setIdTipoPlanilla(Integer idTipoPlanilla) {
		this.idTipoPlanilla = idTipoPlanilla;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getCategoriaPlanilla() {
		return categoriaPlanilla;
	}
	public void setCategoriaPlanilla(Integer categoriaPlanilla) {
		this.categoriaPlanilla = categoriaPlanilla;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
