package PageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class PendingAndAmmendmentsSuggestedPartnerStatus_Admin {
	
	WebDriver driver;
	MailBox code;
		
		public PendingAndAmmendmentsSuggestedPartnerStatus_Admin(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			code = new MailBox();
			
		}
		
		//GENERAL INFORMATION
		@FindBy(xpath = "//button[text()='Send Suggestion']")
		private WebElement sendSuggestionButton;
		
		@FindBy(xpath = "//h4[text()='General Information']/following-sibling::button")
		private WebElement suggestionModificationGeneralInfo;
		
		@FindBy(xpath = "//div[@class='row']/div[5]/div/div/button")
		private WebElement statusFilterDropdown;
		
		@FindBy(xpath = "//div[@class='row']/div[5]/div/div/div/div/div/div/div[2]/div/input")
		private WebElement statusFilterDropdownTextField;
		
		@FindBy(xpath = "//div[@class='row']/div[5]/div/div/div/div/div[2]/div/div/input")
		private WebElement dropdownFirstOption;
		
		@FindBy(xpath = "//div[@id='root']")
		private WebElement pageDive;
		
		@FindBy(xpath = "//div[@class='table-row']/div[5]")
		private List<WebElement> partnerStatusList;
		
		@FindBy(xpath = "//h4[text()='Contact Information']/following-sibling::button")
		private WebElement suggestionModificationContactInfo;
		
		@FindBy(xpath = "//h4[text()='Other Information']/following-sibling::button")
		private WebElement suggestionModificationOtherInfo;
		
		@FindBy(xpath = "//h2[text()='Suggest Modification']")
		private WebElement suggestionModificationPopupHeader;
		
		@FindBy(xpath = "//textarea[@data-testid='modification-textarea']")
		private WebElement suggestionModificationTextArea;
		
		@FindBy(xpath = "//button[@data-testid='cancel-modification']")
		private WebElement suggestionModificationCancelButton;
		
		@FindBy(xpath = "//button[@data-testid='save-modification']")
		private WebElement suggestionModificationSaveButton;
		
		@FindBy(xpath = "//button[@data-testid='resolve-modification']")
		private WebElement suggestionModificationResolveButton;
		
		@FindBy(xpath = "//div[text()='Please suggest some modicfication!']")
		private WebElement blankTextAreaValidationMessage;
		
		@FindBy(xpath = "(//button[text()='Edit Suggestion'])[1]")
		private WebElement editSuggestionButton1;
		
		@FindBy(xpath = "(//button[text()='Edit Suggestion'])[2]")
		private WebElement editSuggestionButton2;
		
		@FindBy(xpath = "(//button[text()='Edit Suggestion'])[3]")
		private WebElement editSuggestionButton3;
		
		@FindBy(xpath = "//button[text()='Resolved']")
		private WebElement resolvedSuggestButton;
		
		@FindBy(xpath = "//div[text()='Please suggest some modification!']")
		private WebElement suggestToastMessage;
		
		@FindBy(xpath = "//div[text()='Suggestions sent to partner']")
		private WebElement sentSuggestSuccessToastMessage;
		
		@FindBy(xpath = "//button[text()='Accept & Confirm']")
		private WebElement acceptAndConfirmButton;
		
		@FindBy(xpath = "//span[text()='Info']")
		private WebElement infoTab;
		
		@FindBy(xpath = "//button[text()='Suggest Modification']")
		private List<WebElement> suggestModificationButtons;
		
		
		/**
		 * Description - Navigating to partner pending status detail page.
		 * @return - true - if admin lands successfully on partner detail page.
		 */
		public boolean navigateToPartnerPendingDetail() {
			try {
				statusFilterDropdown.click();
				statusFilterDropdownTextField.sendKeys("Pending");
				WaitClass.waitForTime(1000);
				dropdownFirstOption.click();
				pageDive.click();
				WaitClass.waitForTime(1000);
				driver.findElement(By.xpath("(//div[@class='icon cursor-pointer'])[1]")).click();
				WaitClass.waitForTime(1000);
				boolean flag = infoTab.isDisplayed();
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - PendingAndAmmendmentsSuggestedPartnerStatus_Admin, Method - navigateToPartnerPendingDetail : " + e);
				return false;
			}
		}
		
		/**
		 * Description - Navigating to partner amendment suggested detail page.
		 * @return - true - if admin lands successfully on partner detail page.
		 */
		public boolean navigateToPartnerAmendmentSuggestedDetail() {
			try {
				statusFilterDropdown.click();
				statusFilterDropdownTextField.sendKeys("Amendment");
				WaitClass.waitForTime(1000);
				dropdownFirstOption.click();
				pageDive.click();
				WaitClass.waitForTime(1000);
				driver.findElement(By.xpath("(//div[@class='icon cursor-pointer'])[1]")).click();
				WaitClass.waitForTime(1000);
				boolean flag = infoTab.isDisplayed();
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - PendingAndAmmendmentsSuggestedPartnerStatus_Admin, Method - navigateToPartnerAmendmentSuggestedDetail : " + e);
				return false;
			}
		}
		
		/**
		 * Description - Navigating to partner amendment suggested detail page.
		 * @return - true - if admin lands successfully on partner detail page.
		 */
		public boolean navigateToPartnerDocuSignDetail() {
			try {
				statusFilterDropdown.click();
				statusFilterDropdownTextField.sendKeys("Docusign");
				WaitClass.waitForTime(1000);
				dropdownFirstOption.click();
				pageDive.click();
				WaitClass.waitForTime(1000);
				driver.findElement(By.xpath("(//div[@class='icon cursor-pointer'])[1]")).click();
				WaitClass.waitForTime(1000);
				boolean flag = infoTab.isDisplayed();
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - PendingAndAmmendmentsSuggestedPartnerStatus_Admin, Method - navigateToPartnerDocuSignDetail : " + e);
				return false;
			}
		}
		
		/**
		 * Description - Validation pending and amendments suggested listing.
		 * @return - true - if admin lands successfully on partner detail page.
		 */
		public boolean statusFilterForPendingAndAmendment() {
			try {
				statusFilterDropdown.click();
				statusFilterDropdownTextField.sendKeys("Pending");
				WaitClass.waitForTime(1000);
				dropdownFirstOption.click();
				WaitClass.waitForTime(2000);
				Utility.clearField(driver, driver.findElement(By.xpath("//*[@value='Pending']")));
				//statusFilterDropdownTextField.clear();
				WaitClass.waitForTime(1000);
				statusFilterDropdownTextField.sendKeys("Amendment");
				WaitClass.waitForTime(1000);
				dropdownFirstOption.click();
				pageDive.click();
					WaitClass.waitForTime(1000);
					for(int i = 1 ; i < (partnerStatusList.size()); i++) {
						boolean flag = false;
						String status = partnerStatusList.get(i).getText();
					    flag = flag || status.equals("Pending");
					    flag = flag || status.equals("Amendments Suggested");
					    if(flag == false) {
					    	return false;
					    }
					}
					return true;
			} catch (Exception e) {
				System.err.println("Exception in Class - PendingAndAmmendmentsSuggestedPartnerStatus_Admin, Method - navigateToPartnerPendingDetail : " + e);
				return false;
			}
		}
		
		/**
		 * Description - validating suggest modification flow.
		 * @param generalInfo - true for general info modification.
		 * @param contactInfo - true for contact info modification.
		 * @param otherInfo - true for other info modification.
		 * @return - true - if suggest modification working correctly.
		 */
		public boolean suggestModificationFlow(boolean generalInfo, boolean contactInfo, boolean otherInfo) {
			try {
				if(generalInfo == true) {
				suggestionModificationGeneralInfo.click();
				boolean flag = suggestionModificationPopupHeader.isDisplayed();
				suggestionModificationTextArea.sendKeys("Update general Information");
				suggestionModificationSaveButton.click();
				WaitClass.waitForTime(2000);
				flag = flag && editSuggestionButton1.isDisplayed();
				return flag;
				}
				else if(contactInfo == true) {
					suggestionModificationContactInfo.click();
					boolean flag = suggestionModificationPopupHeader.isDisplayed();
					suggestionModificationTextArea.sendKeys("Update contact Information");
					suggestionModificationSaveButton.click();
					WaitClass.waitForTime(2000);
					flag = flag && editSuggestionButton2.isDisplayed();
					return flag;
				}
				else if(otherInfo == true) {
					suggestionModificationOtherInfo.click();
					boolean flag = suggestionModificationPopupHeader.isDisplayed();
					suggestionModificationTextArea.sendKeys("Update other Information");
					suggestionModificationSaveButton.click();
					WaitClass.waitForTime(2000);
					flag = flag && editSuggestionButton3.isDisplayed();
					return flag;
				}
				return false;
			} catch (Exception e) {
				System.err.println("Exception in Class - Edit_Profile_Partner, Method - suggestModificationFlow : " + e);
				return false;
			}
		}
		
		/**
		 * Description - Validating send modification suggest modification toast message.
		 * @return - true - if suggest modification toast message visible.
		 */
		public boolean sendModificationValidation() {
			try {
				sendSuggestionButton.click();
				boolean flag = sentSuggestSuccessToastMessage.isDisplayed();
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - Edit_Profile_Partner, Method - sendModificationValidation : " + e);
				return false;
			}
		}
		
		/**
		 * Description - Validating general info suggest Modification pop-up.
		 * @return - true - if suggest Modification works correctly.
		 */
		public boolean suggestModificationGeneralInfo() {
			try {
				suggestionModificationGeneralInfo.click();
				boolean flag = suggestionModificationPopupHeader.isDisplayed();
				flag = flag && suggestionModificationCancelButton.isDisplayed();
				flag = flag && suggestionModificationGeneralInfo.isDisplayed();
				flag = flag && suggestionModificationSaveButton.isDisplayed();
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - PendingAndAmmendmentsSuggestedPartnerStatus_Admin, Method - suggestModificationGeneralInfo : " + e);
				return false;
			}
		}
		
		/**
		 * Description - Validating suggest modification button visible or not.
		 * @return - true - if suggest modification button visible.
		 */
		public boolean suggestModificationButton() {
			try {
				return suggestionModificationGeneralInfo.isDisplayed();
			} catch (Exception e) {
				System.err.println("Exception in Class - PendingAndAmmendmentsSuggestedPartnerStatus_Admin, Method - suggestModificationButton : " + e);
				return false;
			}
		}
		

		/**
		 * Description - Validating suggest modification button click.
		 * @return - true - if suggest modification button clickable.
		 */
		public boolean suggestModificationButtonClick() {
			try {
				boolean flag = true;
				for(int i = 0; i < (suggestModificationButtons.size()); i++ ) {
				suggestModificationButtons.get(i).click();
				flag = flag && suggestionModificationPopupHeader.isDisplayed();
				suggestionModificationCancelButton.click();
				WaitClass.waitForTime(2000);
				}
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - PendingAndAmmendmentsSuggestedPartnerStatus_Admin, Method - suggestModificationButtonClick : " + e);
				return false;
			}
		}
		
		/**
		 * Description - Validating suggest modification pop-up text-area accepts text.
		 * @return - true - if working correctly.
		 */
		public boolean suggestModificationPopupEnterText() {
			try {
				boolean flag = true;
				for(int i = 0; i < (suggestModificationButtons.size()); i++ ) {
				suggestModificationButtons.get(i).click();
				flag = flag && suggestionModificationPopupHeader.isDisplayed();
				suggestionModificationTextArea.sendKeys("Text Entered Successfully");
				suggestionModificationCancelButton.click();
				WaitClass.waitForTime(2000);
				}
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - PendingAndAmmendmentsSuggestedPartnerStatus_Admin, Method - suggestModificationPopupEnterText : " + e);
				return false;
			}
		}
		
		/**
		 * Description - Validating suggest modification pop-up cancel button.
		 * @return - true - if working correctly.
		 */
		public boolean suggestModificationPopupCancelButton() {
			try {
				boolean flag = true;
				for(int i = 0; i < (suggestModificationButtons.size()); i++ ) {
				suggestModificationButtons.get(i).click();
				suggestionModificationTextArea.sendKeys("Text Entered Successfully");
				suggestionModificationCancelButton.click();
				WaitClass.waitForTime(2000);
				suggestModificationButtons.get(i).click();
				String textAreaValue = suggestionModificationTextArea.getAttribute("value");
				flag = flag && textAreaValue.isBlank();
				suggestionModificationCancelButton.click();
				}
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - PendingAndAmmendmentsSuggestedPartnerStatus_Admin, Method - suggestModificationPopupCancelButton : " + e);
				return false;
			}
		}
		
		/**
		 * Description - Validating suggest modification pop-up save button.
		 * @return - true - if working correctly.
		 */
		public boolean suggestModificationPopupSaveButton() {
			try {
				boolean flag = true;
				for(int i = 0; i < (suggestModificationButtons.size()); i++ ) {
				suggestModificationButtons.get(i).click();
				suggestionModificationTextArea.sendKeys("Text Entered Successfully");
				suggestionModificationSaveButton.click();
				WaitClass.waitForTime(2000);
				}
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - PendingAndAmmendmentsSuggestedPartnerStatus_Admin, Method - suggestModificationPopupSaveButton : " + e);
				return false;
			}
		}
		
		/**
		 * Description - Validating suggest modification enter text for single button.
		 * @return - true - if working correctly.
		 */
		public boolean suggestModificationSingleButton() {
			try {
				suggestionModificationGeneralInfo.click();
				boolean flag = suggestionModificationPopupHeader.isDisplayed();
				suggestionModificationTextArea.sendKeys("Update general Information");
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - PendingAndAmmendmentsSuggestedPartnerStatus_Admin, Method - suggestModificationSingleButton : " + e);
				return false;
			}
		}
		
		/**
		 * Description - Validating Edit suggest modification save button.
		 * @return - true - if working correctly.
		 */
		public boolean suggestModificationSaveButton() {
			try {
				suggestionModificationContactInfo.click();
				boolean flag = suggestionModificationPopupHeader.isDisplayed();
				suggestionModificationTextArea.clear();
				WaitClass.waitForTime(2000);
				suggestionModificationTextArea.sendKeys("Update general Information 2");
				suggestionModificationSaveButton.click();
				WaitClass.waitForTime(2000);
				flag = flag && suggestionModificationContactInfo.isDisplayed();
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - PendingAndAmmendmentsSuggestedPartnerStatus_Admin, Method - suggestModificationSaveButton : " + e);
				return false;
			}
		}
		
		/**
		 * Description - Validating Edit suggest modification resolve button.
		 * @return - true - if working correctly.
		 */
		public boolean editSuggestModificationResolveButton() {
			try {
				boolean flag = true;
				try {
					editSuggestionButton1.click();
					flag = suggestionModificationPopupHeader.isDisplayed();
					suggestionModificationTextArea.clear();
					WaitClass.waitForTime(2000);
					suggestionModificationTextArea.sendKeys("Update general Information 2");
					suggestionModificationResolveButton.click();
					WaitClass.waitForTime(2000);
				}
				catch(Exception e) {}
				flag = flag && resolvedSuggestButton.isDisplayed();
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - PendingAndAmmendmentsSuggestedPartnerStatus_Admin, Method - editSuggestModificationResolveButton : " + e);
				return false;
			}
		}

}
