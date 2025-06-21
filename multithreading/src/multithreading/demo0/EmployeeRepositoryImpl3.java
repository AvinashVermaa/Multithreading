package multithreading.demo0;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl3 implements EmployeeRepository {

	private static List<Employee> employeeList = new ArrayList<>();

	static {
		employeeList.add(new Employee(301, "Kapil"));
		employeeList.add(new Employee(302, "Manish"));
		employeeList.add(new Employee(303, "Vikram"));
		employeeList.add(new Employee(304, "Ajita"));
		employeeList.add(new Employee(305, "Deepa"));
	}

	@Override
	public void displayEmployees() {
		for (Employee employee : employeeList) {
			System.out.println(employee);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

	}

	@Override
	public String toString() {
		return "EmployeeRepositoryImpl3";
	}

}
