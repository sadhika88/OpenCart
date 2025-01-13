package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;


public class TC001_AccountRegistration extends BaseClass {
	
@Test(groups = {"Regrission","Master"})
public void verify_account_registration() {
	logger.info("**********TC001_AccountregistrationAccount***************");
	logger.debug("This is a debug log message");
	try {
	HomePage hp=new HomePage(sadhika);
	hp.clickmyaccunt();
	logger.info("**********Cliked on My Account link***************");
	hp.clickmyreg();
	logger.info("**********Clicked on Register link***************");
	AccountRegistration regpage=new AccountRegistration(sadhika);
	logger.info("**********Providing Customer details***************");
	regpage.setFirstname(randomString().toUpperCase());
	regpage.setlastname(randomString().toUpperCase());
	regpage.setemail(randomString()+"@gmail.com");//randomly generated the email
	regpage.setTelephone(randomNumber());
String password=AlphaNumeric();
	regpage.setPassword(password);//direct enter alphanumeric method password changing every time nothing but first static
	//remaining   changing so declare password it is fixed once


	regpage.setConfirmPassword(password);
	regpage.setPrivacyPolicy();
	regpage.clickContinue();
	logger.info("Validating expacted message.......");
	String confmsg=regpage.getConfirmationPage();
	
	Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");

	logger.info("Test passed");
	} 
	catch (Exception e)
	{
		logger.error("Test failed: " + e.getMessage());
		Assert.fail("Test failed: " + e.getMessage());
	} 
	finally 
	{
	logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}
}

}

