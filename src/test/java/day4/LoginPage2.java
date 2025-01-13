package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	WebDriver sadhika;
	public LoginPage2(WebDriver sadhika) {
		this.sadhika=sadhika;
		PageFactory.initElements(sadhika, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Username']") WebElement txt_username_loc;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement txt_password_loc;
	@FindBy(xpath="//button[@type='submit']") WebElement Login_loc;
	
public void setUserName(String user) {
	txt_username_loc.sendKeys(user);
}
public void setPassword(String pwd) {
	txt_password_loc.sendKeys(pwd);
}
public void setLogin() {
	Login_loc.click();;
}
}
