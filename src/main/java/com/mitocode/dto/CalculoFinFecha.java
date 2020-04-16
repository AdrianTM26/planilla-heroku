package com.mitocode.dto;

import java.sql.Date;
import java.util.Calendar;

import javax.validation.constraints.NotNull;

public class CalculoFinFecha {
	
	@NotNull(message="No se ha especificado una fecha iniiar para calcular")
	private Date fechaIni;
	
	@NotNull(message="No se ha especificado la cantidad de dias para sumarle a la fecha")
	private Integer dias;
	
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Integer getDias() {
		return dias;
	}
	public void setDias(Integer dias) {
		this.dias = dias;
	}
	
	public Date CalcularFin() {
		
		Date fecha = new Date(this.fechaIni.getTime());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_MONTH, this.dias);
		
		return new Date(calendar.getTime().getTime());
	}
	
	
}
