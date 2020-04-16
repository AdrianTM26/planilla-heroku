package com.mitocode.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Empresa;
import com.mitocode.model.PdoAno;

public interface PdoAnoRepo extends JpaRepository<PdoAno, Integer>{
	
	List<PdoAno> findByEmpresa(Empresa empresa);
	
	PdoAno findByEmpresaAndDescripcion(Empresa empresa,Integer descripcion);
	
	PdoAno findByIdPdoAno (Integer id);
	
	Boolean existsByEmpresaAndDescripcion(Empresa empresa, Integer descripcion);
	
	
}
