package utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;


public final class DataTestProvider {
	
	private static List<HashMap<String,String>> dataList = new ArrayList<>();
	
	@DataProvider
	public static Object[] getTestData(Method methodName) {
		String testName = methodName.getName();
		String testClassName = methodName.getDeclaringClass().getSimpleName();
		String path = null;
		
		try {
			path = System.getProperty("user.dir") + TestFileReader.getProperty("testDataPath");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		dataList = ReadExcelFile.getExcelData(testClassName, path);
		List<HashMap<String,String>> testDataList = new ArrayList<>();
		for(HashMap<String,String> map : dataList) {
			if(map.get("TestName").equalsIgnoreCase(testName) && map.get("Automateble").equalsIgnoreCase("Yes")) {
				testDataList.add(map);
			}
		}

		return testDataList.toArray();
	}

}
