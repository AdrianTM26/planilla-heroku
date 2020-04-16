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
@Table(name = "tipo_doc")
public class TipoDoc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoDoc;
	
	@NotNull(message="La descripcion del tipo de documento no debe estar vacio")
	@Length(message="La desripcion del tipo de documento no debe exceder los 40 caracteres",min=0,max=40)
	@Column(name = "descripcion", nullable = false, length = 40)
	private String descripcion;

	public Integer getIdTipoDoc() {
		return idTipoDoc;
	}

	public void setIdTipoDoc(Integer idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
