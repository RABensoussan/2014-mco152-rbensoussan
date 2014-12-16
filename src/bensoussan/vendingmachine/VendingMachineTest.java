package bensoussan.vendingmachine;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class VendingMachineTest {

	@Test
	public void testPay() {
		Inventory inv = new Inventory();
		Money bank = new Money(10, 10, 10, 10);
		VendingMachine vm = new VendingMachine(inv, bank);
		double paidamount = vm.pay(new Money(1, 1, 0, 0));
		Assert.assertEquals(1.25, paidamount, 0.0);
	}

	@Test
	public void testBuy() throws CodeNotFoundException, NotEnoughPaidException,
			NotEnoughChangeException {
		Inventory inv = new Inventory();
		try {
			inv.load("./inventory.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Money bank = new Money(10, 10, 10, 10);
		VendingMachine vm = new VendingMachine(inv, bank);
		vm.pay(new Money(2, 0, 0, 0));
		int currentQty = inv.get("B02").getQuantity();
		Money change = vm.buy("B02");
		Assert.assertEquals(0.0, vm.getPaid().getTotal(), 0);
		Assert.assertEquals(.70, change.getTotal(), 0);
		Assert.assertEquals(currentQty--, inv.get("B02").getQuantity());
	}

	@Test
	public void testBuyOnlyNickles() throws CodeNotFoundException,
			NotEnoughPaidException, NotEnoughChangeException {
		Inventory inv = new Inventory();
		try {
			inv.load("./inventory.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Money bank = new Money(0, 0, 0, 20);
		VendingMachine vm = new VendingMachine(inv, bank);
		vm.pay(new Money(2, 0, 0, 0));
		Money change = vm.buy("B02");
		Assert.assertEquals(.70, change.getTotal(), 0);

	}

	@Test
	public void testBuyThrowsCodeNotFoundException()
			throws NotEnoughPaidException, NotEnoughChangeException {
		Inventory inv = new Inventory();
		try {
			inv.load("./inventory.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Money bank = new Money(10, 10, 10, 10);
		VendingMachine vm = new VendingMachine(inv, bank);
		try {
			vm.buy("A22");
			Assert.fail("Should have thrown a code not found exception");
		} catch (CodeNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testBuyThrowsNotEnoughPaidException()
			throws CodeNotFoundException, NotEnoughChangeException {
		Inventory inv = new Inventory();
		try {
			inv.load("./inventory.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Money bank = new Money(10, 10, 10, 10);
		VendingMachine vm = new VendingMachine(inv, bank);
		vm.pay(new Money(0, 1, 1, 1));
		try {
			vm.buy("A01");
			Assert.fail("Should have thrown a not enough paid exception");
		} catch (NotEnoughPaidException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testBuyThrowsNotEnoughChangeException()
			throws CodeNotFoundException, NotEnoughPaidException {
		Inventory inv = new Inventory();
		try {
			inv.load("./inventory.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Money bank = new Money(0, 1, 0, 2);
		VendingMachine vm = new VendingMachine(inv, bank);
		vm.pay(new Money(2, 0, 0, 0));
		try {
			vm.buy("B02");
			Assert.fail("Should have thrown a Not Enough Change Exception");
		} catch (NotEnoughChangeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testBuyThrowsNotEnoughChangeExceptionOnlyDollars()
			throws CodeNotFoundException, NotEnoughPaidException {
		Inventory inv = new Inventory();
		try {
			inv.load("./inventory.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Money bank = new Money(10, 0, 0, 0);
		VendingMachine vm = new VendingMachine(inv, bank);
		vm.pay(new Money(2, 0, 0, 0));
		try {
			vm.buy("B02");
			Assert.fail("Should throw not enough change exception - only dollars in machine, need ten cents change");
		} catch (NotEnoughChangeException e) {
			System.out.println(e.getMessage());
		}
	}
}
