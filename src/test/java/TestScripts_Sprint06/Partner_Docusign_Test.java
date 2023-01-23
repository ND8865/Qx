package TestScripts_Sprint06;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.Partner_Docusign_page;
import PageObjectClasses.SignIn_Admin_Pages;
import TestListners.CustomAssert;
import UtilityClass.Utility;

public class Partner_Docusign_Test {
	private WebDriver driver;
	SignIn_Admin_Pages signInAdmin;
	String username;
	String userpassword;
	Partner_Docusign_page docusign;

	@BeforeMethod
	public void browserlaunch() {
		driver = DriverClass.setDriver("chrome", "admin");
		signInAdmin = new SignIn_Admin_Pages(driver);
		username = Utility.getPropertiesFile("primaryLogin", "superAdminUsername");
		userpassword = Utility.getPropertiesFile("primaryLogin", "superAdminPassword");
		docusign = new Partner_Docusign_page(driver);
	}

	 @AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1, description = " Verify that Sign In is Successfully on ADMIN  ", enabled = true)
	public void TSSHYB429() {

		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
	}

	@Test(priority = 2, description = " Verify that user can click on the Partner Tab.  ", enabled = true)
	public void TSSHYB430() {

		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = docusign.PartnerButton();
		CustomAssert.assertTrue(flag, "Verify that user can click on the Partner Tab.",
				"Unable to Verify that user can click on the Partner Tab.");
	}

	@Test(priority = 3, description = " Verify that User can filter the value by status.  ", enabled = true)
	public void TSSHYB431() {

		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = docusign.PartnerButton();
		CustomAssert.assertTrue(flag, "Verify that user can click on the Partner Tab.",
				"Unable to Verify that user can click on the Partner Tab.");
		flag = docusign.Filterstatus();
		CustomAssert.assertTrue(flag, "Verify that User can filter the value by status.",
				"Unable to Verify that User can filter the value by status.");

	}

	@Test(priority = 4, description = "Verify that if the admin has given something suggesstion then clicking on Accept & Confirm without resolving it will show error message (Please resolve all suggested modifications).  ", enabled = true)
	public void TSSHYB432() {

		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = docusign.PartnerButton();
		CustomAssert.assertTrue(flag, "Verify that user can click on the Partner Tab.",
				"Unable to Verify that user can click on the Partner Tab.");
		flag = docusign.Filterstatus();
		CustomAssert.assertTrue(flag, "Verify that User can filter the value by status.",
				"Unable to Verify that User can filter the value by status.");
		flag = docusign.SuggestionMessage();
		CustomAssert.assertTrue(flag,
				"Verify that if the admin has given something suggesstion then clicking on Accept & Confirm without resolving it will show error message (Please resolve all suggested modifications).",
				"Unable to Verify that if the admin has given something suggesstion then clicking on Accept & Confirm without resolving it will show error message (Please resolve all suggested modifications).");

	}

	@Test(priority = 5, description = "Verify if Admin is able to view (DocuSign Envelope ID) popuop after clicking on Accept & Confirm by resolving all the suggesstions  ", enabled = true)
	public void TSSHYB433() {

		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = docusign.PartnerButton();
		CustomAssert.assertTrue(flag, "Verify that user can click on the Partner Tab.",
				"Unable to Verify that user can click on the Partner Tab.");
		flag = docusign.Filterstatus();
		CustomAssert.assertTrue(flag, "Verify that User can filter the value by status.",
				"Unable to Verify that User can filter the value by status.");
		flag = docusign.DocuSignEnvelopeID();
		CustomAssert.assertTrue(flag,
				"Verify if Admin is able to view (DocuSign Envelope ID) popuop after clicking on Accept & Confirm by resolving all the suggesstions",
				"Unable to Verify if Admin is able to view (DocuSign Envelope ID) popuop after clicking on Accept & Confirm by resolving all the suggesstions");

	}

	@Test(priority = 6, description = " Verify if Admin will view the error message (Please enter envelope ID) after clicking on Submit by leaving the text box as blank.  ", enabled = true)
	public void TSSHYB434() {

		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = docusign.PartnerButton();
		CustomAssert.assertTrue(flag, "Verify that user can click on the Partner Tab.",
				"Unable to Verify that user can click on the Partner Tab.");
		flag = docusign.Filterstatus();
		CustomAssert.assertTrue(flag, "Verify that User can filter the value by status.",
				"Unable to Verify that User can filter the value by status.");
		flag = docusign.ValidateEnvelopeIdErrorMessage();
		CustomAssert.assertTrue(flag,
				"Verify if Admin will view the error message (Please enter envelope ID) after clicking on Submit by leaving the text box as blank.",
				"Unable to Verify if Admin will view the error message (Please enter envelope ID) after clicking on Submit by leaving the text box as blank.");

	}

	@Test(priority = 7, description = " Verify if Admin is able to submit by entering valid DocuSign Envelope ID.  ", enabled = true)
	public void TSSHYB435() {

		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = docusign.PartnerButton();
		CustomAssert.assertTrue(flag, "Verify that user can click on the Partner Tab.",
				"Unable to Verify that user can click on the Partner Tab.");
		flag = docusign.Filterstatus();
		CustomAssert.assertTrue(flag, "Verify that User can filter the value by status.",
				"Unable to Verify that User can filter the value by status.");
		flag = docusign.EnterEnvelopeId();
		CustomAssert.assertTrue(flag, "Verify if Admin is able to submit by entering valid DocuSign Envelope ID.",
				"Unable to Verify if Admin is able to submit by entering valid DocuSign Envelope ID.");

	}

}
