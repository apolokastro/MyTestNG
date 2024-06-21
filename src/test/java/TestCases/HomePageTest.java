package TestCases;

import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.*;
import utils.DataTestProvider;
import Logger.Log;

public class HomePageTest extends TestBase {

	HomePage homePage = new HomePage();
	
	private static Logger logger = LogManager.getLogger(HomePageTest.class);

	@Test(groups = {"Regression"}, dataProvider = "getTestData", dataProviderClass = DataTestProvider.class)
	public void fTest(HashMap<String, String> dataMap) throws Exception {
		try {
			StringBuilder testData = new StringBuilder();
			Log.info("=========== Start Test =========", true, logger);
			Log.info("TestName: " + dataMap.get("TestName"), false, logger);
			for (Map.Entry<String, String> entry : dataMap.entrySet()) {
				if (!entry.getKey().equalsIgnoreCase("TestName")) {
					testData.append(entry.getKey() + "=" + entry.getValue());
					testData.append(", ");
				}
				
			}
			Log.info("=========== Test Data =========", true, logger);
			Log.info(String.valueOf(testData), true, logger);
			Log.info("===============================", true, logger);
			
			getURL();
			homePage.clickCloseBannerButton();
			Log.success("Step passed", true, logger);
			homePage.clickAccountButton();
			Log.success("Step passed", true, logger);
			homePage.clickLoginButton();
			System.out.println(dataMap.get("val1"));
			System.out.println(dataMap.get("val2"));
			Thread.sleep(1000);
			Log.success("Step passed", true, logger);
			Log.info("=========== End Test =========", true, logger);
		} catch (Exception e) {
			Log.error("Test Failed...", true, logger);
			Log.error(e.getMessage() + e.getCause(), true, logger);
			Assert.fail(e.getMessage(), e.getCause());
		}
	}
}
