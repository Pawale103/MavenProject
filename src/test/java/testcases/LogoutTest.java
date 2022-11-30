package testcases;

import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
	
	@Test
	public void logoutTest() throws InterruptedException
	{
		lp.login();
		Thread.sleep(2000);
		hp.logout();
	}

}
