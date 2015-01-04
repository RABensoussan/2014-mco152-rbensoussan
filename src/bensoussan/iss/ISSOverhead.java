package bensoussan.iss;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ISSOverhead {

	public static void main(String args[]) {
		String address = "1602 Avenue J Brooklyn, NY 11230";

		GetISS anISSGetter;
		try {
			anISSGetter = new GetISS(address);
			ISS iss = anISSGetter.getIss();
			Response[] responses = iss.getResponse();

			String[] timestamps = new String[responses.length];
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd' 'HH:mm:ss' 'zzz");

			for (int i = 0; i < responses.length; i++) {
				long time = responses[i].getRisetime();
				Date date = new Date(time * 1000L);
				timestamps[i] = formatter.format(date);
			}

			for (String a : timestamps) {
				System.out.println(a);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
