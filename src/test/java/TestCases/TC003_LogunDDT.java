package TestCases;


import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import Utilits.DataProviders;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
//import pageObjects.MyAccount;
public class TC003_LogunDDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups = "DataDriven")//getting data provider from different class
	public void verify_loginDDT(String email,String pwd,String exp) throws InterruptedException {
	
		  //boolean testResult = true; 
		//HomePage
logger.info("***** stating TC_003_LoginDDT ******");
		
		try
		{
		//HomePage
		HomePage hp=new HomePage(sadhika);
		hp.clickmyaccunt();
		hp.login();
		
		//Login
		LoginPage lp=new LoginPage(sadhika);
		lp.sentEmail(email.trim());
		lp.setPassword(pwd);
		lp.clicklogin();
			
		//MyAccount
		MyAccount macc=new MyAccount(sadhika);
		boolean targetPage=macc.isMyAccoutPageExists();
		
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{			
				macc.clickLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}catch(Exception e)
		{
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("***** Finished TC_003_LoginDDT ******");
		
        
	}
}

