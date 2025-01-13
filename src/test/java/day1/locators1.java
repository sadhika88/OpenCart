package day1;

import java.time.Duration;

import javax.swing.text.Highlighter.Highlight;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators1 {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://github.com/login");
	Thread.sleep(2000);
	highlight(driver,driver.findElement(By.id("login_field")));
	Thread.sleep(2000);
	highlight(driver,driver.findElement(By.name("password")));
	Thread.sleep(2000);
	highlight(driver, driver.findElement(By.className("header-logo")));
	Thread.sleep(2000);
	highlight(driver, driver.findElement(By.linkText("Forgot password?")));
	Thread.sleep(2000);
	highlight(driver, driver.findElement(By.partialLinkText("Create an")));
	Thread.sleep(2000);
	highlight(driver, driver.findElement(By.tagName("div")));
	Thread.sleep(2000);
	highlight(driver, driver.findElement(By.xpath("//label[contains(text(),'Username or email address')]")));
	highlight(driver, driver.findElement(By.cssSelector("input[name='commit']")));
	
	
	
	
	
	
	
	
	//driver.close();
	
}

private static void highlight(WebDriver driver,WebElement element) {
JavascriptExecutor js=(JavascriptExecutor)driver;

 js.executeScript("arguments[0].setAttribute('style','border:2px solid red; background:yellow')",element);
	
}
}
