package bensoussan.tetris;

public class SPiece extends Piece{

	public SPiece(){
		super();
		
		squares[2][1] = new Square();
		squares[2][2] = new Square();
		squares[3][0] = new Square();
		squares[3][1] = new Square();
		
	}
}
