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
@Table(name = "nivel_edu")
public class NivelEdu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNivelEdu;

	@NotNull(message="La descripcion del nivel educacion no debe estar vacio")
	@Length(message="La desripcion del nivel educacion no debe exceder los 100 caracteres",min=0,max=100)
	@Column(name = "descripcion", nullable = false, length = 100)
	private String descripcion;

	public Integer getIdNivelEdu() {
		return idNivelEdu;
	}

	public void setIdNivelEdu(Integer idNivelEdu) {
		this.idNivelEdu = idNivelEdu;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
