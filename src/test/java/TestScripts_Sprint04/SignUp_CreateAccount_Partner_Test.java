package TestScripts_Sprint04;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.MailBox;
import PageObjectClasses.SignUp_CreateAccount_Partner_Page;
import TestListners.CustomAssert;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class SignUp_CreateAccount_Partner_Test {
	private WebDriver driver;
	SignUp_CreateAccount_Partner_Page signUpCreateAccountPartner;
	String username;
	String userpassword;
	MailBox code;
	String UserNameGamer;
	String EmailGamer;
	int c;
	String PasswordGamer;
	String name;

	@BeforeMethod
	public void browserlaunch() {
		driver = DriverClass.setDriver("chrome", "partner");
		signUpCreateAccountPartner = new SignUp_CreateAccount_Partner_Page(driver);
		username = Utility.getPropertiesFile("primaryLogin", "partnerUsername3");
		userpassword = Utility.getPropertiesFile("primaryLogin", "partnerPassword3");
		code = new MailBox();
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		c = Integer.parseInt(count) + 1;
		UserNameGamer = "Partner" + c;
		EmailGamer = "qa_partner" + c + "@1secmail.com";
		name = "Partner0" + c;
		PasswordGamer = "Qwerty@12345678";

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1, description = " Verify that All Web Element Are Visible on Partner Sign In Create Account ", enabled = true)
	public void TSSHYB215() {
		WaitClass.waitForTime(17000);
		boolean flag = signUpCreateAccountPartner.CreateAccountButtonClick();
		CustomAssert.assertTrue(flag, "Verify that Create Account Button is Working on Partner Sign In .",
				"Unable to Verify that Create Account Button is Working on Partner Sign In .");
		flag = signUpCreateAccountPartner.AllWebElementDisplayedPartnerCreateAccount();
		CustomAssert.assertTrue(flag, "Verify that All Web Element Are Visible on Partner Sign In Create Account.",
				"Unable to Verify that All Web Element Are Visible on Partner Sign In Create Account..");
	}

	@Test(priority = 2, description = " Verify that Validation is Present on SignUp Create Account on Partner ", enabled = true)
	public void TSSHYB216() {
		WaitClass.waitForTime(17000);
		boolean flag = signUpCreateAccountPartner.CreateAccountButtonClick();
		CustomAssert.assertTrue(flag, "Verify that Create Account Button is Working on Partner Sign In .",
				"Unable to Verify that Create Account Button is Working on Partner Sign In .");
		flag = signUpCreateAccountPartner.ValidateCreateAccountSignUp(true, false, false, false, false, false);
		CustomAssert.assertTrue(flag, "Verify that Validate the Blank Name user field .",
				"Unable to verify Validate the Blank Name user field .");
		flag = signUpCreateAccountPartner.ValidateCreateAccountSignUp(false, true, false, false, false, false);
		CustomAssert.assertTrue(flag, "Verify that Validate the BlankUserName user field .",
				"Unable to verify Validate the BlankUserName user field .");
		flag = signUpCreateAccountPartner.ValidateCreateAccountSignUp(false, false, true, false, false, false);
		CustomAssert.assertTrue(flag, "Verify that Validate the BlankEmail user field .",
				"Unable to verify Validate the BlankEmail user field .");
		flag = signUpCreateAccountPartner.ValidateCreateAccountSignUp(false, false, false, true, false, false);
		CustomAssert.assertTrue(flag, "Verify that Validate the blankPassword user field .",
				"Unable to verify Validate the blankPassword user field .");
		flag = signUpCreateAccountPartner.ValidateCreateAccountSignUp(false, false, false, false, true, false);
		CustomAssert.assertTrue(flag, "Verify that Validate the blankConfirmPassord user field .",
				"Unable to verify Validate the blankConfirmPassord user field .");
		flag = signUpCreateAccountPartner.ValidateCreateAccountSignUp(false, false, false, false, false, true);
		CustomAssert.assertTrue(flag, "Verify that Validate the WrongCredentials user field .",
				"Unable to verify Validate the WrongCredentials user field .");

	}


	@Test(priority = 4, description = " Verify that SignUp or Create Account is Successfully Created on Partner  ", enabled = true)
	public void TSSHYB218() {
		WaitClass.waitForTime(17000);
		boolean flag = signUpCreateAccountPartner.CreateAccountButtonClick();
		CustomAssert.assertTrue(flag, "Verify that Create Account Button is Working on Partner Sign In .",
				"Unable to Verify that Create Account Button is Working on Partner Sign In .");
		flag = signUpCreateAccountPartner.SignUpCreateAccount(name, UserNameGamer, EmailGamer, PasswordGamer,
				PasswordGamer);
		CustomAssert.assertTrue(flag, "Verify that SignUp or Create Account is Successfully Created on Partner.",
				"Unable to Verify SignUp or Create Account is Successfully Created on Partner.");
		Utility.setTempProperties("testDataVariables", "signUpUserCount", c + "");
		String verificationCode = code.getEmailData(EmailGamer, "body > em", 2);
		flag = signUpCreateAccountPartner.ConfirmAccount(verificationCode);
		CustomAssert.assertTrue(flag, "Account confirmed successfully", "having isssue with Account confirmation");
	}

	@Test(priority = 5, description = " Verify that SignUp or Create Account is Successfully Created on Partner after Resend the code ", enabled = false)
	public void TSSHYB219() {
		WaitClass.waitForTime(17000);
		boolean flag = signUpCreateAccountPartner.CreateAccountButtonClick();
		CustomAssert.assertTrue(flag, "Verify that Create Account Button is Working on Partner Sign In .",
				"Unable to Verify that Create Account Button is Working on Partner Sign In .");
		flag = signUpCreateAccountPartner.SignUpCreateAccount(name, UserNameGamer, EmailGamer, PasswordGamer,
				PasswordGamer);
		CustomAssert.assertTrue(flag, "Verify that SignUp or Create Account is Successfully Created on Partner.",
				"Unable to Verify SignUp or Create Account is Successfully Created on Partner.");
		Utility.setTempProperties("testDataVariables", "signUpUserCount", c + "");
		String verificationCode = code.getEmailData(EmailGamer, "body > em", 2);
		flag = signUpCreateAccountPartner.ConfirmAccountResend(verificationCode);
		CustomAssert.assertTrue(flag, "Account confirmed successfully", "having isssue with Account confirmation");
	}
}
