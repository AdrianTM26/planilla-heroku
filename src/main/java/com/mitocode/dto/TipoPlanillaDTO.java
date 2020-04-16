package com.mitocode.dto;

import java.util.List;

import com.mitocode.model.Empresa;
import com.mitocode.model.Perfil;
import com.mitocode.model.TipoPlanilla;
import com.mitocode.model.TipoPlanillaDetalle;
import com.mitocode.model.TipoPlanillaPerfil;
import com.mitocode.model.Trabajador;

public class TipoPlanillaDTO {
	
	private TipoPlanilla tipoPlanilla;
	private List<Perfil> lsPerfil;
	private List<Trabajador> lsTrabajador;
	private List<TipoPlanillaPerfil> lsTipoPlanillaPerfil;
	private List<TipoPlanillaDetalle> lsTipoPlanillaDetalle;
	private Empresa empresa;
	
	public TipoPlanilla getTipoPlanilla() {
		return tipoPlanilla;
	}
	public void setTipoPlanilla(TipoPlanilla tipoPlanilla) {
		this.tipoPlanilla = tipoPlanilla;
	}
	public List<Perfil> getLsPerfil() {
		return lsPerfil;
	}
	public void setLsPerfil(List<Perfil> lsPerfil) {
		this.lsPerfil = lsPerfil;
	}
	public List<Trabajador> getLsTrabajador() {
		return lsTrabajador;
	}
	public void setLsTrabajador(List<Trabajador> lsTrabajador) {
		this.lsTrabajador = lsTrabajador;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public List<TipoPlanillaPerfil> getLsTipoPlanillaPerfil() {
		return lsTipoPlanillaPerfil;
	}
	public void setLsTipoPlanillaPerfil(List<TipoPlanillaPerfil> lsTipoPlanillaPerfil) {
		this.lsTipoPlanillaPerfil = lsTipoPlanillaPerfil;
	}
	public List<TipoPlanillaDetalle> getLsTipoPlanillaDetalle() {
		return lsTipoPlanillaDetalle;
	}
	public void setLsTipoPlanillaDetalle(List<TipoPlanillaDetalle> lsTipoPlanillaDetalle) {
		this.lsTipoPlanillaDetalle = lsTipoPlanillaDetalle;
	}
	
}
