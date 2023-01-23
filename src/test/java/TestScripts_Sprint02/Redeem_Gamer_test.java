package TestScripts_Sprint02;

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

public class Redeem_Gamer_test {
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

	@Test(priority = 1, description = "Validating that All WebElements are visible on Redeem Module ", enabled = true)
	public void TSSHYB105() {
		WaitClass.waitForTime(3000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable to click on Redeem button.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.IsAllElementVisiableRedeem();
		CustomAssert.assertTrue(flag, "All Element are visiable in Redeem Module.",
				"Unable to WebElement  visiable in Redeem module.");
	}

	@Test(priority = 2, description = " Verify that Add Account CashBack method is Adding   ", enabled = true) 
	public void TSSHYB93() {
		WaitClass.waitForTime(3000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(3000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable click on Redeem button.");
		WaitClass.waitForTime(3000);
		flag = redeemclass.cashbackmethod();
		CustomAssert.assertTrue(flag, "Adding CashBack Method on Redeem Module .",
				"Unable  to Adding CashBack Method on Redeem Module");
		WaitClass.waitForTime(3000);
		flag = redeemclass.addDepositaccount();
		CustomAssert.assertTrue(flag, "Adding CashBack Method on Redeem Module .",
				"Unable  to Adding CashBack Method on Redeem Module");

	}

	@Test(priority = 3, description = " Sorting Cashback Vendor, QxPointsRedeemed, Fees , Status on Redeem Page  ", enabled = true)
	public void TSSHYB106() {
		WaitClass.waitForTime(3000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable to click on Redeem button.");
		flag = redeemclass.TransactionButton();
		CustomAssert.assertTrue(flag, "click on Transaction button.", "Unable to click on Transaction button.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.SortingRedeemPage(1, 0, 0, 0);
		CustomAssert.assertTrue(flag, "Verify sorting for Cashback Vendor in Asc .",
				"Unable to Verify sorting for Cashback Vendor in Asc .");
		WaitClass.waitForTime(2000);
		flag = redeemclass.SortingRedeemPage(2, 0, 0, 0);
		CustomAssert.assertTrue(flag, "Verify sorting for Cashback Vendor in Desc.",
				"Unable to Verify sorting for Cashback Vendor in Desc.");
		
		WaitClass.waitForTime(2000);
		flag = redeemclass.SortingRedeemPage(0, 0, 1, 0);
		CustomAssert.assertTrue(flag, "Verify sorting for Fees in Asc .", "Unable to Verify sorting for Fees Asc.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.SortingRedeemPage(0, 0, 2, 0);
		CustomAssert.assertTrue(flag, "Verify sorting for Fees in Desc .",
				" Unable to Verify sorting for Fees in Desc .");
		WaitClass.waitForTime(2000);
		flag = redeemclass.SortingRedeemPage(0, 0, 0, 1);
		CustomAssert.assertTrue(flag, "Verify sorting for Status in Asc .",
				"Unable to Verify sorting for Status in Asc.");

	}


	@Test(priority = 5, description = " checking Continue Button Working and Land on Redeem Pages  ", enabled = true)
	public void TSSHYB108() {
		WaitClass.waitForTime(2000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(3000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable click on Redeem button.");
	}

	@Test(priority = 6, description = " checking all elements are visible on Redeem From Page After click on Continue  ", enabled = true)
	public void TSSHYB109() {
		WaitClass.waitForTime(2000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(3000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable click on Redeem button.");
		WaitClass.waitForTime(3000);
		flag = redeemclass.IsAllElementVisiableFromRedeemPage();
		CustomAssert.assertTrue(flag, "checking all elements are visible on Redeem From Page After click on Continue .",
				"Unable  checking all elements are visible on Redeem From Page After click on Continue.");

	}

	@Test(priority = 7, description = " Add Qx Points and Verify the Amount is Adding and Redeem ", enabled = true)
	public void TSSHYB110() {
		WaitClass.waitForTime(2000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable click on Redeem button.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.AddQxpoints();
		CustomAssert.assertTrue(flag, "Add Qx Points and Verify the Amount is Adding and Redeem .",
				"Unable  to Add Qx Points and Verify the Amount is Adding and Redeem.");
	}

	@Test(priority = 8, description = " Verify Validating Redeem Page and Confirmation Message Pages Amount,Fees , And Net redemption. ", enabled = true)
	public void TSSHYB111() {
		WaitClass.waitForTime(2000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable click on Redeem button.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.AddQxpoints();
		CustomAssert.assertTrue(flag, "Add Qx Points and Verify the Amount is Adding and Redeem .",
				"Unable  to Add Qx Points and Verify the Amount is Adding and Redeem.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.ValidateRedeemAndConfirmationMessage();
		CustomAssert.assertTrue(flag, "Verify Amount Confirmation Message in Pop Up and Success Message.",
				"Unable  to Verify Amount Confirmation Message in Pop Up and Success Message .");
	}

	@Test(priority = 9, description = " Verify Amount Confirmation Message in Pop Up and Success Message ", enabled = true)
	public void TSSHYB112() {
		WaitClass.waitForTime(2000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable click on Redeem button.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.AddQxpoints();
		CustomAssert.assertTrue(flag, "Add Qx Points and Verify the Amount is Adding and Redeem .",
				"Unable  to Add Qx Points and Verify the Amount is Adding and Redeem.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.ValidateRedeemAndConfirmationMessage();
		CustomAssert.assertTrue(flag, "Verify Amount Confirmation Message in Pop Up and Success Message.",
				"Unable  to Verify Amount Confirmation Message in Pop Up and Success Message .");
		WaitClass.waitForTime(2000);
		flag = redeemclass.VerifyElementVisibilityAmountConfirmationMsg();
		CustomAssert.assertTrue(flag, " Verify Amount Confirmation Message in Pop Up and Success Message .",
				"Unable  to Verify Amount Confirmation Message in Pop Up and Success Message .");
	}

	@Test(priority = 10, description = " Validate Total Amount , Less Fees Redemption , and Net Redemption is correct.  ", enabled = false)
	public void TSSHYB113() {
		WaitClass.waitForTime(2000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable click on Redeem button.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.ValidatetotalAmountLessFeesNetRedemption();
		CustomAssert.assertTrue(flag, "Validate Total Amount , Less Fees Redemption , and Net Redemption is correct. .",
				"Unable  to Validate Total Amount , Less Fees Redemption , and Net Redemption is correct..");

	}

	@Test(priority = 11, description = " Verify Amount Value is Present on Redeem Page    ", enabled = true)
	public void TSSHYB95() {
		WaitClass.waitForTime(2000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.clickonredeembutton();
		CustomAssert.assertTrue(flag, "click on Redeem button.", "Unable click on Redeem button.");
		WaitClass.waitForTime(2000);
		flag = redeemclass.TransactionButton();
		CustomAssert.assertTrue(flag, "click on Transaction button.", "Unable to click on Transaction button.");
		flag = redeemclass.VerifyAmount();
		CustomAssert.assertTrue(flag, " Verify Amount value is present  on Redeem page.",
				"Unable to Verify Amount value is present  on Redeem page.");
	}

}