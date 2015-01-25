package bensoussan.minesweeper;

import javax.swing.JButton;

public class Button extends JButton{

	private static final long serialVersionUID = 1L;
	private int i;
	private int j;
	
	public Button(int i, int j){
		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}
	
	
}
