package TestScripts_Sprint04;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.MailBox;
import PageObjectClasses.SignIn_Partner_Pages;
import PageObjectClasses.SignUp_CreateAccount_Partner_Page;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class SignIn_Partner_Test {
	private WebDriver driver;
	SignIn_Partner_Pages signInPartner;
	SignUp_CreateAccount_Partner_Page partner;
	MailBox mail;
	String username;
	String userpassword;
	
	@BeforeClass
	public void beforeClass() {
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int c = Integer.parseInt(count)+1;
		username = "qa_partner11"+c;
		String EmailParner = "qa_partner11"+c+"@1secmail.com";
		userpassword = "Qwerty@12345678";
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		
		driver = DriverClass.setDriver("chrome", "partner");
		partner = new SignUp_CreateAccount_Partner_Page(driver);
		WaitClass.waitForTime(10000);
		boolean flag = partner.CreateAccountButtonClick();
		Assert.assertTrue(flag);
		flag = partner.SignUpCreateAccount("Automation Partner", username, EmailParner, userpassword, userpassword);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(5000);
        mail = new MailBox();
        String verificationCode = mail.getEmailData(EmailParner, "body > em", 2);
		flag = partner.ConfirmAccount(verificationCode);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(10000);
		driver.quit();
		flag = APICalls.preparePartnerAccountAfterSignup(EmailParner, username, userpassword, Utility.getPropertiesFile("primaryLogin", "superAdminUsername"), Utility.getPropertiesFile("primaryLogin", "superAdminPassword"));
		Assert.assertTrue(flag);
	}

	@BeforeMethod
	public void browserlaunch() {
		driver = DriverClass.setDriver("chrome", "partner");
		signInPartner = new SignIn_Partner_Pages(driver);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1, description = " Verify that All Web Element Are Visible on Partner Sign In Page", enabled = true)
	public void TSSHYB211() {
		WaitClass.waitForTime(20000);
		boolean flag = signInPartner.AllWebElementDisplayedPartnerSignIn();
		CustomAssert.assertTrue(flag, "Verify that All Web Element Are Visible on Partner Sign In Page.",
				"Unable to Verify that All Web Element Are Visible on Partner Sign In Page..");
	}

	@Test(priority = 2, description = " Verify that Validation is Success on Sign In Partner ", enabled = true)
	public void TSSHYB212() {
		WaitClass.waitForTime(17000);
		boolean flag = signInPartner.ValidateSignIn(true, false, false);
		CustomAssert.assertTrue(flag, "Verify that Validation is Successfull on Sign In Partner with BlankUser.",
				"Unable to Validation is Successfull on Sign In Partner with BlankUser.");
		flag = signInPartner.ValidateSignIn(false, true, false);
		CustomAssert.assertTrue(flag, "Verify that Validation is Successfull on Sign In Partner with BlankPassword.",
				"Unable to Validation is Successfull on Sign In Partner with BlankPassword.");
		flag = signInPartner.ValidateSignIn(false, false, true);
		CustomAssert.assertTrue(flag, "Verify that Validation is Successfull on Sign In Partner with WrongCredentials.",
				"Unable to Validation is Successfull on Sign In Partner with WrongCredentials.");
	}

	@Test(priority = 3, description = " Verify that Sign In is Successfully on Partner  ", enabled = true)
	public void TSSHYB213() {
		WaitClass.waitForTime(17000);
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
	}

	@Test(priority = 4, description = " Verify that Sign Out is SuccessFul on Partner  ", enabled = true)
	public void TSSHYB214() {
		WaitClass.waitForTime(20000);
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, " Verify that Sign In is Successful on  Partner.",
				"Unable to Verify that Sign In is Successful on  Partner.");
		flag = signInPartner.SignOutPartner();
		CustomAssert.assertTrue(flag, " Verify that Sign Out is Successful on  Partner.",
				"Unable to Verify that Sign Out is Successful on  Partner.");
	}

}
