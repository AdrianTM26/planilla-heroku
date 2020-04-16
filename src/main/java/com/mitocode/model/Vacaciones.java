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

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="pdo_vacacion")
public class Vacaciones {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idVacacion;
	
	@NotNull(message="La fecha de Inicio de la vacacion no puede estar vacio")
	@Column(name="fecha_ini_pdo", nullable=false)
	private Date fechaIni;
	
	@NotNull(message="La fecha de Fin de la vacacion no puede estar vacio")
	@Column(name="fecha_fin_pdo",nullable=false)
	private Date fechaFin;
	
	@NotNull(message="El estado de la vacacion no puede estar vacio")
	@Column(name="estado", nullable=false)
	private Integer estado;
	
	@NotNull(message="Los dias vendidos de la vacacion no puede estar vacio")
	@Column(name="dias_vend",nullable=false)
	private Integer diasVendidos;
	
	@NotNull(message="Los dias tomados de la vacacion no puede estar vacio")
	@Column(name="dias_tom", nullable=false)
	private Integer diasTomados;
	
	@ManyToOne
	@JoinColumn(name="id_trabajador")
	private Trabajador trabajador;

	public Integer getIdVacacion() {
		return idVacacion;
	}

	public void setIdVacacion(Integer idVacacion) {
		this.idVacacion = idVacacion;
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getDiasVendidos() {
		return diasVendidos;
	}

	public void setDiasVendidos(Integer diasVendidos) {
		this.diasVendidos = diasVendidos;
	}

	public Integer getDiasTomados() {
		return diasTomados;
	}

	public void setDiasTomados(Integer diasTomados) {
		this.diasTomados = diasTomados;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	
}
