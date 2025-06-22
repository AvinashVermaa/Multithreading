package multithreading.demo2;

public class EmployeeServiceImpl implements Runnable{
	
	private EmployeeRepository empRepos;
	
	public EmployeeServiceImpl(EmployeeRepository empRepo) {
		super();
		this.empRepos = empRepo;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " started fetching from : " + empRepos);
		empRepos.displayEmployees();
		System.out.println(Thread.currentThread().getName() + " finished fetching from : " + empRepos);
		
	}

}
