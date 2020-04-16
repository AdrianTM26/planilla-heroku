package com.mitocode.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="suspencion")
public class Suspencion {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idSuspencion;
	
	@Column(name = "nombre_archivo", nullable = false, length = 50)
	private String nombreArchivo;
	
	@Column(name = "fecha_registro", nullable = false)
	private Timestamp fechaRegistro;
	
	@OneToOne
	@JoinColumn(name = "id_trabajador", nullable = false)
	private Trabajador trabajador;

	public Integer getIdSuspencion() {
		return idSuspencion;
	}

	public void setIdSuspencion(Integer idSuspencion) {
		this.idSuspencion = idSuspencion;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	
}
