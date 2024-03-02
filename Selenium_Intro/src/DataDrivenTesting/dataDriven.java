package DataDrivenTesting;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataDriven {
	
	@Test(dataProvider="getExcelData")
	public void testDataDriven(String tcName, String data1, String data2, String data3, String data4) {
		
		System.out.println(tcName+data1+data2+data3+data4);
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException {
		
		String filePath = System.getProperty("user.dir")+"\\ExcelData\\TestData.xlsx";
		String sheetName = "TestSheet1";
		
		getDataFromExcel obj = new getDataFromExcel();
		
		Object[][] data = obj.getData(filePath,sheetName);
		return data;
	}

}
