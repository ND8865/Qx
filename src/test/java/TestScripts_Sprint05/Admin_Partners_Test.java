package TestScripts_Sprint05;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.Admin_Partners_Page;
import PageObjectClasses.MailBox;
import PageObjectClasses.SignIn_Admin_Pages;
import PageObjectClasses.SignUp_CreateAccount_Partner_Page;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Admin_Partners_Test {
	private WebDriver driver;
	SignIn_Admin_Pages signInAdmin;
	String username;
	String userpassword;
	Admin_Partners_Page adminPartners;
	SignUp_CreateAccount_Partner_Page partner;
	MailBox mail;
	
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

		driver = DriverClass.setDriver("chrome", "admin");
		signInAdmin = new SignIn_Admin_Pages(driver);
		username = Utility.getPropertiesFile("primaryLogin", "superAdminUsername");
		userpassword = Utility.getPropertiesFile("primaryLogin", "superAdminPassword");
		adminPartners = new Admin_Partners_Page(driver);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1, description = " Verify if Admin is able to sign in through the correct credentials. ", enabled = true)
	public void TSSHYB244() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");

	}

	@Test(priority = 2, description = " Verify that ADMIN Partners Button is Clickable.  ", enabled = true)
	public void TSSHYB245() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");

	}

	@Test(priority = 3, description = " Verify that All Elements are Visible on ADMIN Partners .  ", enabled = true)
	public void TSSHYB246() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartners.AllElementDisplayed();
		CustomAssert.assertTrue(flag, "Verify that All Elements are Visible on ADMIN PARTNERS DeshBoard .",
				"Unable to verify All Elements are Visible on ADMIN PARTNERS DeshBoard .");

	}
// Partner -search
	@Test(priority = 4, description = " Verify if user can search the games through the partner name. ", enabled = true)
	public void TSSHYB247() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartners.PartnersNameSearch();
		CustomAssert.assertTrue(flag, "Verify that user can Search the Games according to Partners Name on ADMIN .",
				"Unable to Verify that user can Search the Games according to Partners Name on ADMIN .");

	}

	@Test(priority = 5, description = " Verify if user can search the games through the Email. ", enabled = true)
	public void TSSHYB248() {
	
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartners.EmailSearch();
		CustomAssert.assertTrue(flag, "Verify that user can Search the Games according to Email on ADMIN .",
				"Unable to Verify that user can Search the Games according to Email on ADMIN .");
	}

 //partner-list
	@Test(priority = 7, description = " Verify if Admin can see Partners tab from the side menu", enabled = true)
	public void TSSHYB250() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
	}

	@Test(priority = 8, description = "Verify if Admin can see the list of Partners ", enabled = true)
	public void TSSHYB251() {
	
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartners.AdminPartnersList();
		CustomAssert.assertTrue(flag, "Verify that All list are Present on Partners Tab.",
				"Unable to verify that All list are Present on Partners Tab.");
	}
//partner -sort 
	@Test(priority = 9, description = "Verify if Admin is able to see the partners deshborad  ", enabled = true)
	public void TSSHYB252() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
	}

	@Test(priority = 10, description = "Verify if Admin is able to see the list of partners", enabled = true)
	public void TSSHYB253() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartners.AdminPartnersList();
		CustomAssert.assertTrue(flag, "Verify that All list are Present on Partners Tab.",
				"Unable to verify that All list are Present on Partners Tab.");
	}
//partner - sort
	@Test(priority = 11, description = "Verify if user can sort the partners in the ascending/descending order according to the Partner name, email, primary contact, primary phone and Status", enabled = true)
	public void TSSHYB254() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartners.SortingAdminPartner(1);
		CustomAssert.assertTrue(flag, "Verify that Sorting are Working by Partner Name in ASC order .",
				"Unable to Verify that Sorting are Working by Partner Name in ASC order .");
		flag = adminPartners.SortingAdminPartner(2);
		CustomAssert.assertTrue(flag, "Verify that Sorting are Working by Partner Name in DESC order .",
				"Unable to Verify that Sorting are Working by Partner Name in DESC order .");
		flag = adminPartners.SortingEmail(1);
		CustomAssert.assertTrue(flag, "Verify that Sorting are Working by Email in ASC order .",
				"Unable to Verify that Sorting are Working by Email in ASC order .");
		flag = adminPartners.SortingEmail(2);
		CustomAssert.assertTrue(flag, "Verify that Sorting are Working by Email in DESC order .",
				"Unable to Verify that Sorting are Working by Email in DESC order .");
		flag = adminPartners.SortingPrimaryContact(1);
		CustomAssert.assertTrue(flag, "Verify that Sorting are Working by Primary Contact in ASC order .",
				"Unable to Verify that Sorting are Working by Primary Contact in ASC order .");
		flag = adminPartners.SortingPrimaryContact(2);
		CustomAssert.assertTrue(flag, "Verify that Sorting are Working by Primary Contact in DESC order .",
				"Unable to Verify that Sorting are Working by Primary Contact in DESC order .");
		flag = adminPartners.SortingPrimaryPhone(1);
		CustomAssert.assertTrue(flag, "Verify that Sorting are Working by Primary Phone in ASC order .",
				"Unable to Verify that Sorting are Working by Primary Phone in ASC order .");
		flag = adminPartners.SortingPrimaryPhone(2);
		CustomAssert.assertTrue(flag, "Verify that Sorting are Working by Primary Phone in DESC order .",
				"Unable to Verify that Sorting are Working by Primary Phone in DESC order .");
	}
//partner - details page
	@Test(priority = 12, description = "Verify if Admin is redirected to Partner's detail page on clicking on view button", enabled = true)
	public void TSSHYB255() {
	
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartners.ViewButton();
		CustomAssert.assertTrue(flag,
				"Verify that View Button is clickble and redirected details Page on ADMIN/PARTNER. ",
				"Unable to Verify that View Button is clickble and redirected details Page on ADMIN/PARTNER.");
	}

	@Test(priority = 13, description = "Verify if Admin is redirected to Partner's detail page on clicking on view button", enabled = true)
	public void TSSHYB256() {
	
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartners.ViewButton();
		CustomAssert.assertTrue(flag,
				"Verify that View Button is clickble and redirected details Page on ADMIN/PARTNER. ",
				"Unable to Verify that View Button is clickble and redirected details Page on ADMIN/PARTNER.");
		flag = adminPartners.AdminPartnerInfo();
		CustomAssert.assertTrue(flag, "Verify that Partners's details are Present after click on the view button.",
				"Unable to Verify that Partners's details are Present after click on the view button.");
	}

}
