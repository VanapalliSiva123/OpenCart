package TestCases;

import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBases.BaseClass;
import junit.framework.Assert;

public class Tc_verifyLoginPage extends BaseClass {

	@Test(groups= {"Regression","Master"})
	public void verifylogin() {
		
		logger.info("Starting the My account details");
		try {
		HomePage h1=new HomePage(driver);
		h1.clickMyaccount();
		h1.clickLogin();
		
		logger.info("Entering the Login details");
		
		LoginPage l1=new LoginPage(driver);
		l1.setemail(prop.getProperty("email"));
		l1.setpassword(prop.getProperty("password"));
		l1.setbtnlogin();
		
		logger.info("Starting the My account is dispalyed");
		
		MyAccountPage m1=new MyAccountPage(driver);
		boolean displayed=m1.Myaccountmsg();
		Assert.assertTrue(displayed);
		m1.clicklogout();
		
		
		
		
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("Finished the login test case");
	}
}
