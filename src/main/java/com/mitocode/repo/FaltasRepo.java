package com.mitocode.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Falta;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.Trabajador;

public interface FaltasRepo extends JpaRepository<Falta,Integer> {
	
	List<Falta> findByTrabajadorAndPdoAnoAndPdoMesOrderByFechaAsc(Trabajador trabajador,PdoAno pdoAno, PdoMes pdoMes);
	Boolean existsByFechaAndTrabajador(Date fecha,Trabajador trabajador);

}
