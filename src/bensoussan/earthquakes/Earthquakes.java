package bensoussan.earthquakes;

public class Earthquakes {

	private Earthquake[] features;
	
	public Earthquakes(){
		
	}
	
	public Earthquake get(int i){
		return features[i];
	}
	
	public Earthquake[] getFeatures(){
		return features;
	}
	
	public String toString(){
		StringBuilder info = new StringBuilder();
		for(Earthquake a: features){
			info.append(a.toString());
			info.append("\n");
		}
		return info.toString();
	}
	
}
