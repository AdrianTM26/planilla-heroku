package com.mitocode.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Perfil;
import com.mitocode.model.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
	
	public Usuario findByUsername(String username);
	public Usuario findByPerfil(Perfil perfil);
	}
