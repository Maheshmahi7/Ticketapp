package com.mahesh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mahesh.model.Department;
import com.mahesh.model.Employee;
import com.mahesh.model.Transaction;
import com.mahesh.model.User;
import com.mahesh.util.ConnectionUtil;

public class TransactionDao {
	
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	/*public String PR_ORDER_PRODUCT(int customerId,int productId ,int quantity) {

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		call.withProcedureName("PR_ORDER_PRODUCT");
		call.declareParameters(new SqlParameter("I_CUSTOMER_ID", Types.INTEGER),new SqlParameter("I_PRODUCT_ID", Types.INTEGER),
				new SqlParameter("I_QUANTITY", Types.INTEGER),
				new SqlOutParameter("O_MESSAGE", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);

		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("I_CUSTOMER_ID", customerId);
		in.addValue("I_PRODUCT_ID", productId);
		in.addValue("I_QUANTITY", quantity);

		Map<String, Object> execute = call.execute(in);

		String status = (String) execute.get("O_MESSAGE");
		return status;

	}*/
	
	public void delete(int id) {

		String sql = "DELETE FROM TICKET_TRANSACTION WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
		
		public List<Transaction> list() {

			String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,PRIORITY,EMPLOYEE_ID,CREATED_DATE,CLOSED_DATE,STATUS FROM TICKET_TRANSACTION";
			return jdbcTemplate.query(sql, (rs, rowNum) -> {
				Transaction transaction=new Transaction();
				transaction.setId(rs.getInt("ID"));
				User user=new User();
				user.setId(rs.getInt("USER_ID"));
				transaction.setUserId(user);
				Department department=new Department();
				department.setId(rs.getInt("DEPARTMENT_ID"));
				transaction.setDepartmentId(department);
				transaction.setSubject(rs.getString("SUBJECT"));
				transaction.setDescription(rs.getString("DESCRIPTION"));
				transaction.setPriority(rs.getString("PRIORITY"));
				Employee employee=new Employee();
				employee.setId(rs.getInt("EMPLOYEE_ID"));
				transaction.setEmployeeId(employee);
				transaction.setCreatedDate(rs.getDate("CREATED_DATE").toLocalDate());
				transaction.setClosedDate(rs.getDate("CLOSED_DATE").toLocalDate());
				transaction.setStatus(rs.getString("STATUS"));
				return transaction;

			});


	}



}
