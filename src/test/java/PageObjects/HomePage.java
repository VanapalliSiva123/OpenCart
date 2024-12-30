package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement Myaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement Login;
		
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement Myaccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/a/span")));
	    
		//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement Register = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[1]/a")));
		
		
		
	public void clickMyaccount() {
		Myaccount.click();
		
	}
	public void clickRegister() {
		Register.click();
		
	}
	
	public void clickLogin() {
		Login.click();
	}
	 	
	 	
		}