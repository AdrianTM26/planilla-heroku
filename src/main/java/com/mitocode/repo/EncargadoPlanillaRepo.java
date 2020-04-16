package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Empresa;
import com.mitocode.model.EncargadoPlanilla;

public interface EncargadoPlanillaRepo extends JpaRepository<EncargadoPlanilla, Integer>{
	
	List<EncargadoPlanilla> findByEmpresaAndEstado(Empresa emp, Integer estado);
	
	EncargadoPlanilla findByIdEncargadoPlanilla(Integer id);
}
