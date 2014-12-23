package bensoussan.nytimes;

public class Response {

	private Meta meta;
	private Docs[] docs;
	
	public Response(){
	}
	
	public Meta getMeta(){
		return meta;
	}
	
	public Docs[] getDocs(){
		return docs;
	}
}
