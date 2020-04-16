package com.mitocode.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.Rhe;
import com.mitocode.model.Trabajador;


public interface RheRepo extends JpaRepository<Rhe, Integer> {
	
	@Query(value="select * from rhe where id_trabajador =:idTrabajador order by id_pdo_ano DESC, id_pdo_mes DESC FETCH NEXT 5 ROWS ONLY ",nativeQuery = true)
	List<Rhe> listarRhe(@Param("idTrabajador") Integer idTrabajador);
	
	Rhe findByIdRhe (Integer id);
	
	List<Rhe> findByTrabajador(Trabajador trab);
	
	List<Rhe> findByTrabajadorAndPdoAnoAndPdoMes (Trabajador trab, PdoAno pdoAno, PdoMes pdoMes);

}
