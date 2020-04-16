package com.mitocode.service;

import java.util.List;

import com.mitocode.model.AdelantoSueldo;
import com.mitocode.model.CuotaAdelanto;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.Trabajador;

public interface CuotaAdelantoService extends ICRUD<CuotaAdelanto>{

	List<CuotaAdelanto> listarXAdeSue(AdelantoSueldo adeSue);

	CuotaAdelanto Pagado(CuotaAdelanto obj);

	List<CuotaAdelanto> listarXTrabPAnoPMes(Trabajador trab, PdoAno pdoAno, PdoMes pdoMes);

	CuotaAdelanto EncontrarCuoAde(Integer id);

}
