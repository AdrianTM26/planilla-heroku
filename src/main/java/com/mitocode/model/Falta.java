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
@Table(name="faltas")
public class Falta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_falta")
	private Integer idFalta;
	
	@NotNull(message="No se ha especificado un trabajador para la falta")
	@ManyToOne
	@JoinColumn(name="id_trabajador", nullable=false)
	private Trabajador trabajador;
	
	@NotNull(message="No se ha especificado un año para la falta")
	@ManyToOne
	@JoinColumn(name="id_pdo_ano", nullable=false)
	private PdoAno pdoAno;
	
	@NotNull(message="No se ha especificado un mes para la falta")
	@ManyToOne
	@JoinColumn(name="id_pdo_mes", nullable=false)
	private PdoMes pdoMes;
	
	@NotNull(message="La fecha de la falta no puede estar vacio")
	@Column(name="fecha", nullable=false)
	private Date fecha;
	
	@NotNull(message="El tipo de justificacion no puede estar vacio")
	@Column(name="tipo_justificacion",nullable=false)
	private Integer justificado;

	public Integer getIdFalta() {
		return idFalta;
	}

	public void setIdFalta(Integer idFalta) {
		this.idFalta = idFalta;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getJustificado() {
		return justificado;
	}

	public void setJustificado(Integer justificado) {
		this.justificado = justificado;
	}	

}
