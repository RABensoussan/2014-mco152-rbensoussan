package bensoussan.tetris;

public class JPiece extends Piece{

	public JPiece(){
		super();
		
		squares[1][3] = new Square();
		squares[2][3] = new Square();
		squares[3][3] = new Square();
		squares[3][2] = new Square();
	}
}
