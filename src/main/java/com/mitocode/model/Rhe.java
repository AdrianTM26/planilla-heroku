package com.mitocode.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rhe")
public class Rhe {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idRhe;
	
	@Column(name = "nombre_archivo", nullable = true, length = 50)
	private String nombreArchivo;
	
	@Column(name = "fecha_registro", nullable = false)
	private Timestamp fechaReg;
	
	@ManyToOne
	@JoinColumn(name="id_trabajador", nullable = false)
	private Trabajador trabajador;

	@ManyToOne
	@JoinColumn(name="id_pdo_ano", nullable = false)
	private PdoAno pdoAno;
	
	@ManyToOne
	@JoinColumn(name="id_pdo_mes", nullable = false)
	private PdoMes pdoMes;

	public Integer getIdRhe() {
		return idRhe;
	}

	public void setIdRhe(Integer idRhe) {
		this.idRhe = idRhe;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Timestamp getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Timestamp fechaReg) {
		this.fechaReg = fechaReg;
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
