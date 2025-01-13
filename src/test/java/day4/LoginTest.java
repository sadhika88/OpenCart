package day4;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver sadhika;
	@BeforeClass
	void setup() {
		sadhika=new ChromeDriver();
		sadhika.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		sadhika.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		sadhika.manage().window().maximize();
	}@Test
	void testLogin() {
		LoginPage2 l=new  LoginPage2(sadhika);
		l.setUserName("Admin");
		l.setPassword("admin123");
		l.setLogin();
		Assert.assertEquals(sadhika.getTitle(), "OrangeHRM");
		
	}
	@AfterClass
	void teardown() {
		sadhika.quit();
	}

}
