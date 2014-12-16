package bensoussan.gameOfLife;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameOfLife extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int ROWS = 20;
	private static final int COLS = 20;
	private JButton[][] cells;

	public GameOfLife() {
		setSize(350, 300);
		setTitle("Connect4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		Container containerCenter = new Container();
		containerCenter.setLayout(new GridLayout(ROWS, COLS));

		container.add(containerCenter, BorderLayout.CENTER);
		JButton nextButton = new JButton("Next");

		ActionListener next = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				nextGeneration();
			}
		};

		nextButton.addActionListener(next);
		container.add(nextButton, BorderLayout.WEST);

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JButton button = (JButton) event.getSource();
				button.setBackground(Color.GREEN);
			}
		};

		Random random = new Random();
		cells = new JButton[COLS][ROWS];
		for (int i = 0; i < COLS; i++) {
			for (int j = 0; j < ROWS; j++) {
				final JButton button = new JButton();
				containerCenter.add(button);
				cells[i][j] = button;
				button.addActionListener(listener);
				int n = random.nextInt(100);
				if (n < 30) {
					button.setBackground(Color.GREEN);
				} else {
					button.setBackground(Color.BLACK);
				}
			}
		}

	}

	public void nextGeneration() {
		boolean[][] alive = new boolean[COLS][ROWS];

		for (int i = 0; i < COLS; i++) {
			for (int j = 0; j < ROWS; j++) {
				int neighbors = getNumAliveNeighbors(i, j);
				switch (neighbors) {
				case 0:
				case 1:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
					alive[i][j] = false;
					break;
				case 2:
					// boolean initialized to false. If alive, change to true
					if (isAlive(i, j)) {
						alive[i][j] = true;
					}
					//not necessary?
					else{
						alive[i][j] = false;
					}
					break;
				case 3:
					alive[i][j] = true;
					break;
				default:
				}
			}
		}

		for (int i = 0; i < COLS; i++) {
			for (int j = 0; j < ROWS; j++) {
				if (alive[i][j] == true) {
					cells[i][j].setBackground(Color.GREEN);
				} else {
					cells[i][j].setBackground(Color.BLACK);
				}
			}
		}

	}

	public int getNumAliveNeighbors(int i, int j) {
		int numAlive = 0;

		if (isAlive(i - 1, j - 1)) {
			numAlive++;
		}
		if (isAlive(i, j - 1)) {
			numAlive++;
		}
		if (isAlive(i - 1, j)) {
			numAlive++;
		}
		if (isAlive(i + 1, j + 1)) {
			numAlive++;
		}
		if (isAlive(i, j + 1)) {
			numAlive++;
		}
		if (isAlive(i + 1, j)) {
			numAlive++;
		}
		if (isAlive(i - 1, j + 1)) {
			numAlive++;
		}
		if (isAlive(i + 1, j - 1)) {
			numAlive++;
		}

		return numAlive;
	}

	private boolean isAlive(int i, int j) {
		try {
			return cells[i][j].getBackground() == Color.GREEN;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String args[]) {
		GameOfLife game = new GameOfLife();
		game.setVisible(true);
	}
}
