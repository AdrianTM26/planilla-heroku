package com.mitocode.dto;

import javax.validation.Valid;

import com.mitocode.model.Contrato;
import com.mitocode.model.Vacaciones;
import com.mitocode.model.VacacionesTomadas;
import com.mitocode.model.VacacionesVendidas;

public class VacacionesDTO {
	
	@Valid
	private Vacaciones vacaciones;
	
	@Valid
	private VacacionesTomadas vacaTomadas;
	
	@Valid
	private VacacionesVendidas vacaVendidas;
	
	@Valid
	private Contrato contrato;

	public Vacaciones getVacaciones() {
		return vacaciones;
	}

	public void setVacaciones(Vacaciones vacaciones) {
		this.vacaciones = vacaciones;
	}

	public VacacionesTomadas getVacaTomadas() {
		return vacaTomadas;
	}

	public void setVacaTomadas(VacacionesTomadas vacaTomadas) {
		this.vacaTomadas = vacaTomadas;
	}

	public VacacionesVendidas getVacaVendidas() {
		return vacaVendidas;
	}

	public void setVacaVendidas(VacacionesVendidas vacaVendidas) {
		this.vacaVendidas = vacaVendidas;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	


}
