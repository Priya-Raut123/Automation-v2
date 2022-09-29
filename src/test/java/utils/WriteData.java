package utils;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {
	
	public static void main(String[] args) throws IOException
	{
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Api Info");
		
		Object data[][] = {
				{"ApiName","LeadId","Response"},
				{"priya",202928,"PASS"},
				{"TESTING",202928,"PASS"}
			
		};
		//Using for reach loop...
		
		int rowCount=0;
		for(Object api[]:data) {
			XSSFRow row = sheet.createRow(rowCount++);
			int columnCount=0;
			for(Object value:api) {
				XSSFCell cell = row.createCell(columnCount++);
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);


			}
		}
	
	String filePath="/home/credenc/workspace/RESTAssuredAutomation/data/WriteData.xlsx";
	FileOutputStream outstream = new FileOutputStream(filePath);
	workbook.write(outstream);
	outstream.close();
	System.out.println("WriteData.xls file written successfully...");

}
	public void priya(Object body) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Api Info");
		
		Object data[][] = {
				{"ApiName","LeadId","Response"},
				{"priya",202928,"PASS"},
				{"RAUT",202928,"PASS"}
			
		};
		//Using for reach loop...
		
		int rowCount=0;
		for(Object api[]:data) {
			XSSFRow row = sheet.createRow(rowCount++);
			int columnCount=0;
			for(Object value:api) {
				XSSFCell cell = row.createCell(columnCount++);
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);


			}
		}
	
	String filePath="/home/credenc/workspace/RESTAssuredAutomation/data/WriteData.xlsx";
	FileOutputStream outstream = new FileOutputStream(filePath);
	workbook.write(outstream);
	outstream.close();
	System.out.println("WriteData.xls file written successfully...");
	
	
	
	}
	
	
	
	

}
