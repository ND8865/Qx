package PageObjectClasses;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class SignUp_CreateAccount_Partner_Page {
	WebDriver driver;
	SoftAssert softassert;

	public SignUp_CreateAccount_Partner_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		softassert = new SoftAssert();
	}

	@FindBy(xpath = "//button[@id='radix-2-trigger-1']")
	private WebElement CreateAccountButton;
	@FindBy(xpath = "//label[text()='Name *']")
	private WebElement NameHeader;
	@FindBy(xpath = "//input[@placeholder='Enter your full name']")
	private WebElement NameFiled;
	@FindBy(xpath = "//label[text()='Username *']")
	private WebElement UserNameHeader;
	@FindBy(xpath = "//input[@placeholder='Enter your username']")
	private WebElement UserNamefield;
	@FindBy(xpath = "//label[text()='Email *']")
	private WebElement EmailHeader;
	@FindBy(xpath = "//input[@placeholder='Enter your email address']")
	private WebElement EmailField;
	@FindBy(xpath = "//label[text()='Password *']")
	private WebElement PasswordHeader;
	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	private WebElement PasswordField;
	@FindBy(xpath = "//label[text()='Confirm Password *']")
	private WebElement ConfimPasswordHeader;
	@FindBy(xpath = "//input[@placeholder='Enter confirm password']")
	private WebElement ConfimPasswordfield;
	@FindBy(xpath = "(//button[@class='amplify-button amplify-field-group__control amplify-field__show-password'])[1]")
	private WebElement PasswordEyeButton;
	@FindBy(xpath = "(//button[@class='amplify-button amplify-field-group__control amplify-field__show-password'])[2]")
	private WebElement ConfirmPasswordEyeButton;
	@FindBy(xpath = "(//button[text()='Create Account'])[2]")
	private WebElement CreateAccountGreenButton;
	@FindBy(xpath = "//input[@placeholder='Enter your code']")
	private WebElement verificationCodefield;
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	private WebElement confirmAccountButton;
	@FindBy(xpath = "//button[text()='Resend Code']")
	private WebElement ResendCode;
	

	/**
	 * Description - Verify that Create Account button is click able or not on
	 * Partner Sign IN Page.
	 * 
	 * @return -true- if Create Account button is Click Able
	 * 
	 */
	public boolean CreateAccountButtonClick() {
		try {
			WaitClass.waitForTime(1000);
			CreateAccountButton.click();
			WaitClass.waitForTime(1000);
			return true;
		} catch (Exception e) {
			System.err.println(
					"Exception in Method - CreateAccountButtonClick, Class - SignUp_CreateAccount_Partner_Page : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify that All WebElement Are Visible on Partner Create
	 * Account Sign Page . .
	 * 
	 * @return - True - If all Web Elements are visible.
	 */
	public boolean AllWebElementDisplayedPartnerCreateAccount() {

		try {

			boolean flag = CreateAccountButton.isDisplayed();
			flag = flag && NameHeader.isDisplayed();
			flag = NameFiled.isDisplayed();
			flag = flag && UserNameHeader.isDisplayed();
			flag = flag && UserNamefield.isDisplayed();
			flag = flag && EmailHeader.isDisplayed();
			flag = flag && EmailField.isDisplayed();
			flag = flag && PasswordHeader.isDisplayed();
			flag = flag && PasswordField.isDisplayed();
			flag = flag && ConfimPasswordHeader.isDisplayed();
			flag = flag && ConfimPasswordfield.isDisplayed();
			flag = flag && PasswordEyeButton.isDisplayed();
			flag = flag && ConfirmPasswordEyeButton.isDisplayed();
			flag = flag && CreateAccountGreenButton.isDisplayed();
			return flag;
		} catch (Exception e) {

			System.err.println(
					"Exception in Method - AllWebElementDisplayedPartnerCreateAccount, Class - SignUp_CreateAccount_Partner_Page : "
							+ e);
			return false;
		}
	}

	/**
	 * Method to perform Validation for Sign Up Create Account on Partner .
	 * 
	 * @param boolean BlankName , BlankUsername, BlankEmail, BlankPassword,
	 *                BlankConfirmPassword , WrongCredentials
	 * @param
	 * @return - True if Validation is Successful
	 */
	public boolean ValidateCreateAccountSignUp(boolean blankName, boolean BlankUserName, boolean BlankEmail,
			boolean blankPassword, boolean blankConfirmPassord, boolean WrongCredentials) {

		try {
			if (blankName == true) {
				NameFiled.clear();
				CreateAccountGreenButton.click();
				String extractedValidation = NameFiled.getAttribute("validationMessage");
				String validation = "Please fill in this field.";
				softassert.assertEquals(extractedValidation, validation);
				softassert.assertAll();
			}

			if (BlankUserName == true) {
				UserNamefield.click();
				UserNamefield.clear();
				CreateAccountGreenButton.click();
				String extractedValidation = UserNamefield.getAttribute("validationMessage");
				String validation = "Please fill in this field.";
				softassert.assertEquals(extractedValidation, validation);
				softassert.assertAll();
			}
			if (BlankEmail == true) {
				EmailField.clear();
				CreateAccountGreenButton.click();
				String extractedValidation = EmailField.getAttribute("validationMessage");
				String validation = "Please fill in this field.";
				softassert.assertEquals(extractedValidation, validation);
				softassert.assertAll();
			}
			if (blankPassword == true) {
				PasswordField.clear();
				CreateAccountGreenButton.click();
				String extractedValidation = PasswordField.getAttribute("validationMessage");
				String validation = "Please fill in this field.";
				softassert.assertEquals(extractedValidation, validation);
				softassert.assertAll();
			}
			if (blankConfirmPassord == true) {
				ConfimPasswordfield.clear();
				CreateAccountGreenButton.click();
				String extractedValidation = ConfimPasswordfield.getAttribute("validationMessage");
				String validation = "Please fill in this field.";
				softassert.assertEquals(extractedValidation, validation);
				softassert.assertAll();
			}

			if (WrongCredentials == true) {
				WaitClass.waitForTime(1000);
				NameFiled.clear();
				WaitClass.waitForTime(1000);
				NameFiled.sendKeys("Partner.ac");
				WaitClass.waitForTime(1000);
				UserNamefield.clear();
				WaitClass.waitForTime(1000);
				UserNamefield.sendKeys("Partner@ac");
				WaitClass.waitForTime(1000);
				EmailField.clear();
				WaitClass.waitForTime(1000);
				EmailField.sendKeys("Partner.yopmail.com");
				WaitClass.waitForTime(1000);
				PasswordField.clear();
				WaitClass.waitForTime(1000);
				PasswordField.sendKeys("Partner@12345678");
				WaitClass.waitForTime(1000);
				ConfimPasswordfield.clear();
				WaitClass.waitForTime(1000);
				ConfimPasswordfield.sendKeys("Partner@12345678");
				WaitClass.waitForTime(1000);
				CreateAccountGreenButton.click();
				WaitClass.waitForTime(1000);
				String Expected = driver.findElement(By.xpath("//div[@class='amplify-alert__body']")).getText();
				String Actual = "Invalid email address format.";
				softassert.assertEquals(Actual, Expected);
				softassert.assertAll();
			}
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Method - ValidateSignIn, Class - SignIn_Partner_Pages : " + e);
			return false;
		}
	}
	
	/**
	 * Description - Verify that SignUp or Create Account is Successfully Created
	 * Partner Sign IN Page.
	 * 
	 * @return -true-If Sign Up or Create Account is Successfully Created
	 * 
	 */
	public boolean SignUp() {
		try {
			ArrayList<String> expecteddata = new ArrayList<String>();
			ArrayList<String> actualdata = new ArrayList<String>();

			NameFiled.sendKeys(Utility.getPropertiesFile("primaryLogin", "Name"));
			WaitClass.waitForTime(1000);
			UserNamefield.sendKeys(Utility.getPropertiesFile("primaryLogin", "UserName"));
			WaitClass.waitForTime(1000);
			EmailField.sendKeys(Utility.getPropertiesFile("primaryLogin", "Email"));
			WaitClass.waitForTime(1000);
			PasswordField.sendKeys(Utility.getPropertiesFile("primaryLogin", "Password"));
			WaitClass.waitForTime(1000);
			ConfimPasswordfield.sendKeys(Utility.getPropertiesFile("primaryLogin", "ConfirmPassword"));
			expecteddata.add(Utility.getPropertiesFile("primaryLogin", "Name"));
			expecteddata.add(Utility.getPropertiesFile("primaryLogin", "UserName"));
			expecteddata.add(Utility.getPropertiesFile("primaryLogin", "Email"));
			expecteddata.add(Utility.getPropertiesFile("primaryLogin", "Password"));
			expecteddata.add(Utility.getPropertiesFile("primaryLogin", "ConfirmPassword"));
			WebElement fullname = driver.findElement(By.xpath("//input[@placeholder='Enter your full name']"));
			String name = fullname.getAttribute("value");
			actualdata.add(name);
			WebElement UserName = driver.findElement(By.xpath("//input[@placeholder='Enter your username']"));
			String Uname = UserName.getAttribute("value");
			actualdata.add(Uname);
			WebElement Email = driver.findElement(By.xpath("//input[@placeholder='Enter your email address']"));
			String Emailadd = Email.getAttribute("value");
			actualdata.add(Emailadd);
			WebElement password = driver.findElement(By.xpath("//input[@placeholder='Enter your password']"));
			String pass = password.getAttribute("value");
			actualdata.add(pass);
			WebElement Confirmpassword = driver.findElement(By.xpath("//input[@placeholder='Enter confirm password']"));
			String confirmpass = Confirmpassword.getAttribute("value");
			actualdata.add(confirmpass);
			for (String A : actualdata) {
				for (String B : expecteddata) {

					softassert.assertEquals(A, B);
					expecteddata.remove(B);
					break;
				}

			}
			softassert.assertAll();
			Utility.javaScriptClick(PasswordEyeButton, driver);
			WebElement password1 = driver.findElement(By.xpath("//input[@placeholder='Enter your password']"));
			String actual = password1.getAttribute("value");
			String expected = Utility.getPropertiesFile("primaryLogin", "Password");
			Utility.javaScriptClick(ConfirmPasswordEyeButton, driver);
			WebElement Confirmpassword1 = driver.findElement(By.xpath("//input[@placeholder='Enter confirm password']"));
			String actualtwo = Confirmpassword1.getAttribute("value");
			String expectedtwo = Utility.getPropertiesFile("primaryLogin", "ConfirmPassword");
			softassert.assertEquals(actual, expected);
			softassert.assertNotEquals(actualtwo, expectedtwo);
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Method - SignUp, Class - SignUp_CreateAccount_Partner_Page : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify that SignUp or Create Account is Successfully Created
	 * Partner Sign IN Page.
	 * 
	 * @return -true-If Sign Up or Create Account is Successfully Created
	 * 
	 */
	public boolean SignUpCreateAccount(String Name ,String UserName, String Email, String password, String confirmpassword) {
		try {
			
			NameFiled.clear();
			NameFiled.sendKeys(Name);
			UserNamefield.clear();
			UserNamefield.sendKeys(UserName);
			EmailField.clear();
			EmailField.sendKeys(Email);
			PasswordField.clear();
			PasswordField.sendKeys(password);
			ConfimPasswordfield.clear();
			ConfimPasswordfield.sendKeys(confirmpassword);
			Utility.javaScriptClick(CreateAccountGreenButton, driver);
			WaitClass.waitForTime(6000);
			return true;
		} catch (Exception e) {
			System.err.println(
					"Exception in Method - SignUpCreateAccount, Class - SignUp_CreateAccount_Partner_Page : " + e);
			return false;
		}

	}
	/**
	 * Description - Checking user landing on dashboard after successful signup.
	 * @param code - Code sent to email for confirmation.
	 * @return True - if user land on dashboard.
	 */
	public boolean ConfirmAccount(String code) {

		try {
			verificationCodefield.clear();
			verificationCodefield.sendKeys(code);
			confirmAccountButton.click();
	
			return true;
		} catch (Exception e) {
			System.err.println("Exception in method - ConfirmAccount, class - SignUp_CreateAccount_Partner_Page :" + e);
			return false;
		}
}
	/**
	 * Description - Checking user landing on dashboard after successful signup after resend the code.
	 * @param code - Code sent to email for confirmation.
	 * @return True - if user land on dashboard.
	 */
	public boolean ConfirmAccountResend(String code) {

		try {
			verificationCodefield.clear();
			verificationCodefield.sendKeys(code);
			ResendCode.click();
			verificationCodefield.clear();
			verificationCodefield.sendKeys(code);
			confirmAccountButton.click();
	
			return true;
		} catch (Exception e) {
			System.err.println("Exception in method - ConfirmAccount, class - SignUp_CreateAccount_Partner_Page :" + e);
			return false;
		}
}



}
