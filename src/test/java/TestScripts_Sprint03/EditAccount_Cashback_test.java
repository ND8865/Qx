package TestScripts_Sprint03;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.EditAccount_Gamer_pages;
import PageObjectClasses.SignInPage_Gamer;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class EditAccount_Cashback_test {
	private WebDriver driver;
	SignInPage_Gamer signIn;
	EditAccount_Gamer_pages EditAccount;
	String username;
	String userpassword;
	
	@BeforeClass
	public void beforeClass() {
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int counter = Integer.parseInt(count)+1;
		username = "automation_gamer"+counter;
		String email = "automation_gamer"+counter+"@1secmail.com";
		userpassword = "Qwerty@12345678";
		String firstname = "Automation";
		String lastname = "Gamer"+counter;
		boolean flag = APICalls.prepareGamerAccount(username, email, userpassword, firstname, lastname);
		Assert.assertTrue(flag);
		Utility.setTempProperties("testDataVariables", "signUpUserCount", counter+"");
	}

	@BeforeMethod
	@Parameters(value = { "browser" })
	public void beforeMethod(String browsername) {
		driver = DriverClass.setDriver(browsername, "gamer");
		signIn = new SignInPage_Gamer(driver);
		EditAccount = new EditAccount_Gamer_pages(driver);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1, description = "Verify that Edit Account is Select on Qx Gamer  ", enabled = true)
	public void TSSHYB149() {
		WaitClass.waitForTime(1000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(1000);
		flag = EditAccount.accountEditprofile();
		CustomAssert.assertTrue(flag, "Edit profile Arrow Button successfully click.",
				"Unable to Edit profile Arrow Button successfully click.");
	}

	@Test(priority = 2, description = " Verify that Terms and Conditions , Privacy Policy Pages is Enable   ", enabled = true)
	public void TSSHYB150() {
		WaitClass.waitForTime(2000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(1000);
		flag = EditAccount.accountEditprofile();
		CustomAssert.assertTrue(flag, "Edit profile Arrow Button successfully click.",
				"Unable to Edit profile Arrow Button successfully click.");
		WaitClass.waitForTime(1000);
		flag = EditAccount.TermsAndCondition();
		CustomAssert.assertTrue(flag, "Terms and Condition Page is Enable .",
				"Unable to find Terms and Condition Page is Enable.");
		WaitClass.waitForTime(1000);
		flag = EditAccount.PrivacyPolicy();
		CustomAssert.assertTrue(flag, "Privacy Policy Page is Enable .",
				"Unable to find Privacy Policy Page is Enable.");
	}

	@Test(priority = 3, description = " Verify that PayPal Cash Back Method is Adding    ", enabled = true)
	public void TSSHYB151() {
		WaitClass.waitForTime(2000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(1000);
		flag = EditAccount.accountEditprofile();
		CustomAssert.assertTrue(flag, "Edit profile Arrow Button successfully click.",
				"Unable to Edit profile Arrow Button successfully click.");
		WaitClass.waitForTime(1000);
		flag = EditAccount.PayPalCashBackMethod();
		CustomAssert.assertTrue(flag, "PayPal Cash Back Method is Adding  .",
				"Unable to verify PayPal Cash Back Method is Adding ");

	}

	@Test(priority = 4, description = " Verify that PayPal Cash Back Method Value is inserting     ", enabled = true)
	public void TSSHYB152() {
		WaitClass.waitForTime(3000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(1000);
		flag = EditAccount.accountEditprofile();
		CustomAssert.assertTrue(flag, "Edit profile Arrow Button successfully click.",
				"Unable to Edit profile Arrow Button successfully click.");
		WaitClass.waitForTime(1000);
		flag = EditAccount.PayPalCashBackMethod();
		CustomAssert.assertTrue(flag, "PayPal Cash Back Method is Adding  .",
				"Unable to verify PayPal Cash Back Method is Adding ");
		WaitClass.waitForTime(1000);
		flag = EditAccount.InsertValuePaypalCashback();
		CustomAssert.assertTrue(flag, " verify In PayPal Cashback Method Value is inserting   .",
				"Unable to verify In PayPal Cashback Method Value is inserting ");

	}

	@Test(priority = 5, description = " Validate Paypal Cash Back Method are correct and Remove functionality are working ", enabled = true)
	public void TSSHYB153() {
		WaitClass.waitForTime(1000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(1000);
		flag = EditAccount.accountEditprofile();
		CustomAssert.assertTrue(flag, "Edit profile Arrow Button successfully click.",
				"Unable to Edit profile Arrow Button successfully click.");
		WaitClass.waitForTime(1000);
		flag = EditAccount.PayPalCashBackMethod();
		CustomAssert.assertTrue(flag, "PayPal Cash Back Method is Adding  .",
				"Unable to verify PayPal Cash Back Method is Adding ");
		WaitClass.waitForTime(1000);
		flag = EditAccount.ValidateAddCashbackAndRemoveMethod();
		CustomAssert.assertTrue(flag, " validate Add CashBack Method and Remove method are working not  .",
				"Unable to validate Add CashBack Method and Remove method are working not . ");

	}

	@Test(priority = 6, description = " Verify the Membership on Edit Profile is Enable  ", enabled = true)
	public void TSSHYB154() {
		WaitClass.waitForTime(1000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(1000);
		flag = EditAccount.accountEditprofile();
		CustomAssert.assertTrue(flag, "Edit profile Arrow Button successfully click.",
				"Unable to Edit profile Arrow Button successfully click.");
		WaitClass.waitForTime(1000);
		flag = EditAccount.MemberShip();
		CustomAssert.assertTrue(flag, "Verify that Membership is correctly Working.",
				"Unable to Verify that Membership is correctly Working.");

	}
}
