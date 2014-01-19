package analytics.dacappo.sap.com;

public abstract class Condition<AspectType extends Aspect> {
	
	// defines row of flows
	protected FlowPattern<AspectType> flowPattern;

	/**
	 * Constructor
	 * @param flowPattern
	 */
	public Condition(FlowPattern<AspectType> flowPattern) {
		this.flowPattern = flowPattern;
	}
		
	public FlowPattern<AspectType> getFlowPatern() {
		return this.flowPattern;
	}

}
