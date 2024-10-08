package inventoryModel;

import java.util.ArrayList;
import java.util.List;

public class Item {
	
	private Long itemId;
	private String name;
	private Long Quantity;
	private Long  totalQuantity = 0L;
	private Long price;
	
	public Long getQuantity() {
		return Quantity;
	}
	public void setQuantity(Long quantity) {
		Quantity = quantity;
	}
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	List<Inventory> inventery = new ArrayList<>();
	
	public List<Inventory> getInventery() {
		return inventery;
	}
	public void setInventery(List<Inventory> inventery) {
		this.inventery = inventery;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Long quantity) {
		this.totalQuantity = quantity;
	}
	

}
