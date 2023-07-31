package com.first.tech.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.first.tech.model.Employee;

@Service
public class EmployeeService {

	private Map<UUID, Employee> employees;
	
	public EmployeeService() {
		employees = new LinkedHashMap<>();
	}
	
	public Employee addEmployee(Employee employee) {
		UUID id = UUID.randomUUID();
		employee.setId(id);
		employees.put(id, employee);
		return employee;
	}
	
	public Employee getEmployee(UUID id) {
        return employees.get(id);
    }
	
	 public List<Employee> getAllEmployees() {
	        return new ArrayList<>(employees.values());
	    }

	public Employee updateEmployee(Employee employee) {
		UUID id = employee.getId();
	    Employee e = employees.get(id);
	    
	    if (e != null) {
	        employees.put(id, employee);
	        return employee; 
	    }
	    
	    return null;
	}
    
	public void removeEmployee(UUID id) {
		Employee e = this.getEmployee(id);
		if(e != null) {
			employees.remove(id);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID inexistente, passe um ID válido para deletar!");
		}
	
        
    } 
    
	
}
