package bensoussan.vendingmachine;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

	private ArrayList<Item> items;
	private Map<String, Item> itemCodes;

	public Inventory() {
		items = new ArrayList<Item>();
		itemCodes = new HashMap<String, Item>();
	}

	public void load(String inventoryFilename) throws IOException {
		Scanner input = new Scanner(new File(inventoryFilename));
		input.useDelimiter(",|\n");
		while (input.hasNext()) {
			String code = input.next();
			String name = input.next();
			double price = input.nextDouble();
			int quantity = input.nextInt();
			Item a = new Item(code, name, price, quantity);
			this.items.add(a);
			this.itemCodes.put(code, a);
		}
		input.close();
	}

	/**
	 * 
	 * @param code
	 * @return the item or null if an item with that code doesn't exist
	 */
	public Item get(String code) {
		return itemCodes.get(code);
	}

	/**
	 * 
	 * @param item
	 *            to add
	 */
	public void add(Item item) {
		this.items.add(item);
		this.itemCodes.put(item.getCode(), item);
	}

	/**
	 * Removes one from quantity of the specified item
	 * 
	 * @param code
	 */
	public void removeOne(String code) {
		int qty = itemCodes.get(code).getQuantity();
		itemCodes.get(code).setQuantity(--qty);
	}

	/**
	 * 
	 * @param code
	 * @return true if the Item exists and there is at least one quantity,
	 *         otherwise false.
	 */
	public boolean isEmpty(String code) {
		try {
			int qty = itemCodes.get(code).getQuantity();
			if (qty <= 0) {
				return true;
			} else {
				return false;
			}
		} catch (NullPointerException e) {
			return true;
		}

	}

	/**
	 * Lists the items in the inventory one per line in the format code name @
	 * price x quantity\n
	 */
	public String toString() {
		StringBuilder info = new StringBuilder();
		DecimalFormat formatter = new DecimalFormat("$0.00");
		for (int i = 0; i < this.items.size(); i++) {
			info.append(this.items.get(i).getCode());
			info.append(" ");
			info.append(this.items.get(i).getName());
			info.append(" @ ");
			info.append(formatter.format(this.items.get(i).getPrice()));
			info.append(" x ");
			info.append(this.items.get(i).getQuantity());
			info.append("\n");
		}
		return info.toString();
	}

}
