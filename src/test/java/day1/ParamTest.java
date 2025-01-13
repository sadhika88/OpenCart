package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class ParamTest {
	WebDriver sadhika;
	@BeforeClass
	@Parameters({"browser"})
	void setup(String br) throws InterruptedException {
		switch (br.toLowerCase()) {
		case "chrome":	sadhika=new ChromeDriver();break;
		case "edge":	sadhika=new EdgeDriver();break;
		case "firefox":	sadhika=new FirefoxDriver();break;
        default:System.out.println("invalid brower");return;//return keyword completely exit from the test /entire method
			//break;
		}
	sadhika.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		sadhika.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		sadhika.manage().window().maximize();
		Thread.sleep(5000);
		}@Test(priority = 1)
	void testlogo() {
		boolean status=sadhika.findElement(By.xpath(" //img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
		}@Test(priority = 2)
	void testTitle() {
		Assert.assertEquals(sadhika.getTitle(), "OrangeHRM");
	
	}@Test(priority = 3)
	void testURL() {
		Assert.assertEquals(sadhika.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		}@AfterClass
	void tearDown() {
		sadhika.quit();
	}

}
