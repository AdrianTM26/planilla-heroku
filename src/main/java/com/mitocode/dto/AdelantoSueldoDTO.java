package com.mitocode.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mitocode.model.AdelantoSueldo;
import com.mitocode.model.CuotaAdelanto;
import com.mitocode.model.Empresa;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.Trabajador;

public class AdelantoSueldoDTO {
	
	@NotNull(message="No se ha especificado un trabajador para el adelanto Sueldo")
	private Trabajador trabajador;
	
	@NotNull(message="No se ha especificado un trabajador para el adelanto Sueldo")
	@Valid
	private AdelantoSueldo adelantoSueldo;
	
	
	private CuotaAdelanto cuotaAdelanto;
	
	@NotNull(message="No se ha especificado un año para el adelanto Sueldo")
	private PdoAno pdoAno;
	
	@NotNull(message="No se ha especificado un mes para el adelanto Sueldo")
	private PdoMes pdoMes;
	
	
	private Empresa empresa;
	
	public Trabajador getTrabajador() {
		return trabajador;
	}
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	public AdelantoSueldo getAdelantoSueldo() {
		return adelantoSueldo;
	}
	public void setAdelantoSueldo(AdelantoSueldo adelantoSueldo) {
		this.adelantoSueldo = adelantoSueldo;
	}
	public CuotaAdelanto getCuotaAdelanto() {
		return cuotaAdelanto;
	}
	public void setCuotaAdelanto(CuotaAdelanto cuotaAdelanto) {
		this.cuotaAdelanto = cuotaAdelanto;
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
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
