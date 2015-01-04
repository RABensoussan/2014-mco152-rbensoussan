package bensoussan.iss;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

public class GetCoordinates {

	private double longitude;
	private double latitude;

	public GetCoordinates(String address) throws IOException {

		address = URLEncoder.encode(address, "UTF-8");
		String urlText = "https://maps.googleapis.com/maps/api/geocode/json?address="
				+ address + "&key=AIzaSyDaKi-f2TSBHAYzfrK2IaENmC0IBTWK_uE";

		URL url = new URL(urlText);
		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		String json = IOUtils.toString(in);
		Gson gson = new Gson();
		Geocode geo = gson.fromJson(json, Geocode.class);

		Results[] results = geo.getResults();
		Location loc = results[0].getGeometry().getLocation();
		latitude = loc.getLat();
		longitude = loc.getLng();
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}
}
