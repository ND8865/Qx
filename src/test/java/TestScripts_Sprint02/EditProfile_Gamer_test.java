package TestScripts_Sprint02;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.EditAccount_Gamer_pages;
import PageObjectClasses.MailBox;
import PageObjectClasses.SignInPage_Gamer;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class EditProfile_Gamer_test {
	private WebDriver driver;

	SignInPage_Gamer signIn;

	EditAccount_Gamer_pages EditAccount;
	MailBox code;
	String username;
	String userpassword;
	String email;
	String usernewemail;
	String firstname;
	String lastname;
	
	
	@BeforeClass
	public void beforeClass() {
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int counter = Integer.parseInt(count)+1;
		username = "automation_gamer"+counter;
		email = "automation_gamer"+counter+"@1secmail.com";
		userpassword = "Qwerty@12345678";
		firstname = "Automation";
		lastname = "Gamer"+counter;
		boolean flag = APICalls.prepareGamerAccount(username, email, userpassword, firstname, lastname);
		Assert.assertTrue(flag);
		Utility.setTempProperties("testDataVariables", "signUpUserCount", counter+"");
		count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		counter = Integer.parseInt(count)+1;
		
		usernewemail = "automation_gamer"+counter+"@1secmail.com";
		Utility.setTempProperties("testDataVariables", "signUpUserCount", counter+"");
		
	}
	

	@BeforeMethod
	@Parameters(value = { "browser" })
	public void beforeMethod(String browsername) {
		driver = DriverClass.setDriver(browsername, "gamer");

		signIn = new SignInPage_Gamer(driver);

		EditAccount = new EditAccount_Gamer_pages(driver);
		code = new MailBox();

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1, description = "Validating that All WebElements are visiable on Edit account", enabled = true)
	public void TSSHYB96() {
		WaitClass.waitForTime(2000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(2000);
		flag = EditAccount.accountEditprofile();
		CustomAssert.assertTrue(flag, "Edit profile Arrow Button successfully click.",
				"Unable to Edit profile Arrow Button successfully click.");

		WaitClass.waitForTime(2000);
		flag = EditAccount.isaccountEditprofileisDisplay();
		CustomAssert.assertTrue(flag, "Edit profile all webelement displayed.",
				"Unable to Edit profile all webelement displayed .");

	}

	@Test(priority = 2, description = "Data verify in Edit account profile  ", enabled = true)
	public void TSSHYB97() {
		WaitClass.waitForTime(2000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(2000);
		flag = EditAccount.accountEditprofile();
		CustomAssert.assertTrue(flag, "Edit profile Arrow Button successfully click.",
				"Unable to Edit profile Arrow Button successfully click.");
		WaitClass.waitForTime(2000);
		flag = EditAccount.ValidateEditProfile(firstname, lastname, username); // "Data verify in Edit account profile "
		CustomAssert.assertTrue(flag, "Edit profile gamer details is filled .",
				"Unable to Edit profile gamer details  .");

	}

	@Test(priority = 3, description = "Verify update email is changed and validate   ", enabled = true)
	public void TSSHYB98() {
		WaitClass.waitForTime(2000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(2000);
		flag = EditAccount.accountEditprofile();
		CustomAssert.assertTrue(flag, "Edit profile Arrow Button successfully click.",
				"Unable to Edit profile Arrow Button successfully click.");
		WaitClass.waitForTime(2000);
		flag = EditAccount.verifyemailupdate(usernewemail); // "Verify update email is changed "
		CustomAssert.assertTrue(flag, "Edit profile gamer able to update email.",
				"Unable to Edit profile gamer  update email .");
		WaitClass.waitForTime(2000);
		String verificationCode = code.getEmailData(usernewemail, "body > em", 2);
		flag = EditAccount.verifyemailvalidation(verificationCode); // "Verify update email is changed "
		CustomAssert.assertTrue(flag, "Edit profile gamer able to update email.",
				"Unable to Edit profile gamer  update email .");

	}

	@Test(priority = 4, description = " Verify Alert message is present  after clear the fields of edit profile  ", enabled = true)
	public void TSSHYB99

	() {
		WaitClass.waitForTime(2000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(2000);
		flag = EditAccount.accountEditprofile();
		CustomAssert.assertTrue(flag, "Edit profile Arrow Button successfully click.",
				"Unable to Edit profile Arrow Button successfully click.");
		WaitClass.waitForTime(2000);
		flag = EditAccount.alertdisplayeditprofile(firstname, lastname); // "Data verify in Edit account profile "
		CustomAssert.assertTrue(flag, "Edit profile gamer alert is persent  .", "Unable to see alert persent  .");
	}

	@Test(priority = 5, description = " verify cash back method elements visibility   ", enabled = true)
	public void TSSHYB100() {
		WaitClass.waitForTime(3000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(3000);
		flag = EditAccount.accountEditprofile();
		CustomAssert.assertTrue(flag, "Edit profile Arrow Button successfully click.",
				"Unable to Edit profile Arrow Button successfully click.");
		WaitClass.waitForTime(3000);
		flag = EditAccount.cashbackmethod();
		CustomAssert.assertTrue(flag, "visiablity of element cashback Account  .",
				"Unable to visiablity of element cashback Account .");

	}

	@Test(priority = 6, description = " Verify cash back method account add  details   ", enabled = true)
	public void TSSHYB101() {
		WaitClass.waitForTime(3000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(3000);
		flag = EditAccount.accountEditprofile();
		CustomAssert.assertTrue(flag, "Edit profile Arrow Button successfully click.",
				"Unable to Edit profile Arrow Button successfully click.");
		WaitClass.waitForTime(3000);
		flag = EditAccount.cashbackmethod();
		CustomAssert.assertTrue(flag, "visiablity of element cashback Account  .",
				"Unable to visiablity of element cashback Account .");
		WaitClass.waitForTime(3000);
		flag = EditAccount.addDepositaccount();
		CustomAssert.assertTrue(flag, "Edit profile cashbackaccount filled details .",
				"Unable to Edit profile cashbackaccount filled details.");
	}


	@Test(priority = 8, description = "verify Profile Photo is uploaded success fully", enabled = true)
	public void TSSHYB103() {
		WaitClass.waitForTime(3000);
		boolean flag = signIn.signinAction(username, userpassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.", "Unable to Sign in.");
		WaitClass.waitForTime(3000);
		flag = EditAccount.ProfilePhotoUpload();
		CustomAssert.assertTrue(flag, "Profile Photo is uploaded success fully .",
				"Profile Photo is uploaded success fully .");

	}

}
