package com.mitocode.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mitocode.model.Afp;
import com.mitocode.model.Banco;
import com.mitocode.model.Cargo;
import com.mitocode.model.Categoria;
import com.mitocode.model.CentroCosto;
import com.mitocode.model.Contrato;
import com.mitocode.model.Departamento;
import com.mitocode.model.DerechoHabientes;
import com.mitocode.model.Descuentos;
import com.mitocode.model.Distrito;
import com.mitocode.model.Empresa;
import com.mitocode.model.Eps;
import com.mitocode.model.EstadoCivil;
import com.mitocode.model.Horario;
import com.mitocode.model.NivelEdu;
import com.mitocode.model.Ocupacion;
import com.mitocode.model.Pais;
import com.mitocode.model.Provincia;
import com.mitocode.model.RegSalud;
import com.mitocode.model.RegimenLaboral;
import com.mitocode.model.Remuneraciones;
import com.mitocode.model.Sctr;
import com.mitocode.model.Situacion;
import com.mitocode.model.TipoContrato;
import com.mitocode.model.TipoDoc;
import com.mitocode.model.TipoPago;
import com.mitocode.model.TipoZona;
import com.mitocode.model.Trabajador;

public class TrabajadorDTO {
	
	private TipoDoc tipoDoc;
	 
    private Pais pais;
	
    private EstadoCivil estadoCivil;

    private Departamento departamento;
	
    private Provincia provincia;
	
    private Distrito distrito;

    private TipoZona tipoZona;

    private NivelEdu nivelEdu;

    private Ocupacion ocupacion;

    private Empresa empresa;

    private Afp afp;

    private Eps epsRegSalud;

    private Eps epsSalud;

    private Eps epsPension;
	
    private RegSalud regSalud;
	
    private Situacion situacion;
	
    private RegimenLaboral regimenLaboral;
	
    private TipoContrato tipoContrato;
	
    private CentroCosto centroCosto;
    
    private Categoria categoria;
	
    private Cargo cargo;
    
    private TipoPago tipoPago;

    private Banco bancoSueldo;

    private Banco bancoCts;

    private Sctr sctrPension;

    private Sctr sctrSalud;

    private Horario horario;
    
    @NotNull(message="No se ha especificado un trabajador")
    private Trabajador trabajador;
    
    private Contrato contrato;
 
    private DerechoHabientes derechoHabientes;

    private Remuneraciones remuneraciones;

    private Descuentos descuentos;
    
	public Horario getHorario() {
		return horario;
	}
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	public TipoDoc getTipoDoc() {
		return tipoDoc;
	}
	public Pais getPais() {
		return pais;
	}
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public Distrito getDistrito() {
		return distrito;
	}
	public TipoZona getTipoZona() {
		return tipoZona;
	}
	public NivelEdu getNivelEdu() {
		return nivelEdu;
	}
	public Ocupacion getOcupacion() {
		return ocupacion;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public Afp getAfp() {
		return afp;
	}
	public Eps getEpsRegSalud() {
		return epsRegSalud;
	}
	public RegSalud getRegSalud() {
		return regSalud;
	}
	public Situacion getSituacion() {
		return situacion;
	}
	public RegimenLaboral getRegimenLaboral() {
		return regimenLaboral;
	}
	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}
	public CentroCosto getCentroCosto() {
		return centroCosto;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public TipoPago getTipoPago() {
		return tipoPago;
	}
	public Banco getBancoSueldo() {
		return bancoSueldo;
	}
	public Banco getBancoCts() {
		return bancoCts;
	}
	public Sctr getSctrPension() {
		return sctrPension;
	}
	public Sctr getSctrSalud() {
		return sctrSalud;
	}
	public Trabajador getTrabajador() {
		return trabajador;
	}
	public Contrato getContrato() {
		return contrato;
	}
	public void setTipoDoc(TipoDoc tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	public void setTipoZona(TipoZona tipoZona) {
		this.tipoZona = tipoZona;
	}
	public void setNivelEdu(NivelEdu nivelEdu) {
		this.nivelEdu = nivelEdu;
	}
	public void setOcupacion(Ocupacion ocupacion) {
		this.ocupacion = ocupacion;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public void setAfp(Afp afp) {
		this.afp = afp;
	}
	public void setEpsRegSalud(Eps epsRegSalud) {
		this.epsRegSalud = epsRegSalud;
	}
	public void setRegSalud(RegSalud regSalud) {
		this.regSalud = regSalud;
	}
	public void setSituacion(Situacion situacion) {
		this.situacion = situacion;
	}
	public void setRegimenLaboral(RegimenLaboral regimenLaboral) {
		this.regimenLaboral = regimenLaboral;
	}
	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public void setCentroCosto(CentroCosto centroCosto) {
		this.centroCosto = centroCosto;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}
	public void setBancoSueldo(Banco bancoSueldo) {
		this.bancoSueldo = bancoSueldo;
	}
	public void setBancoCts(Banco bancoCts) {
		this.bancoCts = bancoCts;
	}
	public void setSctrPension(Sctr sctrPension) {
		this.sctrPension = sctrPension;
	}
	public void setSctrSalud(Sctr sctrSalud) {
		this.sctrSalud = sctrSalud;
	}
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	public Eps getEpsSalud() {
		return epsSalud;
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
	public DerechoHabientes getDerechoHabientes() {
		return derechoHabientes;
	}
	public void setDerechoHabientes(DerechoHabientes derechoHabientes) {
		this.derechoHabientes = derechoHabientes;
	}
	public Remuneraciones getRemuneraciones() {
		return remuneraciones;
	}
	public void setRemuneraciones(Remuneraciones remuneraciones) {
		this.remuneraciones = remuneraciones;
	}
	public Descuentos getDescuentos() {
		return descuentos;
	}
	public void setDescuentos(Descuentos descuentos) {
		this.descuentos = descuentos;
	}
	
}
