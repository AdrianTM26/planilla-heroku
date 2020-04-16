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
@Table(name = "cuenta_cargo")
public class CuentaCargo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCuentaCargo;
	
	@NotNull(message="La descripcion de la cuenta cargo no puede estar vacio")
	@Column(nullable = false)
	private String descripcion;
	
	@NotNull(message="El numero de cuenta de la cuenta cargo no puede estar vacio")
	@Column(name = "nro_cuenta", nullable = false)
	private String nroCuenta;
	
	@NotNull(message="El tipo de cuenta de la cuenta cargo no puede estar vacio")
	@Column(name = "tipo_cuenta", nullable = false)
	private Integer tipoCuenta;
	
	@NotNull(message="El tipo de moneda de la cuenta cargo no puede estar vacio")
	@Column(name = "tipo_modena", nullable = false)
	private Integer tipoMoneda;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable = false)
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name = "id_banco", nullable = false)
	private Banco banco;

	public Integer getIdCuentaCargo() {
		return idCuentaCargo;
	}

	public void setIdCuentaCargo(Integer idCuentaCargo) {
		this.idCuentaCargo = idCuentaCargo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public Integer getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(Integer tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Integer getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(Integer tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
}
