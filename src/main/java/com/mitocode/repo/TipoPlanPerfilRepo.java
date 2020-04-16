package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Perfil;
import com.mitocode.model.TipoPlanilla;
import com.mitocode.model.TipoPlanillaPerfil;

public interface TipoPlanPerfilRepo extends JpaRepository<TipoPlanillaPerfil, Integer> {
	
	List<TipoPlanillaPerfil> findByPerfil(Perfil perfil);
	List<TipoPlanillaPerfil> findByTipoPlanilla(TipoPlanilla tipoPlanilla);
	
}

