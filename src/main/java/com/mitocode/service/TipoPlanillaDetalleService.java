package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Contrato;
import com.mitocode.model.TipoPlanilla;
import com.mitocode.model.TipoPlanillaDetalle;
import com.mitocode.model.Trabajador;

public interface TipoPlanillaDetalleService extends ICRUD<TipoPlanillaDetalle> {

	Boolean eliminar(TipoPlanilla tipPlan);

	List<Trabajador> armarListTrab(List<Trabajador> lstrab);
	
	List<Contrato> armarListContrato(List<Contrato> lsCont, TipoPlanilla tipPlan);
 
	List<TipoPlanillaDetalle> listarTrabAsignados(TipoPlanilla tipPlan);

	Boolean eliminarTPD(List<TipoPlanillaDetalle> lstipPlanDet);

}
