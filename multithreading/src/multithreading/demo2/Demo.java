package multithreading.demo2;

public class Demo {

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
			empService[i] = new Thread(empServiceImpl);
			empService[i].start();
		}
		
		for(int i=0;i<empService.length;i++) {
			try {
				empService[i].join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("Completed in " + (System.currentTimeMillis() - startTime) + " milliseconds");
		System.out.println(Thread.currentThread().getName() + " finished fetching");
	}
}
