package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class StreamsAggregation {

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
		StreamsAggregation obj = new StreamsAggregation();
		obj.loadEmplData();
		obj.loadTransData();
		
		//Calculate the total salary of all employees.
		Double totalSalary = obj.emplist.stream()
					.mapToDouble(e->e.getSalary())
					.sum();
		System.out.println("Total salary is :"+totalSalary);
		System.out.println("***********************************");
		System.out.println("***********************************");
		
		//Calculate the average salary of employees
		OptionalDouble totalAvgSalary = obj.emplist.stream()
					.mapToDouble(e-> e.getSalary())
					.average();
		System.out.println("Total avg salary is :"+totalAvgSalary);
		System.out.println("***********************************");
		System.out.println("***********************************");
		
		//Find the maximum transaction amount.
		Optional<Transaction> maxSalary = obj.transList.stream()
					.max((a,b)->Double.compare(a.getAmount(), b.getAmount()));
		System.out.println("Max salary is :"+maxSalary.get().getAmount());
		System.out.println("***********************************");
		System.out.println("***********************************");
		
		//Find the minimum transaction amount.
		Optional<Transaction> minSalary = obj.transList.stream()
				.min((a,b)->Double.compare(a.getAmount(), b.getAmount()));
		System.out.println("Min salary is :"+minSalary.get().getAmount());
		System.out.println("***********************************");
		System.out.println("***********************************");
		
		//Count how many SUCCESS transactions are present.
		Long count = obj.transList.stream()
					.filter(e->e.getStatus().contentEquals("success"))
					.count();
		System.out.println("Total count is :"+count);
		System.out.println("***********************************");
		System.out.println("***********************************");
	
	}

}
