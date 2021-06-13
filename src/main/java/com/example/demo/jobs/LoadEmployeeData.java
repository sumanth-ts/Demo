package com.example.demo.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.example.demo.model.Employee;

@EnableBatchProcessing
@Configuration
public class LoadEmployeeData {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@Bean
	public Job readEmployeesFile() {
		return jobBuilderFactory.get("readEmployeesFile")
				.incrementer(new RunIdIncrementer()).start(step1()).build();
				
	}
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Employee,Employee>chunk(10).reader(reader1())
				.writer(writer1()).build();
	}
	
	@Bean
	public FlatFileItemReader<Employee> reader1(){
		 FlatFileItemReader<Employee> reader= new FlatFileItemReader<>();
		 reader.setResource(new PathResource(("D:\\BackendProjects\\demo\\src\\main\\resources\\data\\employees.csv")));
		 reader.setLineMapper(new DefaultLineMapper<Employee>() {{
			 setLineTokenizer(new DelimitedLineTokenizer() {{
				 setNames(new String[] {"_id","userId","firstName","lastName","mobile"});
			 }});
			 setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {{
				 setTargetType(Employee.class);
			 }});
		 }});
		 
		return reader;
	}
	
	@Bean
	public MongoItemWriter<Employee> writer1(){
		MongoItemWriter<Employee> writer =new MongoItemWriter<Employee>();
		writer.setTemplate(mongoTemplate);
		writer.setCollection("Employee");
		
		return writer;
	}

}
