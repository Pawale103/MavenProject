package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.LoginPage;

public class BaseTest {
	public static WebDriver driver;
	Properties prop;
	LoginPage lp;
	HomePage hp;
	
	
	public void initDriver() throws IOException
	
	{
		prop= new Properties();
		String filepath=System.getProperty("user.dir")+"\\Config.properties";
		FileInputStream fis= new FileInputStream(filepath);
		prop.load(fis);
		
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options= new ChromeOptions();
//			options.setHeadless(true);
//			options.addArguments("--headless");
//			options.addArguments("--disable-notification");
//			options.addArguments("--incognito");
			options.addArguments("--start-maximized");
			
			driver=new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			EdgeOptions options= new EdgeOptions();
//			options.addArguments("--headless");
//			options.addArguments("--disable-notification");
			options.addArguments("--start-maximized");
			
			driver= new EdgeDriver(options);
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();			
		}
		else
		{
			System.out.println("Given browser is not used in our Automation Script");
		}
		
		driver.navigate().to(prop.getProperty("url"));
	}
	 @BeforeClass
	 public void objectCreation() throws IOException
	 {
		 initDriver();
		 lp= new LoginPage(driver);
		 hp= new HomePage(driver);
	 }
	 
	 @AfterSuite
	 public void tearDown()
	 {
		// driver.close();
	 }
	

}
