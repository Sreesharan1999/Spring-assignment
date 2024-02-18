package com.gl.assignment.Springbootass;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.Day2Practice.model.Employee;

@SpringBootApplication
public class SpringbootassApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootassApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		java.util.List<Employee> employees = service.getAll();
		for(Employee temp : employees) {
			System.out.println(temp.toString());
		}
	
		
	}

}
