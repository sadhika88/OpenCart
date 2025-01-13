package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver sadhika;
	public BasePage(WebDriver sadhika) {
		this.sadhika=sadhika;
		PageFactory.initElements(sadhika, this);
	}
	
}
