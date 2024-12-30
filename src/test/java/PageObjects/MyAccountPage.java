package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement clickLogout;
	
	public boolean Myaccountmsg() {
		
			
		return(msgHeading.isDisplayed());
		
	
	}
		
		public void clicklogout() {
			//clickLogout.click();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",clickLogout );
		}
	



	}

