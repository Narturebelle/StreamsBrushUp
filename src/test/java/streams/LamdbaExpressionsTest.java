package streams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lamdbaExpressionExamples.LamdbaExpressions;


public class LamdbaExpressionsTest {
	
	LamdbaExpressions calculator = new LamdbaExpressions();
	
	@Test
	public void addTest() {
		int actualValue = calculator.add(4, 9);
		 assertEquals(13, actualValue);
	}

}
