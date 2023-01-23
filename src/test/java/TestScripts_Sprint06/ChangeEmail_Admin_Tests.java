package TestScripts_Sprint06;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.ChangeEmail_Admin;
import PageObjectClasses.Change_Password_Admin;
import PageObjectClasses.MailBox;
import PageObjectClasses.SignIn_Admin_Pages;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class ChangeEmail_Admin_Tests {
	private WebDriver driver;
	MailBox code = new MailBox();
	
	SignIn_Admin_Pages signInAdmin;
	Change_Password_Admin changeAdmin;
	ChangeEmail_Admin changeEmail;
	String usernameAdmin;
	String userpasswordAdmin;
	int c;
	String EmailAdmin;
	String NewEmailAdmin;
	
	@BeforeClass
	public void beforeClass() {
		driver = DriverClass.setDriver("chrome", "admin");
		WaitClass.waitForTime(10000);
		code = new MailBox();
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		c = Integer.parseInt(count) + 1;
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		usernameAdmin = "admin_user_2022"+c;
		EmailAdmin = usernameAdmin+"@1secmail.com";
		userpasswordAdmin = "Qwerty@12345678";
		boolean flag = APICalls.prepareAdminAccount(Utility.getPropertiesFile("primaryLogin", "superAdminUsername"), Utility.getPropertiesFile("primaryLogin", "superAdminPassword"), "Automation Admin", usernameAdmin, EmailAdmin, userpasswordAdmin, driver);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(3000);
		driver.quit();
		count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		c = Integer.parseInt(count) + 1;
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		NewEmailAdmin = "admin_user_2022"+c+"@1secmail.com";
	}
	
	@BeforeMethod
	public void browserlaunch() {
		driver = DriverClass.setDriver("chrome", "admin");
		signInAdmin = new SignIn_Admin_Pages(driver);
		changeAdmin = new Change_Password_Admin(driver);
		changeEmail = new ChangeEmail_Admin(driver);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
    
	@Test( priority = 1, description = "Verify if Admin is on the Setting page by clicking on the Settings tab and Edit profile tab by default")
	public void TSSHYB370() {
		boolean flag = signInAdmin.signinActionAdmin(usernameAdmin, userpasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate Admin signin");
		flag = changeEmail.navigateToSettingPage();
		CustomAssert.assertTrue(flag, "Admin navigated on setting page successfully","Fail to navigate Admin setting page");
	}
	
	
	@Test( priority = 2, description = "Verify if Admin is able to view the change Email field in Change Password tab")
	public void TSSHYB371() {
		boolean flag = signInAdmin.signinActionAdmin(usernameAdmin, userpasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate Admin signin");
		flag = changeEmail.navigateToSettingPage();
		CustomAssert.assertTrue(flag, "Admin navigated on change password page successfully","Fail to navigate on Admin change password page");
		flag = changeEmail.validateEmailFieldChangePasswordPage();
		CustomAssert.assertTrue(flag, "Email field visibility validated successfully","Fail to validate Email field visibility");
	}
	
	@Test( priority = 3, description = "Verify if Admin is able to view the old email address as pre-filled. It should not be editable")
	public void TSSHYB372() {
		boolean flag = signInAdmin.signinActionAdmin(usernameAdmin, userpasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate Admin signin");
		flag = changeEmail.navigateToSettingPage();
		CustomAssert.assertTrue(flag, "Admin navigated on change password page successfully","Fail to navigate on Admin change password page");
		flag = changeEmail.ValidateEmailFieldData(EmailAdmin);
		CustomAssert.assertTrue(flag, "Email field value and disability validated successfully","Fail to validate Email field value and disability");
	}
	
	@Test( priority = 4, description = "Verify if Admin is able to click on Change button and Change Email Address pop-up will get opened.")
	public void TSSHYB373() {
		boolean flag = signInAdmin.signinActionAdmin(usernameAdmin, userpasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate Admin signin");
		flag = changeEmail.navigateToSettingPage();
		CustomAssert.assertTrue(flag, "Admin navigated on change password page successfully","Fail to navigate on Admin change password page");
		flag = changeEmail.ValidateEmailFieldData(EmailAdmin);
		CustomAssert.assertTrue(flag, "Email field value and disability validated successfully","Fail to validate Email field value and disability");
		flag = changeEmail.ValidateEmailFieldChangePopup();
		CustomAssert.assertTrue(flag, "Email field change pop-up validated successfully","Fail to validate Email field field change pop-up");
	}
	
	@Test( priority = 5, description = "Verify if Admin is able to view the warning message 'Please enter valid email address.' on clicking Confirm button by leaving the New Email Address field as blank or by entering incorrect format of email address.")
	public void TSSHYB374() {
		boolean flag = signInAdmin.signinActionAdmin(usernameAdmin, userpasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate Admin signin");
		flag = changeEmail.navigateToSettingPage();
		CustomAssert.assertTrue(flag, "Admin navigated on change password page successfully","Fail to navigate on Admin change password page");
		flag = changeEmail.ValidateEmailFieldChangePopup();
		CustomAssert.assertTrue(flag, "Email field change pop-up validated successfully","Fail to validate Email field field change pop-up");
		flag = changeEmail.validateEmailFieldsValidation(true, false);
		CustomAssert.assertTrue(flag, "Email blank field validation validated successfully","Fail to validate Email blank field validation");
		flag = changeEmail.validateEmailFieldsValidation(false, true);
		CustomAssert.assertTrue(flag, "Email field Invalid email validation validated successfully","Fail to validate Email field Invalid email validation");
		
	}
	
	@Test( priority = 6, description = "Verify if Admin is able to click on confirm by entering valid email address and view the Verification Code pop-up.")
	public void TSSHYB375() {
		boolean flag = signInAdmin.signinActionAdmin(usernameAdmin, userpasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate Admin signin");
		flag = changeEmail.navigateToSettingPage();
		CustomAssert.assertTrue(flag, "Admin navigated on change password page successfully","Fail to navigate on Admin change password page");
		flag = changeEmail.ValidateEmailFieldChangePopup();
		CustomAssert.assertTrue(flag, "Email field change pop-up validated successfully","Fail to validate Email field field change pop-up");
		flag = changeEmail.ValidateEmailFieldConfirmButton(NewEmailAdmin);
		CustomAssert.assertTrue(flag, "Email field change pop-up validated successfully","Fail to validate Email field field change pop-up");
		
	}
    
    @Test( priority = 7, description = "Verify if Admin is able to close the pop-ups by clicking on cancel button.")
	public void TSSHYB376() {
		boolean flag = changeEmail.signinActionAdminSkip(usernameAdmin, userpasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate Admin signin");
		flag = changeEmail.navigateToSettingPage();
		CustomAssert.assertTrue(flag, "Admin navigated on change password page successfully","Fail to navigate on Admin change password page");
		flag = changeEmail.validateCancelButtons();
		CustomAssert.assertTrue(flag, "All popups cancel buttons validated successfully","Fail to validate all popups cancel buttons");
		
	}
	
	@Test( priority = 8, description = "Verify if Admin is able to view 'invalid verification provided, please try again' toast message on clicking Confirm by leaving the box empty or by entering invalid verification code. ")
	public void TSSHYB377() {
		boolean flag = changeEmail.signinActionAdminSkip(usernameAdmin, userpasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate Admin signin");
		flag = changeEmail.navigateToSettingPage();
		CustomAssert.assertTrue(flag, "Admin navigated on change password page successfully","Fail to navigate on Admin change password page");
		flag = changeEmail.ValidateEmailFieldChangePopup();
		CustomAssert.assertTrue(flag, "Email field change pop-up validated successfully","Fail to validate Email field field change pop-up");
		flag = changeEmail.ValidateEmailFieldConfirmButton(NewEmailAdmin);
		CustomAssert.assertTrue(flag, "Email field confirm button validated successfully","Fail to validate Email field confirm button");
		flag = changeEmail.validateVerificationCodeValidation(true, false);
		CustomAssert.assertTrue(flag, "verification code blank field validation validated successfully","Fail to validate verification code blank field validation");
		flag = changeEmail.validateVerificationCodeValidation(false, true);
		CustomAssert.assertTrue(flag, "verification code Invalid validation validated successfully","Fail to validate verification code Invalid validation");
		
	}
	
	@Test( priority = 9, description = "Verify if Admin is able to see the old email address if email is not verified by putting in the verification code")
	public void TSSHYB378() {
		boolean flag = changeEmail.signinActionAdminSkip(usernameAdmin, userpasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate Admin signin");
		flag = changeEmail.navigateToSettingPage();
		CustomAssert.assertTrue(flag, "Admin navigated on change password page successfully","Fail to navigate on Admin change password page");
		flag = changeEmail.ValidateEmailFieldData(EmailAdmin);
		CustomAssert.assertTrue(flag, "Email field value and disability validated successfully","Fail to validate Email field value and disability");
			
	}
	
	@Test( priority = 10, description = "Verify if Admin is able to click on Confirm by entering valid verification code and view a success toast message 'Your email address changed successfully'")
	public void TSSHYB379() {
		boolean flag = changeEmail.signinActionAdminSkip(usernameAdmin, userpasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate Admin signin");
		flag = changeEmail.navigateToSettingPage();
		CustomAssert.assertTrue(flag, "Admin navigated on change password page successfully","Fail to navigate on Admin change password page");
		flag = changeEmail.ValidateEmailFieldChangePopup();
		CustomAssert.assertTrue(flag, "Email field change pop-up validated successfully","Fail to validate Email field field change pop-up");
		flag = changeEmail.ValidateEmailFieldConfirmButton(NewEmailAdmin);
		CustomAssert.assertTrue(flag, "Email field confirm button validated successfully","Fail to validate Email field confirm button");
		WaitClass.waitForTime(3000);
		String verificationCode = code.getEmailData(NewEmailAdmin, "body > em", 2);
		flag = changeEmail.ValidateValidVerificationCode(verificationCode);
		CustomAssert.assertTrue(flag, "Email field change pop-up validated successfully","Fail to validate Email field field change pop-up");
	
    }
    
    @Test( priority = 11, description = "Verify if Admin is able to view the new Email Address in the Email field.")
	public void TSSHYB380() {
		boolean flag = signInAdmin.signinActionAdmin(usernameAdmin, userpasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate Admin signin");
		flag = changeEmail.navigateToSettingPage();
		CustomAssert.assertTrue(flag, "Admin navigated on change password page successfully","Fail to navigate on Admin change password page");
		flag = changeEmail.ValidateEmailFieldData(NewEmailAdmin);
		CustomAssert.assertTrue(flag, "Email field value and disability validated successfully","Fail to validate Email field value and disability");
			
	}

}
