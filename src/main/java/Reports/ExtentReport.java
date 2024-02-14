package Reports;

import java.io.File;
import java.util.Objects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Driver.DriverManager;

import com.aventstack.extentreports.ExtentReports;

import utils.Common;

import utils.TestFileReader;


public class ExtentReport {
	static ExtentReports extent;
	static ExtentTest test;
	static String timestamp;
	
	//Este metodo inicia el reporte
	public static void initReports(String suiteName) throws Exception {
		
		//Aqui generamos la fecha actual desde la clase Common.java
		timestamp = Common.getCurrentDateTime();
		
		if (Objects.isNull(extent)) {
			String reportPath = "";
			
			//Aqui se valida que Suite se esta corriendo. Esto viene desde el Runner.XML que se esta usando
			if (suiteName.equals("Test-Suite")) {
				reportPath = System.getProperty("user.dir") + TestFileReader.getProperty("reportPath") + timestamp + ".html";
			}
			
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
			
			extent = new ExtentReports();
			extent.setSystemInfo("Environment", TestFileReader.getProperty("environment"));
			extent.setSystemInfo("Platform", TestFileReader.getProperty("platform"));
			extent.setSystemInfo("Tester", TestFileReader.getProperty("qaEngineer"));
			extent.attachReporter(reporter);
			reporter.config().setReportName(TestFileReader.getProperty("reportName"));
			reporter.config().setReportName(TestFileReader.getProperty("reportTitle"));
			reporter.config().setTheme(Theme.STANDARD);
			reporter.config().setEncoding(TestFileReader.getProperty("reportEncoding"));
		}
	}
	
	public static void createTest(String testName, String className, String[] groups, String browserName) {
		ExtentTestManager.setExtentTest(extent.createTest(className + " : " + testName));
	}
	
	public static void flushReports(String overallExecutionTime){
		extent.setSystemInfo("Total Execution Time", overallExecutionTime);
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
	}
	
	public static void attachScreenshotToReport(String testName) {
		ExtentTestManager.getExtentTest().addScreenCaptureFromPath(getScreenshotPath(testName), testName);
	}
	
	
	public static void reportFailedTest(String[] groups, String browserName) {
		ExtentTestManager.setExtentTest(ExtentTestManager.getExtentTest().assignCategory(groups).assignDevice(browserName));
	}
	
	public static void reportPassTest(String[] groups, String browserName) {
		ExtentTestManager.setExtentTest(ExtentTestManager.getExtentTest().assignCategory(groups).assignDevice(browserName));
	}
	
	public static void removeRetryTestFromReport() {
		extent.removeTest(ExtentTestManager.getExtentTest());
	}
	
	public static String getScreenshotPath(String testcasename) {
		try {
			TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destPath = System.getProperty("user.dir") + "\\extentReports\\" + testcasename + ".png";
			FileHandler.copy(source, new File(destPath));
			return destPath;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
