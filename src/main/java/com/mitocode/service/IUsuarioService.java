package com.mitocode.service;

import com.mitocode.model.Perfil;
import com.mitocode.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario>{
	
	public Usuario findbyUsername(String username);
	public Usuario findbyPerfil(Perfil perfil);
}
