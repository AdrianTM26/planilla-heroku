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
@Table(name = "descuentos")
public class Descuentos {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idDescuentos;
	
	@NotNull(message="La descripcion del descuento no puede estar vacio")
	@Column(nullable=false)
	private String descripcion;
	
	@NotNull(message="El tipo de descuento no puede estar vacio")
	@Column(name = "tipo_dsct", nullable = false)
	private Integer tipoDsct;
	
	@Column(name = "monto_fijo", nullable = true)
	private Double montoFijo;
	
	private String formula;
	
	@NotNull(message="El estado del descuento no puede estar vacio")
	@Column(name="estado", nullable=false)
	private Integer estado;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable = false)
	private Empresa empresa;

	public Integer getIdDescuentos() {
		return idDescuentos;
	}

	public void setIdDescuentos(Integer idDescuentos) {
		this.idDescuentos = idDescuentos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getTipoDsct() {
		return tipoDsct;
	}

	public void setTipoDsct(Integer tipoDsct) {
		this.tipoDsct = tipoDsct;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
