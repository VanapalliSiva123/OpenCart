package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage {
	
	public AccountRegisterPage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstname;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastname;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//input[@id='input-newsletter']")
WebElement chkSubscribe;

@FindBy(xpath="//input[@name='agree']")
WebElement chkPrivacypolicy;

@FindBy(xpath="//button[normalize-space()='Continue']")
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

public void setFirstname(String fname) {
	txtFirstname.sendKeys(fname);
}
public void setLastname(String lname) {
	txtLastname.sendKeys(lname);
}
public void setEmail(String email) {
	txtEmail.sendKeys(email);
}
public void setPassword(String pass) {
	txtPassword.sendKeys(pass);
}
public void setSubscribe() {
	//chkSubscribe.click();
	//chkSubscribe.submit();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",chkSubscribe );
}
public void setprivacybox() {
	//chkPrivacypolicy.click();
	//chkPrivacypolicy.submit();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",chkPrivacypolicy );
}
public void clickContinue() {
	//btnContinue.click();
	
	//btnContinue.submit();
	
	//Actions act = new Actions(driver);
	//act.moveToElement(btnContinue).click().perform();
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", btnContinue);
	
	
	
	
}
public String getconfrimationmsg() {
	try {
		return(msgConfirmation.getText());
	}catch(Exception e) {
		return(e.getMessage());
	}
	
}
}

