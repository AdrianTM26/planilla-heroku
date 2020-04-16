package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.TipoPago;
import com.mitocode.repo.TipoPagoRepo;
import com.mitocode.service.TipoPagoService;

@Service
public class TipoPagoServiceImpl implements TipoPagoService{

	@Autowired
	TipoPagoRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public TipoPago registrar(TipoPago obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoPago modificar(TipoPago obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoPago leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoPago> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarTipoPago. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
