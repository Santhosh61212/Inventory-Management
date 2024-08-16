package inventoryModel;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Item {
	
	private int itemId;
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
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
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
	
	
	public void updateCell(XSSFSheet Sheet) {
		int cellNum = 0;
		System.out.println("ItemId " + getItemId());
		
		Row row = Sheet.createRow(getItemId());
//		if (getItemId() > 0) {
//			Cell cell = row.createCell(cellNum);
//			cell.setCellValue(getItemId());
//			++cellNum;
//		}
		if(getItemId() > 0) {
			Cell cell = row.createCell(cellNum);
			cell.setCellValue(getItemId());
			++cellNum;
		}
		
		if (getName() != null) {
			Cell cell = row.createCell(cellNum);
			cell.setCellValue(getName());
			++cellNum;
		}

		if (getPrice() != null) {
			Cell cell = row.createCell(cellNum);
			cell.setCellValue(getPrice());
			++cellNum;
		}
	}
	

}
