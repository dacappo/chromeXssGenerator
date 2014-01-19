package analytics.dacappo.sap.com;

public abstract class Aspect {
	
	/**
	 * Abstract method for checking a single aspect - returns false, because it is overwirtten
	 * for RequiredApsects
	 * 
	 * Concrete Aspects should not be able to call this method!
	 */
	public boolean checkAspect(ConcreteAspect c) {return false;};
	
}
