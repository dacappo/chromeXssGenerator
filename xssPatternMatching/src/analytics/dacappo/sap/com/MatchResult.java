package analytics.dacappo.sap.com;

public class MatchResult {
	
	private boolean bool = false;
	private int flowPatternPosition;
	
	public void setBool(boolean bool) {
		this.bool = bool;
	}
	
	public boolean getBool() {
		return this.bool;
	}
	
	public void setFlowPatternPosition(int i) {
		this.flowPatternPosition = i;
	}
	
	public int getFlowPatternPosition() {
		return this.flowPatternPosition;
	}

}
