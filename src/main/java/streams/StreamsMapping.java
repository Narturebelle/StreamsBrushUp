package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsMapping {

	List<Employee> emplist;
	List<Transaction> transList;

	void loadEmplData() {
		emplist = new ArrayList<Employee>();
		emplist.add(new Employee(1, "Vijay", "Reddy", 500.00, "HR", true));
		emplist.add(new Employee(2, "Ajay", "Goud", 5000.00, "TEACHER", true));
		emplist.add(new Employee(3, "Harshith", "Reddy", 1500.00, "TEACHER", true));
		emplist.add(new Employee(4, "Bharghavi", "Yadav", 6000.00, "TEACHER", false));
		emplist.add(new Employee(5, "Jaya", "blank", 2000.00, "HR", false));
	}

	void loadTransData() {
		transList = new ArrayList<Transaction>();
		transList.add(new Transaction(1, 5909.00, "success"));
		transList.add(new Transaction(2, 3000.00, "success"));
		transList.add(new Transaction(3, 4000.00, "fail"));
		transList.add(new Transaction(4, 6000.00, "fail"));
		transList.add(new Transaction(5, 2000.00, "success"));
	}

	public static void main(String[] args) {
		StreamsMapping obj = new StreamsMapping();
		obj.loadEmplData();
		obj.loadTransData();

		// From employees, extract only employee names.
		List<String> listOfNames = obj.emplist.stream().map(e -> e.getName()).collect(Collectors.toList());
		listOfNames.forEach(e -> System.out.println(e));
		System.out.println("***********************************");
		System.out.println("***********************************");

		// From employees, extract salary values into a list.
		List<Double> listOfSal = obj.emplist.stream().map(e -> e.getSalary()).collect(Collectors.toList());
		listOfSal.forEach(e -> System.out.println(e));
		System.out.println("***********************************");
		System.out.println("***********************************");

		// From transactions, extract transaction amounts.
		List<Double> listOfTransactionAmount = obj.transList.stream()
					 .map(e->e.getAmount())
					 .collect(Collectors.toList());
		listOfTransactionAmount.forEach(e -> System.out.println(e));
		System.out.println("***********************************");
		System.out.println("***********************************");
		
		// From employees, create a list of “name-department” strings.
		List<String> listOfDepartName = obj.emplist.stream()
					.map(e->e.getName() +" - "+ e.getDepartment())
					.collect(Collectors.toList());
		listOfDepartName.forEach(e -> System.out.println(e));
		System.out.println("***********************************");
		System.out.println("***********************************");
		
		// From transactions, extract only transaction IDs.
		List<Integer> listOfTransIDs = obj.transList.stream()
					.map(e-> e.getId())
					.collect(Collectors.toList());
		listOfTransIDs.forEach(e -> System.out.println(e));
		System.out.println("***********************************");
		System.out.println("***********************************");
	}

}
