package PageObjectClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Admin_Partners_Page {
	WebDriver driver;
	SoftAssert softassert;

	public Admin_Partners_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		softassert = new SoftAssert();
	}

	@FindBy(xpath = "//img[@alt='logo']")
	private WebElement AcQyrLogo;
	@FindBy(xpath = "//span[contains(text(),'Partners')]")
	private WebElement PartnersButton;
	@FindBy(xpath = "//h3[@class='main-heading']")
	private WebElement UserName;
	@FindBy(xpath = "//h4[contains(text(),'Partners')]")
	private WebElement PartnerDeshboardtext;
	@FindBy(xpath = "//input[@data-testid = 'searchKey']")
	private WebElement SearchField;
	@FindBy(xpath = "//label[contains(text(),'Partner Name')]")
	private WebElement PartnerNameHeader;
	@FindBy(xpath = "//label[contains(text(),'Email')]")
	private WebElement EmailHeader;
	@FindBy(xpath = "//label[contains(text(),'Primary Contact')]")
	private WebElement PrimaryContactHeader;
	@FindBy(xpath = "//label[contains(text(),'Primary Phone')]")
	private WebElement PrimaryPhoneHeader;
	@FindBy(xpath = "//label[contains(text(),'Status')]")
	private WebElement StatusHeader;
	@FindBy(xpath = "//div[text()='Partner']")
	private WebElement PartnerSortHeader;
	@FindBy(xpath = "//div[text()='Email']")
	private WebElement EmailSortHeader;
	@FindBy(xpath = "//div[text()='Primary Contact']")
	private WebElement PrimaryContactSortHeader;
	@FindBy(xpath = "//div[text()='Primary Phone']")
	private WebElement PrimaryPhoneSortHeader;
	@FindBy(xpath = "//div[text()='Status']")
	private WebElement StatusSortHeader;
	@FindBy(xpath = "//div[text()='View']")
	private WebElement ViewSortHeader;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[1]")
	private List<WebElement> SortingPartner;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[2]")
	private List<WebElement> SortingEmail;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[3]")
	private List<WebElement> SortingPrimaryContact;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[4]")
	private List<WebElement> SortingPrimaryPhone;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[5]")
	private List<WebElement> SortingStatus;
	@FindBy(xpath = "//div[contains(@class,'table-body')]//div[@class='table-row']/div[6]")
	private List<WebElement> SortingView;
	@FindBy(xpath = "//label[text()='Partner Name']/following-sibling::div")
	private WebElement SelectPartnerName;
	@FindBy(xpath = "//label[text()='Email']/following-sibling::div")
	private WebElement SelectEmail;
	@FindBy(xpath = "//*[text()='akash']//preceding-sibling::input")
	private WebElement CheckBoxClickPartnerName;
	@FindBy(xpath = "//*[text()='akash.sarangi@kiwitech.com']//preceding-sibling::input")
	private WebElement CheckBoxClickEmail;
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M19 6.41L1')]")
	private WebElement DropDownCross;
	@FindBy(xpath = "//label[text()='Primary Contact']/following-sibling::div")
	private WebElement SelectPrimaryContact;
	@FindBy(xpath = "//label[text()='Primary Phone']/following-sibling::div")
	private WebElement SelectPrimaryPhone;
	@FindBy(xpath = "//label[text()='Status']/following-sibling::div")
	private WebElement SelectStatus;
	@FindBy(xpath = "//*[text()='Akash Sarangi']//preceding-sibling::input")
	private WebElement CheckBoxClickprimaryContact;
	@FindBy(xpath = "//*[text()='(079) 784-0230']//preceding-sibling::input")
	private WebElement CheckBoxClickprimaryPhone;
	@FindBy(xpath = "//*[text()='Pending']//preceding-sibling::input")
	private WebElement CheckBoxClickStatus;
	@FindBy(xpath = "//span[@data-testid='partner-name-sort-asc']")
	private WebElement PartnersASC;
	@FindBy(xpath = "//span[@data-testid='partner-name-sort-desc']")
	private WebElement PartnersDESC;
	@FindBy(xpath = "//span[@data-testid='partner-email-sort-asc']")
	private WebElement EmailASC;
	@FindBy(xpath = "//span[@data-testid='partner-email-sort-desc']")
	private WebElement EmailDESC;
	@FindBy(xpath = "//span[@data-testid='partner-primary-sort-asc']")
	private WebElement PrimaryContactASC;
	@FindBy(xpath = "//span[@data-testid='partner-primary-sort-desc']")
	private WebElement PrimaryContactDESC;
	@FindBy(xpath = "//span[@data-testid='partner-phone-sort-asc']")
	private WebElement PrimaryPhoneASC;
	@FindBy(xpath = "//span[@data-testid='partner-phone-sort-desc']")
	private WebElement PrimaryPhoneDESC;

	// All WebElements are from the Partners Details Page's Info Tab.
	@FindBy(xpath = "//div[@class='content-section']")
	private List<WebElement> ContentDetailspage;

	/**
	 * Description - Checking All Elements are Visible on ADMIN PARTNERS DeshBoard .
	 * 
	 * @return - True - If All Elements Are Visible on ADMIN PARTNERS DeshBoard.
	 */
	public boolean AllElementDisplayed() {

		try {

			boolean flag = AcQyrLogo.isDisplayed();
			flag = flag && PartnersButton.isDisplayed();
			flag = flag && UserName.isDisplayed();
			flag = flag && PartnerDeshboardtext.isDisplayed();
			flag = flag && SearchField.isDisplayed();
			flag = flag && PartnerNameHeader.isDisplayed();
			flag = flag && EmailHeader.isDisplayed();
			flag = flag && PrimaryContactHeader.isDisplayed();
			flag = flag && PrimaryPhoneHeader.isDisplayed();
			flag = flag && StatusHeader.isDisplayed();
			flag = flag && PartnerSortHeader.isDisplayed();
			flag = flag && EmailSortHeader.isDisplayed();
			flag = flag && PrimaryContactSortHeader.isDisplayed();
			flag = flag && PrimaryPhoneSortHeader.isDisplayed();
			flag = flag && StatusSortHeader.isDisplayed();
			flag = flag && ViewSortHeader.isDisplayed();
			return flag;
		} catch (Exception e) {

			System.err.println("Exception in Method - AllElementDisplayed, Class - Admin_Partners_Page.java : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify that Partners Button Are Working .
	 * 
	 * @return - True - If Partners Button Are Working .
	 */
	public boolean AdminPartnersButton() {

		try {
			PartnersButton.click();
			boolean partnertextdeshboard = PartnerDeshboardtext.isDisplayed();

			return partnertextdeshboard;
		} catch (Exception e) {

			System.err.println("Exception in Method - AdminPartnersButton, Class - Admin_Partners_Page.java : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify that user can Search the Games according to Partners
	 * Name and Email On ADMIN,
	 * 
	 * @return - True - if is search Bar is working by PartnersName .
	 */

	public boolean PartnersNameSearch() {
		try {

			WaitClass.waitForTime(2000);
			boolean flag = true;
			SearchField.clear();
			WaitClass.waitForTime(2000);
			int random = Utility.getRandomInt(0, SortingPartner.size() - 1);
			WebElement list = SortingPartner.get(random);
			String searchdetails = list.getText();
			SearchField.sendKeys(searchdetails);
			WaitClass.waitForTime(3000);
			for (WebElement data : SortingPartner) {
				String dataverify = data.getText();
				flag = flag && dataverify.equals(searchdetails);
				return flag;
			}

		}

		catch (Exception e) {

			System.err.println("Exception in Method - PartnersNameSearch, Class - Admin_Partners_Page : " + e);

		}
		return false;
	}

	/**
	 * Description - Verify that user can Search the Games according to Partners
	 * Name and Email On ADMIN,
	 * 
	 * @return - True - if is search Bar is working by Email .
	 */

	public boolean EmailSearch() {
		try {

			WaitClass.waitForTime(2000);
			boolean flag = true;
			SearchField.clear();
			WaitClass.waitForTime(2000);
			int random = Utility.getRandomInt(0, SortingEmail.size() - 1);
			WebElement list = SortingEmail.get(random);
			String searchdetails = list.getText();
			SearchField.sendKeys(searchdetails);
			WaitClass.waitForTime(3000);
			for (WebElement data : SortingEmail) {
				String dataverify = data.getText();
				flag = flag && dataverify.equals(searchdetails);
				return flag;
			}

		}

		catch (Exception e) {

			System.err.println("Exception in Method - EmailSearch, Class - Admin_Partners_Page : " + e);

		}
		return false;
	}

	/**
	 * Description - Verify if user can filter the data according to the Partner
	 * name, Email, Primary Contact, Primary Phone and status.
	 * 
	 * @return - True - If Filter Are Working Properly .
	 */

	public boolean AdminPartnersFilter() {
		try {
			// It is for Verify and Validate Filter for "Partner Name"
			boolean PartnerName = false;
			Actions action = new Actions(driver);
			SelectPartnerName.click();
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(CheckBoxClickPartnerName, driver);
			WaitClass.waitForTime(2000);
			action.moveToElement(PartnerNameHeader).click().perform();
			WaitClass.waitForTime(2000);
			String textfullNameActual = driver
					.findElement(By.xpath("//span[@class='css-1v99tuv'][normalize-space()='akash']")).getText();
			String textfullNameExpected = SortingPartner.get(0).getText();
			if (textfullNameActual.equalsIgnoreCase(textfullNameExpected)) {
				PartnerName = true;
			}
			// It is for Verify and Validate Filter for "Email"
			action.moveToElement(DropDownCross).click().perform();
			boolean email = false;
			SelectEmail.click();
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(CheckBoxClickEmail, driver);
			WaitClass.waitForTime(2000);
			action.moveToElement(EmailHeader).click().perform();
			WaitClass.waitForTime(2000);
			String textEmailActual = driver
					.findElement(
							By.xpath("//span[@class='css-1v99tuv'][normalize-space()='akash.sarangi@kiwitech.com']"))
					.getText();
			String textEmailExpected = SortingEmail.get(0).getText();
			if (textEmailActual.equalsIgnoreCase(textEmailExpected)) {
				email = true;
			}
			action.moveToElement(DropDownCross).click().perform();
			// It is for Verify and Validate Filter for "Primary Contact."
			boolean primaryContact = false;
			SelectPrimaryContact.click();
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(CheckBoxClickprimaryContact, driver);
			WaitClass.waitForTime(2000);
			action.moveToElement(PrimaryContactHeader).click().perform();
			WaitClass.waitForTime(2000);
			String textPrimaryContactEx = driver.findElement(By.xpath("//span[normalize-space()='Akash Sarangi']"))
					.getText();
			String textPrimaryContactactual = SortingPrimaryContact.get(1).getText();
			if (textPrimaryContactEx.equalsIgnoreCase(textPrimaryContactactual)) {
				primaryContact = true;
			}
			action.moveToElement(DropDownCross).click().perform();
			// It is for Verify and Validate Filter for "Primary Phone."
			boolean primaryPhone = false;
			SelectPrimaryPhone.click();
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(CheckBoxClickprimaryPhone, driver);
			WaitClass.waitForTime(2000);
			action.moveToElement(PrimaryPhoneHeader).click().perform();
			WaitClass.waitForTime(2000);
			String textPrimaryPhoneEx = driver.findElement(By.xpath("//span[normalize-space()='(079) 784-0230']"))
					.getText();
			String textPrimaryPhoneactual = SortingPrimaryPhone.get(0).getText();
			if (textPrimaryPhoneEx.equalsIgnoreCase(textPrimaryPhoneactual)) {
				primaryPhone = true;
			}
			action.moveToElement(DropDownCross).click().perform();
			// It is for Verify and Validate Filter for "Status."
			boolean Status = false;
			SelectStatus.click();
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(CheckBoxClickStatus, driver);
			WaitClass.waitForTime(2000);
			action.moveToElement(PrimaryPhoneHeader).click().perform();
			WaitClass.waitForTime(2000);
			String textStausEx = driver.findElement(By.xpath("//span[normalize-space()='Pending']")).getText();
			String textStatusActual = SortingStatus.get(0).getText();
			if (textStausEx.equalsIgnoreCase(textStatusActual)) {
				Status = true;
			}
			action.moveToElement(DropDownCross).click().perform();
			return PartnerName && email && primaryContact && primaryPhone && primaryPhone && Status;
		}

		catch (Exception e) {

			System.err.println("Exception in Method - AdminPartnersFilter, Class - Admin_Partners_Page : " + e);

		}
		return false;
	}

	/**
	 * Description - Verify that ADMIN/PARTNERS Listing are correct as per the ADMIN
	 * Added .
	 * 
	 * @return - True - if ADMIN/PARTNERS List has been Added.
	 */
	public boolean AdminPartnersList() {
		boolean flag = false;

		try {
			for (WebElement partner : SortingPartner) {
				if (partner.isDisplayed()) {
					flag = true;
				} else {
					flag = false;
				}
			}
			for (WebElement email : SortingEmail) {
				if (email.isDisplayed()) {
					flag = true;
				} else {
					flag = false;
				}
			}
			for (WebElement primarycontact : SortingPrimaryContact) {
				if (primarycontact.isDisplayed()) {
					flag = true;
				} else {
					flag = false;
				}
			}
			for (WebElement primaryPhone : SortingPrimaryPhone) {
				if (primaryPhone.isDisplayed()) {
					flag = true;
				} else {
					flag = false;
				}
			}
			for (WebElement staus : SortingStatus) {
				if (staus.isDisplayed()) {
					flag = true;
				} else {
					flag = false;
				}
			}
			return flag;

		}

		catch (Exception e) {

			System.err.println("Exception in Method - AdminPartnersList, Class - Admin_Partners_Page : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify And Validate Sorting for ADMIN/PARTNERS are Working.
	 * 
	 * @return - True - if Sorting are Working for Partners , Email ,
	 *         PrimaryContact,PrimaryPhone on ADMIN/USER
	 * 
	 */

	public boolean SortingAdminPartner(int partner) {
		try {
			if (partner == 1) {

				ArrayList<String> data1 = new ArrayList<String>();
				ArrayList<String> data2 = new ArrayList<String>();
				WaitClass.waitForTime(3000);
				PartnersASC.click();
				WaitClass.waitForTime(3000);
				for (int i = 0; i <= 4; i++) {
					String partnername = SortingPartner.get(i).getText();
					data1.add(partnername);
				}
				PartnersASC.click();
				PartnersDESC.click();
				PartnersASC.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= 4; j++) {
					String partnernameac = SortingPartner.get(j).getText();
					data2.add(partnernameac);
				}

				softassert.assertEquals(data1, data2);
				softassert.assertAll();
				return true;
			}
			if (partner == 2) {
				ArrayList<String> list1 = new ArrayList<String>();
				ArrayList<String> list2 = new ArrayList<String>();
				WaitClass.waitForTime(3000);
				PartnersDESC.click();
				WaitClass.waitForTime(3000);
				for (int i = 0; i <= 4; i++) {
					String partnameex = SortingPartner.get(i).getText();

					list1.add(partnameex);
				}

				PartnersDESC.click();
				PartnersASC.click();
				PartnersDESC.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= 4; j++) {
					String partnernameac = SortingPartner.get(j).getText();

					list2.add(partnernameac);
				}

				softassert.assertEquals(list1, list2);
				softassert.assertAll();
				return true;

			}
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Method - SortingAdminPartner, Class - Admin_Partners_Page : " + e);

		}
		return false;
	}

	/**
	 * Description - Verify And Validate Sorting for ADMIN/PARTNERS are Working.
	 * 
	 * @return - True - if Sorting are Working for Partners , Email ,
	 *         PrimaryContact,PrimaryPhone on ADMIN/USER
	 * 
	 */

	public boolean SortingEmail(int email) {
		try {
			if (email == 1) {

				ArrayList<String> data1 = new ArrayList<String>();
				ArrayList<String> data2 = new ArrayList<String>();
				WaitClass.waitForTime(3000);
				EmailASC.click();
				WaitClass.waitForTime(3000);
				for (int i = 0; i <= 4; i++) {
					String partnername = SortingEmail.get(i).getText();
					data1.add(partnername);
				}
				EmailASC.click();
				EmailDESC.click();
				EmailASC.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= 4; j++) {
					String partnernameac = SortingEmail.get(j).getText();
					data2.add(partnernameac);
				}

				softassert.assertEquals(data1, data2);
				softassert.assertAll();
				return true;
			}
			if (email == 2) {
				ArrayList<String> list1 = new ArrayList<String>();
				ArrayList<String> list2 = new ArrayList<String>();
				WaitClass.waitForTime(3000);
				EmailDESC.click();
				WaitClass.waitForTime(3000);
				for (int i = 0; i <= 4; i++) {
					String partnameex = SortingPartner.get(i).getText();

					list1.add(partnameex);
				}

				EmailDESC.click();
				EmailASC.click();
				EmailDESC.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= 4; j++) {
					String partnernameac = SortingPartner.get(j).getText();
					list2.add(partnernameac);
				}

				softassert.assertEquals(list1, list2);
				softassert.assertAll();
				return true;

			}
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Method - SortingEmail, Class - Admin_Partners_Page : " + e);

		}
		return false;
	}

	/**
	 * Description - Verify And Validate Sorting for ADMIN/PARTNERS are Working.
	 * 
	 * @return - True - if Sorting are Working for Partners , Email ,
	 *         PrimaryContact,PrimaryPhone on ADMIN/USER
	 * 
	 */

	public boolean SortingPrimaryContact(int primaryContact) {
		try {
			if (primaryContact == 1) {

				ArrayList<String> data1 = new ArrayList<String>();
				ArrayList<String> data2 = new ArrayList<String>();
				WaitClass.waitForTime(3000);
				PrimaryContactASC.click();
				WaitClass.waitForTime(3000);
				for (int i = 0; i <= 4; i++) {
					String partnername = SortingPrimaryContact.get(i).getText();
					data1.add(partnername);
				}
				PrimaryContactASC.click();
				PrimaryContactDESC.click();
				PrimaryContactASC.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= 4; j++) {
					String partnernameac = SortingPrimaryContact.get(j).getText();
					data2.add(partnernameac);
				}

				softassert.assertEquals(data1, data2);
				softassert.assertAll();
				return true;
			}
			if (primaryContact == 2) {
				ArrayList<String> list1 = new ArrayList<String>();
				ArrayList<String> list2 = new ArrayList<String>();
				WaitClass.waitForTime(3000);
				PrimaryContactDESC.click();
				WaitClass.waitForTime(3000);
				for (int i = 0; i <= 4; i++) {
					String partnameex = SortingPrimaryContact.get(i).getText();

					list1.add(partnameex);
				}

				PrimaryContactDESC.click();
				PrimaryContactASC.click();
				PrimaryContactDESC.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= 4; j++) {
					String partnernameac = SortingPrimaryContact.get(j).getText();
					list2.add(partnernameac);
				}

				softassert.assertEquals(list1, list2);
				softassert.assertAll();
				return true;

			}
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Method - SortingPrimaryContact, Class - Admin_Partners_Page : " + e);

		}
		return false;
	}

	/**
	 * Description - Verify And Validate Sorting for ADMIN/PARTNERS are Working.
	 * 
	 * @return - True - if Sorting are Working for Partners , Email ,
	 *         PrimaryContact,PrimaryPhone on ADMIN/USER
	 * 
	 */

	public boolean SortingPrimaryPhone(int primaryphone) {
		try {
			if (primaryphone == 1) {

				ArrayList<String> data1 = new ArrayList<String>();
				ArrayList<String> data2 = new ArrayList<String>();
				WaitClass.waitForTime(3000);
				PrimaryPhoneASC.click();
				WaitClass.waitForTime(3000);
				for (int i = 0; i <= 4; i++) {
					String partnername = SortingPrimaryPhone.get(i).getText();
					data1.add(partnername);
				}
				PrimaryPhoneASC.click();
				PrimaryPhoneDESC.click();
				PrimaryPhoneASC.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= 4; j++) {
					String partnernameac = SortingPrimaryPhone.get(j).getText();
					data2.add(partnernameac);
				}

				softassert.assertEquals(data1, data2);
				softassert.assertAll();
				return true;
			}
			if (primaryphone == 2) {
				ArrayList<String> list1 = new ArrayList<String>();
				ArrayList<String> list2 = new ArrayList<String>();
				WaitClass.waitForTime(3000);
				PrimaryPhoneDESC.click();
				WaitClass.waitForTime(3000);
				for (int i = 0; i <= 4; i++) {
					String partnameex = SortingPrimaryPhone.get(i).getText();

					list1.add(partnameex);
				}

				PrimaryPhoneDESC.click();
				PrimaryPhoneASC.click();
				PrimaryPhoneDESC.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= 4; j++) {
					String partnernameac = SortingPrimaryPhone.get(j).getText();
					list2.add(partnernameac);
				}

				softassert.assertEquals(list1, list2);
				softassert.assertAll();
				return true;

			}
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Method - SortingPrimaryPhone, Class - Admin_Partners_Page : " + e);

		}
		return false;
	}

	/**
	 * Description - Verify if ADMIN is redirected to Partner's detail page on
	 * clicking on view button.
	 * 
	 * @return - True - if Land on Partner's details page .
	 */

	public boolean ViewButton() {
		try {
			SearchField.sendKeys("Test_Partner");
			WaitClass.waitForTime(3000);
			SortingView.get(0).click();
			return true;
		}

		catch (Exception e) {

			System.err.println("Exception in Method - ViewButton, Class - Admin_Partners_Page : " + e);

		}
		return false;
	}

	/**
	 * Description - Verify that Partners's details are Present after click on the
	 * view button.
	 *
	 * 
	 * @return - True - if details are present General Information, contact
	 *         Information , Other Information .
	 */

	public boolean AdminPartnerInfo() {
		boolean flag = false;

		try {
			for (int i = 0; i <= ContentDetailspage.size() - 1; i++) 
			{
				String textcontent = ContentDetailspage.get(i).getText();
				if (driver.getPageSource().contains(textcontent)) {
					flag = true;
				}

			}
			return flag;
		}

		catch (Exception e) {

			System.err.println("Exception in Method - AdminPartnerInfo, Class - Admin_Partners_Page : " + e);

		}
		return false;
	}

}
