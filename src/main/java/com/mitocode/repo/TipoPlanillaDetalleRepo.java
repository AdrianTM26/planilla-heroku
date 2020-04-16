package com.mitocode.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.TipoPlanilla;
import com.mitocode.model.TipoPlanillaDetalle;
import com.mitocode.model.Trabajador;

public interface TipoPlanillaDetalleRepo extends JpaRepository<TipoPlanillaDetalle, Integer> {

	/*@Query(value="DELETE FROM tipoplanilla_trabajador\r\n" + 
			" WHERE id_tipo_planilla =:idTipoPlanilla", nativeQuery = true)
	void eliminarPorTipPlan(@Param("idTipoPlanilla") Integer idTipoPlanilla);*/
	void deleteByTipoPlanilla(TipoPlanilla tipPlan);
	public Boolean existsByTipoPlanilla(TipoPlanilla tipPlan);
	public Boolean existsByTrabajador(Trabajador trab);
	public List<TipoPlanillaDetalle> findByTipoPlanilla(TipoPlanilla tipPlan);
	public Boolean existsByTrabajadorAndTipoPlanilla(Trabajador trab, TipoPlanilla tipPlan);
}
