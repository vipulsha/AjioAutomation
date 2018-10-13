package pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.common.ParentPage;

public class MyAccountPage extends ParentPage {

	// Data Members
	@FindBy(xpath = "//li[text()='ADDRESS BOOK']")
	WebElement addressBook;
	@FindBy(xpath = "//span[text()='Add new address']")
	WebElement addAddressLink;
	@FindBy(name = "postalCode")
	WebElement pinCodeTextbox;
	@FindBy(name = "firstName")
	WebElement firstNameTextbox;
	@FindBy(name = "lastName")
	WebElement lastNameTextbox;
	@FindBy(name = "line1")
	WebElement addressLine1Textbox;
	@FindBy(name = "state")
	WebElement stateTextbox;
	@FindBy(name = "district")
	WebElement districtTextbox;
	@FindBy(name = "phone")
	WebElement phoneNoTextbox;
	@FindBy(xpath = "//input[@value='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//button[text()='Reset']")
	WebElement resetButton;
/*	@FindBy(id = "addAddressTypeHomeSpan")
	WebElement homeAddress;
	@FindBy(id = "addAddressTypeWorkSpan")
	WebElement workAddress;
*/	
	private final String ADDRESSES_XPATH = "//div[@class='address-section']/div[contains(@class,'inactive-address')]";
	private final String ADDRESS_NAME_XPATH = ".//span[@class='address-book-user-name']";
	private final String ADDRESS_LINE1_XPATH = ".//div[@class='address-first']";
	private final String CITY_XPATH = ".//div[@class='address-third']";
	private final String STATE_XPATH = ".//div[@class='address-fourth']";
	private final String PINCODE_XPATH = ".//div[@class='address-fifth']";
	
	// Constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// Page Functions
	public void clickAddressBook() {
		click(addressBook);
	}

	public void clickAddAddressLink() {
		click(addAddressLink);
	}

	public void enterPinCode(String pinCode) {
		enterText(pinCodeTextbox, pinCode);
	}

	public void enterFirstName(String firstName) {
		enterText(firstNameTextbox, firstName);
	}

	public void enterLastName(String lastName) {
		enterText(lastNameTextbox, lastName);
	}

	public void enterAddressLine1(String addressLine1) {
		enterText(addressLine1Textbox, addressLine1);
	}

	public void enterState(String state) {
		enterText(stateTextbox, state);
	}

	public void enterDistrict(String district) {
		enterText(districtTextbox, district);
	}

	public void enterPhoneNo(String phoneNo) {
		enterText(phoneNoTextbox, phoneNo);
	}

/*	public void selectHomeAddress() {
		click(homeAddress);
	}

	public void selectWorkAddress() {
		click(workAddress);
	}
*/
	public void clickSaveButton() {
		int cnt = 1;
		do {
			try {
				click(saveButton);
				waitForElementToBeInVisible(saveButton);
				break;
			} catch (Exception e) {}
			cnt++;
		} while(cnt<=2);
	}

	public void clickResetButton() {
		click(resetButton);
	}

	public boolean isAddressPresent(String firstName,String lastName, 
			String addressLine1,String pinCode,String district,String state,String addressType) {
		// Get all address elements
		List<WebElement> addresses = findElements(By.xpath(ADDRESSES_XPATH));

		for(int i=0; i<addresses.size(); i++) {
			WebElement address = addresses.get(i);
			// Name & Address Type
			WebElement name = waitForChildElement(address, By.xpath(ADDRESS_NAME_XPATH));
			String addressName = name.getText();
			String firstNameTxt = "";
			String lastNameTxt = "";
			if (StringUtils.isNotBlank(addressName)) {
				String[] split2 = addressName.split(" ");
				firstNameTxt = split2[0];
				lastNameTxt = split2[1];
			}

			if (!firstName.equals(firstNameTxt) || !lastName.equals(lastNameTxt)) 
				continue;

			// Address Line1
			WebElement addLine1 = waitForChildElement(address, By.xpath(ADDRESS_LINE1_XPATH));
			
			String addLine1Txt = addLine1.getText().trim().replace(",", "");
			if (!addressLine1.equalsIgnoreCase(addLine1Txt))
				continue;

			// City & State
			WebElement cityState = waitForChildElement(address, By.xpath(CITY_XPATH));
			String cityStateTxt = cityState.getText().trim().replace(",", "");
			if (!cityStateTxt.equalsIgnoreCase(district)) 
				continue;
			
			WebElement stateElement = waitForChildElement(address, By.xpath(STATE_XPATH));
			String stateTxt = stateElement.getText().trim().replace(",", "");
			if (!stateTxt.equalsIgnoreCase(state)) 
				continue;

			// Pin code
			WebElement pinCodeElement = waitForChildElement(address, By.xpath(PINCODE_XPATH));
			String pinCodeTxt = pinCodeElement.getText();
			pinCodeTxt = pinCodeTxt.split("- ")[1];
			if(!pinCode.equals(pinCodeTxt))
				continue;
			else 
				return true;
		}
		return false;
	}
}
