package PageObjectClasses;

import java.util.ArrayList;
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

public class Admin_Users_Page {
	WebDriver driver;
	SoftAssert softassert;

	public Admin_Users_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		softassert = new SoftAssert();
	}

	@FindBy(xpath = "//img[@alt='logo']")
	private WebElement AcQyrLogo;
	@FindBy(xpath = "//span[normalize-space()='Admin Users']")
	private WebElement AdminUsersButton;
	@FindBy(xpath = "//input[@placeholder='Search by Full Name, Username...']")
	private WebElement SearchBarField;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[1]")
	private List<WebElement> SortingFullName;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[2]")
	private List<WebElement> SortingUserName;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[3]")
	private List<WebElement> SortingEmail;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[4]")
	private List<WebElement> SortingStatus;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[5]")
	private List<WebElement> SortingActions;
	@FindBy(xpath = "//div[@class='table-body no-scrollbar']//div[1]//div[5]//span[1]//*[name()='svg']")
	private WebElement ActionButton;
	@FindBy(xpath = "//label[contains(text(),'Enabled')]")
	private WebElement EnabledTextButton;
	@FindBy(xpath = "//h2[contains(text(),'Disable Admin?')]")
	private WebElement DisablePopupText;
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	private WebElement ConfirmButton;
	@FindBy(xpath = "//h2[contains(text(),'Enable Admin?')]")
	private WebElement EnablePopupText;
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	private WebElement UpdateButton;
	@FindBy(xpath = "//div[@class='rrt-title' or contains(text(),'Admin user updated successfully.')]")
	private WebElement AlertAfterUpdateButton;
	@FindBy(xpath = "//div[@data-testid='full-name']//div//span[@class='css-1v99tuv'][normalize-space()='Select']")
	private WebElement SelectFullName;
	@FindBy(xpath = "//*[text()='Aaaa']//preceding-sibling::input")
	private WebElement CheckBoxClickfullname;
	@FindBy(xpath = "//label[normalize-space()='Full Name']")
	private WebElement HeaderFullNAme;
	@FindBy(xpath = "//div[@title='Clear all']//*[name()='svg']")
	private WebElement DropDownCross;
	@FindBy(xpath = "//div[@data-testid='username']//div//span[@class='css-1v99tuv'][normalize-space()='Select']")
	private WebElement SelectUserName;
	@FindBy(xpath = "//*[text()='Mac']//preceding-sibling::input")
	private WebElement CheckBoxClickUserName;
	@FindBy(xpath = "//label[normalize-space()='Username']")
	private WebElement HeaderUserName;
	@FindBy(xpath = "//div[@data-testid='useremail']//div//span[@class='css-1v99tuv'][normalize-space()='Select']")
	private WebElement SelectUserEmail;
	@FindBy(xpath = "//*[text()='mac@yopmail.com']//preceding-sibling::input")
	private WebElement CheckBoxClickEmail;
	@FindBy(xpath = "//label[normalize-space()='Email']")
	private WebElement HeaderEmail;
	@FindBy(xpath = "//div[@data-testid='status']//div//span[@class='css-1v99tuv'][normalize-space()='Select']")
	private WebElement SelectUserStatus;
	@FindBy(xpath = "//*[text()='Enabled']//preceding-sibling::input")
	private WebElement CheckBoxClickStatus;
	@FindBy(xpath = "//label[normalize-space()='Status']")
	private WebElement HeaderStatus;
	@FindBy(xpath = "//div[normalize-space()='Full Name']//span[@class='icon-up-arrow']")
	private WebElement FullNameASC;
	@FindBy(xpath = "//div[normalize-space()='Full Name']//span[@class='icon-down-arrow']")
	private WebElement FullNameDesc;
	@FindBy(xpath = "//div[normalize-space()='Username']//span[@class='icon-up-arrow']")
	private WebElement UserNameASC;
	@FindBy(xpath = "//div[normalize-space()='Username']//span[@class='icon-down-arrow']")
	private WebElement UserNameDesc;
	@FindBy(xpath = "//div[normalize-space()='Email']//span[@class='icon-up-arrow']")
	private WebElement EmailASC;
	@FindBy(xpath = "//div[normalize-space()='Email']//span[@class='icon-down-arrow']")
	private WebElement EmailDesc;
	@FindBy(css = "div[class='table-body no-scrollbar'] div:nth-child(1) div:nth-child(3) a:nth-child(1)")
	private WebElement Emaillink;

	/**
	 * Description - Verify that if ADMIN is able to Click on ADMIN user TAB. .
	 * 
	 * @return - True - if ADMIN is able to Click on ADMIN user TAB.
	 */
	public boolean AdminUserTab() {

		try {
			boolean logo = AcQyrLogo.isDisplayed();
			Utility.javaScriptClick(AdminUsersButton, driver);
			return logo;
		} catch (Exception e) {

			System.err.println("Exception in Method - AdminUserTab, Class - Admin_Users_Page : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify that user can Search the data according to Full name,
	 * username and email
	 * 
	 * 
	 * @return - True - if is search Bar is working by full Name .
	 */

	public boolean VerifyFullNameSearch() {
		try {

			WaitClass.waitForTime(2000);
			boolean flag = true;
			SearchBarField.clear();
			WaitClass.waitForTime(2000);
			int random = Utility.getRandomInt(0, SortingFullName.size() - 1);
			WebElement list = SortingFullName.get(random);
			String searchdetails = list.getText();
			SearchBarField.sendKeys(searchdetails);
			WaitClass.waitForTime(3000);
			for (WebElement data : SortingFullName) {
				String dataverify = data.getText();
				flag = flag && dataverify.equals(searchdetails);
				return flag;
			}

		}

		catch (Exception e) {

			System.err.println("Exception in Method - VerifyFullNameSearch, Class - Admin_Users_Page : " + e);

		}
		return false;
	}

	/**
	 * Description - Verify that user can Search the data according to Full name,
	 * username and email
	 * 
	 * 
	 * @return - True - if is search Bar is working by UserNAme .
	 */

	public boolean VerifyUserNameSearch() {
		try {

			WaitClass.waitForTime(2000);
			boolean flag = true;
			SearchBarField.clear();
			WaitClass.waitForTime(2000);
			int random = Utility.getRandomInt(0, SortingUserName.size() - 1);
			WebElement list = SortingUserName.get(random);
			String searchdetails = list.getText();
			SearchBarField.sendKeys(searchdetails);
			WaitClass.waitForTime(3000);
			for (WebElement data : SortingUserName) {
				String dataverify = data.getText();
				flag = flag && dataverify.equals(searchdetails);
				return flag;
			}

		}

		catch (Exception e) {

			System.err.println("Exception in Method - VerifyUserNameSearch, Class - Admin_Users_Page : " + e);

		}
		return false;
	}

	/**
	 * Description - Verify that user can Search the data according to Full name,
	 * username and email.
	 * 
	 * 
	 * @return - True - if is search Bar is working by Email .
	 */

	public boolean VerifyEmailSearch() {
		try {

			WaitClass.waitForTime(2000);
			boolean flag = true;
			SearchBarField.clear();
			WaitClass.waitForTime(2000);
			int random = Utility.getRandomInt(0, SortingEmail.size() - 1);
			WebElement list = SortingEmail.get(random);
			String searchdetails = list.getText();
			SearchBarField.sendKeys(searchdetails);
			WaitClass.waitForTime(3000);
			for (WebElement data : SortingEmail) {
				String dataverify = data.getText();
				flag = flag && dataverify.equals(searchdetails);
				return flag;
			}

		}

		catch (Exception e) {

			System.err.println("Exception in Method - VerifyEmailSearch, Class - Admin_Users_Page : " + e);

		}
		return false;
	}

	/**
	 * Description - Verify that Can be ADMIN/USER/ENABLE/DISABLE Toggle Button Are
	 * Working .
	 * 
	 * @return - True - if is ADMIN Should be Enable, Disable
	 */

	public boolean EnableDisable() {
		try {
			WaitClass.waitForTime(2000);
			WebElement actionbuttonclick = SortingActions.get(0);
			Actions act = new Actions(driver);
			act.moveToElement(actionbuttonclick).click().build().perform();
			boolean enabledtext = EnabledTextButton.isDisplayed();
			EnabledTextButton.click();
			boolean disablePopupTextmsg = DisablePopupText.isDisplayed();
			act.moveToElement(ConfirmButton).click().build().perform();
			EnabledTextButton.click();
			boolean EnablePopuptext = EnablePopupText.isDisplayed();
			act.moveToElement(ConfirmButton).click().build().perform();
			Utility.javaScriptClick(UpdateButton, driver);
			String alerttext = Utility.getalerttext(driver, AlertAfterUpdateButton);
			String alerttextex = "Admin user updated successfully.";
			Assert.assertEquals(alerttext, alerttextex);
			softassert.assertAll();
			System.out.println(alerttext);
			driver.navigate().refresh();
			WaitClass.waitForTime(5000);

			return enabledtext && disablePopupTextmsg && EnablePopuptext;
		}

		catch (Exception e) {

			System.err.println("Exception in Method - EnableDisable, Class - Admin_Users_Page : " + e);

		}
		return false;
	}

	/**
	 * Description : Verify and validate the Filters Are working on ADMIN USERS for
	 * Full Name ,Username , Email, Status.
	 * 
	 * 
	 * @return true: if the Filter are working properly
	 * 
	 */

	public boolean FilterAdmin() {
		try {

			// It is for Verify and Validate Filter for "Full Name"
			Actions action = new Actions(driver);
			SelectFullName.click();
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(CheckBoxClickfullname, driver);
			WaitClass.waitForTime(2000);

			action.moveToElement(HeaderFullNAme).click().perform();
			WaitClass.waitForTime(2000);
			String textfullNameActual = driver
					.findElement(By.cssSelector("div[data-testid='full-name'] div span[class='css-1v99tuv']"))
					.getText();
			String textfullNameExpected = SortingFullName.get(0).getText();
			if (textfullNameActual.equalsIgnoreCase(textfullNameExpected)) {
				System.out.println("Sucessfully Matched");
			}
			// It is for Verify and Validate Filter for "User Name"
			action.moveToElement(DropDownCross).click().perform();
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(SelectUserName, driver);
			WaitClass.waitForTime(1000);
			action.moveToElement(CheckBoxClickUserName).click().perform();
			WaitClass.waitForTime(2000);
			action.moveToElement(HeaderUserName).click().perform();
			WaitClass.waitForTime(2000);
			String textuserNameActual = driver
					.findElement(By.cssSelector("div[data-testid='username'] div span[class='css-1v99tuv']")).getText();
			String textuserNameExpected = SortingUserName.get(0).getText();
			if (textuserNameActual.equalsIgnoreCase(textuserNameExpected)) {
				System.out.println("Sucessfully Matched");
			}
			action.moveToElement(DropDownCross).click().perform();

			// It is for Verify and Validate Filter for "Email"

			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(SelectUserEmail, driver);
			WaitClass.waitForTime(1000);
			action.moveToElement(CheckBoxClickEmail).click().perform();
			WaitClass.waitForTime(2000);
			action.moveToElement(HeaderEmail).click().perform();
			WaitClass.waitForTime(2000);
			String textemailActual = driver
					.findElement(By.cssSelector("div[data-testid='useremail'] div span[class='css-1v99tuv']"))
					.getText();
			String textEmailExpected = SortingEmail.get(0).getText();
			if (textemailActual.equalsIgnoreCase(textEmailExpected)) {
				System.out.println("Sucessfully Matched");
			}
			action.moveToElement(DropDownCross).click().perform();
			// It is for Verify and Validate Filter for "Status"
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(SelectUserStatus, driver);
			WaitClass.waitForTime(1000);
			action.moveToElement(CheckBoxClickStatus).click().perform();
			WaitClass.waitForTime(2000);
			action.moveToElement(HeaderStatus).click().perform();
			WaitClass.waitForTime(2000);
			String textstatusActual = driver
					.findElement(By.cssSelector("div[data-testid='status'] div span[class='css-1v99tuv']")).getText();
			String textstatusExpected = SortingStatus.get(0).getText();
			if (textstatusActual.equalsIgnoreCase(textstatusExpected)) {
				System.out.println("Sucessfully Matched");
			}
			action.moveToElement(DropDownCross).click().perform();

			return true;

		} catch (Exception e) {
			System.err.println("Exception in Method - FilterAdmin, Class - Admin_Users_Page : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify And Validate Sorting for ADMIN / USER are Working.
	 * 
	 * @return - True - if Sorting are Working for FullName , UserName, Email on
	 *         ADMIN/USER
	 * 
	 */

	public boolean SortingAdminUserFullname(int FullName) {
		try {
			if (FullName == 1) {

				ArrayList<String> data1 = new ArrayList<String>();
				ArrayList<String> data2 = new ArrayList<String>();
				WaitClass.waitForTime(3000);
				FullNameASC.click();
				WaitClass.waitForTime(3000);
				for (int j = 0; j <= 4; j++) {
					String fullname = SortingFullName.get(j).getText();
					data1.add(fullname);
				}

				FullNameASC.click();
				FullNameDesc.click();
				FullNameASC.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= 4; j++) {
					String FullNameex = SortingFullName.get(j).getText();

					data2.add(FullNameex);
				}

				return data1.equals(data2);
			}
			if (FullName == 2) {
				ArrayList<String> list1 = new ArrayList<String>();
				ArrayList<String> list2 = new ArrayList<String>();
				WaitClass.waitForTime(3000);
				FullNameDesc.click();
				WaitClass.waitForTime(3000);
				for (int j = 0; j <= 4; j++) {
					String fullname = SortingFullName.get(j).getText();

					list1.add(fullname);
				}

				FullNameDesc.click();
				FullNameASC.click();
				FullNameDesc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= 4; j++) {
					String fullName = SortingFullName.get(j).getText();

					list2.add(fullName);
				}

				return list1.equals(list2);

			}
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Method - SortingAdminUser, Class - Admin_Users_Page : " + e);

		}
		return false;

	}

	/**
	 * Description - Verify And Validate Sorting for ADMIN / USER are Working.
	 * 
	 * @return - True - if Sorting are Working for FullName , UserName, Email on
	 *         ADMIN/USER
	 * 
	 */

	public boolean SortingAdminUserUserName(int UserName) {
		try {
			if (UserName == 1) {

				ArrayList<String> data1 = new ArrayList<String>();
				ArrayList<String> data2 = new ArrayList<String>();
				WaitClass.waitForTime(3000);
				UserNameASC.click();
				WaitClass.waitForTime(3000);
				for (int j = 0; j <= 4; j++) {
					String fullname = SortingUserName.get(j).getText();
					data1.add(fullname);
				}

				UserNameASC.click();
				UserNameDesc.click();
				UserNameASC.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= 4; j++) {
					String FullNameex = SortingUserName.get(j).getText();

					data2.add(FullNameex);
				}

				return data1.equals(data2);
			}
			if (UserName == 2) {
				ArrayList<String> list1 = new ArrayList<String>();
				ArrayList<String> list2 = new ArrayList<String>();
				WaitClass.waitForTime(3000);
				UserNameDesc.click();
				WaitClass.waitForTime(3000);
				for (int j = 0; j <= 4; j++) {
					String fullname = SortingUserName.get(j).getText();

					list1.add(fullname);
				}

				UserNameDesc.click();
				UserNameASC.click();
				UserNameDesc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= 4; j++) {
					String fullName = SortingUserName.get(j).getText();

					list2.add(fullName);
				}

				return list1.equals(list2);

			}
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Method - SortingAdminUserUserName, Class - Admin_Users_Page : " + e);

		}
		return false;

	}

	/**
	 * Description - Verify And Validate Sorting for ADMIN / USER are Working.
	 * 
	 * @return - True - if Sorting are Working for FullName , UserName, Email on
	 *         ADMIN/USER
	 * 
	 */

	public boolean SortingAdminUserEmail(int Email) {
		try {
			if (Email == 1) {

				ArrayList<String> data1 = new ArrayList<String>();
				ArrayList<String> data2 = new ArrayList<String>();
				WaitClass.waitForTime(3000);
				EmailASC.click();
				WaitClass.waitForTime(3000);
				for (int j = 0; j <= 4; j++) {
					String fullname = SortingEmail.get(j).getText();
					data1.add(fullname);
				}

				EmailASC.click();
				EmailDesc.click();
				EmailASC.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= 4; j++) {
					String FullNameex = SortingEmail.get(j).getText();

					data2.add(FullNameex);
				}

				return data1.equals(data2);
			}
			if (Email == 2) {
				ArrayList<String> list1 = new ArrayList<String>();
				ArrayList<String> list2 = new ArrayList<String>();
				WaitClass.waitForTime(3000);
				EmailDesc.click();
				WaitClass.waitForTime(3000);
				for (int j = 0; j <= 4; j++) {
					String fullname = SortingEmail.get(j).getText();

					list1.add(fullname);
				}

				EmailDesc.click();
				EmailASC.click();
				EmailDesc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= 4; j++) {
					String fullName = SortingEmail.get(j).getText();

					list2.add(fullName);
				}

				return list1.equals(list2);

			}
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Method - SortingAdminUserEmail, Class - Admin_Users_Page : " + e);

		}
		return false;

	}

	/**
	 * Description - Verify that ADMIN/USER Listing are correct as per the ADMIN
	 * Added .
	 * 
	 * @return - True - if ADMIN/USER List has been Added.
	 */
	public boolean AdminUserList() {
		boolean flag = false;

		try {
			for (WebElement fullname : SortingFullName) {
				boolean listfullname = fullname.isDisplayed();
				flag = listfullname;
			}
			for (WebElement Username : SortingUserName) {
				boolean Uname = Username.isDisplayed();
				flag = Uname;
			}
			for (WebElement Email : SortingEmail) {
				boolean Emailex = Email.isDisplayed();
				flag = Emailex;
			}
			for (WebElement status : SortingStatus) {
				boolean Status = status.isDisplayed();
				flag = Status;
			}
			if (Emaillink.isEnabled()) {
				Emaillink.click();
				flag = true;
			}
			return flag;
		} catch (Exception e) {

			System.err.println("Exception in Method - AdminUserList, Class - Admin_Users_Page : " + e);
			return false;
		}
	}

}
