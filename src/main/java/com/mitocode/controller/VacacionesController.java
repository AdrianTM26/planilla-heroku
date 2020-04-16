package com.mitocode.controller;

import java.sql.Date;
import java.util.Calendar;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.CalculoFinFecha;
import com.mitocode.dto.ResponseWrapper;
import com.mitocode.dto.VacacionesDTO;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.Trabajador;
import com.mitocode.model.Vacaciones;
import com.mitocode.model.VacacionesTomadas;
import com.mitocode.model.VacacionesVendidas;
import com.mitocode.service.AnoMesService;
import com.mitocode.service.VacacionesService;
import com.mitocode.service.VacacionesTomadasService;
import com.mitocode.service.VacacionesVendidasService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/vacaciones")
public class VacacionesController {

	@Autowired
	VacacionesService service;

	@Autowired
	VacacionesTomadasService serviceTomadas;

	@Autowired
	VacacionesVendidasService serviceVendidas;

	@Autowired
	AnoMesService serviceAnoMes;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarPorTrabajador")
	public ResponseWrapper listarXTrabajador(@RequestBody Trabajador trabajador) throws Exception {
		
		if (trabajador.getIdTrabajador() == null) {
			throw new ExceptionResponse(new java.util.Date(), this.getClass().getSimpleName() + "/listarTrabRemuInac",
					Constantes.msgListarVacacionesError + " no se ha especificado un trabajador valido", trabajador);
		}
		 
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsvac = service.buscarPorTrabajador(trabajador);
			if (lsvac != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarVacacionesOK);
				response.setAaData(lsvac);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarVacacionesError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarVacacionesPorTrabajador. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new java.util.Date(), this.getClass().getSimpleName() + "/listarPorTrabajador",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trabajador);
		}
	}

	@PostMapping("/calcFin")
	public ResponseWrapper caclcularFechaFin(@Valid @RequestBody CalculoFinFecha calc, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new java.util.Date(), this.getClass().getSimpleName() + "/calcFin",
					"Error en la validacion: Lista de Errores:" + errors.toString(), calc);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			Date fechaFin = calc.CalcularFin();
			response.setEstado(Constantes.valTransaccionOk);
			response.setDefaultObj(fechaFin);
			return response;

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " calcularFechaFin. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new java.util.Date(), this.getClass().getSimpleName() + "/calcFin",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					calc);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/registrarVT")
	public ResponseWrapper registrarVacaTomada(@Valid @RequestBody VacacionesDTO vacacionesDTO, BindingResult result)
			throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new java.util.Date(), this.getClass().getSimpleName() + "/registrarVT",
					"Error en la validacion: Lista de Errores:" + errors.toString(), vacacionesDTO);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			Vacaciones vacacion = vacacionesDTO.getVacaciones();
			vacacion.setFechaIni(this.arreglarFechaModificar(vacacion.getFechaIni()));
			vacacion.setFechaFin(this.arreglarFechaModificar(vacacion.getFechaFin()));

			VacacionesTomadas tmp_vt = this.setearDatosPdoToma(vacacionesDTO.getVacaTomadas(), vacacion);
			VacacionesTomadas resp_vt = serviceTomadas.registrar(tmp_vt);

			response.setEstado(Constantes.valTransaccionOk);
			response.setMsg(Constantes.msgRegistrarVacacionTomadaOK);
			response.setDefaultObj(resp_vt);

			service.modificar(vacacion);
			
			return response;

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarVacacionTomada. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new java.util.Date(), this.getClass().getSimpleName() + "/registrarVT",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					vacacionesDTO);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/registrarVV")
	public ResponseWrapper registrarVacaVendida(@Valid @RequestBody VacacionesDTO vacacionesDTO, BindingResult result)
			throws Exception {

		ResponseWrapper response = new ResponseWrapper();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new java.util.Date(), this.getClass().getSimpleName() + "/registrarVV",
					"Error en la validacion: Lista de Errores:" + errors.toString(), vacacionesDTO);
		}

		try {
			Vacaciones vacacion = vacacionesDTO.getVacaciones();
			vacacion.setFechaIni(this.arreglarFechaModificar(vacacion.getFechaIni()));
			vacacion.setFechaFin(this.arreglarFechaModificar(vacacion.getFechaFin()));

			VacacionesVendidas tmp_vv = this.setearDatosPdoVenta(vacacionesDTO.getVacaVendidas(), vacacion);
			VacacionesVendidas resp_vv = serviceVendidas.registrar(tmp_vv);

			response.setEstado(Constantes.valTransaccionOk);
			response.setMsg(Constantes.msgRegistrarVacacionVendidaOK);
			response.setDefaultObj(resp_vv);
			service.modificar(vacacion);

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarVacacionVendida. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new java.util.Date(), this.getClass().getSimpleName() + "/registrarVV",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					vacacionesDTO);
		}
		
		return response;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/registrarVA/{dias}")
	public ResponseWrapper registrarVacaAdelanto(@Valid @RequestBody VacacionesDTO vacacionesDTO, BindingResult result,
			@PathVariable("dias") Integer diasAdel) throws Exception {

		ResponseWrapper response = new ResponseWrapper();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new java.util.Date(), this.getClass().getSimpleName() + "/registrarVA/"+diasAdel,
					"Error en la validacion: Lista de Errores:" + errors.toString(), vacacionesDTO);
		}
		
		try {
			Vacaciones periodo_actual = service
					.buscarUltimoPeriodoPorTrabajador(vacacionesDTO.getContrato().getTrabajador());
			Calendar calendar = Calendar.getInstance();
			Vacaciones nueva_vaca1 = new Vacaciones();
			Vacaciones resp_vaca1;
			Vacaciones resp_vaca2, nueva_vaca2;

			nueva_vaca1.setFechaIni(periodo_actual.getFechaFin());
			calendar.setTime(periodo_actual.getFechaFin());
			calendar.add(Calendar.MONTH, 6);
			nueva_vaca1.setFechaFin(new Date(calendar.getTime().getTime()));
			nueva_vaca1.setTrabajador(vacacionesDTO.getContrato().getTrabajador());
			nueva_vaca1.setDiasVendidos(0);

			if (diasAdel <= 15) {
				nueva_vaca1.setDiasTomados(diasAdel);
				if (diasAdel == 15) {
					nueva_vaca1.setEstado(3);
				} else {
					nueva_vaca1.setEstado(4);
				}
				resp_vaca1 = service.registrar(nueva_vaca1);
				resp_vaca2 = new Vacaciones();
			} else {

				nueva_vaca2 = new Vacaciones();
				nueva_vaca1.setDiasTomados(15);
				nueva_vaca1.setEstado(3);
				nueva_vaca2.setFechaIni(nueva_vaca1.getFechaFin());
				calendar.setTime(nueva_vaca1.getFechaFin());
				calendar.add(Calendar.MONTH, 6);
				nueva_vaca2.setFechaFin(new Date(calendar.getTime().getTime()));
				nueva_vaca2.setTrabajador(vacacionesDTO.getContrato().getTrabajador());
				nueva_vaca2.setDiasTomados(diasAdel - 15);
				nueva_vaca2.setDiasVendidos(0);
				if (diasAdel == 30) {
					nueva_vaca2.setEstado(3);
				} else {
					nueva_vaca2.setEstado(4);
				}

				resp_vaca1 = service.registrar(nueva_vaca1);
				resp_vaca2 = service.registrar(nueva_vaca2);
			}

			VacacionesTomadas tmp_va1, tmp_va2, resp_va1, resp_va2;
			CalculoFinFecha calc = new CalculoFinFecha();
			Date fech_ini = vacacionesDTO.getVacaTomadas().getFechaIni();
			calc.setFechaIni(fech_ini);
			tmp_va1 = new VacacionesTomadas();

			if (diasAdel <= 15) {
				calc.setDias(diasAdel);
				if (fech_ini.getMonth() == calc.CalcularFin().getMonth()) {
					tmp_va1.setTipo(0);
				} else {
					tmp_va1.setTipo(1);
				}
				tmp_va1.setFechaIni(fech_ini);
				tmp_va1.setFechaFin(new Date(calc.CalcularFin().getTime()));
				tmp_va1 = this.setearDatosPdoToma(tmp_va1, resp_vaca1);
				tmp_va1.setPdoVacacion(resp_vaca1);
				resp_va1 = serviceTomadas.registrar(tmp_va1);
				resp_va2 = new VacacionesTomadas();
			} else {
				tmp_va2 = new VacacionesTomadas();
				calc.setDias(15);
				if (fech_ini.getMonth() == calc.CalcularFin().getMonth()) {
					tmp_va1.setTipo(0);
				} else {
					tmp_va1.setTipo(1);
				}
				tmp_va1.setFechaIni(fech_ini);
				tmp_va1.setFechaFin(new Date(calc.CalcularFin().getTime()));
				tmp_va1 = this.setearDatosPdoToma(tmp_va1, resp_vaca1);
				tmp_va1.setPdoVacacion(resp_vaca1);
				resp_va1 = serviceTomadas.registrar(tmp_va1);

				Date fech_ini2 = new Date(calc.CalcularFin().getTime());
				calc.setDias(diasAdel - 15);
				calc.setFechaIni(fech_ini2);
				if (fech_ini2.getMonth() == calc.CalcularFin().getMonth()) {
					tmp_va2.setTipo(0);
				} else {
					tmp_va2.setTipo(1);
				}
				tmp_va2.setFechaIni(fech_ini2);
				tmp_va2.setFechaFin(new Date(calc.CalcularFin().getTime()));
				tmp_va2 = this.setearDatosPdoToma(tmp_va2, resp_vaca2);
				tmp_va2.setPdoVacacion(resp_vaca2);
				resp_va2 = serviceTomadas.registrar(tmp_va2);
			}

			if (resp_va1 != null && resp_va2 != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgRegistrarVacacionAdelantadaOK);

			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgRegistrarVacacionAdelantadaError);
			}

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarVacacionAdelantada. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new java.util.Date(), this.getClass().getSimpleName() + "/registrarVA",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					vacacionesDTO);
		}
		return response;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PutMapping("/modificarVacas") // noseusa
	public ResponseWrapper modificar(@RequestBody VacacionesDTO vacacionesDTO) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();
			Vacaciones resp_vac = service.modificar(vacacionesDTO.getVacaciones());
			if (resp_vac != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgActualizarVacacionOK);
				response.setDefaultObj(resp_vac);
				return response;
			} else {
				System.out.println(this.getClass().getSimpleName() + " Error al actualizar Vacacion.");
				throw new Exception(Constantes.msgActualizarVacacionError);
			}
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " actualizar. ERROR : " + e);
			System.out.println(this.getClass().getSimpleName() + "actualizar. " + "Linea nro : "
					+ e.getStackTrace()[0].getLineNumber());
			throw new Exception(Constantes.msgActualizarVacacionError);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class) // sin usar
	@DeleteMapping("/{idVacacion}") // noseusa
	public ResponseWrapper eliminar(@PathVariable("idVacacion") Integer id) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();

			Boolean resp = service.eliminar(id);

			if (!resp) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgEliminarVacacionOK);
				response.setDefaultObj(resp);
				return response;
			} else {
				System.out.println(this.getClass().getSimpleName() + " Error al eliminar Vacacion");
				throw new Exception(Constantes.msgEliminarVacacionError);
			}
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " eliminar. ERROR : " + e);
			System.out.println(this.getClass().getSimpleName() + "eliminar. " + "Linea nro : "
					+ e.getStackTrace()[0].getLineNumber());
			throw new Exception(Constantes.msgEliminarVacacionError);
		}
	}

	private VacacionesTomadas setearDatosPdoToma(VacacionesTomadas vt, Vacaciones v) throws Exception {
		try {
			PdoAno auxAIni = new PdoAno();
			PdoAno auxAFin = new PdoAno();
			auxAIni.setDescripcion(vt.getFechaIni().getYear() + 1900);
			auxAFin.setDescripcion(vt.getFechaIni().getYear() + 1900);
			PdoAno anoIni = serviceAnoMes.buscarSiExistePorDesc(v.getTrabajador().getEmpresa(), auxAIni);
			if (anoIni != null) {
				vt.setPdoAnoIni(anoIni);
				PdoAno anoFin = serviceAnoMes.buscarSiExistePorDesc(v.getTrabajador().getEmpresa(), auxAFin);
				if (anoFin != null) {
					vt.setPdoAnoFin(anoFin);
				} else {
					System.out.println(this.getClass().getSimpleName() + " buscar Año Fin. ERROR ");
					return null;
				}
			} else {
				System.out.println(this.getClass().getSimpleName() + " buscar Año Inicio. ERROR ");
				return null;

			}

			PdoMes mesIni = serviceAnoMes.encontrarMes(vt.getFechaIni().getMonth() + 1);

			if (mesIni != null) {
				vt.setPdoMesIni(mesIni);
				PdoMes mesFin = serviceAnoMes.encontrarMes(vt.getFechaFin().getMonth() + 1);
				if (mesFin != null) {
					vt.setPdoMesFin(mesFin);
				} else {
					System.out.println(this.getClass().getSimpleName() + " buscar Mes Fin. ERROR ");
					return null;
				}
			} else {
				System.out.println(this.getClass().getSimpleName() + " buscar Mes Inicio. ERROR ");
				return null;
			}
		} catch (Exception e) {
			VacacionesDTO vaca = new VacacionesDTO();
			vaca.setVacaTomadas(vt);
			vaca.setVacaciones(v);
			System.out.println(this.getClass().getSimpleName() + " setearDatosPdoToma. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new java.util.Date(), this.getClass().getSimpleName() + "Metodo: ",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					vaca);
		}

		return vt;

	}

	private VacacionesVendidas setearDatosPdoVenta(VacacionesVendidas vv, Vacaciones v) throws Exception {
		try {
			PdoAno auxA = new PdoAno();
			auxA.setDescripcion(vv.getFechaVenta().getYear() + 1900);
			PdoAno ano = serviceAnoMes.buscarSiExistePorDesc(v.getTrabajador().getEmpresa(), auxA);
			if (ano != null) {
				vv.setPdoAnoVenta(ano);
			} else {
				System.out.println(this.getClass().getSimpleName() + " buscar Año Venta. ERROR ");
				return null;
			}

			PdoMes mes = serviceAnoMes.encontrarMes(vv.getFechaVenta().getMonth() + 1);
			if (mes != null) {
				vv.setPdoMesVenta(mes);
			} else {
				System.out.println(this.getClass().getSimpleName() + " buscar Mes Venta. ERROR ");
				return null;
			}
		} catch (Exception e) {
			VacacionesDTO vaca = new VacacionesDTO();
			vaca.setVacaVendidas(vv);
			vaca.setVacaciones(v);
			System.out.println(this.getClass().getSimpleName() + " setearDatosPdoVenta. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new java.util.Date(), this.getClass().getSimpleName() + "Metodo: ",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					vaca);
		}

		return vv;
	}

	private Date arreglarFechaModificar(Date fecha_vaca) {
		Date fecha = new Date(fecha_vaca.getTime());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_MONTH, 1);

		return new Date(calendar.getTime().getTime());
	}

}
