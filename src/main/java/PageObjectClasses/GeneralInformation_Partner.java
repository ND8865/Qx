package PageObjectClasses;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import UtilityClass.Utility;
import UtilityClass.WaitClass;


public class GeneralInformation_Partner {
	
	private WebDriver driver;
	
	public GeneralInformation_Partner(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//h4[contains(@class, 'page-heading')]")
	private WebElement pageHeadingElement;
	
	@FindBy(xpath = "//label[contains(@for, 'logoUpload')]")
	private WebElement uploadButtonElement;
	
	@FindBy(xpath = "//div[contains(@class, 'add-logo')]/div[contains(@class, 'logo-box')]//img")
	private WebElement logoElement;
	
	@FindBy(xpath = "//input[@name = 'legalEntityName']")
	private WebElement legalEntityNameElement;
	
	@FindBy(xpath = "//button[text() = 'Next']")
	private WebElement nextButtonElement;
	
	@FindBy(xpath = "//a[contains(@class, 'signout')]")
	private WebElement signoutElement;
	
	@FindBy(xpath = "//div[contains(@class, 'modal-content')]")
	private WebElement DialogBoxElement;
	
	@FindBy(xpath = "//h2[contains(@class, 'modal-heading')]")
	private WebElement dialogBoxHeadingElement;
	
	@FindBy(xpath = "//div[contains(@class, 'modal-footer')]/button[3]")
	private WebElement confirmButtonElement;
	
	@FindBy(xpath = "//select[@name = 'categoryId']")
	private WebElement categoryElement;
	
	@FindBy(xpath = "//select[@name = 'joinReasonId']")
	private WebElement reasonToJoinElement;
	
	String[] allCategories = {"Game publisher", "Game developer", "Loyalty rewards program retail"};
	String[] allReasonsToJoin = {"Loyalty rewards program retail",
			"Use the QX portal to define and issue offers, with associated rewards, based upon in-game events or actions", 
			"Both"};
	/**
	 * validates page heading
	 * @param pageHeading (String) Page Heading that should be visible on the page
	 * @return true if page heading gets validated successfully
	 */
	public boolean validatePageHeading(String pageHeading) {
		try {
			return pageHeadingElement.getText().contains(pageHeading);
		} catch (Exception e) {
			System.err.println("Class - GeneralInformation_Partner and Method - validatePageHeading");
			return false;
		}
	}
	
	public boolean uploadLogoAction() {
		try {
			String imageRelativePath = "src/test/resources/TestData/chicken.jpeg";
			File imageFile = new File(imageRelativePath);
			
			WebElement element = driver.findElement(By.xpath("//input[@name = 'logo']"));
			element.sendKeys(imageFile.getAbsolutePath());
			
			return true;
		} catch (Exception e) {
			System.err.println("Class - GeneralInformation_partner and Method - uploadLogoAction:");
			System.err.println(e);
			return false;
		}
	}
	
	public boolean navigateForward() {
		try {
			driver.navigate().forward();
			return true;
		} catch (Exception e) {
			System.err.println("Class - GeneralInformation_partner and Method - navigateForward:");
			System.err.println(e);
			return false;
		}
	}
	
	/**
	 * 
	 * @param value (String) 1 - generalInfo, 2 - ContactInfo, 3 - OtherInfo, 4 - T&C 
	 * @return
	 */
	public boolean navigateTo(String value) {
		try {
			String pattern = "//span[text() = '" + value + "']//parent::a";
			driver.findElement(By.xpath(pattern)).click();
			return true;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_Partner and Method - navigateTo");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean validateLegalEntityName(String legalEntityName) {
		try {
			WaitClass.waitForElement(legalEntityNameElement, driver, 3000);
			return legalEntityNameElement.getAttribute("value").contains(legalEntityName);
		} catch (Exception e) {
			 System.err.println("Class - GeneralInformation_partner and Method - validateLegalEntityName:");
			 System.err.println(e);
			 return false;
		}
	}
	
	public boolean setLegalEntityName(String name) {
		try {
			Utility.clearField(driver, legalEntityNameElement);
			legalEntityNameElement.sendKeys(name);
			return true;
		} catch (Exception e) {
			System.err.println("Class - GeneralInformation_partner and Method - setLegalEntityName:");
			 System.err.println(e);
			 return false;
		}
	}
	
	public boolean clickNextButton() {
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].click()", nextButtonElement);
			Thread.sleep(3000);
			return true;
		} catch (Exception e) {
			 System.err.println("Class - GeneralInformation_partner and Method - clickButton");
			 System.err.println(e);
			 return false;
		}
	}
	
	public boolean signoutAction() {
		try {
			signoutElement.click();
			if (DialogBoxElement.isDisplayed() && dialogBoxHeadingElement.getText().contains("Sign Out")) {
				confirmButtonElement.click();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("Class - GeneralInformation_partner and Method - signoutAction");
			System.err.println(e);
			return false;
		}
	}
	
	public boolean clearAllFields() {
		try {
			Utility.clearField(driver, legalEntityNameElement);
			return true;
		} catch (Exception e) {
			System.err.println("Class - GeneralInformation_partner and Method - clearAllFields");
			System.err.println(e);
			return false;
		}
	}
	
	
	/**
	 * validates functionality of dropdown
	 * @param categoryDropdown (boolean) if true checks if all options in category dropdown are Selectable
	 * @param reasonToJoinDropdown (boolean) if true checks if all options in reasons to join dropdown are selectable
	 * @return true if all options in a dropdown are selectable
	 */
	
	public boolean validateDropdown(boolean categoryDropdown, boolean reasonToJoinDropdown) {
		try {
			boolean flag = false;
			if (categoryDropdown) {
				flag = validateDropdown(categoryElement, allCategories);
			}
			else if(reasonToJoinDropdown) {
				flag = validateDropdown(reasonToJoinElement, allReasonsToJoin);
			}
			return flag;
		} catch (Exception e) {
			System.err.println("Class - GeneralInformation_partner and Method - validateDropdown");
			System.err.println(e);
			return false;
		}
	}
	
	public boolean selectFromDropdown(boolean categoryDropdown, boolean reasonToJoinDropdown, String value) {
		try {
			WebElement dropdown = null;
			if (categoryDropdown) dropdown = categoryElement;
			else if (reasonToJoinDropdown) dropdown = reasonToJoinElement;
			Select select = new Select(dropdown);
			select.selectByValue(value);
			return true;
		} catch (Exception e) {
			System.err.println("Class - GeneralInformation_partner and Method - selectFromDropdown");
			System.err.println(e);
			return false;
		}
	}
	
	private boolean validateDropdown(WebElement dropdownElement, String[] optionStrings) {
		Select dropdownSelect = new Select(dropdownElement);
		List<WebElement> allOptions = dropdownSelect.getOptions();
		for (int i = 0; i < allOptions.size(); i++) {
			dropdownSelect.selectByValue(i + "");
			if (!dropdownSelect.getFirstSelectedOption().getText().contains(optionStrings[i])) {
				return false;
			}
		}
		return true;
	}
}
