package com.mitocode.batch;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.mitocode.model.Asistencia;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.Trabajador;
import com.mitocode.repo.AsistenciaRepo;
import com.mitocode.repo.PdoAnoRepo;
import com.mitocode.repo.PdoMesRepo;
import com.mitocode.repo.TrabajadorRepo;

public class AsistenciaStepTasklet implements Tasklet, StepExecutionListener {

	@Autowired
	TrabajadorRepo repoTrabajador;

	@Autowired
	AsistenciaRepo repoAsistencia;

	@Autowired
	PdoAnoRepo repoPdoAno;

	@Autowired
	PdoMesRepo repoPdoMes;

	private static final Logger LOG = LoggerFactory.getLogger(AsistenciaStepTasklet.class);
	private Boolean esFeriado = false;
	Integer dia_actual_semana = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;
	Integer dia_actual_mes = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	Integer actual_mes = Calendar.getInstance().get(Calendar.MONTH) + 1;

	@Override
	public void beforeStep(StepExecution stepExecution) {
		LOG.info("Asistencia Step iniciado. . .");
		PdoMes mes = repoPdoMes.findByIdPdoMes(actual_mes);
		if (mes.getTxtDiasFeriados() != null) {
			String feriados[] = mes.getTxtDiasFeriados().split(",");
			for (String feriado : feriados) {
				if (feriado.compareTo(this.dia_actual_mes.toString()) == 0) {
					this.esFeriado = true;
				}
			}

		}
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		LOG.info("Asistencia Processor ended. Estado: " + stepExecution.getStatus());
		if (stepExecution.getStatus() == BatchStatus.COMPLETED) {
			return ExitStatus.COMPLETED;
		} else {
			if (stepExecution.getStatus() == BatchStatus.FAILED)
				return ExitStatus.FAILED;
			else {
				if (stepExecution.getStatus() == BatchStatus.STOPPED)
					return ExitStatus.STOPPED;
				else
					return ExitStatus.UNKNOWN;
			}
		}
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		try {

			List<Trabajador> lsTrabajador = repoTrabajador.findAll();
			LOG.info("trabajadores listados  correctamente");

			this.dia_actual_semana = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;
			Asistencia asistencia = new Asistencia();

			List<Asistencia> lsAsistencia = new ArrayList<Asistencia>();
			if (esFeriado) {
				LOG.info("No se registrara asistencias para el dia de hoy, es feriado");
			} else {
				for (Trabajador trabajador : lsTrabajador) {
					if (!trabajador.getHorario().getCheckSabado() && !trabajador.getHorario().getCheckDomingo()) {
						asistencia = setearAsistencia(trabajador);
						lsAsistencia.add(asistencia);
						LOG.info("Trabajador " + trabajador.getNombres()
								+ " agregado a la lista de asistencias para SAB y DOM   por batch");
					} else {
						switch (this.dia_actual_semana) {
						case 6:
							if (!trabajador.getHorario().getCheckSabado()) {
								asistencia = setearAsistencia(trabajador);
								lsAsistencia.add(asistencia);
								LOG.info("Trabajador " + trabajador.getNombres()
										+ " agregado a la lista de asistencias para SAB por batch");
							}
							;
							break;
						case 7:
							if (!trabajador.getHorario().getCheckDomingo()) {
								asistencia = setearAsistencia(trabajador);
								lsAsistencia.add(asistencia);
								LOG.info("Trabajador " + trabajador.getNombres()
										+ " agregado a la lista de asistencias para DOM por batch");
							}
							;
							break;
						}
					}
				}
			}

			List<Asistencia> resp = repoAsistencia.saveAll(lsAsistencia);
			LOG.info("Asistencias registradas correctamente, cantidad de trabajadores: " + lsAsistencia.size());
			return RepeatStatus.FINISHED;
		} catch (Exception e) {
			System.err.println("ERROR: " + this.getClass().getSimpleName() + " Error en los CRUD " + e.getMessage());
			System.err.println(
					this.getClass().getSimpleName() + "Error " + "Linea nro : " + e.getStackTrace()[0].getLineNumber());
			throw new Exception();
		}
	}

	public Asistencia setearAsistencia(Trabajador trabajador) {
		Asistencia asist = new Asistencia();
		asist.setFecha(new Date(Calendar.getInstance().getTime().getTime()));
		PdoAno ano = repoPdoAno.findByEmpresaAndDescripcion(trabajador.getEmpresa(),
				new Date(Calendar.getInstance().getTime().getTime()).getYear() + 1900);
		LOG.info("Año encontrado: " + ano.getDescripcion());
		Optional<PdoMes> mes = repoPdoMes.findById(new Date(Calendar.getInstance().getTime().getTime()).getMonth() + 1);
		LOG.info("Mes encontrado: " + mes.get().getDescripcion());
		asist.setPdoAno(ano);
		asist.setPdoMes(mes.get());
		asist.setTrabajador(trabajador);
		asist.setTipoAsistencia(0);
		return asist;
	}

}
