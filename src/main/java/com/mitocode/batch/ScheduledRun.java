package com.mitocode.batch;

import java.util.Calendar;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mitocode.exception.ExceptionResponse;
 
@Component
@EnableScheduling
public class ScheduledRun {

	@Autowired
    private JobLauncher launcher;
     
    @Autowired
    private Job AsistenciaJob;
    
    @Autowired
    private Job VacacionesJob;
     
    
    private JobExecution execution;
     
    @Scheduled(cron="0 0 0 ? * 6,7")
    //@Scheduled(cron="*/10 * * * * *")
    public void runAsistenciaSchedule(){
        try {
        	execution = launcher.run(AsistenciaJob, new JobParametersBuilder()
        			.addLong("timestamp",System.currentTimeMillis())
        			.toJobParameters());
            System.out.println("Execution status: "+ execution.getStatus());
        } catch (JobExecutionAlreadyRunningException e) {
        	new ExceptionResponse(new Date(),e.getMessage(),this.getClass().getSimpleName()+" Error al ejecutar el Job Asistencia, ERROR: "+e.getStackTrace()[0].getClassName(),e);
        } catch (JobRestartException e) {           
        	new ExceptionResponse(new Date(),e.getMessage(),this.getClass().getSimpleName()+" Error al ejecutar el Job Asistencia, ERROR: "+e.getStackTrace()[0].getClassName(),e);
        } catch (JobInstanceAlreadyCompleteException e) {           
        	new ExceptionResponse(new Date(),e.getMessage(),this.getClass().getSimpleName()+" Error al ejecutar el Job Asistencia, ERROR: "+e.getStackTrace()[0].getClassName(),e);
        } catch (JobParametersInvalidException e) {         
        	new ExceptionResponse(new Date(),e.getMessage(),this.getClass().getSimpleName()+" Error al ejecutar el Job Asistencia, ERROR: "+e.getStackTrace()[0].getClassName(),e);
        }
    }
    
    
   //@Scheduled(cron="*/10 * * ? * *")
   @Scheduled(cron="0 0 0 15,28-31 * ?")
   public void runVacacionesSchedule(){
        try {
        	final Calendar c = Calendar.getInstance();
            if (c.get(Calendar.DATE) == c.getActualMaximum(Calendar.DATE)) {
            	execution = launcher.run(VacacionesJob, new JobParametersBuilder()
            			.addLong("timestamp",System.currentTimeMillis())
            			.toJobParameters());
                System.out.println("Execution status: "+ execution.getStatus());
          }
 
        } catch (JobExecutionAlreadyRunningException e) {
            new ExceptionResponse(new Date(),e.getMessage(),this.getClass().getSimpleName()+" Error al ejecutar el Job Vacaciones, ERROR: "+e.getStackTrace()[0].getClassName(),e);
        } catch (JobRestartException e) {           
        	new ExceptionResponse(new Date(),e.getMessage(),this.getClass().getSimpleName()+" Error al ejecutar el Job Vacaciones, ERROR: "+e.getStackTrace()[0].getClassName(),e);
        } catch (JobInstanceAlreadyCompleteException e) {           
        	new ExceptionResponse(new Date(),e.getMessage(),this.getClass().getSimpleName()+" Error al ejecutar el Job Vacaciones, ERROR: "+e.getStackTrace()[0].getClassName(),e);
        } catch (JobParametersInvalidException e) {         
        	new ExceptionResponse(new Date(),e.getMessage(),this.getClass().getSimpleName()+" Error al ejecutar el Job, ERROR: "+e.getStackTrace()[0].getClassName(),e);
        }
    }
    
}
