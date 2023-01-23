package TestScripts_Sprint05;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.Admin_Partners_Enable_Disable_page;
import PageObjectClasses.Admin_Partners_Page;
import PageObjectClasses.MailBox;
import PageObjectClasses.SignIn_Admin_Pages;
import PageObjectClasses.SignIn_Partner_Pages;
import PageObjectClasses.SignUp_CreateAccount_Partner_Page;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Admin_Partners_Enable_Disable_Test {
	private WebDriver driver;
	SignIn_Admin_Pages signInAdmin;
	SignUp_CreateAccount_Partner_Page partner;
	MailBox mail;
	String username;
	String userpassword;
	String username1;
	String userpassword1;
	Admin_Partners_Page adminPartners;
	Admin_Partners_Enable_Disable_page adminPartnerEnableDisable;
	SignIn_Partner_Pages signInPartner;
	
	@BeforeClass
	public void beforeClass() {
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int c = Integer.parseInt(count)+1;
		username1 = "qa_partner11"+c;
		String EmailParner = "qa_partner11"+c+"@1secmail.com";
		userpassword1 = "Qwerty@12345678";
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		
		driver = DriverClass.setDriver("chrome", "partner");
		partner = new SignUp_CreateAccount_Partner_Page(driver);
		WaitClass.waitForTime(10000);
		boolean flag = partner.CreateAccountButtonClick();
		Assert.assertTrue(flag);
		flag = partner.SignUpCreateAccount("Automation Partner", username1, EmailParner, userpassword1, userpassword1);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(5000);
        mail = new MailBox();
        String verificationCode = mail.getEmailData(EmailParner, "body > em", 2);
		flag = partner.ConfirmAccount(verificationCode);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(10000);
		driver.quit();
		flag = APICalls.preparePartnerAccountAfterSignup(EmailParner, username1, userpassword1, Utility.getPropertiesFile("primaryLogin", "superAdminUsername"), Utility.getPropertiesFile("primaryLogin", "superAdminPassword"));
		Assert.assertTrue(flag);
	}

	@BeforeMethod
	public void browserlaunch() {

		driver = DriverClass.setDriver("chrome", "admin");
		signInAdmin = new SignIn_Admin_Pages(driver);
		username = Utility.getPropertiesFile("primaryLogin", "superAdminUsername");
		userpassword = Utility.getPropertiesFile("primaryLogin", "superAdminPassword");
		adminPartners = new Admin_Partners_Page(driver);
		adminPartnerEnableDisable = new Admin_Partners_Enable_Disable_page(driver);
		signInPartner = new SignIn_Partner_Pages(driver);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1, description = " Verify if Admin is able to sign in through the correct credentials ", enabled = true)
	public void TSSHYB257() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
	}

	@Test(priority = 2, description = " Verify if Admin is able to click on Partners tab ", enabled = true)
	public void TSSHYB258() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");

	}

	@Test(priority = 3, description = "Verify if Admin is able to filter the disabled partners.", enabled = true)
	public void TSSHYB259() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerEnableDisable.DisablePartners();
		CustomAssert.assertTrue(flag, "Verify if ADMIN is able to filter the disabled partners.",
				"Unable to if ADMIN is able to filter the disabled partners.");
	}

	@Test(priority = 4, description = "Verify if Admin is able to see all the inactive Partners.", enabled = true)
	public void TSSHYB260() {
	
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerEnableDisable.DisablePartners();
		CustomAssert.assertTrue(flag, "Verify if Admin is able to see all the inactive Partners.",
				"Unable to Verify if Admin is able to see all the inactive Partners.");
	}

	@Test(priority = 5, description = " Verify if Admin is able to filter the Approved partners.", enabled = true)
	public void TSSHYB261() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerEnableDisable.FilterApprovedPartners();
		CustomAssert.assertTrue(flag, "Verify if Admin is able to see all the Approved Partners.",
				"Unable to Verify if Admin is able to see all the Approved Partners.");
	}

	@Test(priority = 6, description = " Verify if Admin is able to click on view button for Active partner.", enabled = true)
	public void TSSHYB262() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerEnableDisable.FilterApprovedPartners();
		CustomAssert.assertTrue(flag, "Verify if Admin is able to see all the Approved Partners.",
				"Unable to Verify if Admin is able to see all the Approved Partners.");
		flag = adminPartnerEnableDisable.ClickViewButton(username1);
		CustomAssert.assertTrue(flag, "Verify if Admin is able to Click on the view button .",
				"Unable to Verify if Admin is able to Click on the view button .");
	}

	@Test(priority = 7, description = " Verify if Admin is able to change the toggle button.", enabled = true)
	public void TSSHYB263() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerEnableDisable.ClickViewButton(username1);
		CustomAssert.assertTrue(flag, "Verify if Admin is able to Click on the view button .",
				"Unable to Verify if Admin is able to Click on the view button .");
		flag = adminPartnerEnableDisable.ToggleButton();
		CustomAssert.assertTrue(flag, "Verify if Admin is able to Click on the toggle button .",
				"Unable to Verify if Admin is able to Click on the toggle button .");
	}

	@Test(priority = 8, description = " Verify if Admin gets a pop up saying Deactivate partner ", enabled = true)
	public void TSSHYB264() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerEnableDisable.ClickViewButton(username1);
		CustomAssert.assertTrue(flag, "Verify if Admin is able to Click on the view button .",
				"Unable to Verify if Admin is able to Click on the view button .");
		flag = adminPartnerEnableDisable.ToggleButton();
		CustomAssert.assertTrue(flag, "Verify if Admin is able to Click on the toggle button .",
				"Unable to Verify if Admin is able to Click on the toggle button .");
	}

	@Test(priority = 9, description = " Verify if Admin can click on  Cancel button ", enabled = true)
	public void TSSHYB265() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerEnableDisable.ClickViewButton(username1);
		CustomAssert.assertTrue(flag, "Verify if Admin is able to Click on the view button .",
				"Unable to Verify if Admin is able to Click on the view button .");
		flag = adminPartnerEnableDisable.ToggleButton();
		CustomAssert.assertTrue(flag, "Verify if Admin is able to Click on the toggle button .",
				"Unable to Verify if Admin is able to Click on the toggle button .");
		flag = adminPartnerEnableDisable.DeactivatePartners();
		CustomAssert.assertTrue(flag, "Verify if Admin can click on  Cancel button.",
				"Unable to Verify if Admin can click on  Cancel button.");
	}

	@Test(priority = 10, description = "Verify if Admin clicks on Confirm, partner is deactivated.", enabled = true)
	public void TSSHYB266() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerEnableDisable.ClickViewButton(username1);
		CustomAssert.assertTrue(flag, "Verify if Admin is able to Click on the view button .",
				"Unable to Verify if Admin is able to Click on the view button .");
		flag = adminPartnerEnableDisable.ToggleButton();
		CustomAssert.assertTrue(flag, "Verify if Admin is able to Click on the toggle button .",
				"Unable to Verify if Admin is able to Click on the toggle button .");
		flag = adminPartnerEnableDisable.DeactivatePartnersConfirm();
		CustomAssert.assertTrue(flag, "Verify if Admin clicks on Confirm, partner is deactivated.",
				"Unable to Verify if Admin clicks on Confirm, partner is deactivated.");
	}

	@Test(priority = 11, description = "Verify if deactivated partner has Tooltip after click on the Confirm button .", enabled = true)
	public void TSSHYB267() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerEnableDisable.ClickViewButton(username1);
		CustomAssert.assertTrue(flag, "Verify if Admin is able to Click on the view button .",
				"Unable to Verify if Admin is able to Click on the view button .");
		flag = adminPartnerEnableDisable.ToggleButton();
		CustomAssert.assertTrue(flag, "Verify if Admin is able to Click on the toggle button .",
				"Unable to Verify if Admin is able to Click on the toggle button .");
		flag = adminPartnerEnableDisable.Disablealerttext();
		CustomAssert.assertTrue(flag, "Verify if deactivated partner has Tooltip after click on the Confirm button .",
				"Unable to Verify if deactivated partner has Tooltip after click on the Confirm button .");
	}

	@Test(priority = 12, description = "Verify if all the Games, Offers & Events of that partner will get disabled.", enabled = true)
	public void TSSHYB268() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerEnableDisable.ValidateDisabledPartners();
		CustomAssert.assertTrue(flag, "Verify if all the Games, Offers & Events of that partner will get disabled.",
				"Unable to Verify if all the Games, Offers & Events of that partner will get disabled.");
	}

	@Test(priority = 13, description = " Verify if account is disabled and for already loged in partner after screen refreshing user is disabled text message will apper.", enabled = false)
	public void TSSHYB269() {

	
		driver = DriverClass.setDriver("chrome", "partner");
		
		boolean flag = signInPartner.signinActionPartner(username1, userpassword1);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner is disabled .",
				"Unable to Verify Sign In is Successful on  Partner is Disabled.");
		flag = adminPartnerEnableDisable.ValidateDisabledAccount();
		CustomAssert.assertTrue(flag, "Verify Disabled text is preset after log in the partner with Disable Account.",
				"Unable to Verify Disabled text is preset after log in the partner with Disable Account.");
	}

	@Test(priority = 14, description = "Verify if Admin is able to click on view button for inactive partner", enabled = true)
	public void TSSHYB270() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerEnableDisable.DisabledPartner();
		CustomAssert.assertTrue(flag, "Verify that Admin is able to click on view button for inactive partner. ",
				"Unable to Verify that Admin is able to click on view button for inactive partner.");
		flag = adminPartnerEnableDisable.ToggleButton();
		CustomAssert.assertTrue(flag, "Verify if Admin is able to Click on the toggle button .",
				"Unable to Verify if Admin is able to Click on the toggle button .");
	}

	@Test(priority = 15, description = "Verify if Admin is able to change the toggle button (from red to green colour to activate the partner)", enabled = true)
	public void TSSHYB271() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerEnableDisable.DisabledPartner();
		CustomAssert.assertTrue(flag, "Verify that Admin is able to click on view button for inactive partner. ",
				"Unable to Verify that Admin is able to click on view button for inactive partner.");
		flag = adminPartnerEnableDisable.ToggleButton();
		CustomAssert.assertTrue(flag, "Verify if Admin is able to Click on the toggle button .",
				"Unable to Verify if Admin is able to Click on the toggle button .");
		flag = adminPartnerEnableDisable.CancelButton();
		CustomAssert.assertTrue(flag, "Verify if ADMIN is able to click on cancel button after click on Toggle button.",
				"Unable to if ADMIN is able to click on cancel button after click on Toggle button.");

	}

	@Test(priority = 16, description = "Verify if Admin gets a pop saying Activate partner", enabled = true)
	public void TSSHYB272() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerEnableDisable.DisabledPartner();
		CustomAssert.assertTrue(flag, "Verify that Admin is able to click on view button for inactive partner. ",
				"Unable to Verify that Admin is able to click on view button for inactive partner.");
		flag = adminPartnerEnableDisable.ToggleButton();
		CustomAssert.assertTrue(flag, "Verify if Admin is able to Click on the toggle button .",
				"Unable to Verify if Admin is able to Click on the toggle button .");
		flag = adminPartnerEnableDisable.ActivatePartnersConfirm();
		CustomAssert.assertTrue(flag, "Verify that Partner is Activate after click on confirm button.",
				"Unable to Verify that Partner is Activate after click on confirm button.");
	}
}
