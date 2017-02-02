import java.time.LocalDate;

import com.mahesh.model.Department;
import com.mahesh.model.Employee;
import com.mahesh.model.Transaction;
import com.mahesh.model.User;

public class TestTransaction {

	public static void main(String[] args) {
		
		Transaction transaction=new Transaction();
		transaction.setId(1);
		User user=new User();
		user.setId(1);
		transaction.setUserId(user);
		Department department=new Department();
		department.setId(1);
		transaction.setDepartmentId(department);
		transaction.setSubject("Reg Mobile");
		transaction.setDescription("Black Mobile");
		transaction.setPriority("MEDIUM");
		Employee employee=new Employee();
		employee.setId(1);
		transaction.setEmployeeId(employee);
		transaction.setCreatedDate(LocalDate.parse("2017-02-02"));
		transaction.setClosedDate(LocalDate.parse("2017-02-03"));
		transaction.setStatus("Closed");
		
		System.out.println(transaction);
		

	}

}
