package bensoussan.earthquakes;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class GenerateEarthquakes {

	public GenerateEarthquakes() {
	}

	public Earthquakes getEarthquakes() throws IOException {
		URL url = new URL(
				"http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/significant_month.geojson");
		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();

		byte b[] = new byte[4096];
		int n = 1;
		StringBuilder builder = new StringBuilder();
		while ((n = in.read(b)) != -1) {
			builder.append(new String(b, 0, n));
		}
		String json = builder.toString();

		Gson gson = new Gson();
		Earthquakes eq = gson.fromJson(json, Earthquakes.class);
		return eq;
	}
}
