package bensoussan.nytimes;

public class Docs {
	private String web_url;
	private String lead_paragraph;
	private Headline headline;

	public Docs(){}
	
	public String getWeb_url() {
		return web_url;
	}

	public String getLead_paragraph() {
		return lead_paragraph;
	}

	public Headline getHeadline() {
		return headline;
	}
	
	public String toString(){
		return web_url + lead_paragraph + headline;
	}
	
}
