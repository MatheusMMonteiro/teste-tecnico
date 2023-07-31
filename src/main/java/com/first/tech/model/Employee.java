package com.first.tech.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



public class Employee {
	
	private UUID id;
	
	@NotBlank
	private String name;
	
	@NotNull
	private RoleEmployee role;
	
	@NotNull
	private double wage;
	
	@NotBlank
	private String phone;
	
	@NotBlank
	private String addres;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RoleEmployee getRole() {
		return role;
	}
	public void setRole(RoleEmployee role) {
		this.role = role;
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	
	
}
