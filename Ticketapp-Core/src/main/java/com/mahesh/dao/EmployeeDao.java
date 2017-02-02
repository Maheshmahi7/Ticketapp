package com.mahesh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mahesh.model.Department;
import com.mahesh.model.Employee;
import com.mahesh.util.ConnectionUtil;

public class EmployeeDao {
	
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(Employee employee) {

		String sql = "INSERT INTO TICKET_EMPLOYEES(NAME,DEPARTMENT_ID,EMAIL_ID,PASSWORD,MOBILE_NUMBER) VALUES(?,?,?,?,?)";
		Object[] params = { employee.getName(),employee.getDepartmentId().getId(),employee.getEmailId(),employee.getPassword(),employee.getMobileNumber() };
		jdbcTemplate.update(sql, params);

	}
	
	public void update(Employee employee) {

		String sql = "UPDATE TICKET_EMPLOYEES SET NAME=?,DEPARTMENT_ID=?,MOBILE_NUMBER=? WHERE ID=?";
		Object[] params = { employee.getName(),employee.getDepartmentId().getId(),employee.getMobileNumber(),employee.getId() };
		jdbcTemplate.update(sql, params);


	}

	public void delete(int id) {

		String sql = "DELETE FROM TICKET_EMPLOYEES WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
		
		public List<Employee> list() {

			String sql = "SELECT ID,NAME,DEPARTMENT_ID,EMAIL_ID,PASSWORD,MOBILE_NUMBER,ACTIVE FROM TICKET_EMPLOYEES";
			return jdbcTemplate.query(sql, (rs, rowNum) -> {
				Employee employee=new Employee();
				employee.setId(rs.getInt("ID"));
				employee.setName(rs.getString("NAME"));
				Department department=new Department();
				department.setId(rs.getInt("DEPARTMENT_ID"));;
				employee.setDepartmentId(department);;
				employee.setEmailId(rs.getString("EMAIL_ID"));
				employee.setPassword(rs.getString("PASSWORD"));
				employee.setMobileNumber(rs.getLong("MOBILE_NUMBER"));
				employee.setActive(rs.getInt("ACTIVE"));
				return employee;

			});


	}


}
