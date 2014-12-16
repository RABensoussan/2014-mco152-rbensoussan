package bensoussan.vendingmachine;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class InventoryTest {

	@Test
	public void testLoad() {
		Inventory inv = new Inventory();
		try {
			inv.load("./inventory.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		Assert.assertTrue(inv != null);
	}

	@Test
	public void testGetNull(){
		Inventory inv = new Inventory();
		try {
			inv.load("./inventory.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(null, inv.get("A22"));
	}
	
	@Test
	public void testRemoveOne() {
		Inventory inv = new Inventory();
		try {
			inv.load("./inventory.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int qty = inv.get("A01").getQuantity();
		qty = qty--;
		inv.removeOne("A01");
		Assert.assertEquals(qty, inv.get("A01").getQuantity());

	}

	@Test
	public void testIsEmpty() {
		Inventory inv = new Inventory();
		try {
			inv.load("./inventory.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertFalse(inv.isEmpty("A01"));
	}
	
	@Test
	public void testIsEmptyVoidCode() {
		Inventory inv = new Inventory();
		try {
			inv.load("./inventory.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(inv.isEmpty("A22"));
	}

}
