package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.TipoContrato;
import com.mitocode.repo.TipoContratoRepo;
import com.mitocode.service.TipoContratoService;

@Service
public class TipoContratoServiceImpl implements TipoContratoService{

	@Autowired
	TipoContratoRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public TipoContrato registrar(TipoContrato obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoContrato modificar(TipoContrato obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoContrato leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoContrato> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarTipoContrato. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
