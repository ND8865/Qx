package PageObjectClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class SignUp_Gamers {

	private WebDriver driver;

	public SignUp_Gamers(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}
	
	@FindBy(xpath = "(//a[text() = 'Sign up'])[2]")
	private WebElement signUpLinkOnLogin;

	@FindBy(xpath = "(//img[@class='logo-customizable'])[1]")
	private WebElement logo;

	@FindBy(xpath = "(//span[@class='textDescription-customizable '])[1]")
	private WebElement SignUpMsg;

	@FindBy(xpath = "(//label[@class='label-customizable'])[1]")
	private WebElement UserNameFieldHeader;

	@FindBy(xpath = "(//input[@name='username'])[1]")
	private WebElement UserNameField;

	@FindBy(xpath = "(//label[@class='label-customizable'])[2]")
	private WebElement EmailFieldHeader;

	@FindBy(xpath = "(//input[@type='email'])[1]")
	private WebElement EmailField;

	@FindBy(xpath = "(//label[@class='label-customizable'])[3]")
	private WebElement PasswordFieldHeader;

	@FindBy(xpath = "(//input[@name='password'])[1]")
	private WebElement PasswordField;

	@FindBy(xpath = "(//button[@name='signUpButton'])[1]")
	private WebElement SignUpButton;

	@FindBy(xpath = "(//p[@class='redirect-customizable']/span)[1]")
	private WebElement SignInMsg;

	@FindBy(xpath = "(//a[@href])[1]")
	private WebElement SignInLink;

	@FindBy(xpath = "(//span[@class='idpDescription-customizable'])[1]")
	private WebElement SocialSignUpMsg;

	@FindBy(xpath = "(//span[@class='legalText-customizable'])[1]")
	private WebElement SocialSignUpBottomMsg;
	
	@FindBy(xpath = "(//button[@name='googleSignUpButton'])[1]")
	private WebElement continueWithGoogle;
	
	// Password Validation Cross Symbols
	@FindBy(xpath = "((//form)[1]//span[text() = '✖'])[1]")
	private WebElement Cross1;

	@FindBy(xpath = "((//form)[1]//span[text() = '✖'])[2]")
	private WebElement Cross2;

	@FindBy(xpath = "((//form)[1]//span[text() = '✖'])[3]")
	private WebElement Cross3;

	@FindBy(xpath = "((//form)[1]//span[text() = '✖'])[4]")
	private WebElement Cross4;

	@FindBy(xpath = "((//form)[1]//span[text() = '✖'])[5]")
	private WebElement Cross5;

	// Password Validation Tick Symbols
	@FindBy(xpath = "((//form)[1]//span[text() = '✓'])[1]")
	private WebElement Tick1;

	@FindBy(xpath = "((//form)[1]//span[text() = '✓'])[2]")
	private WebElement Tick2;

	@FindBy(xpath = "((//form)[1]//span[text() = '✓'])[3]")
	private WebElement Tick3;

	@FindBy(xpath = "((//form)[1]//span[text() = '✓'])[4]")
	private WebElement Tick4;

	@FindBy(xpath = "((//form)[1]//span[text() = '✓'])[5]")
	private WebElement Tick5;

	// Password Validation Msgs
	@FindBy(xpath = "(//span[@class='checkPasswordText-lowerletter'])[1]")
	private WebElement LowerLetterMsg;

	@FindBy(xpath = "(//span[@class='checkPasswordText-upperletter'])[1]")
	private WebElement UpperLetterMsg;

	@FindBy(xpath = "(//span[@class='checkPasswordText-symbols'])[1]")
	private WebElement SymbolsMsg;

	@FindBy(xpath = "(//span[@class='checkPasswordText-numbers'])[1]")
	private WebElement NumbersMsg;

	@FindBy(xpath = "(//span[@class='checkPasswordText-length'])[1]")
	private WebElement LengthMsg;
	
	//Confirm Account page elements
	
	@FindBy(xpath = "//img[@class='logo-customizable']")
	private WebElement confirmAccountLogo;
	
	@FindBy(xpath = "//label[text()='Verification Code']")
	private WebElement verificationCodeHeader;
	
	@FindBy(xpath = "//input[@id='verification_code']")
	private WebElement verificationCodefield;
	
	@FindBy(xpath = "//button[@name='confirm']")
	private WebElement confirmAccountButton;
	
	@FindBy(xpath = "//p/span")
	private WebElement codeReceiveMsg;
	
	@FindBy(xpath = "//button[@name='resend']")
	private WebElement codeResendLink;
	
	@FindBy(xpath = "//p[@id='errorMessage']")
	private WebElement wrongCodeMsg;
	
	//Dashboard element
	
	@FindBy(xpath = "//h4[@class='jss17']")
	private WebElement dashboardText;
	
	// T&C Acceptance
	@FindBy(xpath = "//div[@class = 'modal-content']")
	private WebElement popupBox;
	
	@FindBy(xpath = "//div[contains(@class, 'modal-title')]")
	private WebElement popupHeading;
	
	@FindBy(xpath = "//button[text() = 'Close']")
	private WebElement closeButton;
	
	@FindBy(xpath = "//input[@id = 'formFirstName']")
	private WebElement formFirstName;
	
	@FindBy(xpath = "//input[@id = 'formLastName']")
	private WebElement formLastName;
	
	@FindBy(xpath = "//label[@class = 'form-check-label']")
	private WebElement tandcCheckbox;
	
	@FindBy(xpath = "//button[text() = 'Update']")
	private WebElement updateButton;
	
	/**
	 * Description - To navigate signup page
	 */
	public boolean sighUpLinkClick() {

		try {
			WaitClass.waitForTime(2000);
			Utility.javaScriptClick(signUpLinkOnLogin, driver);
			return SignUpButton.isDisplayed();

		} catch (Exception e) {
			System.err.println("Exception in method - checkAllCrossPasswordValidation, class - SignUp_Gamers" + e);
			return false;
		}

	}
    /**
     * Description - Checking all elements visibility
     * @return - True - if all elements are visible
     */
	public boolean checkAllElementsSignUp() {

		try {

			boolean flag = logo.isDisplayed();
			flag = flag && SignUpMsg.isDisplayed();
			flag = flag && UserNameFieldHeader.isDisplayed();
			flag = flag && UserNameField.isDisplayed();
			flag = flag && EmailFieldHeader.isDisplayed();
			flag = flag && EmailField.isDisplayed();
			flag = flag && PasswordFieldHeader.isDisplayed();
			flag = flag && PasswordField.isDisplayed();
			flag = flag && SignUpButton.isDisplayed();
			flag = flag && SignInMsg.isDisplayed();
			flag = flag && SignInLink.isDisplayed();
			flag = flag && SocialSignUpMsg.isDisplayed();
			flag = flag && SocialSignUpBottomMsg.isDisplayed();
			flag = flag && SignUpMsg.isDisplayed();
			flag = flag && continueWithGoogle.isDisplayed();
			return true;

		} catch (Exception e) {
			System.err.println("Exception in method - checkAllElementsSignUp, class - SignUp_Gamers" + e);
			return false;
		}

	}

	/**
     * Description - Checking all invalid password crosses are visible or not.
     * @return - True - if cross elements are visible.
     */
	public boolean checkAllCrossPasswordValidation() {

		try {
			boolean flag = Cross1.isDisplayed();
			flag = flag && Cross2.isDisplayed();
			flag = flag && Cross3.isDisplayed();
			flag = flag && Cross4.isDisplayed();
			flag = flag && Cross5.isDisplayed();
			return true;

		} catch (Exception e) {
			System.err.println("Exception in method - checkAllCrossPasswordValidation, class - SignUp_Gamers" + e);
			return false;
		}

	}

	/**
     * Description - Checking all valid password ticks are visible or not.
     * @return - True - if all ticks elements are visible.
     */
	public boolean checkAllTickPasswordValidation() {

		try {

			boolean flag = Tick1.isDisplayed();
			flag = flag && Tick2.isDisplayed();
			flag = flag && Tick3.isDisplayed();
			flag = flag && Tick4.isDisplayed();
			flag = flag && Tick5.isDisplayed();
			return true;

		} catch (Exception e) {
			System.err.println("Exception in method - checkAllTickPasswordValidation, class - SignUp_Gamers" + e);
			return false;
		}

	}
	
	/**
     * Description - Checking all password msgs are visible or not.
     * @return - True - if all msgs elements are visible.
     */
	public boolean checkAllPasswordValidationMsg() {

		try {

			boolean flag = LowerLetterMsg.isDisplayed();
			flag = flag && UpperLetterMsg.isDisplayed();
			flag = flag && SymbolsMsg.isDisplayed();
			flag = flag && NumbersMsg.isDisplayed();
			flag = flag && LengthMsg.isDisplayed();
			return true;

		} catch (Exception e) {
			System.err.println("Exception in method - checkAllPasswordValidationMsg, class - SignUp_Gamers" + e);
			return false;
		}

	}
	
	
	/**
     * Description - Checking all elements on confirm Account page.
     * @return - True - if all elements are visible.
     */
	public boolean checkAllElementsConfirmAccountPage() {

		try {

			boolean flag = confirmAccountLogo.isDisplayed();
			flag = flag && verificationCodeHeader.isDisplayed();
			flag = flag && verificationCodefield.isDisplayed();
			flag = flag && confirmAccountButton.isDisplayed();
			flag = flag && codeReceiveMsg.isDisplayed();
			flag = flag && codeResendLink.isDisplayed();
			return true;

		} catch (Exception e) {
			System.err.println("Exception in method - checkAllPasswordValidationMsg, class - SignUp_Gamers" + e);
			return false;
		}

	}

	/**
	 * Description - Checking signUp process.
	 * @param userName- Gamer user name.
	 * @param email- Gamer email id.
	 * @param password- Gamer password.
	 * @return- true- if signup process working correctly.
	 */
	public boolean signUp(String userName, String email, String password) {

		try {
			UserNameField.clear();
			UserNameField.sendKeys(userName);
			EmailField.clear();
			EmailField.sendKeys(email);
			PasswordField.clear();
			PasswordField.sendKeys(password);
			SignUpButton.click();
			WaitClass.waitForTime(6000);
			return true;
		} catch (Exception e) {
			System.err.println("Exception in method - signUp, class - SignUp_Gamers" + e);
			return false;
		}
	}
	
	/**
     * Description - Checking existing user name validation msg.
     * @return - True - if existing user name validation msg shown.
     */
	public boolean signUpExistingUserNameMsg() {

		try {
			WebElement ExistingUserMsg = driver.findElement(By.xpath("(//p[@id='errorMessage'])[1]"));
			boolean flag = ExistingUserMsg.isDisplayed();
			WaitClass.waitForTime(6000);
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in method - signUpExistingUserNameMsg, class - SignUp_Gamers" + e);
			return false;
		}
	}

    /**
     * Description - Checking field validation msgs for blank and invalid inputs.
     * @param blankUserName - true, if user name is blank.
     * @param blankEmail - true - if user email is blank.
     * @param textInEmailField - true - if entered only text in email field.
     * @param missingTextafterAtsymbol - true - if missing text after '@' symbol.
     * @return - true - if matches validation message for any case.
     */
	public boolean checkValidationSignUpGamer(boolean blankUserName, boolean blankEmail, boolean textInEmailField, boolean missingTextafterAtsymbol) {

		try {
			if (blankUserName == true) {
				String validation = "Please fill";
				String extractedValidation = UserNameField.getAttribute("validationMessage");
				return extractedValidation.contains(validation);
			}

			else if (blankEmail == true) {
				String validation = "Please fill";
				String extractedValidation = EmailField.getAttribute("validationMessage");
				return extractedValidation.contains(validation);
			}

			else if (textInEmailField == true) {
				String email = EmailField.getAttribute("value");
				String validation = "Please include an '@' in the email address. '"+email+"' is missing an '@'.";
				String extractedValidation = EmailField.getAttribute("validationMessage");
				return validation.equals(extractedValidation);
			}
			
			else if (missingTextafterAtsymbol == true) {
				String email = EmailField.getAttribute("value");
				String validation = "Please enter a part following '@'. '"+email+"' is incomplete.";
				String extractedValidation = EmailField.getAttribute("validationMessage");
				return validation.equals(extractedValidation);
			}
			return false;
		} catch (Exception e) {
			System.err.println("Exception in method - checkValidationSignUpGamer, class - SignUp_Gamers" + e);
			return false;
		}
	}
	
	/**
     * Description - Checking signin link working or not.
     * @return - True - if link working correctly.
     */
	public boolean signUpPageSignInLink() {

		try {
			SignInLink.click();
			WebElement signInButton = driver.findElement(By.xpath("(//input[@name='signInSubmitButton'])[2]"));
			boolean flag = signInButton.isDisplayed();
			return flag;

		} catch (Exception e) {
			System.err.println("Exception in method - signUpPageSignInLink, class - SignUp_Gamers" + e);
			return false;
		}

	}
	
	/**
     * Description - Checking after successful signup user lands on next page or not.
     * @return - True - if user lands on next page.
     */
	public boolean signUpCompletionCheck() {

		try {
			boolean flag = confirmAccountButton.isDisplayed();
			return flag;

		} catch (Exception e) {
			System.err.println("Exception in method - signUpCompletionCheck, class - SignUp_Gamers" + e);
			return false;
		}

	}
	/**
     * Description - Resend link form confirm account during signup.
     * @return - True - if user lands on next page.
     */
	public boolean resendLinkConfirmAccount() {

		try {
			codeResendLink.click();
			boolean flag = codeResendLink.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in method - resendLinkConfirmAccount, class - SignUp_Gamers" + e);
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
			boolean flag = dashboardText.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in method - ConfirmAccount, class - SignUp_Gamers" + e);
			return false;
		}

	}
	
	/**
     * Description - Checking wrong code error Msg.
     * @return - True - if error message shown
     */
	public boolean WrongCodeErrorMsg(String code) {

		try {
			verificationCodefield.clear();
			verificationCodefield.sendKeys(code);
			confirmAccountButton.click();
			boolean flag = wrongCodeMsg.isDisplayed();
			return flag;

		} catch (Exception e) {
			System.err.println("Exception in method - WrongCodeErrorMsg, class - SignUp_Gamers" + e);
			return false;
		}

	}
	
	public boolean completeSignUp(String firstname, String lastname) {
		try {
			WebDriverWait errorWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			errorWait.until(ExpectedConditions.visibilityOf(popupBox));
			if (popupHeading.getText().equals("Error")) {
				WebDriverWait closeButtonWait = new WebDriverWait(driver, Duration.ofSeconds(10));
				closeButtonWait.until(ExpectedConditions.elementToBeClickable(closeButton));
				closeButton.click();
				WaitClass.waitForTime(3000);
				formFirstName.clear();
				formFirstName.sendKeys(firstname);
				formLastName.clear();
				formLastName.sendKeys(lastname);
				tandcCheckbox.click();
				WebDriverWait updateButtonWait = new WebDriverWait(driver, Duration.ofSeconds(10));
				updateButtonWait.until(ExpectedConditions.elementToBeClickable(updateButton));
				updateButton.click();
				WaitClass.waitForTime(5000);
			}
			return true;
		} catch (Exception e) {
			System.err.println("Exception in method - completeSignUp, class - SignUp_Gamers" + e);
			return false;
		}
	}
	
	public boolean createNewAccount(String gamerUsername, String gamerPassword, String gamerEmail, String firstname, String lastname) {
		try {
			MailBox code = new MailBox();
			sighUpLinkClick();
			signUp(gamerUsername, gamerEmail, gamerPassword);
			String verificationCode = code.getEmailData(gamerEmail, "body > em", 2);
			ConfirmAccount(verificationCode);
			completeSignUp(firstname, lastname);
			
			Utility.printCredentials(gamerUsername, gamerPassword, gamerEmail, firstname + " " +lastname );
			return true;
		} catch (Exception e) {
			System.err.println("Exception in method - createNewAccount, class - SignUp_Gamers" + e);
			return false;
		}
	}
}
