package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.AdelantoSueldo;
import com.mitocode.model.Cargo;
import com.mitocode.model.CuotaAdelanto;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;

public interface CuotaAdelantoRepo extends JpaRepository<CuotaAdelanto, Integer>{
	
	public List<CuotaAdelanto> findByAdelantoSueldo(AdelantoSueldo adeSue);
	
	public CuotaAdelanto findByIdCuotaAdelanto (Integer id);
		
	@Query(value="select ca.id_cuota_adelanto, ca.estado, ca.monto_cuota, ca.id_adelando_sueldo, ca.id_pdo_ano, ca.id_pdo_mes from adelanto_sueldo ad \r\n" + 
			"						Inner Join cuota_adelanto ca on ca.id_adelando_sueldo = ad.id_adelanto_sueldo \r\n" + 
			"						Inner Join trabajador tr on tr.id_trabajador = ad.id_trabajador \r\n" + 
			"						where tr.id_trabajador=:idtrabajador AND ca.id_pdo_ano=:idpdoano AND ca.id_pdo_mes= :idpdomes", nativeQuery = true)
	List<CuotaAdelanto> listarxTrabPAnoPMes(@Param("idtrabajador") Integer idTrabajador, @Param("idpdoano") Integer idPdoAno, @Param("idpdomes") Integer idPdoMes);

}
