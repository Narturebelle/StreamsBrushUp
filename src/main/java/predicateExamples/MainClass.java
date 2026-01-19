package predicateExamples;

import java.util.function.Predicate;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Predicate<Integer> op = (num)-> num > 5 || num > 15;
        System.out.println(op.test(3));
       //2 Write a Predicate<String> that checks if a string is empty.
        Predicate<String> isEmptyString =  (inputString)-> inputString.isEmpty();
        System.out.println(isEmptyString.test("Vijay"));
        System.out.println(isEmptyString.test(""));
        
        //3 Create a Predicate<Integer> to check if a number is even.
        Predicate<Integer> isEven = (number)-> {
        	if(number%2 == 0) {
        		return true ;
        	}else {
        		return false;
        	}};
            System.out.println(isEven.test(4));
            System.out.println(isEven.test(9));  
            
       //4 Write a predicate that checks if a string starts with "A".
            Predicate<String> isStartWithA = (input)-> {
            	if (input.startsWith("A")) {
            		return true;
            	}else {
            		return false;
            	}		 
            };
            System.out.println(isStartWithA.test("Apple"));
            System.out.println(isStartWithA.test("Bpple"));
            
            
			/*
			 * Create two predicates: 
			 * number > 10 
			 * number < 50 
			 * Use and() to test the number
			 * 25.
			 */
           Predicate<Integer> result1 = (number)-> number>10;
           Predicate<Integer> result2 = (number)-> number<50;
           Predicate<Integer> result = result1.and(result2);
           System.out.println("result1 "+result1.test(12));
           System.out.println("result2 "+result2.test(66));
           System.out.println(result.test(35));

            String[] names = {"Apple","Ant","Axe","Ball"};
            Predicate<String> str = (name)-> {
            		name.startsWith("A");
            		return true;
            };
            
            for(String name:names) {
            	System.out.println("Names :"+str.test(name));;
            }
            
            
            
	}
	

}
