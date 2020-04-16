package com.mitocode.batch;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Contrato;
import com.mitocode.model.Trabajador;
import com.mitocode.model.Vacaciones;
import com.mitocode.repo.ContratoRepo;
import com.mitocode.repo.TrabajadorRepo;
import com.mitocode.repo.VacacionesRepo;

public class PrimeraVacacionStepTasklet implements Tasklet, StepExecutionListener {
	
	Integer index_error = 0;
	@Autowired
	TrabajadorRepo repoTrabajador;
	
	@Autowired
	VacacionesRepo repoVacaciones;
	
	@Autowired
	ContratoRepo repoContrato;
	

	private static final Logger LOG = LoggerFactory.getLogger(AsistenciaStepTasklet.class);
	private final Date fecha_actual = new Date(Calendar.getInstance().getTime().getTime());

	@Override
	public void beforeStep(StepExecution stepExecution) {
		LOG.info("Primeras Vacaciones Step iniciado. . . Fecha actual: "+this.fecha_actual);


	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		LOG.info("Primeras Vacaciones Processor ended. Estado: " + stepExecution.getStatus());
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
		List<Trabajador> lsTrabajador = new ArrayList<>();
		try {
			lsTrabajador = repoTrabajador.findAll();
			for(Trabajador trabajador: lsTrabajador) {
				if(repoVacaciones.existsByTrabajador(trabajador)) {
					LOG.warn("El trabajador  "+trabajador.getNombres()+" ya presenta registro de vacaciones");
				}else {
					LOG.info("es la primera vacacion de   "+trabajador.getNombres());
					Contrato contrato = repoContrato.findByTrabajador(trabajador);
					Date fecha = new Date(contrato.getFecInicio().getTime());
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(fecha); 
					calendar.add(Calendar.MONTH,6);
					index_error++;
					if(calendar.getTime().compareTo(this.fecha_actual)==-1) {
						LOG.info("Le corresponse vacacion primera a "+ trabajador.getNombres()+ " Fecha Vac Inicio: "+ fecha + " Fecha Vac Fin: " + calendar.getTime());
						Vacaciones vacacion = new Vacaciones();
						vacacion.setTrabajador(trabajador);
						vacacion.setDiasTomados(0);
						vacacion.setDiasVendidos(0);
						vacacion.setEstado(1);
						vacacion.setFechaIni(fecha);
						vacacion.setFechaFin(new Date(calendar.getTime().getTime()));
						repoVacaciones.save(vacacion);
						LOG.info("Vacacion para "+trabajador.getNombres()+" registrada correctamente");
						
					}else {
						LOG.warn("No le corresponde aun vacaciones a " + trabajador.getNombres());
					}
				}
			}
			
			return RepeatStatus.FINISHED;
			
		} catch (Exception e) {
			System.err.println("ERROR: " + this.getClass().getSimpleName() + " Error en los CRUD " + e.getMessage());
			System.err.println(
					this.getClass().getSimpleName() + "Error " + "Linea nro : " + e.getStackTrace()[0].getLineNumber());
			throw new ExceptionResponse(new java.util.Date(),e.getMessage(),"ERROR: " + this.getClass().getSimpleName()+ "batchError: PrimeraVacacionStepTasklet "+
					"Error " + "Linea nro : " + e.getStackTrace()[0].getLineNumber(),lsTrabajador.get(index_error));
		}
	}

}
