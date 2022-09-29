package utils;

public class ExcelUtilsCallFunction {

	public static void main(String[] args){
	
		//String projDir = System.getProperty("user.dir");
		//System.out.println("projDir");
		String excelPath="/home/credenc/workspace/RESTAssuredAutomation/data/ReportData.xlsx";
		String sheetName ="Sheet2";
		
		ExcelUtils excel = new ExcelUtils(excelPath,sheetName);
		
		excel.getRowCount();
		excel.getCellData(1,0);
		excel.getCellData(1,1);
		excel.getCellData(1,2);
		excel.getCellData(1,3);
		}
	}
