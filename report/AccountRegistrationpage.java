package pageObjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AccountRegistrationpage extends Basepage {
public AccountRegistrationpage(WebDriver sadhika) {
		super(sadhika);
	
	}
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtfirstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtlastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemail;
//	@FindBy(xpath = "//input[@id='input-telephone']")
//	WebElement txttelephone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPolicy;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement txtContinue;
	@FindBy(xpath = "//a[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	public void setFirstname(String fname) {
		txtfirstname.sendKeys(fname);
	}
	public void setlastname(String lname) {
		txtlastname.sendKeys(lname);
	}
	public void setemail(String email) {
		txtemail.sendKeys(email);
	}
//	public void setTelephone(String tel) {
//		txttelephone.sendKeys(tel);
//	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
				
	public void setConfirmPassword(String pwd) {
	txtConfirmPassword.sendKeys(pwd);
	}
	public void setPrivacyPolicy() {
		JavascriptExecutor js=(JavascriptExecutor)sadhika;
		js.executeScript("arguments[0].click();",chkPolicy);	
	}
	public void clickContinue() {

		JavascriptExecutor js=(JavascriptExecutor)sadhika;
		js.executeScript("arguments[0].click();",txtContinue);	
	}
	public String getConfirmationPage() {
		try {
			return(msgConfirmation.getText());
		}catch(Exception e) {
			return e.getMessage();
		}
		
		
	}

}
