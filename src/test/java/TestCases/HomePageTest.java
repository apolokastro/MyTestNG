package TestCases;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.*;
import Logger.Log;

public class HomePageTest extends TestBase {

	HomePage homePage = new HomePage();
	
	private static Logger logger = LogManager.getLogger(HomePageTest.class);

	@Test(groups = {"Regression"})
	public void fTest() throws Exception {
		try {
			Log.info("=========== Start Test =========", true, logger);
			getURL();
			homePage.clickCloseBannerButton();
			Log.success("Step passed", true, logger);
			homePage.clickAccountButton();
			Log.success("Step passed", true, logger);
			homePage.clickLoginButton();
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
