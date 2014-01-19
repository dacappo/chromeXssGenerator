package analytics.dacappo.sap.com;

import java.util.LinkedList;

public class FlowPattern<AspectType extends Aspect> {
	
	// defines sink of flows
	private AspectType sink;
	
	// defines row of sources for the sink
	private LinkedList<Flow<AspectType>> flows = new LinkedList<Flow<AspectType>>();

	/**
	* Constructor
	*/
	public FlowPattern(AspectType sink) {
		this.sink = sink;
	}
	
	/**
	* Adds part of flow - similar to a source
	* @param Flow
	*/
	public void addFlow(Flow<AspectType> f) {
		flows.add(f);
	}
	
	/**
	* Checks if a FlowPattern matches the own one
	* @param FlowPattern
	* @return boolean
	*/
	public MatchResult checkPattern(FlowPattern<ConcreteAspect> fp) {
		
		MatchResult result = new MatchResult();
		result.setBool(false);
		
		LinkedList<Flow<ConcreteAspect>> concreteFlow = fp.getFlows();
		
		int concreteFlowPosition = 0;
		int requiredFlowPosition = 0;
		
		// Pattern matching - similar to String matching algorithm
		while (concreteFlow.size() >= concreteFlowPosition + this.flows.size()) {
			
			while(	this.flows.size() > requiredFlowPosition &&
					this.flows.get(requiredFlowPosition).checkFlow(concreteFlow.get(concreteFlowPosition + requiredFlowPosition))) {
				
				if(requiredFlowPosition == this.flows.size() - 1) {
					// If the needed pattern fits the concrete flow situation
					result.setFlowPatternPosition(concreteFlowPosition);
					result.setBool(true);
				} 
				requiredFlowPosition++;
			}
			requiredFlowPosition = 0;
			concreteFlowPosition++;
		}
		
		// In case there is no required flow structure
		if(this.flows.size() == 0) {
			result.setBool(true);
		}
		
		result.setBool(sink.checkAspect(fp.getSink()) && result.getBool());
		return 	result;
	}
	
	/**
	* returns sink
	* @return AspectType
	*/	
	public AspectType getSink() {
		return sink;
	}
	
	/**
	* returns list of flows(sources)
	* @return LinkedList<Flow>
	*/
	public LinkedList<Flow<AspectType>> getFlows() {
		return flows;
	}

}
