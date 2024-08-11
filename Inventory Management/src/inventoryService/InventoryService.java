package inventoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import inventoryModel.Inventory;
import inventoryModel.Item;

public class InventoryService {
	private static Long invid = 0L;
	private static Long itmId = 0L;
	
	
	
	List<Item> item = new ArrayList<>();
	List<Inventory> inventory = new ArrayList<>();
	
	public void createItem(Scanner sc) {
		Item itm = new Item();
		System.out.println("Enter Item Name : ");
		itm.setName(sc.next());
		System.out.println("Enter Item Price : ");
		itm.setPrice(sc.nextLong());
		itm.setItemId(++itmId);
		
		item.add(itm);
	}
	
	public void createInventory(Scanner sc) {
		Inventory inv = new Inventory();
		System.out.println("Enter Inventory Name : ");
		inv.setName(sc.next());
		inv.setInventoryId(++invid);
		
		inventory.add(inv);
	}
	
	public void addItemsInInventory(Scanner sc) {
		System.out.println("Inventory Detail");
		for (Inventory invt : inventory) {
			System.out.println(invt.getInventoryId() + " => " + invt.getName());
		}
		System.out.println("Please enter the Inventory Id");
		Long invtValue = sc.nextLong();

		for (Inventory invt : inventory) {
			if (invt.getInventoryId().equals(invtValue)) {
				System.out.println(" Item Detail ");
				for (Item itm : item) {
					System.out.println(itm.getItemId() + " => " + itm.getName());
				}

				System.out.println("please Enter the Item Id");
				Long itmValue = sc.nextLong();
				for (Item itm : item) {
					if (itm.getItemId().equals(itmValue)) {
						System.out.println("Please enter the Quantity");
						Long Quantity = sc.nextLong();
						//to prepare item Object
						Item itemobj = new Item();
						itemobj.setItemId(itm.getItemId());
						itemobj.setName(itm.getName());
						itemobj.setPrice(itm.getPrice());
						itemobj.setQuantity(Quantity);
						
						
						itm.setTotalQuantity(itm.getTotalQuantity() + Quantity);
						
						//to set the inventory details in Items 
						List<Inventory> inventory = itm.getInventery();
						inventory.add(invt);
						itm.setInventery(inventory);
						
						//to set the items detail in Inventory
						//List<Item> item = invt.getItem();
						
						for(List<Item> item : invt.getItem()) {
							item.add(itemobj);
							invt.setItem(item);
							invt.setQuantity();
						}
						
						
					}
				}

			}
		}
	}
	
	public void getItems(){
		System.out.println("smm");
		for (Item itm : item) {
			System.out.println(itm.getItemId() + " => " + itm.getName());
		}
	}
	
	public void getInventory() {
		for (Inventory invt : inventory) {
			System.out.println(invt.getInventoryId() + " => " + invt.getName());
		}
	}
	
	public void getItemByItemid(Long id) {
		for (Item itm : item) {
			if(itm.getItemId().equals(id)) {
				System.out.println("Items Value");
				System.out.println("name  : " + itm.getName());
				System.out.println("Price : " + itm.getPrice());
				System.out.println("TotalQuantity : " + itm.getTotalQuantity());
				System.out.println("Inventory Detail");
				for(Inventory inventory : itm.getInventery()) {
					System.out.println("name : " + inventory.getName());
					System.out.println("Quantity : " + inventory.getQuantity());
				}
				
			}
		}
		System.out.println("Enter the Item Value");
		
		
	}
}
