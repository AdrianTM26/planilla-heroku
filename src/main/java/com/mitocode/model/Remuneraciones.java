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
@Table(name = "remuneraciones")
public class Remuneraciones {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idRemuneraciones;
	
	@NotNull(message="La descripcion de la remuneracion no puede estar vacio")
	@Column(nullable = false)
	private String descripcion;
	
	@NotNull(message="El tipo de remuneracion no puede estar vacio")
	@Column(name = "tipo_remuneracion", nullable = false)
	private Integer tipoRemuneracion;
	
	@Column(name = "monto_fijo", nullable = true)
	private Double montoFijo;
	
	@Column(nullable = true)
	private String formula;
	
	@NotNull(message="El estado de la remuneracion no puede estar vacio")
	@Column(nullable = false)
	private Integer estado;
	
	@NotNull(message="El descuento de la remuneracion no puede estar vacio")
	@Column(name = "afecto_dsct", nullable = false)
	private Integer afectoDsct;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable = false)
	private Empresa empresa;

	public Integer getIdRemuneraciones() {
		return idRemuneraciones;
	}

	public void setIdRemuneraciones(Integer idRemuneraciones) {
		this.idRemuneraciones = idRemuneraciones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getTipoRemuneracion() {
		return tipoRemuneracion;
	}

	public void setTipoRemuneracion(Integer tipoRemuneracion) {
		this.tipoRemuneracion = tipoRemuneracion;
	}

	public Double getMontoFijo() {
		return montoFijo;
	}

	public void setMontoFijo(Double montoFijo) {
		this.montoFijo = montoFijo;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getAfectoDsct() {
		return afectoDsct;
	}

	public void setAfectoDsct(Integer afectoDsct) {
		this.afectoDsct = afectoDsct;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	

}
