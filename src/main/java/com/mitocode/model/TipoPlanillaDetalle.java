package com.mitocode.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tipoplanilla_trabajador")
public class TipoPlanillaDetalle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer idTipoPlanillaDetalle;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_planilla")
	TipoPlanilla tipoPlanilla;
	
	@ManyToOne
	@JoinColumn(name="id_trabajador")
	Trabajador trabajador;

	public Integer getIdTipoPlanillaDetalle() {
		return idTipoPlanillaDetalle;
	}

	public void setIdTipoPlanillaDetalle(Integer idTipoPlanillaDetalle) {
		this.idTipoPlanillaDetalle = idTipoPlanillaDetalle;
	}

	public TipoPlanilla getTipoPlanilla() {
		return tipoPlanilla;
	}

	public void setTipoPlanilla(TipoPlanilla tipoPlanilla) {
		this.tipoPlanilla = tipoPlanilla;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	
}
