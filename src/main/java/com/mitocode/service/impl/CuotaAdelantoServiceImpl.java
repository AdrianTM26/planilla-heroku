package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.AdelantoSueldo;
import com.mitocode.model.CuotaAdelanto;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.Trabajador;
import com.mitocode.repo.CuotaAdelantoRepo;
import com.mitocode.service.CuotaAdelantoService;

@Service
public class CuotaAdelantoServiceImpl implements CuotaAdelantoService{
	
	@Autowired
	CuotaAdelantoRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public CuotaAdelanto registrar(CuotaAdelanto obj) {
		try {
		return repo.save(obj);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" registrarAdelantoSueldo. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public CuotaAdelanto modificar(CuotaAdelanto obj) {
		try {
		return repo.save(obj);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" modificarAdelantoSueldo. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public CuotaAdelanto leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CuotaAdelanto> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<CuotaAdelanto> listarXAdeSue(AdelantoSueldo adeSue) {
		try {
			
		return repo.findByAdelantoSueldo(adeSue);
		
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarCuotaPorAdelantoSueldo. ERROR : "+e.getMessage());
			throw e;
		}
	}
	
	@Override
	public CuotaAdelanto Pagado(CuotaAdelanto obj) {
		try {
		obj.setEstado(1);
		return repo.save(obj);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" pagarAdelantoSueldo. ERROR : "+e.getMessage());
			throw e;
		}
	}
	
	@Override
	public List<CuotaAdelanto> listarXTrabPAnoPMes(Trabajador trab, PdoAno pdoAno, PdoMes pdoMes) {
		try {
		return repo.listarxTrabPAnoPMes(trab.getIdTrabajador(), pdoAno.getIdPdoAno(), pdoMes.getIdPdoMes());
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarAdelantoSueldoPorTrabajadorAnoMes. ERROR : "+e.getMessage());
			throw e;
		}
	}
	
	@Override
	public CuotaAdelanto EncontrarCuoAde(Integer id) {
		try {
		return repo.findByIdCuotaAdelanto(id);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" encontrarCuotaAdelanto. ERROR : "+e.getMessage());
			throw e;
		}
	}

}
