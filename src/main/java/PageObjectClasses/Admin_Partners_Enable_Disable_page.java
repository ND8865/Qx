package PageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Admin_Partners_Enable_Disable_page {
	WebDriver driver;
	SoftAssert softassert;

	public Admin_Partners_Enable_Disable_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		softassert = new SoftAssert();
	}

	@FindBy(xpath = "//label[text()='Status']/following-sibling::div")
	private WebElement SelectStatus;
	@FindBy(xpath = "//*[text()='Disabled']//preceding-sibling::input")
	private WebElement CheckBoxClickStatus;
	@FindBy(xpath = "//label[contains(text(),'Primary Phone')]")
	private WebElement PrimaryPhoneHeader;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[5]")
	private List<WebElement> SortingStatus;
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M19 6.41L1')]")
	private WebElement DropDownCross;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[1]")
	private List<WebElement> SortingPartnerGames;
	@FindBy(xpath = "//*[text()='Approved']//preceding-sibling::input")
	private WebElement CheckBoxClickStatusApproved;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[6]")
	private List<WebElement> SortingView;
	@FindBy(xpath = "//h4[text()='General Information']")
	private WebElement GeneralInformation;
	@FindBy(xpath = "//input[@data-testid = 'searchKey']")
	private WebElement SearchFields;
	@FindBy(xpath = "//*[contains(text(),'Enabled')]")
	private WebElement EnableToggelButton;
	@FindBy(xpath = "//h4[text()='Akash Pro plus']")
	private WebElement usernameheader;
	@FindBy(xpath = "//h2[contains(text(),'Deactivate Partner?')]")
	private WebElement DeactivatePartnerHeading;
	@FindBy(xpath = "//p[contains(text(),'Are you sure you want to deactivate this partner?')]")
	private WebElement DeactivatePartnertext;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement CancelDeactivatetb;
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	private WebElement ConfirmDeactivatetb;
	@FindBy(xpath = "//div[contains(text(),'Partner disabled successfully')]")
	private WebElement TooltipPartnerDisabled;
	@FindBy(xpath = "//span[contains(text(),'Games')]")
	private WebElement GamesTab;
	@FindBy(xpath = "//span[contains(text(),'Offers')]")
	private WebElement OfferTab;
	@FindBy(xpath = "//span[contains(text(),'Events')]")
	private WebElement EventsTab;
	@FindBy(xpath = "//h2[contains(text(),'Activate Partner?')]")
	private WebElement ActivatePartnerheading;
	@FindBy(xpath = "//p[contains(text(),'Are you sure you want to activate this partner?')]")
	private WebElement ActivatePartnertext;
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	private WebElement ActivateConfirmButton;
	@FindBy(xpath = "//div[contains(text(),'Partner enabled successfully')]")
	private WebElement EnablePartnerToltip;
	/**
	 * Description - Verify if ADMIN is able to filter the disabled partners.
	 * 
	 * @return - True - If disabled filter are working and confirm disable partner
	 *         are present in the list .
	 * 
	 */
	public boolean DisablePartners() {
		boolean approvedallgames = false;

		try {
			Actions action = new Actions(driver);
			SelectStatus.click();
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(CheckBoxClickStatus, driver);
			WaitClass.waitForTime(2000);
			action.moveToElement(PrimaryPhoneHeader).click().perform();
			WaitClass.waitForTime(2000);
			for (int i = 0; i <= SortingPartnerGames.size() - 1; i++) {
				String approvedstatusgames = SortingPartnerGames.get(i).getText();
				if (driver.getPageSource().contains(approvedstatusgames)) {
					approvedallgames = true;
				}

			}
			action.moveToElement(DropDownCross).click().perform();
			return approvedallgames;
		}

		catch (Exception e) {

			System.err
					.println("Exception in Method - DisablePartenr, Class - Admin_Partners_Enable_Disable_page : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify if ADMIN is able to filter the Approved partners.
	 * 
	 * @return - True - If Approved filter are working and confirm Approved partners
	 *         are present in the list .
	 */
	public boolean FilterApprovedPartners() {
		boolean approvedallgames = false;

		try {
			Actions action = new Actions(driver);
			SelectStatus.click();
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(CheckBoxClickStatusApproved, driver);
			WaitClass.waitForTime(2000);
			action.moveToElement(PrimaryPhoneHeader).click().perform();
			WaitClass.waitForTime(2000);
			for (int i = 0; i <= SortingPartnerGames.size() - 1; i++) {
				String approvedstatusgames = SortingPartnerGames.get(i).getText();
				if (driver.getPageSource().contains(approvedstatusgames)) {
					approvedallgames = true;
				}

			}
			// action.moveToElement(DropDownCross).click().perform();
			return approvedallgames;
		}

		catch (Exception e) {

			System.err.println(
					"Exception in Method - FilterApprovedPartners, Class - Admin_Partners_Enable_Disable_page : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify if ADMIN is able to click on view button for Active
	 * partner.
	 * 
	 * @return - True - If Verify if ADMIN is able to click on view button for
	 *         Active partner.
	 */
	public boolean ClickViewButton(String username) {

		try {
			SearchFields.click();
			SearchFields.sendKeys(username);
			SortingView.get(0).click();
			boolean geninfo = GeneralInformation.isDisplayed();
			return geninfo;
		}

		catch (Exception e) {

			System.err.println(
					"Exception in Method - ClickViewButton, Class - Admin_Partners_Enable_Disable_page : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify if ADMIN is able to change the toggle button.
	 * 
	 * 
	 * @return - True - If if ADMIN is able to change the toggle button.
	 * 
	 */
	public boolean ToggleButton() {

		try {
			EnableToggelButton.click();
			boolean UserHeadr = usernameheader.isDisplayed();
			return UserHeadr;
		}

		catch (Exception e) {

			System.err.println("Exception in Method - ToggleButton, Class - Admin_Partners_Enable_Disable_page : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify if ADMIN can click on Cancel Button.
	 * 
	 * @return - True - If Verify that ADMIN Can click on Cancel Button.
	 * 
	 */
	public boolean DeactivatePartners() {

		try {
			boolean flag = DeactivatePartnerHeading.isDisplayed();
			flag = flag && DeactivatePartnertext.isDisplayed();
			flag = flag && CancelDeactivatetb.isDisplayed();
			flag = flag && ConfirmDeactivatetb.isDisplayed();
			CancelDeactivatetb.click();
			return flag;
		}

		catch (Exception e) {

			System.err.println(
					"Exception in Method - DeactivatePartners, Class - Admin_Partners_Enable_Disable_page : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify if ADMIN can click on Confirm Button.
	 * 
	 * @return - True - If ADMIN Can click on Confirm Button and deactivate the
	 *         Partners .
	 * 
	 */
	public boolean DeactivatePartnersConfirm() {

		try {
			boolean flag = DeactivatePartnerHeading.isDisplayed();
			flag = flag && DeactivatePartnertext.isDisplayed();
			flag = flag && CancelDeactivatetb.isDisplayed();
			flag = flag && ConfirmDeactivatetb.isDisplayed();
			return flag;
		}

		catch (Exception e) {

			System.err.println(
					"Exception in Method - DeactivatePartnersConfirm, Class - Admin_Partners_Enable_Disable_page : "
							+ e);
			return false;
		}
	}

	/**
	 * Description - Verify if ADMIN can click on Confirm Button and Verify the
	 * Alert text for Disable the Partner.
	 * 
	 * @return - True - If ADMIN Can click on Confirm Button and deactivate the
	 *         Partners .
	 * 
	 */
	public boolean Disablealerttext() {

		try {
			boolean flag = DeactivatePartnerHeading.isDisplayed();
			flag = flag && DeactivatePartnertext.isDisplayed();
			flag = flag && CancelDeactivatetb.isDisplayed();
			flag = flag && ConfirmDeactivatetb.isDisplayed();
			ConfirmDeactivatetb.click();
			WaitClass.waitForTime(2000);
			String alerttext = Utility.getalerttext(driver, TooltipPartnerDisabled);
			String alerttextext = "Partner disabled successfully";
			Assert.assertEquals(alerttext, alerttextext);
			softassert.assertAll();
			return flag;
		}

		catch (Exception e) {

			System.err.println(
					"Exception in Method - Disablealerttext, Class - Admin_Partners_Enable_Disable_page : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify if all the Games, Offers & Events of that partner will
	 * get disabled.
	 * 
	 * @return - True - if all the Games,offers & Events of that partner will get
	 *         disabled.
	 * 
	 */
	public boolean ValidateDisabledPartners() {

		try {
			GamesTab.click();
			driver.findElement(By.xpath("//input[@placeholder='Search by Game Name, Description...']"))
					.sendKeys(Utility.getPropertiesFile("primaryLogin", "PartnerName"));
			String DisabledPartnersText = driver
					.findElements(By.xpath("//div[contains(@class,'table-body')]//div[@class='table-row']/div[6]"))
					.get(0).getText();
			String Expected = "Disabled";
			softassert.assertEquals(DisabledPartnersText, Expected);
			softassert.assertAll();
			EventsTab.click();
			WaitClass.waitForTime(2000);
			driver.findElement(By.xpath("//input[@placeholder='Search by Event Name, Partner...']"))
					.sendKeys(Utility.getPropertiesFile("primaryLogin", "PartnerName"));
			WaitClass.waitForTime(2000);
			String DisabledPartnersTexta = driver
					.findElements(By.xpath("//div[contains(@class,'table-body')]//div[@class='table-row']/div[5]"))
					.get(0).getText();
			WaitClass.waitForTime(2000);
			String Expectedb = "Disabled";
			softassert.assertEquals(DisabledPartnersTexta, Expectedb);
			softassert.assertAll();

			return true;
		}

		catch (Exception e) {

			System.err.println(
					"Exception in Method - ValidateDisabledPartners, Class - Admin_Partners_Enable_Disable_page : "
							+ e);
			return false;
		}
	}

	/**
	 * Description -Verify if account is disabled and for already loged in partner
	 * after screen refreshing user is disabled text message will appear.
	 * 
	 * 
	 * @return - True - If User is disabled text is present after Sign in with
	 *         Disabled Account.
	 * 
	 */
	public boolean ValidateDisabledAccount() {

		try {
			String disabledtext = driver.findElement(By.xpath("//div[@class='amplify-alert__body']")).getText();
			String expectedtext = "User is disabled.";
			softassert.assertEquals(disabledtext, expectedtext);
			softassert.assertAll();
			return true;
		}

		catch (Exception e) {

			System.err.println(
					"Exception in Method - ValidateDisabledAccount, Class - Admin_Partners_Enable_Disable_page : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify if ADMIN is able to click on view button for Disable
	 * partner.
	 * 
	 * @return - True - If Verify if ADMIN is able to click on view button for
	 *         Disable partner.
	 */
	public boolean DisabledPartner() {

		try {
			SearchFields.click();
			SearchFields.sendKeys(Utility.getPropertiesFile("primaryLogin", "UserNameAdminPartners"));
			SortingView.get(0).click();
			boolean geninfo = GeneralInformation.isDisplayed();
			return geninfo;
		}

		catch (Exception e) {

			System.err.println(
					"Exception in Method - DisabledPartner, Class - Admin_Partners_Enable_Disable_page : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify that Cancel button is working properly after change the
	 * toggle button from red to green.
	 * 
	 * @return - True - If Cancel button is working fine.
	 *         
	 */
	public boolean CancelButton() {

		try {
			
			CancelDeactivatetb.click();
			return true;
		}

		catch (Exception e) {

			System.err.println(
					"Exception in Method - CancelButton, Class - Admin_Partners_Enable_Disable_page : " + e);
			return false;
		}
}
	/**
	 * Description - Verify if ADMIN can click on Confirm Button Partner should be Activate.
	 * 
	 * @return - True - If ADMIN Can click on Confirm Button and Active the
	 *         Partners .
	 * 
	 */
	public boolean ActivatePartnersConfirm() {

		try {
			boolean flag = ActivatePartnerheading.isDisplayed();
			flag = flag && ActivatePartnertext.isDisplayed();
			flag = flag && CancelDeactivatetb.isDisplayed();
			flag = flag && ActivateConfirmButton.isDisplayed();
			ActivateConfirmButton.click();
			WaitClass.waitForTime(2000);
			String alerttext = Utility.getalerttext(driver, EnablePartnerToltip);
			String alerttextext = "Partner enabled successfully";
			Assert.assertEquals(alerttext, alerttextext);
			softassert.assertAll();
			return flag;
		}

		catch (Exception e) {

			System.err.println(
					"Exception in Method - ActivatePartnersConfirm, Class - Admin_Partners_Enable_Disable_page : "
							+ e);
			return false;
		}
	}








}
