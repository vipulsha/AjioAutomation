package tests;

import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;
import pages.CategoryHomePage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchResultsPage;
import pages.ShoppingBagPage;
import tests.commons.ParentTest;

public class TC_03_CheckoutProductWithoutLogin extends ParentTest {
	
	@Test
	public void verifyProductCheckoutWithoutLogin() {
		ATUReports.setAuthorInfo("Santosh", Utils.getCurrentTime(),"1.0");
		HomePage homePage = new HomePage(driver);
		CategoryHomePage categoryHomePage = homePage.clickOnCategory(getData("category"));
		SearchResultsPage searchResultsPage = categoryHomePage.searchProduct(getData("searchCriteria"));
//		ProductDetailsPage productDetailsPage = searchResultsPage.clickOnProduct("Denim Jeans with Frayed Hems");
		ProductDetailsPage productDetailsPage = searchResultsPage.clickOnProduct(0);
		productDetailsPage.selectColor(getData("color"));
		productDetailsPage.selectSize(getData("size"));
		productDetailsPage.clickAddToBag();
		ShoppingBagPage shoppingBagPage = productDetailsPage.clickGoToBag();
		CheckoutPage checkoutPage = shoppingBagPage.clickProceedToShipping();
		checkoutPage.clickProceedToPayment();
	}
	
}
