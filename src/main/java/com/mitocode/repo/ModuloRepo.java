package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.Modulo;

public interface ModuloRepo extends JpaRepository<Modulo, Integer> {
	
	@Query(value="select distinct m.* from modulo m inner join pagina p on p.id_modulo = m.id_modulo\r\n" + 
			"							inner join perfiles_pagina pp	on pp.id_pagina = p.id_pagina\r\n" +  
			"where pp.id_perfil = :idperfil order by m.orden ;", nativeQuery = true)
	List<Modulo> listarModuloPorPerfil(@Param("idperfil") Integer idperfil);

}
