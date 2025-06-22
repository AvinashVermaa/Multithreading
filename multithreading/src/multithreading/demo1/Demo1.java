package multithreading.demo1;

public class Demo1 {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " started fetching");
		
		EmployeeServiceImpl empService = null;
		
		EmployeeRepository[] empRepos = {
				new EmployeeRepositoryImpl1(),
				new EmployeeRepositoryImpl2(),
				new EmployeeRepositoryImpl3()
		};
		
		long startTime = System.currentTimeMillis();
		
		for(int i=0;i<empRepos.length;i++) {
			empService = new EmployeeServiceImpl(empRepos[i]);
			empService.start();
		}
		
		
		System.out.println("Completed in " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}
}
