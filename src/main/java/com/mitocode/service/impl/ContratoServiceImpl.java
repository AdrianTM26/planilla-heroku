package com.mitocode.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Categoria;
import com.mitocode.model.Contrato;
import com.mitocode.model.Empresa;
import com.mitocode.repo.ContratoRepo;
import com.mitocode.service.ContratoService;


@Service
public class ContratoServiceImpl implements ContratoService {

	
	@Autowired
	private ContratoRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public Contrato registrar(Contrato obj) {
		try{
			Date fechaHoy = new Date();
			Timestamp fechaFirma = new Timestamp(fechaHoy.getTime());
			obj.setFechaFirma(fechaFirma);
			return repo.save(obj);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" registrarContrato. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Contrato modificar(Contrato obj) {
		try {
			Date fechaHoy = new Date();
			Timestamp fechaFirma = new Timestamp(fechaHoy.getTime());
			obj.setFechaFirma(fechaFirma);
			return repo.save(obj);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" modificarContrato. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Contrato leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contrato> listar() {
		return repo.findAll();
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contrato> listarPorEmpresa(Empresa empresa) {
		try {
			return repo.listarPorEmpresa(empresa.getIdEmpresa());
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarPorEmpresa. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Contrato> eliminarCategoriaPorContrato(Categoria categoria) {
		
		try {
			List<Contrato> listContratos= repo.findByCategoria(categoria);
			if(listContratos!=null) {
				for(Contrato c: listContratos) {
					c.setCategoria(null);
					c.setCargo(null);  
					repo.save(c);
				}
			}
			
			return listContratos;
			
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" modificarContrato. ERROR : "+e.getMessage());
			throw e;
		}
		
	}

	@Override
	public List<Contrato> listarPorEmpresaYTipoComp(Empresa empresa, Integer tipoComp) {
		try {
			return repo.listarPorEmpresaYTipoComprobante(empresa.getIdEmpresa(), tipoComp);
			
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarPortipoComp. ERROR : "+e.getMessage());
			throw e;
		}
	}
	
	@Override
	public List<Contrato> listarPorEmpresayCuartaCat(Empresa empresa) {
		try {
			return repo.listarPorEmpresaYCuartaCat(empresa.getIdEmpresa(), 2);	
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarPortipoComp. ERROR : "+e.getMessage());
			throw e;
		}
	}

}
