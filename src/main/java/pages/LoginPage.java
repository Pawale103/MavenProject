package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass  {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) throws IOException
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@href='/account/login?ret=/']")
	private WebElement loginLink;
	
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
	private WebElement username;
	
	@FindBy(xpath="//input[@class='_2IX_2- _3mctLh VJZDxU']")
	private WebElement password;

	@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL' and @type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement cancelButton;
	
	public void login() throws InterruptedException
	{
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginButton.click();
		
		
	}
	
	
	

}
