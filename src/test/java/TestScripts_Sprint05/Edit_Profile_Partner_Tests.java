package TestScripts_Sprint05;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.Edit_Profile_Partner;
import PageObjectClasses.MailBox;
import PageObjectClasses.SignIn_Partner_Pages;
import PageObjectClasses.SignUp_CreateAccount_Partner_Page;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Edit_Profile_Partner_Tests {
	
	private WebDriver driver;
	Edit_Profile_Partner editProfilePage;
	SignIn_Partner_Pages signInPartner;
	String userNamePartner;
	String passwordPartner;
	
	SignUp_CreateAccount_Partner_Page partner;
	MailBox mail;
	
	@BeforeClass
	public void beforeClass() {
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int c = Integer.parseInt(count)+1;
		userNamePartner = "qa_partner11"+c;
		String EmailParner = "qa_partner11"+c+"@1secmail.com";
		passwordPartner = "Qwerty@12345678";
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		
		driver = DriverClass.setDriver("chrome", "partner");
		partner = new SignUp_CreateAccount_Partner_Page(driver);
		WaitClass.waitForTime(10000);
		boolean flag = partner.CreateAccountButtonClick();
		Assert.assertTrue(flag);
		flag = partner.SignUpCreateAccount("Automation Partner", userNamePartner, EmailParner, passwordPartner, passwordPartner);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(5000);
        mail = new MailBox();
        String verificationCode = mail.getEmailData(EmailParner, "body > em", 2);
		flag = partner.ConfirmAccount(verificationCode);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(10000);
		driver.quit();
		flag = APICalls.preparePartnerAccountAfterSignup(EmailParner, userNamePartner, passwordPartner, Utility.getPropertiesFile("primaryLogin", "superAdminUsername"), Utility.getPropertiesFile("primaryLogin", "superAdminPassword"));
		Assert.assertTrue(flag);
	}

	
	@BeforeMethod
	public void beforeMethod() {
		driver = DriverClass.setDriver("chrome", "partner");
		signInPartner = new SignIn_Partner_Pages(driver);
		editProfilePage = new Edit_Profile_Partner(driver);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(description = "Verify if Partner is able to sign in through the correct credentials")
	public void TSSHYB306() {   
		boolean flag = signInPartner.signinActionPartner(userNamePartner, passwordPartner);
		CustomAssert.assertTrue(flag, "Partner login validated successfully","Fail to validate partner login");
	}
	
	@Test(description = "Verify if Partner is on the Settings landing page by clicking on the Settings tab")
	public void TSSHYB307() {   
		boolean flag = signInPartner.signinActionPartner(userNamePartner, passwordPartner);
		CustomAssert.assertTrue(flag, "Partner login validated successfully","Fail to validate partner login");
		flag = editProfilePage.navigateToEditProfilePage();
		CustomAssert.assertTrue(flag, "Partner Navigated to edit profile page","Fail to navigate on the edit profile page");
	}
	
	@Test(description = "Verify If Partner is able to change the logo image")
	public void TSSHYB308() {
		boolean flag = signInPartner.signinActionPartner(userNamePartner, passwordPartner);
		CustomAssert.assertTrue(flag, "Partner login validated successfully","Fail to validate partner login");
		flag = editProfilePage.navigateToEditProfilePage();
		CustomAssert.assertTrue(flag, "Partner Navigated to edit profile page","Fail to navigate on the edit profile page");
		flag = editProfilePage.uploadLogoAction();
		CustomAssert.assertTrue(flag, "Partner logo uploaded successfully","Fail to upload profile logo");
		
	}
	
	@Test(description = "Verify If Partner can change only the logo under general information tab")
	public void TSSHYB309() {
		boolean flag = signInPartner.signinActionPartner(userNamePartner, passwordPartner);
		CustomAssert.assertTrue(flag, "Partner login validated successfully","Fail to validate partner login");
		flag = editProfilePage.navigateToEditProfilePage();
		CustomAssert.assertTrue(flag, "Partner Navigated to edit profile page","Fail to navigate on the edit profile page");
		flag = editProfilePage.validateAllTextFieldsDisabled();
		CustomAssert.assertTrue(flag, "Edit profile text fields disability validated successfully","Fail to validate disability of Edit profile text fields");
	}
	
	@Test(description = "Verify If Partner can change all the informations under contact information except Authorized signatory")
	public void TSSHYB310() {
		boolean flag = signInPartner.signinActionPartner(userNamePartner, passwordPartner);
		CustomAssert.assertTrue(flag, "Partner login validated successfully","Fail to validate partner login");
		flag = editProfilePage.navigateToEditProfilePage();
		CustomAssert.assertTrue(flag, "Partner Navigated to edit profile page","Fail to navigate on the edit profile page");
		flag = editProfilePage.contactInformationUpdateAction();
		CustomAssert.assertTrue(flag, "Contact information updated successfully","Fail to update contact information");
	}
	
	@Test(description = "Verify If Partner cannot change anything in other information tab")
	public void TSSHYB311() {
		boolean flag = signInPartner.signinActionPartner(userNamePartner, passwordPartner);
		CustomAssert.assertTrue(flag, "Partner login validated successfully","Fail to validate partner login");
		flag = editProfilePage.navigateToEditProfilePage();
		CustomAssert.assertTrue(flag, "Partner Navigated to edit profile page","Fail to navigate on the edit profile page");
		flag = editProfilePage.otherInformationEditablefieldsValidation();
		CustomAssert.assertTrue(flag, "Other information all fields disability validated successfully","Fail to check fields disability other information");
	}
	
	@Test(description = "After making changes, user can click on update button and changes will be immediately reflected without any permission")
	public void TSSHYB312() {
		boolean flag = signInPartner.signinActionPartner(userNamePartner, passwordPartner);
		CustomAssert.assertTrue(flag, "Partner login validated successfully","Fail to validate partner login");
		flag = editProfilePage.navigateToEditProfilePage();
		CustomAssert.assertTrue(flag, "Partner Navigated to edit profile page","Fail to navigate on the edit profile page");
		flag = editProfilePage.otherInformationUpdateValidation();
		CustomAssert.assertTrue(flag, "other information updated successfully","Fail to update other information");
	}

}
