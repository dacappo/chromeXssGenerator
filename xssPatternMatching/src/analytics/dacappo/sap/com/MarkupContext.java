package analytics.dacappo.sap.com;

import java.util.Iterator;
import java.util.LinkedList;

public class MarkupContext<AspectType extends Aspect> {
	
	// defines the all the content of the flow
	private AspectType content;
	
	// defines the current HTML tag the flow goes into
	private AspectType currentTag;
	
	// defines the current HTML tag position - where goes the flow
	private AspectType currentTagPosition; // opening: <div id=1> | center: some content | closing: </div>
	
	// defines the current HTML attribute the glow goes into
	private AspectType currentAttribute;
	
	// defines the current HTML attribute position - where goes the flow
	private AspectType currentAttributePosition; // name: id= | value: 
	
	// defines list of tags occurring before the current flow
	private LinkedList<AspectType> previousTags = new LinkedList<AspectType>();

    // defines list of attributes within the current tag occurring before the current flow
	private LinkedList<AspectType> previousAttributes = new LinkedList<AspectType>();
	
	
	/*
	 * Not used for pattern matching -> exploit generation (e.g. contains ' or ")
	 */
	
	
	// defines the mark-up of the entire tag the flow ends
	private String tagMarkup;
	
	//defines the mark-up of the entire attribute the flow ends (part of tagMarkup above)
	private String attributeMarkup;
	
	
	/**
	 * Constructor
	 */
	public MarkupContext() {
		this.currentTag = null;
		this.currentTagPosition = null;
		this.currentAttribute = null;
		this.currentAttributePosition = null;
	}
	
	/**
	 * Constructor
	 */
	public MarkupContext(AspectType currentTag) {
		this.currentTag = currentTag;
		this.currentTagPosition = null;
		this.currentAttribute = null;
		this.currentAttributePosition = null;
	}
	
	/**
	 * Constructor
	 */
	public MarkupContext(AspectType currentTag, AspectType currentTagPosition) {
		this.currentTag = currentTag;
		this.currentTagPosition = currentTagPosition;
		this.currentAttribute = null;
		this.currentAttributePosition = null;
	}
	
	/**
	 * Constructor
	 */
	public MarkupContext(AspectType currentTag, AspectType currentTagPosition, AspectType currentAttribute) {
		this.currentTag = currentTag;
		this.currentTagPosition = currentTagPosition;
		this.currentAttribute = currentAttribute;
		this.currentAttributePosition = null;
	}
	
	/**
	 * Constructor
	 */
	public MarkupContext(AspectType currentTag, AspectType currentTagPosition, AspectType currentAttribute, AspectType currentAttributePosition) {
		this.currentTag = currentTag;
		this.currentTagPosition = currentTagPosition;
		this.currentAttribute = currentAttribute;
		this.currentAttributePosition = currentAttributePosition;
	}
	
	/**
	 * Constructor
	 */
	public AspectType getCurrentTag() {
		return this.currentTag;
	}
	
	
	public void setCurrentTag(AspectType currentTag) {
		this.currentTag = currentTag;
	}
	
	public AspectType getCurrentTagPosition() {
		return this.currentTagPosition;
	}
	
	public void setCurrentTagPosition(AspectType currentTagPosition) {
		this.currentTagPosition = currentTagPosition;
	}
	
	public AspectType getCurrentAttribute() {
		return this.currentAttribute;
	}
	
	public void setCurrentAttribute(AspectType currentAttribute) {
		this.currentAttribute = currentAttribute;
	}
	
	public AspectType getCurrentAttributePosition() {
		return this.currentAttributePosition;
	}
	
	public AspectType getContent() {
		return this.content;
	}
	
	public void setContent(AspectType content) {
		this.content = content;
	}
	
	public void setCurrentAttributePosition(AspectType currentAttributePosition) {
		this.currentAttributePosition = currentAttributePosition;
	}
	
	public void addPreviousTag(AspectType a) {
		previousTags.add(a);
	}
	
	public void addPreviousAttribute(AspectType a) {
		previousAttributes.add(a);
	}
	
	public LinkedList<AspectType> getPreviousTags() {
		return previousTags;
	}
	
	public LinkedList<AspectType> getPreviousAttributes() {
		return previousAttributes;
	}
	
	public void setTagMarkup(String tagMarkup) {
		this.tagMarkup = tagMarkup;
	}
	
	public String getTagMarkup() {
		return this.tagMarkup;
	}
	
	public void setAttributeMarkup(String attributeMarkup) {
		this.attributeMarkup = attributeMarkup;
	}
	
	public String getAttributeMarkup() {
		return this.attributeMarkup;
	}
	
	
	/**
	 * Checks markupContext for matches with the own one
	 * @param MarkupContext
	 * @return boolean
	 */
	public boolean checkMarkupContext(MarkupContext<ConcreteAspect> mc) {
		
		boolean content, tag, tagPosition, attribute, attributePosition;
		
		if (this.content != null) {
			content = this.content.checkAspect(mc.getContent());
		} else {
			content = true;
		}		
		
		if (this.currentTag != null) {
			tag = this.currentTag.checkAspect(mc.getCurrentTag());
		} else {
			tag = true;
		}
		
		if (this.currentTagPosition != null) {
			tagPosition = this.currentTagPosition.checkAspect(mc.getCurrentTagPosition());
		} else {
			tagPosition = true;
		}
		
		if (this.currentAttribute != null) {
			attribute = this.currentAttribute.checkAspect(mc.getCurrentAttribute());
		} else {
			attribute = true;
		}
		
		if (this.currentAttributePosition != null) {
			attributePosition = this.currentAttributePosition.checkAspect(mc.getCurrentAttributePosition());
		} else {
			attributePosition = true;
		}
		
		return	content &&
				tag &&
				tagPosition &&
				attribute &&
				attributePosition &&
				this.checkMarkupContextPrevious(mc);
	}
	
	
	/**
	 * Checks a markupContext comparing to the own one - sub-method for checking lists of previous tags and attributes
	 */
	private boolean checkMarkupContextPrevious(MarkupContext<ConcreteAspect> mc) {
		
		boolean result = true;
		
		Iterator<AspectType> iRequired = previousTags.iterator();
		while(iRequired.hasNext()) {
			AspectType requiredAspect = iRequired.next();
			Iterator<ConcreteAspect> iConcrete = mc.getPreviousTags().iterator();
			while(iConcrete.hasNext()) {
				if(!requiredAspect.checkAspect(iConcrete.next())) {
					result = false;
				}	
			}
		}
		
		iRequired = previousAttributes.iterator();
		while(iRequired.hasNext()) {
			AspectType requiredAspect = iRequired.next();
			Iterator<ConcreteAspect> iConcrete = mc.getPreviousAttributes().iterator();
			while(iConcrete.hasNext()) {
				if(!requiredAspect.checkAspect(iConcrete.next())) {
					result = false;
				}	
			}
		}
		return result;
	}

}
