package PageObjectClasses;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class EditAccount_Gamer_pages {
	WebDriver driver;
	SoftAssert softassert;

	public EditAccount_Gamer_pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		softassert = new SoftAssert();
	}

// #Edit Account page WebElement
	@FindBy(xpath = "//button[@id='userDropdown']")
	private WebElement arrowbutton;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
	private WebElement accountbutton;
	@FindBy(xpath = "//div[text()='Account']")
	private WebElement accountlogo;
	@FindBy(xpath = "//a[text()='Edit Profile']")
	private WebElement editprofile;
	@FindBy(xpath = "//a[text()='Change Password']")
	private WebElement changepassword;
	@FindBy(xpath = "//input[@id='logoUpload']")
	private WebElement logoupload;
	@FindBy(xpath = "//button[text()='Edit']")
	private WebElement editbutton;
	@FindBy(xpath = "//label[text()='First Name']")
	private WebElement headerfirstname;
	@FindBy(xpath = "//input[@id='formFirstName']")
	private WebElement filedfirstname;
	@FindBy(xpath = "//label[text()='Last Name']")
	private WebElement headerlastname;
	@FindBy(xpath = "//input[@id='formLastName']")
	private WebElement fieldlastname;
	@FindBy(xpath = "//*[text()='Username']")
	private WebElement headerusername;
	@FindBy(xpath = "//input[@id='formUsername']")
	private WebElement fieldusername;
	@FindBy(xpath = "//*[text()='Email Address']")
	private WebElement headeremail;
	@FindBy(xpath = "//input[@id='formBasicEmail']")
	private WebElement fieldemail;
	@FindBy(xpath = "//button[text()='Change']")
	private WebElement changebutton;
	@FindBy(xpath = "//*[text()='Phone Number']")
	private WebElement headerphone;
	@FindBy(xpath = "//input[@class='PhoneInputInput']")
	private WebElement fieldphone;
	@FindBy(xpath = "//*[text()='Membership Level']")
	private WebElement headermembership;
	@FindBy(xpath = "//*[@id='formMembership']")
	private WebElement fieldmembership;
	@FindBy(xpath = "//*[text()='CashBack Method']")
	private WebElement headercashback;
//	@FindBy(xpath = "//span[@class='form-control add__vendor']")
//	private WebElement fieldcashback;
	@FindBy(xpath = "//button[text()='Add New']")
	private WebElement addnewbutton;
	@FindBy(xpath = "//a[text()='Terms and Conditions']")
	private WebElement termcondition;
	@FindBy(xpath = "//a[text()='Privacy Policy']")
	private WebElement privacypolicy;
	@FindBy(xpath = "//*[text()='New Email Address']")
	private WebElement newemailaddress;
	@FindBy(xpath = "//input[@id='formNewEmail']")
	private WebElement newemailaddressfileds;
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement confirmemail;
	@FindBy(xpath = "//button[@class='btn btn-primary' and text()='Confirm']")
	private WebElement verificationbuttonconfirm;
	@FindBy(xpath = "//select[@class='PhoneInputCountrySelect']")
	private WebElement phonecountrycode;
	// # Cash Back Method WebElement
	@FindBy(xpath = "//span[@class='form-control add__vendor']")
	private WebElement clickonarrowcashback;
	@FindBy(xpath = "//a[text()='+ add']")
	private WebElement clickonaddbutton;
	@FindBy(xpath = "//input[@id='formNewEmail']")
	private WebElement verificationfield;
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement verificationcodeconfirm;
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement updatebutton;
	@FindBy(xpath = "//div[contains(text(),'Please enter valid phone number.')]")
	private WebElement EnterValidNumber;
	@FindBy(xpath = "//div[contains(text(),'Add Cashback Method')]")
	private WebElement AddCashBackMethodHeader;
	@FindBy(xpath = "//button[@id='dropdown-basic']")
	private WebElement SelectCashBackMethodDropdown;
	@FindBy(xpath = "(//button[text() = 'Edit'])[2]")
	private WebElement EditButtonforremove;
	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	private WebElement RemoveButtonCashback;
	@FindBy(xpath = "//div[contains(text(),'Remove Cashback')]")
	private WebElement AlertRemoveCashbackmethod;
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	private WebElement Confirmcashbackmethod;
	// # Add Account Details
	@FindBy(xpath = "//div[contains(text(),'Add Deposit Account')]")
	private WebElement adddepositaccount;
	@FindBy(xpath = "//*[contains(text(),'Cashback Method Nickname')]")
	private WebElement accountnicknameheader;
	@FindBy(xpath = "(//input[@id='formFirstName'])[1]")
	private WebElement accountnicknameheaderfield;
	@FindBy(xpath = "//*[contains(text(),'Routing Number')]")
	private WebElement accountroutingheader;
	@FindBy(xpath = "//input[@placeholder='Routing Number']")
	private WebElement accountroutingheaderfield;
	@FindBy(xpath = "//*[contains(text(),'Account Number')]")
	private WebElement accountnumberheader;
	@FindBy(xpath = "//input[@placeholder='Account Number']")
	private WebElement accountnumberheaderfield;
	@FindBy(xpath = "//*[contains(text(),'Bank Account Name')]")
	private WebElement bankaccountname;
	@FindBy(xpath = "//input[@placeholder='Bank Account Name']")
	private WebElement bankaccountnamefield;
	@FindBy(xpath = "//button[contains(text(),'Add New')]")
	private WebElement clickonAddNewButton;
	@FindBy(xpath = "//a[contains(text(),'+ add')]")
	private WebElement clickonadd;
	@FindBy(xpath = "(//input[@id='formBasicRadio'])[1]")
	private WebElement chekingradiobutton;
	@FindBy(xpath = "(//input[@id='formBasicRadio'])[2]")
	private WebElement chekingsavingbutton;
	@FindBy(xpath = "//input[@id='formBasicCheckbox']")
	private WebElement clickoncheckbox;
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement clickonAddButton;
	@FindBy(xpath = "//*[contains(text(),'Remove Cashback Method')  or   contains(text(),'+ add')]")
	private WebElement removecashback;
	@FindBy(xpath = "//input[@name='gameIcon']")
	private WebElement clickEditButton;
	@FindBy(xpath = "//input[@type='file']")
	private WebElement UploadImg;
	@FindBy(xpath = "//input[@placeholder='Confirm Account Number']")
	private WebElement confirmAccount;
	// # Sprint 3 All WebElements
	@FindBy(linkText = "Terms and Conditions")
	private WebElement TermsAndConditions;
	@FindBy(linkText = "Privacy Policy")
	private WebElement PrivacyPolicy;
	@FindBy(xpath = "//h1[contains(text(),'Terms & Conditions')]")
	private WebElement TermsAndConditionPage;
	@FindBy(xpath = "//h1[contains(text(),'Targeted Shopping Solutions Privacy Policy')]")
	private WebElement PrivacyPolicyPage;
	@FindBy(xpath = "//label[contains(text(),'Cashback Method Nickname')]")
	private WebElement PaypalCashNickNameHeader;
	@FindBy(xpath = "//label[contains(text(),'Enter email or phone number associated with your PayPal account')]")
	private WebElement EmailPhoneHeader;
	@FindBy(xpath = "//span[contains(text(),'Make this the default cashback method.')]")
	private WebElement CheckButtonText;
	@FindBy(xpath = "//input[@placeholder='Cashback Method Nickname']")
	private WebElement PayPalAccountNickNamefield;
	@FindBy(xpath = "//input[@placeholder='PayPal Email or Phone Number']")
	private WebElement EmailorPhoneFieldPaypal;
	@FindBy(xpath = "//input[@id='formBasicCheckbox']")
	private WebElement CheckboxPaypal;
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement PayPalAddButton;
	@FindBy(xpath = "//div[@class='Toastify__toast-body' or contains(text(),'Payment method added successfully.')]")
	private WebElement AlertAfterAddAccount;
	@FindBy(xpath = "//div[@class='modal-body']/p")
	private WebElement RemoveCashbackPopuptext;
	@FindBy(xpath = "//div[contains(text(),'User payment method removed successfully.')]")
	private WebElement AlertafterRemovecashback;
	@FindBy(xpath = "(//a[text()='Dashboard'])[2]")
	private WebElement HomeButton;

	/**
	 * Description - checking all elements on account edit profile .
	 * 
	 * @return - True - if all elements are visible.
	 */
	public boolean isaccountEditprofileisDisplay() {

		try {

			boolean flag = accountlogo.isDisplayed();
			flag = flag && editprofile.isDisplayed();
			flag = flag && changepassword.isDisplayed();
			flag = flag && editbutton.isDisplayed();
			flag = flag && headerfirstname.isDisplayed();
			flag = flag && filedfirstname.isDisplayed();
			flag = flag && headerlastname.isDisplayed();
			flag = flag && fieldlastname.isDisplayed();
			flag = flag && headerusername.isDisplayed();
			flag = flag && fieldusername.isDisplayed();
			flag = flag && headeremail.isDisplayed();
			flag = flag && fieldemail.isDisplayed();
			flag = flag && changebutton.isDisplayed();
			flag = flag && headerphone.isDisplayed();
			flag = flag && fieldphone.isDisplayed();
			flag = flag && headermembership.isDisplayed();
			flag = flag && fieldmembership.isDisplayed();
			flag = flag && headercashback.isDisplayed();
			flag = flag && termcondition.isDisplayed();
			flag = flag && privacypolicy.isDisplayed();

			return flag;
		} catch (Exception e) {

			System.err.println(
					"Exception in Method - isaccounteditprofileisdisplay, Class - EditAccount_Gamer_pages.java : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify Arrow button & Account button is working .
	 * 
	 * @return-True- If lands on drop down account page and return edit profile is
	 *               display.
	 * 
	 */
	public boolean accountEditprofile() {
		try {

			arrowbutton.click();
			WaitClass.waitForTime(2000);
			accountbutton.click();
			WaitClass.waitForTime(2000);
			Utility.clearField(driver, fieldphone);
			WaitClass.waitForTime(2000);

			return editprofile.isDisplayed();

		} catch (Exception e) {
			System.err.println("Exception in method - accounteditprofile, class - EditAccount_Gamer_pages.java" + e);
			return false;
		}
	}

	/**
	 * Description - Verify the Profile photo is uploaded .
	 * 
	 * @return-True- If Verify the Profile photo is uploaded
	 * 
	 **/
	public boolean ProfilePhotoUpload() {
		try {

			arrowbutton.click();
			WaitClass.waitForTime(2000);
			accountbutton.click();
			WaitClass.waitForTime(3000);
			new Actions(driver).click(clickEditButton).build().perform();

			WaitClass.waitForTime(2000);

			Utility.uploadFileWithRobot(Utility.getPropertiesFile("primaryLogin", "GameIconImg"));

			return true;

		} catch (Exception e) {
			System.err.println("Exception in method - ProfilePhotoUpload, class - EditAccount_Gamer_pages.java" + e);
			return false;
		}
	}

	/**
	 * Description - checking land to edit profile fields.
	 * 
	 * @return-True- If lands on edit profile page and verify data .
	 */
	public boolean ValidateEditProfile(String firstName, String lastName, String username) {
		try {
			WebElement get = driver.findElement(By.id("formFirstName"));
			String firstname = get.getAttribute("value").trim();
			if(!firstname.equals(firstname)) {
				return false;
			}
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("window.scrollBy(0,100)");
			WebElement get1 = driver.findElement(By.id("formLastName"));
			String lastname = get1.getAttribute("value");
			if(!lastname.equals(lastName)) {
				return false;
			}
			WebElement get2 = driver.findElement(By.id("formUsername"));
			String username1 = get2.getAttribute("value");
			if(!username1.equals(username)) {
				return false;
			}
			return true;
		}

		catch (Exception e) {
			System.err.println("Exception in method - veryfieditfields, class - EditAccount_Gamer_pages.java" + e);
			return false;
		}

	}

	/**
	 * Description - Verify update Email are changing .
	 * 
	 * @return-True- If lands on change email address pop up window.
	 * 
	 */
	public boolean verifyemailupdate(String email) {
		try {
			WaitClass.waitForTime(2000);
			changebutton.click();

			newemailaddressfileds.sendKeys(email);
			WaitClass.waitForTime(3000);
			confirmemail.click();
			WaitClass.waitForTime(3000);
			// newemailaddress.isDisplayed();

			return true;
		} catch (Exception e) {
			System.err.println("Exception in method - verifyemailupdate, class - EditAccount_Gamer_pages.java" + e);
			return false;

		}
	}

	/**
	 * Description - Verify update Email Validation .
	 * 
	 * @return-True- If lands on change email address pop up window.
	 * 
	 */
	public boolean verifyemailvalidation(String code) {
		try {
			WaitClass.waitForTime(2000);

			verificationfield.sendKeys(code);
			verificationcodeconfirm.click();

			return true;
		} catch (Exception e) {
			System.err.println("Exception in method - verifyemailvalidation, class - EditAccount_Gamer_pages.java" + e);
			return false;
		}
	}

	/**
	 * Description - Verify Removing Cash back Method Add account .
	 * 
	 * @return-True- If Cash back method are remove.
	 * 
	 */
	public boolean RemoveCashbackmethod() {
		try {
			WaitClass.waitForTime(3000);
			Actions action = new Actions(driver);
			action.moveToElement(EditButtonforremove).click().perform();
			WaitClass.waitForTime(3000);
			Utility.javaScriptClick(RemoveButtonCashback, driver);
			Confirmcashbackmethod.click();
			WaitClass.waitForTime(4000);
			HomeButton.click();
			driver.navigate().refresh();

			return true;
		} catch (Exception e) {
			System.err.println("Exception in method - RemoveCashbackmethod, class - EditAccount_Gamer_pages.java" + e);
			return false;
		}
	}

	/**
	 * Description - Verify edit profile alert message .
	 * 
	 * @return-True- alert message is present .
	 * 
	 */
	public boolean alertdisplayeditprofile(String firstName, String lastName) {
		try {

			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("window.scrollBy(0,-50)");
			filedfirstname.click();
			WaitClass.waitForTime(2000);
			Utility.clearField(driver, filedfirstname);
			WaitClass.waitForTime(2000);
			filedfirstname.click();
			WaitClass.waitForTime(2000);
			fieldlastname.click();
			WaitClass.waitForTime(2000);
			Utility.clearField(driver, fieldlastname);
			WaitClass.waitForTime(3000);
			fieldlastname.click();

			boolean name = driver.findElement(By.xpath("//div[text()='Please enter first name.']")).isDisplayed();
			System.out.println(name);
			WaitClass.waitForTime(3000);
			boolean lastname = driver.findElement(By.xpath("//div[text()='Please enter last name.']")).isDisplayed();
			System.out.println(lastname);
			WaitClass.waitForTime(3000);
			filedfirstname.sendKeys(firstName);
			fieldlastname.sendKeys(lastName);
			Utility.javaScriptClick(updatebutton, driver);

			return true;
		} catch (Exception e) {
			System.err
					.println("Exception in method - alertdisplayeditprofile, class - EditAccount_Gamer_pages.java" + e);
			return false;

		}

	}

	/**
	 * Description - Verify cash back method element is display .
	 * 
	 * @return-True- if cash back method is work.
	 * 
	 */
	public boolean cashbackmethod() {
		try {

			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("window.scrollBy(0,50)");
			Utility.javaScriptClick(addnewbutton, driver);
			WaitClass.waitForTime(2000);
			boolean flag1 = AddCashBackMethodHeader.isDisplayed();
			WaitClass.waitForTime(2000);
			Utility.javaScriptClick(SelectCashBackMethodDropdown, driver);
			WaitClass.waitForTime(2000);
			paymentsMethod("Dwolla");
			WaitClass.waitForTime(2000);
			boolean flag = accountnicknameheader.isDisplayed();
			flag = flag && accountroutingheader.isDisplayed();
			JavascriptExecutor je1 = (JavascriptExecutor) driver;
			je1.executeScript("window.scrollBy(0,50)");
			flag = flag && accountnumberheader.isDisplayed();
			flag = flag && bankaccountname.isDisplayed();
			return flag1 && flag;
		} catch (Exception e) {
			System.err.println("Exception in method - cashbackmethod, class - EditAccount_Gamer_pages.java" + e);
			return false;

		}
	}

	/**
	 * Description - Method for Payment Add Cash back Method .
	 * 
	 */
	private void paymentsMethod(String PaymentMethod) {
		List<WebElement> paymethods = driver.findElements(By.xpath("//li[@class='active_item']"));
		for (WebElement cashbackmethod : paymethods) {
			if (cashbackmethod.getText().contains(PaymentMethod)) {
				cashbackmethod.click();
				break;
			}
		}
	}

	/**
	 * Description - Verify details for add account .
	 * 
	 * @return-True- if all details are filled .
	 * 
	 */
	public boolean addDepositaccount() {
		try {

			accountnicknameheaderfield.sendKeys(Utility.getPropertiesFile("primaryLogin", "accountnickname"));
			WaitClass.waitForTime(2000);
			accountroutingheaderfield.sendKeys(Utility.getPropertiesFile("primaryLogin", "routingnumber"));
			WaitClass.waitForTime(2000);
			accountnumberheaderfield.sendKeys(Utility.getPropertiesFile("primaryLogin", "accountnumber"));
			WaitClass.waitForTime(2000);
			confirmAccount.sendKeys(Utility.getPropertiesFile("primaryLogin", "ConfirmACNumber"));
			WaitClass.waitForTime(2000);
			bankaccountnamefield.sendKeys(Utility.getPropertiesFile("primaryLogin", "bankname"));
			WaitClass.waitForTime(2000);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("window.scrollBy(0,100)");
			chekingradiobutton.click();
			WaitClass.waitForTime(2000);
			chekingsavingbutton.click();
			WaitClass.waitForTime(2000);
			clickoncheckbox.click();
			JavascriptExecutor je1 = (JavascriptExecutor) driver;
			je1.executeScript("window.scrollBy(0,-600)");
			clickonAddButton.click();
			WaitClass.waitForTime(3000);
			Utility.javaScriptClick(EditButtonforremove, driver);
			WaitClass.waitForTime(3000);
			Utility.javaScriptClick(RemoveButtonCashback, driver);
			WaitClass.waitForTime(5000);

			return true;

		} catch (Exception e) {
			System.err.println("Exception in method - addDepositAccount, class - EditAccount_Gamer_pages.java" + e);
			return false;
		}
	}

	/**
	 * Description - Verify Edit Profile Add Deposit Account alert msg is present
	 * after clear the field .
	 * 
	 * @return-True- Alert message is present after clear the fields .
	 * 
	 */
	public boolean ValidateAddDepositAccountAlertFieldClear() {
		try {

//			accountnicknameheaderfield.sendKeys(Utility.getPropertiesFile("primaryLogin", "accountnickname"));
//			WaitClass.waitForTime(2000);
			accountroutingheaderfield.sendKeys(Utility.getPropertiesFile("primaryLogin", "routingnumber"));
			WaitClass.waitForTime(2000);
			accountnumberheaderfield.sendKeys(Utility.getPropertiesFile("primaryLogin", "accountnumber"));
			WaitClass.waitForTime(2000);
			confirmAccount.sendKeys(Utility.getPropertiesFile("primaryLogin", "ConfirmACNumber"));
			WaitClass.waitForTime(2000);
			bankaccountnamefield.sendKeys(Utility.getPropertiesFile("primaryLogin", "bankname"));
			WaitClass.waitForTime(2000);
			Utility.clearField(driver, accountnicknameheaderfield);
			WaitClass.waitForTime(2000);
			Utility.clearField(driver, accountroutingheaderfield);
			WaitClass.waitForTime(2000);
			Utility.clearField(driver, accountnumberheaderfield);
			WaitClass.waitForTime(2000);
			Utility.clearField(driver, confirmAccount);
			WaitClass.waitForTime(2000);
			Utility.clearField(driver, bankaccountnamefield);
			WaitClass.waitForTime(2000);
//			boolean flag = driver.findElement(By.xpath("//div[contains(text(),'Please enter account nickname.')]"))
//					.isDisplayed();
			boolean flag1 = driver.findElement(By.xpath("//div[contains(text(),'Please enter routing number.')]"))
					.isDisplayed();
			boolean flag2 = driver.findElement(By.xpath("//div[contains(text(),'Please enter account number.')]"))
					.isDisplayed();
			boolean flag4 = driver.findElement(By.xpath("//div[contains(text(),'Please confirm the account number.')]"))
					.isDisplayed();
			boolean flag3 = driver.findElement(By.xpath("//div[contains(text(),'Please enter account name.')]"))
					.isDisplayed();
			return flag1 && flag2 && flag3 && flag4;
		} catch (Exception e) {
			System.err.println(
					"Exception in method - ValidateAddDepositAccountAlertFieldClear, class - EditAccount_Gamer_pages.java"
							+ e);
			return false;

		}

	}

	/**
	 * Description - Verify Add Deposit Account Method Details are present .
	 * 
	 * 
	 * @return-True- if Add Deposit Account Method Details are present .
	 * 
	 */
	public boolean ValidateAddDepositAccountMethod() {
		try {

			ArrayList<String> expecteddata = new ArrayList<String>();
			ArrayList<String> actualdata = new ArrayList<String>();

			accountnicknameheaderfield.sendKeys(Utility.getPropertiesFile("primaryLogin", "accountnickname"));
			WaitClass.waitForTime(2000);
			accountroutingheaderfield.sendKeys(Utility.getPropertiesFile("primaryLogin", "routingnumber"));
			WaitClass.waitForTime(2000);
			accountnumberheaderfield.sendKeys(Utility.getPropertiesFile("primaryLogin", "accountnumber"));
			WaitClass.waitForTime(2000);
			confirmAccount.sendKeys(Utility.getPropertiesFile("primaryLogin", "ConfirmACNumber"));
			WaitClass.waitForTime(2000);
			bankaccountnamefield.sendKeys(Utility.getPropertiesFile("primaryLogin", "bankname"));

			expecteddata.add(Utility.getPropertiesFile("primaryLogin", "accountnickname"));
			expecteddata.add(Utility.getPropertiesFile("primaryLogin", "routingnumber"));
			expecteddata.add(Utility.getPropertiesFile("primaryLogin", "accountnumber"));
			expecteddata.add(Utility.getPropertiesFile("primaryLogin", "ConfirmACNumber"));
			expecteddata.add(Utility.getPropertiesFile("primaryLogin", "bankname"));

			WebElement get = driver.findElement(By.xpath("//input[@placeholder='Cashback Method Nickname']"));
			String firstname = get.getAttribute("value");
			actualdata.add(firstname);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("window.scrollBy(0,100)");
			WebElement get1 = driver.findElement(By.xpath("//input[@placeholder='Routing Number']"));
			String lastname = get1.getAttribute("value");
			actualdata.add(lastname);
			WebElement get2 = driver.findElement(By.xpath("//input[@placeholder='Account Number']"));
			String username = get2.getAttribute("value");
			actualdata.add(username);

			WebElement get4 = driver.findElement(By.xpath("//input[@placeholder='Confirm Account Number']"));
			String confirmAcnum = get4.getAttribute("value");
			actualdata.add(confirmAcnum);

			WebElement get3 = driver.findElement(By.xpath("//input[@placeholder='Bank Account Name']"));
			String basicemail = get3.getAttribute("value");
			actualdata.add(basicemail);
			SoftAssert soft = new SoftAssert();
			for (String A : actualdata) {
				for (String B : expecteddata) {

					soft.assertEquals(A, B);
					expecteddata.remove(B);
					break;
				}

			}
			soft.assertAll();
			return true;
		} catch (Exception e) {
			System.err.println(
					"Exception in method - ValidateAddDepositAccountAlertFieldClear, class - EditAccount_Gamer_pages.java"
							+ e);
			return false;

		}
	}

	/**
	 * Description - Verify Phone Number and country code validation .
	 * 
	 * @return-True- if phone number is Entering and country code validation
	 * 
	 * 
	 */
	public boolean ValidatePhonenumber() {

		try {

			phonecountrycode.click();
			phonecountrycode.sendKeys("India");
			WaitClass.waitForTime(2000);
			phonecountrycode.sendKeys(Keys.ENTER);
			String countryname = driver.findElement(By.xpath("//option[@value='IN']")).getText();
			String expectedcountryname = "India";
			softassert.assertEquals(countryname, expectedcountryname);
			softassert.assertAll();
			Utility.clearField(driver, fieldphone);
			WaitClass.waitForTime(2000);
			fieldphone.sendKeys("7765996512");
			WaitClass.waitForTime(2000);
			String actualphone = driver.findElement(By.xpath("//input[@class='PhoneInputInput']"))
					.getAttribute("value");
			ArrayList<String> addphone1 = new ArrayList<String>();
			addphone1.add(actualphone);
			String expectedphone = "7765996512";
			String exphone[] = expectedphone.split("");
			ArrayList<String> addphone = new ArrayList<String>();
			addphone.add(exphone[0] + exphone[1] + exphone[2] + exphone[3] + exphone[4] + " " + exphone[5] + exphone[6]
					+ exphone[7] + exphone[8] + exphone[9]);
			softassert.assertEquals(addphone, addphone1);
			softassert.assertAll();
			int len = actualphone.length();
			if (len == 11) {
				return true;
			} else if (len < 11) {
				EnterValidNumber.isDisplayed();
			}
			updatebutton.click();
			return true;

		} catch (Exception e) {
			System.err.println("Exception in method - ValidatePhonenumber, class - EditAccount_Gamer_pages.java" + e);
			return false;
		}

	}

	// # The Sprint 3 Start from There
	/**
	 * Description - Verify that Terms And Condition , Privacy Policy Page is
	 * available .
	 * 
	 * @return-True- if Both pages are Enable .
	 * 
	 */
	public boolean TermsAndCondition() {
		try {

			boolean CashBackMethod = driver.findElement(By.xpath("//label[contains(text(),'CashBack Method')]"))
					.isDisplayed();
			boolean TermsAndCondition = driver.findElement(By.xpath("//a[contains(text(),'Terms and Conditions')]"))
					.isDisplayed();
			boolean PrivacyPolicy = driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]"))
					.isDisplayed();
			WaitClass.waitForTime(2000);
			String oldTab = driver.getWindowHandle();
			termcondition.click();
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			newTab.remove(oldTab);
			driver.switchTo().window(newTab.get(0));
			WaitClass.waitForTime(4000);
			boolean termandConditionpage = TermsAndConditionPage.isDisplayed();
			driver.close();
			driver.switchTo().window(oldTab);// change focus back to old tab
			return CashBackMethod && TermsAndCondition && PrivacyPolicy && termandConditionpage;

		} catch (Exception e) {
			System.err.println("Exception in method - TermsAndCondition, class - EditAccount_Gamer_pages.java" + e);
			return false;

		}
	}

	/**
	 * Description - Verify that Terms And Condition , Privacy Policy Page is
	 * available .
	 * 
	 * @return-True- if Both pages are Enable .
	 * 
	 */
	public boolean PrivacyPolicy() {
		try {

			String oldTab = driver.getWindowHandle();
			PrivacyPolicy.click();
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			newTab.remove(oldTab);
			driver.switchTo().window(newTab.get(0));
			WaitClass.waitForTime(4000);
			boolean PrivacyPages = PrivacyPolicyPage.isDisplayed();
			driver.close();
			driver.switchTo().window(oldTab);// change focus back to old tab
			return PrivacyPages;

		} catch (Exception e) {
			System.err.println("Exception in method - TermsAndCondition, class - EditAccount_Gamer_pages.java" + e);
			return false;

		}
	}

	/**
	 * Description - Verify that PayPal Cash Back Method is Adding On Edit Profile .
	 * 
	 * @return-True- if Cash PayPal Back Method is Adding on Edit profile.
	 * 
	 */
	public boolean PayPalCashBackMethod() {
		try {

			Utility.javaScriptClick(addnewbutton, driver);
			WaitClass.waitForTime(2000);
			boolean flag1 = AddCashBackMethodHeader.isDisplayed();
			WaitClass.waitForTime(2000);
			Utility.javaScriptClick(SelectCashBackMethodDropdown, driver);
			WaitClass.waitForTime(2000);
			paymentsMethod("PayPal");
			WaitClass.waitForTime(2000);
			boolean flag = PaypalCashNickNameHeader.isDisplayed();
			flag = flag && EmailPhoneHeader.isDisplayed();
			JavascriptExecutor je1 = (JavascriptExecutor) driver;
			je1.executeScript("window.scrollBy(0,50)");
			flag = flag && CheckButtonText.isDisplayed();

			return flag && flag1;
		} catch (Exception e) {
			System.err.println("Exception in method - PayPalCashBackMethod, class - EditAccount_Gamer_pages.java" + e);
			return false;

		}
	}

	/**
	 * Description - Verify that in PayPal Cash Back method Value is Inserting or
	 * not .
	 * 
	 * @return-True- if Cash PayPal Back Method Value is inserting .
	 * 
	 */
	public boolean InsertValuePaypalCashback() {
		try {
			// # Verify from first with email id
			Utility.clearField(driver, PayPalAccountNickNamefield);
			WaitClass.waitForTime(2000);
			PayPalAccountNickNamefield.sendKeys("Gamerpaypal");
			Utility.clearField(driver, EmailorPhoneFieldPaypal);
			WaitClass.waitForTime(2000);
			EmailorPhoneFieldPaypal.sendKeys("gamer12345@gmail.com");
			Utility.javaScriptClick(PayPalAddButton, driver);
			String alerttext = Utility.getalerttext(driver, AlertAfterAddAccount);
			String alerttextex = "User cashback method added successfully.";
			Assert.assertEquals(alerttext, alerttextex);
			softassert.assertAll();
			System.out.println(alerttext);
			WaitClass.waitForTime(2000);
			Utility.javaScriptClick(EditButtonforremove, driver);
			Utility.javaScriptClick(RemoveButtonCashback, driver);
			Utility.javaScriptClick(AlertRemoveCashbackmethod, driver);
			Utility.javaScriptClick(Confirmcashbackmethod, driver);
			WaitClass.waitForTime(4000);
			HomeButton.click();
			driver.navigate().refresh();
			return true;
		} catch (Exception e) {
			System.err.println(
					"Exception in method - InsertValuePaypalCashback, class - EditAccount_Gamer_pages.java" + e);
			return false;

		}
	}

	/**
	 * Description - validate Add CashBack Method and Remove method are working not
	 * .
	 * 
	 * @return-True- if Cash PayPal Back Method is Validation is correct .
	 * 
	 */
	public boolean ValidateAddCashbackAndRemoveMethod() {
		try {
			boolean flag = true;
			ArrayList<String> expected = new ArrayList<String>();
			ArrayList<String> actual = new ArrayList<String>();
			// # Verify from first with phone number
			Utility.clearField(driver, PayPalAccountNickNamefield);
			WaitClass.waitForTime(2000);
			PayPalAccountNickNamefield.sendKeys("Gamerpaypal");
			Utility.clearField(driver, EmailorPhoneFieldPaypal);
			WaitClass.waitForTime(2000);
			EmailorPhoneFieldPaypal.sendKeys("7765996512");
			WaitClass.waitForTime(2000);
			Utility.clearField(driver, EmailorPhoneFieldPaypal);
			boolean alertmsg = driver
					.findElement(By.xpath("//div[contains(text(),'Please enter email address or phone number.')]"))
					.isDisplayed();
			WaitClass.waitForTime(2000);
			EmailorPhoneFieldPaypal.sendKeys("7765996512");
			expected.add("Gamerpaypal");
			expected.add("7765996512");
			String nicknamevalue = driver.findElement(By.xpath("//input[@placeholder='Cashback Method Nickname']"))
					.getAttribute("value");
			String phonevalue = driver.findElement(By.xpath("//input[@placeholder='PayPal Email or Phone Number']"))
					.getAttribute("value");
			actual.add(nicknamevalue);
			actual.add(phonevalue);
			Assert.assertEquals(expected, actual);
			softassert.assertAll();
			String phonevalue2 = driver.findElement(By.xpath("//input[@placeholder='PayPal Email or Phone Number']"))
					.getAttribute("value");
			int phonelength = phonevalue2.length();
			if (phonelength > 10) {
				flag = driver.findElement(By.xpath("//div[contains(text(),'Please enter valid input.')]"))
						.isDisplayed();
			}
			if (phonelength < 10) {
				flag = driver.findElement(By.xpath("//div[contains(text(),'Please enter valid input.')]"))
						.isDisplayed();
			}

			WaitClass.waitForTime(2000);
			Utility.javaScriptClick(CheckboxPaypal, driver);
			Utility.javaScriptClick(PayPalAddButton, driver);
			// # Alert Message present after Add Cash Back Method.
			String alerttext = Utility.getalerttext(driver, AlertAfterAddAccount);
			String alerttextex = "Payment method added successfully.";
			Assert.assertEquals(alerttext, alerttextex);
			softassert.assertAll();
			WaitClass.waitForTime(2000);
			Utility.javaScriptClick(EditButtonforremove, driver);
			flag = driver.findElement(By.xpath("//div[contains(text(),'Edit Cashback Method')]")).isDisplayed();
			Utility.javaScriptClick(RemoveButtonCashback, driver);
			flag = RemoveCashbackPopuptext.isDisplayed();
			Utility.javaScriptClick(AlertRemoveCashbackmethod, driver);
			Utility.javaScriptClick(Confirmcashbackmethod, driver);
			// # Alert Message present after Remove Cash Back Method.
			String alerttextremove = Utility.getalerttext(driver, AlertafterRemovecashback);
			String alerttextexremove = "User payment method removed successfully.";
			Assert.assertEquals(alerttextremove, alerttextexremove);
			softassert.assertAll();
			String nocashbackmethod = driver
					.findElement(By.xpath("//div[contains(text(),'No Cashback Method Found.')]")).getText();
			String nocashbackmethodex = "No Cashback Method Found.";
			Assert.assertEquals(nocashbackmethod, nocashbackmethodex);
			softassert.assertAll();
			HomeButton.click();
			driver.navigate().refresh();
			return flag && alertmsg;
		} catch (Exception e) {
			System.err.println(
					"Exception in method - ValidateAddCashbackAndRemoveMethod, class - EditAccount_Gamer_pages.java"
							+ e);
			return false;

		}
	}

	/**
	 * Description - Verify that MemberShip is Working on Edit Profile .
	 * 
	 * @return-True- if MemberShip is Working on Edit Profile.
	 * 
	 */
	public boolean MemberShip() {
		try {
			boolean flag = false;
			boolean membership = driver.findElement(By.xpath("//label[contains(text(),'Membership Level')]"))
					.isDisplayed();
			String membershiptext = driver.findElement(By.xpath("//input[@id='formMembership']")).getAttribute("value");
			if (driver.getPageSource().contains(membershiptext)) {
				flag = true;
			}

			return true&&membership&&flag;

		} catch (Exception e) {
			System.err.println("Exception in method - MemberShip, class - EditAccount_Gamer_pages.java" + e);
			return false;

		}

	}
}
