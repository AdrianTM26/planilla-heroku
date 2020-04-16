package com.mitocode.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mitocode.model.Contrato;
import com.mitocode.model.CuentaCargo;
import com.mitocode.model.Empresa;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;

public class CuentaCargoDTO {
	
	@NotNull(message="No se ha especifiado una cuenta Cargo")
	private CuentaCargo cuentaCargo;
	
	@NotNull(message="No se ha especificado una empresa para la cuenta Cargo")
	private Empresa empresa;
	
	private Contrato contrato;
	
	private PdoAno pdoAno;
	
	private PdoMes pdoMes;
	
	private String descripcion;
	
	public CuentaCargo getCuentaCargo() {
		return cuentaCargo;
	}
	public void setCuentaCargo(CuentaCargo cuentaCargo) {
		this.cuentaCargo = cuentaCargo;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
		
}
