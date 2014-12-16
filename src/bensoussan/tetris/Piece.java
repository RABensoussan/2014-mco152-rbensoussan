package bensoussan.tetris;

public class Piece {

	protected Square squares[][];
	
	public Piece() {
		squares = new Square[4][4];
		
		
	}
	
	public void rotateRight(){
		Square[][] temp = new Square[4][4];
		for(int i=0; i<temp.length; i++){
			for(int j=0; j<temp[0].length; j++){
				temp[i][j] = squares[Math.abs(j-3)][i];
			}
		}
		
		for(int i=0; i<squares.length; i++){
			for(int j=0; j<squares[0].length; j++){
				squares[i][j] = temp[i][j];
			}
		}

	}

	public String toString(){
		StringBuilder info = new StringBuilder();
		for(int i=0; i<squares.length; i++){
			for(int j=0; j<squares[0].length; j++){
				if(squares[i][j]==null){
					info.append("-");
				}
				else{
					info.append("O");
				}
			}
			if(i!=3){
				info.append("/n");
				}
		}
		return info.toString();
	}
}
