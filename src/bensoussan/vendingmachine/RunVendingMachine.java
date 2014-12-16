package bensoussan.vendingmachine;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class RunVendingMachine {

	// print inventory
	// make selection
	// input money
	// input selection
	// output change
	public static void main(String[] args) {

		Inventory inventory = new Inventory();
		try {
			inventory.load("./inventory.txt");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		Money bank = new Money(10, 10, 10, 10);
		VendingMachine a = new VendingMachine(inventory, bank);

		// print inventory
		System.out.println(inventory.toString());
		// make selection
		System.out.println("Add Money/Make Selection?");
		System.out.println("1. Dollar\n2. Quarter\n3. Dime\n4. Nickle");
		System.out.println("or enter in the Item Code");
		Scanner keyboard = new Scanner(System.in);
		DecimalFormat formatter = new DecimalFormat("$0.00");

		Money change = new Money();

		while (change.getTotal() == 0) {
			String choice = keyboard.next();
			choice.toUpperCase();
			switch (choice) {
			case "1":
				a.pay(new Money(1, 0, 0, 0));
				System.out.println("Balance "
						+ formatter.format(a.getPaid().getTotal()));
				break;
			case "2":
				a.pay(new Money(0, 1, 0, 0));
				System.out.println("Balance "
						+ formatter.format(a.getPaid().getTotal()));
				break;
			case "3":
				a.pay(new Money(0, 0, 1, 0));
				System.out.println("Balance "
						+ formatter.format(a.getPaid().getTotal()));
				break;
			case "4":
				a.pay(new Money(0, 0, 0, 1));
				System.out.println("Balance "
						+ formatter.format(a.getPaid().getTotal()));
				break;
			default:
				try {
					if (inventory.get(choice).getQuantity() == 0) {
						System.out.println("Out of stock");
					}
					else{
					change = a.buy(choice);
					System.out.println("Dispensing "
							+ inventory.get(choice).getName());
					System.out.println("Change "
							+ formatter.format(change.getTotal()));
					System.exit(0);
					}
				} catch (CodeNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (NotEnoughPaidException e) {
					System.out.println(e.getMessage());
				} catch (NotEnoughChangeException e) {
					System.out.println(e.getMessage());
				} catch(NullPointerException e){
					System.out.println("Code Not Found");
				}
			}// end switch case
		}// end while
		keyboard.close();
	}

}
