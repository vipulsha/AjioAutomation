package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserHomePage;
import tests.commons.ParentTest;

public class TC_01_SignInTest extends ParentTest {
	@Test
	public void signInTest() {
		HomePage homePage = new HomePage(driver);
		homePage.clickSignInLink();
		homePage.signIn("vipul@mailinator.com", "test@123");
		UserHomePage userHomePage = new UserHomePage(driver);
		String welComeMessage = userHomePage.getWelComeMessage();
		String userName = "Vipul";
		Assert.assertTrue(welComeMessage.contains(userName), "Failed: User is not logged in");
	}
}
