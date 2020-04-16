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
@Table(name="pdo_ano")
public class PdoAno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPdoAno;
	
	@NotNull(message="La descripcion del año no puede estar vacio")
	@Column(name = "descripcion", nullable = false)
	private Integer descripcion;
	
	//@JsonIgnore
	@NotNull(message="No se ha especificado una empresa")
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable=false)
	private Empresa empresa;

	public Integer getIdPdoAno() {
		return idPdoAno;
	}

	public Integer getDescripcion() {
		return descripcion;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setIdPdoAno(Integer idPdoAno) {
		this.idPdoAno = idPdoAno;
	}

	public void setDescripcion(Integer descripcion) {
		this.descripcion = descripcion;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
