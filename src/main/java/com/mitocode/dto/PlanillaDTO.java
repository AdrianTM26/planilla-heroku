package com.mitocode.dto;

import com.mitocode.model.Contrato;
import com.mitocode.model.Parametro;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.Trabajador;

public class PlanillaDTO {
	
	private Planilla planilla;
	private Contrato contrato;
	private Parametro tardanza;
	private Parametro tipoRango;
	private Trabajador trabajador;
	private PdoAno pdoAno;
	private PdoMes pdoMes;
	
	public Planilla getPlanilla() {
		return planilla;
	}
	public Contrato getContrato() {
		return contrato;
	}
	public void setPlanilla(Planilla planilla) {
		this.planilla = planilla;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	public Parametro getTardanza() {
		return tardanza;
	}
	public void setTardanza(Parametro tardanza) {
		this.tardanza = tardanza;
	}
	public Parametro getTipoRango() {
		return tipoRango;
	}
	public void setTipoRango(Parametro tipoRango) {
		this.tipoRango = tipoRango;
	}
	public Trabajador getTrabajador() {
		return trabajador;
	}
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	public PdoAno getPdoAno() {
		return pdoAno;
	}
	public void setPdoAno(PdoAno pdoAno) {
		this.pdoAno = pdoAno;
	}
	public PdoMes getPdoMes() {
		return pdoMes;
	}
	public void setPdoMes(PdoMes pdoMes) {
		this.pdoMes = pdoMes;
	}
	
}
