package bensoussan.opportunity;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NasaFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel picture;
	private int counter;
	private images[] theArray;
	private JLabel index;

	public NasaFrame() {
		counter = 0;

		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("MERA Opportunity Rover");

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		generateTheArray();
		picture = new JLabel("Loading...");
		container.add(picture, BorderLayout.CENTER);
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		JButton backButton = new JButton("<");
		JButton forwardButton = new JButton(">");
		// index = new JLabel(counter + "of " + theArray.length);
		index = new JLabel(String.valueOf(counter));

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (counter == 0) {
					counter = 255;
				} else {
					counter++;
				}
				changePicture();
				index.setText(counter + "of " + theArray.length);
			}

		});

		forwardButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (counter == 255) {
					counter = 0;
				} else {
					counter--;
				}
				changePicture();
				index.setText(counter + "of " + theArray.length);
			}

		});

		south.add(backButton);
		south.add(index);
		south.add(forwardButton);

		container.add(south, BorderLayout.SOUTH);

	}

	public void generateTheArray() {
		try {
			DownloadImageArrayThread arrayGenerator = new DownloadImageArrayThread(
					this);
			arrayGenerator.start();
		} catch (IOException e) {
		}

	}

	public void setTheArray(images[] temp) {
		theArray = temp;
	}

	public void changePicture() {
		GenerateImagesThread imageGenerator = new GenerateImagesThread(
				theArray[counter], picture);
		imageGenerator.start();

	}

	public static void main(String args[]) {
		NasaFrame aFrame = new NasaFrame();
		aFrame.setVisible(true);

	}

}
