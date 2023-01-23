package TestScripts_Sprint05;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.Admin_Partner_Reject_Page;
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

public class Admin_Partners_Reject_test {
	private WebDriver driver;
	SignIn_Admin_Pages signInAdmin;
	String username;
	String userpassword;
	String username1;
	String userpassword1;
	Admin_Partners_Page adminPartners;
	Admin_Partners_Enable_Disable_page adminPartnerEnableDisable;
	SignIn_Partner_Pages signInPartner;
	Admin_Partner_Reject_Page adminPartnerReject;
	SignUp_CreateAccount_Partner_Page partner;
	MailBox mail;
	
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
		flag = APICalls.preparePendingPartnerAccountAfterSignup(EmailParner, username1, userpassword1);
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
		adminPartnerReject = new Admin_Partner_Reject_Page(driver);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1, description = " Verify if Admin is able to sign in through the correct credentials ", enabled = true)
	public void TSSHYB273() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
	}

	@Test(priority = 2, description = " Verify if Admin is able to click on Partners tab ", enabled = true)
	public void TSSHYB274() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
	}

	@Test(priority = 3, description = "Verify if user can view the list of Rejected partners by selecting Rejected Status", enabled = true)
	public void TSSHYB275() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerReject.FilterRejected();
		CustomAssert.assertTrue(flag,
				"Verify that user is able to select the rejected status and verify that Rejected partners are in list.",
				"Unable to Verify that user is able to select the rejected status and verify that Rejected partners are in list.");
	}

	@Test(priority = 4, description = "Verify if user can click on the view icon for Rejected partner", enabled = true)
	public void TSSHYB276() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerReject.FilterRejected();
		CustomAssert.assertTrue(flag,
				"Verify that user is able to select the rejected status and verify that Rejected partners are in list.",
				"Unable to Verify that user is able to select the rejected status and verify that Rejected partners are in list.");
		flag = adminPartnerReject.ViewButton();
		CustomAssert.assertTrue(flag, "Verify if user can click on the view icon for Rejected Partners.",
				"Unable to Verify if user can click on the view icon for Rejected Partners.");
	}

	@Test(priority = 5, description = "Verify if user can view the details by clicking on the view icon", enabled = true)
	public void TSSHYB277() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerReject.FilterRejected();
		CustomAssert.assertTrue(flag,
				"Verify that user is able to select the rejected status and verify that Rejected partners are in list.",
				"Unable to Verify that user is able to select the rejected status and verify that Rejected partners are in list.");
		flag = adminPartnerReject.ViewButton();
		CustomAssert.assertTrue(flag, "Verify that user is able to view the details by clicking onthe view icon.",
				"Unable to Verify that user is able to view the details by clicking onthe view icon.");
	}

	@Test(priority = 6, description = "Verify that all the fields in the detail page are non-editable and view only on ADMIN Partners Editable", enabled = true)
	public void TSSHYB278() {
	
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerReject.FilterRejected();
		CustomAssert.assertTrue(flag,
				"Verify that user is able to select the rejected status and verify that Rejected partners are in list.",
				"Unable to Verify that user is able to select the rejected status and verify that Rejected partners are in list.");
		flag = adminPartnerReject.ViewButton();
		CustomAssert.assertTrue(flag, "Verify that user is able to view the details by clicking onthe view icon.",
				"Unable to Verify that user is able to view the details by clicking onthe view icon.");
		flag = adminPartnerReject.RejectedPageEditable();
		CustomAssert.assertTrue(flag,
				"Verify that all the field in the details page are non-editable on ADMIN Partners.",
				"Unable to verify that all the field in the details page are non-editable on ADMIN Partners.");
	}

	@Test(priority = 7, description = "Verify if Admin can reject a partnerwhose status is either pending/Amendments Suggested/docusign pending", enabled = true)
	public void TSSHYB279() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerReject.CanRejectPartners(true, false, false);
		CustomAssert.assertTrue(flag, "Verify that ADMIN is able to reject the partners by Pending Status.",
				"Unable to Verify that ADMIN is able to reject the partners by Pending Status.");
		flag = adminPartnerReject.CanRejectPartners(false, true, false);
		CustomAssert.assertTrue(flag,
				"Verify that ADMIN is able to reject the partners by Amendments Suggested Status.",
				"Unable to Verify that ADMIN is able to reject the partners by Amendments Suggested  Status.");
		flag = adminPartnerReject.CanRejectPartners(false, false, true);
		CustomAssert.assertTrue(flag, "Verify that ADMIN is able to reject the partners by Docusign Pending Status.",
				"Unable to Verify that ADMIN is able to reject the partners by Docusign Pending   Status.");
	}

	@Test(priority = 8, description = " Verify if admin can click on the reject button in Partner's detail page. ", enabled = true)
	public void TSSHYB280() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerReject.CanRejectPartners(true, false, false);
		CustomAssert.assertTrue(flag, "Verify that ADMIN is able to reject the partners by Pending Status.",
				"Unable to Verify that ADMIN is able to reject the partners by Pending Status.");
	}

	@Test(priority = 9, description = " Verify if admin gets a pop up box wherein he will be required to add the reason for rejection. ", enabled = true)
	public void TSSHYB281() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerReject.CanRejectPartners(true, false, false);
		CustomAssert.assertTrue(flag, "Verify that ADMIN is able to reject the partners by Pending Status.",
				"Unable to Verify that ADMIN is able to reject the partners by Pending Status.");
	}

	@Test(priority = 10, description = " Verify if admin can mention the reason for reject the partner before confirm the rejection.", enabled = true)
	public void TSSHYB282() {
	
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerReject.RejectPartner();
		CustomAssert.assertTrue(flag,
				"Verify that ADMIN is able mention the reason for reject the partner by Pending Status.",
				"Unable to Verify that ADMIN is able mention the reason for reject the partner by Pending Status.");
	}

	@Test(priority = 11, description = " Verify if admin is able to Reject the partner by click on confirm button.", enabled = true)
	public void TSSHYB283() {
		
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminPartners.AdminPartnersButton();
		CustomAssert.assertTrue(flag, "Verify that ADMIN Partners Button is Clickable.",
				"Unable to Verify that ADMIN Partners Button is Clickable..");
		flag = adminPartnerReject.RejectPartner();
		CustomAssert.assertTrue(flag,
				"Verify that ADMIN is able mention the reason for reject the partner by Pending Status.",
				"Unable to Verify that ADMIN is able mention the reason for reject the partner by Pending Status.");
		flag = adminPartnerReject.ConfirmRejectPartner();
		CustomAssert.assertTrue(flag, "Verify that admin is able to Reject the partner by click on confirm button.",
				"Unable to Verify that admin is able to Reject the partner by click on confirm button.");
	}

}
