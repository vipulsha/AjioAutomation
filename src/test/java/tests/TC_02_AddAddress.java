package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.MyAccountPage;
import pages.UserHomePage;
import tests.commons.ParentTest;

public class TC_02_AddAddress extends ParentTest {
	HomePage homePage = null;
	UserHomePage userHomePage = null;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage(driver);
		homePage.signIn("vipul@mailinator.com", "test@123");
		userHomePage = new UserHomePage(driver);
		String welComeMessage = userHomePage.getWelComeMessage();
		String userName = "Vipul";
		Assert.assertTrue(welComeMessage.contains(userName), "Failed: User is not logged in");
	}

	@Test
	public void verifyAddingAddress() {
		userHomePage.clickMyAccountLink();
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		myAccountPage.clickAddressBook();
		myAccountPage.clickAddAddressLink();
		myAccountPage.enterFirstName("Vipul");
		myAccountPage.enterLastName("Sharma");
		myAccountPage.enterAddressLine1("Wagholi");
		myAccountPage.enterState("Maharashtra");
		myAccountPage.enterDistrict("Pune");
		myAccountPage.enterPhoneNo("9404560059");
		myAccountPage.selectWorkAddress();
		myAccountPage.enterPinCode("411014");
		myAccountPage.clickSaveButton();
		Assert.assertTrue(myAccountPage.isAddressPresent("Vipul", "Sharma", "Wagholi", "411014", "Pune", "Maharashtra", "Work"), "Failed: Address not present.");
	}
}
