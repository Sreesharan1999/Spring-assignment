package com.gl.assignment.Springbootass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.Day2Practice.model.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/addemployee")
	public String addEmployee() {
		return "addemployee";
	}
	
	@PostMapping("/insertemployee")
	public String insertEmployee(@RequestParam int id , @RequestParam String firstname , @RequestParam String lastname , @RequestParam String address , @RequestParam String department , @RequestParam String designation) {
		Employee ecc=new Employee(id, firstname, lastname, address, department, designation);
		employeeService.add(ecc);
		return "home";
	}
	
	@RequestMapping("/selectemployee")
	public String selectEmployee(Model data) {
		List<Employee> employee = employeeService.getAll();
		data.addAttribute("employee", employee);
		return "selectemployee";
		
	}
	
	@GetMapping("/staffupdateform")
	public String staffUpdateForm(@RequestParam int id , Model data) {
		
		Employee employee = employeeService.getById(id);
		
		if(employee != null) {
			data.addAttribute("employee", employee);
			return "staffUpdateForm";
		}
		else {
			List<Employee> employees = employeeService.getAll();
			data.addAttribute("employee", employees);
			return "home";
		}
	}
		@PostMapping("/staffupdate")
		public String staffUpdate(@RequestParam int id , @RequestParam String firstname , @RequestParam String lastname , @RequestParam String address , @RequestParam String department , @RequestParam String designation , Model data) {
			
			Employee employee = new Employee(id, firstname, lastname, address, department, designation);
			employeeService.update(employee);
			
			List<Employee> employees = employeeService.getAll();
			data.addAttribute("employees", employees);
			return "home";
		
	}

}
