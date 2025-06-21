package multithreading.demo0;

public class Demo1 {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " started fetching");
		
		EmployeeServiceImpl employeeServiceImpl = null;
		
		EmployeeRepository[] employeeRepositories = { 
				new EmployeeRepositoryImpl1(), 
				new EmployeeRepositoryImpl2(),
				new EmployeeRepositoryImpl3() 
		};
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < employeeRepositories.length; i++) {
			employeeServiceImpl = new EmployeeServiceImpl(employeeRepositories[i]);
			employeeServiceImpl.run();
		}
		
		System.out.println("Completed in " + (System.currentTimeMillis() - startTime) + " milliseconds");
		
		System.out.println(Thread.currentThread().getName() + " finished fetching");
	}
}
