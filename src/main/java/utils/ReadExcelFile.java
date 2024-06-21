package utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static List<HashMap<String, String>> getExcelData(String sheetName, String testDataPath) {
		List<HashMap<String, String>> testData = null;
		HashMap<String, String> rowMap;
		
		try (FileInputStream fs = new FileInputStream(testDataPath)) {
			
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowNum = sheet.getLastRowNum();
			int colNum = sheet.getRow(0).getLastCellNum();
			
			testData = new ArrayList<>();
			for (int row = 1; row <= rowNum; row++) {
				rowMap = new HashMap<>();
				for (int col = 0; col < colNum; col++) {
						String key = sheet.getRow(0).getCell(col).toString();
						String value = sheet.getRow(row).getCell(col).toString();
						rowMap.put(key, value);
				}
				testData.add(rowMap);
			}
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return testData;
	}

	

}
