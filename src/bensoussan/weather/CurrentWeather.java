package bensoussan.weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class CurrentWeather {
	
	public CurrentWeather(){
		
	}
	
	public WeatherNow getWeatherNow() throws IOException{
		
		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Brooklyn&units=imperial");
		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		//I want to output my JSON to the screen
				//input streams don't care about string, longs, doubles, nothing. They care about bytes. It returns the value of the byte.
				//characters and bytes are the same thing. Everything is a number in computers - everything is given a number value
				//A is 0065. A byte equals 66 and the char equal to that byte is B.
		byte b[] = new byte[4096];
		int n=1;
		StringBuilder builder = new StringBuilder();
		while((n= in.read(b)) != -1){
			builder.append(new String(b, 0, n));
		}
		String json = builder.toString();
		//this reads 4096 bytes from our input stream. N is the amount of bytes that were read
		
		Gson gson = new Gson();
		//we're going to give Gson a string and tell Gson to turn this string into a class
		WeatherNow now = gson.fromJson(json, WeatherNow.class);
		return now;
	}

}
