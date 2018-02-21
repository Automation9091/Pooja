package com.sis.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sis.qa.base.TestBase;

public class ExcelUtils extends TestBase {

	public static XSSFWorkbook xWorkbook;
	public static XSSFSheet xSheet;
	public static XSSFRow xRow;
	public static XSSFCell xCell;
	static String FilePath = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\sis\\qa\\testdata\\TestData.xlsx";

	/*public void main(String[] args) throws IOException {
		System.out.println(getdataFromExcel("newStudyCreation", "StudyNumber"));
	}*/

	/*public String getdataFromExcel(String strTestCaseId, String strColumnName)
	{
		FileInputStream File= null;
		//String strColumnName = "StudyNumber";
		try {
			File = new FileInputStream(FilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Excel File Not found. Error Message: " + e.getMessage());
		}
		try {
			xWorkbook = new XSSFWorkbook(File);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Excel Workbook Not found. Error Message: " + e.getMessage());
		}
		xSheet = xWorkbook.getSheet("TestData");
		String CellValue = "";
		//System.out.println("Sheet name is "+xSheet);
		int rw;
		int intRw = xSheet.getLastRowNum();
		Row refRw;
		Cell refCl;
		String strColData = "";
		for(rw=1;rw<=intRw;rw++){
			refRw = xSheet.getRow(rw);
			refCl = refRw.getCell(0);
			CellValue = refCl.getStringCellValue();
			if (CellValue.equals(strTestCaseId))
			{
				refCl = refRw.getCell(findColumnNumber(strColumnName));
				strColData = refCl.getStringCellValue();
				break;
			}
			
		 }			 		
		return strColData;
				
	}

	public int findColumnNumber(String strColumnName) {
		FileInputStream File = null;
		// String strColumnName = "StudyNumber";
		try {
			File = new FileInputStream(FilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Excel File Not found. Error Message: "
					+ e.getMessage());
		}
		try {
			xWorkbook = new XSSFWorkbook(File);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Excel Workbook Not found. Error Message: "
					+ e.getMessage());
		}
		xSheet = xWorkbook.getSheet("TestData");
		String CellValue = "";
		//System.out.println("Sheet name is " + xSheet);
		int Colno;
		Row rfRw = xSheet.getRow(0);

		for (Colno = 1; Colno <= rfRw.getLastCellNum(); Colno++) {
			CellValue = rfRw.getCell(Colno).getStringCellValue();
			System.out.println(CellValue);
			if (CellValue.equals(strColumnName)) {
				break;
			}
		}

		return Colno;
	}*/

}
