package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Categoria;
import com.mitocode.model.Empresa;
import com.mitocode.repo.CategoriaRepo;
import com.mitocode.repo.ContratoRepo;
import com.mitocode.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepo repo;
	
	@Autowired ContratoRepo repoContrato;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public Categoria registrar(Categoria obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarCategoria. ERROR : " + e.getMessage()+ e.getLocalizedMessage());
			
			throw e;
		}
	}

	@Override
	public Categoria modificar(Categoria obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " modificarCategoria. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Categoria leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Integer id) {
		try {
			repo.deleteById(id);
			Boolean resp = repo.existsById(id);
			return resp;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " eliminarCategoria. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Categoria> listarXEmpresa(Empresa empresa) {
		try {
			return repo.findByEmpresa(empresa);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarCategoriaXEmpresa. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Categoria buscarCatXDes(String categoria) {
		try {
			
		return repo.findCategoriaByDescripcion(categoria);
		
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName() + " buscarCategoriaPorDescripcion. ERROR : " + e.getMessage());
			throw e;
		}
	}

}
