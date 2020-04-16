package com.mitocode.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.icu.text.SimpleDateFormat;
import com.mitocode.dto.Planilla;
import com.mitocode.dto.PlanillaDTO;
import com.mitocode.model.Afp;
import com.mitocode.model.Contrato;
import com.mitocode.model.Empresa;
import com.mitocode.model.Parametro;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.PlanillaHistorico;
import com.mitocode.repo.AfpRepo;
import com.mitocode.repo.ContratoRepo;
import com.mitocode.repo.ParametroRepo;
import com.mitocode.repo.PdoAnoRepo;
import com.mitocode.repo.PdoMesRepo;
import com.mitocode.repo.PlanillaHistoricaRepo;
import com.mitocode.service.PlanillaHistoricoService;
import com.mitocode.util.Constantes;

@Service
public class PlanillaHistoricoServiceImpl implements PlanillaHistoricoService {

	@Autowired
	PlanillaHistoricaRepo repo;

	@Autowired
	ContratoRepo repoContrato;

	@Autowired
	ParametroRepo repoParametro;

	@Autowired
	PdoMesRepo repoPdoMes;

	@Autowired
	PdoAnoRepo repoPdoAno;

	@Autowired
	AfpRepo repoAfp;

	@Autowired
	PlanillaHistoricaRepo repoPlanilla;

	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public PlanillaHistorico registrar(PlanillaHistorico obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarPlanillaHistorico. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public PlanillaHistorico modificar(PlanillaHistorico obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanillaHistorico leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanillaHistorico> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Integer id) {
		try {
			Boolean resp = repo.existsById(id);
			repo.deleteById(id);
			return resp;

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " eliminarBoleta. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoMovTotal(PlanillaDTO planillaDTO) {
		try {
			Parametro par = new Parametro();
			Double res_mov_tot = 0.00, mov_diaria = 0.00;
			par = repoParametro.findByCodigoAndGrupo(Constantes.CODDIASCOMPTBASE, Constantes.GRPGLOBAL);
			mov_diaria = (planillaDTO.getContrato().getMovilidad() / Double.parseDouble(par.getValor()));
			res_mov_tot = mov_diaria * planillaDTO.getPlanilla().getDias_computables();
			return res_mov_tot;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoMovilidadTotal. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoHorExtra25(PlanillaDTO planillaDTO) {
		try {
			Double res_ho_ext25 = 0.00, fact_ho_ext25 = 0.00;
			fact_ho_ext25 = planillaDTO.getPlanilla().getHo_extra25() * 1.25;
			res_ho_ext25 = planillaDTO.getContrato().getValorHora() * fact_ho_ext25;
			return res_ho_ext25;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoHorExtra25. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoHorExtra35(PlanillaDTO planillaDTO) {
		try {
			Double res_ho_ext35 = 0.00, fact_ho_ext35 = 0.00;
			fact_ho_ext35 = planillaDTO.getPlanilla().getHo_extra35() * 1.35;
			res_ho_ext35 = fact_ho_ext35 * planillaDTO.getContrato().getValorHora();
			return res_ho_ext35;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoHorExtra35. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoRemJorNorm(PlanillaDTO planillaDTO, boolean ctsAgrario) {
		try {
			Parametro par_dias = repoParametro.findByCodigoAndGrupo(Constantes.CODDIASCOMPTBASE, Constantes.GRPGLOBAL);
			Double res_jor_bas = 0.00, tmp_por_dia = 0.00;
			tmp_por_dia = planillaDTO.getContrato().getSueldoBase() / Double.parseDouble(par_dias.getValor());
			res_jor_bas = tmp_por_dia * planillaDTO.getPlanilla().getDias_computables();
			if (!ctsAgrario) {
				return res_jor_bas;
			} else {
				Parametro sal_min = repoParametro.findByCodigoAndEmpresa(Constantes.CODSALMINVIT,
						planillaDTO.getContrato().getTrabajador().getEmpresa());
				Double sal_min_vitalxDia = Double.parseDouble(sal_min.getValor())
						/ Double.parseDouble(par_dias.getValor());
				Double cts_pormes = Double.parseDouble(
						repoParametro.findByCodigoAndGrupo(Constantes.CODCTSAGRARIO, Constantes.GRPGLOBAL).getValor());
				Double cts_valorxDia = cts_pormes - sal_min_vitalxDia;
				Planilla planilla = planillaDTO.getPlanilla();
				return res_jor_bas + cts_valorxDia * (planilla.getDias_computables());
			}

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoRemuneracionJornalNormal. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoAsigFam(PlanillaDTO planillaDTO) {
		try {
			Integer num_hijos = planillaDTO.getContrato().getTrabajador().getNroHij();
			Parametro par = new Parametro();
			par = repoParametro.findByCodigoAndEmpresa(Constantes.CODSALMINVIT,
					planillaDTO.getContrato().getTrabajador().getEmpresa());
			Double asig_fami = Double.parseDouble(par.getValor()) * 0.1;
			if (num_hijos > 0) {
				return asig_fami;
			} else {
				return 0.00;
			}

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoAsignacionFamiliar. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoRemDiaFerdoLabo(PlanillaDTO planillaDTO) {
		try {

			Parametro param = new Parametro();
			param = repoParametro.findByCodigoAndGrupo(Constantes.CODDIASCOMPTBASE, Constantes.GRPGLOBAL);
			Double dias_comp = Double.parseDouble(param.getValor());
			Double remFrdo_labo = (planillaDTO.getContrato().getSueldoBase() / dias_comp)
					* planillaDTO.getPlanilla().getFerdo_laborad() * 2;
			return remFrdo_labo;

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoRemuneracionDiaFeriadoLaborado. ERROR : "
					+ e.getMessage());
			throw e;

		}
	}

	@Override
	public Double calculoRemDiaVaca(PlanillaDTO planillaDTO) {
		try {
			Parametro param = new Parametro();
			param = repoParametro.findByCodigoAndGrupo(Constantes.CODDIASCOMPTBASE, Constantes.GRPGLOBAL);
			Double dias_comp = Double.parseDouble(param.getValor());
			Planilla planilla = planillaDTO.getPlanilla();
			Double remVaca = (planillaDTO.getContrato().getSueldoBase() / dias_comp) * planilla.getDias_vacaciones();
			return remVaca;

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoRemuneracionDiaVaca. ERROR : " + e.getMessage());
			throw e;

		}
	}

	@Override
	public Double calculoRemVacaVend(PlanillaDTO planillaDTO) {
		try {
			Parametro param = new Parametro();
			param = repoParametro.findByCodigoAndGrupo(Constantes.CODDIASCOMPTBASE, Constantes.GRPGLOBAL);
			Date fecha_actual = new Date();
			int mes_fecha_actual = fecha_actual.getMonth() + 1;
			Date fecha_inicio = planillaDTO.getContrato().getFecInicio();
			int mes_fecha_inicio = fecha_inicio.getMonth();
			int semestre_acumulado = 0;
			/*
			 * if(fecha_actual.getYear()>fecha_inicio.getYear()) {
			 * 
			 * for(int i =fecha_inicio.getYear();i < fecha_actual.getYear();i++) {
			 * semestre_acumulado = semestre_acumulado+2; }
			 * 
			 * if(mes_fecha_actual<mes_fecha_inicio) {
			 * 
			 * semestre_acumulado--; }
			 * 
			 * }else {
			 * 
			 * }
			 */
			Double dias_comp = Double.parseDouble(param.getValor());
			Planilla planilla = planillaDTO.getPlanilla();
			Double remVacaVend = (planillaDTO.getContrato().getSueldoBase() / dias_comp)
					* planilla.getVacaciones_vend();
			return remVacaVend;

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoRemuneracionVacaVendida. ERROR : " + e.getMessage());
			throw e;

		}
	}

	@Override
	public Double calculoRemFerdo(PlanillaDTO planillaDTO) {
		try {
			Parametro param = new Parametro();
			param = repoParametro.findByCodigoAndGrupo(Constantes.CODDIASCOMPTBASE, Constantes.GRPGLOBAL);
			Double dias_comp = Double.parseDouble(param.getValor());
			PdoMes pdo_mes_obj = repoPdoMes.getOne(planillaDTO.getPlanilla().getPdo_mes().getIdPdoMes());
			Double remFrdo = (planillaDTO.getContrato().getSueldoBase() / dias_comp)
					* pdo_mes_obj.getDiasFeriadoCalend();
			return remFrdo;

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoRemuneracionFerdo. ERROR : " + e.getMessage());
			throw e;

		}
	}

	@Override
	public Double calculoDsctComSobFLuMix(PlanillaDTO planillaDTO, Double total_comp) {
		try {
			Parametro param = new Parametro();
			param = repoParametro.findByCodigoAndEmpresa(Constantes.CODONP,
					planillaDTO.getContrato().getTrabajador().getEmpresa());
			Integer id_afp = Integer.parseInt(param.getValor());
			Afp res_afp = repoAfp.getOne(id_afp);
			String es_onp = res_afp.getDescripcion();
			Afp tmp_afp = planillaDTO.getContrato().getTrabajador().getAfp();

			if (es_onp.compareToIgnoreCase(tmp_afp.getDescripcion()) == 0) {
				return 0.00;
			} else {
				return tmp_afp.getComSobFluMix() * total_comp;
			}
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoDsctComSobFluMix. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoMonDiasInjusti(PlanillaDTO planillaDTO) {
		try {
			Parametro param = new Parametro();
			param = repoParametro.findByCodigoAndGrupo(Constantes.CODDIASCOMPTBASE, Constantes.GRPGLOBAL);
			Integer dias_comp = Integer.parseInt(param.getValor());
			Double monto_pordia = planillaDTO.getContrato().getSueldoBase() / dias_comp;
			Double monto_injusti_pordia = monto_pordia / 30;

			return (monto_injusti_pordia) * planillaDTO.getPlanilla().getFaltas_injusti();
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoMonDiasInjustificados. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoMonTardanza(PlanillaDTO planillaDTO) {
		try {
			Parametro paramTipoTard = new Parametro();
			Parametro paramTardxDia = new Parametro();
			Parametro paramTardxRang = new Parametro();
			Double sueld_pordia = planillaDTO.getContrato().getSueldoBase() / 30;
			Double sueld_porminuto = (sueld_pordia / 24) / 60;
			Double mon_tard = 0.0;

			paramTipoTard = repoParametro.findByCodigoAndEmpresa(Constantes.CODTIPTARD,
					planillaDTO.getContrato().getTrabajador().getEmpresa());
			paramTardxDia = repoParametro.findByCodigoAndEmpresa(Constantes.CODTARCNTDIAS,
					planillaDTO.getContrato().getTrabajador().getEmpresa());
			paramTardxRang = repoParametro.findByCodigoAndEmpresa(Constantes.CODTIPORANGO,
					planillaDTO.getContrato().getTrabajador().getEmpresa());

			Integer valor_tipo = Integer.parseInt(paramTipoTard.getValor());
			Integer valor_rang = Integer.parseInt(paramTardxRang.getValor());
			switch (valor_tipo) {

			case 1:
				Integer valor_tarxDia = Integer.parseInt(paramTardxDia.getValor());

				mon_tard = (double) Math.round(planillaDTO.getPlanilla().getTardanzas() / valor_tarxDia);

				return mon_tard * sueld_pordia;

			case 2:
				switch (valor_rang) {

				case 1:
					return planillaDTO.getPlanilla().getTardanzas() * sueld_porminuto;

				case 2:
					Double rango = (double) planillaDTO.getPlanilla().getTardanzas() % 10;
					if (planillaDTO.getPlanilla().getTardanzas() == 0) {
						return 0.0;
					} else {
						return sueld_porminuto * (rango + 1) * 10;
					}

				default:
					return null;

				}

			default:
				return null;
			}
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoMontoTardanza. ERROR : " + e.getMessage());
			throw e;
		}

	}

	@Override
	public Double calculoDsctComSobFLu(PlanillaDTO planillaDTO, Double total_comp) {
		try {
			Parametro param = new Parametro();
			param = repoParametro.findByCodigoAndEmpresa(Constantes.CODONP,
					planillaDTO.getContrato().getTrabajador().getEmpresa());
			Integer id_afp = Integer.parseInt(param.getValor());
			Afp res_afp = repoAfp.getOne(id_afp);
			String es_onp = res_afp.getDescripcion();
			Afp tmp_afp = planillaDTO.getContrato().getTrabajador().getAfp();

			if (es_onp.compareToIgnoreCase(tmp_afp.getDescripcion()) == 0) {

				return 0.00;

			} else {

				return tmp_afp.getComSobFlu() * total_comp;

			}
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoDsctoComSobfLu. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoDsctSctr(PlanillaDTO planillaDTO) {
		try {
			if (planillaDTO.getContrato().getTrabajador().getRegSalud() != null) {
				return null;

			} else {
				return 0.09;
			}
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoDsctSctr. ERROR : " + e.getMessage());
			throw e;
		}

	}

	@Override
	public Double calculoRemGrat(PlanillaDTO planillaDTO, boolean activar_hora_actual) throws Exception {
		try {
			Date periodo1Ini = new Date();
			Date periodo1Fin = new Date();
			Date periodo2Ini = new Date();
			Date periodo2Fin = new Date();

			Parametro param1INI = repoParametro.findByCodigoAndGrupo(Constantes.CODGRATIPERIODO1INI,
					Constantes.GRPGLOBAL);
			Parametro param1FIN = repoParametro.findByCodigoAndGrupo(Constantes.CODGRATIPERIODO1FIN,
					Constantes.GRPGLOBAL);
			Parametro param2INI = repoParametro.findByCodigoAndGrupo(Constantes.CODGRATIPERIODO2INI,
					Constantes.GRPGLOBAL);
			Parametro param2FIN = repoParametro.findByCodigoAndGrupo(Constantes.CODGRATIPERIODO2FIN,
					Constantes.GRPGLOBAL);

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Integer pdo_ano = planillaDTO.getPlanilla().getPdo_ano().getDescripcion();

			String fechaPeriodo1Ini = pdo_ano + "-" + param1INI.getValor();
			String fechaPeriodo1Fin = pdo_ano + "-" + param1FIN.getValor();
			String fechaPeriodo2Ini = pdo_ano + "-" + param2INI.getValor();
			String fechaPeriodo2Fin = pdo_ano + "-" + param2FIN.getValor();

			periodo1Ini = formatter.parse(fechaPeriodo1Ini);
			periodo1Fin = formatter.parse(fechaPeriodo1Fin);
			periodo2Ini = formatter.parse(fechaPeriodo2Ini);
			periodo2Fin = formatter.parse(fechaPeriodo2Fin);

			Double comp = 0.0, grati_mes = 0.0, grati_dia = 0.0;
			Double comp_prom = 0.0, comp_prom_dia = 0.0, comp_prom_mes = 0.0, rem_hrs25 = 0.0, rem_hrs35 = 0.0,
					rem_vaca_vend = 0.0, rem_comi = 0.0;
			Integer meses_hrs25 = 0, meses_hrs35 = 0, meses_vaca_vend = 0, meses_comi = 0, meses_periodo = 0;
			Date fecha_inicio = planillaDTO.getContrato().getFecInicio();
			int mes_fecha_inicio = fecha_inicio.getMonth() + 1;
			int year_fecha_inicio = fecha_inicio.getYear() + 1900;
			int fecha_pdo_mes = planillaDTO.getPlanilla().getPdo_mes().getIdPdoMes();
			Integer ano_actual = planillaDTO.getPlanilla().getPdo_ano().getDescripcion();
			Integer faltas_injus = 0, faltas_jus = 0;

			if (fecha_pdo_mes == 12 && !activar_hora_actual && year_fecha_inicio < ano_actual) {
				fecha_inicio.setYear(fecha_inicio.getYear() + 1);
			}

			if (fecha_pdo_mes == 7) {

				for (int i = periodo1Ini.getMonth() + 1; i <= periodo1Fin.getMonth() + 1; i++) {
					PlanillaHistorico plan = repoPlanilla
							.obtenerPlanilla(planillaDTO.getPlanilla().getPdo_ano().getIdPdoAno(), i);
					if (plan != null) {
						meses_periodo++;
						comp = plan.getContrato().getSueldoBase() + plan.getRemDiaFerdoLabo() + plan.getAsigFam();
						faltas_injus = faltas_injus + plan.getFaltaInjusti();
						faltas_jus = faltas_jus + plan.getFaltaJusti();

						if (plan.getRemHoExt25() != 0) {
							meses_hrs25++;
							rem_hrs25 = rem_hrs25 + plan.getRemHoExt25();
						}
						if (plan.getRemHoExt35() != 0) {
							meses_hrs35++;
							rem_hrs35 = rem_hrs35 + plan.getRemHoExt35();
						}
						if (plan.getRemVacaVend() != 0) {
							meses_vaca_vend++;
							rem_vaca_vend = rem_vaca_vend + plan.getRemVacaVend();
						}
						if (plan.getRemComisiones() != 0) {
							meses_comi++;
							rem_comi = rem_comi + plan.getRemComisiones();
						}

						comp_prom = comp_prom + comp;
					}
				}
				if (meses_hrs25 >= 3)
					comp_prom = comp_prom + rem_hrs25;
				if (meses_hrs35 >= 3)
					comp_prom = comp_prom + rem_hrs35;
				if (meses_vaca_vend >= 3)
					comp_prom = comp_prom + rem_vaca_vend;
				if (meses_comi >= 3)
					comp_prom = comp_prom + rem_comi;

				comp_prom = comp_prom / meses_periodo;
				comp_prom_mes = comp_prom / 6;
				comp_prom_dia = comp_prom_mes / 30;

				if (fecha_pdo_mes == mes_fecha_inicio && ano_actual == year_fecha_inicio) {

					return 0.00;

				} else {

					if (mes_fecha_inicio >= periodo1Ini.getMonth() + 1 && year_fecha_inicio < ano_actual) {

						return comp_prom;

					} else {

						if (fecha_inicio.getDate() == 30 || fecha_inicio.getDate() == 31) {

							grati_mes = ((periodo1Fin.getMonth() + 1) - mes_fecha_inicio) * comp_prom_mes;
							grati_dia = comp_prom_dia;// 1dia

						} else {

							grati_mes = ((periodo1Fin.getMonth() + 1) - mes_fecha_inicio) * comp_prom_mes;
							grati_dia = (31 - fecha_inicio.getDate()) * comp_prom_dia;// n dias
						}

						return grati_mes + grati_dia;
					}
				}

			} else if (fecha_pdo_mes == 12) {

				for (int i = periodo2Ini.getMonth() + 1; i <= periodo2Fin.getMonth() + 1; i++) {
					PlanillaHistorico plan = repoPlanilla
							.obtenerPlanilla(planillaDTO.getPlanilla().getPdo_ano().getIdPdoAno(), i);
					if (plan != null) {
						meses_periodo++;
						comp = plan.getContrato().getSueldoBase() + plan.getRemDiaFerdoLabo() + plan.getAsigFam();
						faltas_injus = faltas_injus + plan.getFaltaInjusti();
						faltas_jus = faltas_jus + plan.getFaltaJusti();

						if (plan.getRemHoExt25() != 0) {
							meses_hrs25++;
							rem_hrs25 = rem_hrs25 + plan.getRemHoExt25();
						}
						if (plan.getRemHoExt35() != 0) {
							meses_hrs35++;
							rem_hrs35 = rem_hrs35 + plan.getRemHoExt35();
						}
						if (plan.getRemVacaVend() != 0) {
							meses_vaca_vend++;
							rem_vaca_vend = rem_vaca_vend + plan.getRemVacaVend();
						}
						if (plan.getRemComisiones() != 0) {
							meses_comi++;
							rem_comi = rem_comi + plan.getRemComisiones();
						}

						comp_prom = comp_prom + comp;
					}
				}
				if (meses_hrs25 >= 3)
					comp_prom = comp_prom + rem_hrs25;
				if (meses_hrs35 >= 3)
					comp_prom = comp_prom + rem_hrs35;
				if (meses_vaca_vend >= 3)
					comp_prom = comp_prom + rem_vaca_vend;
				if (meses_comi >= 3)
					comp_prom = comp_prom + rem_comi;

				comp_prom = comp_prom / meses_periodo;
				comp_prom_mes = comp_prom / 6;
				comp_prom_dia = comp_prom_mes / 30;

				if (fecha_pdo_mes == mes_fecha_inicio && ano_actual == year_fecha_inicio) {

					return 0.00;

				} else {

					if (mes_fecha_inicio < periodo2Ini.getMonth() + 1 || year_fecha_inicio < ano_actual) {

						return comp_prom;

					} else {

						if (fecha_inicio.getDate() == 30 || fecha_inicio.getDate() == 31) {

							grati_mes = ((periodo2Fin.getMonth() + 1) - mes_fecha_inicio) * comp_prom_mes;
							grati_dia = comp_prom_dia;
						} else {
							grati_mes = ((periodo2Fin.getMonth() + 1) - mes_fecha_inicio) * comp_prom_mes;
							grati_dia = (30 - fecha_inicio.getDate()) * comp_prom_dia;
						}

						return grati_mes + grati_dia;
					}
				}

			} else
				return 0.0;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoRemGrati. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoCTSDefault(PlanillaDTO planillaDTO) throws Exception {
		try {
			PdoMes pdomes_julio = new PdoMes();
			pdomes_julio.setIdPdoMes(7);
			pdomes_julio.setAbrev("JUL");
			pdomes_julio.setDescripcion("JULIO");
			pdomes_julio.setDiasFeriadoCalend(2);
			PdoMes pdomes_diciembre = new PdoMes();
			pdomes_diciembre.setIdPdoMes(12);
			pdomes_diciembre.setAbrev("DIC");
			pdomes_diciembre.setDescripcion("DICIEMBRE");
			pdomes_diciembre.setDiasFeriadoCalend(2);

			Date periodo1Ini = new Date();
			Date periodo1Fin = new Date();
			Date periodo2Ini = new Date();
			Date periodo2Fin = new Date();

			Parametro param1INI = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO1INI,
					Constantes.GRPGLOBAL);
			Parametro param1FIN = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO1FIN,
					Constantes.GRPGLOBAL);
			Parametro param2INI = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO2INI,
					Constantes.GRPGLOBAL);
			Parametro param2FIN = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO2FIN,
					Constantes.GRPGLOBAL);

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Integer pdo_ano = planillaDTO.getPlanilla().getPdo_ano().getDescripcion();
			String pdo_ano_next = String.valueOf(planillaDTO.getPlanilla().getPdo_ano().getDescripcion() + 1);

			String fechaPeriodo1Ini = pdo_ano + "-" + param1INI.getValor();
			String fechaPeriodo1Fin = pdo_ano + "-" + param1FIN.getValor();
			String fechaPeriodo2Ini = pdo_ano + "-" + param2INI.getValor();
			String fechaPeriodo2Fin = pdo_ano_next + "-" + param2FIN.getValor();

			try {
				periodo1Ini = formatter.parse(fechaPeriodo1Ini);
				periodo1Fin = formatter.parse(fechaPeriodo1Fin);
				periodo2Ini = formatter.parse(fechaPeriodo2Ini);
				periodo2Fin = formatter.parse(fechaPeriodo2Fin);
			} catch (ParseException e) {
				LOG.error(this.getClass().getSimpleName() + " calculoCTSDefault. ERROR : " + e.getMessage());
				throw e;
			}
			PlanillaHistorico plan_grati = new PlanillaHistorico();
			boolean sinPlanGrati = false;
			Double rem_grati = 0.0;
			Double rem_cts = 0.0, comp = 0.0;
			Double comp_prom = 0.0, rem_hrs25 = 0.0, rem_hrs35 = 0.0, rem_vaca_vend = 0.0, rem_comi = 0.0;
			Integer meses_hrs25 = 0, meses_hrs35 = 0, meses_vaca_vend = 0, meses_comi = 0, meses_periodo = 0,
					dias_periodo = 0;
			Date fecha_inicio = planillaDTO.getContrato().getFecInicio();
			int mes_fecha_inicio = fecha_inicio.getMonth() + 1;
			int year_fecha_inicio = fecha_inicio.getYear() + 1900;
			int fecha_pdo_mes = planillaDTO.getPlanilla().getPdo_mes().getIdPdoMes();
			Integer ano_actual = planillaDTO.getPlanilla().getPdo_ano().getDescripcion();
			Integer faltas_injus = 0, faltas_jus = 0;
			Empresa empresa = planillaDTO.getContrato().getTrabajador().getEmpresa();

			if (fecha_pdo_mes == periodo1Fin.getMonth() + 2) {

				Integer ano = planillaDTO.getPlanilla().getPdo_ano().getDescripcion() - 1;
				PdoAno grati_ano = repoPdoAno.findByEmpresaAndDescripcion(empresa, ano);

				if (year_fecha_inicio < ano_actual) {
					if (mes_fecha_inicio != 12) {
						plan_grati = repo.obtenerPlanGrati(planillaDTO.getContrato().getIdContrato(),
								grati_ano.getIdPdoAno(), 12);
					} else {
						plan_grati = repo.obtenerPlanGrati(planillaDTO.getContrato().getIdContrato(),
								planillaDTO.getPlanilla().getPdo_ano().getIdPdoAno(), 7);
					}

				} else {
					if (mes_fecha_inicio < 6) {
						plan_grati = repo.obtenerPlanGrati(planillaDTO.getContrato().getIdContrato(),
								planillaDTO.getPlanilla().getPdo_ano().getIdPdoAno(), 7);
					} else {
						sinPlanGrati = true;
					}
				}
				if (!sinPlanGrati) {
					rem_grati = plan_grati.getRemGrati();
				}

				for (int i = periodo1Ini.getMonth() + 1; i <= periodo1Fin.getMonth() + 1; i++) {
					PlanillaHistorico plan = repoPlanilla
							.obtenerPlanilla(planillaDTO.getPlanilla().getPdo_ano().getIdPdoAno(), i);
					if (plan != null) {
						meses_periodo++;
						comp = plan.getContrato().getSueldoBase() + plan.getRemDiaFerdoLabo() + plan.getAsigFam();
						faltas_injus = faltas_injus + plan.getFaltaInjusti();
						faltas_jus = faltas_jus + plan.getFaltaJusti();

						if (plan.getRemHoExt25() != 0) {
							meses_hrs25++;
							rem_hrs25 = rem_hrs25 + plan.getRemHoExt25();
						}
						if (plan.getRemHoExt35() != 0) {
							meses_hrs35++;
							rem_hrs35 = rem_hrs35 + plan.getRemHoExt35();
						}
						if (plan.getRemVacaVend() != 0) {
							meses_vaca_vend++;
							rem_vaca_vend = rem_vaca_vend + plan.getRemVacaVend();
						}
						if (plan.getRemComisiones() != 0) {
							meses_comi++;
							rem_comi = rem_comi + plan.getRemComisiones();
						}

						comp_prom = comp_prom + comp;
					}
				}
				if (meses_hrs25 >= 3)
					comp_prom = comp_prom + rem_hrs25;
				if (meses_hrs35 >= 3)
					comp_prom = comp_prom + rem_hrs35;
				if (meses_vaca_vend >= 3)
					comp_prom = comp_prom + rem_vaca_vend;
				if (meses_comi >= 3)
					comp_prom = comp_prom + rem_comi;

				comp_prom = comp_prom / meses_periodo;

				if (fecha_pdo_mes == mes_fecha_inicio && year_fecha_inicio == ano_actual) {
					return 0.00;
				} else {
					if (mes_fecha_inicio < periodo1Ini.getMonth() + 1 || year_fecha_inicio < ano_actual) {
						rem_cts = (comp_prom + rem_grati / 6) / 2;
						rem_cts = rem_cts - ((rem_cts / meses_periodo) / 30) * (faltas_injus - faltas_jus);
						return rem_cts;
					} else {
						rem_cts = ((comp_prom + rem_grati / 6) / 360) * (periodo1Fin.getMonth() + 1 - mes_fecha_inicio)
								* 30;
						rem_cts = rem_cts - ((rem_cts / meses_periodo) / 30) * (faltas_injus - faltas_jus);
						return rem_cts;
					}

				}
			} else if (fecha_pdo_mes == periodo2Fin.getMonth() + 2) {

				Integer ano = planillaDTO.getPlanilla().getPdo_ano().getDescripcion() - 1;
				PdoAno grati_ano = repoPdoAno.findByEmpresaAndDescripcion(empresa, ano);

				if (year_fecha_inicio < ano_actual) {
					if (mes_fecha_inicio != 12) {
						plan_grati = repo.obtenerPlanGrati(planillaDTO.getContrato().getIdContrato(),
								grati_ano.getIdPdoAno(), 12);
					} else {
						sinPlanGrati = true;
					}
				} else {
					sinPlanGrati = true;
				}

				if (!sinPlanGrati) {
					rem_grati = plan_grati.getRemGrati();
				}

				for (int i = periodo2Ini.getMonth() + 1; i <= periodo2Fin.getMonth() + 13; i++) {
					PlanillaHistorico plan;
					if (i <= 12) {

						PdoAno for_ano_anterior = repoPdoAno.findByEmpresaAndDescripcion(empresa, ano);
						plan = repoPlanilla.obtenerPlanilla(for_ano_anterior.getIdPdoAno(), i);

					} else {
						plan = repoPlanilla.obtenerPlanilla(planillaDTO.getPlanilla().getPdo_ano().getIdPdoAno(),
								i - 12);
					}

					if (plan != null) {
						meses_periodo++;
						comp = plan.getContrato().getSueldoBase() + plan.getRemDiaFerdoLabo() + plan.getAsigFam();
						faltas_injus = faltas_injus + plan.getFaltaInjusti();
						faltas_jus = faltas_jus + plan.getFaltaJusti();

						if (plan.getRemHoExt25() != 0) {
							meses_hrs25++;
							rem_hrs25 = rem_hrs25 + plan.getRemHoExt25();
						}
						if (plan.getRemHoExt35() != 0) {
							meses_hrs35++;
							rem_hrs35 = rem_hrs35 + plan.getRemHoExt35();
						}
						if (plan.getRemVacaVend() != 0) {
							meses_vaca_vend++;
							rem_vaca_vend = rem_vaca_vend + plan.getRemVacaVend();
						}
						if (plan.getRemComisiones() != 0) {
							meses_comi++;
							rem_comi = rem_comi + plan.getRemComisiones();
						}

						comp_prom = comp_prom + comp;
					}
				}

				if (meses_hrs25 >= 3)
					comp_prom = comp_prom + rem_hrs25;
				if (meses_hrs35 >= 3)
					comp_prom = comp_prom + rem_hrs35;
				if (meses_vaca_vend >= 3)
					comp_prom = comp_prom + rem_vaca_vend;
				if (meses_comi >= 3)
					comp_prom = comp_prom + rem_comi;

				comp_prom = comp_prom / meses_periodo;

				if (fecha_pdo_mes == mes_fecha_inicio && year_fecha_inicio == ano_actual) {
					return 0.00;
				} else {
					if (year_fecha_inicio < ano_actual) {
						if (mes_fecha_inicio < 11) {
							rem_cts = (comp_prom + rem_grati / 6) / 2;
							rem_cts = rem_cts - ((rem_cts / meses_periodo) / 30) * (faltas_injus - faltas_jus);
							return rem_cts;
						} else {
							rem_cts = ((comp_prom + rem_grati / 6) / 360)
									* (periodo2Fin.getMonth() + 13 - mes_fecha_inicio) * 30;
							rem_cts = rem_cts - ((rem_cts / meses_periodo) / 30) * (faltas_injus - faltas_jus);
							return rem_cts;
						}
					} else {
						rem_cts = ((comp_prom + rem_grati / 6) / 360) * (periodo2Fin.getMonth() + 1 - mes_fecha_inicio)
								* 30;
						rem_cts = rem_cts - ((rem_cts / meses_periodo) / 30) * (faltas_injus - faltas_jus);
						return rem_cts;
					}
				}
			} else
				return 0.0;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoMonCTSDefault. ERROR : " + e.getMessage());
			throw e;
		}

	}

	@Override
	public Double calculoCTSConsCivil(PlanillaDTO planillaDTO, Double remJornal) throws Exception {

		try {
			Parametro param1INI = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO1INI,
					Constantes.GRPGLOBAL);
			Parametro param1FIN = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO1FIN,
					Constantes.GRPGLOBAL);
			Parametro param2INI = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO2INI,
					Constantes.GRPGLOBAL);
			Parametro param2FIN = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO2FIN,
					Constantes.GRPGLOBAL);

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Integer pdo_ano = planillaDTO.getPlanilla().getPdo_ano().getDescripcion();
			String pdo_ano_next = String.valueOf(planillaDTO.getPlanilla().getPdo_ano().getDescripcion() + 1);

			String fechaPeriodo1Ini = pdo_ano + "-" + param1INI.getValor();
			String fechaPeriodo1Fin = pdo_ano + "-" + param1FIN.getValor();
			String fechaPeriodo2Ini = pdo_ano + "-" + param2INI.getValor();
			String fechaPeriodo2Fin = pdo_ano_next + "-" + param2FIN.getValor();

			Date periodo1Ini = new Date();
			Date periodo1Fin = new Date();
			Date periodo2Ini = new Date();
			Date periodo2Fin = new Date();

			try {
				periodo1Ini = formatter.parse(fechaPeriodo1Ini);
				periodo1Fin = formatter.parse(fechaPeriodo1Fin);
				periodo2Ini = formatter.parse(fechaPeriodo2Ini);
				periodo2Fin = formatter.parse(fechaPeriodo2Fin);
			} catch (ParseException e) {
				LOG.error(this.getClass().getSimpleName() + " calculoCTSConsCivil ERROR : " + e.getMessage());
				throw e;
			}

			Date fecha_inicio = planillaDTO.getContrato().getFecInicio();
			int mes_fecha_inicio = fecha_inicio.getMonth() + 1;
			int year_fecha_inicio = fecha_inicio.getYear() + 1900;
			int dia_fecha_inicio = fecha_inicio.getDate();
			int fecha_pdo_mes = planillaDTO.getPlanilla().getPdo_mes().getIdPdoMes();
			int fecha_pdo_ano = planillaDTO.getPlanilla().getPdo_ano().getDescripcion();
			Double rem_jornalxDia = remJornal / planillaDTO.getPlanilla().getDias_computables();
			Double rem_cts_dias, rem_cts_mes;

			if (fecha_pdo_mes >= periodo1Ini.getMonth() + 2 && fecha_pdo_mes <= periodo1Fin.getMonth() + 2) {

				if (fecha_pdo_mes == periodo1Fin.getMonth() + 2) {
					if (year_fecha_inicio < fecha_pdo_ano) {
						return 6 * 0.15 * remJornal;
					} else {
						if (mes_fecha_inicio == fecha_pdo_mes && year_fecha_inicio == fecha_pdo_ano) {
							return 0.0;
						} else {
							if (dia_fecha_inicio == 30 || dia_fecha_inicio == 31) {
								rem_cts_mes = (10 - mes_fecha_inicio) * remJornal;
								rem_cts_dias = rem_jornalxDia;
								return 0.15 * (rem_cts_mes + rem_cts_dias);
							} else {
								rem_cts_mes = (10 - mes_fecha_inicio) * remJornal;
								rem_cts_dias = (planillaDTO.getPlanilla().getDias_computables() - dia_fecha_inicio)
										* rem_jornalxDia;
								return 0.15 * (rem_cts_mes + rem_cts_dias);
							}
						}
					}
				} else
					return 0.0;

			} else {
				if (fecha_pdo_mes == periodo2Fin.getMonth() + 2) {
					if (year_fecha_inicio < fecha_pdo_ano) {
						if (mes_fecha_inicio < periodo2Ini.getMonth() + 1) {
							return 6 * 0.15 * remJornal;
						} else {
							if (dia_fecha_inicio == 30 || dia_fecha_inicio == 31) {
								rem_cts_mes = (16 - mes_fecha_inicio) * remJornal;
								rem_cts_dias = rem_jornalxDia;
								return 0.15 * (rem_cts_mes + rem_cts_dias);
							} else {
								rem_cts_mes = (16 - mes_fecha_inicio) * remJornal;
								rem_cts_dias = (planillaDTO.getPlanilla().getDias_computables() - dia_fecha_inicio)
										* rem_jornalxDia;
								return 0.15 * (rem_cts_mes + rem_cts_dias);
							}
						}
					} else {

						if (mes_fecha_inicio == fecha_pdo_mes && year_fecha_inicio == fecha_pdo_ano) {
							return 0.0;
						} else {
							if (dia_fecha_inicio == 30 || dia_fecha_inicio == 31) {
								rem_cts_mes = (4 - mes_fecha_inicio) * remJornal;
								rem_cts_dias = rem_jornalxDia;
								return 0.15 * (rem_cts_mes + rem_cts_dias);
							} else {
								rem_cts_mes = (4 - mes_fecha_inicio) * remJornal;
								rem_cts_dias = (planillaDTO.getPlanilla().getDias_computables() - dia_fecha_inicio)
										* rem_jornalxDia;
								return 0.15 * (rem_cts_mes + rem_cts_dias);
							}
						}
					}
				} else
					return 0.0;
			}
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoCTSConsCivil. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoCTSTrabHogar(PlanillaDTO planillaDTO) throws Exception {
		try {
			Parametro param1INI = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO1INI,
					Constantes.GRPGLOBAL);
			Parametro param1FIN = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO1FIN,
					Constantes.GRPGLOBAL);
			Parametro param2INI = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO2INI,
					Constantes.GRPGLOBAL);
			Parametro param2FIN = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO2FIN,
					Constantes.GRPGLOBAL);

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Integer pdo_ano = planillaDTO.getPlanilla().getPdo_ano().getDescripcion();
			String pdo_ano_next = String.valueOf(planillaDTO.getPlanilla().getPdo_ano().getDescripcion() + 1);

			String fechaPeriodo1Ini = pdo_ano + "-" + param1INI.getValor();
			String fechaPeriodo1Fin = pdo_ano + "-" + param1FIN.getValor();
			String fechaPeriodo2Ini = pdo_ano + "-" + param2INI.getValor();
			String fechaPeriodo2Fin = pdo_ano_next + "-" + param2FIN.getValor();

			Date periodo1Ini = new Date();
			Date periodo1Fin = new Date();
			Date periodo2Ini = new Date();
			Date periodo2Fin = new Date();

			try {
				periodo1Ini = formatter.parse(fechaPeriodo1Ini);
				periodo1Fin = formatter.parse(fechaPeriodo1Fin);
				periodo2Ini = formatter.parse(fechaPeriodo2Ini);
				periodo2Fin = formatter.parse(fechaPeriodo2Fin);
			} catch (ParseException e) {
				LOG.error(this.getClass().getSimpleName() + " calculoCTSTrabHogar. ERROR : " + e.getMessage());
				throw e;
			}

			Date fecha_inicio = planillaDTO.getContrato().getFecInicio();
			int mes_fecha_inicio = fecha_inicio.getMonth() + 1;
			int year_fecha_inicio = fecha_inicio.getYear() + 1900;
			int fecha_pdo_mes = planillaDTO.getPlanilla().getPdo_mes().getIdPdoMes();
			int fecha_pdo_ano = planillaDTO.getPlanilla().getPdo_ano().getDescripcion();
			Double sueld_basxDia = planillaDTO.getContrato().getSueldoBase() / 30;

			if (fecha_pdo_mes >= periodo1Ini.getMonth() + 2 && fecha_pdo_mes <= periodo1Fin.getMonth() + 2) {

				if (fecha_pdo_mes == periodo1Fin.getMonth() + 2) {
					if (mes_fecha_inicio == periodo1Fin.getMonth() + 1 && year_fecha_inicio == fecha_pdo_ano) {
						return 0.0;
					} else {
						Double cts = 15 * sueld_basxDia
								* (12 * (fecha_pdo_ano - year_fecha_inicio) + 10 - mes_fecha_inicio) / 12;
						return cts;
					}
				} else
					return 0.0;

			} else if (fecha_pdo_mes == periodo2Fin.getMonth() + 2) {
				if (mes_fecha_inicio == periodo2Fin.getMonth() + 1 && year_fecha_inicio == fecha_pdo_ano) {
					return 0.0;
				} else {
					return 15 * sueld_basxDia * (12 * (fecha_pdo_ano - year_fecha_inicio) + 4 - mes_fecha_inicio) / 12;// Enero-Abril
				}
			} else
				return 0.0;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoCTSTrabHogar. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoCTSPequeEmp(PlanillaDTO planillaDTO) throws Exception {
		try {
			Parametro param1INI = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO1INI,
					Constantes.GRPGLOBAL);
			Parametro param1FIN = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO1FIN,
					Constantes.GRPGLOBAL);
			Parametro param2INI = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO2INI,
					Constantes.GRPGLOBAL);
			Parametro param2FIN = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO2FIN,
					Constantes.GRPGLOBAL);

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Integer pdo_ano = planillaDTO.getPlanilla().getPdo_ano().getDescripcion();
			String pdo_ano_next = String.valueOf(planillaDTO.getPlanilla().getPdo_ano().getDescripcion() + 1);

			String fechaPeriodo1Ini = pdo_ano + "-" + param1INI.getValor();
			String fechaPeriodo1Fin = pdo_ano + "-" + param1FIN.getValor();
			String fechaPeriodo2Ini = pdo_ano + "-" + param2INI.getValor();
			String fechaPeriodo2Fin = pdo_ano_next + "-" + param2FIN.getValor();

			Date periodo1Ini = new Date();
			Date periodo1Fin = new Date();
			Date periodo2Ini = new Date();
			Date periodo2Fin = new Date();

			try {
				periodo1Ini = formatter.parse(fechaPeriodo1Ini);
				periodo1Fin = formatter.parse(fechaPeriodo1Fin);
				periodo2Ini = formatter.parse(fechaPeriodo2Ini);
				periodo2Fin = formatter.parse(fechaPeriodo2Fin);
			} catch (ParseException e) {
				LOG.error(this.getClass().getSimpleName() + " calculoCTSPEqueEmp. ERROR : " + e.getMessage());
				throw e;
			}

			Date fecha_inicio = planillaDTO.getContrato().getFecInicio();
			int mes_fecha_inicio = fecha_inicio.getMonth() + 1;
			int year_fecha_inicio = fecha_inicio.getYear() + 1900;
			int fecha_pdo_mes = planillaDTO.getPlanilla().getPdo_mes().getIdPdoMes();
			int fecha_pdo_ano = planillaDTO.getPlanilla().getPdo_ano().getDescripcion();
			Double sueld_basxDia = planillaDTO.getContrato().getSueldoBase() / 30;
			Double dias_remunerados;

			if (fecha_pdo_mes >= periodo1Ini.getMonth() + 2 && fecha_pdo_mes <= periodo1Fin.getMonth() + 2) {

				if (fecha_pdo_mes == periodo1Fin.getMonth() + 2) {
					if (mes_fecha_inicio == periodo1Fin.getMonth() + 1 && year_fecha_inicio == fecha_pdo_ano) {
						return 0.0;
					} else {
						dias_remunerados = 15
								* (double) ((12 * (fecha_pdo_ano - year_fecha_inicio) + 10 - mes_fecha_inicio) / 12);
						if (dias_remunerados <= 90)
							return sueld_basxDia * dias_remunerados;
						else
							return sueld_basxDia * 90;
					}
				} else
					return 0.0;

			} else if (fecha_pdo_mes == periodo2Fin.getMonth() + 2) {
				if (mes_fecha_inicio == periodo2Fin.getMonth() + 1 && year_fecha_inicio == fecha_pdo_ano) {
					return 0.0;
				} else {
					dias_remunerados = 15
							* (double) ((12 * (fecha_pdo_ano - year_fecha_inicio) + 4 - mes_fecha_inicio) / 12);
					if (dias_remunerados <= 90)
						return sueld_basxDia * dias_remunerados;
					else
						return sueld_basxDia * 90;
				}
			} else
				return 0.0;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoCTSPequeEmp. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoCTSPesquero(PlanillaDTO planillaDTO, Double total_comp) throws Exception {
		try {
			Parametro param1INI = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO1INI,
					Constantes.GRPGLOBAL);
			Parametro param1FIN = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO1FIN,
					Constantes.GRPGLOBAL);
			Parametro param2INI = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO2INI,
					Constantes.GRPGLOBAL);
			Parametro param2FIN = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPERIODO2FIN,
					Constantes.GRPGLOBAL);
			Parametro paramCTS = repoParametro.findByCodigoAndGrupo(Constantes.CODCTSPESQUERO, Constantes.GRPGLOBAL);

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Integer pdo_ano = planillaDTO.getPlanilla().getPdo_ano().getDescripcion();
			String pdo_ano_next = String.valueOf(planillaDTO.getPlanilla().getPdo_ano().getDescripcion() + 1);

			String fechaPeriodo1Ini = pdo_ano + "-" + param1INI.getValor();
			String fechaPeriodo1Fin = pdo_ano + "-" + param1FIN.getValor();
			String fechaPeriodo2Ini = pdo_ano + "-" + param2INI.getValor();
			String fechaPeriodo2Fin = pdo_ano_next + "-" + param2FIN.getValor();

			Date periodo1Ini = new Date();
			Date periodo1Fin = new Date();
			Date periodo2Ini = new Date();
			Date periodo2Fin = new Date();

			try {
				periodo1Ini = formatter.parse(fechaPeriodo1Ini);
				periodo1Fin = formatter.parse(fechaPeriodo1Fin);
				periodo2Ini = formatter.parse(fechaPeriodo2Ini);
				periodo2Fin = formatter.parse(fechaPeriodo2Fin);
			} catch (ParseException e) {
				LOG.error(this.getClass().getSimpleName() + " calculoCTSPesquero. ERROR : " + e.getMessage());
				throw e;
			}

			int fecha_pdo_mes = planillaDTO.getPlanilla().getPdo_mes().getIdPdoMes();
			Double cts_valor = Double.parseDouble(paramCTS.getValor());
			Double cts_pordia = cts_valor * total_comp / planillaDTO.getPlanilla().getDias_computables();
			Planilla planilla = planillaDTO.getPlanilla();

			if (fecha_pdo_mes == periodo1Ini.getMonth() + 1 || fecha_pdo_mes == periodo2Ini.getMonth() + 1) {
				return cts_pordia * (planilla.getDias_computables());
			} else {
				return 0.0;
			}
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoCTSPesquero. ERROR : " + e.getMessage());
			throw e;
		}

	}

	@Override
	public Double calculo5taCategPorMes(PlanillaDTO planillaDTO, Integer mes_actual, Double retenc_mensual_total) {
		try {
			Parametro param = new Parametro();
			param = repoParametro.findByCodigoAndGrupo(Constantes.CODUIT, Constantes.GRPGLOBAL);
			Double uit = Double.parseDouble(param.getValor());
			Double sueld_base = planillaDTO.getContrato().getSueldoBase();
			Integer meses_rest = 12 - (mes_actual - 1);
			Double rem_mens_pro = sueld_base * meses_rest;
			Double grat_por_recib;
			Double bonif_extra = 0.0;
			grat_por_recib = sueld_base * 2;
			if (mes_actual >= 7 && mes_actual <= 12) {
				bonif_extra = sueld_base * 0.09;
			}
			if (mes_actual == 12) {
				bonif_extra = sueld_base * 0.18;
			}
			Double rem_perc_mesanter = sueld_base * (mes_actual - 1);
			Double rem_anua_proy = rem_mens_pro + grat_por_recib + rem_perc_mesanter + bonif_extra;
			Double ded_uit7 = uit * 7;
			Double impuesto_renta_proy;
			Double retenc_mensual;
			Double renta_neta_5ta = rem_anua_proy - ded_uit7;
			if (renta_neta_5ta <= 0) {
				return 0.0;
			} else {

				if (renta_neta_5ta <= Constantes.IMPUESTO1 * uit) {
					impuesto_renta_proy = renta_neta_5ta * Constantes.TASA1;
				} else if (renta_neta_5ta <= Constantes.IMPUESTO2 * uit) {
					impuesto_renta_proy = renta_neta_5ta * Constantes.TASA2;
				} else if (renta_neta_5ta <= Constantes.IMPUESTO3 * uit) {
					impuesto_renta_proy = renta_neta_5ta * Constantes.TASA3;
				} else if (renta_neta_5ta <= Constantes.IMPUESTO4 * uit) {
					impuesto_renta_proy = renta_neta_5ta * Constantes.TASA4;
				} else {
					impuesto_renta_proy = renta_neta_5ta * Constantes.TASA5;
				}

				switch (mes_actual) {

				case 2:
					retenc_mensual = (impuesto_renta_proy - retenc_mensual_total) / 12;
					return retenc_mensual;

				case 3:
					retenc_mensual = (impuesto_renta_proy - retenc_mensual_total) / 12;
					return retenc_mensual;

				case 4:
					retenc_mensual = (impuesto_renta_proy - retenc_mensual_total) / 9;
					return retenc_mensual;

				case 5:
					retenc_mensual = (impuesto_renta_proy - retenc_mensual_total) / 8;
					return retenc_mensual;

				case 6:
					retenc_mensual = (impuesto_renta_proy - retenc_mensual_total) / 8;
					return retenc_mensual;

				case 7:
					retenc_mensual = (impuesto_renta_proy - retenc_mensual_total) / 8;
					return retenc_mensual;

				case 8:
					retenc_mensual = (impuesto_renta_proy - retenc_mensual_total) / 5;
					return retenc_mensual;

				case 9:
					retenc_mensual = (impuesto_renta_proy - retenc_mensual_total) / 4;
					return retenc_mensual;

				case 10:
					retenc_mensual = (impuesto_renta_proy - retenc_mensual_total) / 4;
					return retenc_mensual;

				case 11:
					retenc_mensual = (impuesto_renta_proy - retenc_mensual_total) / 4;
					return retenc_mensual;

				case 12:
					retenc_mensual = (impuesto_renta_proy - retenc_mensual_total);
					return retenc_mensual;

				default:
					retenc_mensual = impuesto_renta_proy / 12;
					return retenc_mensual;
				}

			}
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculo5taCategPorMes. ERROR : " + e.getMessage());
			throw e;
		}

	}

	@Override
	public Double calculo5taCateg(PlanillaDTO planillaDTO, Integer mes_actual) {
		try {
			Double retenc_mensual_total1 = 0.0;
			Double retenc_mensual_total2 = 0.0;
			Double retenc_mensual_total3 = 0.0;
			Double total = 0.0;

			for (int i = 1; i <= mes_actual; i++) {
				switch (i) {
				case 1:
					total = calculo5taCategPorMes(planillaDTO, 1, 0.0);
					retenc_mensual_total1 = retenc_mensual_total1 + total;
					break;
				case 2:
					total = calculo5taCategPorMes(planillaDTO, 2, retenc_mensual_total1);
					retenc_mensual_total1 = retenc_mensual_total1 + total;
					break;
				case 3:
					total = calculo5taCategPorMes(planillaDTO, 3, retenc_mensual_total1);
					retenc_mensual_total1 = retenc_mensual_total1 + total;
					break;
				case 4:
					total = calculo5taCategPorMes(planillaDTO, 4, retenc_mensual_total1);
					retenc_mensual_total1 = retenc_mensual_total1 + total;
					break;
				case 5:
					total = calculo5taCategPorMes(planillaDTO, 5, retenc_mensual_total1);
					retenc_mensual_total2 = retenc_mensual_total2 + retenc_mensual_total1 + total;
					break;
				case 6:
					total = calculo5taCategPorMes(planillaDTO, 6, retenc_mensual_total1);
					retenc_mensual_total2 = retenc_mensual_total2 + total;
					break;
				case 7:
					total = calculo5taCategPorMes(planillaDTO, 7, retenc_mensual_total1);
					retenc_mensual_total2 = retenc_mensual_total2 + total;
					break;
				case 8:
					total = calculo5taCategPorMes(planillaDTO, 8, retenc_mensual_total2);
					retenc_mensual_total2 = retenc_mensual_total2 + total;
					break;
				case 9:
					total = calculo5taCategPorMes(planillaDTO, 9, retenc_mensual_total2);
					retenc_mensual_total3 = retenc_mensual_total3 + retenc_mensual_total2 + total;
					break;
				case 10:
					total = calculo5taCategPorMes(planillaDTO, 10, retenc_mensual_total2);
					retenc_mensual_total3 = retenc_mensual_total3 + total;
					break;
				case 11:
					total = calculo5taCategPorMes(planillaDTO, 11, retenc_mensual_total2);
					retenc_mensual_total3 = retenc_mensual_total3 + total;
					break;
				case 12:
					total = calculo5taCategPorMes(planillaDTO, 12, retenc_mensual_total3);
					retenc_mensual_total3 = retenc_mensual_total3 + total;
					break;
				}
			}
			return total;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculo5taCateg. ERROR : " + e.getMessage());
			throw e;
		}

	}

	@Override
	public Double calculoEssaludVida(PlanillaDTO planillaDTO) {
		try {
			Parametro par = new Parametro();
			Integer ess_flag = 0;
			par = repoParametro.findByCodigoAndEmpresa(Constantes.CODESSALUDVIDA,
					planillaDTO.getContrato().getTrabajador().getEmpresa());
			ess_flag = (planillaDTO.getContrato().getTrabajador().getEssaludVida());
			if (ess_flag == 0) {
				return 0.00;
			} else {
				return Double.parseDouble(par.getValor());
			}

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoEssaludVida. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoMonNocturno(PlanillaDTO planillaDTO) {
		try {
			Parametro par = new Parametro();
			par = repoParametro.findByCodigoAndGrupo(Constantes.CODDIASCOMPTBASE, Constantes.GRPGLOBAL);
			Integer dias_comp = Integer.parseInt(par.getValor());
			Double rmv = (planillaDTO.getContrato().getSueldoBase() / dias_comp)
					* planillaDTO.getPlanilla().getDias_computables();

			return 0.35 * rmv;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoMonNocturno. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoBonif29351(PlanillaDTO planillaDTO) throws Exception {
		try {
			Parametro param = new Parametro();
			param = repoParametro.findByCodigoAndEmpresa(Constantes.CODBONEXT29351,
					planillaDTO.getContrato().getTrabajador().getEmpresa());
			Double gratif = this.calculoRemGrat(planillaDTO, true);
			Double result = 0.0;
			Double bono = Double.parseDouble(param.getValor());
			if (gratif != 0) {
				result = gratif * bono;
			}

			return result;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoBonificacion2951. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoAporEssalud(PlanillaDTO planillaDTO, Double dsct_eps) {
		try {
			Parametro par = new Parametro();
			par = repoParametro.findByCodigoAndEmpresa(Constantes.CODESSALUD,
					planillaDTO.getContrato().getTrabajador().getEmpresa());
			Double apor_ess = Double.parseDouble(par.getValor());
			return apor_ess - dsct_eps;

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoAporteEssalud. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double[] calculoAporEps(PlanillaDTO planillaDTO) {
		try {
			Double[] resul = new Double[2];
			if (planillaDTO.getContrato().getTrabajador().getRegSalud() != null
					&& planillaDTO.getContrato().getTrabajador().getRegSalud().getIdRegSalud() == 4) {
				resul[0] = planillaDTO.getContrato().getTrabajador().getEps().getAporte();
				resul[1] = calculoAporEssalud(planillaDTO, resul[0]);
			} else {
				resul[0] = 0.0;
				resul[1] = calculoAporEssalud(planillaDTO, resul[0]);
			}
			return resul;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoAporteEps. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public PlanillaHistorico encontrarPlanilla(PlanillaDTO planillaDTO) {
		try {

			PdoAno ano = planillaDTO.getPlanilla().getPdo_ano();
			PdoMes mes = planillaDTO.getPlanilla().getPdo_mes();
			Contrato contrato = planillaDTO.getContrato();
			return repoPlanilla.findByPdoAnoAndPdoMesAndContrato(ano, mes, contrato);

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " BuscarPlanilla. ERROR : " + e.getMessage());
			throw e;
		}

	}

	@Override
	public List<PlanillaHistorico> listarBoletas(Integer idContrato) {
		try {
			return repoPlanilla.listarBoletas(idContrato);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarBoletas. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Double calculoRemDiasJusti(PlanillaDTO planillaDTO) {
		try {
			Parametro par = repoParametro.findByCodigoAndGrupo(Constantes.CODDIASCOMPTBASE, Constantes.GRPGLOBAL);
			Double sueld_basic = planillaDTO.getContrato().getSueldoBase();
			Double sueld_dia = sueld_basic / Double.parseDouble(par.getValor());

			return planillaDTO.getPlanilla().getFaltas_justi() * sueld_dia;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " calculoRemDiasJustificados. ERROR : " + e.getMessage());
			throw e;
		}
	}

}
