package bensoussan.tetris;

import org.junit.Assert;
import org.junit.Test;


public class PieceTest {

	@Test
	public void testPiece() {
		JPiece jp = new JPiece();
		String str = jp.toString();
		Assert.assertEquals("----/n---O/n---O/n--OO", str);
	}
	
	@Test
	public void testPieceRotate(){
		TPiece tp = new TPiece();
		tp.rotateRight();
		String str = tp.toString();
		Assert.assertEquals("-O--/nOO--/n-O--/n----", str);
		
	}

}
