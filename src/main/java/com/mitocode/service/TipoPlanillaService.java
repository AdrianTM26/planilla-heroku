package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Empresa;
import com.mitocode.model.Perfil;
import com.mitocode.model.TipoPlanilla;
import com.mitocode.model.TipoPlanillaDetalle;
import com.mitocode.model.TipoPlanillaPerfil;
import com.mitocode.model.Trabajador;

public interface TipoPlanillaService extends ICRUD<TipoPlanilla>{
	
	List<TipoPlanilla> listarPorEmpresa(Empresa empresa);
	List<TipoPlanillaDetalle> registrarTrabajadores(List<Trabajador> lsTrabajador, TipoPlanilla tipoPlanilla);
	TipoPlanilla encontrarTipPlan(TipoPlanilla tipPlan);
	List<TipoPlanilla> listarPorPerfil(Perfil perfil);

}
