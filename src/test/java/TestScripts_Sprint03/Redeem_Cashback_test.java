package TestScripts_Sprint03;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.EditAccount_Gamer_pages;
import PageObjectClasses.Redeem_Gamer_pages;
import PageObjectClasses.SignInPage_Gamer;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Redeem_Cashback_test {
	private WebDriver driver;
	SignInPage_Gamer signIn;
	EditAccount_Gamer_pages EditAccount;
	Redeem_Gamer_pages redeemclass;
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
	public void browserlaunch() {
		driver = DriverClass.setDriver("chrome", "gamer");

		signIn = new SignInPage_Gamer(driver);
		EditAccount = new EditAccount_Gamer_pages(driver);
		redeemclass = new Redeem_Gamer_pages(driver);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1, description = "Validating that All WebElements are visible on Redeem Module on Transaction ", enabled = true)
	public void TSSHYB161() {
		WaitClass.waitForTime(1000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable to click on Redeem button.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.AllWebElementPresentonTransActionsPage();
		CustomAssert.assertTrue(flag, "All Element are visiable in Redeem Module.",
				"Unable to WebElement  visiable in Redeem module.");
	}

	@Test(priority = 2, description = "Verify that PayPal Cashback Method are Adding on Redeem ", enabled = true)
	public void TSSHYB155() {
		WaitClass.waitForTime(1000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable to click on Redeem button.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.AddPayPalCashback();
		CustomAssert.assertTrue(flag, "Verify that Paypal Cashback method are Add on Redeem.",
				"Unable to Verify that Paypal Cashback method are Add on Redeem.");
	}

	@Test(priority = 3, description = "Verify that PayPal Cashback Method Value is inserting  ", enabled = true)
	public void TSSHYB156() {
		WaitClass.waitForTime(1000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable to click on Redeem button.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.AddPayPalCashback();
		CustomAssert.assertTrue(flag, "Verify that Paypal Cashback method are Add on Redeem.",
				"Unable to Verify that Paypal Cashback method are Add on Redeem.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.InsertValuePaypalCashbackRedeemPaypal();
		CustomAssert.assertTrue(flag, "Verify that Paypal Cashback Method Value is inserting . ",
				"Unable to Verify that Paypal Cashback Method Value is inserting . ");
	}

	@Test(priority = 4, description = "Verify that Terms and Condition Page is Enable on Redeem   ", enabled = true)
	public void TSSHYB157() {
		WaitClass.waitForTime(1000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable to click on Redeem button.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.TermsAndConditions();
		CustomAssert.assertTrue(flag, " verify Terms And Condition Page is Enable .",
				"Unable to verify Terms And Condition Page is Enable.");

	}

	@Test(priority = 5, description = "Verify that if Picked the value from the dropdown Paypal on Redeem   ", enabled = true)
	public void TSSHYB158() {
		WaitClass.waitForTime(1000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable to click on Redeem button.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.GetValueFromdropdownRedeem();
		CustomAssert.assertTrue(flag, "Verify Pick the value from the drop down.",
				"Unable to Verify Pick the value from the drop down.");
	}

	@Test(priority = 6, description = "Verify that CashBack Page is Enable And Check Visiblity of WebElements after Redeem the value (PayPal)", enabled = true)
	public void TSSHYB159() {
		WaitClass.waitForTime(1000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable to click on Redeem button.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.GetValueFromdropdownRedeem();
		CustomAssert.assertTrue(flag, "Verify Pick the value from the drop down.",
				"Unable to Verify Pick the value from the drop down.");
		flag = redeemclass.CashBackAfterRedeemPaypal();
		CustomAssert.assertTrue(flag, "Verify that CashBack Page and visibility of Elements .",
				"Unable to Verify that CashBack Page and visibility of Elements.");
	}

	@Test(priority = 7, description = "Validate the CashBack Method After Redeem the Value for PayPal", enabled = true)
	public void TSSHYB160() {
		WaitClass.waitForTime(1000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable to click on Redeem button.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.GetValueFromdropdownRedeem();
		CustomAssert.assertTrue(flag, "Verify Pick the value from the drop down.",
				"Unable to Verify Pick the value from the drop down.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.CashBackAfterRedeemPaypal();
		CustomAssert.assertTrue(flag, "Verify that CashBack Page and visibility of Elements .",
				"Unable to Verify that CashBack Page and visibility of Elements.");
		WaitClass.waitForTime(1000);
		flag = redeemclass.ValidateCashBackMethodPaypal();
		CustomAssert.assertTrue(flag, "Validate CashBack Method Value are present for PayPal after redeem the value .",
				"Unable to Validate CashBack Method Value are present for PayPal after redeem the value.");
	}

}
