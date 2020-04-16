	package com.mitocode.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	public JobBuilderFactory jobbuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepbuilderFactory;
	
	@Bean
	@Primary
	public Tasklet StepAsistenciaTasklet() {
		return new AsistenciaStepTasklet();
	}
	
	@Bean
	@Primary
	public Tasklet StepVacacionPrimeroTasklet() {
		return new PrimeraVacacionStepTasklet();
	}
	
	@Bean
	@Primary
	public Tasklet StepVacacionSegundoTasklet() {
		return new SiguientesVacacionStepTasklet();
	}
	
	@Bean
	public Step VacacionPrimeroStep() {
		return stepbuilderFactory
				.get("VacacionPrimeroStep")
				.tasklet(StepVacacionPrimeroTasklet())
				.build();
	}
	
	@Bean
	public Step VacacionSegundaStep() {
		return stepbuilderFactory
				.get("VacacionSegundaStep")
				.tasklet(StepVacacionSegundoTasklet())
				.build();
	}
	
	
	@Bean
	public Step AsistenciaStep() {
		return stepbuilderFactory
				.get("AsistenciaStep")
				.tasklet(StepAsistenciaTasklet())
				.build();
	}
	
	@Bean
	public Job AsistenciaJob(AsistenciaJobListener listener) {
		return jobbuilderFactory
				.get("AsistenciaJob")
				.preventRestart()
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.start(AsistenciaStep())
				//.next(processBatch(new SunatReaderChunk(1), itemProcessor(), itemWritter()))
				.build();
	}
	
	@Bean
	public Job VacacionesJob(VacacionesJobListener listener) {
		return jobbuilderFactory
				.get("VacacionesJob")
				.preventRestart()
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.start(VacacionPrimeroStep())
				.next(VacacionSegundaStep())
				.build();
	}
}
