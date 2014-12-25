package bensoussan.nytimes;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import com.google.gson.Gson;

public class News {

	public News() {
	}

	public NYTimes getNews() {
		String urlbeg = "http://api.nytimes.com/svc/search/v2/articlesearch.json?callback=svc_search_v2_articlesearch";
		String urlend = "&api-key=a09bd13fb9e3628ae900642f9f6a9dc0:6:70504438";
		GregorianCalendar today = new GregorianCalendar();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String date = formatter.format(today.getTime());
		String urldate = "&end_date=" + date;

		URL url;
		try {
			url = new URL(urlbeg + urldate + urlend);

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
			NYTimes news = gson.fromJson(json, NYTimes.class);
			return news;

		} catch (IOException e) {
			return null;
		}

	}

}
