package com.mitocode.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.PlanillaDTO;
import com.mitocode.dto.ResponseWrapper;
import com.mitocode.dto.TrabajadorDTO;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.AdelantoSueldo;
import com.mitocode.model.CuotaAdelanto;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.PlanillaHistorico;
import com.mitocode.model.Trabajador;
import com.mitocode.service.AdelantoSueldoService;
import com.mitocode.service.CuotaAdelantoService;
import com.mitocode.service.PlanillaHistoricoService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/planilla")
public class PlanillaController {

	@Autowired
	PlanillaHistoricoService service;

	@Autowired
	AdelantoSueldoService service_as;

	@Autowired
	CuotaAdelantoService service_ca;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/generarPlanilla")
	public ResponseWrapper generarPlanilla(@Valid @RequestBody PlanillaDTO planillaDTO, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();

			}).collect(Collectors.toList());
			errors.remove(null);
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/generarPlanilla",
					"Error en la validacion: Lista de Errores:" + errors.toString(), planillaDTO);
		}

		
		try {
			ResponseWrapper response = new ResponseWrapper();
			PlanillaHistorico res_planilla_historico = new PlanillaHistorico();
			Double rem_jor_norm = 0.00;

			PlanillaHistorico tmp_planilla_historico = this.crearPlanilla(planillaDTO);

			double deudaAdelantoSueldo = pagarDeuda(tmp_planilla_historico);
			tmp_planilla_historico.setTotPagado(tmp_planilla_historico.getTotPagado() - deudaAdelantoSueldo);
			tmp_planilla_historico.setMonPrest(deudaAdelantoSueldo);

			res_planilla_historico = service.registrar(tmp_planilla_historico);
			if (res_planilla_historico != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgGenerarPlanillaOK);
				response.setDefaultObj(res_planilla_historico);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgGenerarPlanillaError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + "generarPlanilla. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/generarPlanilla",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					planillaDTO);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/buscarPlanilla")
	public ResponseWrapper buscarPlanilla(@Valid @RequestBody PlanillaDTO planillaDTO, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();

			}).collect(Collectors.toList());
			errors.remove(null);
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/generarPlanilla",
					"Error en la validacion: Lista de Errores:" + errors.toString(), planillaDTO);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();

			PlanillaHistorico res_planilla = service.encontrarPlanilla(planillaDTO);
			if (res_planilla != null) {
				response.setEstado(Constantes.valTransaccionOk);
				String pdo_mes = planillaDTO.getPlanilla().getPdo_mes().getDescripcion();
				Integer pdo_ano = planillaDTO.getPlanilla().getPdo_ano().getDescripcion();
				response.setMsg(Constantes.msgEncontroPlanilla + pdo_mes + "-" + pdo_ano);
				response.setDefaultObj(res_planilla);
			} else {
				response.setEstado(Constantes.valTransaccionNoEncontro);
				response.setMsg(Constantes.msgBuscarPlanillaError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + "buscarPlanilla. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/buscarPlanilla",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					planillaDTO);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarBoletas")
	public ResponseWrapper listarBoletas(@RequestBody TrabajadorDTO trabajadorDTO) throws Exception {
		
		if (trabajadorDTO.getContrato().getIdContrato() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarBoletas",
					Constantes.msgListarBoletasError + " no se ha especificado un contrato valida", trabajadorDTO);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();

			List res_planillas = service.listarBoletas(trabajadorDTO.getContrato().getIdContrato());

			if (res_planillas != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarBoletasOk);
				response.setAaData(res_planillas);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarBoletasError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + "listarBoletas. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarBoletas",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trabajadorDTO);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@DeleteMapping("/{idPlanillaHistorico}")
	public ResponseWrapper borrarBoleta(@PathVariable("idPlanillaHistorico") Integer idPlanilla) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();

			Boolean resp = service.eliminar(idPlanilla);

			if (resp) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgEliminarBoletaOK);
				response.setDefaultObj(resp);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgEliminarBoletaError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + "eliminarBoleta. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/"+idPlanilla,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					idPlanilla);
		}
	}

	public PlanillaHistorico crearPlanilla(PlanillaDTO planilladto) throws Exception {
		try {
		PlanillaHistorico res_planilla_historico = new PlanillaHistorico();

		res_planilla_historico.setContrato(planilladto.getContrato());
		res_planilla_historico.setTipoTardanza(planilladto.getTardanza());
		res_planilla_historico.setValorTipoTard(planilladto.getTardanza().getValor());
		if (planilladto.getTardanza().getValor().compareTo("2") == 0) {
			res_planilla_historico.setClaseTipoTardanza(planilladto.getTipoRango());
			res_planilla_historico.setValorClaseTipoTard(planilladto.getTipoRango().getValor());
		}
		res_planilla_historico.setPdoAno(planilladto.getPlanilla().getPdo_ano());
		res_planilla_historico.setPdoMes(planilladto.getPlanilla().getPdo_mes());
		res_planilla_historico.setDiaFerdo(planilladto.getPlanilla().getDias_ferdo());
		res_planilla_historico.setDiaCompbl(planilladto.getPlanilla().getDias_computables());
		res_planilla_historico.setHoExt25(planilladto.getPlanilla().getHo_extra25());
		res_planilla_historico.setHoExt35(planilladto.getPlanilla().getHo_extra35());
		res_planilla_historico.setDiaFerdoLabo(planilladto.getPlanilla().getFerdo_laborad());
		res_planilla_historico.setDiaVaca(planilladto.getPlanilla().getDias_vacaciones());
		res_planilla_historico.setTiempo_tardanza(planilladto.getPlanilla().getTardanzas());
		res_planilla_historico.setFaltaInjusti(planilladto.getPlanilla().getFaltas_injusti());
		res_planilla_historico.setFaltaJusti(planilladto.getPlanilla().getFaltas_justi());
		res_planilla_historico.setComiMix(planilladto.getContrato().getTrabajador().getComiMixta());
		if (planilladto.getContrato().getBancoSueldo() != null) {
			res_planilla_historico.setIdBanco(planilladto.getContrato().getBancoSueldo().getIdBanco());
			res_planilla_historico.setNroCuentaBanco(planilladto.getContrato().getNroCta());
		}
		res_planilla_historico.setIdCargo(planilladto.getContrato().getCargo().getIdCargo());
		res_planilla_historico.setSueldoBasico(planilladto.getContrato().getSueldoBase());
		res_planilla_historico.setRemComisiones(planilladto.getPlanilla().getComisiones());

		res_planilla_historico.setMovilidad(service.calculoMovTotal(planilladto));
		res_planilla_historico.setRemHoExt25(service.calculoHorExtra25(planilladto));
		res_planilla_historico.setRemHoExt35(service.calculoHorExtra35(planilladto));
		res_planilla_historico.setEssaludVida(service.calculoEssaludVida(planilladto));
		res_planilla_historico.setAsigFam(service.calculoAsigFam(planilladto));
		res_planilla_historico.setRemFerdo(service.calculoRemFerdo(planilladto));
		res_planilla_historico.setRemDiaFerdoLabo(service.calculoRemDiaFerdoLabo(planilladto));
		res_planilla_historico.setRemDiaVaca(service.calculoRemDiaVaca(planilladto));
		res_planilla_historico.setRemGrati(service.calculoRemGrat(planilladto, true));
		res_planilla_historico.setRemVacaVend(service.calculoRemVacaVend(planilladto));
		res_planilla_historico.setRemFaltaJusti(service.calculoRemDiasJusti(planilladto));

		Double rem_comp_normal = service.calculoRemJorNorm(planilladto, false) + res_planilla_historico.getRemFerdo()
				+ res_planilla_historico.getRemFaltaJusti() + res_planilla_historico.getRemDiaVaca();

		res_planilla_historico.setRemJorNorm(rem_comp_normal);

		Double rem_ferdo_laborad = res_planilla_historico.getRemDiaFerdoLabo();
		Double rem_jor_lab = res_planilla_historico.getRemJorNorm();
		Double rem_asig_fam = res_planilla_historico.getAsigFam();
		Double rem_vacaciones = res_planilla_historico.getRemDiaVaca();
		Double rem_vacaciones_vendidas = res_planilla_historico.getRemVacaVend();
		Double rem_hrs_extra = res_planilla_historico.getRemHoExt25() + res_planilla_historico.getRemHoExt35();
		Double rem_ferd = res_planilla_historico.getRemFerdo();

		Double total_comp = rem_ferdo_laborad + rem_jor_lab + rem_asig_fam + rem_vacaciones + rem_vacaciones_vendidas
				+ rem_hrs_extra + rem_ferd;
		res_planilla_historico.setTot_comp(total_comp);// FeriadoLaborado + Remuneracion Jornada Normal + Asig Familiar
														// + vacaciones + hrs extra + feriados

		res_planilla_historico.setBonif29351(service.calculoBonif29351(planilladto));

		switch (planilladto.getContrato().getRegimenLaboral().getIdRegLaboral()) {
		case 1:
			res_planilla_historico.setCts(0.0);
			res_planilla_historico.setRemJorNorm(service.calculoRemJorNorm(planilladto, true));
			break;
		case 2:
			res_planilla_historico
					.setCts(service.calculoCTSConsCivil(planilladto, res_planilla_historico.getRemJorNorm()));
			break;
		case 10:
			res_planilla_historico.setCts(0.0);
			break;
		case 14:
			res_planilla_historico.setCts(service.calculoCTSPequeEmp(planilladto));
			break;
		case 23:
			res_planilla_historico.setCts(service.calculoCTSTrabHogar(planilladto));
			break;
		case 24:
			res_planilla_historico.setCts(service.calculoCTSPesquero(planilladto, total_comp));
			break;
		default:
			res_planilla_historico.setCts(service.calculoCTSDefault(planilladto));
		}

		res_planilla_historico.setAfp(planilladto.getContrato().getTrabajador().getAfp());
		res_planilla_historico.setTotIngre(0.00);

		if (planilladto.getContrato().getTrabajador().getAfp() != null) {
			if (isAfp(planilladto)) {
				res_planilla_historico.setDsctOnp(0.00);// si es afp es cero
				res_planilla_historico.setDsctFondObl(
						total_comp * planilladto.getContrato().getTrabajador().getAfp().getApoOblFndPen());
				res_planilla_historico.setDsctPriSeg(
						total_comp * planilladto.getContrato().getTrabajador().getAfp().getPrimaSeguro());// solo se
																											// llama a
																											// su valor
																											// no se
																											// hace
																											// calculo
				if (planilladto.getContrato().getTrabajador().getComiMixta() == 0) {
					res_planilla_historico.setDsctComSobFLu(service.calculoDsctComSobFLu(planilladto, total_comp));
					res_planilla_historico.setDsctComMixSobFlu(0.00);
				} else if (planilladto.getContrato().getTrabajador().getComiMixta() == 1) {
					res_planilla_historico.setDsctComSobFLu(0.00);
					res_planilla_historico
							.setDsctComMixSobFlu(service.calculoDsctComSobFLuMix(planilladto, total_comp));
				}
			} else {
				res_planilla_historico.setDsctOnp(total_comp * 0.13);
				res_planilla_historico.setDsctFondObl(0.0);
				res_planilla_historico.setDsctComSobFLu(0.00);
				res_planilla_historico.setDsctComMixSobFlu(0.00);
				res_planilla_historico.setDsctPriSeg(0.00);
			}
		} else {
			res_planilla_historico.setDsctFondObl(0.0);
			res_planilla_historico.setDsctComSobFLu(0.00);
			res_planilla_historico.setDsctComMixSobFlu(0.00);
			res_planilla_historico.setDsctOnp(0.00);
			res_planilla_historico.setDsctPriSeg(0.00);
		}

		res_planilla_historico.setDsctComMixAnualSal(0.00);// siempre cero
		res_planilla_historico.setDsct5taCat(
				service.calculo5taCateg(planilladto, planilladto.getPlanilla().getPdo_mes().getIdPdoMes()));
		res_planilla_historico.setMonFalt(planilladto.getPlanilla().getFaltantes());
		res_planilla_historico.setMonAdela(planilladto.getPlanilla().getAdelanto());
		res_planilla_historico.setMonPrest(planilladto.getPlanilla().getPrestamos());
		res_planilla_historico.setDsctFaltaInjusti(service.calculoMonDiasInjusti(planilladto));
		res_planilla_historico.setDsctTardanza(service.calculoMonTardanza(planilladto));
		Double[] aporEssaYEps = service.calculoAporEps(planilladto);
		res_planilla_historico.setAporEssalud(aporEssaYEps[1] * total_comp);
		res_planilla_historico.setEps(aporEssaYEps[0] * total_comp);
		if (planilladto.getContrato().getHorNoc() == 1) {
			res_planilla_historico.setRemHoraNoctur(service.calculoMonNocturno(planilladto));
		} else {
			res_planilla_historico.setRemHoraNoctur(0.0);
		}
		res_planilla_historico.setSctr(0.00);

		Double total_ing = res_planilla_historico.getRemJorNorm() + res_planilla_historico.getAsigFam()
				+ res_planilla_historico.getCts() + res_planilla_historico.getRemDiaFerdoLabo()
				+ res_planilla_historico.getRemGrati() + res_planilla_historico.getRemHoExt25()
				+ res_planilla_historico.getRemHoExt35() + res_planilla_historico.getRemVacaVend()
				+ res_planilla_historico.getMovilidad() + res_planilla_historico.getRemComisiones();

		Double total_desc = res_planilla_historico.getDsct5taCat() + res_planilla_historico.getDsctComMixAnualSal()
				+ res_planilla_historico.getDsctComMixSobFlu() + res_planilla_historico.getDsctComSobFLu()
				+ res_planilla_historico.getDsctFaltaInjusti() + res_planilla_historico.getDsctFondObl()
				+ res_planilla_historico.getDsctOnp() + res_planilla_historico.getDsctPriSeg()
				+ res_planilla_historico.getDsctTardanza() + res_planilla_historico.getMonAdela()
				+ res_planilla_historico.getMonFalt() + res_planilla_historico.getMonPrest()
				+ res_planilla_historico.getEssaludVida();

		Double total_apor = res_planilla_historico.getAporEssalud() + res_planilla_historico.getSctr();

		res_planilla_historico.setTotIngre(total_ing);
		res_planilla_historico.setTotDsct(total_desc);
		res_planilla_historico.setTotApor(total_apor);
		res_planilla_historico.setTotPagado(total_ing - total_desc);
		res_planilla_historico.setNetPagPdt(0.0);

		return res_planilla_historico;
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + "crearPlanilla. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() ,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					planilladto);
		}

	}

	private boolean isAfp(PlanillaDTO planilladto) {
		if (planilladto.getContrato().getTrabajador().getAfp().getDescripcion().compareTo(Constantes.CODONP) == 0) {
			return false;
		} else {
			return true;
		}
	}

	public double pagarDeuda(PlanillaHistorico planillaHistorica) {

		Trabajador trab = planillaHistorica.getContrato().getTrabajador();
		PdoAno pdoAno = planillaHistorica.getPdoAno();
		PdoMes pdoMes = planillaHistorica.getPdoMes();

		double montoTotal = 0.0;

		List<CuotaAdelanto> lsCuoAde = service_ca.listarXTrabPAnoPMes(trab, pdoAno, pdoMes);

		if (lsCuoAde.size() > 0) {

			for (int i = 0; i < lsCuoAde.size(); i++) {

				int cantCuoAde = 0;
				int cantPagado = 0;

				CuotaAdelanto cuoAdelanto = service_ca.EncontrarCuoAde(lsCuoAde.get(i).getIdCuotaAdelanto());

				if (cuoAdelanto.getEstado() == 0) {
					montoTotal = montoTotal + cuoAdelanto.getMontoCuota();
					service_ca.Pagado(cuoAdelanto);

				}

				AdelantoSueldo valAdeSue = cuoAdelanto.getAdelantoSueldo();

				List<CuotaAdelanto> lsCuotaAdelanto = service_ca.listarXAdeSue(valAdeSue);
				cantCuoAde = lsCuotaAdelanto.size();
				for (int j = 0; j < lsCuotaAdelanto.size(); j++) {
					if (lsCuotaAdelanto.get(j).getEstado() == 1) {
						cantPagado = cantPagado + 1;
					}
				}
				if (cantCuoAde == cantPagado) {
					service_as.deudaSaldada(valAdeSue);
				}
			}
			return montoTotal;
		} else {
			return montoTotal;
		}
	}
}
