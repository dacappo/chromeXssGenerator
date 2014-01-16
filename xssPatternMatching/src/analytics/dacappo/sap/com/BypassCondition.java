package analytics.dacappo.sap.com;

public class BypassCondition extends Condition<RequiredAspect> {
	
	// String-based description of bypass for output overview
	private String describtion;

	/**
	* Constructor: calls super constructor of Condtion
	*/
	public BypassCondition(String describtion, FlowPattern<RequiredAspect> flowPattern) {
		super(flowPattern);
		this.describtion = describtion;		
	}
	
	public String getDescribtion(){
		return describtion;
	}
	
	/**
	* Checks if FindingCondition match to this BypassCondtion
	* @param FindingCondition
	* @return boolean
	*/
	public MatchResult checkCondition(FindingCondition fc) {
		return this.flowPattern.checkPattern(fc.getFlowPatern());
	}
}
