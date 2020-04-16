package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Empresa;
import com.mitocode.model.TipoPlanilla;

public interface TipoPlanillaRepo extends JpaRepository<TipoPlanilla, Integer> {
	
	List<TipoPlanilla> findByEmpresa(Empresa empresa);
	TipoPlanilla findByIdTipoPlanilla(Integer id);
}
