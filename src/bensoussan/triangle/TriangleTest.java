package bensoussan.triangle;

import org.junit.Assert;
import org.junit.Test;


public class TriangleTest {

	@Test
	public void testTriangle() {
		Triangle tri = new Triangle(6);
		String shape = tri.toString();
		Assert.assertEquals("     *\n    * *\n   *   *\n  *     *\n *       *\n***********", shape);
	}

	@Test
	public void testTriangle2(){
		Triangle tri = new Triangle(9);
		String shape = tri.toString();
		Assert.assertEquals("        *\n       * *\n      *   *\n     *     *\n    *       *\n   *         *\n  *           *\n *             *\n*****************", shape);
	}
}
