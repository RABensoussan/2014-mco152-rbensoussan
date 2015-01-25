package bensoussan.opportunity;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JLabel;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

public class DownloadImageArrayThread extends Thread {

	private NasaFrame frame;

	public DownloadImageArrayThread(NasaFrame frame) throws IOException {
		this.frame = frame;
	}

	@Override
	public void run() {
		try {
			URL url = new URL(
					"http://merpublic.s3.amazonaws.com/oss/mera/images/images_sol13.json");
			URLConnection connection = url.openConnection();
			InputStream in;

			in = connection.getInputStream();
			String json = IOUtils.toString(in);
			Gson gson = new Gson();
			NasaAPI nasaAPI = gson.fromJson(json, NasaAPI.class);
			frame.setTheArray(nasaAPI.getImages());

			frame.changePicture();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
