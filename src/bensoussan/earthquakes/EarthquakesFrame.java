package bensoussan.earthquakes;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class EarthquakesFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public EarthquakesFrame() throws IOException{
		
		setSize(400, 200);
		setTitle("Significant Earthquakes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		GenerateEarthquakes gen = new GenerateEarthquakes();
		Earthquakes eqs = gen.getEarthquakes();
		Earthquake[] eqsArray = eqs.getFeatures();
		JList<Earthquake> eqslist = new JList<Earthquake>(eqsArray);
		eqslist.setLayoutOrientation(JList.VERTICAL);
		eqslist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(eqslist);
		
	}
	
	public static void main(String args[]) throws IOException{
		EarthquakesFrame frame = new EarthquakesFrame();
		frame.setVisible(true);
	
		
	}
}
