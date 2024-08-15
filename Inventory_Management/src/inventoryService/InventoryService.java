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
	
	/**
	 * this method used to create the item
	 * 
	 * @param sc
	 * 
	 * @author spandiyaraj
	 * @Date Aug 15, 2024
	 */
	public void createItem(Scanner sc) {
		Item itm = new Item();
		System.out.println("Enter Item Name : ");
		itm.setName(sc.next());
		System.out.println("Enter Item Price : ");
		itm.setPrice(sc.nextLong());
		itm.setItemId(++itmId);
		
		item.add(itm);
	}
	
	/**
	 * this method used to create the Inventory
	 * 
	 * @param sc
	 * 
	 * @author Santhosh
	 * @date Aug 15, 2024
	 */
	public void createInventory(Scanner sc) {
		Inventory inv = new Inventory();
		System.out.println("Enter Inventory Name : ");
		inv.setName(sc.next());
		inv.setInventoryId(++invid);
		
		inventory.add(inv);
	}
	
	/**
	 * this method is used add item in inventory
	 *  
	 * @param sc
	 * 
	 * @author Santhosh
	 * @date Aug 15, 2024
	 */
	public void addItemsInInventory(Scanner sc) {
		
		System.out.println("Inventory Detail");
		getInventory();
		
		System.out.println("Please enter the Inventory Id");
		Long invtValue = sc.nextLong();

		inventory.stream()
		.filter(invt -> invt.getInventoryId().equals(invtValue))
		.findFirst()
		.ifPresent(invt -> {
			System.out.println(" Item Detail ");
			getItems();
			
			System.out.println("please Enter the Item Id");
			Long itmValue = sc.nextLong();
			
			item.stream()
			.filter(itm -> itm.getItemId().equals(itmValue))
			.findFirst()
			.ifPresent( itm -> {
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
				invt.getItem().add(itemobj);
				
				
				Inventory invent = new Inventory();
				invent.setInventoryId(invt.getInventoryId());
				invent.setName(invt.getName());
				invent.setQuantity(Quantity);
				
				itm.getInventery().add(invent);
				
			});
			
		});
	}
	
	/**
	 * this method used to get the items
	 * 
	 * @author Santhosh
	 * @date Aug 15, 2024
	 */
	public void getItems(){
		item.stream().forEach(itm->System.out.println(itm.getItemId() + " => " + itm.getName()));
	}
	
	/**
	 * this method used to get the inventory
	 * 
	 * @author Santhosh
	 * @date Aug 15, 2024
	 */
	public void getInventory() {
		inventory.stream().forEach(invt -> System.out.println(invt.getInventoryId() + " => " + invt.getName()));
	}
	
	/**
	 * this method used to get item by item id
	 * 
	 * @param id
	 * 
	 * @author Santhosh
	 * @date Aug 15, 2024
	 */
	public void getItemByItemid(Long id) {
		item.stream()
		.filter(itm -> itm.getItemId().equals(id))
		.findFirst()
		.ifPresent( itm -> {
			System.out.println("Items Value");
			System.out.println("name  : " + itm.getName());
			System.out.println("Price : " + itm.getPrice());
			System.out.println("TotalQuantity : " + itm.getTotalQuantity());
			System.out.println("Inventory Detail");
			
			itm.getInventery().stream().forEach( inventory -> {
					System.out.println("name : " + inventory.getName());
					System.out.println("Quantity : " + inventory.getQuantity());
				}
			);
			
		});
	}
	
	/**
	 * this method used to get inventory by id
	 * 
	 * @param id
	 * 
	 * @author Santhosh
	 * @date Aug 15, 2024
	 */
	public void getInventoryById(Long id) {
		
		inventory.stream().forEach( inv -> {
			System.out.println("Inventory detail");
			System.out.println("Inventory Id : " + inv.getInventoryId());
			System.out.println("Inventory Name : " + inv.getName());
			inv.getItem().stream().forEach(itm -> {
				System.out.println("Item Id : " + itm.getItemId());
				System.out.println("Item Name : " + itm.getName());
				System.out.println("Item : " + itm.getQuantity());
			});
		});
	}
}
