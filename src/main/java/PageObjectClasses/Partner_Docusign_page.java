package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Partner_Docusign_page {
	WebDriver driver;
	SoftAssert softassert;

	public Partner_Docusign_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		softassert = new SoftAssert();
	}

	@FindBy(xpath = "//span[contains(text(),'Partners')]")
	private WebElement Partnerbutton;
	@FindBy(xpath = "(//span[contains(text(),'Select')])[5]")
	private WebElement SelectfilterStatus;
	@FindBy(xpath = "//*[text()='Amendments Suggested']//preceding-sibling::input")
	private WebElement SearchDropdownValuestatus;
	@FindBy(xpath = "//label[text()='Status']")
	private WebElement GamenameHeader;
	@FindBy(xpath = "//*[@class='icon cursor-pointer']")
	private WebElement ViewButton;
	@FindBy(xpath = "//button[contains(text(),'Resolved')]")
	private WebElement Resolvedtab;
	@FindBy(xpath = "//h2[contains(text(),'Suggest Modification')]")
	private WebElement SuggestModificationHeading;
	@FindBy(xpath = "//textarea[@placeholder='General Information']")
	private WebElement SuggestionField;
	@FindBy(xpath = "//button[text()='Resolve']")
	private WebElement SuggestionResolvebutton;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement SuggestionSavebutton;
	@FindBy(xpath = "//button[text()='Accept & Confirm']")
	private WebElement AcceptandConfirmbutton;
	@FindBy(xpath = "//div[contains(text(),'Please resolve all suggested modifications')]")
	private WebElement ToastMessagePleaseresolveallsuggestedmodifications;

	@FindBy(xpath = "//h2[contains(text(),'DocuSign Envelope ID')]")
	private WebElement DocusignEnvelopeidheader;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement DocusignidSubmitButton;
	@FindBy(xpath = "//input[@placeholder='Enter envelope ID']")
	private WebElement DocusignEnvelopeIdField;
	@FindBy(xpath = "//div[contains(text(),'Please enter envelope ID')]")
	private WebElement EnvelopidErrorMessage;

	/**
	 * Description - Verify that user can click on the partner button.
	 * 
	 * @return - true - if user can click on the partner button.
	 * 
	 */
	public boolean PartnerButton() {
		try {

			Utility.javaScriptClick(Partnerbutton, driver);

			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Docusign_page, Method - PartnerButton : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify that user can filter the status on partner tab.
	 * 
	 * @return - true - if user can filter the status on partner tab.
	 * 
	 */
	public boolean Filterstatus() {
		try {

			SelectfilterStatus.click();
			WaitClass.waitForTime(1000);
			SearchDropdownValuestatus.click();
			WaitClass.waitForTime(2000);
			Actions actiona = new Actions(driver);
			actiona.moveToElement(GamenameHeader).click().perform();

			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Docusign_page, Method - Filterstatus : " + e);
			return false;
		}
	}

	/**
	 * Description -"Verify that if the ADMIN has given something suggestion then
	 * clicking on Accept & Confirm without resolving it will show error message
	 * ""Please resolve all suggested modifications"" "
	 * 
	 * @return - true - " if the ADMIN has given something suggestion then clicking
	 *         on Accept & Confirm without resolving it will show error message
	 *         ""Please resolve all suggested modifications"" "
	 * 
	 */
	public boolean SuggestionMessage() {
		try {
			Utility.javaScriptClick(ViewButton, driver);
			Utility.javaScriptClick(Resolvedtab, driver);
			boolean heading = SuggestModificationHeading.isDisplayed();
			Utility.clearField(driver, SuggestionField);
			Utility.javascriptSendKeys(driver, SuggestionField, " This is temp suggestion");
			Utility.javaScriptClick(SuggestionSavebutton, driver);
			Utility.javaScriptClick(AcceptandConfirmbutton, driver);
			String toastmessage = Utility.getalerttext(driver, ToastMessagePleaseresolveallsuggestedmodifications);
			String toastmessageexp = "Please resolve all suggested modifications";
			softassert.assertEquals(toastmessage, toastmessageexp);
			softassert.assertAll();

			return true && heading;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Docusign_page, Method - SuggestionMessage : " + e);
			return false;
		}
	}

	/**
	 * Description -Verify if ADMIN is able to view "DocuSign Envelope ID" Pop up
	 * after clicking on Accept & Confirm by resolving all the suggestions.
	 * 
	 * 
	 * @return - true - if ADMIN is able to view "DocuSign Envelope ID" Pop up after
	 *         clicking on Accept & Confirm by resolving all the suggestions.
	 *
	 */
	public boolean DocuSignEnvelopeID() {
		try {
			Utility.javaScriptClick(ViewButton, driver);
			Utility.javaScriptClick(Resolvedtab, driver);
			boolean heading = SuggestModificationHeading.isDisplayed();
			Utility.clearField(driver, SuggestionField);
			Utility.javascriptSendKeys(driver, SuggestionField, " This is temp suggestion");
			Utility.javaScriptClick(Resolvedtab, driver);
			Utility.javaScriptClick(AcceptandConfirmbutton, driver);
			boolean envelopeid = DocusignEnvelopeidheader.isDisplayed();
			return true && heading && envelopeid;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Docusign_page, Method - DocuSignEnvelopeID : " + e);
			return false;
		}
	}

	/**
	 * Description -Verify if ADMIN will view the error message "Please enter
	 * envelope ID" after clicking on Submit by leaving the text box as blank.
	 * 
	 * @return - true - if ADMIN will view the error message "Please enter envelope
	 *         ID" after clicking on Submit by leaving the text box as blank.
	 * 
	 */
	public boolean ValidateEnvelopeIdErrorMessage() {
		try {
			Utility.javaScriptClick(ViewButton, driver);
			Utility.javaScriptClick(Resolvedtab, driver);
			boolean heading = SuggestModificationHeading.isDisplayed();
			Utility.clearField(driver, SuggestionField);
			Utility.javascriptSendKeys(driver, SuggestionField, " This is temp suggestion");
			Utility.javaScriptClick(Resolvedtab, driver);
			Utility.javaScriptClick(AcceptandConfirmbutton, driver);
			boolean envelopeid = DocusignEnvelopeidheader.isDisplayed();
			Utility.javaScriptClick(DocusignidSubmitButton, driver);
			String textactual = EnvelopidErrorMessage.getText();
			String textexp = "Please enter envelope ID";
			softassert.assertEquals(textactual, textexp);
			softassert.assertAll();
			return true && heading && envelopeid;
		} catch (Exception e) {
			System.err.println(
					"Exception in Class - Partner_Docusign_page, Method - ValidateEnvelopeIdErrorMessage : " + e);
			return false;
		}
	}

	/**
	 * Description -Verify if ADMIN is able to submit by entering valid DocuSign
	 * Envelope ID.
	 * 
	 * @return - true - if ADMIN is able to submit by entering valid DocuSign
	 *         Envelope ID.
	 * 
	 */
	public boolean EnterEnvelopeId() {
		try {
			Utility.javaScriptClick(ViewButton, driver);
			Utility.javaScriptClick(Resolvedtab, driver);
			boolean heading = SuggestModificationHeading.isDisplayed();
			WaitClass.waitForTime(1000);
			Utility.clearField(driver, SuggestionField);
			WaitClass.waitForTime(1000);
			Utility.javascriptSendKeys(driver, SuggestionField, " This is temp suggestion");
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(SuggestionResolvebutton, driver);
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(AcceptandConfirmbutton, driver);
			WaitClass.waitForTime(1000);
			boolean envelopeid = DocusignEnvelopeidheader.isDisplayed();
			WaitClass.waitForTime(1000);
			Utility.clearField(driver, DocusignEnvelopeIdField);
			WaitClass.waitForTime(1000);
			DocusignEnvelopeIdField.sendKeys("987654321");
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(DocusignidSubmitButton, driver);
		
			return true && heading && envelopeid;
		} catch (Exception e) {
			System.err.println(
					"Exception in Class - Partner_Docusign_page, Method - EnterEnvelopeId : " + e);
			return false;
		}
	}

}
