package bensoussan.tetris;

public class ZPiece extends Piece{

	public ZPiece(){
		super();
		
		squares[2][0] = new Square();
		squares[2][1] = new Square();
		squares[3][1] = new Square();
		squares[3][2] = new Square();
	}
}
