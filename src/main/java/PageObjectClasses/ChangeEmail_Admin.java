package PageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.WaitClass;

public class ChangeEmail_Admin {
	
	WebDriver driver;
	MailBox code;
		
		public ChangeEmail_Admin(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			code = new MailBox();
			
		}
		
		@FindBy(xpath = "//span[text()='Settings']")
		private WebElement settingsTab;

		@FindBy(xpath = "//div[text()='Account Details']")
		private WebElement settingAccountDetailsText;
		
		@FindBy(xpath = "//span[text()='Change Password']")
		private WebElement changePasswordTab;
		
		@FindBy(xpath = "//div[text()='Change Password']")
		private WebElement changePasswordHeader;
		
		@FindBy(xpath = "//input[@data-testid='emailupdate' and @disabled]")
		private WebElement emailUpdateField;
		
		@FindBy(xpath = "//button[text()='Change']")
		private WebElement emailChangeButton;
		
		@FindBy(xpath = "//h2[text()='Change Email Address']")
		private WebElement popupHeader;
		
		@FindBy(xpath = "//button[text()='Confirm']")
		private WebElement confirmButton;
		
		@FindBy(xpath = "//div[text()='Please enter email address.']")
		private WebElement blankFieldValidationText;
		
		@FindBy(xpath = "//div[text()='Please enter valid email address.']")
		private WebElement invalidEmailValidationtext;
		
		@FindBy(xpath = "//input[@data-testid='newEmail']")
		private WebElement emailInputfield;
		
		@FindBy(xpath = "//h2[text()='Verification Code']")
		private WebElement enterVerificationCodePopup;
		
		@FindBy(xpath = "//p/span[@class='text-green']")
		private WebElement verificationPopupEmail;
		
		@FindBy(xpath = "//input[@data-testid='verification']")
		private WebElement verificationCodeInputfields;
		
		@FindBy(xpath = "//button[text()='Cancel']")
		private WebElement cancelButton;
		
		@FindBy(xpath = "//div[text()='Please enter verification code.']")
		private WebElement blankCodevalidationText;
		
		@FindBy(xpath = "//div[text()='Invalid verification code provided, please try again.']")
		private WebElement invalidCodeMessage;
		
		@FindBy(xpath = "//div[text()='Your email address changed successfully']")
		private WebElement changeEmailSuccessMessage;
		
		
		
		/**
		 * Description - Validating all cancel buttons.
		 * @return - true - if admin lands successfully on setting page.
		 */
		public boolean validateCancelButtons() {
			try {
				emailChangeButton.click();
				WaitClass.waitForTime(1000);
				cancelButton.click();
				boolean flag = changePasswordHeader.isDisplayed();
				emailChangeButton.click();
				WaitClass.waitForTime(1000);
				emailInputfield.sendKeys("test1212@yopmail.com");
				confirmButton.click();
				WaitClass.waitForTime(3000);
				flag = flag && enterVerificationCodePopup.isDisplayed();
				WaitClass.waitForTime(1000);
				cancelButton.click();
				flag = flag && changePasswordHeader.isDisplayed();
				return flag ;
			} catch (Exception e) {
				System.err.println("Exception in Class - ChangeEmail_Admin, Method - validateCancelButtons : " + e);
				return false;
			}
		}
		
		
		/**
		 * Description - Navigating to setting page.
		 * @return - true - if admin lands successfully on setting page.
		 */
		public boolean navigateToSettingPage() {
			try {
				boolean flag = settingsTab.isDisplayed();
				settingsTab.click();
				WaitClass.waitForTime(1000);
				flag = flag && settingAccountDetailsText.isDisplayed();
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - ChangeEmail_Admin, Method - navigateToSettingPage : " + e);
				return false;
			}
		}
		
		/**
		 * Description - validating email change field and update button visible on change password page.
		 * @return - true - if all elements are visible.
		 */
		public boolean validateEmailFieldChangePasswordPage() {
			try {
				boolean flag = emailUpdateField.isDisplayed();
				flag = flag && emailChangeButton.isDisplayed();
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - ChangeEmail_Admin, Method - validateEmailFieldChangePasswordPage : " + e);
				return false;
			}
		}
		
		/**
		 * Description - Validating email field is disabled and showing correct email.
		 * @return - true - if showing correct email and field is disabled.
		 */
		public boolean ValidateEmailFieldData(String emailAdmin) {
			try {
				WaitClass.waitForTime(1000);
				String fetchedEmail = emailUpdateField.getAttribute("value");
				boolean flag2 = (fetchedEmail).equals(emailAdmin);
				return (flag2);
			} catch (Exception e) {
				System.err.println("Exception in Class - ChangeEmail_Admin, Method - ValidateEmailFieldData : " + e);
				return false;
			}
		}
		
		/**
		 * Description - Validating email field change pop-up.
		 * @return - true - if pop-up shows correctly.
		 */
		public boolean ValidateEmailFieldChangePopup() {
			try {
				emailChangeButton.click();
				WaitClass.waitForTime(1000);
				return popupHeader.isDisplayed();
			} catch (Exception e) {
				System.err.println("Exception in Class - ChangeEmail_Admin, Method - ValidateEmailFieldChangePopup : " + e);
				return false;
			}
		}
		
		/**
		 *  Description - validating blank and incorrect validation on change password pop-up.
		 * @param blankEmailFields - Takes true for blank field validation.
		 * @param invalidEmailField - Takes true for invalid current password validation.
		 * @return - true if validation validated successfully.
		 */
		public boolean validateEmailFieldsValidation(boolean blankEmailField, boolean invalidEmailField) {
			try {
				if(blankEmailField==true) {
					confirmButton.click();
					WaitClass.waitForTime(2000);
					return 	blankFieldValidationText.isDisplayed();
				}
				else if(invalidEmailField==true) {
					emailInputfield.sendKeys("Test");
					confirmButton.click();
					WaitClass.waitForTime(2000);
					return 	invalidEmailValidationtext.isDisplayed();
				}
				return false;
			} catch (Exception e) {
				System.err.println("Exception in Class - ChangeEmail_Admin, Method - validateEmailFieldsValidation : " + e);
				return false;
			}
		}
		
		/**
		 * Description - Validating email field confirm button flow.
		 * @return - true - if confirm button working correctly.
		 */
		public boolean ValidateEmailFieldConfirmButton(String newAdminEmail) {
			try {
				emailInputfield.sendKeys(newAdminEmail);
				confirmButton.click();
				WaitClass.waitForTime(3000);
				boolean flag = enterVerificationCodePopup.isDisplayed();
				flag = flag && verificationCodeInputfields.isDisplayed();
				flag = flag && confirmButton.isDisplayed();
				flag = flag && cancelButton.isDisplayed();
				flag = flag && (newAdminEmail).equals(verificationPopupEmail.getText());
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - ChangeEmail_Admin, Method - ValidateEmailFieldConfirmButton : " + e);
				return false;
			}
		}
		
		/**
		 *  Description - validating blank and incorrect verification code on change password.
		 * @param blankCodeField - Takes true for blank field validation.
		 * @param invalidCode - Takes true for invalid verification code validation.
		 * @return - true if validation validated successfully.
		 */
		public boolean validateVerificationCodeValidation(boolean blankCodeField, boolean invalidCode) {
			try {
				if(blankCodeField==true) {
					confirmButton.click();
					WaitClass.waitForTime(2000);
					return 	blankCodevalidationText.isDisplayed();
				}
				else if(invalidCode==true) {
					verificationCodeInputfields.sendKeys("12345");
					confirmButton.click();
					WaitClass.waitForTime(1000);
					return 	invalidCodeMessage.isDisplayed();
				}
				return false;
			} catch (Exception e) {
				System.err.println("Exception in Class - ChangeEmail_Admin, Method - validateVerificationCodeValidation : " + e);
				return false;
			}
		}
		
		
		@FindBy(xpath = "//input[@placeholder='Enter your username']")
		private WebElement UserNameField;
		
		@FindBy(xpath = "//input[@placeholder='Enter your password']")
		private WebElement PasswordField;
		
		@FindBy(xpath = "//button[text()='Sign in']")
		private WebElement SignInGreenButton;
		
		@FindBy(xpath = "//button[text()='Skip']")
		private WebElement skipButton;
		
		
		/**
		 * Method to perform sign in actions.
		 * 
		 * @param username
		 * @param password
		 * @return - true if all the actions are performed.
		 */
		public boolean signinActionAdminSkip(String username, String password) {
			UserNameField.clear();
			try {
				if (username.length() > 0) {
					UserNameField.sendKeys(username);
				}
				PasswordField.clear();
				if (password.length() > 0) {
					PasswordField.sendKeys(password);
				}
				SignInGreenButton.click();
				WaitClass.waitForTime(2000);
				skipButton.click();
				boolean Landonpage = driver.findElement(By.xpath("//div[@class='logo-box']//img[@alt='logo']"))
						.isDisplayed();
				WaitClass.waitForTime(10000);
				return true && Landonpage;
			} catch (Exception e) {
				System.err.println("Exception in Method - signinActionAdminSkip, Class - ChangeEmail_Admin : " + e);
				return false;
			}
		}
		
		/**
		 * Description - Validating correct verification code.
		 * @return - true - if email changed successfully.
		 */
		public boolean ValidateValidVerificationCode(String verificationCode) {
			try {
				verificationCodeInputfields.sendKeys(verificationCode);
				confirmButton.click();
				return 	changeEmailSuccessMessage.isDisplayed();
			} catch (Exception e) {
				System.err.println("Exception in Class - ChangeEmail_Admin, Method - ValidateValidVerificationCode : " + e);
				return false;
			}
		}

}
