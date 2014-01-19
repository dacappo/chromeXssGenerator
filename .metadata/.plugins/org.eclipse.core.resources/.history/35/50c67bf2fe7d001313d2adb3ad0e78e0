package tests.dacappo.sap.com;

import analytics.dacappo.sap.com.*;

public class ConditionTest {
	
	BypassCondition bypassCondition;
	FindingCondition findingCondition;
	
	public ConditionTest() {
		
		FlowPattern<RequiredAspect> requiredFlowPattern = new FlowPattern<RequiredAspect>(new RequiredAspect());
		FlowPattern<ConcreteAspect> concreteFlowPattern = new FlowPattern<ConcreteAspect>(new ConcreteAspect());
		
		bypassCondition = new BypassCondition("",requiredFlowPattern);
		findingCondition = new FindingCondition(concreteFlowPattern);
		
		runTest("Condition testing empty1", true);
		
		
		
		
	
		Flow<ConcreteAspect> concreteFlow1 = new Flow<ConcreteAspect>(new ConcreteAspect(), new MarkupContext<ConcreteAspect>(new ConcreteAspect(), new ConcreteAspect(), new ConcreteAspect()));
		Flow<ConcreteAspect> concreteFlow2 = new Flow<ConcreteAspect>(new ConcreteAspect(), new MarkupContext<ConcreteAspect>(new ConcreteAspect(), new ConcreteAspect(), new ConcreteAspect()));
		Flow<ConcreteAspect> concreteFlow3 = new Flow<ConcreteAspect>(new ConcreteAspect(), new MarkupContext<ConcreteAspect>(new ConcreteAspect(), new ConcreteAspect(), new ConcreteAspect()));
		Flow<RequiredAspect> requiredFlow1 = new Flow<RequiredAspect>(new RequiredAspect(), new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect(), new RequiredAspect()));
		Flow<RequiredAspect> requiredFlow2 = new Flow<RequiredAspect>(new RequiredAspect(), new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect(), new RequiredAspect()));
		Flow<RequiredAspect> requiredFlow3 = new Flow<RequiredAspect>(new RequiredAspect(), new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect(), new RequiredAspect()));
		
		requiredFlowPattern = new FlowPattern<RequiredAspect>(new RequiredAspect());
		concreteFlowPattern = new FlowPattern<ConcreteAspect>(new ConcreteAspect());
	
		//requiredFlowPattern.addFlow(requiredFlow1);
		//requiredFlowPattern.addFlow(requiredFlow2);
		//requiredFlowPattern.addFlow(requiredFlow3);
		
		concreteFlowPattern.addFlow(concreteFlow1);
		concreteFlowPattern.addFlow(concreteFlow2);
		concreteFlowPattern.addFlow(concreteFlow3);
	
		bypassCondition = new BypassCondition("",requiredFlowPattern);
		findingCondition = new FindingCondition(concreteFlowPattern);
		
		runTest("Condition testing 2", true);
		
		
		
		concreteFlow1 = new Flow<ConcreteAspect>(new ConcreteAspect("1"), new MarkupContext<ConcreteAspect>(new ConcreteAspect(), new ConcreteAspect(), new ConcreteAspect()));
		concreteFlow2 = new Flow<ConcreteAspect>(new ConcreteAspect("0"), new MarkupContext<ConcreteAspect>(new ConcreteAspect(), new ConcreteAspect(), new ConcreteAspect()));
		concreteFlow3 = new Flow<ConcreteAspect>(new ConcreteAspect("1"), new MarkupContext<ConcreteAspect>(new ConcreteAspect(), new ConcreteAspect(), new ConcreteAspect()));
		requiredFlow1 = new Flow<RequiredAspect>(new RequiredAspect(), new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect(), new RequiredAspect()));
		requiredFlow2 = new Flow<RequiredAspect>(new RequiredAspect(), new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect(), new RequiredAspect()));
		requiredFlow3 = new Flow<RequiredAspect>(new RequiredAspect(), new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect(), new RequiredAspect()));
		
		requiredFlowPattern = new FlowPattern<RequiredAspect>(new RequiredAspect());
		concreteFlowPattern = new FlowPattern<ConcreteAspect>(new ConcreteAspect());
	
		requiredFlowPattern.addFlow(requiredFlow1);
		requiredFlowPattern.addFlow(requiredFlow2);
		requiredFlowPattern.addFlow(requiredFlow3);
		
		concreteFlowPattern.addFlow(concreteFlow1);
		concreteFlowPattern.addFlow(concreteFlow2);
		concreteFlowPattern.addFlow(concreteFlow3);
	
		bypassCondition = new BypassCondition("",requiredFlowPattern);
		findingCondition = new FindingCondition(concreteFlowPattern);
		
		runTest("Condition testing 3", true);
		
		
		
		/*
		 * realistic test that should match
		 */
		concreteFlow1 = new Flow<ConcreteAspect>(new ConcreteAspect("0"), new MarkupContext<ConcreteAspect>(new ConcreteAspect(), new ConcreteAspect(), new ConcreteAspect()));
		concreteFlow2 = new Flow<ConcreteAspect>(new ConcreteAspect("1"), new MarkupContext<ConcreteAspect>(new ConcreteAspect("script"), new ConcreteAspect("open"), new ConcreteAspect("id")));
		concreteFlow3 = new Flow<ConcreteAspect>(new ConcreteAspect("0"), new MarkupContext<ConcreteAspect>(new ConcreteAspect(), new ConcreteAspect(), new ConcreteAspect()));
		
		RequiredAspect origin = new RequiredAspect();
		origin.addForbiddenValue("0");
		
		RequiredAspect tag = new RequiredAspect();
		tag.addAllowedValue("script");
		
		RequiredAspect tagPosition = new RequiredAspect();
		tagPosition.addAllowedValue("open");
		tagPosition.addAllowedValue("center");
		
		RequiredAspect attribute = new RequiredAspect();
		attribute.addForbiddenValue("src");
		
		requiredFlow1 = new Flow<RequiredAspect>(origin, new MarkupContext<RequiredAspect>(tag, tagPosition, attribute));		
		
		requiredFlowPattern = new FlowPattern<RequiredAspect>(new RequiredAspect());
		concreteFlowPattern = new FlowPattern<ConcreteAspect>(new ConcreteAspect());
	
		requiredFlowPattern.addFlow(requiredFlow1);		
		concreteFlowPattern.addFlow(concreteFlow1);
		concreteFlowPattern.addFlow(concreteFlow2);
		concreteFlowPattern.addFlow(concreteFlow3);
	
		bypassCondition = new BypassCondition("",requiredFlowPattern);
		findingCondition = new FindingCondition(concreteFlowPattern);
		
		runTest("Condition testing 4", true);
		
		
		/*
		 * realistic bypass test that should match
		 */
		Flow<ConcreteAspect> concreteFlow0 = new Flow<ConcreteAspect>(new ConcreteAspect("2"), new MarkupContext<ConcreteAspect>(new ConcreteAspect(), new ConcreteAspect(), new ConcreteAspect()));
		concreteFlow1 = new Flow<ConcreteAspect>(new ConcreteAspect("1"), new MarkupContext<ConcreteAspect>(new ConcreteAspect(), new ConcreteAspect(), new ConcreteAspect()));
		concreteFlow2 = new Flow<ConcreteAspect>(new ConcreteAspect("0"), new MarkupContext<ConcreteAspect>(new ConcreteAspect("div"), new ConcreteAspect("open"), new ConcreteAspect("id")));
		concreteFlow3 = new Flow<ConcreteAspect>(new ConcreteAspect("1"), new MarkupContext<ConcreteAspect>(new ConcreteAspect(), new ConcreteAspect(), new ConcreteAspect()));
		Flow<ConcreteAspect> concreteFlow4 = new Flow<ConcreteAspect>(new ConcreteAspect("1"), new MarkupContext<ConcreteAspect>(new ConcreteAspect("div"), new ConcreteAspect("close"), new ConcreteAspect()));
		
		origin = new RequiredAspect();
		origin.addAllowedValue("1");
		
		tag = new RequiredAspect();
		tag.addForbiddenValue("script");
		tagPosition = new RequiredAspect();		
		attribute = new RequiredAspect();
		
		requiredFlow1 = new Flow<RequiredAspect>(origin, new MarkupContext<RequiredAspect>(tag, tagPosition, attribute));
		
		origin = new RequiredAspect();
		origin.addAllowedValue("0");
		
		tag = new RequiredAspect();	
		tagPosition = new RequiredAspect();		
		attribute = new RequiredAspect();
		
		requiredFlow2 = new Flow<RequiredAspect>(origin, new MarkupContext<RequiredAspect>(tag, tagPosition, attribute));
		
		origin = new RequiredAspect();
		origin.addAllowedValue("1");
		
		tag = new RequiredAspect();
		tag.addForbiddenValue("script");
		
		tagPosition = new RequiredAspect();
		
		attribute = new RequiredAspect();
		
		requiredFlow3 = new Flow<RequiredAspect>(origin, new MarkupContext<RequiredAspect>(tag, tagPosition, attribute));
		
		requiredFlowPattern = new FlowPattern<RequiredAspect>(new RequiredAspect());
		concreteFlowPattern = new FlowPattern<ConcreteAspect>(new ConcreteAspect());
	
		requiredFlowPattern.addFlow(requiredFlow1);
		requiredFlowPattern.addFlow(requiredFlow2);
		requiredFlowPattern.addFlow(requiredFlow3);
		
		concreteFlowPattern.addFlow(concreteFlow0);
		concreteFlowPattern.addFlow(concreteFlow1);
		concreteFlowPattern.addFlow(concreteFlow2);
		concreteFlowPattern.addFlow(concreteFlow3);
		concreteFlowPattern.addFlow(concreteFlow4);
	
		bypassCondition = new BypassCondition("",requiredFlowPattern);
		findingCondition = new FindingCondition(concreteFlowPattern);
		
		runTest("Condition testing 5", true);
		
		
		
		
		
		MarkupContext<ConcreteAspect> mk1 = new MarkupContext<ConcreteAspect>();
		mk1.setContent(new ConcreteAspect("testt'est"));
		
		MarkupContext<ConcreteAspect> mk3 = new MarkupContext<ConcreteAspect>();
		mk3.setContent(new ConcreteAspect("testtest"));
		
		MarkupContext<RequiredAspect> mk2 = new MarkupContext<RequiredAspect>();
		
		RequiredAspect rq1 = new RequiredAspect();
		rq1.addForbiddenValuePart("'");
		rq1.addForbiddenValuePart("\"");
		mk2.setContent(rq1);
		
		concreteFlow1 = new Flow<ConcreteAspect>(new ConcreteAspect(), mk1);
		concreteFlow2 = new Flow<ConcreteAspect>(new ConcreteAspect(), mk3);
		requiredFlow1 = new Flow<RequiredAspect>(new RequiredAspect(), mk2);
		
		
		requiredFlowPattern = new FlowPattern<RequiredAspect>(new RequiredAspect());
		concreteFlowPattern = new FlowPattern<ConcreteAspect>(new ConcreteAspect());
	
		requiredFlowPattern.addFlow(requiredFlow1);		
		concreteFlowPattern.addFlow(concreteFlow1);
		concreteFlowPattern.addFlow(concreteFlow2);
	
		bypassCondition = new BypassCondition("Describtion",requiredFlowPattern);
		findingCondition = new FindingCondition(concreteFlowPattern);
		
		runTest("Condition testing 6", true);
	
	}	
		
	private void runTest(String describtion, boolean expectation) {
		MatchResult result = bypassCondition.checkCondition(findingCondition);
		RunUnitTests.printTest(describtion, expectation, result.getBool());
	}

}
