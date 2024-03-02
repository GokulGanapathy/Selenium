package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ExcelDataDriven_Intro {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList data = getData("Purchase");
		System.out.println(data);
		
	}
	
	public static ArrayList getData(String TestCaseName) throws IOException
	{
		ArrayList<String> list = new ArrayList<>();
		
		FileInputStream fis = new FileInputStream("ExcelData\\TestData.xlsx");  //Relative Path
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int noOfsheets = workbook.getNumberOfSheets();
		XSSFSheet sheet =null;
		//sheet=workbook.getSheet("TestSheet1");
		for(int i=0;i<noOfsheets;++i) {
			if(workbook.getSheetName(i).equals("TestSheet1"))
			{
				sheet = workbook.getSheetAt(i);
			}
		}
		
		// Method 1
		/* Conventional way of getting Data
		int numOfRows = sheet.getPhysicalNumberOfRows();
		int numOfCols = sheet.getRow(0).getPhysicalNumberOfCells();
		String testData[][]=new String[numOfRows][numOfCols];
		
		int column=0;
		XSSFRow row = sheet.getRow(0);  // 0th index row is always headers
		for(int i=0;i<numOfCols;++i)
		{
			if(row.getCell(i).getStringCellValue().equalsIgnoreCase("TestCaseName"))
			{
				column=i;
				break;
			}
		}
		for(int i=0;i<numOfRows;++i)
		{
			XSSFRow row1 = sheet.getRow(i);
			if(row1.getCell(column).getStringCellValue().equalsIgnoreCase(TestCaseName))
			{
				for(int j=0;j<numOfCols;++j)
				{
					list.add(row1.getCell(j).getStringCellValue());
				}
				break;
			}
			
		}*/
		
		
		// Method 2
		/* Getting Cells and storing in List and Map
		ArrayList<String> tcName = new ArrayList<>();
		for(int i=0;i<numOfRows;++i)
		{
			tcName.add(sheet.getRow(i).getCell(0).getStringCellValue());
		}
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for(int i=1;i<numOfRows;++i)
		{
			XSSFRow row = sheet.getRow(i);
			ArrayList<String> list = new ArrayList<>();
			for(int j=1;j<row.getPhysicalNumberOfCells();++j)
			{
				list.add(row.getCell(j).getStringCellValue());
			}
			map.put(row.getCell(0).getStringCellValue(), list);
		}
		System.out.println(tcName);
		System.out.println(map);
		*/
		
		//Method 3 
		//Using Iterator
		
		Iterator<Row> rows = sheet.iterator();  	// Its return type is <Row>
		Row row = rows.next();						// It will return a Row
		Iterator<Cell> cell = row.iterator(); 		// Can also use CellIterator() or iterator() 
													// It will Return a Cell
		int k=0;
		int column=0;
		while(cell.hasNext())					
		{
			Cell value = cell.next();				// Its return type is Cell
			if(value.getStringCellValue().equals("TestCaseName"))
			{
				column=k;
				break;
			}
			k++;
			
		}
		System.out.println(column);	
		
		while(rows.hasNext()) {
			Row row1 = rows.next();
			if(row1.getCell(column).getStringCellValue().equalsIgnoreCase(TestCaseName)) {
				Iterator<Cell> cell1=row1.iterator();
				while(cell1.hasNext())
				{
					Cell value = cell1.next();
					if(value.getCellType()==CellType.STRING)
					{
						//System.out.println("String");
						list.add(value.getStringCellValue());
					}
					else if(value.getCellType()==CellType.NUMERIC)
					{
						//System.out.println("Num");
						list.add(NumberToTextConverter.toText(value.getNumericCellValue()));
					}
					else {
						//System.out.println("Date");
						list.add(value.getLocalDateTimeCellValue().toString());
					}
					
				}
				break;
			}
		}
		
		return list;
	}


}
