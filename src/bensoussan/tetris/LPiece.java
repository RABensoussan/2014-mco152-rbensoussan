package bensoussan.tetris;

public class LPiece extends Piece{

	public LPiece(){
		super();
		squares[1][0] = new Square();
		squares[2][0] = new Square();
		squares[3][0] = new Square();
		squares[3][1] = new Square();
	}
}
