package bensoussan.opportunity;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GenerateImagesThread extends Thread {

	images a;
	JLabel picture;

	public GenerateImagesThread(images a, JLabel picture) {
		this.a = a;
		this.picture = picture;
	}

	@Override
	public void run() {
		String urlStr = a.getUrl();
		try {
			URL url = new URL(urlStr);
			Image image = ImageIO.read(url);
			ImageIcon icon = new ImageIcon(image);
			picture.setIcon(icon);
		} catch (IOException e) {
		}
	}

}
