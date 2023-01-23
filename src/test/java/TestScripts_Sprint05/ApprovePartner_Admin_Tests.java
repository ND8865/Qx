package TestScripts_Sprint05;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.ApprovePartner_Admin;
import PageObjectClasses.MailBox;
import PageObjectClasses.SignIn_Admin_Pages;
import PageObjectClasses.SignUp_CreateAccount_Partner_Page;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class ApprovePartner_Admin_Tests {
	
	private WebDriver driver;
	SignIn_Admin_Pages signInAdmin;
	String username;
	String userpassword;
	String adminUser;
	String adminPass;
	String EmailParner;
	
	ApprovePartner_Admin partnersUserPage;
	
	SignUp_CreateAccount_Partner_Page partner;
	MailBox mail;
	
	@BeforeClass
	public void beforeClass() {
		adminUser = Utility.getPropertiesFile("primaryLogin", "superAdminUsername");
		adminPass = Utility.getPropertiesFile("primaryLogin", "superAdminPassword");
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int c = Integer.parseInt(count)+1;
		username = "qa_partner11"+c;
		EmailParner = "qa_partner11"+c+"@1secmail.com";
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
		flag = APICalls.preparePendingPartnerAccountAfterSignup(EmailParner, username, userpassword);
		Assert.assertTrue(flag);
	}

	@BeforeMethod
	public void browserlaunch() {
		driver = DriverClass.setDriver("chrome", "admin");
		signInAdmin = new SignIn_Admin_Pages(driver);
		partnersUserPage = new ApprovePartner_Admin(driver);
		
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
    
	@Test( description = "Verify that the user should click on resolve for three edit modifications before clicking on Accept and Confirm button")
	public void TSSHYB284() {
		boolean flag = signInAdmin.signinActionAdmin(adminUser, adminPass);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner detail page","Fail to navigae on partner detail page.");
		flag = partnersUserPage.suggestModificationFlow(true, false, false);
		CustomAssert.assertTrue(flag, "General info modification validated successfully","Fail to validate General info modification");
		flag = partnersUserPage.suggestModificationFlow(false, true, false);
		CustomAssert.assertTrue(flag, "Contact info modification validated successfully","Fail to validate contact info modification");
		flag = partnersUserPage.suggestModificationFlow(false, false, true);
		CustomAssert.assertTrue(flag, "Other info modification validated successfully","Fail to validate other info modification");
	}
	
	@Test( description = "Verify if user doesn't type in text and click on send modification, he should get a pop up message saying Suggest some modification")
	public void TSSHYB285() {
		boolean flag = signInAdmin.signinActionAdmin(adminUser, adminPass);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner detail page","Fail to navigae on partner detail page.");
		flag = partnersUserPage.sendModificationBlankValidation();
		CustomAssert.assertTrue(flag, "Send modification validation validated successfully","Fail to validate Send modification validation");
	}
	
	@Test( description = "Verify that if there are no suggestions then user should be able to click on Accept and confirm")
	public void TSSHYB286() {
		boolean flag = signInAdmin.signinActionAdmin(adminUser, adminPass);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner detail page","Fail to navigae on partner detail page.");
		flag = partnersUserPage.validateAcceptAndConfirmButton();
		CustomAssert.assertTrue(flag, "Accept and confirm button validated successfully","Fail to validate Accept and confirm button");
	}
	
	@Test( description = "Verify on clicking on Accept and Confirm user should get a pop up asking for envelope ID")
	public void TSSHYB287() {
		boolean flag = signInAdmin.signinActionAdmin(adminUser, adminPass);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner detail page","Fail to navigae on partner detail page.");
		flag = partnersUserPage.validateConfirmPopup();
		CustomAssert.assertTrue(flag, "Accept and confirm button pop-up validated successfully","Fail to validate Accept and confirm button pop-up");
	}
	
	@Test( description = "Verify that the admin fills in the document which consists of the terms and conditions that have been finalized between the partner and the admin and enter the envelope ID")
	public void TSSHYB288() {
		boolean flag = signInAdmin.signinActionAdmin(adminUser, adminPass);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner detail page","Fail to navigae on partner detail page.");
		flag = partnersUserPage.envelopeIdSubmission();
		CustomAssert.assertTrue(flag, "Envelope ID submitted successfully","Fail to validate Envelope ID submission.");
	}
	
	@Test( description = "Verify that partner receives the email with the document that he needs to sign")
	public void TSSHYB289() {
		boolean flag = partnersUserPage.docuSignValidateEmail(EmailParner);
		CustomAssert.assertTrue(flag, "Email docuSign link validated successfully","Fail to validate Email docuSign link");
		
	}
	
	@Test( description = "Verify if Admin can manually approve/Reject the Partner by clicking on approve/reject button")
	public void TSSHYB290() {
		boolean flag = signInAdmin.signinActionAdmin(adminUser, adminPass);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerDetailManualApprove();
		CustomAssert.assertTrue(flag, "Admin navigated to partner detail page","Fail to navigae on partner detail page.");
		flag = partnersUserPage.approveMannuallyButtonFlow();
		CustomAssert.assertTrue(flag, "Manually approve button validated successfully","Fail to validate Manually approve button.");
	}
	
	@Test( description = "Verify that the Status of partner is changed to Approved/Rejected")
	public void TSSHYB291() {
		boolean flag = signInAdmin.signinActionAdmin(adminUser, adminPass);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.approvedPartnerStatusValidate(EmailParner);
		CustomAssert.assertTrue(flag, "Approved status validated for onborded partner","Fail to validate Approved status for onborded partner");
	}
}
