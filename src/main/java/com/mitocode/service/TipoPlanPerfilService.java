package com.mitocode.service;

import java.util.List;

import com.mitocode.model.TipoPlanilla;
import com.mitocode.model.TipoPlanillaPerfil;

public interface TipoPlanPerfilService extends ICRUD<TipoPlanillaPerfil> {
	List<TipoPlanillaPerfil> listarPorTipoPlanilla(TipoPlanilla tipoPlanilla);
	
}
