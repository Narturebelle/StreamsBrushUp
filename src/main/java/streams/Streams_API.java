package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*

*/

public class Streams_API {

	static List<String> array = Arrays.asList("Vijay", "Vnkat", "Kumbam");
	static List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	List<Employee> empList = new ArrayList<Employee>();


	public static void main(String[] args) {
		
		Streams_API obj = new Streams_API();
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("vijay");
		emp1.setLastname("Kumbam");
		emp1.setStatus(true);
		emp1.setSalary(5000);
		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setName("Ajay");
		emp2.setLastname("Kumbam");
		emp2.setStatus(false);
		emp2.setSalary(2000);
		
		obj.empList.add(emp1);
		obj.empList.add(emp2);
		obj.empList.add(emp1);
		obj.empList.add(emp2);
		
		
		
		// Given a list of integers, write a stream pipeline to filter even numbers and
		// collect them into a list.
		List<Integer> result = num.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		result.forEach(i -> System.out.println(i));
		System.out.println("******************************");
		// Given a list of strings, convert all strings to lowercase and remove
		// duplicates.
		List<String> upperCase1 = array.stream().map(i -> i.toUpperCase()).collect(Collectors.toList());
		upperCase1.forEach(i -> System.out.println(i));
		System.out.println("******************************");

		// Given a list of integers, find the sum of all numbers greater than 50.
		List<Integer> resultInt = num.stream().filter(i -> i > 50).collect(Collectors.toList());
		resultInt.forEach(i -> System.out.println(i));
		System.out.println("******************************");

		// Given a list of strings, count how many strings start with the letter “J”.
		List<String> resultStartV = array.stream().filter(i -> i.startsWith("V")).collect(Collectors.toList());
		resultStartV.forEach(i -> System.out.println(i));
		System.out.println("******************************");

		// Given a list of integers, find the maximum value using streams.
		Optional<Integer> max = num.stream().reduce(Integer::max);

		System.out.println(max.get());
		System.out.println("******************************");

		Optional<Integer> minValue = num.stream().reduce(Integer::min);

		System.out.println(minValue.get());
		System.out.println("******************************");
		
		//Given a list of employees, extract only employee names into a list.		
		List<String> emp = obj.empList.stream()
									.map(empObj->empObj.getName())
									.collect(Collectors.toList());
		emp.forEach(i -> System.out.println(i));
		System.out.println("******************************");
		
		//Given a list of integers, sort them in descending order.
		List<Integer> sortedNum = num.stream().sorted().collect(Collectors.toList());
		sortedNum.forEach(i -> System.out.println(i));
		System.out.println("******************************");
		
		//Given a list of strings, filter strings with length greater than 5.
		List<String> strG5 = array.stream()
			.filter(str-> str.length() > 5)
			.collect(Collectors.toList());
		strG5.forEach(i -> System.out.println(i));
		System.out.println("******************************");

		//Given a list of integers, skip the first 3 elements and collect the rest.
		List<Integer> skipFirst3 =	num.stream()
			.skip(3)
			.collect(Collectors.toList());
		skipFirst3.forEach(i -> System.out.println(i));
		System.out.println("******************************");
		
		//Given a list of integers, limit the stream to first 5 elements.
		List<Integer> limit5 =	num.stream()
				.limit(5)
				.collect(Collectors.toList());
		limit5.forEach(i -> System.out.println(i));
			System.out.println("******************************");
	}

}
