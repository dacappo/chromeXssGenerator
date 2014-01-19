package analytics.dacappo.sap.com;

import java.util.Iterator;
import java.util.LinkedList;

public class RequiredAspect extends Aspect {

	// defines list of values needed for a positive check - if empty nothing is needed
	private LinkedList<String> allowedValues = new LinkedList<String>();
	
	// defines list of value-parts needed for a positive check - if empty nothing is needed
	private LinkedList<String> allowedValueParts = new LinkedList<String>();
	
	// defines list of values forbidden for a positive check - if empty nothing is forbidden
	private LinkedList<String> forbiddenValues = new LinkedList<String>();
	
	// defines list of value-parts needed for a positive check - if empty nothing is forbidden
	private LinkedList<String> forbiddenValueParts = new LinkedList<String>();

	public RequiredAspect() {
	}

	public String getValue() {
		return "undefined";
	}

	public void addAllowedValue(String s) {
		this.allowedValues.add(s);
	}
	
	public void addAllowedValuePart(String s) {
		this.allowedValueParts.add(s);
	}

	public void addForbiddenValue(String s) {
		this.forbiddenValues.add(s);
	}

	public void addForbiddenValuePart(String s) {
		this.forbiddenValueParts.add(s);
	}

	// Super function: compairs two ConreteAspects : String comparison
	@Override
	public boolean checkAspect(ConcreteAspect c) {

		// Check for forbidden values
		Iterator<String> i = forbiddenValues.iterator();
		while (i.hasNext()) {
			String value = i.next();
			if (c != null && value.equals(c.getValue())) {
				return false;
			}
		}

		// Check for forbidden valueParts
		i = forbiddenValueParts.iterator();
		while (i.hasNext()) {
			String value = i.next();
			if (c != null && c.getValue().contains(value)) {
				return false;
			}
		}

		// Check for allowed values
		i = allowedValues.iterator();
		while (i.hasNext()) {
			String value = i.next();
			if (c != null && value.equals(c.getValue())) {
				return true;
			}
		}
		
		// Check for allowed valueParts
				i = allowedValueParts.iterator();
				while (i.hasNext()) {
					String value = i.next();
					if (c != null && c.getValue().contains(value)) {
						return true;
					}
				}
		

		// Check if allowedValues is empty and therefore nothing is required
		if (allowedValues.isEmpty() && allowedValueParts.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
