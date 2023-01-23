package TestScripts_Sprint05;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.PendingAndAmmendmentsSuggestedPartnerStatus_Admin;
import PageObjectClasses.SignIn_Admin_Pages;
import TestListners.CustomAssert;
import UtilityClass.Utility;

public class PendingAndAmmendmentsSuggestedPartnerStatus_Admin_Tests {
	
	private WebDriver driver;
	SignIn_Admin_Pages signInAdmin;
	String username;
	String userpassword;
	PendingAndAmmendmentsSuggestedPartnerStatus_Admin partnersUserPage;

	@BeforeMethod
	public void browserlaunch() {
		driver = DriverClass.setDriver("chrome", "admin");
		signInAdmin = new SignIn_Admin_Pages(driver);
		username = Utility.getPropertiesFile("primaryLogin", "superAdminUsername");
		userpassword = Utility.getPropertiesFile("primaryLogin", "superAdminPassword");
		partnersUserPage = new PendingAndAmmendmentsSuggestedPartnerStatus_Admin(driver);
		
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
    
	@Test( description = "Verify if Admin is able to sign in through the correct credentials")
	public void TSSHYB313() {
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
	
	}
	
	@Test( description = "Verify if user can view the list of Pending/Ammendment Suggested partners by selecting Pending/Ammendments Suggested Status")
	public void TSSHYB314() {
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.statusFilterForPendingAndAmendment();
		CustomAssert.assertTrue(flag, "Pending and amendment suggested filter validated successfully","Fail to validate Pending and amendment suggested filter");
	
	}
	
	@Test( description = "Verify if the status is pending, admin should be able to suggest modification by clicking on the view icon")
	public void TSSHYB315() {
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerPendingDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner pending  detail page","Fail to navigae on partner pending detail page.");
		flag = partnersUserPage.suggestModificationGeneralInfo();
		CustomAssert.assertTrue(flag, "General info modification pop-up validated successfully","Fail to validate General info modification pop-up");
	
	}
	
	@Test( description = "Verify if the status is Amendments suggested, admin should be able to suggest modification by clicking on the view icon")
	public void TSSHYB316() {
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerAmendmentSuggestedDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner Amendment Suggested  detail page","Fail to navigae on partner Amendmen tSuggested detail page.");
		flag = partnersUserPage.suggestModificationGeneralInfo();
		CustomAssert.assertTrue(flag, "General info modification pop-up validated successfully","Fail to validate General info modification pop-up");
	
	}
	
	@Test( description = "Verify if the status is DocuSign pending, admin should not be able to suggest modification by clicking on the view icon")
	public void TSSHYB317() {
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerDocuSignDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner DocuSign detail page","Fail to navigae on partner DocuSign detail page.");
		flag = partnersUserPage.suggestModificationButton();
		CustomAssert.assertFalse(flag, "Suggest modification button become invisible successfully","Suggest modification button is visible");
	
	}
	
	
	
	@Test( description = "Verify if user is able to click on the button Suggest Modifications under General Information, Contact Information, Other Information")
	public void TSSHYB318() {
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerPendingDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner pending  detail page","Fail to navigae on partner pending detail page.");
		flag = partnersUserPage.suggestModificationButtonClick();
		CustomAssert.assertTrue(flag, "All Suggest modification pop-up validated successfully","Fail to validate Suggest modification pop-up");
	
	}
	
	@Test( description = "Verify if user is able to type in the text box of the suggest modification of one or all the headings")
	public void TSSHYB319() {
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerPendingDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner pending  detail page","Fail to navigae on partner pending detail page.");
		flag = partnersUserPage.suggestModificationPopupEnterText();
		CustomAssert.assertTrue(flag, "All Suggest modification pop-up enter text validated successfully","Fail to validate Suggest modification pop-up enter text");
	
	}
	
	@Test( description = "Verify if user types in the text in the suggest modification box and clicks on cancel, changes should not be reflected")
	public void TSSHYB320() {
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerPendingDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner pending  detail page","Fail to navigae on partner pending detail page.");
		flag = partnersUserPage.suggestModificationPopupCancelButton();
		CustomAssert.assertTrue(flag, "All Suggest modification pop-up cancel button validated successfully","Fail to validate Suggest modification pop-up enter text cancel button");
	
	}
	
	@Test( description = "Verify if user types in the text in the suggest modification box and clicks on save, changes get reflected")
	public void TSSHYB321() {
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerPendingDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner pending  detail page","Fail to navigae on partner pending detail page.");
		flag = partnersUserPage.suggestModificationFlow(true, false, false);
		CustomAssert.assertTrue(flag, "General info modification validated successfully","Fail to validate General info modification");
		flag = partnersUserPage.suggestModificationFlow(false, true, false);
		CustomAssert.assertTrue(flag, "Contact info modification validated successfully","Fail to validate contact info modification");
		flag = partnersUserPage.suggestModificationFlow(false, false, true);
		CustomAssert.assertTrue(flag, "Other info modification validated successfully","Fail to validate other info modification");
	}
	
	@Test( description = "Verify that the user should fill in the text for at least one suggest modification box")
	public void TSSHYB322() {
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerPendingDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner pending  detail page","Fail to navigae on partner pending detail page.");
		flag = partnersUserPage.suggestModificationSingleButton();
		CustomAssert.assertTrue(flag, "Single Suggest modification enter text validated successfully","Fail to validate Single Suggest modification enter text");
	}
	
	@Test( description = "Verify after saving, the button will be changed to edit modification")
	public void TSSHYB323() {
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerPendingDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner pending  detail page","Fail to navigae on partner pending detail page.");
		flag = partnersUserPage.suggestModificationFlow(true, false, false);
		CustomAssert.assertTrue(flag, "General info modification save button validated successfully","Fail to validate General info modification save button");
	}
	
	@Test( description = "Verify if user can edit the modification anytime for pending status after clicking on edit modification")
	public void TSSHYB324() {
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerPendingDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner pending  detail page","Fail to navigae on partner pending detail page.");
		flag = partnersUserPage.suggestModificationFlow(true, false, false);
		CustomAssert.assertTrue(flag, "General info modification save button validated successfully","Fail to validate General info modification save button");
		flag = partnersUserPage.suggestModificationSaveButton();
		CustomAssert.assertTrue(flag, "Edit General info modification save button validated successfully","Fail to validate Edit General info modification save button");
	}
	
	@Test( description = "Verify if user can edit the modification anytime for Amendments suggest status after clicking on edit modification")
	public void TSSHYB325() {
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerAmendmentSuggestedDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner Amendment Suggested  detail page","Fail to navigae on partner Amendmen tSuggested detail page.");
		flag = partnersUserPage.suggestModificationSaveButton();
		CustomAssert.assertTrue(flag, "Edit General info modification save button validated successfully","Fail to validate Edit General info modification save button");
	}
	
	@Test( description = "Verify if user clicks on Send Modification button text written in all three suggest modification boxes are saved and sent to the partner")
	public void TSSHYB326() {
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerPendingDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner pending  detail page","Fail to navigae on partner pending detail page.");
		flag = partnersUserPage.suggestModificationFlow(true, false, false);
		CustomAssert.assertTrue(flag, "General info modification validated successfully","Fail to validate General info modification");
		flag = partnersUserPage.suggestModificationFlow(false, true, false);
		CustomAssert.assertTrue(flag, "Contact info modification validated successfully","Fail to validate contact info modification");
		flag = partnersUserPage.suggestModificationFlow(false, false, true);
		CustomAssert.assertTrue(flag, "Other info modification validated successfully","Fail to validate other info modification");
		flag = partnersUserPage.sendModificationValidation();
		CustomAssert.assertTrue(flag, "Send modification button validated successfully","Fail to validate oSend modification button");
	
	}
	
	@Test( description = "Verify that the user should click on resolve for three edit modifications before clicking on Accept and Confirm button")
	public void TSSHYB327() {
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Admin sigin validated successfully","Fail to validate admin signin");
		flag = partnersUserPage.navigateToPartnerAmendmentSuggestedDetail();
		CustomAssert.assertTrue(flag, "Admin navigated to partner Amendment Suggested  detail page","Fail to navigae on partner Amendmen tSuggested detail page.");
		flag = partnersUserPage.editSuggestModificationResolveButton();
		CustomAssert.assertTrue(flag, "Edit General info modification resolve button validated successfully","Fail to validate Edit General info modification resolve button");
	}
	
}
