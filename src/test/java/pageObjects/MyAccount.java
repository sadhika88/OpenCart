package pageObjects;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyAccount extends BasePage{
	public Logger logger;
	public  MyAccount(WebDriver sadhika) {
		// TODO Auto-generated constructor stub
	
		super(sadhika);
		
		
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']") //my account page heading
	WebElement msgheading;
@FindBy(linkText = "Logout")
WebElement logoutElement;
	
	
	public boolean isMyAccoutPageExists() {
		try {
			return(msgheading.isDisplayed());
		}catch (Exception e) {
			return false;
			
		}
		
		
	}
	public void  clickLogout() {
		JavascriptExecutor js=(JavascriptExecutor)sadhika;
		js.executeScript("arguments[0].click();", logoutElement);
	//logoutElement.click();
		 
		
    }
	}

