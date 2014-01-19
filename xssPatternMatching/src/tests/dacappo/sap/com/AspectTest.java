package tests.dacappo.sap.com;
import analytics.dacappo.sap.com.*;

public class AspectTest {
	
	ConcreteAspect ca;
	RequiredAspect ra;
	
	public AspectTest() {
		ca = new ConcreteAspect();
		ra = new RequiredAspect();
		runTest("empty ConcreteAspect - empty RequiredAspect", true);
		
		ca = new  ConcreteAspect("html");
		ra = new RequiredAspect();
		runTest("single ConcreteAspect - empty RequiredAspect", true);
		
		ca = new  ConcreteAspect("html");
		ra = new RequiredAspect();
		ra.addAllowedValue("html");
		runTest("single allowed RequiredAspect - allowed ConcreteAspect", true);
		
		ca = new  ConcreteAspect("html");
		ra = new RequiredAspect();
		ra.addAllowedValue("body");
		ra.addAllowedValue("html");
		runTest("various allowed RequiredAspect containing ConcreteAspect ", true);
		
		ca = new  ConcreteAspect("html");
		ra = new RequiredAspect();
		ra.addAllowedValue("body");
		ra.addAllowedValue("html");
		ra.addForbiddenValue("head");
		ra.addForbiddenValue("p");
		runTest("various allowed and forbidden RequiredAspect - allowed ConcreteAspect ", true);
		
		ca = new  ConcreteAspect("html");
		ra = new RequiredAspect();
		ra.addForbiddenValue("p");
		ra.addForbiddenValue("html");
		runTest("various forbidden RequiredAspect - forbidden ConcreteAspect ", false);
		
		ca = new  ConcreteAspect("html");
		ra = new RequiredAspect();
		ra.addAllowedValue("body");
		ra.addAllowedValue("head");
		ra.addForbiddenValue("html");
		ra.addForbiddenValue("p");
		runTest("various allowed and forbidden RequiredAspect - forbidden ConcreteAspect ", false);
		
		ca = new  ConcreteAspect("html");
		ra = new RequiredAspect();
		ra.addAllowedValue("body");
		ra.addAllowedValue("head");
		runTest("various allowed RequiredAspect - other ConcreteAspect ", false);
		
		
		ca = new ConcreteAspect("test'bla");
		ra = new RequiredAspect();
		ra.addForbiddenValuePart("'");
		ra.addForbiddenValuePart("\"");
		runTest("normal ConcreteAspect - forbiddenValuePart RequiredAspect 1", false);
		
		ca = new ConcreteAspect("test\" bla");
		ra = new RequiredAspect();
		ra.addForbiddenValuePart("'");
		ra.addForbiddenValuePart("\"");
		runTest("normal ConcreteAspect - forbiddenValuePart RequiredAspect 2", false);
		
		ca = new ConcreteAspect("test bla");
		ra = new RequiredAspect();
		ra.addForbiddenValuePart("'");
		ra.addForbiddenValuePart("\"");
		runTest("normal ConcreteAspect - forbiddenValuePart RequiredAspect 3", true);
	}
	
	private void runTest(String describtion, boolean expectation) {
		boolean result = ra.checkAspect(ca);
		RunUnitTests.printTest(describtion, expectation, result);
	}	
}
