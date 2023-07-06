package Base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.Driver;

public class PageBase {
	
	protected void moveToElementAndClick(By by) {
		WebElement element = explicitlyWaitForTheElementToBePresented(by);
		Actions actions = new Actions(Driver.driver);
		actions.moveToElement(element).click().build().perform();
	}

	private WebElement explicitlyWaitForTheElementToBePresented(By by) {
		return (new WebDriverWait(Driver.driver, Duration.ofSeconds(50))).until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	

}
