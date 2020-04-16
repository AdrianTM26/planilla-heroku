package com.mitocode.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cargo")
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cargo", nullable = false)
	private Integer idCargo;
	
	@NotNull(message="La descripcion del cargo no debe estar vacio")
	@Length(message="La desripcion del cargo no debe exceder los 100 caracteres",min=0,max=100)
	@Column(name = "descripcion", nullable = false, length = 100)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = true, foreignKey = @ForeignKey(name = "fk_categoria"))
	private Categoria categoria;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cargo")
	private List<Contrato> lsContrato;

	public Integer getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Contrato> getLsContrato() {
		return lsContrato;
	}

	public void setLsContrato(List<Contrato> lsContrato) {
		this.lsContrato = lsContrato;
	}

	

}
