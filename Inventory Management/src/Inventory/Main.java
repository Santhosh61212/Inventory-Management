package Inventory;

import java.lang.*;
import java.util.*;

import inventoryService.InventoryService;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int value = -1;
		InventoryService invService = new InventoryService();
		while (value != 0) {
			System.out.println(" 1 => createItems");
			System.out.println(" 2 => createInventory");
			System.out.println(" 3 => addItemsInInventory");

			System.out.println(" 4 => getItems");
			System.out.println(" 5 => getInventory");

			System.out.println("Enter the value : ");
			
			value = sc.nextInt();
			if (value > 0) {
				switch (value) {
				case 1:
					invService.createItem(sc);
					break;
				case 2:
					invService.createInventory(sc);
					break;
				case 3:
					invService.addItemsInInventory(sc);
					break;
				case 4:
					invService.getItems();
					break;
				case 5:
					invService.getInventory();
					break;

				}
			}
		}
	}
}
