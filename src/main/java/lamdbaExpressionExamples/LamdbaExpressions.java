package lamdbaExpressionExamples;

public class LamdbaExpressions {
	
		AddLamdba addlamdba = (a, b)-> a+b;
		SubLamdba sublamdba = (a,b)-> a-b;
		//MulLamdba mulLamdba = (a*b)-> a*b;
		
		public int add(int a, int b) {
			return a+b;
		}
		
	
	//Basic Operations [Add, Sub, Mul, Div]
	

	public static void main(String[] args) {
		LamdbaExpressions le =  new LamdbaExpressions();
		System.out.println("Add is :"+ le.addlamdba.addLamdbaMethod(5, 9));
		
		le.add(5, 6);
		
	}

}
