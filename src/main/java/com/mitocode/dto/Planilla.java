package com.mitocode.dto;

import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;

public class Planilla {
	private Integer faltas_justi;
	private Integer faltas_injusti;
	private Integer dias_vacaciones;
	private Integer dias_ferdo;
	private Integer dias_computables;
	private Integer ferdo_laborad;
	private Integer vacaciones_vend;
	private Double ho_extra25;
	private Double ho_extra35;
	private Double faltantes;
	private Double adelanto;
	private Double prestamos;
	private Double comisiones;
	private Integer tardanzas;
	private PdoAno pdo_ano;
	private PdoMes pdo_mes;
	
	public Integer getDias_ferdo() {
		return dias_ferdo;
	}
	public void setDias_ferdo(Integer dias_ferdo) {
		this.dias_ferdo = dias_ferdo;
	}
	public Integer getFaltas_justi() {
		return faltas_justi;
	}
	public Integer getFaltas_injusti() {
		return faltas_injusti;
	}
	public Integer getDias_vacaciones() {
		return dias_vacaciones;
	}
	public Integer getDias_computables() {
		return dias_computables;
	}
	public Integer getFerdo_laborad() {
		return ferdo_laborad;
	}
	public Double getHo_extra25() {
		return ho_extra25;
	}
	public Double getHo_extra35() {
		return ho_extra35;
	}
	public Double getFaltantes() {
		return faltantes;
	}
	public Double getAdelanto() {
		return adelanto;
	}
	public Double getPrestamos() {
		return prestamos;
	}
	public void setFaltas_justi(Integer faltas_justi) {
		this.faltas_justi = faltas_justi;
	}
	public void setFaltas_injusti(Integer faltas_injusti) {
		this.faltas_injusti = faltas_injusti;
	}
	public void setDias_vacaciones(Integer dias_vacaciones) {
		this.dias_vacaciones = dias_vacaciones;
	}
	public void setDias_computables(Integer dias_computables) {
		this.dias_computables = dias_computables;
	}
	public void setFerdo_laborad(Integer ferdo_laborad) {
		this.ferdo_laborad = ferdo_laborad;
	}
	public void setHo_extra25(Double ho_extra25) {
		this.ho_extra25 = ho_extra25;
	}
	public void setHo_extra35(Double ho_extra35) {
		this.ho_extra35 = ho_extra35;
	}
	public void setFaltantes(Double faltantes) {
		this.faltantes = faltantes;
	}
	public void setAdelanto(Double adelanto) {
		this.adelanto = adelanto;
	}
	public void setPrestamos(Double prestamos) {
		this.prestamos = prestamos;
	}
	public PdoAno getPdo_ano() {
		return pdo_ano;
	}
	public PdoMes getPdo_mes() {
		return pdo_mes;
	}
	public void setPdo_ano(PdoAno pdo_ano) {
		this.pdo_ano = pdo_ano;
	}
	public void setPdo_mes(PdoMes pdo_mes) {
		this.pdo_mes = pdo_mes;
	}
	public Integer getVacaciones_vend() {
		return vacaciones_vend;
	}
	public void setVacaciones_vend(Integer vacaciones_vend) {
		this.vacaciones_vend = vacaciones_vend;
	}
	public Integer getTardanzas() {
		return tardanzas;
	}
	public void setTardanzas(Integer tardanzas) {
		this.tardanzas = tardanzas;
	}
	public Double getComisiones() {
		return comisiones;
	}
	public void setComisiones(Double comisiones) {
		this.comisiones = comisiones;
	}
	
	
	
}
