package Reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentTestManager {
	
	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();
	
	static ExtentTest getExtentTest() {
		return extTest.get();
	}
	
	public static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}
	
	public static void unload() {
		extTest.remove();
	} 

}
