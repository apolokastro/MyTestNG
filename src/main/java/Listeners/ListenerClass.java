package Listeners;

import org.apache.logging.log4j.ThreadContext;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Reports.ExtentLogger;
import Reports.ExtentReport;

public class ListenerClass implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getThrowable());
		try {
			String browserName = result.getTestContext().getCurrentXmlTest().getParameter("browser");
			ExtentReport.reportFailedTest(result.getMethod().getGroups(), browserName);
			ExtentReport.attachScreenshotToReport(result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestStart(ITestResult result) {

		try {
			String className = result.getTestClass().getRealClass().getSimpleName();
			String testName = result.getMethod().getMethodName();
			String browserName = result.getTestContext().getCurrentXmlTest().getParameter("browser");
			ExtentReport.createTest(testName, className, result.getMethod().getGroups(), browserName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		String browserName = result.getTestContext().getCurrentXmlTest().getParameter("browser");
		ExtentReport.reportPassTest(result.getMethod().getGroups(), browserName);
		ExtentLogger.pass(result.getMethod().getMethodName() + " : SUCCESS");
	}
	
	@Override
	public void onStart(ITestContext context) {
		try {
			ThreadContext.put("threadName", context.getCurrentXmlTest().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			if (result.wasRetried()) {
				ExtentReport.removeRetryTestFromReport();
			}
			
			ExtentLogger.skip(result.getMethod().getMethodName() + " : Skipped");
		}
	}
}
