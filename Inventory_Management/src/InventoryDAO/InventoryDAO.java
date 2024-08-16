package InventoryDAO;

import java.io.File; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import inventoryModel.Item;

public class InventoryDAO {
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private final static List<String>itemList = new ArrayList<>(Arrays.asList("Id", "ItemName", "ItemPrice"));
	static int  collValue = 0;

	static {
		try {
			
			FileInputStream file = new FileInputStream(new File("G:\\Projects\\Data\\InventoryManagement.xlsx"));
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);

		} catch (FileNotFoundException e) {

			System.out.println("exception" + e);
			
			File file = new File("G:\\Projects\\Data\\InventoryManagement.xlsx");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet("Items detail");
			Row row = sheet.createRow(0);
			itemList.stream().forEach(itmValue -> {
				if(collValue < 3) {
					Cell cell = row.createCell(collValue++); 
					cell.setCellValue(itmValue);
				}
			});
			
			

		} catch (IOException e) {

			System.out.println("ioException" + e);

		}
	}

	public void createItem(Item itm) {
		itm.updateCell(sheet);
		try {
			FileOutputStream out = new FileOutputStream(new File("G:\\Projects\\Data\\InventoryManagement.xlsx"));
			workbook.write(out);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getItems() {}

}
		
			 
	  
	 
