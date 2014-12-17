package bensoussan.weather;

import java.awt.Container;
import java.awt.Font;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WeatherFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public WeatherFrame() throws IOException {

		setSize(270, 250);
		setTitle("Current Weather");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

		/*CurrentWeather curr = new CurrentWeather();
		WeatherNow now = curr.getWeatherNow();
		
		JLabel title = new JLabel("Weather in Brooklyn");
		title.setBorder(BorderFactory.createEmptyBorder(10, 10, 4, 10));
		title.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		container.add(title);
		
		double temp = now.getMain().getTemp();
		JLabel tempLabel = new JLabel(String.valueOf(temp));
		tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		tempLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		container.add(tempLabel);

		ImageIcon iconLogo = now.getImage();
		JLabel icon = new JLabel(iconLogo, JLabel.CENTER);
		icon.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		container.add(icon);
		
		Weather[] weathers = now.getWeather();
		for(Weather w: weathers){
			JLabel main = new JLabel("Main: " + w.getMain());
			main.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
			container.add(main);
			JLabel desc = new JLabel("Description: " + w.getDescription());
			desc.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
			container.add(desc);
		}
		
		JLabel min = new JLabel("Temp Min: " + now.getMain().getTempMin());
		min.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		container.add(min);
		JLabel max = new JLabel("Temp Max: " + now.getMain().getTempMax());
		max.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		container.add(max);*/

		WeatherDownloadThread thread = new WeatherDownloadThread();
		//to run a thread, you do not call run. you call thread.start()
		thread.start();
		
		
		
	}

	public static void main(String args[]) throws IOException {
		WeatherFrame frame = new WeatherFrame();
		frame.setVisible(true);
	}
}
