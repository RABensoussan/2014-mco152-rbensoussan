package bensoussan.test1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AirplaneTest {

	@Test
	public void testToStringWithEmptyPlane() {
		Airplane plane = new Airplane("AB_CD_EF", 3);
		String planePic = plane.toString();
		Assert.assertEquals("    AB_CD_EF\n" + "001 .._.._..\n"
				+ "002 .._.._..\n" + "003 .._.._..\n", planePic);
	}

	@Test
	public void testToStringWithFullPlane() throws UnknownSeatException {
		Airplane plane = new Airplane("AB_CD_EF", 3);
		plane.occupy("1A", "1B", "1C", "1D", "1E", "1F", "2A", "2B", "2C",
				"2D", "2E", "2F", "3A", "3B", "3C", "3D", "3E", "3F");
		Assert.assertEquals("    AB_CD_EF\n" + "001 OO_OO_OO\n"
				+ "002 OO_OO_OO\n" + "003 OO_OO_OO\n", plane.toString());
	}

	@Test
	public void testGetNumSeats() {
		Airplane plane = new Airplane("AB_CD_EF", 3);
		Assert.assertEquals(18, plane.getNumSeats());
	}

	@Test
	public void testGetNumEmptySeats() throws UnknownSeatException {
		Airplane plane = new Airplane("AB_CD_EF", 3);
		try {
			plane.occupy("1A");
		} catch (UnknownSeatException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(17, plane.getNumEmptySeats());
	}

	@Test
	public void testIsFull() throws UnknownSeatException {
		Airplane plane = new Airplane("AB_CD_EF", 3);
		try {
			plane.occupy("1A");
		} catch (UnknownSeatException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertFalse(plane.isFull());
	}

	@Test
	public void testGetSeatThrowsUnknownSeatException() {
		Airplane plane = new Airplane("AB_CD_EF", 3);
		try {
			plane.getSeat("4A");
			Assert.fail("Should throw an UnknownSeatException");
		} catch (UnknownSeatException e) {
		}
	}

	@Test
	public void testOccupySeats() throws UnknownSeatException,
			FullPlaneException, NotEnoughSeatsTogeatherException {
		Airplane plane = new Airplane("AB_CD_EF", 3);
		plane.occupy("1A", "1B", "1D", "2A", "2B", "2C", "2E", "2F", "3B",
				"3E", "3F");
		// should occupy 1E and 1F
		List<Seat> occupied = new ArrayList<Seat>();
		occupied = plane.occupySeats(2);
		List<Seat> expected = new ArrayList<Seat>();
		expected.add(new Seat(1, 'E'));
		expected.add(new Seat(1, 'F'));
		Assert.assertEquals(expected, occupied);
	}

	@Test
	public void testOccupySeatsThrowsNotEnoughSeatsTogeatherException()
			throws FullPlaneException, UnknownSeatException {
		Airplane plane = new Airplane("AB_CD_EF", 3);
		plane.occupy("1A", "1B", "1D", "1E", "1F", "2A", "2B", "2C", "2D",
				"2E", "2F", "3A", "3B", "3C", "3E", "3F");
		try {
			plane.occupySeats(3);
			Assert.fail("Should have thrown NotEnoughSeatsTogeatherException");
		} catch (NotEnoughSeatsTogeatherException e) {
		}
	}

	@Test
	public void testOccupySeatsThrowsFullPlaneException()
			throws NotEnoughSeatsTogeatherException, UnknownSeatException {
		Airplane plane = new Airplane("AB_CD_EF", 3);
		plane.occupy("1A", "1B", "1C", "1D", "1E", "1F", "2A", "2B", "2C",
				"2D", "2E", "2F", "3A", "3B", "3C", "3D", "3E", "3F");
		try {
			plane.occupySeats(3);
			Assert.fail("Should have thrown full plane exception");
		} catch (FullPlaneException e) {
		}
	}

}
