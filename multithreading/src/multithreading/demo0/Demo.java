package multithreading.demo0;

public class Demo {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " started fetching");
		
		EmployeeServiceImpl empService = null;
		
		long startTime = System.currentTimeMillis();
		
		empService = new EmployeeServiceImpl(new EmployeeRepositoryImpl1());
		empService.run();
		
		empService = new EmployeeServiceImpl(new EmployeeRepositoryImpl2());
		empService.run();
		
		empService = new EmployeeServiceImpl(new EmployeeRepositoryImpl3());
		empService.run();
		
		System.out.println("Completed in " + (System.currentTimeMillis() - startTime) + " milliseconds");
		System.out.println(Thread.currentThread().getName() + " finished fetching");
	}
}
