package bensoussan.connectFour;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Connect4Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	public Connect4Frame() {
		setSize(350, 300);
		setTitle("Connect4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		GridLayout layout = new GridLayout(6, 7);
		Container container = getContentPane();
		container.setLayout(layout);
		
		ActionListener listener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				JButton button = (JButton) event.getSource();
				if(button.getBackground() == Color.GREEN){
					button.setBackground(Color.PINK);
				}
				else{
					button.setBackground(Color.GREEN);
				}
		}
			};
			
		for (int i = 0; i < 6*7; i++) {
			JButton button = new JButton();
			container.add(button);	
			button.addActionListener(listener);
		}
	}

	public static void main(String args[]) {
		Connect4Frame game = new Connect4Frame();
		game.setVisible(true);
	}
}
