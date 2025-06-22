package multithreading.demo1;

public class Demo2 {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " started fetching");
		
		EmployeeServiceImpl empServiceImpl = null;
		
		EmployeeRepository[] empRepos = {
				new EmployeeRepositoryImpl1(),
				new EmployeeRepositoryImpl2(),
				new EmployeeRepositoryImpl3()
		};
		
		Thread[] empService = new Thread[empRepos.length];
		
		long startTime = System.currentTimeMillis();
		
		for(int i=0;i<empRepos.length;i++) {
			empServiceImpl = new EmployeeServiceImpl(empRepos[i]);
			empService[i] = empServiceImpl;
			empService[i].start();
		}
		
		for(int i=0;i<empService.length;i++) {
			try {
				empService[i].join();
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		
		System.out.println("Completed in " + (System.currentTimeMillis() - startTime) + " milliseconds");
		System.out.println(Thread.currentThread().getName() + " finished fetching");
	}
}
