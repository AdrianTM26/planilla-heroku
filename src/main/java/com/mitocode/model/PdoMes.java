	package com.mitocode.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pdo_mes")
public class PdoMes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPdoMes;

	@NotNull(message="La descripcion del mes no puede estar vacio")
	@Length(message="La descripcion del mes no puede exceder a 20 caracteres",min=0,max=20)
	@Column(name = "descripcion", nullable = false, length = 20)
	private String descripcion;

	@NotNull(message="La abreviatura del mes no puede estar vacio")
	@Length(message="La abreviatura del mes no puede exceder a 3 caracteres",min=0,max=3)
	@Column(name = "abrev", nullable = false, length = 3)
	private String abrev;

	@NotNull(message="La cantidad de feriados del mes no puede estar vacio")
	@Column(name = "dias_feriado_calend", nullable = false)
	private Integer diasFeriadoCalend;
	
	@Column(name="cantidad_dias",nullable = true)
	private Integer cantidadDias;
	
	@Column(name="dias_feriados",nullable=true)
	private String txtDiasFeriados;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pdoMes")
	private List<CuotaAdelanto> cuotaAdelanto;

	
	public String getTxtDiasFeriados() {
		return txtDiasFeriados;
	}

	public void setTxtDiasFeriados(String txtDiasFeriados) {
		this.txtDiasFeriados = txtDiasFeriados;
	}

	public Integer getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(Integer cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	public Integer getIdPdoMes() {
		return idPdoMes;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getAbrev() {
		return abrev;
	}

	public Integer getDiasFeriadoCalend() {
		return diasFeriadoCalend;
	}

	public void setIdPdoMes(Integer idPdoMes) {
		this.idPdoMes = idPdoMes;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setAbrev(String abrev) {
		this.abrev = abrev;
	}

	public void setDiasFeriadoCalend(Integer diasFeriadoCalend) {
		this.diasFeriadoCalend = diasFeriadoCalend;
	}
}
