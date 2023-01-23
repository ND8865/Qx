package PageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class AdminUsers_Admin {
	WebDriver driver;
	SoftAssert softassert;

	public AdminUsers_Admin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		softassert = new SoftAssert();
	}
	@FindBy(xpath = "//h4[text()='Admin Users']")
	private WebElement adminUserHeadertext;

	@FindBy(xpath = "//input[@data-testid='searchKey']")
	private WebElement searchBar;

	@FindBy(xpath = "//button[text()='Add New']")
	private WebElement addNewFilterButton;

	@FindBy(xpath = "//label[text()='Full Name']")
	private WebElement fullNameFilterLabel;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	private WebElement fullNameFilter;

	@FindBy(xpath = "//label[text()='Username']")
	private WebElement userNameFilterLabel;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement userNameFilter;

	@FindBy(xpath = "//label[text()='Email']")
	private WebElement emailFilterLabel;

	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement emailFilter;

	@FindBy(xpath = "//label[text()='Status']")
	private WebElement statusFilterLabel;

	@FindBy(xpath = "(//button[@type='button'])[5]")
	private WebElement statusFilter;

	@FindBy(xpath = "//div[text()='Full Name']")
	private WebElement fullNameColumnLabel;

	@FindBy(xpath = "(//span[@class='icon-up-arrow'])[1]")
	private WebElement fullNameSortAsc;

	@FindBy(xpath = "(//span[@class='icon-down-arrow'])[1]")
	private WebElement fullNameSortDesc;

	@FindBy(xpath = "//div[text()='Username']")
	private WebElement userNameColumnLabel;

	@FindBy(xpath = "(//span[@class='icon-up-arrow'])[2]")
	private WebElement userNameSortAsc;

	@FindBy(xpath = "(//span[@class='icon-down-arrow'])[2]")
	private WebElement userNameSortDesc;

	@FindBy(xpath = "//div[text()='Email']")
	private WebElement emailColumnLabel;

	@FindBy(xpath = "(//span[@class='icon-up-arrow'])[3]")
	private WebElement emailSortAsc;

	@FindBy(xpath = "(//span[@class='icon-down-arrow'])[3]")
	private WebElement emailSortDesc;

	@FindBy(xpath = "//div[text()='Status']")
	private WebElement statusColumnLabel;

	@FindBy(xpath = "//div[text()='Action']")
	private WebElement actionColumnLabel;

	@FindBy(xpath = "//div[@class='table-row']/div[1]")
	private List<WebElement> adminNameListing;
	
	@FindBy(xpath = "//div[@class='table-row']/div[2]")
	private List<WebElement> userNameListing;
	
	//Add Admin User page Locators

	@FindBy(xpath = "//input[@data-testid='fullName']")
	private WebElement fullNameTextField;
	
	@FindBy(xpath = "//input[@data-testid='username']")
	private WebElement userNameTextField;
	
	@FindBy(xpath = "//input[@data-testid='email']")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//button[text()='Invite']")
	private WebElement inviteButton;
	
	@FindBy(xpath = "//div[text()='Please enter full name.']")
	private WebElement fullNameBlankText;
	
	@FindBy(xpath = "//div[text()='Please enter username.']")
	private WebElement userNameBlankText;
	
	@FindBy(xpath = "//div[text()='Please enter email address.']")
	private WebElement emailBlankText;
	
	@FindBy(xpath = "//div[text()='Please enter valid email address.']")
	private WebElement emailInvalidText;
	
	//Permission Locators
	
	@FindBy(xpath = "//h4[text()='Permissions']")
	private WebElement permissionsheaderText;
	
	@FindBy(xpath = "//div[@class='btn-switch big-with-label']/label")
	private List<WebElement> permissionLabels;
	
	@FindBy(xpath = "//div[@class='btn-switch big-with-label']/div/input")
	private List<WebElement> permissionToggles;
	
	@FindBy(xpath = "//input[@data-testid='onboardUsers']")
	private WebElement manageAdminUserToggle;
	
	@FindBy(xpath = "//input[@data-testid='approveGames']")
	private WebElement approveGamesToggle;
	
	@FindBy(xpath = "//input[@data-testid='manageGamers']")
	private WebElement manageGamersToggle;
	
	@FindBy(xpath = "//input[@data-testid='manageEvents']")
	private WebElement manageEventsToggle;
	
	@FindBy(xpath = "//input[@data-testid='approveIssuers']")
	private WebElement managePartnerUsersToggle;
	
	@FindBy(xpath = "//input[@data-testid='approveOffers']")
	private WebElement approveOffersToggle;
	
	@FindBy(xpath = "//input[@data-testid='offerReward']")
	private WebElement adjustRewardpointsToggle;
	
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement updateButton;
	
	
	
	
	
	
	
	/**
	 * Description - Navigating to Admin users page after successful login.
	 * @return - true - if admin lands successfully on Admin users page.
	 */
	public boolean navigateToAdminUsers() {
		try {
			boolean flag = driver.findElement(By.xpath("//span[text()='Admin Users']")).isDisplayed();
			driver.findElement(By.xpath("//span[text()='Admin Users']")).click();
			flag = flag && adminUserHeadertext.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - AdminUsers_Admin, Method - navigateToAdminUsers : " + e);
			return false;
		}
	}

	/**
	 * Description - validating all contents are visible on the Admin Users page.
	 * @return - true - if all elements are visible.
	 */
	public boolean validateAllElementsAdminUsersPage() {
		try {
			boolean flag = searchBar.isDisplayed();
			flag = flag && addNewFilterButton.isDisplayed();
			flag = flag && fullNameFilterLabel.isDisplayed();
			flag = flag && fullNameFilter.isDisplayed();
			flag = flag && userNameFilterLabel.isDisplayed();
			flag = flag && userNameFilter.isDisplayed();
			flag = flag && emailFilterLabel.isDisplayed();
			flag = flag && emailFilter.isDisplayed();
			flag = flag && statusFilterLabel.isDisplayed();
			flag = flag && statusFilter.isDisplayed();
			flag = flag && fullNameColumnLabel.isDisplayed();
			flag = flag && fullNameSortAsc.isDisplayed();
			flag = flag && fullNameSortDesc.isDisplayed();
			flag = flag && userNameColumnLabel.isDisplayed();
			flag = flag && userNameSortAsc.isDisplayed();
			flag = flag && userNameSortDesc.isDisplayed();
			flag = flag && emailColumnLabel.isDisplayed();
			flag = flag && emailSortAsc.isDisplayed();
			flag = flag && emailSortDesc.isDisplayed();
			flag = flag && statusColumnLabel.isDisplayed();
			flag = flag && actionColumnLabel.isDisplayed();
			for (int i = 1; i < (adminNameListing.size()) - 1; i++) {
				String adminName = adminNameListing.get(i).getText();
				flag = flag && (!(adminName.isEmpty()));
			}
			return flag;
		} catch (Exception e) {
			System.err.println(
					"Exception in Class - AdminUsers_Admin, Method - validateAllElementsAdminUsersPage : " + e);
			return false;
		}
	}

	/**
	 * Description - validating Add New button action.
	 * @return - true - if admin lands successfully on Add Admin users page.
	 */
	public boolean validateAddNewButton() {
		try {
			addNewFilterButton.click();
			WaitClass.waitForTime(2000);
			boolean flag = (driver.findElement(By.xpath("//h4[text()='Add Admin User']"))).isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - AdminUsers_Admin, Method - validateAddNewButton : " + e);
			return false;
		}
	}
	
	/**
	 * Description - validating back button of Add Admin page.
	 * @return - true - if admin lands successfully on Admin users listing page.
	 */
	public boolean validateBackButton() {
		try {
			WaitClass.waitForTime(1000);
			driver.findElement(By.xpath("//button[text()='Back']")).click();
			WaitClass.waitForTime(1000);
			boolean flag = adminUserHeadertext.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - AdminUsers_Admin, Method - validateBackButton : " + e);
			return false;
		}
	}
	

	/**
	 * Description - validating cancel button of Add Admin page.
	 * @return - true - if admin lands successfully on Admin users listing page.
	 */
	public boolean validateCancelButton() {
		try {
			WaitClass.waitForTime(1000);
			driver.findElement(By.xpath("//button[text()='Cancel']")).click();
			WaitClass.waitForTime(1000);
			boolean flag = adminUserHeadertext.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - AdminUsers_Admin, Method - validateCancelButton : " + e);
			return false;
		}
	}
	
	/**
	 * Description - validating all validations of Add Admin form.
	 * @param blankFields - true - if validate blank field validation.
	 * @param invalidEmail - true - if validate invalid email validation.
	 * @param existingUser - true - if validate existing user validation.
	 * @return - true - if validation validated successfully.
	 */
	public boolean ValidateAddAdminUserForm(boolean blankFields, boolean invalidEmail, boolean existingUser) {

		try {
			String adminFullName = Utility.getPropertiesFile("primaryLogin", "Akash-Admin-User");
			String adminUserName = Utility.getPropertiesFile("primaryLogin", "superAdminName");
			String adminEmail = Utility.getPropertiesFile("primaryLogin", "superAdminEmail");
			if (blankFields == true) {
				fullNameTextField.clear();
				userNameTextField.clear();
				emailTextField.clear();
				inviteButton.click();
				WaitClass.waitForTime(3000);
				boolean flag = (fullNameBlankText.getText()).equals("Please enter full name.");
				flag = flag && (userNameBlankText.getText()).equals("Please enter username.");
				flag = flag && (emailBlankText.getText()).equals("Please enter email address.");
				return flag;
			}

			if (invalidEmail == true) {
				emailTextField.clear();
				emailTextField.sendKeys("anuj@yopmail");
				WaitClass.waitForTime(2000);
				boolean flag = (emailInvalidText.getText()).equals("Please enter valid email address.");
				return flag;
				
			}
			if (existingUser == true) {
				fullNameTextField.clear();
				fullNameTextField.sendKeys(adminFullName);
				userNameTextField.clear();
				userNameTextField.sendKeys(adminUserName);
				emailTextField.clear();
				emailTextField.sendKeys(adminEmail);
				inviteButton.click();
				WaitClass.waitForTime(1000);
				boolean flag = (driver.findElement(By.xpath("//div[@class='top-center']/div"))).isDisplayed();
				return flag;
			}
			return false;
		} catch (Exception e) {
			System.err.println("Exception in Method - AdminUsers_Admin, Class - ValidateAddAdminUserForm : " + e);
			return false;
		}
	}
	
	/**
	 * Description - Validating invite admin button.
	 * @param fullName - taking input full name as string.
	 * @param userName - taking input username as string.
	 * @param email - taking input email as string.
	 * @return - true, if validated successfully.
	 */
	public boolean ValidateInviteAdminFlow(String fullName, String userName, String email) {

		try {
			fullNameTextField.clear();
			fullNameTextField.sendKeys(fullName);
			userNameTextField.clear();
			userNameTextField.sendKeys(userName);
			emailTextField.clear();
			emailTextField.sendKeys(email);
			inviteButton.click();
			WaitClass.waitForTime(1000);
			boolean flag = adminUserHeadertext.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Method - AdminUsers_Admin, Class - ValidateAddAdminFlow : " + e);
			return false;
		}
	}
	
	/**
	 * Description - new Added admin validated in listing.
	 * @param userName - taking username as string.
	 * @return - true- if new added admin validated successfully.
	 */
	public boolean ValidatelatestAddedAdmin(String userName) {
		try {
			WaitClass.waitForTime(4000);
			searchBar.clear();
			searchBar.sendKeys(userName);
			WaitClass.waitForTime(5000);
		    String latestAddedUserName = driver.findElement(By.xpath("(//div[@class='table-row']/div[2])[2]")).getText();
		    boolean flag = (latestAddedUserName).equals(userName);
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Method - AdminUsers_Admin, Class - ValidatelatestAddedAdmin : " + e);
			return false;
		}
	}
	
	/**
	 * Description - validating edit admin button in listing.
	 * @param userName - taking username as string.
	 * @return - true- if edit admin button working correctly validated successfully.
	 */
	public boolean ValidateEditAdminButton(String userName) {
		try {
			WaitClass.waitForTime(1000);
			searchBar.clear();
			searchBar.sendKeys(userName);
			WaitClass.waitForTime(5000);
		    String latestAddedUserName = driver.findElement(By.xpath("(//div[@class='table-row']/div[2])[2]")).getText();
		    boolean flag = (latestAddedUserName).equals(userName);
		    driver.findElement(By.xpath("//span[@class='icon cursor-pointer']")).click();
		    flag = flag &&  driver.findElement(By.xpath("//h4[text()='Edit Admin User']")).isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Method - AdminUsers_Admin, Class - ValidateEditAdminButton : " + e);
			return false;
		}
	}
	
	/**
	 * Description - Validating pre-filled data on edit admin page.
	 * @param fullName - taking input full name as string.
	 * @param userName - taking input username as string.
	 * @param email - taking input email as string.
	 * @return - true, if validated successfully.
	 */
	public boolean ValidateprefilledDataAddAdmin(String fullName, String userName, String email) {

		try {
			WaitClass.waitForTime(2000);
			String fullNameShown = fullNameTextField.getAttribute("value");
			String userNameShown = userNameTextField.getAttribute("value");
			String emailShown = emailTextField.getAttribute("value");
			boolean flag = (fullNameShown).equals(fullName);
			flag = flag && (userNameShown).equals(userName);
			flag = flag && (emailShown).equals(email);
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Method - AdminUsers_Admin, Class - ValidateprefilledDataAddAdmin : " + e);
			return false;
		}
	}
	

	/**
	 * Description - validating all permissions are visible.
	 * @return - true - if all elements are visible.
	 */
	public boolean validateAllPermissionsContentVisibility() {
		try {
			boolean flag = permissionsheaderText.isDisplayed();
			
			for (int i = 0; i < (permissionLabels.size()) - 1; i++) {
				String permissionlabel = permissionLabels.get(i).getText();
				flag = flag && (!(permissionlabel.isEmpty()));
			}
			return flag;
		} catch (Exception e) {
			System.err.println(
					"Exception in Class - AdminUsers_Admin, Method - validateAllPermissionsContentVisibility : " + e);
			return false;
		}
	}
	
	/**
	 * Description - validating permission toggles and update button.
	 * @return - true - if admin detail updated successfully.
	 */
	public boolean validatePermissionUpdateFlow() {
		try {
			WaitClass.waitForTime(1000);
			manageAdminUserToggle.click();
			approveGamesToggle.click();
			manageGamersToggle.click();
			manageEventsToggle.click();
			managePartnerUsersToggle.click();
			approveOffersToggle.click();
			adjustRewardpointsToggle.click();
			WaitClass.waitForTime(1000);
			boolean flag = updateButton.isDisplayed();
			updateButton.click();
			WaitClass.waitForTime(1000);
			flag = flag && driver.findElement(By.xpath("//div[text()='Admin user updated successfully.']")).isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - AdminUsers_Admin, Method - validatePermissionUpdateFlow : " + e);
			return false;
		}
	}
	

	/**
	 * Description - validating approve game permission accessibility.
	 * @return - true - if approve and reject button enabled.
	 */
	public boolean validateIsGameApproveButtonEnable() {
		try {
			driver.findElement(By.xpath("//span[text()='Games']")).click();
			WaitClass.waitForTime(1000);
			driver.findElement(By.xpath("//div[@class='row']/div[4]/div/div/button")).click();
			driver.findElement(By.xpath("//div[@class='row']/div[4]/div/div/div/div/div/div/div[2]/div/input")).sendKeys("Submit");
			WaitClass.waitForTime(1000);
			driver.findElement(By.xpath("//div[@class='row']/div[4]/div/div/div/div/div[2]/div/div/input")).click();
			driver.findElement(By.xpath("//div[@id='root']")).click();
			WaitClass.waitForTime(1000);
			driver.findElement(By.xpath("(//span[@class='icon cursor-pointer'])[1]")).click();
			WaitClass.waitForTime(1000);
			boolean flag = driver.findElement(By.xpath("//button[text()='Approve']")).isEnabled();
			flag =flag && driver.findElement(By.xpath("//button[text()='Reject']")).isEnabled();
			return flag;
		} catch (Exception e) {
			System.err.println(
					"Exception in Class - AdminUsers_Admin, Method - validateIsGameApproveButtonEnable : " + e);
			return false;
		}
	}
	
	/**
	 * Description - validating approve offers permission accessibility.
	 * @return - true - if approve and reject button enabled.
	 */
	public boolean validateIsOfferApproveButtonEnable() {
		try {
			driver.findElement(By.xpath("//span[text()='Offers']")).click();
			WaitClass.waitForTime(1000);
			driver.findElement(By.xpath("//div[@class='row']/div[4]/div/div/button")).click();
			driver.findElement(By.xpath("//div[@class='row']/div[4]/div/div/div/div/div/div/div[2]/div/input")).sendKeys("In Review");
			WaitClass.waitForTime(1000);
			driver.findElement(By.xpath("//div[@class='row']/div[4]/div/div/div/div/div[2]/div/div/input")).click();
			driver.findElement(By.xpath("//div[@id='root']")).click();
			WaitClass.waitForTime(1000);
			driver.findElement(By.xpath("(//div[@class='custom-dropdown more-dropdown dropdown'])[1]")).click();
			driver.findElement(By.xpath("//a/span[text()='View']")).click();
			WaitClass.waitForTime(1000);
			boolean flag = driver.findElement(By.xpath("//button[text()='Approve']")).isEnabled();
			flag =flag && driver.findElement(By.xpath("//button[text()='Reject']")).isEnabled();
			return flag;
		} catch (Exception e) {
			System.err.println(
					"Exception in Class - AdminUsers_Admin, Method - validateIsOfferApproveButtonEnable : " + e);
			return false;
		}
	}
	
	/**
	 * Description - validating all given permissions are accessible by admin.
	 * @return - true - if all assigned permissions accessible.
	 */
	public boolean validateAssignedPermissionsTabs() {
		try {
			boolean flag = driver.findElement(By.xpath("//span[text()='Admin Users']")).isDisplayed();
			flag =flag && driver.findElement(By.xpath("//span[text()='Gamers']")).isDisplayed();
			flag =flag && driver.findElement(By.xpath("//span[text()='Events']")).isDisplayed();
			flag =flag && driver.findElement(By.xpath("//span[text()='Partners']")).isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println(
					"Exception in Class - AdminUsers_Admin, Method - validateAssignedPermissionsTabs : " + e);
			return false;
		}
	}
	
	/**
	 * Description - validating all text fields are disabled on edit admin page.
	 * @return - true - if all full name, user name and email are disabled..
	 */
	public boolean validateDisabilityOfTextFields() {
		try {
			boolean flag = fullNameTextField.isEnabled();
			flag =flag && userNameTextField.isEnabled();
			flag =flag && emailTextField.isEnabled();
			return (!(flag));
		} catch (Exception e) {
			System.err.println(
					"Exception in Class - AdminUsers_Admin, Method - validateDisabilityOfTextFields : " + e);
			return false;
		}
	}
	
	/**
	 * Description - validating permission toggles and update button.
	 * @return - true - if admin detail updated successfully.
	 */
	public boolean validateAdminEditUpdateFlow() {
		try {
			manageAdminUserToggle.click();
			WaitClass.waitForTime(1000);
			manageAdminUserToggle.click();
			boolean flag = updateButton.isDisplayed();
			updateButton.click();
			WaitClass.waitForTime(1000);
			flag = flag && driver.findElement(By.xpath("//div[text()='Admin user updated successfully.']")).isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - AdminUsers_Admin, Method - validateAdminEditUpdateFlow : " + e);
			return false;
		}
	}
	
	
	
	

}
