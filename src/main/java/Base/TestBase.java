package Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Driver.Driver;

public class TestBase {

	@Parameters({ "browser","env"})
	@BeforeMethod(groups = { "Regression"})
	public void setUp(String browser, String env) throws Exception {
		Driver.startDriver(browser, env);
		System.out.println("Driver Started...");
	}

	@AfterMethod(groups = { "Regression"})
	public void tearDown() {
		Driver.closeDriver();
		System.out.println("Driver Destroyed...");
	}
}
