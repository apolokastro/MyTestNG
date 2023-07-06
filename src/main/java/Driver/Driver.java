package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import utils.TestFileReader;

public class Driver {
	public static WebDriver driver;

	public static void startDriver(String browser, String env) throws Exception {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}

		if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "src\\test\\resources\\msedgedriver.exe");
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.get(TestFileReader.getProperty(env.toLowerCase()+"url"));
	}

	public static void closeDriver() {
		driver.quit();
	}

}
