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
			
			System.out.println(" 6 => getItemByItemId ");
			System.out.println(" 7 => getInventoryById ");

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
				case 6:
					System.out.println("please enter the Item id");
					Long itemId = sc.nextLong();
					if(itemId>0) {
						invService.getItemByItemid(itemId);
					}
					break;
				case 7:
					System.out.println("please enter the Inventory id");
					Long inventoryId = sc.nextLong();
					if(inventoryId > 0) {
						invService.getInventoryById(inventoryId);
					}
				}
			}
		}
	}
}
