package bensoussan.weather;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageDownloadThread extends Thread{

	private WeatherNow now;
	private WeatherFrame frame;
	
	public ImageDownloadThread(WeatherNow now, WeatherFrame frame){
		this.now = now;
		this.frame = frame;
	}
	
	@Override
	public void run(){
		Weather[] weather = now.getWeather();
		String iconTxt = weather[0].getIcon();
		String web = "http://openweathermap.org/img/w/" + iconTxt + ".png";
		Image image = null;
		try {
		    URL url = new URL(web);
		    image = ImageIO.read(url);
		} catch (IOException e) {
		}
		frame.displayIcon(image);
	}
}
