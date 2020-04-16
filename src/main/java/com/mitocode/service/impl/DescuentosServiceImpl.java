package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Descuentos;
import com.mitocode.model.Empresa;
import com.mitocode.repo.DescuentosRepo;
import com.mitocode.service.DescuentosService;
import com.mitocode.util.Constantes;

@Service
public class DescuentosServiceImpl implements DescuentosService {

	@Autowired
	DescuentosRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public Descuentos registrar(Descuentos obj) {
		try {
		return repo.save(obj);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarDescuento. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Descuentos modificar(Descuentos obj) {
		try {
		return repo.save(obj);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName() + " modificarDescuento. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Descuentos leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Descuentos> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Descuentos darBaja(Descuentos obj) {
		try {
		obj.setEstado(0);
		return repo.save(obj);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName() + " darBajaDescuento. ERROR : " + e.getMessage());
			throw e;
		}
	}
	
	@Override
	public Descuentos activar(Descuentos obj) {
		try {
		obj.setEstado(1);
		return repo.save(obj);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName() + " activarDescuento. ERROR : " + e.getMessage());
			throw e;
		}
	}
	
	@Override
	public List<Descuentos> listarXEmpresa(Empresa emp) {
		try {
		return repo.findByEmpresaAndEstado(emp, Constantes.ConsActivo);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarDescuentosPorEmpresa. ERROR : " + e.getMessage());
			throw e;
		}
	}
	
	@Override
	public List<Descuentos> listarXEmpresaInac(Empresa emp) {
		try {
		return repo.findByEmpresaAndEstado(emp, Constantes.ConsInActivo);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarDescuentosInactivosPorEmpresa. ERROR : " + e.getMessage());
			throw e;
		}
	}

}
