package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getDataFromExcel {
	
	public Object[][] getData(String filePath,String sheetName) throws IOException {
		
		FileInputStream fis =  new FileInputStream(filePath);
		
		DataFormatter formatter =  new DataFormatter();		//To Format the Data in Excel
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);   // Considering we're using .xlsx format file 
														 // - If its .xls format we have to use HSSFWorkbook
		XSSFSheet sheet = workbook.getSheet(sheetName);  // XSSFSheet implements Sheet interface in Apache-poi package
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfCols = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data = new Object[noOfRows-1][noOfCols];
		
		for(int i=0;i<noOfRows-1;i++)
		{
			XSSFRow row = sheet.getRow(i+1);
			for(int j=0;j<noOfCols;++j)
			{
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
				
				/* This is another way to format the data
				if(sheet.getRow(i).getCell(j).getCellType()==CellType.STRING) {
					data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
				else if(sheet.getRow(i).getCell(j).getCellType()==CellType.NUMERIC)
				{
					data[i][j] = NumberToTextConverter.toText(sheet.getRow(i).getCell(j).getNumericCellValue());
				}*/
			}
		}
		workbook.close();
		fis.close();
		return data;
	}

}
