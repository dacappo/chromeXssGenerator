package tests.dacappo.sap.com;

public class RunUnitTests {

	public static void main(String[] args) {
		
		System.out.println("Aspect Unit Tests:");
		new AspectTest();
		System.out.println("Flow Unit Tests:");
		new FlowTest();
		System.out.println("Condition Unit Tests:");
		new ConditionTest();
		
	}
	
	private static int counter = 1;
	public static void printTest(String describtion, boolean expectation, boolean result) {
		if (result == expectation) {
			System.out.println(" " + counter + ") \t correct");
		} else {
			System.err.println(describtion + " : " + expectation + " + " +  result + " = " + "incorrect");
		}
		counter++;
	}	

}
