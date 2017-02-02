package com.mahesh.model;

public class TestRole {

	public static void main(String[] args) {
		
		Role role=new Role();
		role.setId(1);
		role.setRole("Production Manager");
		role.setActive(1);
		
		System.out.println(role);

	}

}
