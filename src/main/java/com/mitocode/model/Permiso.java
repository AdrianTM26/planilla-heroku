package com.mitocode.model;

import java.util.Date;

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
@Table(name="permisos")
public class Permiso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_permiso")
	private Integer idPermiso;
	
	@NotNull(message="El tipo de permiso para Permiso no puede estar vacio")
	@ManyToOne
	@JoinColumn(name="id_tipo_permiso", nullable=false)
	private TipoPermiso tipoPermiso;
	
	//@Temporal(value=TemporalType.DATE)
	@NotNull(message="La feha de Incio del permiso no puede estar vacio")
	@Column(name="fecha_ini",nullable=false)
	private Date fechaIni;
	
	//@Temporal(value=TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;
	
	@NotNull(message="No se ha especificado un trabajador para el permiso")
	@ManyToOne
	@JoinColumn(name="id_trabajador", nullable=false)
	private Trabajador trabajador;
	
	@NotNull(message="No se ha especificado un año para el permiso")
	@ManyToOne
	@JoinColumn(name="pdo_ano", nullable=false)
	private PdoAno pdoAno;
	
	@NotNull(message="No se ha especificado un mes para el permiso")
	@ManyToOne
	@JoinColumn(name="pdo_mes", nullable=false)
	private PdoMes pdoMes;

	public Integer getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}

	public TipoPermiso getTipoPermiso() {
		return tipoPermiso;
	}

	public void setTipoPermiso(TipoPermiso tipoPermiso) {
		this.tipoPermiso = tipoPermiso;
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

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public PdoAno getPdoAno() {
		return pdoAno;
	}

	public void setPdoAno(PdoAno pdoAno) {
		this.pdoAno = pdoAno;
	}

	public PdoMes getPdoMes() {
		return pdoMes;
	}

	public void setPdoMes(PdoMes pdoMes) {
		this.pdoMes = pdoMes;
	}
	
	
	
}
