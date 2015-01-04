package bensoussan.iss;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

public class GetISS {

	private ISS iss;

	public GetISS(String address) throws IOException {

		GetCoordinates coordinate = new GetCoordinates(address);
		double lat = coordinate.getLatitude();
		double lng = coordinate.getLongitude();

		String urlText = "http://api.open-notify.org/iss-pass.json?lat=" + lat
				+ "&lon=" + lng;

		URL url = new URL(urlText);
		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		String json = IOUtils.toString(in);

		Gson gson = new Gson();
		iss = gson.fromJson(json, ISS.class);

	}

	public ISS getIss() {
		return iss;
	}
}
