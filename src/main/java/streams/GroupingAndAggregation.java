package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupingAndAggregation {
	
	List<Employee> emplist; 
	List<Transaction> transList;
	
	void loadEmplData() {
		emplist = new ArrayList<Employee>();
		emplist.add(new Employee(1,"Vijay","Reddy",500.00,"HR",true));
		emplist.add(new Employee(2,"Ajay","Goud",5000.00,"TEACHER",true));
		emplist.add(new Employee(3,"Harshith","Reddy",1500.00,"TEACHER",true));
		emplist.add(new Employee(4,"VBharghavi","Yadav",6020.00,"TEACHER",false));
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
		GroupingAndAggregation obj = new GroupingAndAggregation();
		obj.loadEmplData();
		obj.loadTransData();
		
		//Group employees by department and count employees per department.
			obj.emplist.stream()
						.collect(Collectors.groupingBy(e->e.getDepartment(),
								Collectors.counting()));
			
		//Group employees by department and calculate total salary per department.
			obj.emplist.stream()
						.collect(Collectors.groupingBy(e->e.getDepartment(),
								Collectors.summarizingDouble(e->e.getSalary())
								));
			
		//Group employees by department and calculate average salary per department.
			obj.emplist.stream()
						.collect(Collectors.groupingBy(e->e.getDepartment(),
								Collectors.averagingDouble(e->e.getSalary())
								));
			
		//Group transactions by status and count per status.
			obj.transList.stream()
						 .collect(Collectors.groupingBy(e->e.getStatus(),
								 Collectors.counting()
								 ));
			
		//Group transactions by status and sum amount per status.
			obj.transList.stream()
						.collect(Collectors.groupingBy(e->e.getStatus(),
								Collectors.summingDouble(e->e.getAmount())
								));
	}

}
