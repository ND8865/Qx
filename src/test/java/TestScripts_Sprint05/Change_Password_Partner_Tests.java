package TestScripts_Sprint05;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.Change_Password_Partner;
import PageObjectClasses.MailBox;
import PageObjectClasses.SignIn_Partner_Pages;
import PageObjectClasses.SignUp_CreateAccount_Partner_Page;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Change_Password_Partner_Tests {
	
	private WebDriver driver;
	Change_Password_Partner changePasswordPage;
	SignIn_Partner_Pages signInPartner;
	String userNamePartner;
	String PasswordPartner;
	String NewPassword;
	String oldPassword;
	int d = 0;
	int c = 0;
	
	SignUp_CreateAccount_Partner_Page partner;
	MailBox mail;
	
	@BeforeClass
	public void beforeClass() {
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int c = Integer.parseInt(count)+1;
		userNamePartner = "qa_partner11"+c;
		String EmailParner = "qa_partner11"+c+"@1secmail.com";
		PasswordPartner = "Qwerty@12345678";
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		
		driver = DriverClass.setDriver("chrome", "partner");
		partner = new SignUp_CreateAccount_Partner_Page(driver);
		WaitClass.waitForTime(10000);
		boolean flag = partner.CreateAccountButtonClick();
		Assert.assertTrue(flag);
		flag = partner.SignUpCreateAccount("Automation Partner", userNamePartner, EmailParner, PasswordPartner, PasswordPartner);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(5000);
        mail = new MailBox();
        String verificationCode = mail.getEmailData(EmailParner, "body > em", 2);
		flag = partner.ConfirmAccount(verificationCode);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(10000);
		driver.quit();
		flag = APICalls.preparePartnerAccountAfterSignup(EmailParner, userNamePartner, PasswordPartner, Utility.getPropertiesFile("primaryLogin", "superAdminUsername"), Utility.getPropertiesFile("primaryLogin", "superAdminPassword"));
		Assert.assertTrue(flag);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver = DriverClass.setDriver("chrome", "partner");
		signInPartner = new SignIn_Partner_Pages(driver);
		changePasswordPage = new Change_Password_Partner(driver);
		String count = Utility.getPropertiesFile("testDataVariables", "partnerPasswordCount");
		d = Integer.parseInt(count);
		c = Integer.parseInt(count)+1;
		oldPassword = "Qwerty@12345678"+d;


		
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(description = "Verify if  Partner is able to sign in through the correct credentials lands on change password page by clicking on the Settings tab")
	public void TSSHYB299() 
	{   
		boolean flag = signInPartner.signinActionPartner(userNamePartner, PasswordPartner);
		CustomAssert.assertTrue(flag, "Partner login validated successfully","Fail to validate partner login");
		flag = changePasswordPage.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner Navigated to settings page","Fail to navigate on the change password page");
		
	}
	
	@Test(description = "Verify if Partner is able to  see all contents on change password page.")
	public void TSSHYB300() 
	{   
		boolean flag = signInPartner.signinActionPartner(userNamePartner, PasswordPartner);
		CustomAssert.assertTrue(flag, "Partner login validated successfully","Fail to validate partner login");
		flag = changePasswordPage.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner Navigated to settings page","Fail to navigate on the change password page");
		flag = changePasswordPage.validateAllElementsChangePasswordPage();
		CustomAssert.assertTrue(flag, "All elements are validated successfully on the change password Page.","Fail to  validated all elements on the change password Page.");
		
	}
	
	@Test(description = "Verify If Partner enters invalid current password.")
	public void TSSHYB301() 
	{   
		boolean flag = signInPartner.signinActionPartner(userNamePartner, PasswordPartner);
		CustomAssert.assertTrue(flag, "Partner login validated successfully","Fail to validate partner login");
		flag = changePasswordPage.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner Navigated to settings page","Fail to navigate on the change password page");
		flag = changePasswordPage.validateFieldsValidation(true, false, false);
		CustomAssert.assertTrue(flag, "Blank fields validation validated successfully.","Fail to  validated Blank fields validation");
		flag = changePasswordPage.validateFieldsValidation(false, true, false);
		CustomAssert.assertTrue(flag, "Invalid current password validated successfully.","Fail to  validated Invalid current password");
		
	}
	
	@Test(description = "Verify If Partner can see an error message, if the new password and the confirm new password don't match.")
	public void TSSHYB302() 
	{   
		boolean flag = signInPartner.signinActionPartner(userNamePartner, PasswordPartner);
		CustomAssert.assertTrue(flag, "Partner login validated successfully","Fail to validate partner login");
		flag = changePasswordPage.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner Navigated to settings page","Fail to navigate on the change password page");
		flag = changePasswordPage.validateFieldsValidation(false, false, true);
		CustomAssert.assertTrue(flag, "Confirm password mismatch validated successfully.","Fail to  validated Confirm password mismatch");
		
	}
	
	@Test(description = "Verify If Partner can add the current password.")
	public void TSSHYB303() 
	{   
		boolean flag = signInPartner.signinActionPartner(userNamePartner, PasswordPartner);
		CustomAssert.assertTrue(flag, "Partner login validated successfully","Fail to validate partner login");
		flag = changePasswordPage.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner Navigated to settings page","Fail to navigate on the change password page");
		flag = changePasswordPage.changePasswordAction(true, false , false);
		CustomAssert.assertTrue(flag, "Current password field filling validated successfully.","Fail to  validated Current password field filling");
		
	}
	
	@Test(description = "Verify if Partner can add new password & Confirm new password.")
	public void TSSHYB304() 
	{   
		boolean flag = signInPartner.signinActionPartner(userNamePartner, PasswordPartner);
		CustomAssert.assertTrue(flag, "Partner login validated successfully","Fail to validate partner login");
		flag = changePasswordPage.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner Navigated to settings page","Fail to navigate on the change password page");
		flag = changePasswordPage.changePasswordAction(false, true , false);
		CustomAssert.assertTrue(flag, "new password & Confirm password fields filling validated successfully.","Fail to  validated new password & Confirm password fields filling.");
		
	}
	
	@Test(description = "Verify If Partner can click on Update to change the password.")
	public void TSSHYB305() 
	{   
		String EditableUserNamePartner = Utility.getPropertiesFile("primaryLogin", "partnerUsername4");
		boolean flag = signInPartner.signinActionPartner(EditableUserNamePartner, oldPassword);
		CustomAssert.assertTrue(flag, "Partner login validated successfully","Fail to validate partner login");
		WaitClass.waitForTime(4000);
		flag = changePasswordPage.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner Navigated to settings page","Fail to navigate on the change password page");
		flag = changePasswordPage.changePasswordAction(false, false , true);
		CustomAssert.assertTrue(flag, "Change password update button validated successfully.","Fail to  validated Change password update button");
		Utility.setTempProperties("testDataVariables", "partnerPasswordCount",c+"");
		
	}

}
