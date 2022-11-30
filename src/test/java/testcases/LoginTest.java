package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	
	
	@Test
	public void loginTestMethod() throws InterruptedException
	{
		lp.login();
		String title=driver.getTitle();
		System.out.println(title);
		if(title.contains("Online Shopping Site"))
		{
			System.out.println("Test case passed");
		}
		else
		{
		Assert.fail();
		}
	}

}
