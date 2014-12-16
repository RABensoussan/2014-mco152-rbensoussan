package bensoussan.vendingmachine;

public class VendingMachine {

	private Inventory inventory;
	private Money bank;

	/**
	 * The amount of money the person has put into the Vending Machine so far
	 */
	private Money paid;

	public VendingMachine(Inventory inventory, Money bank) {
		this.inventory = inventory;
		this.bank = bank;
		paid = new Money();
	}

	public Inventory getInventory() {
		return inventory;
	}

	public Money getBank() {
		return bank;
	}

	public Money getPaid() {
		return paid;
	}

	/**
	 * Add additional Money to the machine
	 * 
	 * @param additional
	 * @return the amount that the person has put into the machine
	 */
	public double pay(Money additional) {
		paid.add(additional);
		return paid.getTotal();
	}

	/**
	 * 
	 * @param code
	 * @return the amount of change as a Money object
	 * @throws CodeNotFoundException
	 *             if there is no item with that code
	 * @throws NotEnoughPaidException
	 *             if paid is not enough to buy the item
	 * @throws NotEnoughChangeException
	 *             if the transaction cannot be completed because there isn't
	 *             enough money in the vending machine for the change
	 */
	public Money buy(String code) throws CodeNotFoundException,
			NotEnoughPaidException, NotEnoughChangeException {
		if (inventory.get(code) == null) {
			throw new CodeNotFoundException();
		}
		if (paid.getTotal() < inventory.get(code).getPrice()) {
			throw new NotEnoughPaidException();
		}
		double paid = this.paid.getTotal();
		double price = inventory.get(code).getPrice();
		double change = paid - price;
		change = Math.round(change * 100.0) / 100.0;
		bank.add(this.paid);
		Money changeReturned = bank.remove(change);
		inventory.removeOne(code);
		this.paid.setNumDimes(0);
		this.paid.setNumDollars(0);
		this.paid.setNumNickles(0);
		this.paid.setNumQuarters(0);
		return changeReturned;
	}

}
