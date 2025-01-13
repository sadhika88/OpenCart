package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver sadhika;
	public LoginPage(WebDriver sadhika) {
		this.sadhika=sadhika;
	}
	
	By txt_username_loc=By.xpath("//input[@placeholder='Username']");
	By txt_password_loc=By.xpath("//input[@placeholder='Password']");
	By Login_loc=By.xpath("//button[normalize-space()='Login']");
public void setUserName(String user) {
	sadhika.findElement(txt_username_loc).sendKeys(user);
}
public void setPassword(String pwd) {
	sadhika.findElement(txt_password_loc).sendKeys(pwd);
}
public void setLogin() {
	sadhika.findElement(Login_loc).click();;
}
}
