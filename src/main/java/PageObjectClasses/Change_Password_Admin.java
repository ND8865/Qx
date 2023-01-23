package PageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Change_Password_Admin {
	
	WebDriver driver;
	
	public Change_Password_Admin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//span[text()='Settings']")
	private WebElement settingsTab;

	@FindBy(xpath = "//h4[text()='Settings']")
	private WebElement settingPageHeader;
	
	@FindBy(xpath = "//div[text()='Change Password']")
	private WebElement changePasswordHeader;
	
	@FindBy(xpath = "//label[text()='Current Password']")
	private WebElement currentPasswordLabel;
	
	@FindBy(xpath = "//input[@name='currentPassword']")
	private WebElement currentPasswordField;
	
	@FindBy(xpath = "(//button[@class='btn btn-text btn-password-toggle'])[1]")
	private WebElement currentPasswordHideButton;
	
	@FindBy(xpath = "//label[text()='New Password']")
	private WebElement newPasswordLabel;
	
	@FindBy(xpath = "//input[@name='newPassword']")
	private WebElement newPasswordField;
	
	@FindBy(xpath = "(//button[@class='btn btn-text btn-password-toggle'])[2]")
	private WebElement newPasswordHideButton;
	
	@FindBy(xpath = "//label[text()='Confirm New Password']")
	private WebElement confirmPasswordLabel;
	
	@FindBy(xpath = "//input[@name='confirmPassword']")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath = "(//button[@class='btn btn-text btn-password-toggle'])[3]")
	private WebElement confirmPasswordHideButton;
	
	@FindBy(xpath = "//div[text()='Please enter current password.']")
	private WebElement currentPasswordBlankValidationText;
	
	@FindBy(xpath = "//div[text()='Please enter new password.']")
	private WebElement newPasswordBlankValidationText;
	
	@FindBy(xpath = "//div[text()='Please enter confirm password.']")
	private WebElement confirmPasswordBlankValidationText;
	
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement updateButton;
	
	

	/**
	 * Description - Navigating to setting page.
	 * @return - true - if admin lands successfully on setting page.
	 */
	public boolean navigateToSetting() {
		try {
			boolean flag = settingsTab.isDisplayed();
			settingsTab.click();
			flag = flag && settingPageHeader.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Change_Password_Admin, Method - navigateToSetting : " + e);
			return false;
		}
	}

	/**
	 * Description - validating all contents are visible on the change password page.
	 * @return - true - if all elements are visible.
	 */
	public boolean validateAllElementsChangePasswordPage() {
		try {
			boolean flag = settingPageHeader.isDisplayed();
			flag = flag && changePasswordHeader.isDisplayed();
			flag = flag && currentPasswordLabel.isDisplayed();
			flag = flag && currentPasswordField.isDisplayed();
			flag = flag && currentPasswordHideButton.isDisplayed();
			flag = flag && newPasswordLabel.isDisplayed();
			flag = flag && newPasswordField.isDisplayed();
			flag = flag && newPasswordHideButton.isDisplayed();
			flag = flag && confirmPasswordLabel.isDisplayed();
			flag = flag && confirmPasswordField.isDisplayed();
			flag = flag && confirmPasswordHideButton.isDisplayed();
			flag = flag && updateButton.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Change_Password_Admin, Method - validateAllElementsChangePasswordPage : " + e);
			return false;
		}
	}
	

	/**
	 *  Description - validating all password fields on change password page.
	 * @param blankFields - Takes true for blank field validation.
	 * @param invalidCurrentPassword - Takes true for invalid current password validation.
	 * @param confirmPasswordMismatch - Takes true for mismatch confirm password.
	 * @return - true if validation validated successfully.
	 */
	public boolean validateFieldsValidation(boolean blankFields, boolean invalidCurrentPassword, boolean confirmPasswordMismatch) {
		try {
			if(blankFields==true) {
				updateButton.click();
				WaitClass.waitForTime(2000);
				boolean flag = currentPasswordBlankValidationText.isDisplayed();
				flag = flag && newPasswordBlankValidationText.isDisplayed();
				flag = flag && confirmPasswordBlankValidationText.isDisplayed();
				return flag;	
			}
			else if(invalidCurrentPassword==true) {
				currentPasswordField.sendKeys("Test@123456789");
				newPasswordField.sendKeys("Qwerty@123456789");
				confirmPasswordField.sendKeys("Qwerty@123456789");
				WaitClass.waitForTime(2000);
				updateButton.click();
				return driver.findElement(By.xpath("//div[text()='Incorrect username or password.']")).isDisplayed();
				
			}
			else if(confirmPasswordMismatch==true) {
				currentPasswordField.sendKeys("Qwerty@12345678");
				newPasswordField.sendKeys("Qwerty@12345678");
				confirmPasswordField.sendKeys("Qwerty@123456789");
				WaitClass.waitForTime(1000);
				return driver.findElement(By.xpath("//div[text()='New password and confirm password do not match.']")).isDisplayed();
				
			}
			return false;
		} catch (Exception e) {
			System.err.println("Exception in Class - Change_Password_Admin, Method - validateFieldsValidation : " + e);
			return false;
		}
	}
	

	/**
	 *  Description - validating positive flow of the change password.
	 * @param currentPassword - Takes true for current password field filling process.
	 * @param newAndConfirmPasswordfields - Takes true for new and confirm password field filling process.
	 * @param filledAllFields - Takes true for for correct changes password flow.
	 * @return - true if validation validated successfully.
	 */
	public boolean changePasswordAction(boolean currentPassword, boolean newAndConfirmPasswordfields, boolean filledAllFields) {
		try {
			if(currentPassword==true) {
				updateButton.click();
				WaitClass.waitForTime(2000);
				currentPasswordField.sendKeys("Qwerty@12345678");
				boolean flag = newPasswordBlankValidationText.isDisplayed();
				flag = flag && confirmPasswordBlankValidationText.isDisplayed();
				return flag;	
			}
			
			else if(newAndConfirmPasswordfields==true) {
				newPasswordField.sendKeys("Qwerty@12345678");
				confirmPasswordField.sendKeys("Qwerty@12345678");
				WaitClass.waitForTime(1000);
				updateButton.click();
				WaitClass.waitForTime(1000);
				return currentPasswordBlankValidationText.isDisplayed();
				
			}
			else if(filledAllFields==true) {
				String count = Utility.getPropertiesFile("testDataVariables", "adminPasswordCount");
				int c = Integer.parseInt(count)+1;
				String NewPassword = "Qwerty@12345678"+c; 
				currentPasswordField.clear();
				newPasswordField.clear();
				confirmPasswordField.clear();
				currentPasswordField.sendKeys("Qwerty@12345678");
				newPasswordField.sendKeys(NewPassword);
				confirmPasswordField.sendKeys(NewPassword);
				WaitClass.waitForTime(2000);
				updateButton.click();
				return driver.findElement(By.xpath("//div[text()='Your password changed successfully']")).isDisplayed();
			}
			return false;
		} catch (Exception e) {
			System.err.println("Exception in Class - Change_Password_Admin, Method - changePasswordAction : " + e);
			return false;
		}
	}

}
