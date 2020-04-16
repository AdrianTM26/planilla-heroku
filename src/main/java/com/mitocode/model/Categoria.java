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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="categoria")
public class Categoria {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idCategoria;
	
	@NotNull(message="No se ha indicado una descripcion para la categoria")
	@NotEmpty(message="La descripcion de la categoria no debe estar vacio")
	@Length(message="La desripcion de la categoria no debe exceder los 100 caracteres",min=0,max=100)
	@Column(name="descripcion", nullable = false, length = 100)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="id_empresa", nullable=false)
	private Empresa empresa;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
	private List<Cargo> lscargo;
	
	/*@JsonIgnore	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
	private List<Contrato> lsContrato;*/
	
	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
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
