package multithreading.demo2;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl2 implements EmployeeRepository{
	
	private static final List<Employee> employeeList = new ArrayList<>();
	
	static {
		employeeList.add(new Employee(201, "Amar"));
		employeeList.add(new Employee(202, "Mohan"));
		employeeList.add(new Employee(203, "Nancy"));
		employeeList.add(new Employee(204, "Astha"));
		employeeList.add(new Employee(205, "Rohit"));
	}
	
	@Override
	public String toString() {
		return "EmployeeRepositoryImpl2";
	}

	@Override
	public void displayEmployees() {
		for(Employee employee : employeeList) {
			System.out.println(employee);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
