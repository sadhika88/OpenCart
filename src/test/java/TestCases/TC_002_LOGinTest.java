package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;


public class TC_002_LOGinTest extends BaseClass{
	@Test(groups = {"Sanity","Master"})
	public void verify_login() {
		logger.info("*****Starting TC002_Login********");
		try {
		//HomePage
		HomePage hp=new HomePage(sadhika);
		hp.clickmyaccunt();
		hp.login();
		//login
		LoginPage lp=new LoginPage(sadhika);
		lp.sentEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clicklogin();
		//My Account
		MyAccount ac=new MyAccount(sadhika);
		//ac.isMyAccoutPageExists();
		boolean targetpage=	ac.isMyAccoutPageExists();
	//	Assert.assertEquals(targetpage, true,"Login failed");
		Assert.assertTrue(targetpage);
		}catch (Exception e) {
			Assert.fail();
		}
		logger.info("***** Finished  TC002_Login********");
		
	}
}
