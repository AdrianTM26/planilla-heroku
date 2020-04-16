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
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "trabajador")
public class Trabajador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTrabajador;

	@NotNull(message="Los nombres del trabajador no pueden estar vacios")
	@Length(message="Los nombres del trabajador no pueden exceder de 80 caracteres", min=0,max=80)
	@Column(name = "nombres", nullable = false, length = 80)
	private String nombres;
	
	@NotNull(message="El apellido paterno del trabajador no puede estar vacio")
	@Length(message="El apellido paterno del trabajador no puede exceder de 80 caracteres", min=0,max=80)
	@Column(name = "ape_pater", nullable = false, length = 80)
	private String apePater;
	
	@NotNull(message="El apellido materno del trabajador no puede estar vacio")
	@Length(message="El apellido materno del trabajador no puede exceder de 80 caracteres", min=0,max=80)
	@Column(name = "ape_mater", nullable = false, length = 80)
	private String apeMater;
	
	@NotNull(message="El numero de documento del trabajador no puede estar vacio")
	@Length(message="El numero de documento del trabajador no puede exceder de 80 caracteres", min=0,max=80)
	@Column(name = "nro_doc", nullable = false, length = 80)
	private String nroDoc;
	
	@NotNull(message="La fecha de nacimiento no puede estar vacio")
	@Column(name = "fec_nac", nullable = false)
	private Timestamp fecNac;
	
	@NotNull(message="El sexo de trabajador no puede estar vacio")
	@Column(name = "sexo", nullable = false, length = 1)
	private String sexo;
	
	@Length(message="El correo no puede exceder de 80 caracteres", min=0,max=80)
	@Email(message="El correo debe contener un formato valido")
	@Column(name = "correo", nullable = true, length = 80)
	private String correo;
	
	@Length(message="El numero de celular debe contener 9 digitos", min=9,max=9)
	@Column(name = "nro_cel", nullable = true, length = 9)
	private String nroCel;
	
	@NotNull(message="La direccion del domicilio no puede estar vacia")
	@Length(message="La direccion del domicilio no puede exceder de 100 caracteres", min=0,max=100)
	@Column(name = "direccion", nullable = false, length = 100)
	private String direccion;
	
	@Length(message="El nombre de la zona del domicilio no puede exceder de 80 caracteres", min=0,max=80)
	@Column(name = "nom_zona", nullable = true, length = 80)
	private String nomZona;
	
	@Length(message="La referencia del domicilio no puede exceder de 200 caracteres", min=0,max=200)
	@Column(name = "referencia", nullable = true, length = 200)
	private String referencia;
	
	@NotNull(message="Debe indicar una cantidad numerica para el numero de hijos del trabajador")
	@PositiveOrZero(message="La cantidad de hijos no puede ser un numero negativo")
	@Column(name = "nro_hij", nullable = false)
	private Integer nroHij;
	
	@Column(name = "fec_reg_pens", nullable = true)
	private Timestamp fecRegPens;
	
	@Length(message="El Código Único de Identificación del Sistema Privado de Pensiones no puede exceder de 20 caracteres", min=0,max=20)
	@Column(name = "nro_cuspp", nullable = true, length = 20)
	private String nroCuspp;
	
	@Column(name = "fec_ingr_salud", nullable = true)
	private Timestamp fecIngrSalud;
	
	@Length(message="El numero de codigo de Essalud no puede exceder de 20 caracteres", min=0,max=20)
	@Column(name = "nro_essalud", nullable = true, length = 20)
	private String nroEssalud;
	
	@Column(name = "essalud_vida", nullable = true)
	private Integer essaludVida;
	
	@Column(name = "afil_asegu_pens", nullable = true)
	private Integer afilAseguPens;
	
	@Column(name = "eps_serv_prop", nullable = true)
	private Integer epsServProp;
	
	@Column(name = "comi_mixta", nullable = true)
	private Integer comiMixta;
	
	@Transient
	private Boolean estado;	

	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_tipo_doc", nullable = false)
	private TipoDoc tipoDoc;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_pais", nullable = true)
	private Pais pais;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_estado_civil", nullable = false)
	private EstadoCivil estadoCivil;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_departamento", nullable = false)
	private Departamento departamento;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_provincia", nullable = false)
	private Provincia provincia;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_distrito", nullable = false)
	private Distrito distrito;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_tipo_zona", nullable = true)
	private TipoZona tipoZona;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_nivel_edu", nullable = false)
	private NivelEdu nivelEdu;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_ocupacion", nullable = true)
	private Ocupacion ocupacion;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable = false)
	private Empresa empresa;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_afp", nullable = true)
	private Afp afp;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_eps", nullable = true)
	private Eps eps;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_reg_salud", nullable = true)
	private RegSalud regSalud;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_situacion", nullable = false)
	private Situacion situacion;
	
	@ManyToOne
	@JoinColumn(name="id_horario", nullable=false)
	private Horario horario;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajador")
	private List<Contrato> lsContrato;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajador")
	private List<DerechoHabientes> lsderechoHabiente;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "trabajador")
	private Suspencion suspencion;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajador")
	private List<Rhe> rhe;
	
	public Integer getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(Integer idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApePater() {
		return apePater;
	}

	public void setApePater(String apePater) {
		this.apePater = apePater;
	}

	public String getApeMater() {
		return apeMater;
	}

	public void setApeMater(String apeMater) {
		this.apeMater = apeMater;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

	public Timestamp getFecNac() {
		return fecNac;
	}

	public void setFecNac(Timestamp fecNac) {
		this.fecNac = fecNac;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNroCel() {
		return nroCel;
	}

	public void setNroCel(String nroCel) {
		this.nroCel = nroCel;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNomZona() {
		return nomZona;
	}

	public void setNomZona(String nomZona) {
		this.nomZona = nomZona;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Integer getNroHij() {
		return nroHij;
	}

	public void setNroHij(Integer nroHij) {
		this.nroHij = nroHij;
	}

	public Timestamp getFecRegPens() {
		return fecRegPens;
	}

	public void setFecRegPens(Timestamp fecRegPens) {
		this.fecRegPens = fecRegPens;
	}

	public String getNroCuspp() {
		return nroCuspp;
	}

	public void setNroCuspp(String nroCuspp) {
		this.nroCuspp = nroCuspp;
	}

	public Timestamp getFecIngrSalud() {
		return fecIngrSalud;
	}

	public void setFecIngrSalud(Timestamp fecIngrSalud) {
		this.fecIngrSalud = fecIngrSalud;
	}

	public String getNroEssalud() {
		return nroEssalud;
	}

	public void setNroEssalud(String nroEssalud) {
		this.nroEssalud = nroEssalud;
	}

	public Integer getEssaludVida() {
		return essaludVida;
	}

	public void setEssaludVida(Integer essaludVida) {
		this.essaludVida = essaludVida;
	}

	public Integer getAfilAseguPens() {
		return afilAseguPens;
	}

	public void setAfilAseguPens(Integer afilAseguPens) {
		this.afilAseguPens = afilAseguPens;
	}

	public Integer getEpsServProp() {
		return epsServProp;
	}

	public void setEpsServProp(Integer epsServProp) {
		this.epsServProp = epsServProp;
	}

	public TipoDoc getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDoc tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public TipoZona getTipoZona() {
		return tipoZona;
	}

	public void setTipoZona(TipoZona tipoZona) {
		this.tipoZona = tipoZona;
	}

	public NivelEdu getNivelEdu() {
		return nivelEdu;
	}

	public void setNivelEdu(NivelEdu nivelEdu) {
		this.nivelEdu = nivelEdu;
	}

	public Ocupacion getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(Ocupacion ocupacion) {
		this.ocupacion = ocupacion;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Afp getAfp() {
		return afp;
	}

	public void setAfp(Afp afp) {
		this.afp = afp;
	}

	public Eps getEps() {
		return eps;
	}

	public void setEps(Eps eps) {
		this.eps = eps;
	}

	public RegSalud getRegSalud() {
		return regSalud;
	}

	public void setRegSalud(RegSalud regSalud) {
		this.regSalud = regSalud;
	}

	public Situacion getSituacion() {
		return situacion;
	}

	public void setSituacion(Situacion situacion) {
		this.situacion = situacion;
	}

	public Integer getComiMixta() {
		return comiMixta;
	}

	public void setComiMixta(Integer comiMixta) {
		this.comiMixta = comiMixta;
	}

	public List<Contrato> getLsContrato() {
		return lsContrato;
	}

	public void setLsContrato(List<Contrato> lsContrato) {
		this.lsContrato = lsContrato;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}
