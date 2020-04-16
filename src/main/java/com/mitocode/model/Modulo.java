package com.mitocode.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="modulo")
public class Modulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idModulo;

	@NotNull(message="La descripcion del modulo no puede estar vacio")
	@Length(message="La descripcion del modulo no puede exceder los 250 caracteres",min=0,max=250)
	@Column(name = "descripcion", nullable = false, length = 250)
	private String descripcion;
	
	@NotNull(message="El icono del modulo no puede estar vacio")
	@Length(message="El icono del modulo no puede exceder los 150 caracteres",min=0,max=150)
	@Column(name = "icono", nullable = false, length = 150)
	private String icono;
	
	@NotNull(message="El estado del modulo no puede estar vacio")
	@Column(name = "estado", nullable = false)
	private Integer estado;
	
	@NotNull(message="La raiz del modulo no puede estar vacio")
	@Length(message="La raiz del modulo no puede exceder los 50 caracteres",min=0,max=50)
	@Column(name = "raiz", nullable = false, length = 50)
	private String raiz;
	
	@NotNull(message="El orden del modulo no puede estar vacio")
	@Column(name = "orden", nullable = false)
	private Integer orden;
	
	@OneToMany(mappedBy = "modulo", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Pagina> lspagina;

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getRaiz() {
		return raiz;
	}

	public void setRaiz(String raiz) {
		this.raiz = raiz;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public List<Pagina> getLspagina() {
		return lspagina;
	}

	public void setLspagina(List<Pagina> lspagina) {
		this.lspagina = lspagina;
	}	

	
}
