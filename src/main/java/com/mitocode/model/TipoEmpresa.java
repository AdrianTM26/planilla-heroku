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
@Table(name = "tipo_empresa")
public class TipoEmpresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoEmp;
	
	@NotNull
	@Length(message="La descripcion del tipo de Empresa no puede exceder de 100 caracteres", min=0, max=100)
	@Column(name = "descripcion", nullable = false, length = 100)
	private String descripcion;

	public Integer getIdTipoEmp() {
		return idTipoEmp;
	}

	public void setIdTipoEmp(Integer idTipoEmp) {
		this.idTipoEmp = idTipoEmp;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}
