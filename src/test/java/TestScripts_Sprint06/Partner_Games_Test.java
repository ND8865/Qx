package TestScripts_Sprint06;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.MailBox;
import PageObjectClasses.Partner_Games_Page;
import PageObjectClasses.SignIn_Partner_Pages;
import PageObjectClasses.SignUp_CreateAccount_Partner_Page;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Partner_Games_Test {
	private WebDriver driver;
	SignIn_Partner_Pages signInPartner;
	Partner_Games_Page partnerpage;
	SignUp_CreateAccount_Partner_Page partner;
	MailBox mail;
	
	
	String username;
	String userpassword;
	String rejectedusername0;
	String rejectedpassword0;
	String gameNameT;
	
	
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
		count = Utility.getPropertiesFile("testDataVariables", "gameCountapi");
		c = Integer.parseInt(count)+1;
		String gameName = "Game "+c;
		Utility.setTempProperties("testDataVariables", "gameCountapi",c+"");
		flag = APICalls.addGamePartner(username, userpassword, gameName);
		Assert.assertTrue(flag);
		
		count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		c = Integer.parseInt(count)+1;
		rejectedusername0 = "qa_partner11"+c;
		String RejectedEmailParner = "qa_partner11"+c+"@1secmail.com";
		rejectedpassword0 = "Qwerty@12345678";
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		
		driver = DriverClass.setDriver("chrome", "partner");
		partner = new SignUp_CreateAccount_Partner_Page(driver);
		WaitClass.waitForTime(10000);
		flag = partner.CreateAccountButtonClick();
		Assert.assertTrue(flag);
		flag = partner.SignUpCreateAccount("Automation Partner", rejectedusername0, RejectedEmailParner, rejectedpassword0, rejectedpassword0);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(5000);
        mail = new MailBox();
        verificationCode = mail.getEmailData(RejectedEmailParner, "body > em", 2);
		flag = partner.ConfirmAccount(verificationCode);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(10000);
		driver.quit();
		flag = APICalls.rejectPartnerAccountAfterSignup(RejectedEmailParner, rejectedusername0, rejectedpassword0, Utility.getPropertiesFile("primaryLogin", "superAdminUsername"), Utility.getPropertiesFile("primaryLogin", "superAdminPassword"));
		Assert.assertTrue(flag);
	}
	

	@BeforeMethod
	public void browserlaunch() {
		driver = DriverClass.setDriver("chrome", "partner");
		signInPartner = new SignIn_Partner_Pages(driver);
		partnerpage = new Partner_Games_Page(driver);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	/* Partner | Games - Search */

	@Test(priority = 1, description = " Verify if Admin is able to sign in through the correct credentials  ", enabled = true)
	public void TSSHYB393() {

		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
	}

	@Test(priority = 2, description = " Verify that user is able to click on Games button on Deshboard and is routed to Games tab.  ", enabled = true)
	public void TSSHYB394() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
	}

	@Test(priority = 3, description = " Verify that user is able to click on search bar.  ", enabled = true)
	public void TSSHYB395() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.SearchField();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on search field ",
				"Unable to Verify that User is able to Click on Games Button.");
	}

	@Test(priority = 4, description = " Verify if user can search the games through the game name and game description  ", enabled = true)
	public void TSSHYB396() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.SearchField();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on search field ",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.SearchGames();
		CustomAssert.assertTrue(flag, "Verify that User is able to Search by Game NAme. ",
				"Unable to Verify that User is able to Search by Game NAme. ");
	}

	@Test(priority = 5, description = " Verify if user searches in the grid view then same result should be populated in the list view untill and unless the search box is cleared  ", enabled = true)
	public void TSSHYB397() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.SearchField();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on search field ",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.SearchGames();
		CustomAssert.assertTrue(flag, "Verify that User is able to Search by Game NAme. ",
				"Unable to Verify that User is able to Search by Game NAme. ");
	}

	@Test(priority = 6, description = " Verify if user searches in the list view then same result should be populated in the grid view untill and unless the search box is cleared  ", enabled = true)
	public void TSSHYB398() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.Listbutton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on list button. ",
				"Unable to Verify that User is able to Click on list button.");
		flag = partnerpage.SearchGamesdescription();
		CustomAssert.assertTrue(flag, "Verify that User is able to Search by Game NAme. ",
				"Unable to Verify that User is able to Search by Game NAme. ");
	}

	@Test(priority = 7, description = " Verify if Partner removes the texts in search box, then the full listing will again appear.  ", enabled = true)
	public void TSSHYB399() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.Listbutton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on list button. ",
				"Unable to Verify that User is able to Click on list button.");
		flag = partnerpage.viewallgamenamelist();
		CustomAssert.assertTrue(flag,
				"Verify that User is able to check the all games are present in list view after clear the search box value.",
				"Unable to Verify that User is able to check the all games are present in list view after clear the search box value.");
	}

	@Test(priority = 8, description = "Verify if user clicks on any game from the search result and clicks on the back button. the seach box should still have the same text and result should be populated.  ", enabled = true)
	public void TSSHYB400() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.Listbutton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on list button. ",
				"Unable to Verify that User is able to Click on list button.");
		flag = partnerpage.viewallgamenamelist();
		CustomAssert.assertTrue(flag,
				"Verify that User is able to check the all games are present in list view after clear the search box value.",
				"Unable to Verify that User is able to check the all games are present in list view after clear the search box value.");
		flag = partnerpage.Listbutton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on list button. ",
				"Unable to Verify that User is able to Click on list button.");
		flag = partnerpage.Validatesearchfield();
		CustomAssert.assertTrue(flag,
				"Verify if user clicks on any game from the search result and clicks on the back button. the seach box should still have the same text and result should be populated. ",
				"Unable to Verify if user clicks on any game from the search result and clicks on the back button. the seach box should still have the same text and result should be populated.");
	}
	/* Partner Games Filter */

	@Test(priority = 9, description = "Verify if user can filter the data according to the Game name and status in the grid view. ", enabled = true)
	public void TSSHYB401() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.GamesFilter();
		CustomAssert.assertTrue(flag, "Verify that User can filter the data according to game name and staus.",
				"Unable to Verify that User can filter the data according to game name and staus.");
	}

	@Test(priority = 10, description = "Verify if user can filter the data according to the Game name and status in the list view. ", enabled = true)
	public void TSSHYB402() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.Listbutton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on list button. ",
				"Unable to Verify that User is able to Click on list button.");
		flag = partnerpage.GamesFilter();
		CustomAssert.assertTrue(flag, "Verify that User can filter the data according to game name and staus.",
				"Unable to Verify that User can filter the data according to game name and staus.");

	}

	@Test(priority = 11, description = "Verify if user filters in the list view then same result should be populated in the grid view untill and unless the filter box is cleared. ", enabled = true)
	public void TSSHYB403() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.Listbutton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on list button. ",
				"Unable to Verify that User is able to Click on list button.");
		flag = partnerpage.GamesFilter();
		CustomAssert.assertTrue(flag, "Verify that User can filter the data according to game name and staus.",
				"Unable to Verify that User can filter the data according to game name and staus.");

	}

	@Test(priority = 12, description = "Verify if user filter in the grid view then same result should be populated in the list view untill and unless the filter box is cleared ", enabled = true)
	public void TSSHYB404() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.GamesFilter();
		CustomAssert.assertTrue(flag, "Verify that User can filter the data according to game name and staus.",
				"Unable to Verify that User can filter the data according to game name and staus.");
	}

	/* Partner | Games - Grid / List view */

	@Test(priority = 16, description = "Verify if partner is able to click on Games button from the Dashboard ", enabled = true)
	public void TSSHYB408() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");

	}

	@Test(priority = 17, description = " Verify if Partner can see the Game icon, Game name, Status, Date submitted, Date modified, Date Approved, Description and view icon. ", enabled = true)
	public void TSSHYB409() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.ElementsvisiblityPartnerGames();
		CustomAssert.assertTrue(flag, " verify that All Elements are present on partner games.",
				"Unable to verify that All Elements are present on partner games.");
	}

	@Test(priority = 18, description = " Verify if partner is able to see all the games created by him only in the grid view by default. ", enabled = true)
	public void TSSHYB410() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.ValidateGamesinlist();
		CustomAssert.assertTrue(flag,
				" Verify if partner is able to see all the games created by him only in the grid view by default",
				"Unable to Verify if partner is able to see all the games created by him only in the grid view by default");
	}

	@Test(priority = 19, description = " Verify if partner clicks on the list view icon, he is able to view all the games created by him. ", enabled = true)
	public void TSSHYB411() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		WaitClass.waitForTime(2000);
		flag = partnerpage.Listbutton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on list button. ",
				"Unable to Verify that User is able to Click on list button.");
		flag = partnerpage.ValidateGamesinlist();
		CustomAssert.assertTrue(flag,
				" Verify if partner clicks on the list view icon, he is able to view all the games created by him.",
				"Unable to Verify if partner clicks on the list view icon, he is able to view all the games created by him.");
	}

	@Test(priority = 20, description = " Verify if partner is able to toggle between list view and grid view. ", enabled = true)
	public void TSSHYB412() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.ToggleGridandList();
		CustomAssert.assertTrue(flag, " Verify if partner is able to toggle between list view and grid view.",
				"Unable to Verify if partner is able to toggle between list view and grid view.");

	}

	/* Partner | Games - Add New */

	@Test(priority = 21, description = " Verify if partner can click on the Add game button. ", enabled = true)
	public void TSSHYB413() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.AddnewGamebutton();
		CustomAssert.assertTrue(flag, "Verify that partner can click on the add game button.",
				"Unable to Verify that partner can click on the add game button.");
	}

	@Test(priority = 22, description = " Verify that user can see all element are visible on new add games page : game icon, game name, dowload urls, description, exchange assets. ", enabled = true)
	public void TSSHYB414() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.AddnewGamebutton();
		CustomAssert.assertTrue(flag, "Verify that partner can click on the add game button.",
				"Unable to Verify that partner can click on the add game button.");
		flag = partnerpage.ElementsvisiblityPartnerAddNewGames();
		CustomAssert.assertTrue(flag, " Verify that all elements are visible on add new game page.  ",
				"Unable to Verify that all elements are visible on add new game page.");
	}

	@Test(priority = 23, description = " Verify if partner can click on the Submit button by entering all mandatory fields: Game icon, Game Name, Download URLs, Description & Exchangeable Assets (Optional). ", enabled = true)
	public void TSSHYB415() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.AddnewGamebutton();
		CustomAssert.assertTrue(flag, "Verify that partner can click on the add game button.",
				"Unable to Verify that partner can click on the add game button.");
		flag = partnerpage.UploadGameIcon();
		CustomAssert.assertTrue(flag, " User can upload the Game icon is successfully.",
				"Unable to verify User can upload the Game icon is successfully.");
		String count = Utility.getPropertiesFile("testDataVariables", "gameCountapi");
		int c = Integer.parseInt(count)+1;
		Utility.setTempProperties("testDataVariables", "gameCountapi",c+"");
		gameNameT = "Automation G"+c;
		flag = partnerpage.AddNewGame(gameNameT);
		CustomAssert.assertTrue(flag,
				" User can entering all mandatory fields: Game icon, Game Name, Download URLs, Description & Exchangeable Assets (Optional). ",
				"Unable to verify User can entering all mandatory fields: Game icon, Game Name, Download URLs, Description & Exchangeable Assets (Optional).");
		flag = partnerpage.SubmitButton();
		CustomAssert.assertTrue(flag,
				" User can click on submit button after filled the all details for craete new game or add new game.",
				"Unable to verify User can click on submit button after filled the all details for craete new game or add new game.");
		flag = partnerpage.ToastMessage();
		CustomAssert.assertTrue(flag,
				" User can verify that after click on the submit button there are showing a toast message.",
				"Unable to verify User can verify that after click on the submit button there are showing a toast message.");
	}

	@Test(priority = 24, description = "Verify after submitting the game, game is visible in both list/grid view with status as in-development ", enabled = true)
	public void TSSHYB416() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.AddnewGamebutton();
		CustomAssert.assertTrue(flag, "Verify that partner can click on the add game button.",
				"Unable to Verify that partner can click on the add game button.");
		flag = partnerpage.UploadGameIcon();
		CustomAssert.assertTrue(flag, " User can upload the Game icon is successfully.",
				"Unable to verify User can upload the Game icon is successfully.");
		String count = Utility.getPropertiesFile("testDataVariables", "gameCountapi");
		int c = Integer.parseInt(count)+1;
		Utility.setTempProperties("testDataVariables", "gameCountapi",c+"");
		gameNameT = "Automation G"+c;
		flag = partnerpage.AddNewGame(gameNameT);
		CustomAssert.assertTrue(flag,
				" User can entering all mandatory fields: Game icon, Game Name, Download URLs, Description & Exchangeable Assets (Optional). ",
				"Unable to verify User can entering all mandatory fields: Game icon, Game Name, Download URLs, Description & Exchangeable Assets (Optional).");
		flag = partnerpage.SubmitButton();
		CustomAssert.assertTrue(flag,
				" User can click on submit button after filled the all details for craete new game or add new game.",
				"Unable to verify User can click on submit button after filled the all details for craete new game or add new game.");
		WaitClass.waitForTime(3000);
		flag = partnerpage.validatenewgame(gameNameT);
		CustomAssert.assertTrue(flag,
				" Verify after submitting the game, game is visible in both list/grid view with status as in-development",
				"Unable to Verify after submitting the game, game is visible in both list/grid view with status as in-development");
	}

	@Test(priority = 25, description = " Verify that same partner cannot add two or more games with the same game name. ", enabled = true)
	public void TSSHYB417() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.AddnewGamebutton();
		CustomAssert.assertTrue(flag, "Verify that partner can click on the add game button.",
				"Unable to Verify that partner can click on the add game button.");
		flag = partnerpage.UploadGameIcon();
		CustomAssert.assertTrue(flag, " User can upload the Game icon is successfully.",
				"Unable to verify User can upload the Game icon is successfully.");
		flag = partnerpage.AddnewGameWithSamename(gameNameT);
		CustomAssert.assertTrue(flag,
				" Verify that same partner cannot add two or more games with the same game name. ",
				"Unable to Verify that same partner cannot add two or more games with the same game name.");
	}
	
	@Test(priority = 27, description = " Verify if Partner is disabled, partner will not be able to sign in with a message (User is disabled).", enabled = true)
	public void TSSHYB419() {
		boolean flag = APICalls.enableDisablePartner(username, Utility.getPropertiesFile("primaryLogin", "superAdminUsername"), Utility.getPropertiesFile("primaryLogin", "superAdminPassword"), false);
		CustomAssert.assertTrue(flag, "Partner Disabled.", "Unable to Disable the partner");
		flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.Disabledpartner();
		CustomAssert.assertTrue(flag,
				" Verify if Partner is disabled, partner will not be able to sign in with a message (User is disabled).",
				"Unable to Verify if Partner is disabled, partner will not be able to sign in with a message (User is disabled).");
	}

	/* Partner | Enable/Disable */

	@Test(priority = 28, description = " Verify if Partner is approved he should be able to login and see the dashboard.", enabled = true)
	public void TSSHYB420() {
		boolean flag = APICalls.enableDisablePartner(username, Utility.getPropertiesFile("primaryLogin", "superAdminUsername"), Utility.getPropertiesFile("primaryLogin", "superAdminPassword"), true);
		CustomAssert.assertTrue(flag, "Partner Enabled.", "Unable to Enable the partner");
		flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.Disabledpartner();
		CustomAssert.assertFalse(flag, "Verify if Partner is approved he should be able to login and see the dashboard.",
				"Unable to Verify if Partner is approved he should be able to login and see the dashboard.");
	}


	/* Partner | Reject */

	@Test(priority = 29, description = " Verify if Partner is rejected by the Admin then after login, the partner can see a screen which says Profile Rejected along with the rejection reason given by admin. ", enabled = true)
	public void TSSHYB421() {
		boolean flag = signInPartner.signinActionPartner(rejectedusername0, rejectedpassword0);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.RejectedPartner();
		CustomAssert.assertTrue(flag,
				" Verify if Partner is rejected by the Admin then after login, the partner can see a screen which says Profile Rejected along with the rejection reason given by admin.",
				"Unable to Verify if Partner is rejected by the Admin then after login, the partner can see a screen which says Profile Rejected along with the rejection reason given by admin.");
	}


	@Test(priority = 31, description = " Verify that after clicking on the (Apply Button) button partner is routed to the General information page with no previous data ", enabled = true)
	public void TSSHYB423() {
		boolean flag = signInPartner.signinActionPartner(rejectedusername0,rejectedpassword0);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.RejectedPartner();
		CustomAssert.assertTrue(flag,
				" Verify if Partner is rejected by the Admin then after login, the partner can see a screen which says Profile Rejected along with the rejection reason given by admin.",
				"Unable to Verify if Partner is rejected by the Admin then after login, the partner can see a screen which says Profile Rejected along with the rejection reason given by admin.");
		flag = partnerpage.ClickonApplybutton();
		CustomAssert.assertTrue(flag,
				" Verify that after clicking on the (Apply Button) button partner is routed to the General information page with no previous data. ",
				"Unable to Verify that after clicking on the (Apply Button) button partner is routed to the General information page with no previous data.");
	}

	/* Partner | Games - Sorting */

	@Test(priority = 32, description = " Verify if user can view the games in the grid view by default. ", enabled = true)
	public void TSSHYB424() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.GamesinGridview();
		CustomAssert.assertTrue(flag, "Verify if user can view the games in the grid view by default.",
				"Unable to Verify if user can view the games in the grid view by default.");
	}

	@Test(priority = 33, description = " Verify if user can sort the games in the ascending/descending order according to the Games name, Date submitted, Date Modified, Date Approved in both grid and list view ", enabled = true)
	public void TSSHYB425() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.Listbutton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on list button. ",
				"Unable to Verify that User is able to Click on list button.");
		flag = partnerpage.SortingPartnerGames(1, 0, 0, 0);
		CustomAssert.assertTrue(flag, " Verify that user are able to sort the game name in ASC Order.",
				"Unable to Verify that user are able to sort the game name in ASC Order.");
		flag = partnerpage.SortingPartnerGames(2, 0, 0, 0);
		CustomAssert.assertTrue(flag, " Verify that user are able to sort the game name in Desc Order.",
				"Unable to Verify that user are able to sort the game name in Desc Order.");
		flag = partnerpage.SortingPartnerGames(0, 1, 0, 0);
		CustomAssert.assertTrue(flag, " Verify that user are able to sort the date submit in ASC Order.",
				"Unable to Verify that user are able to sort the date submit in ASC Order.");
		flag = partnerpage.SortingPartnerGames(0, 2, 0, 0);
		CustomAssert.assertTrue(flag, " Verify that user are able to sort the date submit in Desc Order.",
				"Unable to Verify that user are able to sort the datesubmit in Desc Order.");
		flag = partnerpage.SortingPartnerGames(0, 0, 1, 0);
		CustomAssert.assertTrue(flag, " Verify that user are able to sort the date modified in ASC Order.",
				"Unable to Verify that user are able to sort the date modified in ASC Order.");
		flag = partnerpage.SortingPartnerGames(0, 0, 2, 0);
		CustomAssert.assertTrue(flag, " Verify that user are able to sort the date modified in Desc Order.",
				"Unable to Verify that user are able to sort the date modified in Desc Order.");
		flag = partnerpage.SortingPartnerGames(0, 0, 0, 1);
		CustomAssert.assertTrue(flag, " Verify that user are able to sort the date approved in ASC Order.",
				"Unable to Verify that user are able to sort the date approved in ASC Order.");
		flag = partnerpage.SortingPartnerGames(0, 0, 0, 2);
		CustomAssert.assertTrue(flag, " Verify that user are able to sort the date approved in Desc Order.",
				"Unable to Verify that user are able to sort the date approved in Desc Order.");
	}

	/* Partner | Game - Status */

	@Test(priority = 34, description = " Verify if Partner is able to click on edit to change the status to Submit for approval to get approval from Admin. ", enabled = true)
	public void TSSHYB426() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.Listbutton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on list button. ",
				"Unable to Verify that User is able to Click on list button.");
		flag = partnerpage.ChangeStatus();
		CustomAssert.assertTrue(flag,
				"Verify if Partner is able to click on edit to change the status to Submit for approval. ",
				"Unable to Verify if Partner is able to click on edit to change the status to Submit for approval.");
	}

	@Test(priority = 35, description = " Verify if Partner can click on update button after change the status to Submit for approval . ", enabled = true)
	public void TSSHYB427() {
		boolean flag = signInPartner.signinActionPartner(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  Partner.",
				"Unable to Verify Sign In is Successful on  Partner.");
		flag = partnerpage.GamesButton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on Games Button.",
				"Unable to Verify that User is able to Click on Games Button.");
		flag = partnerpage.Listbutton();
		CustomAssert.assertTrue(flag, "Verify that User is able to Click on list button. ",
				"Unable to Verify that User is able to Click on list button.");
		flag = partnerpage.ChangeStatus();
		CustomAssert.assertTrue(flag,
				"Verify if Partner is able to click on edit to change the status to Submit for approval. ",
				"Unable to Verify if Partner is able to click on edit to change the status to Submit for approval.");
		flag = partnerpage.Updatebutton();
		CustomAssert.assertTrue(flag,
				"Verify if Partner can click on update button after change the status to Submit for approval . ",
				"Unable to Verify if Partner can click on update button after change the status to Submit for approval .");

	}


}
