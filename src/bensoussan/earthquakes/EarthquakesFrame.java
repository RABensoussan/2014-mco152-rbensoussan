package bensoussan.earthquakes;

import java.awt.Container;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EarthquakesFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public EarthquakesFrame() throws IOException{
		
		setSize(400, 400);
		setTitle("Significant Earthquakes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		GenerateEarthquakes gen = new GenerateEarthquakes();
		Earthquakes eqs = gen.getEarthquakes();
		
		
		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		container.add(new JLabel(eqs.toString()));
		
	}
	
	public static void main(String args[]) throws IOException{
		EarthquakesFrame frame = new EarthquakesFrame();
		frame.setVisible(true);
	
		
	}
}
