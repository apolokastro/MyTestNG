package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import Base.PageBase;

public class HomePage extends PageBase{
	private static Logger logger = LogManager.getLogger(HomePage.class);
	
	By closeBannerButton = By.xpath("//button[@aria-label='Close Welcome Banner']");
	By menuButton = By.xpath("//mat-icon[text()='menu']");
	
	By accountButton = By.xpath("//button[@aria-label='Show/hide account menu']");
	By loginButton = By.xpath("//button[@aria-label='Go to login page']");
	
	By emailField = By.xpath("//input[@id='email']");
	By psddwordField = By.xpath("//input[@id='password']");
	
	public void clickCloseBannerButton() {
		moveToElementAndClick(closeBannerButton);
	}
	
	public void clickMenuButton(){
		moveToElementAndClick(menuButton);
	}
	
	public void clickAccountButton(){
		moveToElementAndClick(accountButton);
	}
	
	public void clickLoginButton(){
		moveToElementAndClick(loginButton);
	}
	
}
