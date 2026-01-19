package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsSorting {
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
		StreamsSorting obj =  new StreamsSorting();
		obj.loadEmplData();
		obj.loadTransData();
		
		//Sort employees by salary (ascending).
		List<Employee> sortedEmployeesAsc	=obj.emplist.stream()
						.sorted((a,b)->Double.compare(a.getSalary(), b.getSalary()))
						.collect(Collectors.toList());
		sortedEmployeesAsc.forEach(e-> System.out.println(e));
		System.out.println("***********************************");
		System.out.println("***********************************");
		
		//Sort employees by salary (descending).
		List<Employee> sortedEmployeesDesc = obj.emplist.stream()
				.sorted((a,b)->Double.compare(b.getSalary(), a.getSalary()))
				.collect(Collectors.toList());
		sortedEmployeesDesc.forEach(e-> System.out.println(e));
		System.out.println("***********************************");
		System.out.println("***********************************");
		//Sort employees by name alphabetically.
			List<Employee> sortedEmployeeName = obj.emplist.stream()
						.sorted((a,b)->a.getName().compareTo(b.getName()))
						.collect(Collectors.toList());
			sortedEmployeeName.forEach(e-> System.out.println(e));
			System.out.println("***********************************");
			System.out.println("***********************************");
		//Sort transactions by amount (highest first).
			List<Transaction> sortedTransaction = obj.transList.stream()
						.sorted((a,b)-> Double.compare(b.getAmount(), a.getAmount()))
						.collect(Collectors.toList());
			sortedTransaction.forEach(e-> System.out.println(e));
			System.out.println("***********************************");
			System.out.println("***********************************");
		//Sort employees by department, then salary.
			List<Employee> sortedByDeptAndSal=obj.emplist.stream()
						.sorted((a,b)->a.getDepartment().compareTo(b.getDepartment()))
						.sorted((a,b)->Double.compare(a.getSalary(), b.getSalary()))
						.collect(Collectors.toList());
			
			
			List<Employee> sortedByDeptAndSall = obj.emplist.stream()
				    .sorted((a, b) -> {
				       
				        int deptCompare = a.getDepartment().compareTo(b.getDepartment());
				        
				        if (deptCompare != 0) {
				            return deptCompare;
				        }
				        
				        // 3. If Departments are the same, compare Salaries
				        return Double.compare(a.getSalary(), b.getSalary());
				    })
				    .collect(Collectors.toList());
			sortedByDeptAndSall.forEach(e-> System.out.println(e));
			System.out.println("***********************************");
			System.out.println("***********************************");

	}

}
