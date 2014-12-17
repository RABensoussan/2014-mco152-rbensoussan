package bensoussan.earthquakes;

public class Earthquake {

	private Properties properties;
	
	public Properties getProperties(){
		return properties;
	}
	
	public String toString(){
		StringBuilder info = new StringBuilder();
		info.append("Place: ");
		info.append(properties.getPlace());
		info.append("Magnitude: ");
		info.append(properties.getMag());
		return info.toString();
	}
	
	
}
