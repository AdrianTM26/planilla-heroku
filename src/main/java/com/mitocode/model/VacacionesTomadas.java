package com.mitocode.model;

import java.sql.Date;

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
@Table(name="vaca_toma")
public class VacacionesTomadas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idVacaTomada;
	
	@NotNull(message="La fecha de Inicio de la vacacion tomada no puede estar vacio")
	@Column(name="fecha_ini", nullable=false)
	private Date fechaIni;
	
	@Column(name="fecha_fin")
	private Date fechaFin;
	
	@Column(name="tipo_fecha")
	private Integer tipo;
	
	@ManyToOne
	@JoinColumn(name="pdo_mes_ini")
	private PdoMes pdoMesIni;
	
	@ManyToOne
	@JoinColumn(name="pdo_mes_fin")
	private PdoMes pdoMesFin;
	
	@ManyToOne
	@JoinColumn(name="pdo_ano_ini")
	private PdoAno pdoAnoIni;
	
	@ManyToOne
	@JoinColumn(name="pdo_ano_fin")
	private PdoAno pdoAnoFin;
	
	@ManyToOne
	@JoinColumn(name="id_vacacion")
	private Vacaciones pdoVacacion;
	

	public Integer getIdVacaTomada() {
		return idVacaTomada;
	}

	public void setIdVacaTomada(Integer idVacaTomada) {
		this.idVacaTomada = idVacaTomada;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public PdoMes getPdoMesIni() {
		return pdoMesIni;
	}

	public void setPdoMesIni(PdoMes pdoMesIni) {
		this.pdoMesIni = pdoMesIni;
	}

	public PdoMes getPdoMesFin() {
		return pdoMesFin;
	}

	public void setPdoMesFin(PdoMes pdoMesFin) {
		this.pdoMesFin = pdoMesFin;
	}

	public PdoAno getPdoAnoIni() {
		return pdoAnoIni;
	}

	public void setPdoAnoIni(PdoAno pdoAnoIni) {
		this.pdoAnoIni = pdoAnoIni;
	}

	public PdoAno getPdoAnoFin() {
		return pdoAnoFin;
	}

	public void setPdoAnoFin(PdoAno pdoAnoFin) {
		this.pdoAnoFin = pdoAnoFin;
	}

	public Vacaciones getPdoVacacion() {
		return pdoVacacion;
	}

	public void setPdoVacacion(Vacaciones pdoVacacion) {
		this.pdoVacacion = pdoVacacion;
	}
	
	
	
	
}
