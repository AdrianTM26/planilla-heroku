package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tipo_contrato")
public class TipoContrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipContrato;
	
	@NotNull(message="La descripcion del tipo de contrato no debe estar vacio")
	@Length(message="La desripcion del tipo de contrato no debe exceder los 100 caracteres",min=0,max=100)
	@Column(name = "descripcion", nullable = false, length = 100)
	private String descripcion;

	public int getIdTipContrato() {
		return idTipContrato;
	}

	public void setIdTipContrato(int idTipContrato) {
		this.idTipContrato = idTipContrato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
