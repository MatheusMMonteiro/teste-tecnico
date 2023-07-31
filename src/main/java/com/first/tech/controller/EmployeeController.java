package com.first.tech.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.first.tech.model.Employee;
import com.first.tech.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findEmployee(@PathVariable UUID id){
		Employee employee = service.getEmployee(id);
		
		if(employee != null) {
			return ResponseEntity.ok(employee);
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID inexistente, passe um ID válido para deletar!");
	}
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> employees = service.getAllEmployees();
		
		if(employees.isEmpty()) {
			return ResponseEntity.status(204).build();
		}
		return ResponseEntity.ok(employees);
		
		
		

	}
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
		Employee e = service.addEmployee(employee);
		if(e != null) {
			return ResponseEntity.status(201).body(e);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PutMapping
	public ResponseEntity<Employee> upadteEmployee(@Valid @RequestBody Employee employee){
		Employee e = service.updateEmployee(employee);
		if(e != null) {
			return ResponseEntity.ok(e);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID inexistente, passe um ID válido para deletar!");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable UUID id){
		service.removeEmployee(id);
		return ResponseEntity.status(204).build();
		
	}
	
	
}
