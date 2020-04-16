package com.mitocode.model;

import java.sql.Date;
import java.sql.Timestamp;

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
@Table(name="asistencias")
public class Asistencia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_asistencia")
	private Integer idAsistencia;
	
	@NotNull(message="El campo fecha no puede estar vacio")
	@Column(name="fecha",nullable=false)
	private Date fecha;
	
	@Column(name="hora_ini_dia")
	private Timestamp horIniDia;
	
	@Column(name="hora_fin_dia")
	private Timestamp horFinDia;
	
	@Column(name="hora_ini_almu")
	private Timestamp horIniAlmu;
	
	@Column(name="hora_fin_almu")
	private Timestamp horFinAlmu;
	
	@Column(name="tipo_asistencia")
	private Integer tipoAsistencia;
	
	@NotNull(message="Se debe indicar a que trabajador procesar su asistencia")
	@ManyToOne
	@JoinColumn(name="id_trabajador", nullable=false)
	private Trabajador trabajador;
	
	@NotNull(message="Se debe indicar a que año pertenece la asistencia")
	@ManyToOne
	@JoinColumn(name="pdo_ano", nullable=true)
	private PdoAno pdoAno;
	
	@NotNull(message="Se debe indicar a que mes pertenece la asistencia")
	@ManyToOne
	@JoinColumn(name="pdo_mes", nullable=true)
	private PdoMes pdoMes;

	public Integer getIdAsistencia() {
		return idAsistencia;
	}

	public void setIdAsistencia(Integer idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Timestamp getHorIniDia() {
		return horIniDia;
	}

	public void setHorIniDia(Timestamp horIniDia) {
		this.horIniDia = horIniDia;
	}

	public Timestamp getHorFinDia() {
		return horFinDia;
	}

	public void setHorFinDia(Timestamp horFinDia) {
		this.horFinDia = horFinDia;
	}

	public Timestamp getHorIniAlmu() {
		return horIniAlmu;
	}

	public void setHorIniAlmu(Timestamp horIniAlmu) {
		this.horIniAlmu = horIniAlmu;
	}

	public Timestamp getHorFinAlmu() {
		return horFinAlmu;
	}

	public void setHorFinAlmu(Timestamp horFinAlmu) {
		this.horFinAlmu = horFinAlmu;
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

	public Integer getTipoAsistencia() {
		return tipoAsistencia;
	}

	public void setTipoAsistencia(Integer tipoAsistencia) {
		this.tipoAsistencia = tipoAsistencia;
	}

	@Override
	public String toString() {
		return "Asistencia [idAsistencia=" + idAsistencia + ", fecha=" + fecha + ", horIniDia=" + horIniDia
				+ ", horFinDia=" + horFinDia + ", horIniAlmu=" + horIniAlmu + ", horFinAlmu=" + horFinAlmu
				+ ", tipoAsistencia=" + tipoAsistencia + ", trabajador=" + trabajador + ", pdoAno=" + pdoAno
				+ ", pdoMes=" + pdoMes + "]";
	}

	public Asistencia() {
		
	}

	public Asistencia(@NotNull Date fecha, Integer tipoAsistencia, Trabajador trabajador) {
		super();
		this.fecha = fecha;
		this.tipoAsistencia = tipoAsistencia;
		this.trabajador = trabajador;
	}
	
}
