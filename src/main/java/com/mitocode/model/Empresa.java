package com.mitocode.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "empresa")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmpresa;
	
	@NotNull(message="La razon social no puede estar vacia")
	@Length(message="La razon social no puede exceder de 100 caracteres", min=0, max=100)
	@Column(name = "razon_social", nullable = false, length = 100)
	private String razonSocial;

	@NotNull(message="El ruc no puede estar vacio")
	@Length(message="El ruc solo puede contener 11 caracteres", min=11, max=11)
	@Column(name = "ruc", nullable = false, length = 11)
	private String ruc;

	@NotNull(message="La ubicacion no puede estar vacia")
	@Column(name ="ubicacion", nullable = false)
	private String ubicacion;	
	
	@Column(name = "estado", nullable = true)
	private Integer estado;

	@Column(name = "fecha_registro", nullable = true)
	private Timestamp fechaRegistro;
	
	private Integer sector;

	@Column(name = "url_imagen", nullable = true, length = 120)
	private String urlImagen;

	@Column(name = "logo", nullable = true, length = 120)
	private String logo;

	@Column(name = "company_limit", nullable = true)
	private Double companyLimit;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_emp", nullable = false, foreignKey = @ForeignKey(name = "fk_tipo_empresa"))
	private TipoEmpresa TipoEmp;
	
	@ManyToOne
	@JoinColumn(name = "id_reg_trib", nullable = true, foreignKey = @ForeignKey(name = "fk_reg_empresa"))
	private RegimenTributario regTrib; 

	@Column(name = "limite_autorizacion", nullable = true)
	private Integer limiteAutorizacion;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private List<Parametro> lsparametro;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private List<Categoria> lscategoria;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private List<Afp> lsafp;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private List<CentroCosto> lscentroCosto;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private List<PdoAno> lsPdoAno;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private List<Eps> lsEps;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private List<Trabajador> lstrabajador;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private List<EncargadoPlanilla> lsEncargadoPlanilla;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private List<CuentaCargo> lsCuentaCargo;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private List<TipoPermiso> lsTipoPermiso;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private List<Horario> lsHorario;

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getSector() {
		return sector;
	}

	public void setSector(Integer sector) {
		this.sector = sector;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Double getCompanyLimit() {
		return companyLimit;
	}

	public void setCompanyLimit(Double companyLimit) {
		this.companyLimit = companyLimit;
	}

	public TipoEmpresa getTipoEmp() {
		return TipoEmp;
	}

	public void setTipoEmp(TipoEmpresa tipoEmp) {
		TipoEmp = tipoEmp;
	}

	public RegimenTributario getRegTrib() {
		return regTrib;
	}

	public void setRegTrib(RegimenTributario regTrib) {
		this.regTrib = regTrib;
	}

	public Integer getLimiteAutorizacion() {
		return limiteAutorizacion;
	}

	public void setLimiteAutorizacion(Integer limiteAutorizacion) {
		this.limiteAutorizacion = limiteAutorizacion;
	}

	public List<Parametro> getLsparametro() {
		return lsparametro;
	}

	public void setLsparametro(List<Parametro> lsparametro) {
		this.lsparametro = lsparametro;
	}

	public List<Categoria> getLscategoria() {
		return lscategoria;
	}

	public void setLscategoria(List<Categoria> lscategoria) {
		this.lscategoria = lscategoria;
	}

	public List<Afp> getLsafp() {
		return lsafp;
	}

	public void setLsafp(List<Afp> lsafp) {
		this.lsafp = lsafp;
	}

	public List<CentroCosto> getLscentroCosto() {
		return lscentroCosto;
	}

	public void setLscentroCosto(List<CentroCosto> lscentroCosto) {
		this.lscentroCosto = lscentroCosto;
	}

	public List<PdoAno> getLsPdoAno() {
		return lsPdoAno;
	}

	public void setLsPdoAno(List<PdoAno> lsPdoAno) {
		this.lsPdoAno = lsPdoAno;
	}

	public List<Eps> getLsEps() {
		return lsEps;
	}

	public void setLsEps(List<Eps> lsEps) {
		this.lsEps = lsEps;
	}

	public List<Trabajador> getLstrabajador() {
		return lstrabajador;
	}

	public void setLstrabajador(List<Trabajador> lstrabajador) {
		this.lstrabajador = lstrabajador;
	}

	public List<EncargadoPlanilla> getLsEncargadoPlanilla() {
		return lsEncargadoPlanilla;
	}

	public void setLsEncargadoPlanilla(List<EncargadoPlanilla> lsEncargadoPlanilla) {
		this.lsEncargadoPlanilla = lsEncargadoPlanilla;
	}

	public List<CuentaCargo> getLsCuentaCargo() {
		return lsCuentaCargo;
	}

	public void setLsCuentaCargo(List<CuentaCargo> lsCuentaCargo) {
		this.lsCuentaCargo = lsCuentaCargo;
	}

	public List<TipoPermiso> getLsTipoPermiso() {
		return lsTipoPermiso;
	}

	public void setLsTipoPermiso(List<TipoPermiso> lsTipoPermiso) {
		this.lsTipoPermiso = lsTipoPermiso;
	}

	public List<Horario> getLsHorario() {
		return lsHorario;
	}

	public void setLsHorario(List<Horario> lsHorario) {
		this.lsHorario = lsHorario;
	}

}
