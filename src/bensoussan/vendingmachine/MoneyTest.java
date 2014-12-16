package bensoussan.vendingmachine;

import org.junit.Assert;
import org.junit.Test;

public class MoneyTest {

	@Test
	public void testAdd() {
		Money money = new Money(1, 2, 0, 0);
		money.add(new Money(1, 0, 0, 1));
		Money test = new Money(2, 2, 0, 1);
		Assert.assertEquals(test.getTotal(), money.getTotal(), 0.0);
	}

	@Test
	public void testRemove() {
		Money money = new Money(2, 2, 2, 2);
		try {
			money.remove(1.25);
		} catch (NotEnoughChangeException e) {
			e.printStackTrace();
		}
		Money test = new Money(1, 1, 2, 2);
		Assert.assertEquals(test.getTotal(), money.getTotal(), 0.0);
	}

	@Test
	public void testRemove2() {
		Money money = new Money(0, 4, 2, 2);
		try {
			money.remove(1.25);
		} catch (NotEnoughChangeException e) {
			e.printStackTrace();
		}
		Money test = new Money(0, 0, 0, 1);
		Assert.assertEquals(test.getTotal(), money.getTotal(), 0.0);
	}

	@Test
	public void testRemove3() {
		Money money = new Money(0, 7, 1, 0);
		try {
			money.remove(.80);
			Assert.fail("Should throw not enough change exception");
		} catch (NotEnoughChangeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testGetTotal() {
		Money money = new Money(2, 2, 2, 2);
		double total = money.getTotal();
		total = Math.round(total * 100.0) / 100.0;
		Assert.assertEquals(2.80, total, 0.0);
	}

	@Test
	public void testGetTotalZero() {
		Money money = new Money(0, 0, 0, 0);
		double total = Math.round(money.getTotal() * 100.0) / 100.0;
		Assert.assertEquals(0, total, 0.0);
	}
	
	@Test
	public void testGetTotal2(){
		Money money = new Money(0,0,0,1);
		double total = Math.round(money.getTotal() * 100.0) / 100.0;
		Assert.assertEquals(.05, total, 0.0);
	}
}
