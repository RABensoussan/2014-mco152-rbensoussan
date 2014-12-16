package bensoussan.tetris;

public class TPiece extends Piece{
	
	public TPiece(){
		super();
		
		squares[2][0] = new Square();
		squares[2][1] = new Square();
		squares[2][2] = new Square();
		squares[3][1] = new Square();
	}
}
