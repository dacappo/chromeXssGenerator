package dd;


import java.util.Map;

public class Finding {
	private Integer id;
	private Integer sinkId;
	
	private String url;
	private String domain;
	
	private String value;
	private Map<String, Source> sources;
	
	private String d1;
	private String d2;
	private String d3;
	
	public Finding(Integer id, Integer sinkId, String url, String domain, String value, Map<String, Source> sources, String d1, String d2, String d3){
		this.id = id;
		this.sinkId = sinkId;
		this.url = url;
		this.domain = domain;
		this.value = value;
		this.sources = sources;
		this.d1 = d1;
		this.d2 = d2;
		this.d3 = d3;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSinkId() {
		return sinkId;
	}

	public void setSinkId(Integer sinkId) {
		this.sinkId = sinkId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Map<String, Source> getSources() {
		return sources;
	}

	public void setSources(Map<String, Source> sources) {
		this.sources = sources;
	}

	public String getD1() {
		return d1;
	}

	public void setD1(String d1) {
		this.d1 = d1;
	}

	public String getD2() {
		return d2;
	}

	public void setD2(String d2) {
		this.d2 = d2;
	}

	public String getD3() {
		return d3;
	}

	public void setD3(String d3) {
		this.d3 = d3;
	}
}
