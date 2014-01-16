package analytics.dacappo.sap.com;



public class ConcreteAspect extends Aspect {

	private String value;
	
	public ConcreteAspect() {
		this.value = null;
	}
	
	public ConcreteAspect(String value) {
		this.value = value;
	}
	 
	public void setValue(String s) {
		this.value = s;
	}
	
	@Override
	public boolean checkAspect(ConcreteAspect c) {
		
		System.out.println("this should never ever happen");
		if (value == null || value.equals(c.getValue()));
		return true;
	}
	
	public String getValue() {
			return this.value;
	}
	
	

}
