package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.Categoria;
import com.mitocode.model.Contrato;
import com.mitocode.model.Trabajador;

public interface ContratoRepo extends JpaRepository<Contrato, Integer> {
	
	@Query(value="select distinct c.*,t.* from contrato c inner join trabajador t on t.id_trabajador = c.id_trabajador\r\n" + 
			" inner join empresa e on e.id_empresa = t.id_empresa where e.id_empresa = :idEmpresa order by t.ape_pater", nativeQuery = true)
	List<Contrato> listarPorEmpresa(@Param("idEmpresa") Integer idEmpresa);
	
	List<Contrato> findByCategoria(Categoria categoria);
	
	Contrato findByTrabajador(Trabajador trabajador);
	
	@Query(value="select distinct c.*,t.* from contrato c inner join trabajador t on t.id_trabajador = c.id_trabajador\r\n" + 
			" inner join empresa e on e.id_empresa = t.id_empresa where e.id_empresa = :idEmpresa and c.tipo_comprobante= :idTipoComprobante"
			+ " order by t.ape_pater", nativeQuery = true)
	List<Contrato> listarPorEmpresaYTipoComprobante(@Param("idEmpresa") Integer idEmpresa,@Param("idTipoComprobante") Integer idTipoComprobante);
	
	
	@Query(value="select ct.id_contrato, ct.cuenta_cts, ct.discap, ct.eps_serv_prop_salud, ct.fec_fin, ct.fec_inicio, ct.fecha_firma_contrato,\r\n" + 
			"  ct.hor_noc, ct.jor_max, ct.movilidad, ct.nro_cci, ct.nro_cta, ct.otr_igr_5ta, ct.quinta_exo, ct.reg_alter_acu_atp,\r\n" + 
			"  ct.sindical, ct.sueldo_base, ct.tipo_comprobante, ct.valor_hora, ct.tipo_cuenta, ct.tipo_moneda, ct.id_banco_cts,ct.id_banco_sueldo, ct.id_cargo ,\r\n" + 
			"  ct.id_categoria, ct.id_centro_costo, ct.id_eps_pension, ct.id_eps_salud, ct.id_regimen_laboral, ct.id_sctr_pension ,\r\n" + 
			"  ct.id_sctr_salud, ct.id_tipo_contrato, ct.id_tipo_pago, ct.id_trabajador from trabajador tr \r\n" + 
			"			Inner Join contrato ct On tr.id_trabajador = ct.id_trabajador\r\n" + 
			"			Inner Join empresa emp On emp.id_empresa = tr.id_empresa where emp.id_empresa=:idEmpresa And ct.tipo_comprobante=:tipo_comprobante", nativeQuery = true)
	List<Contrato> listarPorEmpresaYCuartaCat(@Param("idEmpresa") Integer idEmpresa,@Param("tipo_comprobante") Integer tipoComprobante);
}
