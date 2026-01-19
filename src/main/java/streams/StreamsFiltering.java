package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsFiltering {
	
	List<Employee> emplist; 
	List<Transaction> transList;
	
	void loadEmplData() {
		emplist = new ArrayList<Employee>();
		emplist.add(new Employee(1,"Vijay","Reddy",500.00,"HR",true));
		emplist.add(new Employee(2,"Ajay","Goud",5000.00,"TEACHER",true));
		emplist.add(new Employee(3,"Harshith","Reddy",1500.00,"TEACHER",true));
		emplist.add(new Employee(4,"Bharghavi","Yadav",6000.00,"TEACHER",false));
		emplist.add(new Employee(5,"Jaya","blank",2000.00,"HR",false));
	}
	
	void loadTransData() {
		transList =  new ArrayList<Transaction>();
		transList.add(new Transaction(1, 5909.00, "success"));
		transList.add(new Transaction(2, 3000.00, "success"));
		transList.add(new Transaction(3, 4000.00, "fail"));
		transList.add(new Transaction(4, 6000.00, "fail"));
		transList.add(new Transaction(5, 2000.00, "success"));	
	}

	public static void main(String[] args) {
		StreamsFiltering obj =  new StreamsFiltering();
		obj.loadEmplData();
		obj.loadTransData();
		
		//From employees, select only active employees.
		List<Employee> activeEmployeeList = obj.emplist.stream()
													  .filter(e->e.isStatus())
													  .collect(Collectors.toList());
		activeEmployeeList.forEach(e-> System.out.println(e));
		System.out.println("***********************************");
		System.out.println("***********************************");

		
		//From employees, select employees with salary greater than 4000.
		List<Employee> employeeListGreaterThan4K = obj.emplist.stream()
															  .filter(e->e.getSalary() >=4000)
					                                          .collect(Collectors.toList());
		employeeListGreaterThan4K.forEach(e->System.out.println(e));
		System.out.println("***********************************");
		System.out.println("***********************************");
		
		//From employees, select employees whose department is "HR".
		List<Employee> employeeHRList = obj.emplist.stream()
				                                   .filter(e->e.getDepartment().contentEquals("HR"))
                                                   .collect(Collectors.toList());
		employeeHRList.forEach(e->System.out.println(e));
		System.out.println("***********************************");
		System.out.println("***********************************");
		
		//From transactions, select only SUCCESS transactions.
		List<Transaction> transactionListWithSuccess = obj.transList.stream()
						.filter(e->e.getStatus().contentEquals("success"))
						.collect(Collectors.toList());
		transactionListWithSuccess.forEach(e-> System.out.println(e));
		System.out.println("***********************************");
		System.out.println("***********************************");
		
		//From transactions, select transactions with amount greater than 10,000.
		List<Transaction> transactionListWithGreaterThan10K = obj.transList.stream()
				                                                           .filter(e->e.getAmount()>=10000)
				                                                           .collect(Collectors.toList());
		transactionListWithGreaterThan10K.forEach(e-> System.out.println(e));
		
		
	}

}
