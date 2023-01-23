package TestScripts_Sprint06;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BaseClass.DriverClass;
import PageObjectClasses.ChangeEmail_Partner;
import PageObjectClasses.MailBox;
import PageObjectClasses.SignIn_Partner_Pages;
import PageObjectClasses.SignUp_CreateAccount_Partner_Page;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class ChangeEmail_Partner_Tests {
	
	private WebDriver driver;
	MailBox code = new MailBox();
	
	SignIn_Partner_Pages signInPartner;
	ChangeEmail_Partner changeEmail;
	String usernameAdmin;
	String userpasswordAdmin;
	ChangeEmail_Partner partnerPendingAndAmendmentFlow;
	SignUp_CreateAccount_Partner_Page partner;
	MailBox mail;
	String EmailParner;
	String userpasswordPartner;
	String NewEmailPartner;
	String usernamePartner;
	
	@BeforeClass
	public void beforeClass() {
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int c = Integer.parseInt(count)+1;
		usernamePartner = "qa_partner11"+c;
		EmailParner = "qa_partner11"+c+"@1secmail.com";
		userpasswordPartner = "Qwerty@12345678";
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		
		driver = DriverClass.setDriver("chrome", "partner");
		partner = new SignUp_CreateAccount_Partner_Page(driver);
		WaitClass.waitForTime(10000);
		boolean flag = partner.CreateAccountButtonClick();
		Assert.assertTrue(flag);
		flag = partner.SignUpCreateAccount("Automation Partner", usernamePartner, EmailParner, userpasswordPartner, userpasswordPartner);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(5000);
        mail = new MailBox();
        String verificationCode = mail.getEmailData(EmailParner, "body > em", 2);
		flag = partner.ConfirmAccount(verificationCode);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(10000);
		driver.quit();
		flag = APICalls.preparePartnerAccountAfterSignup(EmailParner, usernamePartner, userpasswordPartner, Utility.getPropertiesFile("primaryLogin", "superAdminUsername"), Utility.getPropertiesFile("primaryLogin", "superAdminPassword"));
		Assert.assertTrue(flag);
		
		count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		c = Integer.parseInt(count)+1;
		NewEmailPartner = "qa_partner11"+c+"@1secmail.com";
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
	}
	
	@BeforeMethod
	public void browserlaunch() {
		driver = DriverClass.setDriver("chrome", "partner");
		signInPartner = new SignIn_Partner_Pages(driver);
		changeEmail = new ChangeEmail_Partner(driver);
		partnerPendingAndAmendmentFlow = new ChangeEmail_Partner(driver);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
    
	@Test( enabled = true,description = "Verify if Partner is on the Setting page by clicking on the Settings tab and Edit profile tab by default")
	public void TSSHYB381() {
		boolean flag = signInPartner.signinActionPartner(usernamePartner, userpasswordPartner);
		CustomAssert.assertTrue(flag, "Partner sigin validated successfully","Fail to validate partner signin");
		flag = changeEmail.navigateToSettingPage();
		CustomAssert.assertTrue(flag, "Partner navigated on setting page successfully","Fail to navigate partner setting page");
	}
	
	@Test( enabled = true,description = "Verify if Partner is on the Setting page by clicking on the Settings tab and Edit profile tab by default")
	public void TSSHYB382() {
		boolean flag = signInPartner.signinActionPartner(usernamePartner, userpasswordPartner);
		CustomAssert.assertTrue(flag, "Partner sigin validated successfully","Fail to validate partner signin");
		flag = changeEmail.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner navigated on change password page successfully","Fail to navigate on partner change password page");
	}
	
	@Test( enabled = true,description = "Verify if Partner is able to view the change Email field in Change Password tab")
	public void TSSHYB383() {
		boolean flag = signInPartner.signinActionPartner(usernamePartner, userpasswordPartner);
		CustomAssert.assertTrue(flag, "Partner sigin validated successfully","Fail to validate partner signin");
		flag = changeEmail.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner navigated on change password page successfully","Fail to navigate on partner change password page");
		flag = changeEmail.validateEmailFieldChangePasswordPage();
		CustomAssert.assertTrue(flag, "Email field visibility validated successfully","Fail to validate Email field visibility");
	}
	
	@Test( enabled = true,description = "Verify if Partner is able to view the old email address as pre-filled. It should not be editable")
	public void TSSHYB384() {
		boolean flag = signInPartner.signinActionPartner(usernamePartner, userpasswordPartner);
		CustomAssert.assertTrue(flag, "Partner sigin validated successfully","Fail to validate partner signin");
		flag = changeEmail.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner navigated on change password page successfully","Fail to navigate on partner change password page");
		flag = changeEmail.ValidateEmailFieldData(EmailParner);
		CustomAssert.assertTrue(flag, "Email field value and disability validated successfully","Fail to validate Email field value and disability");
	}
	
	@Test( enabled = true,description = "Verify if Partner is able to click on Change button and Change Email Address pop-up will get opened.")
	public void TSSHYB385() {
		boolean flag = signInPartner.signinActionPartner(usernamePartner, userpasswordPartner);
		CustomAssert.assertTrue(flag, "Partner sigin validated successfully","Fail to validate partner signin");
		flag = changeEmail.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner navigated on change password page successfully","Fail to navigate on partner change password page");
		flag = changeEmail.ValidateEmailFieldData(EmailParner);
		CustomAssert.assertTrue(flag, "Email field value and disability validated successfully","Fail to validate Email field value and disability");
		flag = changeEmail.ValidateEmailFieldChangePopup();
		CustomAssert.assertTrue(flag, "Email field change pop-up validated successfully","Fail to validate Email field field change pop-up");
	}
	
	@Test( enabled = true,description = "Verify if Partner is able to view the warning message 'Please enter valid email address.' on clicking Confirm button by leaving the New Email Address field as blank or by entering incorrect format of email address.")
	public void TSSHYB386() {
		boolean flag = signInPartner.signinActionPartner(usernamePartner, userpasswordPartner);
		CustomAssert.assertTrue(flag, "Partner sigin validated successfully","Fail to validate partner signin");
		flag = changeEmail.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner navigated on change password page successfully","Fail to navigate on partner change password page");
		flag = changeEmail.ValidateEmailFieldChangePopup();
		CustomAssert.assertTrue(flag, "Email field change pop-up validated successfully","Fail to validate Email field field change pop-up");
		flag = changeEmail.validateEmailFieldsValidation(true, false);
		CustomAssert.assertTrue(flag, "Email blank field validation validated successfully","Fail to validate Email blank field validation");
		flag = changeEmail.validateEmailFieldsValidation(false, true);
		CustomAssert.assertTrue(flag, "Email field Invalid email validation validated successfully","Fail to validate Email field Invalid email validation");
		
	}
	
	@Test( enabled = true,description = "Verify if Partner is able to click on confirm by entering valid email address and view the Verification Code pop-up.")
	public void TSSHYB387() {
		boolean flag = signInPartner.signinActionPartner(usernamePartner, userpasswordPartner);
		CustomAssert.assertTrue(flag, "Partner sigin validated successfully","Fail to validate partner signin");
		flag = changeEmail.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner navigated on change password page successfully","Fail to navigate on partner change password page");
		flag = changeEmail.ValidateEmailFieldChangePopup();
		CustomAssert.assertTrue(flag, "Email field change pop-up validated successfully","Fail to validate Email field field change pop-up");
		flag = changeEmail.ValidateEmailFieldConfirmButton(NewEmailPartner);
		CustomAssert.assertTrue(flag, "Email field change pop-up validated successfully","Fail to validate Email field field change pop-up");
		
	}
    
    @Test( enabled = true,description = "Verify if Partner is able to close the pop-ups by clicking on cancel button.")
	public void TSSHYB388() {
		boolean flag = changeEmail.signinActionPartnerSkip(usernamePartner, userpasswordPartner);
		CustomAssert.assertTrue(flag, "Partner sigin validated successfully","Fail to validate partner signin");
		flag = changeEmail.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner navigated on change password page successfully","Fail to navigate on partner change password page");
		flag = changeEmail.validateCancelButtons();
		CustomAssert.assertTrue(flag, "All popups cancel buttons validated successfully","Fail to validate all popups cancel buttons");
		
	}
	
	@Test( enabled = true,description = "Verify if Partner is able to view 'invalid verification provided, please try again' toast message on clicking Confirm by leaving the box empty or by entering invalid verification code. ")
	public void TSSHYB389() {
		boolean flag = changeEmail.signinActionPartnerSkip(usernamePartner, userpasswordPartner);
		CustomAssert.assertTrue(flag, "Partner sigin validated successfully","Fail to validate partner signin");
		flag = changeEmail.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner navigated on change password page successfully","Fail to navigate on partner change password page");
		flag = changeEmail.ValidateEmailFieldChangePopup();
		CustomAssert.assertTrue(flag, "Email field change pop-up validated successfully","Fail to validate Email field field change pop-up");
		flag = changeEmail.ValidateEmailFieldConfirmButton(NewEmailPartner);
		CustomAssert.assertTrue(flag, "Email field confirm button validated successfully","Fail to validate Email field confirm button");
		flag = changeEmail.validateVerificationCodeValidation(true, false);
		CustomAssert.assertTrue(flag, "verification code blank field validation validated successfully","Fail to validate verification code blank field validation");
		flag = changeEmail.validateVerificationCodeValidation(false, true);
		CustomAssert.assertTrue(flag, "verification code Invalid validation validated successfully","Fail to validate verification code Invalid validation");
		
	}
	
	@Test( enabled = true,description = "Verify if Partner is able to see the old email address if email is not verified by putting in the verification code")
	public void TSSHYB390() {
		boolean flag = changeEmail.signinActionPartnerSkip(usernamePartner, userpasswordPartner);
		CustomAssert.assertTrue(flag, "Partner sigin validated successfully","Fail to validate partner signin");
		flag = changeEmail.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner navigated on change password page successfully","Fail to navigate on partner change password page");
		flag = changeEmail.ValidateEmailFieldData(EmailParner);
		CustomAssert.assertTrue(flag, "Email field value and disability validated successfully","Fail to validate Email field value and disability");
			
	}
	
	@Test( enabled = true,description = "Verify if Partner is able to click on Confirm by entering valid verification code and view a success toast message 'Your email address changed successfully'")
	public void TSSHYB391() {
		boolean flag = changeEmail.signinActionPartnerSkip(usernamePartner, userpasswordPartner);
		CustomAssert.assertTrue(flag, "Partner sigin validated successfully","Fail to validate partner signin");
		flag = changeEmail.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner navigated on change password page successfully","Fail to navigate on partner change password page");
		flag = changeEmail.ValidateEmailFieldChangePopup();
		CustomAssert.assertTrue(flag, "Email field change pop-up validated successfully","Fail to validate Email field field change pop-up");
		flag = changeEmail.ValidateEmailFieldConfirmButton(NewEmailPartner);
		CustomAssert.assertTrue(flag, "Email field confirm button validated successfully","Fail to validate Email field confirm button");
		WaitClass.waitForTime(3000);
		String verificationCode = code.getEmailData(NewEmailPartner, "body > em", 2);
		flag = changeEmail.ValidateValidVerificationCode(verificationCode);
		CustomAssert.assertTrue(flag, "Email field change pop-up validated successfully","Fail to validate Email field field change pop-up");
	
    }
    
    @Test( enabled = true,description = "Verify if Partner is able to view the new Email Address in the Email field.")
	public void TSSHYB392() {
		boolean flag = signInPartner.signinActionPartner(usernamePartner, userpasswordPartner);
		CustomAssert.assertTrue(flag, "Partner sigin validated successfully","Fail to validate partner signin");
		flag = changeEmail.navigateToChangePasswordPage();
		CustomAssert.assertTrue(flag, "Partner navigated on change password page successfully","Fail to navigate on partner change password page");
		flag = changeEmail.ValidateEmailFieldData(NewEmailPartner);
		CustomAssert.assertTrue(flag, "Email field value and disability validated successfully","Fail to validate Email field value and disability");
			
	}
}
