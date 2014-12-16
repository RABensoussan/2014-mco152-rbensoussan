package bensoussan.weather;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class WeatherNow {

	private String name;
	private Weather[] weather;
	private Main main;
	
		public String getName() {
		return name;
	}
	public Weather[] getWeather() {
		return weather;
	}
	public Main getMain() {
		return main;
	}
	public ImageIcon getImage(){
		String iconTxt = weather[0].getIcon();
		String web = "http://openweathermap.org/img/w/" + iconTxt + ".png";
		Image image = null;
		try {
		    URL url = new URL(web);
		    image = ImageIO.read(url);
		} catch (IOException e) {
		}
		ImageIcon icon = new ImageIcon(image);
		return icon;
	}
	
}
