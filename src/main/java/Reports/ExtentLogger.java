package Reports;

import com.aventstack.extentreports.Status;

public class ExtentLogger {
	public static void pass(String passMsg) {
		ExtentTestManager.getExtentTest().pass(passMsg);
	}
	
	public static void fail(String passMsg) {
		ExtentTestManager.getExtentTest().fail(passMsg);
	}
	
	public static void fail(Throwable t) {
		ExtentTestManager.getExtentTest().fail(t);
	}
	
	public static void skip(String msg) {
		ExtentTestManager.getExtentTest().skip(msg);
	}
	
	public static void info(String msg) {
		ExtentTestManager.getExtentTest().info(msg);
	}
	
	public static void log(Status status, String msg) {
		ExtentTestManager.getExtentTest().log(status, msg);
	}
}
