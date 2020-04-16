package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="planilla_historico")
public class PlanillaHistorico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPlanillaHistorico;
	
	@Column(name="dia_ferdo", nullable = false)
	private Integer diaFerdo;
	
	@Column(name="falta_justi", nullable = true)
	private Integer faltaJusti;
	
	@Column(name="rem_falta_justi", nullable = true)
	private Double remFaltaJusti;
	
	@Column(name="falta_injusti", nullable = true)
	private Integer faltaInjusti;
	
	@Column(name="dsct_falta_injusti", nullable = true)
	private Double dsctFaltaInjusti;
	
	@Column(name="tiempo_tardanza", nullable = true)
	private Integer tiempo_tardanza;
	
	@Column(name="rem_ferdo", nullable = false)
	private Double remFerdo;
	
	@Column(name="dia_compbl", nullable = false)	
	private Integer diaCompbl;
	
	@Column(name="ho_ext25", nullable = false)
	private Double hoExt25;
	
	@Column(name="rem_ho_ext25", nullable = false)
	private Double remHoExt25;
	
	@Column(name="ho_ext35", nullable = false)
	private Double hoExt35;
	
	@Column(name="rem_ho_ext35", nullable = false)
	private Double remHoExt35;
	
	@Column(name="rem_ho_noctur",nullable=true)
	private Double remHoraNoctur;
	
	@Column(name="dia_ferdo_labo", nullable = false)
	private Integer diaFerdoLabo;
	
	@Column(name="rem_dia_ferdo_labo", nullable = false)
	private Double remDiaFerdoLabo;
	
	@Column(name="rem_jor_norm", nullable = false)
	private Double remJorNorm;

	@Column(name="asig_fam", nullable = false)
	private Double asigFam;
	
	@Column(name="rem_grati", nullable = true)
	private Double remGrati;
	
	@Column(name="dia_vaca", nullable = false)
	private Integer diaVaca;
	
	@Column(name="rem_vaca_vend", nullable = false)
	private Double remVacaVend;

	@Column(name="rem_cts", nullable = false)
	private Double cts;
	
	@Column(name="rem_dia_vaca", nullable = false)
	private Double remDiaVaca;

	@Column(name="tot_comp", nullable = false)
	private Double tot_comp;
	
	@Column(name="bonif29351", nullable = false)
	private Double bonif29351;
	
	@Column(name="movilidad", nullable = false)
	private Double movilidad;
	
	@Column(name="tot_ingre", nullable = false)
	private Double totIngre;
	
	@Column(name="dsct_fond_obl", nullable = false)
	private Double dsctFondObl;
	
	@Column(name="dsct_com_sob_flu", nullable = false)
	private Double dsctComSobFLu;
	
	@Column(name="dsct_com_mix_sob_flu", nullable = false)
	private Double dsctComMixSobFlu;
	
	@Column(name="dsct_com_mix_anual_sal", nullable = false)
	private Double dsctComMixAnualSal;

	@Column(name="dsct_pri_seg", nullable = false)
	private Double dsctPriSeg;
	
	@Column(name="dsct_onp", nullable = false)
	private Double dsctOnp;
	
	@Column(name="essalud_vida", nullable = false)
	private Double essaludVida;

	@Column(name="dsct_5ta_cat", nullable = false)
	private Double dsct5taCat;
	
	@Column(name="mon_falt", nullable = false)
	private Double monFalt;
	
	@Column(name="mon_adela", nullable = false)
	private Double monAdela;
	
	@Column(name="mon_prest", nullable = false)
	private Double monPrest;
	
	@Column(name="idbanco", nullable = true)
	private Integer idBanco;
	
	@Column(name="sueld_basic", nullable= false)
	private Double sueldoBasico;
	
	@Column(name="id_cargo",nullable = false)
	private Integer idCargo;
	
	@Column(name="nro_cuenta_banco", length = 20, nullable = true)
	private String nroCuentaBanco;
	
	@Column(name="comiMix", nullable= true)
	private Integer comiMix;
	
	@Column(name="dsct_tardanza",nullable = true)
	private Double dsctTardanza;

	@Column(name="tot_dsct", nullable = false)
	private Double totDsct;
	
	@Column(name="net_pag_pdt", nullable = false)
	private Double netPagPdt;
	
	@Column(name="tot_pagado", nullable = false)
	private Double totPagado;
	
	@Column(name="apor_essalud", nullable = false)
	private Double aporEssalud;
	
	@Column(name="sctr", nullable = false)
	private Double sctr;
	
	@Column(name="aport_eps", nullable = true)
	private Double eps;
	
	@Column(name="tot_apor", nullable = false)
	private Double totApor;
	
	@Column(name="valor_tipo_tard", nullable= true)
	private String valorTipoTard;
	
	@Column(name="valor_clase_tipo_tard", nullable= true)
	private String valorClaseTipoTard;
	
	@Column(name="rem_comisiones", nullable = true)
	private Double remComisiones;
		
	@ManyToOne
	@JoinColumn(name="id_contrato", nullable = false)
	private Contrato contrato;
	
	@ManyToOne
	@JoinColumn(name="id_afp", nullable = true)
	private Afp afp;
	
	@ManyToOne
	@JoinColumn(name="id_pdo_ano", nullable = false)
	private PdoAno pdoAno;
	
	@ManyToOne
	@JoinColumn(name="id_pdo_mes", nullable = false)
	private PdoMes pdoMes;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_tardanza", nullable = true)
	private Parametro tipoTardanza;
	
	@ManyToOne
	@JoinColumn(name="id_clase_tipo_tardanza", nullable = true)
	private Parametro claseTipoTardanza;

	public Integer getDiaVaca() {
		return diaVaca;
	}

	public Double getRemDiaVaca() {
		return remDiaVaca;
	}

	public void setDiaVaca(Integer diaVaca) {
		this.diaVaca = diaVaca;
	}

	public void setRemDiaVaca(Double remDiaVaca) {
		this.remDiaVaca = remDiaVaca;
	}

	public Integer getIdPlanillaHistorico() {
		return idPlanillaHistorico;
	}

	public Integer getDiaFerdo() {
		return diaFerdo;
	}

	public Double getRemFerdo() {
		return remFerdo;
	}

	public Integer getDiaCompbl() {
		return diaCompbl;
	}

	public Double getHoExt25() {
		return hoExt25;
	}

	public Double getRemHoExt25() {
		return remHoExt25;
	}

	public Double getHoExt35() {
		return hoExt35;
	}

	public Double getRemHoExt35() {
		return remHoExt35;
	}

	public Integer getDiaFerdoLabo() {
		return diaFerdoLabo;
	}

	public Double getRemDiaFerdoLabo() {
		return remDiaFerdoLabo;
	}

	public Double getRemJorNorm() {
		return remJorNorm;
	}

	public Double getAsigFam() {
		return asigFam;
	}

	public Double getRemGrati() {
		return remGrati;
	}

	public Double getCts() {
		return cts;
	}

	public Double getTot_comp() {
		return tot_comp;
	}

	public Double getBonif29351() {
		return bonif29351;
	}

	public Double getMovilidad() {
		return movilidad;
	}

	public Double getTotIngre() {
		return totIngre;
	}

	public Double getDsctFondObl() {
		return dsctFondObl;
	}

	public Double getDsctComSobFLu() {
		return dsctComSobFLu;
	}

	public Double getDsctComMixSobFlu() {
		return dsctComMixSobFlu;
	}

	public Double getDsctComMixAnualSal() {
		return dsctComMixAnualSal;
	}

	public Double getDsctPriSeg() {
		return dsctPriSeg;
	}

	public Double getDsctOnp() {
		return dsctOnp;
	}

	public Double getEssaludVida() {
		return essaludVida;
	}

	public Double getDsct5taCat() {
		return dsct5taCat;
	}

	public Double getMonFalt() {
		return monFalt;
	}

	public Double getMonAdela() {
		return monAdela;
	}

	public Double getMonPrest() {
		return monPrest;
	}

	public Double getTotDsct() {
		return totDsct;
	}

	public Double getNetPagPdt() {
		return netPagPdt;
	}

	public Double getTotPagado() {
		return totPagado;
	}

	public Double getAporEssalud() {
		return aporEssalud;
	}

	public Double getSctr() {
		return sctr;
	}

	public Double getTotApor() {
		return totApor;
	}

	public Afp getAfp() {
		return afp;
	}

	public void setIdPlanillaHistorico(Integer idPlanillaHistorico) {
		this.idPlanillaHistorico = idPlanillaHistorico;
	}

	public void setDiaFerdo(Integer diaFerdo) {
		this.diaFerdo = diaFerdo;
	}

	public void setRemFerdo(Double remFerdo) {
		this.remFerdo = remFerdo;
	}

	public void setDiaCompbl(Integer diaCompbl) {
		this.diaCompbl = diaCompbl;
	}

	public void setHoExt25(Double hoExt25) {
		this.hoExt25 = hoExt25;
	}

	public void setRemHoExt25(Double remHoExt25) {
		this.remHoExt25 = remHoExt25;
	}

	public void setHoExt35(Double hoExt35) {
		this.hoExt35 = hoExt35;
	}

	public void setRemHoExt35(Double remHoExt35) {
		this.remHoExt35 = remHoExt35;
	}

	public void setDiaFerdoLabo(Integer diaFerdoLabo) {
		this.diaFerdoLabo = diaFerdoLabo;
	}

	public void setRemDiaFerdoLabo(Double remDiaFerdoLabo) {
		this.remDiaFerdoLabo = remDiaFerdoLabo;
	}

	public void setRemJorNorm(Double remJorNorm) {
		this.remJorNorm = remJorNorm;
	}

	public void setAsigFam(Double asigFam) {
		this.asigFam = asigFam;
	}

	public void setRemGrati(Double remGrati) {
		this.remGrati = remGrati;
	}

	public void setCts(Double cts) {
		this.cts = cts;
	}

	public void setTot_comp(Double tot_comp) {
		this.tot_comp = tot_comp;
	}

	public void setBonif29351(Double bonif29351) {
		this.bonif29351 = bonif29351;
	}

	public void setMovilidad(Double movilidad) {
		this.movilidad = movilidad;
	}

	public void setTotIngre(Double totIngre) {
		this.totIngre = totIngre;
	}

	public void setDsctFondObl(Double dsctFondObl) {
		this.dsctFondObl = dsctFondObl;
	}

	public void setDsctComSobFLu(Double dsctComSobFLu) {
		this.dsctComSobFLu = dsctComSobFLu;
	}

	public void setDsctComMixSobFlu(Double dsctComMixSobFlu) {
		this.dsctComMixSobFlu = dsctComMixSobFlu;
	}

	public void setDsctComMixAnualSal(Double dsctComMixAnualSal) {
		this.dsctComMixAnualSal = dsctComMixAnualSal;
	}

	public void setDsctPriSeg(Double dsctPriSeg) {
		this.dsctPriSeg = dsctPriSeg;
	}

	public void setDsctOnp(Double dsctOnp) {
		this.dsctOnp = dsctOnp;
	}

	public void setEssaludVida(Double essaludVida) {
		this.essaludVida = essaludVida;
	}

	public void setDsct5taCat(Double dsct5taCat) {
		this.dsct5taCat = dsct5taCat;
	}

	public void setMonFalt(Double monFalt) {
		this.monFalt = monFalt;
	}

	public void setMonAdela(Double monAdela) {
		this.monAdela = monAdela;
	}

	public void setMonPrest(Double monPrest) {
		this.monPrest = monPrest;
	}

	public void setTotDsct(Double totDsct) {
		this.totDsct = totDsct;
	}

	public void setNetPagPdt(Double netPagPdt) {
		this.netPagPdt = netPagPdt;
	}

	public void setTotPagado(Double totPagado) {
		this.totPagado = totPagado;
	}

	public void setAporEssalud(Double aporEssalud) {
		this.aporEssalud = aporEssalud;
	}

	public void setSctr(Double sctr) {
		this.sctr = sctr;
	}

	public void setTotApor(Double totApor) {
		this.totApor = totApor;
	}

	public void setAfp(Afp afp) {
		this.afp = afp;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public PdoAno getPdoAno() {
		return pdoAno;
	}

	public PdoMes getPdoMes() {
		return pdoMes;
	}

	public void setPdoAno(PdoAno pdoAno) {
		this.pdoAno = pdoAno;
	}

	public void setPdoMes(PdoMes pdoMes) {
		this.pdoMes = pdoMes;
	}

	public Integer getFaltaJusti() {
		return faltaJusti;
	}

	public Double getRemFaltaJusti() {
		return remFaltaJusti;
	}

	public Integer getFaltaInjusti() {
		return faltaInjusti;
	}

	public void setFaltaJusti(Integer faltaJusti) {
		this.faltaJusti = faltaJusti;
	}

	public void setRemFaltaJusti(Double remFaltaJusti) {
		this.remFaltaJusti = remFaltaJusti;
	}

	public void setFaltaInjusti(Integer faltaInjusti) {
		this.faltaInjusti = faltaInjusti;
	}

	public Double getDsctFaltaInjusti() {
		return dsctFaltaInjusti;
	}

	public Integer getTiempo_tardanza() {
		return tiempo_tardanza;
	}


	public void setDsctFaltaInjusti(Double dsctFaltaInjusti) {
		this.dsctFaltaInjusti = dsctFaltaInjusti;
	}

	public void setTiempo_tardanza(Integer tiempo_tardanza) {
		this.tiempo_tardanza = tiempo_tardanza;
	}


	public Parametro getTipoTardanza() {
		return tipoTardanza;
	}

	public Parametro getClaseTipoTardanza() {
		return claseTipoTardanza;
	}

	public void setTipoTardanza(Parametro tipoTardanza) {
		this.tipoTardanza = tipoTardanza;
	}

	public void setClaseTipoTardanza(Parametro claseTipoTardanza) {
		this.claseTipoTardanza = claseTipoTardanza;
	}
	
	public Double getRemVacaVend() {
		return remVacaVend;
	}

	public void setRemVacaVend(Double remVacaVend) {
		this.remVacaVend = remVacaVend;
	}
	
	public Double getDsctTardanza() {
		return dsctTardanza;
	}

	public void setDsctTardanza(Double monTardanza) {
		this.dsctTardanza = monTardanza;
	}

	public Double getEps() {
		return eps;
	}

	public void setEps(Double eps) {
		this.eps = eps;
	}

	public Double getRemHoraNoctur() {
		return remHoraNoctur;
	}

	public void setRemHoraNoctur(Double remHoraNoctur) {
		this.remHoraNoctur = remHoraNoctur;
	}

	public String getValorTipoTard() {
		return valorTipoTard;
	}

	public void setValorTipoTard(String valorTipoTard) {
		this.valorTipoTard = valorTipoTard;
	}

	public String getValorClaseTipoTard() {
		return valorClaseTipoTard;
	}

	public void setValorClaseTipoTard(String valorClaseTipoTard) {
		this.valorClaseTipoTard = valorClaseTipoTard;
	}

	public Integer getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(Integer idBanco) {
		this.idBanco = idBanco;
	}

	public Double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(Double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	public Integer getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public String getNroCuentaBanco() {
		return nroCuentaBanco;
	}

	public void setNroCuentaBanco(String nroCuentaBanco) {
		this.nroCuentaBanco = nroCuentaBanco;
	}

	public Integer getComiMix() {
		return comiMix;
	}

	public void setComiMix(Integer comiMix) {
		this.comiMix = comiMix;
	}

	public Double getRemComisiones() {
		return remComisiones;
	}

	public void setRemComisiones(Double remComisiones) {
		this.remComisiones = remComisiones;
	}
	
	

}
