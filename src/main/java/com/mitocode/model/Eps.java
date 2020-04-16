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

@Entity
@Table(name = "eps")
public class Eps {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEps;

	@NotNull(message="La descripcion del eps no debe estar vacio")
	@Length(message="La desripcion del eps no debe exceder los 50 caracteres",min=0,max=50)
	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;
	
	@Column(name = "aporte", nullable = true)
	private Double aporte;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable=false)
	private Empresa empresa;

	public Integer getIdEps() {
		return idEps;
	}

	public void setIdEps(Integer idEps) {
		this.idEps = idEps;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getAporte() {
		return aporte;
	}

	public void setAporte(Double aporte) {
		this.aporte = aporte;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
	
	
}
