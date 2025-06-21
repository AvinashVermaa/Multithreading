package multithreading.demo0;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl1 implements EmployeeRepository {

	private static List<Employee> employeeList = new ArrayList<>();

	static {
		employeeList.add(new Employee(101, "Abhishek"));
		employeeList.add(new Employee(102, "Sneh"));
		employeeList.add(new Employee(103, "Lakshay"));
		employeeList.add(new Employee(104, "Aditi"));
		employeeList.add(new Employee(105, "Raman"));
	}

	@Override
	public void displayEmployees() {
		for (Employee emp : employeeList) {
			System.out.println(emp);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

	}

	@Override
	public String toString() {
		return "EmployeeRepositoryImpl1";
	}

}
