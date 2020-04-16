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
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name="vaca_vend")
public class VacacionesVendidas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vacacion_vendida")
	private Integer idVacaVendida;
	
	@NotNull(message="La fecha de la Venta de la vacacion vendida no puede estar vacio")
	@Column(name="fecha_venta",nullable=false)
	private Date fechaVenta;
	
	@ManyToOne
	@JoinColumn(name="pdo_mes_venta")
	private PdoMes pdoMesVenta;
	
	@ManyToOne
	@JoinColumn(name="pdo_ano_venta")
	private PdoAno pdoAnoVenta;
	
	@NotNull(message="La cantidad de vacaciones vendidas (Dias) no puede estar vacio")
	@PositiveOrZero(message="La cantidad de vacaciones vendidads (Dias) no puede ser negativo")
	@Column(name="cnt_dias",nullable=false)
	private Integer cantDias;
	
	@ManyToOne
	@JoinColumn(name="id_vacacion")
	private Vacaciones vacacion;

	public Integer getIdVacaVendida() {
		return idVacaVendida;
	}

	public void setIdVacaVendida(Integer idVacaVendida) {
		this.idVacaVendida = idVacaVendida;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public PdoMes getPdoMesVenta() {
		return pdoMesVenta;
	}

	public void setPdoMesVenta(PdoMes pdoMesVenta) {
		this.pdoMesVenta = pdoMesVenta;
	}

	public PdoAno getPdoAnoVenta() {
		return pdoAnoVenta;
	}

	public void setPdoAnoVenta(PdoAno pdoAnoVenta) {
		this.pdoAnoVenta = pdoAnoVenta;
	}

	public Integer getCantDias() {
		return cantDias;
	}

	public void setCantDias(Integer cantDias) {
		this.cantDias = cantDias;
	}

	public Vacaciones getVacacion() {
		return vacacion;
	}

	public void setVacacion(Vacaciones vacacion) {
		this.vacacion = vacacion;
	}
	
}
