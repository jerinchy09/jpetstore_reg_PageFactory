package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	String filepath="C:\\Users\\USER\\Desktop\\testdata.xlsx";
	public String[] readExcel() throws IOException {
		String[] data = new String[5];
		
		FileInputStream fis = new FileInputStream(filepath);
		 //read the workbook
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Row row = sheet.getRow(1);
		
		Cell cell = row.getCell(0);
		String username = cell.getStringCellValue();
	
		Cell cell2 = row.getCell(1);
		String password= cell2.getStringCellValue();
		
		data[0]=username;
		data[1]=password;
		return data;
		
	}
}
