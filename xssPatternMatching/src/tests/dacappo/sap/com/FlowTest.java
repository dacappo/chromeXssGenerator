package tests.dacappo.sap.com;

import analytics.dacappo.sap.com.ConcreteAspect;
import analytics.dacappo.sap.com.Flow;
import analytics.dacappo.sap.com.MarkupContext;
import analytics.dacappo.sap.com.RequiredAspect;

public class FlowTest {
	
	Flow<ConcreteAspect> fc;
	Flow<RequiredAspect> fr;
	
	public FlowTest() {
				
		fc = new Flow<ConcreteAspect>(new ConcreteAspect(), new MarkupContext<ConcreteAspect>(new ConcreteAspect(), new ConcreteAspect(), new ConcreteAspect()));
		fr = new Flow<RequiredAspect>(new RequiredAspect(), new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect(), new RequiredAspect()));
		runTest("empty ConcreteFlow - Empty ConcreteFlow ", true);
		
		fc = new Flow<ConcreteAspect>(new ConcreteAspect("1"), new MarkupContext<ConcreteAspect>(new ConcreteAspect(), new ConcreteAspect(), new ConcreteAspect()));
		fr = new Flow<RequiredAspect>(new RequiredAspect(), new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect(), new RequiredAspect()));
		runTest("origin ConcreteFlow - Empty ConcreteFlow ", true);
		
		fc = new Flow<ConcreteAspect>(new ConcreteAspect("1"), new MarkupContext<ConcreteAspect>(new ConcreteAspect("div"), new ConcreteAspect(), new ConcreteAspect()));
		fr = new Flow<RequiredAspect>(new RequiredAspect(), new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect(), new RequiredAspect()));
		runTest("origin tag ConcreteFlow - Empty ConcreteFlow ", true);
		
		fc = new Flow<ConcreteAspect>(new ConcreteAspect("1"), new MarkupContext<ConcreteAspect>(new ConcreteAspect("div"), new ConcreteAspect("1"), new ConcreteAspect("src")));
		fr = new Flow<RequiredAspect>(new RequiredAspect(), new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect(), new RequiredAspect()));
		runTest("origin tag ConcreteFlow - Empty ConcreteFlow ", true);
		
		fc = new Flow<ConcreteAspect>(new ConcreteAspect("1"), new MarkupContext<ConcreteAspect>(new ConcreteAspect("div"), new ConcreteAspect("1"), new ConcreteAspect("src")));
		fr = new Flow<RequiredAspect>(new RequiredAspect(), new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect(), new RequiredAspect()));
		runTest("origin tag position attribute ConcreteFlow - Empty ConcreteFlow ", true);
		
		RequiredAspect ra1 = new RequiredAspect();
		ra1.addAllowedValue("1");
		fc = new Flow<ConcreteAspect>(new ConcreteAspect(), new MarkupContext<ConcreteAspect>(new ConcreteAspect("div"), new ConcreteAspect("1"), new ConcreteAspect("src")));
		fr = new Flow<RequiredAspect>(ra1, new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect(), new RequiredAspect()));
		runTest("tag  position attriubteConcreteFlow - origin ConcreteFlow ", false);
		
		ra1 = new RequiredAspect();
		ra1.addAllowedValue("1");
		fc = new Flow<ConcreteAspect>(new ConcreteAspect("0"), new MarkupContext<ConcreteAspect>(new ConcreteAspect("div"), new ConcreteAspect("1"), new ConcreteAspect("src")));
		fr = new Flow<RequiredAspect>(ra1, new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect(), new RequiredAspect()));
		runTest("tag  position attriubteConcreteFlow - origin ConcreteFlow ", false);
		
		ra1 = new RequiredAspect();
		RequiredAspect ra2 = new RequiredAspect();
		ra1.addAllowedValue("1");
		ra2.addAllowedValue("id");
		fc = new Flow<ConcreteAspect>(new ConcreteAspect("1"), new MarkupContext<ConcreteAspect>(new ConcreteAspect("div"), new ConcreteAspect("1"), new ConcreteAspect("src")));
		fr = new Flow<RequiredAspect>(ra1, new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect(), ra2));
		runTest("tag  position attriubteConcreteFlow - origin ConcreteFlow ", false);
		
		ra1 = new RequiredAspect();
		ra2 = new RequiredAspect();
		ra1.addAllowedValue("1");
		ra2.addAllowedValue("docsrc");
		ra2.addAllowedValue("src");
		fc = new Flow<ConcreteAspect>(new ConcreteAspect("1"), new MarkupContext<ConcreteAspect>(new ConcreteAspect("div"), new ConcreteAspect("1"), new ConcreteAspect("src")));
		fr = new Flow<RequiredAspect>(ra1, new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect(), ra2));
		runTest("tag  position attriubteConcreteFlow - origin ConcreteFlow ", true);
		
		ra1 = new RequiredAspect();
		ra2 = new RequiredAspect();
		ra1.addAllowedValue("1");
		ra2.addAllowedValue("id");
		ra2.addAllowedValue("src");
		RequiredAspect ra3 = new RequiredAspect();
		ra3.addForbiddenValue("srcdoc");
		fc = new Flow<ConcreteAspect>(new ConcreteAspect("1"), new MarkupContext<ConcreteAspect>(new ConcreteAspect("div"), new ConcreteAspect("1"), new ConcreteAspect("srcdoc")));
		fr = new Flow<RequiredAspect>(ra1, new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect(), ra2));
		runTest("tag  position attriubteConcreteFlow - origin ConcreteFlow ", false);
		
		ra1 = new RequiredAspect();
		ra1.addForbiddenValue("sr");
		ra1.addForbiddenValue("src");
		
		MarkupContext<RequiredAspect> mcon1 = new MarkupContext<RequiredAspect>(new RequiredAspect(), new RequiredAspect());
		mcon1.addPreviousAttribute(ra1);
		
		MarkupContext<ConcreteAspect> mcon2 = new MarkupContext<ConcreteAspect>(new ConcreteAspect("div"), new ConcreteAspect("1"), new ConcreteAspect("id"));
		mcon2.addPreviousAttribute(new ConcreteAspect("src"));
		
		fc = new Flow<ConcreteAspect>(new ConcreteAspect("1"), mcon2);
		fr = new Flow<RequiredAspect>(new RequiredAspect(), mcon1 );
		runTest("previous attribute", false);
		
	}
	
	private void runTest(String describtion, boolean expectation) {
		boolean result = fr.checkFlow(fc);
		RunUnitTests.printTest(describtion, expectation, result);
	}

}
