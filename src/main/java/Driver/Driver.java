package Driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.TestFileReader;

public class Driver {

	public static void initDriver(String browser, String env) {
		
		WebDriver driver = null;
		
		if (Objects.isNull(driver)) {
			String environment = null;
			
			try {
				environment = TestFileReader.getProperty("platform");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			switch (environment) {
			case "local":
				initializeDriverOnLocal(browser, driver);
				break;

			default:
				break;
			}
		}
		
	}
	
	public static void initializeDriverOnLocal(String browser, WebDriver driver) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				DriverManager.setDriver(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
