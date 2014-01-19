package analytics.dacappo.sap.com;

public class Flow<AspectType extends Aspect> {
	
	// defines source of a flow
	private AspectType origin;
	
	// defines the context within the HTMl mark-up of the flow
	private MarkupContext<AspectType> markupContext;

	/**
	* Constructor
	*/
	public Flow(AspectType origin, MarkupContext<AspectType> markupContext) {
		this.origin = origin;
		this.markupContext = markupContext;
	}
	
	/**
	* Checks if Flow matches the own one
	* @param Flow
	* @return boolean
	*/
	public boolean checkFlow(Flow<ConcreteAspect> f) {
		return 	origin.checkAspect(f.getOrigin()) &&
				markupContext.checkMarkupContext(f.getMarkupContext());		
	}
	
	/**
	* Returns origin
	* @return AspectType
	*/
	public AspectType getOrigin() {
		return this.origin;
	}
	
	/**
	* Returns the markupContext
	* @return markupContext
	*/
	public MarkupContext<AspectType> getMarkupContext() {
		return this.markupContext;
	}

}
