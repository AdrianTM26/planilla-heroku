package com.mitocode.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cuota_adelanto")
public class CuotaAdelanto implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idCuotaAdelanto;
	
	@ManyToOne
	@JoinColumn(name = "id_adelando_sueldo", nullable = false)
	private AdelantoSueldo adelantoSueldo;
	
	@Column(name = "monto_cuota")
	private Double montoCuota;
	
	@ManyToOne
	@JoinColumn(name = "id_pdo_ano", nullable = false)
	private PdoAno pdoAno;
	
	@ManyToOne
	@JoinColumn(name = "id_pdo_mes", nullable = false)
	private PdoMes pdoMes;
	
	private Integer estado;

	public Integer getIdCuotaAdelanto() {
		return idCuotaAdelanto;
	}

	public void setIdCuotaAdelanto(Integer idCuotaAdelanto) {
		this.idCuotaAdelanto = idCuotaAdelanto;
	}

	public AdelantoSueldo getAdelantoSueldo() {
		return adelantoSueldo;
	}

	public void setAdelantoSueldo(AdelantoSueldo adelantoSueldo) {
		this.adelantoSueldo = adelantoSueldo;
	}

	public Double getMontoCuota() {
		return montoCuota;
	}

	public void setMontoCuota(Double montoCuota) {
		this.montoCuota = montoCuota;
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6372999515210024617L;

}
