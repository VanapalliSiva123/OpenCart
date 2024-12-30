package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBases.BaseClass;
import Utilities.DataProviders;

public class Tc_LoginDataDrivenTest extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void VerifyDDT(String email,String pwd,String exp) {
	try {	
	logger.info("Starting the DDT test case");
	HomePage h1=new HomePage(driver);
	h1.clickMyaccount();
	h1.clickLogin();
	
	logger.info("Entering the Login details");
	
	LoginPage l1=new LoginPage(driver);
	l1.setemail(email);
	l1.setpassword(pwd);
	l1.setbtnlogin();
	
	logger.info("Starting the My account is dispalyed");
	
	MyAccountPage m1=new MyAccountPage(driver);
	boolean displayed=m1.Myaccountmsg();
	
	//data is valid - login sucess - testpass- logout
	//                login failed - test fail
	
	//Data is invalid -login sucess -testfail-logout
	//                 login failed - test pass
	
	if(exp.equalsIgnoreCase("Valid")) {
		
		if(displayed==true) {
			
			m1.clicklogout();
			Assert.assertTrue(true);
			
			
		}else {
			Assert.assertTrue(false);
		}
		
	}
if(exp.equalsIgnoreCase("Invalid")) {
		
		if(displayed==true) {
			
			m1.clicklogout();
			Assert.assertTrue(false);
			
			
		}else {
			Assert.assertTrue(true);
		}
}
	}
		catch(Exception e){
			Assert.fail();
		}
		logger.info("Finished the ddt TestCase is sucessful");	
		}
	

}

