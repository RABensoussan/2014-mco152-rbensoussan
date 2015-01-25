package bensoussan.minesweeper;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;

public class MinesweeperFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private int ROWS;
	private int COLS;
	private Button[][] cells;
	private Container container;
	private ActionListener listener;

	public MinesweeperFrame(int rows, int cols) {
		this.ROWS = rows;
		this.COLS = cols;

		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Minesweeper");
		setSize(400, 400);

		container = getContentPane();
		container.setLayout(new GridLayout(ROWS, COLS));

		listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Object buttonclicked = event.getSource();
				if (buttonclicked.getClass() == MineButton.class) {
					((MineButton) buttonclicked).showMine();
					((MineButton) buttonclicked).setBackground(Color.RED);
					gameOver();
				} else {
					generateNumber((Button) buttonclicked);
					clearSurroundingCells((Button) buttonclicked);
				}
			}

			private void clearSurroundingCells(Button button) {

			}
		};

		generateGrid();
		generateMines();

	}

	private void generateNumber(Button button) {
		int i = button.getI();
		int j = button.getJ();
		if (button.getClass() == MineButton.class) {
			return;
		}
		int counter = 0;
		if (isMine(i - 1, j - 1)) {
			counter++;
		}
		if (isMine(i - 1, j)) {
			counter++;
		}
		if (isMine(i - 1, j + 1)) {
			counter++;
		}
		if (isMine(i, j + 1)) {
			counter++;
		}
		if (isMine(i, j - i)) {
			counter++;
		}
		if (isMine(i + 1, j - i)) {
			counter++;
		}
		if (isMine(i + 1, j)) {
			counter++;
		}
		if (isMine(i + 1, j + i)) {
			counter++;
		}
		if (counter != 0) {
			button.setText(String.valueOf(counter));
		}
	}

	private boolean isMine(int i, int j) {
		try {
			if (cells[i][j] instanceof MineButton) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	private void generateGrid() {
		cells = new Button[COLS][ROWS];
		for (int i = 0; i < COLS; i++) {
			for (int j = 0; j < ROWS; j++) {
				final Button button = new Button(i, j);
				container.add(button);
				cells[i][j] = button;
				button.addActionListener(listener);
			}
		}

	}

	private void generateMines() {
		Random random = new Random();
		int counter = 0;
		while (counter < 10) {
			int tempCol = random.nextInt(COLS);
			int tempRow = random.nextInt(ROWS);
			if ((cells[tempCol][tempRow].getClass() != MineButton.class)) {
				cells[tempCol][tempRow] = new MineButton(tempCol, tempRow);
				counter++;
			}
		}

	}

	public void gameOver() {
		for (int i = 0; i < COLS; i++) {
			for (int j = 0; j < ROWS; j++) {
				if (cells[i][j].getClass() == MineButton.class) {
					((MineButton) cells[i][j]).showMine();
				}
			}
		}
		// --stamp picture onto screen? how else to make unresponsive?
	}

	public static void main(String[] args) {
		MinesweeperFrame gameFrame = new MinesweeperFrame(8, 8);
		gameFrame.setVisible(true);
	}
}
