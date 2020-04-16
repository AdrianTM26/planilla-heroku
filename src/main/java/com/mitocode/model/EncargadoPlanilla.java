package com.mitocode.model;

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
@Table(name = "encargado_planilla")
public class EncargadoPlanilla {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEncargadoPlanilla;
	
	@NotNull(message="El nombre del encargado de planilla no puede estar vacio")
	@Length(message="El nombre del encargado de planilla no puede exceder los 50 caracteres",min=0,max=50)
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;
	
	@NotNull(message="El apellido del encargado de planilla no puede estar vacio")
	@Length(message="El apellido del encargado de planilla no puede exceder los 50 caracteres",min=0,max=50)
	@Column(name = "apellido", length = 50, nullable = false)
	private String apellido;
	
	@NotNull(message="El numero de DNI del encargado de planilla no puede estar vacio")
	@Length(message="El numero de DNI del encargado de planilla no puede exceder los 50 caracteres",min=0,max=50)
	@Column(name = "nro_dni", length = 8, nullable = false)
	private String NroDni;
	
	
	private Integer estado;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable = false)
	private Empresa empresa;

	public Integer getIdEncargadoPlanilla() {
		return idEncargadoPlanilla;
	}

	public void setIdEncargadoPlanilla(Integer idEncargadoPlanilla) {
		this.idEncargadoPlanilla = idEncargadoPlanilla;
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

	public String getNroDni() {
		return NroDni;
	}

	public void setNroDni(String nroDni) {
		NroDni = nroDni;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
		
	
}
