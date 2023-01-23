package TestScripts_Sprint06;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.ContactInformation_Partner;
import PageObjectClasses.Edit_Profile_Partner;
import PageObjectClasses.GeneralInformation_Partner;
import PageObjectClasses.MailBox;
import PageObjectClasses.OtherInformation_Partner;
import PageObjectClasses.ProfilePending_Partner;
import PageObjectClasses.SignIn_Partner_Pages;
import PageObjectClasses.SignUp_CreateAccount_Partner_Page;
import PageObjectClasses.TermsAndConditions_Partner;
import TestListners.CustomAssert;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Onboarding_Partner_Tests {
	
	private WebDriver driver;
	SignUp_CreateAccount_Partner_Page signUpCreateAccountPartner;
	SignIn_Partner_Pages signInPartner;
	Edit_Profile_Partner editProfilePartner;
	GeneralInformation_Partner generalInformation_Partner;
	ContactInformation_Partner contactInformation_Partner;
	OtherInformation_Partner otherInformation_Partner;
	TermsAndConditions_Partner termsAndConditions_Partner;
	ProfilePending_Partner profilePending_Partner;
	MailBox mail;
	
	
	String username;
	String password;
	String partnerName = "Automation Partner";
	MailBox code;
	String UserNameGamer;
	String EmailGamer;
	int c;
	String PasswordGamer;
	String name;
	String confirmpassword;
	String generalInfo_legalEntityName;
	String generalInfo_selectCategory;
	String generalInfo_reasonToJoin;
	String contactInfo_dba;
	String contactInfo_address1;
	String contactInfo_address2;
	String contactInfo_country;
	String contactInfo_state;
	String contactInfo_city;
	String contactInfo_zipcode;
	String contactInfo_primaryname;
	String contactInfo_primarytitle;
	String contactInfo_primaryphonenumber;
	String contactInfo_primaryaltphonenumber;
	String contactInfo_primaryemail;
	String contactInfo_secondaryname;
	String contactInfo_secondarytitle;
	String contactInfo_secondaryphonenumber;
	String contactInfo_secondaryaltphonenumber;
	String contactInfo_secondaryemail;
	String contactInfo_authorizedname;
	String contactInfo_authorizedtitle;
	String otherInfo_estnumofgames;
	String otherInfo_estnumofgamers;
	String otherInfo_gamegrowth;
	String otherInfo_gamergrowth;
	String otherInfo_option;
	String addSuggestedChanges;
	
	@BeforeClass
	public void beforeClass() {
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int c = Integer.parseInt(count)+1;
		username = "qa_partner11"+c;
		String EmailParner = "qa_partner11"+c+"@1secmail.com";
		password = "Qwerty@12345678";
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		
		driver = DriverClass.setDriver("chrome", "partner");
		signUpCreateAccountPartner = new SignUp_CreateAccount_Partner_Page(driver);
		WaitClass.waitForTime(10000);
		boolean flag = signUpCreateAccountPartner.CreateAccountButtonClick();
		Assert.assertTrue(flag);
		flag = signUpCreateAccountPartner.SignUpCreateAccount("Automation Partner", username, EmailParner, password, password);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(5000);
        mail = new MailBox();
        String verificationCode = mail.getEmailData(EmailParner, "body > em", 2);
		flag = signUpCreateAccountPartner.ConfirmAccount(verificationCode);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(10000);
		driver.quit();
	}
	
	@BeforeMethod
	public void browserlaunch() {
		driver = DriverClass.setDriver("chrome", "partner");
		signUpCreateAccountPartner = new SignUp_CreateAccount_Partner_Page(driver);
		signInPartner = new SignIn_Partner_Pages(driver);
		editProfilePartner = new Edit_Profile_Partner(driver);
		generalInformation_Partner = new GeneralInformation_Partner(driver);
		contactInformation_Partner = new ContactInformation_Partner(driver);
		otherInformation_Partner = new OtherInformation_Partner(driver);
		termsAndConditions_Partner = new TermsAndConditions_Partner(driver);
		profilePending_Partner = new ProfilePending_Partner(driver);
		
		code = new MailBox();
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		c = Integer.parseInt(count) + 1;
		UserNameGamer = "Partner" + c;
		EmailGamer = "qa_partner" + c + "@1secmail.com";
		name = "Partner0" + c;
		confirmpassword = "Qwerty@12345678";
		PasswordGamer = "Qwerty@12345678";
		generalInfo_legalEntityName = "CD Projekt X";
		generalInfo_selectCategory = "1";
		generalInfo_reasonToJoin = "2";
		contactInfo_dba = "CD Projekt";
		contactInfo_address1 = "CD PROJEKT S.A.";
		contactInfo_address2 = "ul. Jagiellonska 74";
		contactInfo_country = "United States";
		contactInfo_state = "California";
		contactInfo_city = "San Jose";
		contactInfo_zipcode = "45676";
		contactInfo_primaryname = "QA Bot";
		contactInfo_primarytitle = "QA Engineer";
		contactInfo_primaryphonenumber = "999999999";
		contactInfo_primaryaltphonenumber = "1111111111";
		contactInfo_primaryemail = "qabot@yopmail.com";
		contactInfo_secondaryname = "Little Tester";
		contactInfo_secondarytitle = "Sr. Qa";
		contactInfo_secondaryphonenumber = "7777777777";
		contactInfo_secondaryaltphonenumber = "4444444444";
		contactInfo_secondaryemail = "littletester@yopmail.com";
		contactInfo_authorizedname = "Evil tester";
		contactInfo_authorizedtitle = "Devil";
		otherInfo_estnumofgames = "12";
		otherInfo_estnumofgamers = "98987443";
		otherInfo_gamegrowth = "99";
		otherInfo_gamergrowth = "89";
		otherInfo_option = "4";
		addSuggestedChanges = "Remove Clause E";
	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	
	@Test (description = "Verify if Partner is able to login using username and Password", enabled = true)
	public void TSSHYB344() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
	}
	
	
	@Test(description = "Verify if user is able to see the General Information page after "
			+ "first time login/Incomplete submission", enabled = true)	
	public void TSSHYB345() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner Signin validated successfully", 
				"Partner Signin validation failed");
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
	}
	
	
	@Test(description = "Verify if user can upload logo from system, enter legal entity name", enabled = true)
	public void TSSHYB346() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner Signin validated successfully", 
				"Partner Signin validation failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		flag = generalInformation_Partner.uploadLogoAction();
		CustomAssert.assertTrue(flag, "Logo Uploaded Successfully", "Unable to upload logo");
		
		flag = generalInformation_Partner.setLegalEntityName(generalInfo_legalEntityName);
		CustomAssert.assertTrue(flag, "Filled Legal Entity Name successfully", "Unable to fill Legal Entity Name");
		
		flag = generalInformation_Partner.validateLegalEntityName(generalInfo_legalEntityName);
		CustomAssert.assertTrue(flag, "Validation of Legal Entity Name is successful", "unable to validate Legal Entity Name Field");
	}
	
	
	@Test(description = "Verify if user can select Category(s): Game publisher, game developer, "
			+ "loyalty rewards program retail from drop down and a reason to join QX", enabled = true)
	public void TSSHYB347() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner Signin validated successfully", 
				"Partner Signin validation failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.validateDropdown(true, false);
		CustomAssert.assertTrue(flag, "Category Dropdown verfied successfully", "Unable to verify category dropdown");
		
		flag = generalInformation_Partner.validateDropdown(false, true);
		CustomAssert.assertTrue(flag, "Reasons to Join Dropdown verfied successfully", "Unable to verify reasons to join dropdown");
	}
	
	
	@Test(description = "Verify if user can click on the next button to go to the contact information page",
			enabled = true)
	public void TSSHYB348() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner Signin validated successfully", 
				"Partner Signin validation failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
	}
	
	
	@Test(description = "Verify if user gets sign out by clicking on the Sign out button", enabled = true)
	public void TSSHYB349() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner Signin validated successfully", 
				"Partner Signin validation failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.signoutAction();
		CustomAssert.assertTrue(flag, "SignOut Action Performed Successfully", "Unable to perform SignOut Action");
	}
	
	
	@Test(description = "Verify after signing back in, General Information data is there", enabled = true)
	public void TSSHYB350() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.signoutAction();
		CustomAssert.assertTrue(flag, "SignOut Action Performed Successfully", "Unable to perform SignOut Action");
		
		flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
	}
	
	@Test(description = "Verify if user can fill in following data in Contact information page: "
			+ "DBA, Business Address Location, Primary Contact Information, Secondary Contact Information, Authorised Signatory" ,
			enabled = true)
	public void TSSHYB351() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.setDBA(contactInfo_dba);
		CustomAssert.assertTrue(flag, "DBA field filled Successfully", "Unable to fill DBA Field");
		
		flag = contactInformation_Partner.setAddress1(contactInfo_address1);
		CustomAssert.assertTrue(flag, "Address1 field filled Successfully", "Unable to fill Address1 Field");
		
		flag = contactInformation_Partner.setAddress2(contactInfo_address2);
		CustomAssert.assertTrue(flag, "Address2 field filled Successfully", "Unable to fill Address2 Field");
		
		flag = contactInformation_Partner.selectCountryfromDropdown(contactInfo_country);
		CustomAssert.assertTrue(flag, "Successfully selected a country from Country dropdown", "Unable to select a country from dropdown");
		
		flag = contactInformation_Partner.selectStatefromDropdown(contactInfo_state);
		CustomAssert.assertTrue(flag, "Successfully selected a state from State dropdown", "Unable to select a state from dropdown");
		
		flag = contactInformation_Partner.selectCityfromDropdown(contactInfo_city);
		CustomAssert.assertTrue(flag, "Successfully selected a city from City Dropdown", "Unable to select a city from dropdown");
		
		flag = contactInformation_Partner.setZipCode(contactInfo_zipcode);
		CustomAssert.assertTrue(flag, "ZipCode field filled Successfully", "Unable to fill ZipCode Field");
		
		flag = contactInformation_Partner.setPrimaryName(contactInfo_primaryname);
		CustomAssert.assertTrue(flag, "Primary Name filled successfully", "Unable to fill primary name successfully");
		
		flag = contactInformation_Partner.setPrimaryTitle(contactInfo_primarytitle);
		CustomAssert.assertTrue(flag, "Primary Title filled successfully", "Unable to fill primary Title successfully");
		
		flag = contactInformation_Partner.setPrimaryPhoneNumber(contactInfo_primaryphonenumber);
		CustomAssert.assertTrue(flag, "Primary Phone number filled successfully", 
				"Unable to fill primary phone number successfully");
		
		flag = contactInformation_Partner.setPrimaryAltPhoneNumber(contactInfo_primaryaltphonenumber);
		CustomAssert.assertTrue(flag, "Primary Alternative Phone Number filled successfully", 
				"Unable to fill primary alternative phone number successfully");
		
		flag = contactInformation_Partner.setPrimaryEmail(contactInfo_primaryemail);
		CustomAssert.assertTrue(flag, "Primary Email filled successfully", "Unable to fill primary email successfully");
		
		flag = contactInformation_Partner.setSecondaryName(contactInfo_secondaryname);
		CustomAssert.assertTrue(flag, "Secondary Name filled successfully", "Unable to fill secondary name successfully");
		
		flag = contactInformation_Partner.setSecondaryTitle(contactInfo_secondarytitle);
		CustomAssert.assertTrue(flag, "Secondary Title filled successfully", 
				"Unable to fill Secondary Title successfully");
		
		flag = contactInformation_Partner.setSecondaryPhoneNumber(contactInfo_secondaryphonenumber);
		CustomAssert.assertTrue(flag, "Secondary Phone Number filled successfully", 
				"Unable to fill secondary phone number successfully");
		
		flag = contactInformation_Partner.setSecondaryAltPhoneNumber(contactInfo_secondaryaltphonenumber);
		CustomAssert.assertTrue(flag, "Secondary Alternative Phone Number filled successfully", 
				"Unable to fill secondary alternative phone number successfully");
		
		flag = contactInformation_Partner.setSecondaryEmail(contactInfo_secondaryemail);
		CustomAssert.assertTrue(flag, "Secondary Email filled successfully", "Unable to fill Secondary Email successfully");
		
		flag = contactInformation_Partner.setAuthorizedName(contactInfo_authorizedname);
		CustomAssert.assertTrue(flag, "Authorised name filled successfully", 
				"Unable to fill Authorised Name successfully");
		
		flag = contactInformation_Partner.setAuthorizedTitle(contactInfo_authorizedtitle);
		CustomAssert.assertTrue(flag, "Authorized Title filled successfully", "Unable to fill Authorized Title successfully");
		
	}
	
	@Test(description = "Verify on clicking on next button, user is routed to the Other Information page",
			enabled = true)
	public void TSSHYB352() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = otherInformation_Partner.validatePageHeading("Other Information");
		CustomAssert.assertTrue(flag, "Validated Other Information Page Successfully", "Unable to validate other information page");
	}
	
	@Test(description = "Verify on clicking on back button, user is routed to the General Information page",
			enabled = true)
	public void TSSHYB353() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.clickButton(true, false);
		CustomAssert.assertTrue(flag, "Clicked on Back Button Successfully", "Unable to click on Back Button");
		
		WaitClass.waitForTime(2000);
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
	}
	
	@Test(description = "Verify if user can fill in following data in Other Information page: "
              + "est # of games, est # of gamers, game growth, gamers growth, one of 5 options", enabled = true)	
	public void TSSHYB354() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = otherInformation_Partner.validatePageHeading("Other Information");
		CustomAssert.assertTrue(flag, "Validated Other Information Page Successfully", "Unable to validate other information page");
		
		flag = otherInformation_Partner.setEstNumberOfGames("9");
		CustomAssert.assertTrue(flag, "Estimated number of Games filled successfully", 
				"Unable to fill estimated number of games");
		
		flag = otherInformation_Partner.setEstNumberOfGamers("98756743");
		CustomAssert.assertTrue(flag, "Estimated number of Gamers filled successfully", 
				"Unable to fill estimated number of gamers");
		
		flag = otherInformation_Partner.setGameGrowthPercentage("98");
		CustomAssert.assertTrue(flag, "Game Growth Percentage filled successfully", 
				"Unable to fill Game Growth Percentage");
		
		flag = otherInformation_Partner.setGamersGrowthPercentage("89");
		CustomAssert.assertTrue(flag, "Gamers Growth Percentage filled successfully", 
				"Unable to fill Gamers Growth Percentage");
		
		flag = otherInformation_Partner.selectRadioButton("3");
		CustomAssert.assertTrue(flag, "Selected an option from radio options Successfully", 
				"Unable to select an option from radio buttons");
	}
	
	@Test(description = "Verify on clicking on next button, user is routed to the Terms and Conditions page",
			enabled = true)
	public void TSSHYB355() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = otherInformation_Partner.validatePageHeading("Other Information");
		CustomAssert.assertTrue(flag, "Validated Other Information Page Successfully", "Unable to validate other information page");
		
		flag = otherInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = termsAndConditions_Partner.validatePageHeading("Terms and Conditions");
		CustomAssert.assertTrue(flag, "Validated Terms and Conditions Page Successfully", 
				"Unable to validate Terms and Conditions page");
	}
	
	@Test(description = "Verify on clicking on Back button, user is routed to the Contact Information page", 
			enabled = true)
	public void TSSHYB356() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = otherInformation_Partner.validatePageHeading("Other Information");
		CustomAssert.assertTrue(flag, "Validated Other Information Page Successfully", "Unable to validate other information page");
		
		flag = otherInformation_Partner.clickButton(true, false);
		CustomAssert.assertTrue(flag, "Clicked on Back Button Successfully", "Unable to click on Back Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
	}
	
	@Test(description = "Verify if user can read the Review Terms and Conditions by scrolling the box up and down",
			enabled = true)
	public void TSSHYB357() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = otherInformation_Partner.validatePageHeading("Other Information");
		CustomAssert.assertTrue(flag, "Validated Other Information Page Successfully", "Unable to validate other information page");
		
		flag = otherInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = termsAndConditions_Partner.validatePageHeading("Terms and Conditions");
		CustomAssert.assertTrue(flag, "Validated Terms and Conditions Page Successfully", 
				"Unable to validate Terms and Conditions page");
		
		flag = termsAndConditions_Partner.validateTermsConditionsScrolling();
		CustomAssert.assertTrue(flag, "Verified Review Terms and Conditions is Scrollable", 
				"Unable to verify scrollability of terms and condition");
	}
	
	@Test(description = "Verify that the Review Terms and Conditions box is non editable", enabled = true)
	public void TSSHYB358() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = otherInformation_Partner.validatePageHeading("Other Information");
		CustomAssert.assertTrue(flag, "Validated Other Information Page Successfully", "Unable to validate other information page");
		
		flag = otherInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = termsAndConditions_Partner.validatePageHeading("Terms and Conditions");
		CustomAssert.assertTrue(flag, "Validated Terms and Conditions Page Successfully", 
				"Unable to validate Terms and Conditions page");
		
		flag = termsAndConditions_Partner.verifyIfTermsConditionsIsEditable();
		CustomAssert.assertTrue(flag, "Verified Review Terms and Conditions is read-only successfully", "Unable to verify that t&C is read only");
	}
	
	@Test(description = "Verify if user can tick mark the box Accept all terms and conditions", enabled = true)
	public void TSSHYB359() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = otherInformation_Partner.validatePageHeading("Other Information");
		CustomAssert.assertTrue(flag, "Validated Other Information Page Successfully", "Unable to validate other information page");
		
		flag = otherInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = termsAndConditions_Partner.validatePageHeading("Terms and Conditions");
		CustomAssert.assertTrue(flag, "Validated Terms and Conditions Page Successfully", 
				"Unable to validate Terms and Conditions page");
		
		flag = termsAndConditions_Partner.enableTermsAndConditions(true);
		CustomAssert.assertTrue(flag, "Validated Terms and Conditions CheckBox successfully", 
				"Unable to validate Terms and Conditions checkbox");
	}
	
	
	@Test(description = "Verify if user can add content in the suggested changes box", enabled = true)
	public void TSSHYB360() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = otherInformation_Partner.validatePageHeading("Other Information");
		CustomAssert.assertTrue(flag, "Validated Other Information Page Successfully", "Unable to validate other information page");
		
		flag = otherInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = termsAndConditions_Partner.validatePageHeading("Terms and Conditions");
		CustomAssert.assertTrue(flag, "Validated Terms and Conditions Page Successfully", 
				"Unable to validate Terms and Conditions page");
		
		flag = termsAndConditions_Partner.addSuggestedChanges("Testing Add Suggested Changes Text Box");
		CustomAssert.assertTrue(flag, "Verified user can add text to Add Suggested Changes text box successfully", 
				"Unable to verify if user can add text to add suggested changes text box");
	}
	
	
	@Test(description = "Verify that either Terms and Conditions is tick marked or modifications are suggested or both",
			enabled = true)
	public void TSSHYB361() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = otherInformation_Partner.validatePageHeading("Other Information");
		CustomAssert.assertTrue(flag, "Validated Other Information Page Successfully", "Unable to validate other information page");
		
		flag = otherInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = termsAndConditions_Partner.validatePageHeading("Terms and Conditions");
		CustomAssert.assertTrue(flag, "Validated Terms and Conditions Page Successfully", 
				"Unable to validate Terms and Conditions page");
		
		flag = termsAndConditions_Partner.enableTermsAndConditions(false);
		CustomAssert.assertTrue(flag, "Unchecked Terms and Conditions CheckBox", "Unable to uncheck terms and conditions checkbox");
		
		flag = termsAndConditions_Partner.clearSuggestedChanges();
		CustomAssert.assertTrue(flag, "Cleared Add Suggested Changes TextBox", "Unable to clear Add Suggested Changes");
		
		flag = termsAndConditions_Partner.validateErrorMessages(false, true);
		CustomAssert.assertTrue(flag, "Validated the error message successfully", "Unable to validate error message");
	}
	
	
	@Test(description = "Verify if Partner is able to view all the pre-entered data even after clicking Next or back "
			+ ", switching to different tabs from left navigation , performing Signout and Signin  or "
			+ "by clicking back/Next button of browser.(Auto save)", enabled = true)
	public void TSSHYB362() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.fillBusinessLocationAddress(contactInfo_address1, contactInfo_address2, contactInfo_country,
				contactInfo_state, contactInfo_city, contactInfo_zipcode);
		CustomAssert.assertTrue(flag, "Filled Bussiness Location Details successfully", "Unable to fill Business Location Details");
	
		flag = contactInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = otherInformation_Partner.validatePageHeading("Other Information");
		CustomAssert.assertTrue(flag, "Validated Other Information Page Successfully", "Unable to validate other information page");
		
		flag = otherInformation_Partner.clickButton(true, false);
		CustomAssert.assertTrue(flag, "Clicked on Back Button Successfully", "Unable to click on Back Button");
		
		WaitClass.waitForTime(2000);
		
		flag = contactInformation_Partner.validateBusinessLocationAddress(contactInfo_address1, contactInfo_address2, contactInfo_country,
				contactInfo_state, contactInfo_city, contactInfo_zipcode);
		CustomAssert.assertTrue(flag, "Validated Values in Business Location Address Successfully", "Unable to Validate Business Location Address");
	
		flag = contactInformation_Partner.clickButton(true, false);
		CustomAssert.assertTrue(flag, "Clicked on Back Button Successfully", "Unable to click on Back Button");
		
		WaitClass.waitForTime(2000);
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.validateBusinessLocationAddress(contactInfo_address1, contactInfo_address2, contactInfo_country,
				contactInfo_state, contactInfo_city, contactInfo_zipcode);
		CustomAssert.assertTrue(flag, "Validated Values in Business Location Address Successfully", "Unable to Validate Business Location Address");
		
		flag = contactInformation_Partner.navigateBack();
		CustomAssert.assertTrue(flag, "navigated to previous page using browser back button successfully", 
				"unable to navigate to previous page using browser back button");
		
		WaitClass.waitForTime(2000);
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.navigateForward();
		CustomAssert.assertTrue(flag, "navigated to previous page using browser forward button successfully", 
				"unable to navigate to previous page using browser forward button");
		
		WaitClass.waitForTime(2000);
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.validateBusinessLocationAddress(contactInfo_address1, contactInfo_address2, contactInfo_country,
				contactInfo_state, contactInfo_city, contactInfo_zipcode);
		CustomAssert.assertTrue(flag, "Validated Values in Business Location Address Successfully", "Unable to Validate Business Location Address");
		
		flag = contactInformation_Partner.navigateTo("1");
		CustomAssert.assertTrue(flag, "navigated to General Information Page Successfully", "Unable to navigate to general information page");
		
		WaitClass.waitForTime(2000);
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.navigateTo("2");
		CustomAssert.assertTrue(flag, "navigated to Contact Information Page Successfully", "Unable to navigate to Contact information page");
		
		WaitClass.waitForTime(2000);
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.validateBusinessLocationAddress(contactInfo_address1, contactInfo_address2, contactInfo_country,
				contactInfo_state, contactInfo_city, contactInfo_zipcode);
		CustomAssert.assertTrue(flag, "Validated Values in Business Location Address Successfully", "Unable to Validate Business Location Address");
		
		flag = contactInformation_Partner.signoutAction();
		CustomAssert.assertTrue(flag, "SignOut Action Performed Successfully", "Unable to perform SignOut Action");
		
		flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.validateBusinessLocationAddress(contactInfo_address1, contactInfo_address2, contactInfo_country,
				contactInfo_state, contactInfo_city, contactInfo_zipcode);
		CustomAssert.assertTrue(flag, "Validated Values in Business Location Address Successfully", "Unable to Validate Business Location Address");
	}
	
	@Test(description = "Verify if Partner is able to see all the required missing information in a popup box named as 'Errors' after clicking on Submit." ,
			enabled = true)
	public void TSSHYB363() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clearAllFields();
		CustomAssert.assertTrue(flag, "Successfully cleared all fields on page", "Unable to clear all fields on general information page");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = otherInformation_Partner.validatePageHeading("Other Information");
		CustomAssert.assertTrue(flag, "Validated Other Information Page Successfully", "Unable to validate other information page");
		
		flag = otherInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = termsAndConditions_Partner.validatePageHeading("Terms and Conditions");
		CustomAssert.assertTrue(flag, "Validated Terms and Conditions Page Successfully", 
				"Unable to validate Terms and Conditions page");
		
		flag = termsAndConditions_Partner.clickButton(false, true, false);
		CustomAssert.assertTrue(flag, "Clicked on Submit Button Successfully", "Unable to click on submit button");
		
		flag = termsAndConditions_Partner.validateErrorMessages(true, false);
		CustomAssert.assertTrue(flag, "Validated Error Message for Missing Legal Entity Name in General Information Page", "Unable to validate error");
	}
	
	@Test(description = "Verify if Partner can close the popup to fill all the missing informations.", enabled = true)
	public void TSSHYB364() {
		boolean flag = signInPartner.signinActionPartner(username, password);
		CustomAssert.assertTrue(flag, "Partner SignIn Validated Successfully", 
				"Partner SignIn Validation Failed");
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.clearAllFields();
		CustomAssert.assertTrue(flag, "Successfully cleared all fields on page", "Unable to clear all fields on general information page");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = otherInformation_Partner.validatePageHeading("Other Information");
		CustomAssert.assertTrue(flag, "Validated Other Information Page Successfully", "Unable to validate other information page");
		
		flag = otherInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = termsAndConditions_Partner.validatePageHeading("Terms and Conditions");
		CustomAssert.assertTrue(flag, "Validated Terms and Conditions Page Successfully", 
				"Unable to validate Terms and Conditions page");
		
		flag = termsAndConditions_Partner.clickButton(false, true, false);
		CustomAssert.assertTrue(flag, "Clicked on Submit Button Successfully", "Unable to click on submit button");
		
		flag = termsAndConditions_Partner.clickButton(false, false, true);
		CustomAssert.assertTrue(flag, "Closed Error Dialog Box successfully", "Unable to close Error Dialog Box");
		
		flag = termsAndConditions_Partner.addSuggestedChanges(addSuggestedChanges);
		CustomAssert.assertTrue(flag, "Added Suggested Changes Successfully", "Unable to add Suggested Changes");
	}
	
	@Test(description = "Verify if user's application is in pending status after clicking on submit.", enabled = true)
	public void TSSHYB365() {
		boolean flag = signUpCreateAccountPartner.CreateAccountButtonClick();
		CustomAssert.assertTrue(flag, "Verify that Create Account Button is Working on Partner Sign In.",
				"Unable to Verify that Create Account Button is Working on Partner Sign In .");
		
		flag = signUpCreateAccountPartner.SignUpCreateAccount(name, UserNameGamer, EmailGamer, PasswordGamer,
				confirmpassword);
		CustomAssert.assertTrue(flag, "Verify that SignUp or Create Account is Successfully Created on Partner.",
				"Unable to Verify SignUp or Create Account is Successfully Created on Partner.");
		
		Utility.setTempProperties("testDataVariables", "signUpUserCount", c + "");
		
		String verificationCode = code.getEmailData(EmailGamer, "body > em", 2);
		flag = signUpCreateAccountPartner.ConfirmAccount(verificationCode);
		CustomAssert.assertTrue(flag, "Account confirmed successfully", "having isssue with Account confirmation");
		
		WaitClass.waitForTime(2000);
		
		flag = generalInformation_Partner.validatePageHeading("General Information");
		CustomAssert.assertTrue(flag, "Verified user redirection to General Information Page successfully", 
				"Unable to verify user redirection to General Information Page successfully");
		
		flag = generalInformation_Partner.uploadLogoAction();
		CustomAssert.assertTrue(flag, "Logo Uploaded Successfully", "Unable to upload logo");
		
		flag = generalInformation_Partner.setLegalEntityName(generalInfo_legalEntityName);
		CustomAssert.assertTrue(flag, "Entered Legal Entity Name Successfully", "Unable to enter legal entity name");
		
		flag = generalInformation_Partner.selectFromDropdown(true, false, generalInfo_selectCategory);
		CustomAssert.assertTrue(flag, "Selected Caregory Successfully", "Unable to select Category Successfully");
		
		flag = generalInformation_Partner.selectFromDropdown(false, true, generalInfo_reasonToJoin);
		CustomAssert.assertTrue(flag, "Selected reason to join Successfully", "Unable to select reason to join Successfully");
		
		flag = generalInformation_Partner.clickNextButton();
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = contactInformation_Partner.validatePageHeading("Contact Information");
		CustomAssert.assertTrue(flag, "Validated Contact Information Page Successfully", "Unable to validate contact information page");
		
		flag = contactInformation_Partner.setDBA(contactInfo_dba);
		CustomAssert.assertTrue(flag, "Filled DBA Field Successfully", "Unable to fill DBA field");
		
		flag = contactInformation_Partner.fillBusinessLocationAddress(contactInfo_address1, contactInfo_address2, contactInfo_country,
				contactInfo_state, contactInfo_city, contactInfo_zipcode);
		CustomAssert.assertTrue(flag, "Filled Business Location Address Successfully", "Unable to fill business location address");
		
		flag = contactInformation_Partner.fillPrimaryContactInformation(contactInfo_primaryname, contactInfo_primarytitle, 
				contactInfo_primaryphonenumber, contactInfo_primaryaltphonenumber, contactInfo_primaryemail);
		CustomAssert.assertTrue(flag, "Filled Primary Contact Information Successfully", "Unable to fill primary contact information");
		
		flag = contactInformation_Partner.fillSecondaryContactInformation(contactInfo_secondaryname, contactInfo_secondarytitle, 
				contactInfo_secondaryphonenumber, contactInfo_secondaryaltphonenumber, contactInfo_secondaryemail);
		CustomAssert.assertTrue(flag, "Filled Secondary Contact Information Successfully", "Unable to fill Secondary contact information");
		
		flag = contactInformation_Partner.fillAuthorizedSignatory(contactInfo_authorizedname, contactInfo_authorizedtitle);
		CustomAssert.assertTrue(flag, "Filled Authorized Signatory Information", "Unable to fill authorized signatory information");
		
		flag = contactInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = otherInformation_Partner.fillAllFields(otherInfo_estnumofgames, otherInfo_estnumofgamers, 
				otherInfo_gamegrowth, otherInfo_gamergrowth);
		CustomAssert.assertTrue(flag, "Filled All Fields on Other Information Page Successfully", 
				"Unable to fill details on Other Information Page");
		
		flag = otherInformation_Partner.selectRadioButton(otherInfo_option);
		CustomAssert.assertTrue(flag, "selected an option successfully", "Unable to select an option");
		
		flag = otherInformation_Partner.clickButton(false, true);
		CustomAssert.assertTrue(flag, "Clicked on Next Button Successfully", "Unable to click on Next Button");
		
		WaitClass.waitForTime(2000);
		
		flag = termsAndConditions_Partner.enableTermsAndConditions(true);
		CustomAssert.assertTrue(flag, "Successfully Checked Terms and Conditions", "Unable to check terms and conditions");
		
		flag = termsAndConditions_Partner.clickButton(false, true, false);
		CustomAssert.assertTrue(flag, "Clicked on Submit Button Successfully", "Unable to click on Submit Button");
		
		WaitClass.waitForTime(2000);
		
		flag = profilePending_Partner.checkLoggedInUserName(name);
		CustomAssert.assertTrue(flag, "Validated User Greeting Successfully", "Unable to validate user greeting");
		
		flag = profilePending_Partner.validatePageHeading("Application Pending");
		CustomAssert.assertTrue(flag, "Validated Application Status Successfully", "Unable to validate application status");
	}
	
}
