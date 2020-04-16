package com.mitocode.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.Contrato;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.PlanillaHistorico;

public interface PlanillaHistoricaRepo extends JpaRepository<PlanillaHistorico, Integer>{
		
	@Query(value="select  * from planilla_historico where id_pdo_ano = :idPdoAno and id_pdo_mes = :idPdoMes",nativeQuery = true)
	PlanillaHistorico obtenerPlanilla(@Param("idPdoAno") Integer idAno, @Param("idPdoMes") Integer idMes);
	
	PlanillaHistorico findByPdoAnoAndPdoMesAndContrato(PdoAno pdoAno, PdoMes pdoMes, Contrato contrato);
	
	@Query(value="select * from planilla_historico where id_contrato =:idContrato order by id_pdo_ano DESC, id_pdo_mes DESC FETCH NEXT 5 ROWS ONLY ",nativeQuery = true)
	List<PlanillaHistorico> listarBoletas(@Param("idContrato") Integer idContrato);
	
	@Query(value="select * from planilla_historico where id_contrato =:idContrato and rem_grati !=0 and id_pdo_ano = :idAno and id_pdo_mes =:idMes",nativeQuery=true)
	PlanillaHistorico obtenerPlanGrati(@Param("idContrato") Integer idContrato,@Param("idAno") Integer idAno, @Param("idMes") Integer idMes);
}
