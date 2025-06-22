package multithreading.demo1;

public class EmployeeServiceImpl extends Thread{

	private EmployeeRepository empRepo;
	
	public EmployeeServiceImpl(EmployeeRepository empRepo) {
		super();
		this.empRepo = empRepo;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " started fetching from : " + empRepo);
		empRepo.displayEmployees();
		System.out.println(Thread.currentThread().getName() + " finished fetching from : " + empRepo);
	}
}
