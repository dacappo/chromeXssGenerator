package dd;


public class Source {
	public Integer sourceId;
	public String sourceName;
	public String sourcePart;
	
	public Integer startPosition;
	public Integer endPosition;
	
	public Integer hasEscaping;
	public Integer hasEncodeURI;
	public Integer hasEncodeURIComponent;
	
	public Source(Integer sourceId, String sourceName, String sourcePart, 	Integer hasEscaping, Integer hasEncodeURI, Integer hasEncodeURIComponent) {
		this.sourceId = sourceId;
		this.sourceName = sourceName;
		this.sourcePart = sourcePart;
		this.hasEncodeURI = hasEncodeURI;
		this.hasEncodeURIComponent = hasEncodeURIComponent;
		this.hasEscaping = hasEscaping;
	}
	
	public Source(Integer sourceId, String sourceName, String sourcePart, Integer startPosition, Integer endPosition, Integer hasEscaping, Integer hasEncodeURI, Integer hasEncodeURIComponent) {
		this.sourceId = sourceId;
		this.sourceName = sourceName;
		this.sourcePart = sourcePart;
		
		this.startPosition = startPosition;
		this.endPosition = endPosition;
		
		this.hasEncodeURI = hasEncodeURI;
		this.hasEncodeURIComponent = hasEncodeURIComponent;
		this.hasEscaping = hasEscaping;
		
	}
	
	public Integer getStartPostition() {
		return startPosition;
	}
	
	public Integer getEndPosition() {
		return endPosition;
	}

	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourcePart() {
		return sourcePart;
	}

	public void setSourcePart(String sourcePart) {
		this.sourcePart = sourcePart;
	}

	public Integer getHasEscaping() {
		return hasEscaping;
	}

	public void setHasEscaping(Integer hasEscaping) {
		this.hasEscaping = hasEscaping;
	}

	public Integer getHasEncodeURI() {
		return hasEncodeURI;
	}

	public void setHasEncodeURI(Integer hasEncodeURI) {
		this.hasEncodeURI = hasEncodeURI;
	}

	public Integer getHasEncodeURIComponent() {
		return hasEncodeURIComponent;
	}

	public void setHasEncodeURIComponent(Integer hasEncodeURIComponent) {
		this.hasEncodeURIComponent = hasEncodeURIComponent;
	}
}
