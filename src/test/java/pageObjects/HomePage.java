package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	public HomePage(WebDriver sadhika){
		super(sadhika);
		
		
	}
	@FindBy(xpath = "//span[normalize-space()='My Account']") 
	WebElement lnkMyaccount;
	@FindBy(xpath = "//a[normalize-space()='Register']") 
	WebElement lnkMyregister;
	@FindBy(linkText = "Login")//login link step 5
	WebElement linkLogin;
	public void clickmyaccunt() {
		lnkMyaccount.click();
	}
	public void clickmyreg() {
	lnkMyregister.click();
	}
	public void login() {
	JavascriptExecutor js=(JavascriptExecutor)sadhika;
	js.executeScript("arguments[0].click();", linkLogin);
	}
}
