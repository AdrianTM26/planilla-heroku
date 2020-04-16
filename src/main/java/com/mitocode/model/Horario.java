package com.mitocode.model;

import java.io.Serializable;
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

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="horarios")
public class Horario implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_horario")
	private Integer idHorario;
	
	@NotNull(message="La hora de inicio del dia en Horario no debe estar vacio")
	@Column(name="hora_inicio_dia", nullable=false)
	private Timestamp horIniDia;
	
	@NotNull(message="La hora de fin del dia en Horario no debe estar vacio")
	@Column(name="hora_fin_dia", nullable=false)
	private Timestamp horFinDia;
	
	@NotNull(message="La hora de inicio del almuerzo en Horario no debe estar vacio")
	@Column(name="hora_inicio_almuer", nullable=false)
	private Timestamp horAlmuerIni;
	
	@NotNull(message="La hora de fin del almuerzo en Horario no debe estar vacio")
	@Column(name="hora_fin_almuer", nullable=false)
	private Timestamp horAlmuerFin;
	
	@NotNull(message="La descripcion del horario no debe estar vacio")
	@Column(name="descripcion", nullable=false)
	private String descripcion;
	
	@NotNull(message="El estado del Horario no debe estar vacio")
	@Column(name="estado", nullable=false)
	private Boolean estado;
	
	@NotNull(message="Se debe indicar si se ha marcado o no el dia Lunes para un Horario")
	@Column(name="check_lunes",nullable=false)
	private Boolean checkLunes;

	@NotNull(message="Se debe indicar si se ha marcado o no el dia Martes para un Horario")
	@Column(name="check_martes",nullable=false)
	private Boolean checkMartes;
	
	@NotNull(message="Se debe indicar si se ha marcado o no el dia Miercoles para un Horario")
	@Column(name="check_miercoles",nullable=false)
	private Boolean checkMiercoles;
	
	@NotNull(message="Se debe indicar si se ha marcado o no el dia Jueves para un Horario")
	@Column(name="check_jueves",nullable=false)
	private Boolean checkJueves;
	
	@NotNull(message="Se debe indicar si se ha marcado o no el dia Viernes para un Horario")
	@Column(name="check_viernes",nullable=false)
	private Boolean checkViernes;
	
	@NotNull(message="Se debe indicar si se ha marcado o no el dia Sabado para un Horario")
	@Column(name="check_sabado",nullable=false)
	private Boolean checkSabado;
	
	@NotNull(message="Se debe indicar si se ha marcado o no el dia Domingo para un Horario")
	@Column(name="check_domingo",nullable=false)
	private Boolean checkDomingo;
	
	@Column(name="dias", nullable=true)
	private String totalDias;

	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable=false)
	private Empresa empresa;

	public Integer getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
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

	public Timestamp getHorAlmuerIni() {
		return horAlmuerIni;
	}

	public Boolean getCheckLunes() {
		return checkLunes;
	}

	public void setCheckLunes(Boolean checkLunes) {
		this.checkLunes = checkLunes;
	}

	public Boolean getCheckMartes() {
		return checkMartes;
	}

	public void setCheckMartes(Boolean checkMartes) {
		this.checkMartes = checkMartes;
	}

	public Boolean getCheckMiercoles() {
		return checkMiercoles;
	}

	public void setCheckMiercoles(Boolean checkMiercoles) {
		this.checkMiercoles = checkMiercoles;
	}

	public Boolean getCheckJueves() {
		return checkJueves;
	}

	public void setCheckJueves(Boolean checkJueves) {
		this.checkJueves = checkJueves;
	}

	public Boolean getCheckViernes() {
		return checkViernes;
	}

	public void setCheckViernes(Boolean checkViernes) {
		this.checkViernes = checkViernes;
	}

	public Boolean getCheckSabado() {
		return checkSabado;
	}

	public void setCheckSabado(Boolean checkSabado) {
		this.checkSabado = checkSabado;
	}

	public Boolean getCheckDomingo() {
		return checkDomingo;
	}

	public void setCheckDomingo(Boolean checkDomingo) {
		this.checkDomingo = checkDomingo;
	}

	
	public void setHorAlmuerIni(Timestamp horAlmuerIni) {
		this.horAlmuerIni = horAlmuerIni;
	}

	public Timestamp getHorAlmuerFin() {
		return horAlmuerFin;
	}

	public void setHorAlmuerFin(Timestamp horAlmuerFin) {
		this.horAlmuerFin = horAlmuerFin;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	

	public String getTotalDias() {
		return totalDias;
	}

	public void setTotalDias(String totalDias) {
		this.totalDias = totalDias;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 3856568896639556663L;

}
