package bensoussan.tetris;

public class BoxPiece extends Piece{

	public BoxPiece(){
		super();
		squares[1][1] = new Square();
		squares[1][2] = new Square();
		squares[2][1] = new Square();
		squares[2][2] = new Square();
		
	}
}
