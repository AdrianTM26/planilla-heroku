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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "derecho_habiente")
public class DerechoHabientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer idDerechoHabiente;
	
	@Column(name = "id_tipo_derechohabiente", nullable = true)
	public Integer idTipoDerechoHabiente;
	
	@NotNull(message="El nombre del derecho habiente no debe estar vacio")
	@Length(message="El nombre del derecho habiente no debe exceder los 50 caracteres",min=0,max=50)
	@Column(name = "nombre",nullable = false, length = 50)
	public String nombre;
	
	@Length(message="El nombre del archivo del derecho habiente no debe exceder los 100 caracteres",min=0,max=100)
	@Column(name = "nombre_archivo",nullable = true, length = 100)
	public String nombreArchivo;
	
	@NotNull(message="El apellido para un derecho habiente no debe estar vacio")
	@Length(message="El apellido para un derecho habiente no debe exceder los 50 caracteres",min=0,max=50)
	@Column(name = "apellido",nullable = false, length = 50)
	public String apellido;
	
	@NotNull(message="La fecha de nacimiento para un derecho habiente no debe estar vacio")
	@Column(name = "fecha_nac" , nullable = false)
	public Timestamp fechaNac;
	
	@Email(message="El correo debe tener un formato valido")
	@NotNull(message="El correo en derecho habiente no debe estar vacio")
	@Length(message="El correo en derecho habiente no debe exceder los 50 caracteres",min=0,max=50)
	@Column(name = "correo",nullable = false, length = 50)
	public String correo;
	
	@Length(message="El Código Único de Identificación del Sistema Privado de Pensiones en derecho habiente no debe exceder los 20 caracteres",min=0,max=20)
	@Column(name = "nro_cuspp", nullable = true, length = 20)
	private String nroCuspp;
	
	private Integer estado;
	
	@NotNull(message="La fecha de inicio del derecho habiente no puede estar vacio")
	@Column(name="fecha_inicio", nullable=false)
	private Timestamp fechaInicio;
	
	@NotNull(message="La fecha de fin del derecho habiente no puede estar vacio")
	@Column(name="fecha_fin", nullable=false)
	private Timestamp fechaFin;
	
	@ManyToOne()
	@JoinColumn(name = "id_trabajdor", nullable = false)
	public Trabajador trabajador;

	public Integer getIdDerechoHabiente() {
		return idDerechoHabiente;
	}

	public void setIdDerechoHabiente(Integer idDerechoHabiente) {
		this.idDerechoHabiente = idDerechoHabiente;
	}

	public Integer getIdTipoDerechoHabiente() {
		return idTipoDerechoHabiente;
	}

	public void setIdTipoDerechoHabiente(Integer idTipoDerechoHabiente) {
		this.idTipoDerechoHabiente = idTipoDerechoHabiente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Timestamp getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Timestamp fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNroCuspp() {
		return nroCuspp;
	}

	public void setNroCuspp(String nroCuspp) {
		this.nroCuspp = nroCuspp;
	}

	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Timestamp getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	
}
