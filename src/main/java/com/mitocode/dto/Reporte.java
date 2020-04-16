package com.mitocode.dto;

import javax.validation.constraints.NotNull;

public class Reporte {
	
	@NotNull(message="No se ha especificado un trabajador para generar Reporte")
	Integer idTrabajador;
	
	@NotNull(message="No se ha especificado un año para generar Reporte")
	Integer idPdoAno;
	
	@NotNull(message="No se ha especificado un mes para generar Reporte")
	Integer idPdoMeS;
	
	public Integer getIdTrabajador() {
		return idTrabajador;
	}
	public void setIdTrabajador(Integer idTrabajador) {
		this.idTrabajador = idTrabajador;
	}
	public Integer getIdPdoAno() {
		return idPdoAno;
	}
	public void setIdPdoAno(Integer idPdoAno) {
		this.idPdoAno = idPdoAno;
	}
	public Integer getIdPdoMeS() {
		return idPdoMeS;
	}
	public void setIdPdoMeS(Integer idPdoMeS) {
		this.idPdoMeS = idPdoMeS;
	}
	
	
}
