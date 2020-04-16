package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TipoPlanillaPerfil {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idTipoPlanillaPerfil;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_planilla")
	private TipoPlanilla tipoPlanilla;
	
	@ManyToOne
	@JoinColumn(name = "id_perfil")
	private Perfil perfil;
	
	@Column(nullable = false)
	private Integer estado;
	
	public Integer getIdTipoPlanillaPerfil() {
		return idTipoPlanillaPerfil;
	}
	public void setIdTipoPlanillaPerfil(Integer idTipoPlanillaPerfil) {
		this.idTipoPlanillaPerfil = idTipoPlanillaPerfil;
	}
	public TipoPlanilla getTipoPlanilla() {
		return tipoPlanilla;
	}
	public void setTipoPlanilla(TipoPlanilla tipoPlanilla) {
		this.tipoPlanilla = tipoPlanilla;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
}
