package Listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import Reports.ExtentReport;
import utils.Common;


public class ExtentListeners implements ISuiteListener {
	
	long startTime;
	long endTime;
	
	public void onFinish(ISuite suite) {
		endTime = System.currentTimeMillis();
		long diff = (endTime - startTime);
		ExtentReport.flushReports(Common.getDurationBreakdown(diff));
	}
	
	public void onStart(ISuite suite) {
		try {
			String suiteName = suite.getName();
			startTime = System.currentTimeMillis();
			ExtentReport.initReports(suiteName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("onStart function started "  + suite.getName());
	}
}
