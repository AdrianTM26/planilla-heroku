package com.mitocode.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="contrato")
public class Contrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idContrato;
	
	@NotNull(message="El campo de regimen alternativo acumulativo o atipico no puede estar vacio")
	@Column(name="reg_alter_acu_atp", nullable = false)
	private Integer regAlterAcuAtp;
	
	@NotNull(message="El campo de discapacidad no puede estar vacio")
	@Column(name="discap", nullable = false)
	private Integer  discap;
	
	@Column(name="jor_max", nullable = true)
	private Integer jorMax;
	
	@Column(name="hor_noc", nullable = true)
	private Integer horNoc;
	
	@NotNull(message="La fecha de inicio del contrato no puede estar vacio")
	@Column(name="fec_inicio", nullable = false)
	private Timestamp fecInicio;
	
	@Column(name="fec_fin", nullable = true)
	private Timestamp fecFin;
	
	@NotNull(message="El sueldo base no puede estar vacio")
	@Column(name="sueldo_base", nullable = false)
	private Double sueldoBase;
	
	@NotNull(message="El tipo de comprobante no puede estar vacio")
	@Column(name="tipo_comprobante", nullable=false)
	private Integer tipoComprob;
	
	@Column(name="valor_hora", nullable = true)
	private Double valorHora;
	
	@Column(name = "tipo_cuenta", nullable = true)
	private Integer tipoCuenta;
	
	@Column(name = "tipo_moneda", nullable = true)
	private Integer tipoMoneda;
	
	@Length(message="El numero de la cuenta del trabajador no debe exceder de 20 caracteres",min=0,max=20)
	@Column(name="nro_cta", length = 20, nullable = true)
	private String nroCta;
	
	@Length(message="El codigo de cuenta interbancario del trabajador no debe exceder de 20 caracteres",min=0,max=20)
	@Column(name="nro_cci", length = 20, nullable = true)
	private String nroCci;
	
	@Column(name="movilidad", nullable = true)
	private Double movilidad;
	
	@Column(name="otr_igr_5ta", nullable = true)
	private Integer otrIgr5ta;
	
	@Column(name="sindical", nullable = true)
	private Integer sindical;
	
	@Column(name="quinta_exo", nullable = true)
	private Integer quintaExo;
	
	@Length(message="El numero de la cuenta CTS del trabajador no debe exceder de 20 caracteres",min=0,max=20)
	@Column(name="cuenta_CTS", length = 20, nullable = true)
	private String cuentaCTS;
	
	@Column(name = "eps_serv_prop_salud", nullable = true)
	private Integer epsServPropSalud;
	
	@Column(name = "fecha_firma_contrato")
	private Timestamp fechaFirma;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "contrato")
	private List<PlanillaHistorico> lsplanillaHistorico;
	
	
	//@JsonIgnore7

	@OneToOne
	@JoinColumn(name="id_trabajador", nullable = false)
	private Trabajador trabajador;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_regimen_laboral", nullable = true)
	private RegimenLaboral regimenLaboral;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_tipo_contrato", nullable = false)
	private TipoContrato tipoContrato;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_centro_costo", nullable = true)
	private CentroCosto centroCosto;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_categoria", nullable = true)
	private Categoria categoria;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_cargo", nullable = true)
	private Cargo cargo;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_tipo_pago", nullable = false)
	private TipoPago tipoPago;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_banco_sueldo", nullable = true)
	private Banco bancoSueldo;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_eps_salud", nullable = true)
	private Eps epsSalud;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_eps_pension", nullable = true)
	private Eps epsPension;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_banco_cts", nullable = true)
	private Banco bancoCts;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_sctr_pension", nullable = true)
	private Sctr sctrPension;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_sctr_salud", nullable = true)
	private Sctr sctrSalud;
	
	
	public Integer getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}

	public Integer getRegAlterAcuAtp() {
		return regAlterAcuAtp;
	}

	public void setRegAlterAcuAtp(Integer regAlterAcuAtp) {
		this.regAlterAcuAtp = regAlterAcuAtp;
	}

	public Integer getDiscap() {
		return discap;
	}

	public void setDiscap(Integer discap) {
		this.discap = discap;
	}

	public Integer getJorMax() {
		return jorMax;
	}

	public void setJorMax(Integer jorMax) {
		this.jorMax = jorMax;
	}

	public Integer getHorNoc() {
		return horNoc;
	}

	public void setHorNoc(Integer horNoc) {
		this.horNoc = horNoc;
	}

	public Timestamp getFecInicio() {
		return fecInicio;
	}

	public void setFecInicio(Timestamp fecInicio) {
		this.fecInicio = fecInicio;
	}

	public Double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public String getNroCta() {
		return nroCta;
	}

	public void setNroCta(String nroCta) {
		this.nroCta = nroCta;
	}

	public String getNroCci() {
		return nroCci;
	}

	public void setNroCci(String nroCci) {
		this.nroCci = nroCci;
	}

	public Double getMovilidad() {
		return movilidad;
	}

	public void setMovilidad(double movilidad) {
		this.movilidad = movilidad;
	}

	public Integer getOtrIgr5ta() {
		return otrIgr5ta;
	}

	public void setOtrIgr5ta(Integer otrIgr5ta) {
		this.otrIgr5ta = otrIgr5ta;
	}

	public Integer getSindical() {
		return sindical;
	}

	public void setSindical(Integer sindical) {
		this.sindical = sindical;
	}

	public Integer getQuintaExo() {
		return quintaExo;
	}

	public void setQuintaExo(int quintaExo) {
		this.quintaExo = quintaExo;
	}

	public String getCuentaCTS() {
		return cuentaCTS;
	}

	public void setCuentaCTS(String cuentaCTS) {
		this.cuentaCTS = cuentaCTS;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public RegimenLaboral getRegimenLaboral() {
		return regimenLaboral;
	}

	public void setRegimenLaboral(RegimenLaboral regimenLaboral) {
		this.regimenLaboral = regimenLaboral;
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public CentroCosto getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(CentroCosto centroCosto) {
		this.centroCosto = centroCosto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	public Banco getBancoSueldo() {
		return bancoSueldo;
	}

	public void setBancoSueldo(Banco bancoSueldo) {
		this.bancoSueldo = bancoSueldo;
	}

	public Banco getBancoCts() {
		return bancoCts;
	}

	public void setBancoCts(Banco bancoCts) {
		this.bancoCts = bancoCts;
	}

	public Sctr getSctrPension() {
		return sctrPension;
	}

	public void setSctrPension(Sctr sctrPension) {
		this.sctrPension = sctrPension;
	}

	public Sctr getSctrSalud() {
		return sctrSalud;
	}

	public void setSctrSalud(Sctr sctrSalud) {
		this.sctrSalud = sctrSalud;
	}

	public Eps getEpsSalud() {
		return epsSalud;
	}
	
	public Timestamp getFecFin() {
		return fecFin;
	}

	public void setFecFin(Timestamp fecFin) {
		this.fecFin = fecFin;
	}

	public Integer getTipoComprob() {
		return tipoComprob;
	}

	public void setTipoComprob(Integer tipoComprob) {
		this.tipoComprob = tipoComprob;
	}

	public void setSueldoBase(Double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public void setMovilidad(Double movilidad) {
		this.movilidad = movilidad;
	}

	public void setQuintaExo(Integer quintaExo) {
		this.quintaExo = quintaExo;
	}

	public void setEpsSalud(Eps epsSalud) {
		this.epsSalud = epsSalud;
	}

	public Eps getEpsPension() {
		return epsPension;
	}

	public void setEpsPension(Eps epsPension) {
		this.epsPension = epsPension;
	}

	public Integer getEpsServPropSalud() {
		return epsServPropSalud;
	}

	public void setEpsServPropSalud(Integer epsServPropSalud) {
		this.epsServPropSalud = epsServPropSalud;
	}

	public List<PlanillaHistorico> getLsplanillaHistorico() {
		return lsplanillaHistorico;
	}

	public void setLsplanillaHistorico(List<PlanillaHistorico> lsplanillaHistorico) {
		this.lsplanillaHistorico = lsplanillaHistorico;
	}

	public Timestamp getFechaFirma() {
		return fechaFirma;
	}

	public void setFechaFirma(Timestamp fechaFirma) {
		this.fechaFirma = fechaFirma;
	}

	public Integer getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(Integer tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Integer getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(Integer tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	
}
