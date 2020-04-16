package com.mitocode.service;

import java.util.List;

import com.mitocode.dto.PlanillaDTO;
import com.mitocode.model.PlanillaHistorico;
import com.mitocode.model.Trabajador;


public interface PlanillaHistoricoService extends ICRUD<PlanillaHistorico>{

	Double calculoMovTotal(PlanillaDTO planillaDTO);

	Double calculoHorExtra25(PlanillaDTO planillaDTO);

	Double calculoHorExtra35(PlanillaDTO planillaDTO);
	
	Double calculoRemJorNorm(PlanillaDTO planillaDTO,boolean ctsAgrario);
	
	Double calculoAsigFam(PlanillaDTO planillaDTO);
	
	Double calculoEssaludVida(PlanillaDTO planillaDTO);
	
	Double calculoAporEssalud(PlanillaDTO planillaDTO,Double dsct_eps);
	
	Double calculoRemDiaFerdoLabo(PlanillaDTO planillaDTO);
	
	Double calculoRemDiaVaca(PlanillaDTO planillaDTO);
	
	Double calculoRemFerdo(PlanillaDTO planillaDTO);
	
	Double calculoRemGrat(PlanillaDTO planillaDTO,boolean activar_hora_actual) throws Exception;
	
	Double calculoBonif29351(PlanillaDTO planillaDTO) throws Exception;
	
	Double calculoCTSDefault(PlanillaDTO planillaDTO) throws Exception;
		
	Double calculoCTSConsCivil(PlanillaDTO planillaDTO, Double remJornal) throws Exception;
	
	Double calculoCTSTrabHogar(PlanillaDTO planillaDTO) throws Exception;
	
	Double calculoCTSPequeEmp(PlanillaDTO planillaDTO) throws Exception;
	
	Double calculoCTSPesquero(PlanillaDTO planillaDTO,Double total_comp) throws Exception;
	
	Double calculoDsctComSobFLu(PlanillaDTO planillaDTO, Double total_comp);
	
	Double calculoDsctComSobFLuMix(PlanillaDTO planillaDTO, Double total_comp);
	
	Double calculoRemVacaVend(PlanillaDTO planillaDTO);
	
	Double calculoMonNocturno(PlanillaDTO planillaDTO);
	
	Double calculoMonDiasInjusti(PlanillaDTO planillaDTO);
	
	Double calculoMonTardanza(PlanillaDTO planillaDTO);
	
	Double calculo5taCateg(PlanillaDTO planillaDTO,Integer mes_actual);
		
	Double calculo5taCategPorMes(PlanillaDTO planillaDTO,Integer mes_actual,Double retencion_total);
	
	Double calculoDsctSctr(PlanillaDTO planillaDTO);
	
	Double [] calculoAporEps(PlanillaDTO planillaDTO);
	
	Double  calculoRemDiasJusti(PlanillaDTO planillaDTO);
	
	PlanillaHistorico encontrarPlanilla(PlanillaDTO planillaDTO);
	
	List<PlanillaHistorico> listarBoletas(Integer idContrato);

}
