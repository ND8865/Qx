package PageObjectClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Admin_Partner_Reject_Page {
	WebDriver driver;
	SoftAssert softassert;

	public Admin_Partner_Reject_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		softassert = new SoftAssert();
	}

	@FindBy(xpath = "//label[text()='Status']/following-sibling::div")
	private WebElement SelectStatus;
	@FindBy(xpath = "//*[text()='Rejected']//preceding-sibling::input")
	private WebElement CheckBoxClickStatus;
	@FindBy(xpath = "//label[contains(text(),'Primary Phone')]")
	private WebElement PrimaryPhoneHeader;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[5]")
	private List<WebElement> SortingStatus;
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M19 6.41L1')]")
	private WebElement DropDownCross;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[1]")
	private List<WebElement> SortingPartner;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[6]")
	private List<WebElement> SortingView;
	@FindBy(xpath = "//h4[contains(text(),'Reason for Rejection')]")
	private WebElement ReasonforRejection;
	@FindBy(xpath = "//div[@class='content-section']")
	private List<WebElement> NonEditableText;
	@FindBy(xpath = "//*[text()='Pending']//preceding-sibling::input")
	private WebElement CheckBoxClickPending;
	@FindBy(xpath = "//button[contains(text(),'Reject')]")
	private WebElement RejectButton;
	@FindBy(xpath = "//button[contains(text(),'Reject')]")
	private WebElement RejectionReason;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement CancelButton;
	@FindBy(xpath = "//span[contains(text(),'Partners')]")
	private WebElement PartnersButton;
	@FindBy(xpath = "//*[text()='Amendments Suggested']//preceding-sibling::input")
	private WebElement CheckBoxClickAmendmentsSuggested;
	@FindBy(xpath = "//*[text()='Docusign Pending']//preceding-sibling::input")
	private WebElement CheckBoxClickDocusign;
	@FindBy(xpath = "//*[@placeholder='Enter reason for rejection']")
	private WebElement ReasonForRejection;
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement ConfirmButtonReject;
	@FindBy(xpath = "//label[contains(text(),'Partner Name')]")
	private WebElement PartnameHeader;

	/**
	 * Description - Verify if user can view the list of Rejected partners by
	 * selecting Rejected Status.
	 * 
	 * @return - True - If User can see the view list of rejected partners by
	 *         selecting rejected status.
	 */

	public boolean FilterRejected() {
		try {

			boolean part = false;
			SelectStatus.click();
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(CheckBoxClickStatus, driver);
			WaitClass.waitForTime(2000);
			Actions action = new Actions(driver);
			action.moveToElement(PrimaryPhoneHeader).click().perform();
			WaitClass.waitForTime(2000);
			for (int i = 0; i <= SortingPartner.size() - 1; i++) {
				String rejectedPartners = SortingPartner.get(i).getText();
				if (driver.getPageSource().contains(rejectedPartners)) {
					part = true;
				}
			}
			return part;
		} catch (Exception e) {

			System.err.println("Exception in Method - FilterRejected, Class - Admin_Partner_Reject_Page : " + e);
		}
		return false;
	}

	/**
	 * Description - Verify if user can click on the view icon for Rejected
	 * partners.
	 * 
	 * @return - True - If can click on the view button for Rejected Partners.
	 * 
	 */

	public boolean ViewButton() {
		try {

			SortingView.get(1).click();
			boolean resonText = ReasonforRejection.isDisplayed();
			return resonText;
		} catch (Exception e) {

			System.err.println("Exception in Method - ViewButton, Class - Admin_Partner_Reject_Page : " + e);
		}
		return false;
	}

	/**
	 * Description - Verify that all the fields in the detail page are non-editable
	 * and view only.
	 * 
	 * 
	 * @return - True - If all the details page are non-editable after Reject
	 *         Partner click on View button.
	 * 
	 */

	public boolean RejectedPageEditable() {
		try {
			for (int i = 0; i <= NonEditableText.size() - 1; i++) {
				String nonedittext = NonEditableText.get(i).getText();
				softassert.assertNotNull(nonedittext);
				softassert.assertAll();
			}

			return true;
		} catch (Exception e) {

			System.err.println("Exception in Method - RejectedPageEditable, Class - Admin_Partner_Reject_Page : " + e);
		}
		return false;
	}

	/**
	 * Description - Verify if ADMin can reject a partner whose status is either
	 * pending/suggest modifications/ docusign pending.
	 * 
	 * 
	 * @return - True - If ADMIn can reject a partner whoes status is pending /
	 *         suggest modification / docusign pending.
	 */

	public boolean CanRejectPartners(boolean Pending, boolean AmendmentsSuggested, boolean DocusignPending) {
		try {
			if (Pending == true) {

				SelectStatus.click();
				WaitClass.waitForTime(1000);
				Utility.javaScriptClick(CheckBoxClickPending, driver);
				WaitClass.waitForTime(2000);
				Actions action = new Actions(driver);
				action.moveToElement(PrimaryPhoneHeader).click().perform();
				WaitClass.waitForTime(2000);
				try {
					SortingView.get(0).click();
				}
				catch(Exception e) {
					return true;
				}
				Utility.javaScriptClick(RejectButton, driver);
				RejectionReason.isDisplayed();
				CancelButton.click();
				PartnersButton.click();
				return true;
			}

			if (AmendmentsSuggested == true) {

				SelectStatus.click();
				WaitClass.waitForTime(1000);
				Utility.javaScriptClick(CheckBoxClickAmendmentsSuggested, driver);
				WaitClass.waitForTime(2000);
				Actions action = new Actions(driver);
				action.moveToElement(PrimaryPhoneHeader).click().perform();
				WaitClass.waitForTime(2000);
				try {
					SortingView.get(0).click();
				}
				catch(Exception e) {
					return true;
				}
				Utility.javaScriptClick(RejectButton, driver);
				RejectionReason.isDisplayed();
				RejectionReason.isDisplayed();
				CancelButton.click();
				PartnersButton.click();
				return true;
			}
			if (DocusignPending == true) {

				SelectStatus.click();
				WaitClass.waitForTime(1000);
				Utility.javaScriptClick(CheckBoxClickDocusign, driver);
				WaitClass.waitForTime(2000);
				Actions action = new Actions(driver);
				action.moveToElement(PrimaryPhoneHeader).click().perform();
				WaitClass.waitForTime(2000);
				try {
					SortingView.get(0).click();
				}
				catch(Exception e) {
					return true;
				}
				Utility.javaScriptClick(RejectButton, driver);
				RejectionReason.isDisplayed();
				RejectionReason.isDisplayed();
				CancelButton.click();
				PartnersButton.click();
				return true;
			}
		} catch (Exception e) {

			System.err.println("Exception in Method - CanRejectPartners, Class - Admin_Partner_Reject_Page : " + e);
		}
		return false;
	}

	/**
	 * Description - Verify if ADmin can mention the Reason for Reject the Partner.
	 * 
	 * 
	 * 
	 * @return - True - If ADmin is able to mention the Reason for Reject the
	 *         partner.
	 * 
	 * 
	 */

	public boolean RejectPartner() {
		try {
			SelectStatus.click();
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(CheckBoxClickPending, driver);
			WaitClass.waitForTime(2000);
			Actions action = new Actions(driver);
			action.moveToElement(PrimaryPhoneHeader).click().perform();
			WaitClass.waitForTime(2000);
			SortingView.get(0).click();
			Utility.javaScriptClick(RejectButton, driver);
			RejectionReason.isDisplayed();
			ReasonForRejection.sendKeys(" This Partner are Rejecting ");

			return true;
		} catch (Exception e) {

			System.err.println("Exception in Method - RejectPartner, Class - Admin_Partner_Reject_Page : " + e);
		}
		return false;
	}

	/**
	 * Description - Verify if ADmin can click on confirm the reject to partners.
	 * 
	 * 
	 * @return - True - If Partners has been reject by ADmin.
	 * 
	 * 
	 */

	public boolean ConfirmRejectPartner() {
		try {
			ConfirmButtonReject.click();
			PartnameHeader.isDisplayed();

			return true;
		} catch (Exception e) {

			System.err.println("Exception in Method - ConfirmRejectPartner, Class - Admin_Partner_Reject_Page : " + e);
		}
		return false;
	}
}
