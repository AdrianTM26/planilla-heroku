package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.TipoDoc;
import com.mitocode.repo.TipoDocRepo;
import com.mitocode.service.TipoDocService;

@Service
public class TipoDocServiceImpl implements TipoDocService {
	
	@Autowired
	TipoDocRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public TipoDoc registrar(TipoDoc obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoDoc modificar(TipoDoc obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoDoc leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoDoc> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarTipoDocumento. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
