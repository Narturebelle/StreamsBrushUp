package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamsReduce {
	
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
		StreamsReduce obj = new StreamsReduce();
		obj.loadEmplData();
		obj.loadTransData();
		
		//Calculate total salary using reduce.
		Double salary = obj.emplist.stream()
									.map(e-> e.getSalary())
									.reduce(0.0, (a,b)-> a+b);
		System.out.println("Total sal :"+salary);
		
		//Calculate total SUCCESS transaction amount using reduce.
		Double successSalary = obj.transList.stream()
					.filter(e->e.getStatus().contentEquals("success"))
					.map(e->e.getAmount())
					.reduce(0.0, (a,b)-> a+b);
		System.out.println("Total successSalary :"+successSalary);
		
		//Find the highest salary using reduce.
		Double maxSalary = obj.emplist.stream()
					.map(e->e.getSalary())
					.reduce(0.0,(a,b)->Math.max(a, b));
		System.out.println("Highest salary :"+maxSalary);

		//Find the lowest transaction amount using reduce.
		Optional<Double> minSalary = obj.emplist.stream()
				.map(e->e.getSalary())
				.reduce((a,b)->Math.min(a, b));
		System.out.println("Lowest salary :"+minSalary.get());
		
		//Concatenate all employee names into one string using reduce.
		String allNames = obj.emplist.stream()
		    .map(e -> e.getName())
		    .reduce("", (a, b) -> a + " " + b); 
		System.out.println("All Names: " + allNames);
	}

}
