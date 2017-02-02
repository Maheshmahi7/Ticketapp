package com.mahesh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mahesh.model.Role;
import com.mahesh.util.ConnectionUtil;

public class RoleDao {

	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(String role) {

		String sql = "INSERT INTO TICKET_ROLES(ROLE) VALUES(?)";
		Object[] params = { role };
		jdbcTemplate.update(sql, params);

	}
	
	public void update(Role role) {

		String sql = "UPDATE TICKET_ROLES SET ACTIVE=? WHERE ID=?";
		Object[] params = { role.getActive(),role.getId() };
		jdbcTemplate.update(sql, params);


	}

	public void delete(int id) {

		String sql = "DELETE FROM TICKET_ROLES WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
		
		public List<Role> list() {

			String sql = "SELECT ID,ROLE,ACTIVE FROM TICKET_ROLES";
			return jdbcTemplate.query(sql, (rs, rowNum) -> {
				Role role=new Role();
				role.setId(rs.getInt("ID"));
				role.setRole(rs.getString("ROLE"));
				role.setActive(rs.getInt("ACTIVE"));
				return role;

			});


	}


}
