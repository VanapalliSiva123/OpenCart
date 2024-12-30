package TestCases;

import org.testng.annotations.Test;

import PageObjects.AccountRegisterPage;
import PageObjects.HomePage;
import TestBases.BaseClass;
import junit.framework.Assert;

public class Tc_VerifyAccountRegister extends BaseClass {
	
	

	@Test(groups= {"Sanity","Master"})
	public void verifyacoountregister() throws InterruptedException {
		logger.info("***Starting the log content");
		try {
		HomePage h1 = new HomePage(driver);
		logger.info("This is the click my account");
		h1.clickMyaccount();
		logger.info("This is the register clicking");
		h1.clickRegister();
		
		logger.info("****Starting the AccountRegister page****");
		
		
		AccountRegisterPage regpage = new AccountRegisterPage(driver);
		logger.info("This is the all register details");
		regpage.setFirstname(randomeString().toUpperCase());
		regpage.setLastname(randomeString().toLowerCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setPassword(randomeAlphaNumeric());
		regpage.setSubscribe();
	    regpage.setprivacybox();
		regpage.clickContinue();
		//regpage.getconfrimationmsg();
		String conmsg=regpage.getconfrimationmsg();
		Assert.assertEquals(conmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
		
		logger.info("Finished the case sucessfully");
			}
	
	
		
	}








