package day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {
public static void main(String[] args) throws IOException, InterruptedException {
	WebDriver sadhika=new ChromeDriver();
	sadhika.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	sadhika.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
	sadhika.manage().window().maximize();
	String filepath=System.getProperty("user.dir") +"\\testData\\DataReal.xlsx";//getting location of file return current project location
	int rows=Excelutility.getRowCount(filepath,"Sheet1");
	for(int i=1;i<=rows;i++) {
		//read from xcel cell
		String principle=Excelutility.getCelldata(filepath, "Sheet1", i, 0);
		String Rateofinterest=Excelutility.getCelldata(filepath, "Sheet1", i, 1);
		String period1=Excelutility.getCelldata(filepath, "Sheet1", i, 2);
		String period2=Excelutility.getCelldata(filepath, "Sheet1", i, 3);
		String frequency=Excelutility.getCelldata(filepath, "Sheet1", i, 4);
		String exp_mvalue=Excelutility.getCelldata(filepath, "Sheet1", i, 5);
		
		//pass data above a condition
		sadhika.findElement(By.xpath(" //input[@id='principal']")).sendKeys(principle);
	sadhika.findElement(By.xpath("//input[@id='interest']")).sendKeys(Rateofinterest);
	sadhika.findElement(By.xpath(" //input[@id='tenure']")).sendKeys(period1);
	Select perdrp=new Select(sadhika.findElement(By.xpath(" //select[@id='tenurePeriod']")));
	perdrp.selectByVisibleText(period2);
	Select fredrp=new Select(sadhika.findElement(By.xpath("//select[@id='frequency']")));
	fredrp.selectByVisibleText(frequency);
	JavascriptExecutor js=(JavascriptExecutor)sadhika;
	WebElement calc=sadhika.findElement(By.xpath( " //div[@class='cal_div']//a[1]"));//clicked on calculator button
	js.executeScript("arguments[0].click();", calc);
	
		//validation
	String act_mvalue=sadhika.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
	if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue)) {
		System.out.println("Test passed");
		Excelutility.setCellData(filepath, "Sheet1", i, 7, "Passed");
		Excelutility.fillGreenColor(filepath, "Sheet1", rows, 7);
	}else {
		System.out.println("Test failed");
		Excelutility.setCellData(filepath, "Sheet1", i, 7, "Failed");
		Excelutility.fillRedColor(filepath, "Sheet1", rows,7);
	}Thread.sleep(2000);
	JavascriptExecutor js1=(JavascriptExecutor)sadhika;
	WebElement clear=sadhika.findElement(By.xpath("//*[@class='PL5']"));//clicked on clear button
	js1.executeScript("arguments[0].click();", clear);
	}//ending for loop
	sadhika.quit();
}
}
