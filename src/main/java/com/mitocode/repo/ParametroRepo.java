package com.mitocode.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import com.mitocode.model.Empresa;
import com.mitocode.model.Parametro;

public interface ParametroRepo extends JpaRepository<Parametro, Integer>  {
	
	Parametro findByCodigoAndEmpresa(String codigo, Empresa emp);

	List<Parametro> findByEstadoAndEmpresa(Integer estado, Empresa emp);
	
	Parametro findByNombre(String nombre);
	
	Parametro findByCodigoAndGrupo(String coddiascomptbase, String grpglobal);

	Parametro findByCodigoAndGrupoAndEmpresa(String coddiascomptbase, String grpglobal, Empresa emp);

}
