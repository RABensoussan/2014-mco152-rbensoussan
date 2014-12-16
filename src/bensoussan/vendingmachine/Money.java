package bensoussan.vendingmachine;

public class Money {

	private int numDollars;
	private int numQuarters;
	private int numDimes;
	private int numNickles;

	public Money() {

	}

	public Money(int numDollars, int numQuarters, int numDimes, int numNickles) {
		this.numDollars = numDollars;
		this.numQuarters = numQuarters;
		this.numDimes = numDimes;
		this.numNickles = numNickles;
	}

	public void add(Money money) {
		this.numDollars += money.getNumDollars();
		this.numQuarters += money.getNumQuarters();
		this.numDimes += money.getNumDimes();
		this.numNickles += money.getNumNickles();
	}

	public Money remove(double amount) throws NotEnoughChangeException {
		int amount2 = (int) (amount * 100);
		int dollarsNeeded = amount2 / 100;
		int dollarsDispensed = 0;
		if (dollarsNeeded <= this.numDollars) {
			dollarsDispensed = dollarsNeeded;
			this.numDollars -= dollarsDispensed;
			dollarsNeeded = 0;
		} else {
			dollarsDispensed = this.numDollars;
			this.numDollars = 0;
			dollarsNeeded -= dollarsDispensed;
		}
		amount2 -= dollarsDispensed * 100;
		int quartersNeeded = amount2 / 25;
		int quartersDispensed = 0;
		if (quartersNeeded <= this.numQuarters) {
			quartersDispensed = quartersNeeded;
			this.numQuarters -= quartersDispensed;
			quartersNeeded = 0;
		} else {
			quartersDispensed = this.numQuarters;
			this.numQuarters = 0;
			quartersNeeded -= quartersDispensed;
		}
		amount2 -= quartersDispensed * 25;
		int dimesNeeded = amount2 / 10;
		int dimesDispensed = 0;
		if (dimesNeeded <= this.numDimes) {
			dimesDispensed = dimesNeeded;
			this.numDimes -= dimesDispensed;
			dimesNeeded = 0;
		} else {
			dimesDispensed = this.numDimes;
			this.numDimes = 0;
			dimesNeeded -= dimesDispensed;
		}
		amount2 -= dimesDispensed * 10;
		int nicklesNeeded = amount2 / 5;
		int nicklesDispensed = 0;
		if (nicklesNeeded <= this.numNickles) {
			nicklesDispensed = nicklesNeeded;
			this.numNickles -= nicklesDispensed;
			nicklesNeeded = 0;
		} else {
			throw new NotEnoughChangeException();
		}
		Money mon = new Money(dollarsDispensed, quartersDispensed,
				dimesDispensed, nicklesDispensed);
		return mon;
	}

	public double getTotal() {
		double total = 0;
		total += this.numDollars * 1;
		total += this.numQuarters * .25;
		total += this.numDimes * .1;
		total += this.numNickles * .05;
		total = Math.round(total * 100.0) / 100.0;
		return total;
	}

	public int getNumDollars() {
		return numDollars;
	}

	public void setNumDollars(int numDollars) {
		this.numDollars = numDollars;
	}

	public int getNumQuarters() {
		return numQuarters;
	}

	public void setNumQuarters(int numQuarters) {
		this.numQuarters = numQuarters;
	}

	public int getNumNickles() {
		return numNickles;
	}

	public void setNumNickles(int numNickles) {
		this.numNickles = numNickles;
	}

	public int getNumDimes() {
		return numDimes;
	}

	public void setNumDimes(int numDimes) {
		this.numDimes = numDimes;
	}

}
