package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mitocode.model.Empresa;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.repo.PdoAnoRepo;
import com.mitocode.repo.PdoMesRepo;
import com.mitocode.service.AnoMesService;
import com.mitocode.util.Constantes;

@Service
public class AnoMesServiceImpl implements AnoMesService{

	@Autowired
	PdoAnoRepo repo_ano;
	
	@Autowired
	PdoMesRepo repo_mes;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public List<PdoAno> listarPorEmpresa(Empresa empresa) {
		try {
			return repo_ano.findByEmpresa(empresa);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarPorEmpresa. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean registrarAnoDefecto(Empresa emp) {
		try {
			Integer año_actual=emp.getFechaRegistro().getYear()+Constantes.ConstAnosDate;
			Integer año_inicial=año_actual-Constantes.CantRngAnosDefault;
			Integer año_final=año_actual+Constantes.CantRngAnosDefault;
			for(int i=año_inicial;i<=año_final;i++) {
				PdoAno tmp_ano = new PdoAno();
				tmp_ano.setDescripcion(i);
				tmp_ano.setEmpresa(emp);
				repo_ano.save(tmp_ano);
			}
			return true;
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" registrarAnoDefecto. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public List<PdoMes> listarMeses() {
		try {
			return repo_mes.findAll(new Sort(Sort.Direction.ASC, "idPdoMes"));
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarMeses. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public PdoAno registrar(PdoAno obj) {
		try {
			
			return repo_ano.save(obj);	
			
		}catch(Exception e) {
			
			LOG.error(this.getClass().getSimpleName()+" registrarAño. ERROR : "+e.getMessage());
			throw e;
			
		}
	}

	@Override
	public PdoAno modificar(PdoAno obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PdoAno leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PdoAno> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PdoAno buscarSiExistePorDesc(Empresa emp, PdoAno ano) {
		
		try {
			return repo_ano.findByEmpresaAndDescripcion(emp,ano.getDescripcion());
				
		}catch(Exception e) {
			
			LOG.error(this.getClass().getSimpleName()+" buscarSiExistePorDescripcion. ERROR : "+e.getMessage());
			throw e;
			
		}
	}

	@Override
	public PdoMes ModificarMes(PdoMes pdomes) {
		try {
			return repo_mes.save(pdomes);
				
		}catch(Exception e) {
			
			LOG.error(this.getClass().getSimpleName()+" modificarMes. ERROR : "+e.getMessage());
			throw e;
			
		}
	}
	
	@Override
	public PdoMes encontrarMes(Integer id) {
		try {
			return repo_mes.findByIdPdoMes(id);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" encontrarMes. ERROR : "+e.getMessage());
			throw e;
		}
	}
	
	@Override
	public PdoAno encontrarAno(Integer id) {
		try {
			return repo_ano.findByIdPdoAno(id);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" encontrarAño. ERROR : "+e.getMessage());
			throw e;
		}
	}

}
