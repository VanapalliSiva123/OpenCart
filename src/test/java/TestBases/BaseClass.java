package TestBases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties prop;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws InterruptedException, IOException {
		
		//Loading the config properties -- same data will loaded
		
		FileReader file = new FileReader("./src//test//resource//config.properties");
		prop=new Properties();
		prop.load(file);
		
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Chromedriver\\chromedriver-win64\\chromedriver.exe");
		logger=LogManager.getLogger(this.getClass());
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities=new DesiredCapabilities();
			if(os.equalsIgnoreCase("Windows")) {
				capabilities.setPlatform(Platform.WIN10);	
			}else if(os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			
			}else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}else {
				System.out.println("No matching os");
				return;
			}
			
			switch(br.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome");break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
			default:System.out.println("No matching browser");
			
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
	 
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {
			
		switch(br.toLowerCase()) {
		
		case "chrome" :driver= new ChromeDriver();
		break;
		case "	Edge" :driver= new EdgeDriver();
		break;
		default :System.out.println("Invalid Browser");
		return;
		}
		}
		
		
		
		//driver=new ChromeDriver();   @alredy write a chrome instance..
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		
		driver.get(prop.getProperty("current_url"));
		driver.manage().window().maximize();
		//Thread.sleep(10000);
		
		}
	
	

		
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void teardown() {
	driver.quit();
		
	}
	public String randomeString() throws InterruptedException {
		String generatedstring=RandomStringUtils.randomAlphabetic(4);
		//Thread.sleep(50000);
		return generatedstring;
			
		}
		
		public String randomeNumber() {
			String generatednumber=RandomStringUtils.randomAlphanumeric(5);
		return generatednumber;
		}
			
		public String randomeAlphaNumeric() {
			String generatedstring = RandomStringUtils.randomAlphabetic(4);
			String generatednumber = RandomStringUtils.randomNumeric(5);
		return(generatedstring+"@"+generatednumber);
			
		}
		
	/*	public String captureScreen(String tname) throws IOException {
			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

			
			String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile = new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
			
			return targetFilePath ;
		
		
		/*public String captureScreenshot(String testName) {
		    if (driver == null) {
		        System.err.println("WebDriver is not initialized!");
		        return null;
		    }
		    try {
		        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";
		        FileUtils.copyFile(srcFile, new File(screenshotPath));
		        return screenshotPath;
		    } catch (Exception e) {
		        System.err.println("Error capturing screenshot: " + e.getMessage());
		        return null;
		    }*/
		}
		


		

