package com.mitocode.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Afp;
import com.mitocode.model.Empresa;
import com.mitocode.model.Eps;
import com.mitocode.model.Parametro;
import com.mitocode.model.TipoPermiso;
import com.mitocode.repo.AfpRepo;
import com.mitocode.repo.EmpresaRepo;
import com.mitocode.repo.EpsRepo;
import com.mitocode.repo.ParametroRepo;
import com.mitocode.repo.TipoPermisoRepo;
import com.mitocode.service.EmpresaService;
import com.mitocode.util.Constantes;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepo repo;
	
	@Autowired
	private ParametroRepo repo_para;
	
	@Autowired
	private AfpRepo repo_afp;
	
	@Autowired
	private EpsRepo repo_eps;
	
	@Autowired
	private TipoPermisoRepo repo_tipoPermiso;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
 
	@Override
	public Empresa registrar(Empresa obj) {
		try {
			Date fecha_hoy=new Date();
			Timestamp tm_fec_hoy=new Timestamp(fecha_hoy.getTime());
			Empresa res_emp = new Empresa();
			obj.setFechaRegistro(tm_fec_hoy);
			obj.setEstado(Constantes.ConsActivo);
			res_emp = repo.save(obj);
			

			Afp res_afp = guardarAfpDefecto(res_emp);
			
			List<Eps> tmp_eps = new ArrayList<>();
			Eps eps1 = this.crearEps("COLSANITAS PERU S.A.  EPS",0.0225,obj);
			Eps eps2 = this.crearEps("MAPFRE PERU S.A. EPS",0.0225,obj);
			Eps eps3 = this.crearEps("PACÍFICO S.A. EPS",0.0225,obj);
			Eps eps4 = this.crearEps("PERSALUD S.A. EPS",0.0225,obj);
			Eps eps5 = this.crearEps("RÍMAC INTERNACIONAL S.A. EPS",0.0225,obj);
			Eps eps6 = this.crearEps("SERVICIOS PROPIOS",0.0225,obj);
			tmp_eps.add(eps1);
			tmp_eps.add(eps2);
			tmp_eps.add(eps3);
			tmp_eps.add(eps4);
			tmp_eps.add(eps5);
			tmp_eps.add(eps6);
			repo_eps.saveAll(tmp_eps);
			
			List<TipoPermiso> tmp_permisos = new ArrayList<>();
			TipoPermiso tp1 = this.CrearTipoPermiso("Maternidad",true,98,obj);
			TipoPermiso tp2 = this.CrearTipoPermiso("Paternidad caso Parto Normal/Cesarea",true,10,obj);
			TipoPermiso tp3 = this.CrearTipoPermiso("Paternidad caso Parto Prematuro/Multpile",true,20,obj);
			TipoPermiso tp4 = this.CrearTipoPermiso("Paternidad caso Complicaciones Graves en Madre/Hijo",true,30,obj);
			TipoPermiso tp5 = this.CrearTipoPermiso("Fallecimiento",true,null,obj);
			TipoPermiso tp6 = this.CrearTipoPermiso("Descanso Médico",true,null,obj);
			tmp_permisos.add(tp1);
			tmp_permisos.add(tp2);
			tmp_permisos.add(tp3);
			tmp_permisos.add(tp4);
			tmp_permisos.add(tp5);
			tmp_permisos.add(tp6);
			repo_tipoPermiso.saveAll(tmp_permisos);
			
		
			for (int i = 0; i < Constantes.ConstarEmpr; i++) {
				
				Parametro p = new Parametro();
				
				switch (i) {
				/**
				 * En este primer case se agrega el Salario minimo vital
				 */
				case 0:
					p.setDescripcion(Constantes.DESSALMINVIT);
					p.setCodigo(Constantes.CODSALMINVIT);
					p.setValor(Constantes.VALSALMINVIT);
					p.setEstado(1);
					p.setGrupo(Constantes.GRPEMPRESA);
					p.setNombre(Constantes.DESSALMINVIT);
					p.setEmpresa(res_emp);
					repo_para.save(p);
					break;
				/**
				 * En el segundo case se agrega la Aportacion EsSalud
				 */
				case 1:
					p.setDescripcion(Constantes.DESESSALUD);
					p.setCodigo(Constantes.CODESSALUD);
					p.setValor(Constantes.VALESSALUD);
					p.setEstado(1);
					p.setGrupo(Constantes.GRPEMPRESA);
					p.setNombre(Constantes.DESESSALUD);
					p.setEmpresa(res_emp);
					repo_para.save(p);
					break;

				/**
				 * En el tercer case se agrega la Unidad Impositiva Tributaria
				 */
				case 2:
					p.setDescripcion(Constantes.DESUIT);
					p.setCodigo(Constantes.CODUIT);
					p.setValor(Constantes.VALUIT);
					p.setEstado(1);
					p.setGrupo(Constantes.GRPEMPRESA);
					p.setNombre(Constantes.DESUIT);
					p.setEmpresa(res_emp);
					repo_para.save(p);
					break;

				/**
				 * En el cuarto case se agrega la Bonificacion Extraordinaria Ley 29351
				 */
				case 3:
					p.setDescripcion(Constantes.DESBONEXT29351);
					p.setCodigo(Constantes.CODBONEXT29351);
					p.setValor(Constantes.VALBONEXT29351);
					p.setEstado(1);
					p.setGrupo(Constantes.GRPEMPRESA);
					p.setNombre(Constantes.DESBONEXT29351);
					p.setEmpresa(res_emp);
					repo_para.save(p);
					break;

				/**
				 * En el quinto case se agrega el Monto de EsSalud+Vida
				 */
				case 4:
					p.setDescripcion(Constantes.DESESSALUDVIDA);
					p.setCodigo(Constantes.CODESSALUDVIDA);
					p.setValor(Constantes.VALESSALUDVIDA);
					p.setEstado(1);
					p.setGrupo(Constantes.GRPEMPRESA);
					p.setNombre(Constantes.DESESSALUDVIDA);
					p.setEmpresa(res_emp);
					repo_para.save(p);
					break;
				/**
				 * En el sexto case se agrega el procentaje de ONP
				 */
				case 5:
					p.setDescripcion(Constantes.DESPORCONP);
					p.setCodigo(Constantes.CODPORCONP);
					p.setValor(Constantes.VALPORCONP);
					p.setEstado(1);
					p.setGrupo(Constantes.GRPEMPRESA);
					p.setNombre(Constantes.DESPORCONP);
					p.setEmpresa(res_emp);
					repo_para.save(p);
					break;
				/**
				 * En el septimo case se agrega las horas de jornada laboral
				*/
				case 6:
					p.setDescripcion(Constantes.DESHORTRAB);
					p.setCodigo(Constantes.CODHORTRAB);
					p.setValor(Constantes.VALHORTRAB);
					p.setEstado(1);
					p.setGrupo(Constantes.GRPEMPRESA);
					p.setNombre(Constantes.DESHORTRAB);
					p.setEmpresa(res_emp);
					repo_para.save(p);
					break;
				
				case 7:
					p.setDescripcion(Constantes.DESTIPTARD);
					p.setCodigo(Constantes.CODTIPTARD);
					p.setValor(Constantes.VALTIPTARD);
					p.setEstado(1);
					p.setGrupo(Constantes.GRPEMPRESA);
					p.setNombre(Constantes.DESTIPTARD);
					p.setEmpresa(res_emp);
					repo_para.save(p);
					break;
					
				case 8:
					p.setDescripcion(Constantes.DESTARCNTDIAS);
					p.setCodigo(Constantes.CODTARCNTDIAS);
					p.setValor(Constantes.VALTARCNTDIAS);
					p.setEstado(1);
					p.setGrupo(Constantes.GRPEMPRESA);
					p.setNombre(Constantes.DESTARCNTDIAS);
					p.setEmpresa(res_emp);
					repo_para.save(p);
					break;
					
				case 9:
					p.setDescripcion(Constantes.DESTIPORANGO);
					p.setCodigo(Constantes.CODTIPORANGO);
					p.setValor(Constantes.VALTIPORANGO);
					p.setEstado(0);
					p.setGrupo(Constantes.GRPEMPRESA);
					p.setNombre(Constantes.DESTIPORANGO);
					p.setEmpresa(res_emp);
					repo_para.save(p);
					break;
				
				case 10:
					Integer id_onp = res_afp.getIdAfp();
					p.setDescripcion(Constantes.DESONP);
					p.setCodigo(Constantes.CODONP);
					p.setValor(String.valueOf(id_onp));
					p.setEstado(0);
					p.setGrupo(Constantes.GRPEMPRESA);
					p.setNombre(Constantes.DESONP);
					p.setEmpresa(res_emp);
					repo_para.save(p);
					break;

				default:
					break;
				}
			}
			return res_emp;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarEmpresa. ERROR : " + e.getMessage());
			throw e;
		}
	}
	
	
	@Override
	public Empresa modificar(Empresa obj) {
		try {
			return repo.save(obj);
		}catch(Exception e){
			LOG.error(this.getClass().getSimpleName()+" modificarEmpresa. ERROR : "+e.getMessage());
			throw e;
		}
	}
	
	
	@Override
	public List<Empresa> listar() {
		try {
			return repo.findAll();
		}catch(Exception e){
			LOG.error(this.getClass().getSimpleName()+" listarEmpresa. ERROR : "+e.getMessage());
			throw e;
		}
	}
	

	@Override
	public Empresa leer(Integer id) {
		Optional<Empresa> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Empresa();
	}
	
	
	@Override
	public Boolean eliminar(Integer id) {
		try {
			Boolean resp = repo.existsById(id);
			repo.deleteById(id);
			return resp;
			
		}catch(Exception e){
			LOG.error(this.getClass().getSimpleName()+" eliminarEmpresa. ERROR : "+e.getMessage());
			throw e;
		}
	}

	
	@Override
	public Empresa buscarXRuc(String ruc) {
		try {		
			return repo.findByRuc(ruc);
		}catch(Exception e){
			LOG.error(this.getClass().getSimpleName()+" buscarEmpresaXRuc. ERROR : "+e.getMessage());
			throw e;
		}
	}
	
	
	@Override
	public Empresa buscarXRazonSocial(String razonSocial) {
		try {		
			return repo.findByRazonSocial(razonSocial);
		}catch(Exception e){
			LOG.error(this.getClass().getSimpleName()+" buscarEmpresaXRazonSocial. ERROR : "+e.getMessage());
			throw e;
		}
	}
	
	private Eps crearEps(String descripcion, Double aporte, Empresa empresa) {
		Eps e = new Eps();
		e.setDescripcion(descripcion);
		e.setAporte(aporte);
		e.setEmpresa(empresa);
		
		return e;
	}
	
	private TipoPermiso CrearTipoPermiso(String des, boolean estado, Integer dias, Empresa emp) {
		TipoPermiso tp = new TipoPermiso();
		tp.setDescripcion(des);
		tp.setDiasPermiso(dias);
		tp.setEstado(estado);
		tp.setEmpresa(emp);
		return tp;
	}
	
	public Afp guardarAfpDefecto(Empresa empresa) {
		Afp afp = new Afp();
		afp.setApoOblFndPen(0.13);
		afp.setComAnuSobSal(0.0);
		afp.setComSobFlu(0.0);
		afp.setComSobFluMix(0.0);
		afp.setDescripcion("ONP");
		afp.setPrimaSeguro(0.0);
		afp.setEmpresa(empresa);
		
		return repo_afp.save(afp);
		
	}

}
