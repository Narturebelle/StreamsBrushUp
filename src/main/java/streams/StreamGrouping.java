package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGrouping {
	
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
		StreamGrouping obj = new StreamGrouping();
		obj.loadEmplData();
		obj.loadTransData();
		
		//Group employees by department.
		Map<String, List<Employee>> emploGroupBy = obj.emplist.stream()
															//.filter(e->e.isStatus())
															.collect(Collectors.groupingBy(e->e.getDepartment()));
		emploGroupBy.forEach((Dept,empListt)->
											System.out.println("Dept is :"+Dept+" ,"+empListt)											
				);
		System.out.println("***********************************");
		System.out.println("***********************************");
		
		//Group transactions by status (SUCCESS / FAILED).
		Map<String, List<Employee>> emploGroupByActive = obj.emplist.stream()
															  .filter(e->e.isStatus())
					                                          .collect(Collectors.groupingBy(e->e.getDepartment()));
		emploGroupByActive.forEach((Dept,empListt)->
												System.out.println("Dept is :"+Dept+" ,"+empListt)
												);
		System.out.println("***********************************");
		System.out.println("***********************************");
		
		//Group employees by status (active / inactive).
		Map<Boolean, List<Employee>> employeeStatus	= obj.emplist.stream()
						.collect(Collectors.groupingBy(e->e.isStatus()));
		employeeStatus.forEach((status,empList)->
						System.out.println("Status : "+status+" , "+empList)
				);
		System.out.println("***********************************");
		System.out.println("***********************************");
		
		
		//Group employees by first letter of name.
	 Map<Object, List<Employee>> groupByFirstLetter = obj.emplist.stream()
					.collect(Collectors.groupingBy(e->e.getName().charAt(0)));
	 groupByFirstLetter.forEach((firstletter, emplist)->
			 System.out.println("Letter :"+firstletter+" ,"+emplist)											
			 );
		System.out.println("***********************************");
		System.out.println("***********************************");
		
		//Group employees by salary range (<3000, 3000–6000, >6000).
	 Map<String, List<Employee>> rangeSalaryofAnEmployee = obj.emplist.stream()
	    		.collect(Collectors.groupingBy(e -> {
	        double salary = e.getSalary();
	        if (salary < 3000) {
	            return "Low (<3000)";
	        } else if (salary <= 6000) {
	            return "Medium (3000-6000)";
	        } else {
	            return "High (>6000)";
	        }
	    }));
	 rangeSalaryofAnEmployee.forEach((str, emplist)->
	 			System.out.println("Salary Range is : "+str+" , "+emplist)
			 );
		
	}

}
