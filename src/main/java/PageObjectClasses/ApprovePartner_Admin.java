package PageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.WaitClass;

public class ApprovePartner_Admin {
	
WebDriver driver;
MailBox code;
	
	public ApprovePartner_Admin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		code = new MailBox();
		
	}
	
	//GENERAL INFORMATION
	@FindBy(xpath = "//button[text()='Send Suggestion']")
	private WebElement sendSuggestionButton;
	
	@FindBy(xpath = "//h4[text()='General Information']/following-sibling::button")
	private WebElement suggestionModificationGeneralInfo;
	
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
	
	@FindBy(xpath = "//div[text()='Please suggest some modicfication!']")
	private WebElement blankTextAreaValidationMessage;
	
	@FindBy(xpath = "(//button[text()='Edit Suggestion'])[1]")
	private WebElement editSuggestionButton1;
	
	@FindBy(xpath = "(//button[text()='Edit Suggestion'])[2]")
	private WebElement editSuggestionButton2;
	
	@FindBy(xpath = "(//button[text()='Edit Suggestion'])[3]")
	private WebElement editSuggestionButton3;
	
	@FindBy(xpath = "//div[text()='Please suggest some modification!']")
	private WebElement suggestToastMessage;
	
	@FindBy(xpath = "//button[text()='Accept & Confirm']")
	private WebElement acceptAndConfirmButton;
	
	@FindBy(xpath = "//input[@name='envelopeId']")
	private WebElement envelopeIdTextField;
	
	@FindBy(xpath = "//div[@class='modal-footer']/button[text()='Cancel']")
	private WebElement envelopeIdpopupCancelButton;
	
	@FindBy(xpath = "//div[@class='modal-footer']/button[text()='Submit']")
	private WebElement envelopeIdpopupSubmitButton;
	
	@FindBy(xpath = "//button[text()='Approve Manually']")
	private WebElement approveManuallyButton;
	
	@FindBy(xpath = "//h2[text()='Approve Manually?']")
	private WebElement approveManuallyPopupHeader;
	
	@FindBy(xpath = "//p[text()='Are you sure you want to approve the partner manually?']")
	private WebElement approveManuallyPopupText;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement approveManuallyPopupCancel;
	
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement approveManuallyPopupConfirm;
	
	@FindBy(xpath = "//div[@class='row']/div[5]/div/div/button")
	private WebElement statusFilterDropdown;
	
	@FindBy(xpath = "//div[@class='row']/div[5]/div/div/div/div/div/div/div[2]/div/input")
	private WebElement statusFilterDropdownTextField;
	
	@FindBy(xpath = "//div[@class='row']/div[5]/div/div/div/div/div[2]/div/div/input")
	private WebElement dropdownFirstOption;
	
	@FindBy(xpath = "//div[@id='root']")
	private WebElement pageDive;
	
	@FindBy(xpath = "//input[@data-testid='searchKey']")
	private WebElement searchInputField;
	

	

	/**
	 * Description - Validating accept and confirm button Pop up.
	 * @return - true - if accept and confirm button pop up shows.
	 */
	public boolean validateConfirmPopup() {
		try {
			acceptAndConfirmButton.click();
			boolean flag = driver.findElement(By.xpath("//h2[text()='DocuSign Envelope ID']")).isDisplayed();
			flag = flag && envelopeIdTextField.isDisplayed();
			flag = flag && envelopeIdpopupCancelButton.isDisplayed();
			flag = flag && envelopeIdpopupSubmitButton.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Edit_Profile_Partner, Method - validateConfirmPopup : " + e);
			return false;
		}
	}
	
	
	
	/**
	 * Description - Navigating to partner detail page.
	 * @return - true - if admin lands successfully on partner detail page.
	 */
	public boolean navigateToPartnerDetail() {
		try {
			statusFilterDropdown.click();
			statusFilterDropdownTextField.sendKeys("Pending");
			WaitClass.waitForTime(1000);
			dropdownFirstOption.click();
			pageDive.click();
			WaitClass.waitForTime(1000);
			driver.findElement(By.xpath("(//div[@class='icon cursor-pointer'])[1]")).click();
			WaitClass.waitForTime(1000);
			boolean flag = sendSuggestionButton.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Edit_Profile_Partner, Method - navigateToPartnerDetail : " + e);
			return false;
		}
	}
	
	/**
	 * Description - Navigating to partner detail page.
	 * @return - true - if admin lands successfully on partner detail page.
	 */
	public boolean navigateToPartnerDetailManualApprove() {
		try {
			statusFilterDropdown.click();
			statusFilterDropdownTextField.sendKeys("Docusign");
			WaitClass.waitForTime(1000);
			dropdownFirstOption.click();
			pageDive.click();
			WaitClass.waitForTime(1000);
			driver.findElement(By.xpath("(//div[@class='icon cursor-pointer'])[1]")).click();
			WaitClass.waitForTime(1000);
			boolean flag = driver.findElement(By.xpath("//h4[text()='General Information']")).isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Edit_Profile_Partner, Method - navigateToPartnerDetailManualApprove : " + e);
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
			suggestionModificationCancelButton.click();
			suggestionModificationGeneralInfo.click();
			flag = flag && suggestionModificationPopupHeader.isDisplayed();
			suggestionModificationSaveButton.click();
			WaitClass.waitForTime(2000);
			flag = flag && blankTextAreaValidationMessage.isDisplayed();
			WaitClass.waitForTime(2000);
			suggestionModificationTextArea.sendKeys("Update general Information");
			suggestionModificationSaveButton.click();
			flag = flag && editSuggestionButton1.isDisplayed();
			return flag;
			}
			else if(contactInfo == true) {
				suggestionModificationContactInfo.click();
				boolean flag = suggestionModificationPopupHeader.isDisplayed();
				suggestionModificationTextArea.sendKeys("Update contact Information");
				suggestionModificationCancelButton.click();
				suggestionModificationContactInfo.click();
				flag = flag && suggestionModificationPopupHeader.isDisplayed();
				suggestionModificationSaveButton.click();
				WaitClass.waitForTime(2000);
				flag = flag && blankTextAreaValidationMessage.isDisplayed();
				WaitClass.waitForTime(2000);
				suggestionModificationTextArea.sendKeys("Update contact Information");
				suggestionModificationSaveButton.click();
				flag = flag && editSuggestionButton2.isDisplayed();
				return flag;
			}
			else if(otherInfo == true) {
				suggestionModificationOtherInfo.click();
				boolean flag = suggestionModificationPopupHeader.isDisplayed();
				suggestionModificationTextArea.sendKeys("Update other Information");
				suggestionModificationCancelButton.click();
				suggestionModificationOtherInfo.click();
				flag = flag && suggestionModificationPopupHeader.isDisplayed();
				suggestionModificationSaveButton.click();
				WaitClass.waitForTime(2000);
				flag = flag && blankTextAreaValidationMessage.isDisplayed();
				WaitClass.waitForTime(2000);
				suggestionModificationTextArea.sendKeys("Update other Information");
				suggestionModificationSaveButton.click();
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
	public boolean sendModificationBlankValidation() {
		try {
			sendSuggestionButton.click();
			boolean flag = suggestToastMessage.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Edit_Profile_Partner, Method - sendModificationBlankValidation : " + e);
			return false;
		}
	}
	
	/**
	 * Description - Validating accept and confirm button.
	 * @return - true - if accept and confirm button works correctly.
	 */
	public boolean validateAcceptAndConfirmButton() {
		try {
			acceptAndConfirmButton.click();
			boolean flag = driver.findElement(By.xpath("//h2[text()='DocuSign Envelope ID']")).isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Edit_Profile_Partner, Method - validateAcceptAndConfirmButton : " + e);
			return false;
		}
	}
	
	/**
	 * Description - Envelope ID submission validation.
	 * @return - true - Envelope Id submitted successfully.
	 */
	public boolean envelopeIdSubmission() {
		try {
			acceptAndConfirmButton.click();
			WaitClass.waitForTime(1000);
			envelopeIdTextField.sendKeys("12345");
			envelopeIdpopupSubmitButton.click();
			WaitClass.waitForTime(1000);
			boolean flag = approveManuallyButton.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Edit_Profile_Partner, Method - envelopeIdSubmission : " + e);
			return false;
		}
	}
	
	/**
	 * Description - Validate docuSign email sent to partner.
	 * @return - true - if docuSign sent to partner.
	 */
	public boolean docuSignValidateEmail(String email) {
		try {
			String docuSignURLFetched = code.getEmailData(email, "body > em", 2);
			return docuSignURLFetched.length()>0;
		} catch (Exception e) {
			System.err.println("Exception in Class - Edit_Profile_Partner, Method - docuSignValidateEmail : " + e);
			return false;
		}
	}
	
	/**
	 * Description - Validating Approve manually button.
	 * @return - true - if successfully approved the partner.
	 */
	public boolean approveMannuallyButtonFlow() {
		try {
			approveManuallyButton.click();
			boolean flag = approveManuallyPopupHeader.isDisplayed();
			flag = flag && approveManuallyPopupText.isDisplayed();
			approveManuallyPopupCancel.click();
			WaitClass.waitForTime(1000);
			approveManuallyButton.click();
			approveManuallyPopupConfirm.click();
			flag = flag && driver.findElement(By.xpath("//div[text()='Partner approved successfully']")).isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Edit_Profile_Partner, Method - approveMannuallyButtonFlow : " + e);
			return false;
		}
	}
	
	/**
	 * Description - Validating approved partner status.
	 * @return - true - if status is approved.
	 */
	public boolean approvedPartnerStatusValidate(String partnerEmail) {
		try {
			searchInputField.sendKeys(partnerEmail);
			WaitClass.waitForTime(1000);
			boolean flag = driver.findElement(By.xpath("(//div[@class='table-row']/div[text()='Approved'])[1]")).isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Edit_Profile_Partner, Method - approvedPartnerStatusValidate : " + e);
			return false;
		}
	}

}


