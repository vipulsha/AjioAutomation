package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;
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
		homePage.signIn(getData("emailId"), getData("password"));
		userHomePage = new UserHomePage(driver);
		String welComeMessage = userHomePage.getWelComeMessage();
		String userName = getData("userName");
		Assert.assertTrue(welComeMessage.contains(userName), "Failed: User is not logged in");
	}

	@Test
	public void verifyAddingAddress() {
		ATUReports.setAuthorInfo("Pallavi", Utils.getCurrentTime(),"1.0");
		userHomePage.clickMyAccountLink();
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		myAccountPage.clickAddressBook();
		myAccountPage.clickAddAddressLink();
		
		String firstName = getData("firstName");
		String lastName = getData("lastName");
		String addressLine1 = getData("addressLine1");
		String state = getData("state");
		String district = getData("district");
		String phoneNo = getData("phoneNo");
		String pinCode = getData("pinCode");
		
		myAccountPage.enterFirstName(firstName);
		myAccountPage.enterLastName(lastName);
		myAccountPage.enterAddressLine1(addressLine1);
		myAccountPage.enterState(state);
		myAccountPage.enterDistrict(district);
		myAccountPage.enterPhoneNo(phoneNo);
		myAccountPage.enterPinCode(pinCode);
		myAccountPage.clickSaveButton();
		Assert.assertTrue(myAccountPage.isAddressPresent(firstName, lastName, addressLine1, pinCode, district, state), "Failed: Address not present.");
	}
}
