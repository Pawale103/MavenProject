package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
	public WebDriver driver;
	Actions act;
	
	public HomePage(WebDriver driver)throws IOException
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		act=new Actions(driver);
		
	}
	
	@FindBy(xpath="(//div[@class='_1psGvi _3BvnxG'])[1]")
	private WebElement profileDropdown;
	
	@FindBy(xpath="//*[text()='Logout']")
	private WebElement logoutButton;
	
	public void logout()
	{
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		act.moveToElement(profileDropdown).build().perform();
		act.moveToElement(logoutButton).click().build().perform();
	}
	

}
