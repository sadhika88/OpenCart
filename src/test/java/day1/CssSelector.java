package day1;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelector {
	static Month convertMonth(String month) {
		HashMap<String, Month> monthMap=new HashMap<String, Month>();
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September",Month.SEPTEMBER);
		monthMap.put("October",Month.OCTOBER);
		monthMap.put("November",Month.NOVEMBER);
		monthMap.put("December",Month.DECEMBER);
		Month vmonth=monthMap.get(month);
		if(vmonth==null) {
			System.out.println("Invaid Month.....");
		}
		return vmonth;
		
	}
	static void selectFutureDate(WebDriver sadhika,String year,String month,String date) {
		 
		  while(true) {
			   String currentmonth=sadhika.findElement(By.xpath(" //span[@class='ui-datepicker-month']")).getText();
			   String currentyear=sadhika.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			  // String currentdate=sadhika.findElement(By.xpath("//span[@class='ui-datepicker-day']")).getText();
			   if(currentmonth.equals(month)&&currentyear.equals(year)) {
				   break;
			   }
			 sadhika.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			 //sadhika.findElement(By.xpath(" //span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		   }
		  List <WebElement> data=sadhika.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
			 for(WebElement op:data) {
				if(op.getText().equals(date)){
					op.click();
					break;
				}
			 }
	}
	static void Pastdate(WebDriver sadhika,String year,String month,String date) {
		 
		  while(true) {
			   String currentmonth=sadhika.findElement(By.xpath(" //span[@class='ui-datepicker-month']")).getText();
			   String currentyear=sadhika.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			  // String currentdate=sadhika.findElement(By.xpath("//span[@class='ui-datepicker-day']")).getText();
			   if(currentmonth.equals(month)&&currentyear.equals(year)) {
				   break;
			   }
			 //sadhika.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			 sadhika.findElement(By.xpath(" //span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		   }
		  List <WebElement> data=sadhika.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
			 for(WebElement op:data) {
				if(op.getText().equals(date)){
					op.click();
					break;
				}
			 }
	}
	

	public static void main(String[] args) throws InterruptedException  {
		WebDriver sadhika=new ChromeDriver();
	sadhika.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//WebDriverWait mywait=new WebDriverWait(sadhika, Duration.ofSeconds(10));
		  
	//sadhika.get("https://the-internet.herokuapp.com/basic_auth");
	
	        //sadhika.get("https://www.hyrtutorials.com/");
    sadhika.get("https://jqueryui.com/datepicker/");
    sadhika.manage().window().maximize();
    sadhika.switchTo().frame(0);
   /* sadhika.findElement(By.xpath(" //input[@id='datepicker']")).sendKeys("12/23/2024");*/
  
   /* String year="2026";
    String month="December";
    String date="23";*/
    sadhika.findElement(By.xpath("//input[@id='datepicker']")).click();
   //selectFutureDate(sadhika, "2025", "September", "25");
   Pastdate(sadhika, "1994", "September", "25");
  
 
 
 
  
   

  
	}
}





	
	
	
	
	
	
	
	
	

	
	

	
	
	
	


	
	


