package com.mitocode.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Contrato;
import com.mitocode.model.TipoPlanilla;
import com.mitocode.model.TipoPlanillaDetalle;
import com.mitocode.model.Trabajador;
import com.mitocode.repo.TipoPlanillaDetalleRepo;
import com.mitocode.service.TipoPlanillaDetalleService;

@Service
public class TipoPlanillaDestalleServiceImpl implements TipoPlanillaDetalleService {

	@Autowired
	TipoPlanillaDetalleRepo repo;

	@Override
	public TipoPlanillaDetalle registrar(TipoPlanillaDetalle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoPlanillaDetalle modificar(TipoPlanillaDetalle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoPlanillaDetalle leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoPlanillaDetalle> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	// @Transactional
	@Override
	public Boolean eliminar(TipoPlanilla tipPlan) {
		Boolean resp = repo.existsByTipoPlanilla(tipPlan);
		if (resp) {
			repo.deleteByTipoPlanilla(tipPlan);
			resp = repo.existsByTipoPlanilla(tipPlan);
		}
		return resp;
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Boolean eliminarTPD(List<TipoPlanillaDetalle> lstipPlanDet) {
		Boolean resp= null;
		for (TipoPlanillaDetalle tpd : lstipPlanDet) {
			repo.deleteById(tpd.getIdTipoPlanillaDetalle());
			resp = repo.existsById(tpd.getIdTipoPlanillaDetalle());
			if (resp) {break;}
		}
		return resp;
	}

	@Override
	public List<Trabajador> armarListTrab(List<Trabajador> lstrab) {
		List<Trabajador> lstrabajador = new ArrayList<>();

		for (Trabajador trabajador : lstrab) {
			trabajador.setEstado(false);
			Boolean exist = repo.existsByTrabajador(trabajador);
			if (!exist) {
				lstrabajador.add(trabajador);
			}
		}
		return lstrabajador;
	}

	@Override
	public List<TipoPlanillaDetalle> listarTrabAsignados(TipoPlanilla tipPlan) {
		List<TipoPlanillaDetalle> lstipPlanDet = repo.findByTipoPlanilla(tipPlan);
		return lstipPlanDet;
	}

	@Override
	public List<Contrato> armarListContrato(List<Contrato> lsCont, TipoPlanilla tipPlan) {
		List<Contrato> lsContrato = new ArrayList<>();
		for(Contrato contrato: lsCont) {
			Boolean exist = repo.existsByTrabajadorAndTipoPlanilla(contrato.getTrabajador(),tipPlan);
			if(exist) {
				lsContrato.add(contrato);
			}
		}
		return lsContrato;
	}

}
