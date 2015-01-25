package bensoussan.minesweeper;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MineButton extends Button {

	private static final long serialVersionUID = 1L;

	public MineButton(int i, int j) {
		super(i, j);
	}

	public void showMine() {
		setIcon(new ImageIcon("./mine.jpg"));
	}
}
