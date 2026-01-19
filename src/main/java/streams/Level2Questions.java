package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Level2Questions {

	List<Employee> empList = new ArrayList<Employee>();
	List<Transaction> transList = new ArrayList<Transaction>();
	public static void main(String[] args) {
		Level2Questions obj = new Level2Questions();
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("vijay");
		emp1.setLastname("Kumbam");
		emp1.setStatus(true);
		emp1.setSalary(5000);
		emp1.setDepartment("HR");
		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setName("Ajay");
		emp2.setLastname("Kumbam");
		emp2.setStatus(false);
		emp2.setDepartment("Teacher");
		emp2.setSalary(2000);
		
		Employee emp3 = new Employee();
		emp3.setId(3);
		emp3.setName("");
		emp3.setLastname("Kumbam");
		emp3.setStatus(true);
		emp3.setDepartment("Teacher");
		emp3.setSalary(2000);
		
		obj.empList.add(emp1);
		obj.empList.add(emp2);
		obj.empList.add(emp3);
		
		Transaction t1 = new Transaction(1,5000.00, "SUCCESS");
		Transaction t2 = new Transaction(2,25000.00, "SUCCESS");
		Transaction t3 = new Transaction(3,5000.00, "SUCCESS");
		Transaction t4 = new Transaction(4,25000.00, "FAILED");
		obj.transList.add(t1);
		obj.transList.add(t2);
		obj.transList.add(t3);
		obj.transList.add(t4);

		
		//You receive a list of users. Each user has status and name How would you get only active users with non-null names?
		List<Employee> emp 	= obj.empList.stream()
				 			             .filter(e -> e.isStatus()&& e.getLastname() != null && !e.getLastname().isEmpty())
						                 .collect(Collectors.toList());
		for(Employee emps:emp) {
			System.out.println(emps.getId()+","+emps.getName());
		}
		
		//From a list of employees, how would you extract names of employees whose salary is greater than 50,000 and status is active?
		List<Employee> empp = obj.empList.stream()
		 								.filter(e-> e.getSalary()>=5000 && e.isStatus())
		 								.collect(Collectors.toList());
		empp.forEach(e -> System.out.println(e.getName()+", "+e.getLastname()));
		
		//From a list of transactions, how would you calculate the total amount of successful transactions?
		double transa = obj.transList.stream()
					.filter(o -> (o.getStatus() == "SUCCESS"))
					.mapToDouble(t->t.getAmount())
					.sum();
		System.out.println("List of transaction is  trans:"+transa);

		//This is giving me total no.of successful transactions in the complete list
		double trans = obj.transList.stream()
				.filter(o -> (o.getStatus() == "SUCCESS"))
				.map(t -> t.getAmount() )
				.count();
		System.out.println("List of transaction is  trans:"+trans);
		
		//From a list of employees, how would you calculate the average salary?
		obj.empList.stream()
					.mapToDouble(o-> o.getSalary()) //==>
					.average()
					.orElse(10.0);
		
		//From a list of transactions , how would you find the order with the highest amount?
		OptionalDouble tr = obj.transList.stream()
					.filter(o-> (o.getStatus()=="SUCCESS"))
					.mapToDouble(o -> o.getAmount())
					.max();
					System.out.println(tr);
					
					//Calculate the total amount of all SUCCESS transactions.
					Double d =obj.transList.stream()
								.filter((t->t.getStatus()=="SUCCESS"))
								.mapToDouble(t->t.getAmount())
								.sum();
					System.out.println("Total Amount of all successful tranactions is:"+d);


					//Calculate the total amount of FAILED transactions.
					Double df =obj.transList.stream()
							.filter((t->t.getStatus()=="FAILED"))
							.mapToDouble(t->t.getAmount())
							.sum();
				System.out.println("Total Amount of all successful tranactions is:"+df);

					//Find the average transaction amount.
				OptionalDouble avg = obj.transList.stream()
											.mapToDouble(t->t.getAmount())
											.average();
				System.out.println("Total Avg Amount of all successful tranactions is:"+avg);

					//Find the maximum transaction amount.
				OptionalDouble oAVG = obj.transList.stream()
							.mapToDouble(t-> t.getAmount())
							.max();
				System.out.println("Total Max Amount of "+oAVG);

					//Find the minimum transaction amount.
				OptionalDouble omin = obj.transList.stream()
						.mapToDouble(t-> t.getAmount())
						.min();
				System.out.println("Total Max Amount of "+omin);

					//Count how many SUCCESS transactions are present.
				System.out.println(obj.transList.stream()
												.filter(t-> "SUCCESS".equalsIgnoreCase(t.getStatus()))
												.count()			
						);

					//Calculate the total amount of transactions done today.
				System.out.println(obj.transList.stream()
							  .mapToDouble(t->t.getAmount())
							  .sum());

					//From a list of employees, how would you group them by department?
					Map<String, List<Employee>> empsObj =obj.empList.stream()
								.collect(Collectors.groupingBy(e->e.getDepartment()));
					
					empsObj.forEach((dept, emplist)-> {
								System.out.println(dept);
								emplist.forEach(empl-> System.out.println(empl));			
					});
					//From a list of users, how would you group users by country and count users per country?
					Map<String, Long> empCount =obj.empList.stream()
								.collect(
										Collectors.groupingBy(e->e.getDepartment(),
										Collectors.counting())
										);
						empCount.forEach((dep, count)->
									System.out.println(dep+", "+count)
								);
						
						
						//From a list of employees, calculate average salary per department
					Map<String, Double> avgSalPerDep= obj.empList.stream()
													  .collect(Collectors.groupingBy(e->e.getDepartment(), 
															  Collectors.averagingDouble(e->e.getSalary())
															  ));
					avgSalPerDep.forEach((dept, sal)->
							System.out.println(dept+","+sal)
							);
				
				

	}

}
