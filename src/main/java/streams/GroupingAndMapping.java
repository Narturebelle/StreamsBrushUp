package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupingAndMapping {
	
	List<Employee> empList = new ArrayList<Employee>();
	List<Transaction> transList = new ArrayList<Transaction>();
	

	public static void main(String[] args) {
		
		GroupingAndMapping obj = new GroupingAndMapping();
		
		Employee e1 = new Employee(1,"Vijay", "Kumbam", 500.0, "HR", true);
		Employee e2 = new Employee(2,"Vijay", "Kumbam", 5000.0, "HR", true);
		Employee e3 = new Employee(3,"Vijay", "Kumbam", 5080.0, "TEACHER", false);
		Employee e4 = new Employee(4,"Vijay", "Kumbam", 5500.0, "TEACHER", true);
		Employee e5 = new Employee(5,"Vijay", "Kumbam", 5200.0, "TEACHER", true);
		Employee e6 = new Employee(6,"Vijay", "Kumbam", 300.0, "HR", false);
		Employee e7 = new Employee(7,"Vijay", "Kumbam", 400.0, "HR", false);

		obj.empList.add(e1);
		obj.empList.add(e2);
		obj.empList.add(e3);
		obj.empList.add(e4);
		obj.empList.add(e5);
		obj.empList.add(e6);
		obj.empList.add(e7);
		
		//Group employees by department and count employees per department.
	Map<String, Long> groupByDeptAndCount = obj.empList.stream()
													    .collect(Collectors.groupingBy(e->e.getDepartment(),
													    		Collectors.counting())
													    		);
	
	
		//Group employees by department and list only employee names per department.
		Map<String, List<Employee>> groupByDeptAndList = obj.empList.stream()
					.collect(Collectors.groupingBy(e->e.getDepartment(),
								Collectors.toList()
							));
		groupByDeptAndList.forEach((dept, listOfemp)->
						System.out.println("Dpet "+dept +" -->"+listOfemp));
						
						
					

		//Group employees by active / inactive status.
		Map<Boolean, List<Employee>> groupByEmpStatus = obj.empList.stream()
					.collect(Collectors.groupingBy(e->e.isStatus(),
							Collectors.toList())						
							);
		groupByEmpStatus.forEach((dept, listOfemp)->
		System.out.println("Status "+dept +" -->"+listOfemp));

		//Group employees by department and calculate total salary per department.
	Map<String, Double> groupByDeptSal=obj.empList.stream()
					.collect(Collectors.groupingBy(
													e->e.getDepartment(),
													Collectors.summingDouble(e->e.getSalary())
													));
	groupByDeptSal.forEach((dept, salary)->
	System.out.println("Status "+dept +" -->"+salary));
		

		//Group employees by department and calculate average salary per department.
	Map<String, Double> groupByDeptAvgSal=obj.empList.stream()
										.collect(Collectors.groupingBy(e->e.getDepartment(),
												Collectors.averagingDouble(e->e.getSalary())
												));
	groupByDeptAvgSal.forEach((dept, salary)->
	System.out.println("Status "+dept +" -->"+salary));
	

		//Group employees by department and find the highest-paid employee in each department.
	Map<String, Optional<Employee>> groupByDeptAvgSals=obj.empList.stream()
												.collect(Collectors.groupingBy(e->e.getDepartment(),
														Collectors.maxBy((a,b)-> Double.compare(a.getSalary(), b.getSalary()))
														));
	groupByDeptAvgSals.forEach((dept, maxSalary)->
	System.out.println("dept for "+dept +" -->"+maxSalary));

		//Group employees by department and find the lowest-paid employee in each department.
	
	Map<String, Optional<Employee>> groupByDeptMinSals= obj.empList.stream()
					.collect(Collectors.groupingBy(e->e.getDepartment(),
							Collectors.minBy((a,b)-> Double.compare(a.getSalary(), b.getSalary()))
							));
	groupByDeptMinSals.forEach((dept, maxSalary)->
		System.out.println("dept for min "+dept +" -->"+maxSalary));

		//Group employees by department and return only active employees.
			Map<String, List<Employee>> actEmpInDept = obj.empList.stream()
						.filter(e->e.isStatus())
						.collect(Collectors.groupingBy(e->e.getDepartment()));
			actEmpInDept.forEach((status, empList)-> System.out.println("status is:"+status +" emp is "+empList.size()));

		//Group employees by salary range (e.g., <3000, 3000–6000, >6000).
			Map<String, List<Employee>> employeesBySalaryRange =
			        obj.empList.stream()
			                   .collect(Collectors.groupingBy(e -> {
			                       if (e.getSalary() < 3000) {
			                           return "<3000";
			                       } else if (e.getSalary() <= 6000) {
			                           return "3000-6000";
			                       } else {
			                           return ">6000";
			                       }
			                   }));

			
			employeesBySalaryRange.forEach((range, emps) -> {
			    System.out.println("Salary Range: " + range);
			    emps.forEach(e ->
			        System.out.println(e.getName() + " -> " + e.getSalary())
			    );
			    System.out.println("-------------------");
			});


		//Group employees by first letter of name.
		Map<Object, List<Employee>>	empListt =obj.empList.stream()
						.collect(Collectors.groupingBy(e-> e.getName().indexOf(0)));
		
		empListt.forEach((object, list)->
							System.out.println(object.toString() +" ,"+list.get(0))
				);
			
		

	}

}
