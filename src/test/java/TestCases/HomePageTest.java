package TestCases;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.*;

public class HomePageTest extends TestBase {
	
	private static Logger logger = LogManager.getLogger(HomePageTest.class);

	HomePage homePage = new HomePage();

	@Test(groups = {"Regression"})
	public void fTest() throws InterruptedException {
		homePage.clickCloseBannerButton();
		homePage.clickAccountButton();
		homePage.clickLoginButton();
		Thread.sleep(3000);
	}

	
}
