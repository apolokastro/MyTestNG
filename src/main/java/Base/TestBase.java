package Base;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Driver.Driver;
import Driver.DriverManager;
import utils.TestFileReader;

public class TestBase {

	@Parameters("browser")
	@BeforeMethod(groups = { "Regression"})
	public void setUp(String browser, Method method) throws Exception {
		Driver.initDriver(browser, method.getName());
		System.out.println("Driver Started..." + method);
	}
	
	public void initiateBrowser(String browser, String methodName) {
		Driver.initDriver(browser, methodName);
	}
	
	protected void getURL() throws Exception {
		DriverManager.getDriver().get(TestFileReader.getProperty("qaurl"));
		
	}

	@AfterMethod(groups = { "Regression"})
	public void tearDown() {
		Driver.quitDriver();
		System.out.println("Driver Destroyed...");
	}
}
