package com.mitocode.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "adelanto_sueldo")
public class AdelantoSueldo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAdelantoSueldo;
	
	@NotNull(message="El tipo de adelanto sueldo no debe estar vacio")
	@Column(name="tipo", nullable=false)
	private Integer tipo;
	
	@Column(name="estado", nullable=false)
	private Integer estado;
	
	
	@Column(name = "nombre_archivo", nullable = true)
	private String nombreArchivo;
	
	@NotNull(message="El monto total del adelanto sueldo no debe estar vacio")
	@Column(name = "monto_total", nullable = false)
	private Double montoTotal;
	
	@NotNull(message="El numero de cuotas de adelanto sueldo no debe estar vacio")
	@Column(name = "nro_cuotas", nullable = false)
	private Integer nroCuotas;
	
	@Column(name = "fecha_solicitud", nullable = false)
	private Timestamp fechaSol;
	
	@ManyToOne()
	@JoinColumn(name = "id_trabajador", nullable = false)
	private Trabajador trabajador;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "adelantoSueldo")
	private List<CuotaAdelanto> cuotaAdelanto;

	public Integer getIdAdelantoSueldo() {
		return idAdelantoSueldo;
	}

	public void setIdAdelantoSueldo(Integer idAdelantoSueldo) {
		this.idAdelantoSueldo = idAdelantoSueldo;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Integer getNroCuotas() {
		return nroCuotas;
	}

	public void setNroCuotas(Integer nroCuotas) {
		this.nroCuotas = nroCuotas;
	}

	public Timestamp getFechaSol() {
		return fechaSol;
	}

	public void setFechaSol(Timestamp fechaSol) {
		this.fechaSol = fechaSol;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public List<CuotaAdelanto> getCuotaAdelanto() {
		return cuotaAdelanto;
	}

	public void setCuotaAdelanto(List<CuotaAdelanto> cuotaAdelanto) {
		this.cuotaAdelanto = cuotaAdelanto;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
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
