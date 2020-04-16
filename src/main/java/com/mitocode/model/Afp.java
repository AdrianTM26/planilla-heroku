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

import com.fasterxml.jackson.annotation.JsonIgnore;;

@Entity
@Table(name="afp")
public class Afp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAfp;
	
	@NotNull(message="La descripcion de la afp no debe estar vacio")
	@Length(message="La desripcion de la afp no debe exceder los 30 caracteres",min=0,max=30)
	@Column(name="descripcion", nullable = false, length=30)
	private String descripcion;
	
	@NotNull(message="La comision sobre flujo no debe estar vacio")
	@Column(name="com_sob_flu", nullable = false)
	private double comSobFlu;
	
	@Column(name="com_sob_flu_mix", nullable = true)
	private double comSobFluMix;
	
	@Column(name="com_anu_sob_sal", nullable = true)
	private double comAnuSobSal;
	
	@Column(name="prima_seguro", nullable = true)
	private double primaSeguro;
	
	@Column(name="apo_obl_fnd_pen", nullable = true)
	private double apoOblFndPen;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable=true)
	private Empresa empresa;

	public Integer getIdAfp() {
		return idAfp;
	}

	public void setIdAfp(Integer idAfp) {
		this.idAfp = idAfp;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getComSobFlu() {
		return comSobFlu;
	}

	public void setComSobFlu(double comSobFlu) {
		this.comSobFlu = comSobFlu;
	}

	public double getComSobFluMix() {
		return comSobFluMix;
	}

	public void setComSobFluMix(double comSobFluMix) {
		this.comSobFluMix = comSobFluMix;
	}


	
	public double getComAnuSobSal() {
		return comAnuSobSal;
	}

	public void setComAnuSobSal(double comAnuSobSal) {
		this.comAnuSobSal = comAnuSobSal;
	}

	public double getPrimaSeguro() {
		return primaSeguro;
	}

	public void setPrimaSeguro(double primaSeguro) {
		this.primaSeguro = primaSeguro;
	}

	public double getApoOblFndPen() {
		return apoOblFndPen;
	}

	public void setApoOblFndPen(double apoOblFndPen) {
		this.apoOblFndPen = apoOblFndPen;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	
}
