package bensoussan.test1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bensoussan.test1.Seat;
import bensoussan.test1.UnknownSeatException;

public class Airplane {

	/**
	 * Construct a new Airplane with the specified configuration and number of
	 * rows. The configuration is a String with letters specifying a seat's
	 * position in the row and a "_" for the aisle.
	 * 
	 * For instance, an Airplane with configuration, ABC_DEFGH_JKL would be
	 * three seats, then an aisle, then 5 seats, then an aisle, then 3 seats.
	 * 
	 * @param configuration
	 * @param numRows
	 */
	private ArrayList<Seat> seats;
	private ArrayList<String> codes;
	private Map<String, Seat> airplane;
	private String configuration;
	private int numRows;
	private int numCol;

	public Airplane(String configuration, int numRows) {
		this.configuration = configuration;
		this.numRows = numRows;
		this.numCol = 0;

		seats = new ArrayList<Seat>();
		codes = new ArrayList<String>();
		airplane = new HashMap<String, Seat>();

		for (int i = 0; i < configuration.length(); i++) {
			char next = configuration.charAt(i);
			if (next != '_') {
				numCol++;
				for (int j = 0; j < numRows; j++) {
					Seat newSeat = new Seat(j+1, next);
					newSeat.setOccupied(false);
					seats.add(newSeat);
					codes.add(newSeat.getCode());
					airplane.put(newSeat.getCode(), newSeat);
					// clusters.put(newSeat, clusterNum);
				}
			}
		}
	}

	/**
	 * @return the total number of EMPTY seats on the plane.
	 */
	public int getNumEmptySeats() {
		int numSeats = 0;
		for (int i = 0; i < seats.size(); i++) {
			if (!seats.get(i).isOccupied()) {
				numSeats++;
			}
		}
		return numSeats;
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isFull() {
		for (int i = 0; i < seats.size(); i++) {
			if (!seats.get(i).isOccupied()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param code
	 * @return true if the seat is occupied, otherwise false.
	 * @throws UnknownSeatException
	 *             if the seat code is not found in the plane.
	 */
	public boolean isOccupied(String code) throws UnknownSeatException {
		if (!airplane.containsKey(code)) {
			throw new UnknownSeatException();
		}
		return airplane.get(code).isOccupied();
	}

	/**
	 * Sets the seat as occupied/unoccupied
	 * 
	 * @param code
	 * @param occupied
	 * @throws UnknownSeatException
	 *             if the seat code is not found in the plane.
	 */
	public void setOccupied(String code, boolean occupied)
			throws UnknownSeatException {
		if (!airplane.containsKey(code)) {
			throw new UnknownSeatException();
		}
		airplane.get(code).setOccupied(occupied);
	}

	/**
	 * Set all seats by their codes as occupied
	 * 
	 * @param codes
	 * @throws UnknownSeatException
	 *             if the seat code is not found in the plane.
	 */
	public void occupy(String... codes) throws UnknownSeatException {
		for (String code : codes) {
			if (!airplane.containsKey(code)) {
				throw new UnknownSeatException();
			}
			airplane.get(code).setOccupied(true);
		}
	}

	/**
	 * Sets all seats as occupied
	 * 
	 * @param seats
	 */
	public void occupy(List<Seat> seats) {
		for (int i = 0; i < seats.size(); i++) {
			seats.get(i).setOccupied(true);
		}
	}

	/**
	 * Returns the seat specified by its code
	 * 
	 * @param code
	 * @throws UnknownSeatException
	 *             if the seat code is not found in the plane.
	 */
	public Seat getSeat(String code) throws UnknownSeatException {
		if (!airplane.containsKey(code)) {
			throw new UnknownSeatException();
		}
		return airplane.get(code);
	}

	/**
	 * @return total number of seats on the plane
	 */
	public int getNumSeats() {
		return seats.size();
	}

	/**
	 * Returns the Airplane specified in text format.
	 * 
	 * The first line should be the configuration, prepended by 4 spaces Each
	 * row in the plane gets a line which starts with The row number, padded
	 * with leading zeros so that is is always 3 digits. A space Then for each
	 * seat, either a "." for an empty seat, "O" for an occupied seat and "_"
	 * for an aisle.
	 * 
	 * Example. AB_CD_EF\n 001 .._.._..\n 002 .._.._..\n 003 .._.._..\n
	 * 
	 * 
	 */
	public String toString() {
		StringBuilder info = new StringBuilder();
		DecimalFormat formatter = new DecimalFormat("000");
		info.append("    ");
		info.append(configuration);
		info.append("\n");
		int next = 0;
		for (int i = 0; i < numRows; i++) {
			info.append(formatter.format(i + 1));
			info.append(" ");
			for (int j = 0; j < configuration.length(); j++) {
				if (configuration.charAt(j) == '_') {
					info.append("_");
				} else if (seats.get(next++).isOccupied()) {
					info.append("O");
				} else {
					info.append(".");
				}
			}
			info.append("\n");
		}
		return info.toString();
	}

	/**
	 * 
	 * @param numSeatsTogeather
	 *            the number of seats to occupy.
	 * @return A list of occupied seats.
	 * @throws FullPlaneException
	 *             if the plane is full
	 * @throws NotEnoughSeatsTogeatherException
	 *             if there are not enough seats next to each other.
	 */
	public List<Seat> occupySeats(int numSeatsTogether)
			throws FullPlaneException, NotEnoughSeatsTogeatherException {

		if (this.isFull()) {
			throw new FullPlaneException();
		}

		List<Seat> occupyThese = new ArrayList<Seat>();

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < configuration.length(); j++) {
				if (configuration.charAt(j) == '_') {
					occupyThese.clear();
				} else {
					String row = String.valueOf(i+1);
					String letter = String.valueOf(configuration.charAt(j));
					String code = row + letter;
					if (!airplane.get(code).isOccupied()
							&& occupyThese.size() < numSeatsTogether) {
						occupyThese.add(airplane.get(code));
					}
				}
			}
			if (occupyThese.size() == numSeatsTogether) {
				for (int seat = 0; seat < numSeatsTogether; seat++) {
					occupyThese.get(seat).setOccupied(true);
				}
				return occupyThese;
			} else {
				occupyThese.clear();
			}
		}
		throw new NotEnoughSeatsTogeatherException();
	}

}
