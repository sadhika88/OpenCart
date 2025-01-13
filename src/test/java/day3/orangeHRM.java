package day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//@Listeners(day3.MyListener.class)
public class orangeHRM {
	WebDriver sadhika;
@BeforeClass
	void setup( ) throws InterruptedException {
		sadhika=new ChromeDriver();
	sadhika.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		sadhika.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		sadhika.manage().window().maximize();
		Thread.sleep(5000);
		}@Test(priority = 1)
	void testlogo() throws InterruptedException {
		boolean status=sadhika.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
		sadhika.manage().window().maximize();
		Thread.sleep(3000);
		}
		@Test(priority = 3,dependsOnMethods = {"testURL"})
	void testTitle() {
		Assert.assertEquals(sadhika.getTitle(), "OrangeHRM");
	
	}
		@Test(priority = 2)
	void testURL() {
		Assert.assertEquals(sadhika.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/");
		}@AfterClass
	void tearDown() {
		sadhika.quit();
	}
}
