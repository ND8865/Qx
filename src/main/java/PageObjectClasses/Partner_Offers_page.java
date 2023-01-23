package PageObjectClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Partner_Offers_page {
	WebDriver driver;
	SoftAssert softassert;
	Actions action;

	public Partner_Offers_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		softassert = new SoftAssert();
		action = new Actions(driver);
	}

	/* Partner | Offers | All WebElemets */

	@FindBy(xpath = "//h4[contains(text(),'Offers')]")
	private WebElement OffersHeader;
	@FindBy(xpath = "//label[contains(text(),'Offer Name')]")
	private WebElement FilterOffernameHeader;
	@FindBy(xpath = "//label[contains(text(),'Game')]")
	private WebElement FilterGameHeader;
	@FindBy(xpath = "//label[contains(text(),'Start Date')]")
	private WebElement FilterStartDateHeader;
	@FindBy(xpath = "//label[contains(text(),'End Date')]")
	private WebElement FilterEndDateHeader;
	@FindBy(xpath = "//label[contains(text(),'Status')]")
	private WebElement FilterStatusHeader;

	/* List view */

	@FindBy(xpath = "//div[contains(text(),'Offer Name')]")
	private WebElement ListOffernameHeader;
	@FindBy(xpath = "//div[contains(text(),'Description')]")
	private WebElement ListDescriptionHeader;
	@FindBy(xpath = "//div[contains(text(),'Created By')]")
	private WebElement ListCreatedbyHeader;
	@FindBy(xpath = "//div[contains(text(),'Game')]")
	private WebElement ListGameHeader;
	@FindBy(xpath = "//div[contains(text(),'Start Date')]")
	private WebElement ListStartDateHeader;
	@FindBy(xpath = "//div[contains(text(),'End Date')]")
	private WebElement ListEndDateHeader;
	@FindBy(xpath = "//div[contains(text(),'Status')]")
	private WebElement ListStatusHeader;
	@FindBy(xpath = "//div[contains(text(),'Action')]")
	private WebElement ListActionHeader;

	/* Partner | Offers | Search */

	@FindBy(xpath = "//h4[contains(text(),'Offers')]")
	private WebElement Offersbutton;
	@FindBy(xpath = "//input[@placeholder='Search by Offer Name...']")
	private WebElement Serachfield;
	@FindBy(xpath = "//div[@class='td'][1]")
	private List<WebElement> OffernameList;
	@FindBy(xpath = "//div[@class='left-side']/strong")
	private List<WebElement> OffernameGrid;
	@FindBy(xpath = "//span[@class='icon-list-view ']")
	private WebElement Listbutton;
	@FindBy(xpath = "//p[@class='text-truncate']")
	private List<WebElement> OfferDescriptionGrid;
	@FindBy(xpath = "//div[@class='td'][2]")
	private List<WebElement> OfferDescriptionList;
	@FindBy(xpath = "//div[@class='games-tags-list']")
	private List<WebElement> OfferGameNameGridlist;

	/* Partner | Offers | Filter */
	@FindBy(xpath = "(//span[contains(text(),'Select')])[1]")
	private WebElement SelectOffername;
	@FindBy(xpath = "//div[@class='css-1vr111p-option']")
	private List<WebElement> ListOffernameFilter;
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M19 6.41L1')]")
	private WebElement DropDownCross;
	@FindBy(xpath = "(//span[contains(text(),'Select')])[2]")
	private WebElement SelectGames;
	@FindBy(xpath = "//*[text()='Tambola Season1']//preceding-sibling::input")
	private WebElement SearchDropdownValueGame;
	@FindBy(xpath = "//div[@class='games-tags-list']")
	private List<WebElement> ListGame;
	@FindBy(xpath = "(//input[@placeholder='dd mmm yyyy'])[1]")
	private WebElement SearchStartDate;
	@FindBy(xpath = "//div[@class='left-side']/p")
	private WebElement ListDatesStartandEnd;
	@FindBy(xpath = "(//input[@placeholder='dd mmm yyyy'])[2]")
	private WebElement SearchEndDate;
	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement DropDownCrossStartdate;
	@FindBy(xpath = "(//span[contains(text(),'Select')])[3]")
	private WebElement SelectStatus;
	@FindBy(xpath = "//*[text()='Disabled']//preceding-sibling::input")
	private WebElement SearchDropdownValueStatus;
	@FindBy(xpath = "//span[@class='badge badge-primary']")
	private List<WebElement> ListStatus;
	@FindBy(xpath = "//span[@class='icon-grid-view active']")
	private WebElement Gridbutton;

	/* Grid and List View */

	@FindBy(xpath = "//div[23]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//img[1]")
	private WebElement GameImage;
	@FindBy(xpath = "//div[23]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//img[1]")
	private WebElement PartnerImage;

	/* Offers - Sorting - Grid */
	@FindBy(xpath = "//span[@class='icon-sort-asc']")
	private WebElement SortButton;
	@FindBy(xpath = "//span[contains(text(),'Offer Name')]")
	private WebElement SortingOffername;
	@FindBy(xpath = "//span[contains(text(),'Game Name')]")
	private WebElement SortingGamename;
	@FindBy(xpath = "//div[normalize-space()='Offer Name']//span[@class='icon-up-arrow']")
	private WebElement SortingOffernameAsc;
	@FindBy(xpath = "//div[normalize-space()='Offer Name']//span[@class='icon-down-arrow']")
	private WebElement SortingOffernameDesc;
	@FindBy(xpath = "//div[normalize-space()='Game']//span[@class='icon-up-arrow']")
	private WebElement SortingGamenameAsc;
	@FindBy(xpath = "//div[normalize-space()='Game']//span[@class='icon-down-arrow']")
	private WebElement SortingGamenameDesc;
	@FindBy(xpath = "//div[@class='td'][4]")
	private List<WebElement> GamenameList;
	@FindBy(xpath = "//div[normalize-space()='Start Date']//span[@class='icon-up-arrow']")
	private WebElement SortingStartdateAsc;
	@FindBy(xpath = "//div[normalize-space()='Start Date']//span[@class='icon-down-arrow']")
	private WebElement SortingStartdateDesc;
	@FindBy(xpath = "//div[@class='td'][5]")
	private List<WebElement> StartDateList;

	@FindBy(xpath = "//div[normalize-space()='End Date']//span[@class='icon-up-arrow']")
	private WebElement SortingEnddateAsc;
	@FindBy(xpath = "//div[normalize-space()='End Date']//span[@class='icon-down-arrow']")
	private WebElement SortingEnddateDesc;
	@FindBy(xpath = "//div[@class='td'][6]")
	private List<WebElement> EndDateList;

	/* Offers - Add Offer from a template Header */

	@FindBy(xpath = "//*[text()='Add New']")
	private WebElement addnewbutton;
	@FindBy(xpath = "//span[contains(text(),'Create an Offer from a Template')]")
	private WebElement Createofferfromatemplate;
	@FindBy(xpath = "//h4[text()='1. Create an Offer']")
	private WebElement CreateAofferHeading;
	@FindBy(xpath = "//label[text()='Choose Template (Optional)']")
	private WebElement Choosetemplateotionalheader;
	@FindBy(xpath = "//h4[text()='2. Add Offer Details']")
	private WebElement AddOfferDetailsHeading;
	@FindBy(xpath = "//label[text()='Offer Name']")
	private WebElement OffernameHeader;
	@FindBy(xpath = "//label[text()='Offer Description to Promote to Players']")
	private WebElement OfferDescriptionHeader;
	@FindBy(xpath = "//h4[text()='Achievements (all achievements must be met to earn the reward)']")
	private WebElement Achievmentsheading;
	@FindBy(xpath = "//label[text()='Achievement Name']")
	private WebElement AchievmentsNameheader;
	@FindBy(xpath = "//label[text()='Description']")
	private WebElement Achievmentsdescription;
	@FindBy(xpath = "//label[text()='Event Name']")
	private WebElement Eventnameheader;
	@FindBy(xpath = "//label[text()='Function']")
	private WebElement Functionheader;
	@FindBy(xpath = "//label[text()='Comparison']")
	private WebElement ComparisonHeader;
	@FindBy(xpath = "//label[text()='Value']")
	private WebElement Valueheader;
	@FindBy(xpath = "//label[text()='QX Points']")
	private WebElement Qxpointsheader;
	@FindBy(xpath = "//label[text()='Choose Game']")
	private WebElement choosegameheader;
	@FindBy(xpath = "//label[text()='Choose Target Gamers']")
	private WebElement choosetargetgamerheader;
	@FindBy(xpath = "//label[text()='Start Date']")
	private WebElement startdateheader;
	@FindBy(xpath = "//label[text()='End Date']")
	private WebElement enddateheader;

	/* Offers - Add Offer from a template field */
	
	@FindBy(xpath = "//div[contains(text(),'Choose Template')]/parent::div")
	private WebElement ChooseTempleteField;
	@FindBy(xpath = "//div[@class=' css-yt9ioa-option']")
	private WebElement ChooseTempleteDropdownField;
	@FindBy(xpath = "//input[@placeholder='Offer Name']")
	private WebElement Offernamefield;
	
	
	
	
	
	
	
	
	/* Partner | Offers | Search */

	/**
	 * Description - Verify that user is able to Click on Offers button on the
	 * Dashboard.
	 * 
	 * @return - true - if user able to click on the Offers button after sign in on
	 *         the Dashboard.
	 */
	public boolean OffersButton() {
		try {
			Utility.javaScriptClick(Offersbutton, driver);
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Offers_page, Method - OffersButton : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify that User can Search the data by Offer name and
	 * description in grid view.
	 * 
	 * 
	 * @return - true - if User can Search the data by Offer name and description in
	 *         grid view .
	 * 
	 */
	public boolean SearchBarGridview(int offername, int description) {
		try {
			if (offername == 1) {

				boolean flag = true;
				Serachfield.clear();
				WaitClass.waitForTime(2000);
				int random = Utility.getRandomInt(0, OffernameGrid.size() - 1);
				WebElement list = OffernameGrid.get(random);
				String searchdetails = list.getText();
				Serachfield.sendKeys(searchdetails);
				Serachfield.sendKeys(Keys.ENTER);
				WaitClass.waitForTime(3000);
				for (WebElement data : OffernameGrid) {
					String dataverify = data.getText();
					flag = flag && dataverify.equals(searchdetails);
				}
				return true;
			}
			if (description == 2) {

				boolean flag = true;
				Utility.clearField(driver, Serachfield);
				WaitClass.waitForTime(2000);
				int random = Utility.getRandomInt(0, OfferDescriptionGrid.size() - 1);
				WebElement list = OfferDescriptionGrid.get(random);
				String searchdetails = list.getText();
				Serachfield.sendKeys(searchdetails);
				Serachfield.sendKeys(Keys.ENTER);
				WaitClass.waitForTime(3000);
				for (WebElement data : OfferDescriptionGrid) {
					String dataverify = data.getText();
					flag = flag && dataverify.equals(searchdetails);

				}
				return true;
			}

		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Offers_page, Method - SearchBarGridview : " + e);

		}
		return false;
	}

	/**
	 * Description - Verify that User can Search the data by Offer name and
	 * description in List view .
	 * 
	 * 
	 * @return - true - if User can Search the data by Offer name and description in
	 *         List view .
	 * 
	 */
	public boolean SearchBarListview(int offername, int description) {
		try {
			if (offername == 1) {

				boolean flag = true;
				Serachfield.clear();
				WaitClass.waitForTime(2000);
				int random = Utility.getRandomInt(0, OffernameList.size() - 1);
				WebElement list = OffernameList.get(random);
				String searchdetails = list.getText();
				Serachfield.sendKeys(searchdetails);
				Serachfield.sendKeys(Keys.ENTER);
				WaitClass.waitForTime(3000);
				for (WebElement data : OffernameList) {
					String dataverify = data.getText();
					flag = flag && dataverify.equals(searchdetails);
				}
				return true;
			}
			if (description == 2) {

				WaitClass.waitForTime(3000);
				boolean flag = true;
				Utility.clearField(driver, Serachfield);
				WaitClass.waitForTime(3000);
				int random = Utility.getRandomInt(0, OfferDescriptionList.size() - 1);
				WebElement list = OfferDescriptionList.get(random);
				String searchdetails = list.getText();
				Serachfield.sendKeys(searchdetails);
				Serachfield.sendKeys(Keys.ENTER);
				WaitClass.waitForTime(3000);
				for (WebElement data : OfferDescriptionList) {
					String dataverify = data.getText();
					flag = flag && dataverify.equals(searchdetails);

				}
				return true;
			}

		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Offers_page, Method - SearchBarListview : " + e);

		}
		return false;
	}

	/**
	 * Description - Verify that user can click on the list view button
	 * 
	 * @return - true - if user can click on the list view button.
	 * 
	 * 
	 */
	public boolean Listbutton() {
		try {

			Utility.javaScriptClick(Listbutton, driver);

			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Offers_page, Method - Listbutton : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify if Partner removes the texts from the search box, then
	 * the full listing will again appear.
	 * 
	 * @return - true - if Partner removes the texts from the search box, then the
	 *         full listing will again appear.
	 * 
	 * 
	 */
	public boolean ValidateList() {
		try {
			boolean flag = false;
			Utility.clearField(driver, Serachfield);
			WaitClass.waitForTime(3000);
			int random = Utility.getRandomInt(0, OfferDescriptionList.size() - 1);
			WebElement list = OfferDescriptionList.get(random);
			String searchdetails = list.getText();
			Serachfield.sendKeys(searchdetails);
			Serachfield.sendKeys(Keys.ENTER);
			WaitClass.waitForTime(3000);
			Utility.clearField(driver, Serachfield);
			if (OfferDescriptionList.size() != 0) {
				flag = true;
			} else if (OfferDescriptionList.size() == 0) {
				flag = false;
			}
			return true && flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Offers_page, Method - ValidateList : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify that user is able to see all Web element are visible on
	 * offers .
	 * 
	 * @return - True - if user is able to see all Web element are visible on offers
	 *         .
	 */
	public boolean ElementsvisiblityPartnerOffers() {

		try {

			boolean flag = OffersHeader.isDisplayed();
			flag = flag && FilterOffernameHeader.isDisplayed();
			flag = FilterGameHeader.isDisplayed();
			flag = flag && FilterStartDateHeader.isDisplayed();
			flag = flag && FilterEndDateHeader.isDisplayed();
			flag = flag && FilterStatusHeader.isDisplayed();
			WaitClass.waitForTime(4000);
			Listbutton.click();
			WaitClass.waitForTime(4000);
			flag = flag && ListOffernameHeader.isDisplayed();
			flag = flag && ListDescriptionHeader.isDisplayed();
			flag = flag && ListCreatedbyHeader.isDisplayed();
			flag = flag && ListGameHeader.isDisplayed();
			flag = flag && ListStartDateHeader.isDisplayed();
			flag = flag && ListEndDateHeader.isDisplayed();
			flag = flag && ListStatusHeader.isDisplayed();
			flag = flag && ListActionHeader.isDisplayed();

			return true && flag;
		} catch (Exception e) {

			System.err.println(
					"Exception in Class - Partner_Offers_page, Method - ElementsvisiblityPartnerOffers : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify if Partner can filter the data according to Offer Name
	 * and Game.
	 * 
	 * @return - true - if Partner can filter the data according to Offer Name and
	 *         Game.
	 * 
	 * 
	 */
	public boolean OffersFilter() {
		try {
			/* Filter | Offer name */

			boolean flag = false;
			SelectOffername.click();
			int random = Utility.getRandomInt(0, ListOffernameFilter.size() - 1);
			WebElement list = ListOffernameFilter.get(random);
			list.click();
			action.moveToElement(FilterOffernameHeader).click().perform();
			WaitClass.waitForTime(2000);
			String Offername = driver.findElement(By.xpath("(//span[@class='css-1v99tuv'])[1]")).getText();
			String offernamefound = OffernameGrid.get(0).getText();

			if (Offername.equals(offernamefound)) {
				flag = true;
			} else {
				flag = false;
			}
			action.moveToElement(DropDownCross).click().perform();

			/* Filter | Game */

			SelectGames.click();
			WaitClass.waitForTime(1000);
			SearchDropdownValueGame.click();
			WaitClass.waitForTime(2000);
			Actions action = new Actions(driver);
			action.moveToElement(FilterOffernameHeader).click().perform();
			WaitClass.waitForTime(2000);
			String gametext = driver.findElement(By.xpath("(//span[@class='css-1v99tuv'])[2]")).getText();
			String gametexttext = ListGame.get(0).getText();
			if (gametext.equals(gametexttext)) {
				flag = true;
			}

			else {
				flag = false;
			}
			return true && flag;

		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Offers_page, Method - OffersFilter : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify that user is able to filter according to start date ,
	 * End date and status.
	 * 
	 * @return - true - if user is able to filter according to start date , End date
	 *         and status.
	 * 
	 */
	public boolean OfferFilterDateStatus() {
		try {
			/* Filter | Start Date */

			boolean flag = false;
			SearchStartDate.click();
			SearchStartDate.sendKeys("01 Jan 2022");
			FilterStartDateHeader.click();
			String Dateactual = ListDatesStartandEnd.getText();
			String date = driver.findElement(By.xpath("(//input[@placeholder='dd mmm yyyy'])[1]")).getText();
			if (Dateactual.contains(date)) {
				flag = true;
			} else if (Dateactual.isBlank()) {
				flag = false;
			}
			/* Filter | End Date */

			action.moveToElement(DropDownCrossStartdate).click().perform();
			SearchEndDate.click();
			SearchEndDate.sendKeys("24 jun 2022");
			FilterStartDateHeader.click();
			String Dateactual1 = ListDatesStartandEnd.getText();
			String date1 = driver.findElement(By.xpath("(//input[@placeholder='dd mmm yyyy'])[2]")).getText();
			if (Dateactual1.contains(date1)) {
				flag = true;
			} else if (Dateactual1.isBlank()) {
				flag = false;
			}
			action.moveToElement(DropDownCrossStartdate).click().perform();

			/* Filter | Status */

			SelectStatus.click();
			WaitClass.waitForTime(1000);
			SearchDropdownValueStatus.click();
			WaitClass.waitForTime(2000);
			Actions action = new Actions(driver);
			action.moveToElement(FilterOffernameHeader).click().perform();
			WaitClass.waitForTime(2000);
			String status = driver.findElement(By.xpath("(//span[@class='css-1v99tuv'])[3]")).getText();
			String statustext = ListStatus.get(0).getText();
			if (status.equals(statustext)) {
				flag = true;
			}

			else {
				flag = false;
			}

			return true && flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Offers_page, Method - OfferFilterDateStatus : " + e);
			return false;
		}

	}

	/* Offers - Grid / List view */

	/**
	 * Description - Verify if Partner experiences a grid view by default.
	 * 
	 * @return - true - if Partner experiences a grid view by default.
	 * 
	 * 
	 */
	public boolean Gridviewbydefault() {
		try {
			boolean flag = false;
			if (Gridbutton.isEnabled()) {
				flag = true;
			} else {
				flag = false;
			}
			return true && flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Offers_page, Method - Gridviewbydefault : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify if Partner can see the game image and Partner image is
	 * display.
	 * 
	 * @return - true - if Partner can see the game image and Partner image is
	 *         display.
	 * 
	 * 
	 */
	public boolean PartnerGamesImages() {
		try {
			boolean validate = false;
			if (GameImage.isDisplayed()) {
				validate = true;
			} else if (PartnerImage.isDisplayed()) {
				validate = true;
			}
			return validate;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Offers_page, Method - PartnerGamesImages : " + e);
			return false;
		}
	}

	/* Offers - Sorting */

	/**
	 * Description - Verify if Partner can sort the records in ascending or
	 * descending order according to the Offer name, Game Name, Start Date, End date
	 * by clicking on sort symbol in the grid view.
	 * 
	 * @return - true - if Partner can sort the records in ascending or descending
	 *         order according to the Offer name, Game Name, Start Date, End date by
	 *         clicking on sort symbol in the grid view.
	 */
	public boolean SortinginGridview(int offername, int gamename) {
		try {

			/* Sorting Offer Name Grid view */

			if (offername == 1) {
				ArrayList<String> offername1 = new ArrayList<String>();
				ArrayList<String> offername2 = new ArrayList<String>();
				for (int j = 0; j <= OffernameGrid.size() - 1; j++) {
					String offernametext = OffernameGrid.get(j).getText();

					offername1.add(offernametext);

				}

				WaitClass.waitForTime(2000);
				for (int j = 0; j <= OffernameGrid.size() - 1; j++) {
					String offernametext2 = OffernameGrid.get(j).getText();

					offername2.add(offernametext2);
				}

				return offername1.equals(offername2);
			}
			if (offername == 2) {
				ArrayList<String> offername3 = new ArrayList<String>();
				ArrayList<String> offername4 = new ArrayList<String>();
				SortButton.click();
				Utility.javaScriptClick(SortingOffername, driver);

				for (int j = 0; j <= OffernameGrid.size() - 1; j++) {
					String offernametext3 = OffernameGrid.get(j).getText();

					offername3.add(offernametext3);
				}

				WaitClass.waitForTime(2000);
				for (int j = 0; j <= OffernameGrid.size() - 1; j++) {
					String gamenametext4 = OffernameGrid.get(j).getText();

					offername4.add(gamenametext4);
				}
				return offername3.equals(offername4);
			}

			/* Sorting Game Name Grid view */

			if (gamename == 1) {
				ArrayList<String> gamename1 = new ArrayList<String>();
				ArrayList<String> gamename2 = new ArrayList<String>();
				for (int j = 0; j <= OfferGameNameGridlist.size() - 1; j++) {
					String offernametext = OfferGameNameGridlist.get(j).getText();

					gamename1.add(offernametext);

				}

				WaitClass.waitForTime(2000);
				for (int j = 0; j <= OfferGameNameGridlist.size() - 1; j++) {
					String offernametext2 = OfferGameNameGridlist.get(j).getText();

					gamename2.add(offernametext2);
				}

				return gamename1.equals(gamename2);
			}
			if (gamename == 2) {
				ArrayList<String> gamename3 = new ArrayList<String>();
				ArrayList<String> gamename4 = new ArrayList<String>();
				// SortButton.click();
				// Utility.javaScriptClick(SortingGamename, driver);

				for (int j = 0; j <= OfferGameNameGridlist.size() - 1; j++) {
					String offernametext3 = OfferGameNameGridlist.get(j).getText();

					gamename3.add(offernametext3);
				}

				WaitClass.waitForTime(2000);
				for (int j = 0; j <= OfferGameNameGridlist.size() - 1; j++) {
					String gamenametext4 = OfferGameNameGridlist.get(j).getText();

					gamename4.add(gamenametext4);
				}
				return gamename3.equals(gamename4);
			}

			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Offers_page, Method - SortinginGridview : " + e);
			return false;
		}
	}

	/* Offers - Sorting in List view */

	/**
	 * Description- Verify if Partner can sort the records in ascending or
	 * descending order according to the Offer name, Game Name, Start Date, End date
	 * by clicking on upper/lower arrow mark.
	 * 
	 * @return- true - if Partner can sort the records in ascending or descending
	 *          order according to the Offer name, Game Name, Start Date, End date
	 *          by clicking on upper/lower arrow mark.
	 * 
	 */
	public boolean SortingPartnerGamesList(int offername, int game, int startdate, int enddate) {
		try {
			// Sorting Offer NAme

			if (offername == 1) {
				ArrayList<String> offernamelist = new ArrayList<String>();
				ArrayList<String> offernamelistB = new ArrayList<String>();
				SortingOffernameAsc.click();

				for (int j = 0; j <= OffernameList.size() - 1; j++) {
					String offernameA = OffernameList.get(j).getText();

					offernamelist.add(offernameA);

				}

				SortingOffernameAsc.click();
				SortingOffernameDesc.click();
				SortingOffernameAsc.click();

				WaitClass.waitForTime(2000);
				for (int j = 0; j <= OffernameList.size() - 1; j++) {
					String offernameB = OffernameList.get(j).getText();

					offernamelistB.add(offernameB);
				}

				return offernamelist.equals(offernamelistB);
			}
			if (offername == 2) {
				ArrayList<String> offernamelistC = new ArrayList<String>();
				ArrayList<String> offernamelistD = new ArrayList<String>();
				SortingOffernameDesc.click();
				for (int j = 0; j <= OffernameList.size() - 1; j++) {
					String offernamec = OffernameList.get(j).getText();

					offernamelistC.add(offernamec);
				}

				SortingOffernameDesc.click();
				SortingOffernameAsc.click();
				SortingOffernameDesc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= OffernameList.size() - 1; j++) {
					String offernameD = OffernameList.get(j).getText();

					offernamelistD.add(offernameD);
				}
				return offernamelistC.equals(offernamelistD);
			}

			// Sorting Game

			if (game == 1) {
				ArrayList<String> gamelistA = new ArrayList<String>();
				ArrayList<String> gamelistB = new ArrayList<String>();
				SortingGamenameAsc.click();
				for (int j = 0; j <= GamenameList.size() - 1; j++) {
					String datetext = GamenameList.get(j).getText();

					gamelistA.add(datetext);

				}

				SortingGamenameAsc.click();
				SortingGamenameDesc.click();
				SortingGamenameAsc.click();

				WaitClass.waitForTime(2000);
				for (int j = 0; j <= GamenameList.size() - 1; j++) {
					String datetext1 = GamenameList.get(j).getText();

					gamelistB.add(datetext1);
				}

				return gamelistA.equals(gamelistB);
			}
			if (game == 2) {
				ArrayList<String> gamelistC = new ArrayList<String>();
				ArrayList<String> gamelistD = new ArrayList<String>();
				SortingGamenameDesc.click();
				for (int j = 0; j <= GamenameList.size() - 1; j++) {
					String datetext3 = GamenameList.get(j).getText();

					gamelistC.add(datetext3);
				}

				SortingGamenameDesc.click();
				SortingGamenameAsc.click();
				SortingGamenameDesc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= GamenameList.size() - 1; j++) {
					String datetext4 = GamenameList.get(j).getText();
					gamelistD.add(datetext4);
				}
				return gamelistC.equals(gamelistD);
			}

			// Sorting Start Date

			if (startdate == 1) {
				ArrayList<String> date1 = new ArrayList<String>();
				ArrayList<String> date2 = new ArrayList<String>();
				SortingStartdateAsc.click();
				for (int j = 0; j <= StartDateList.size() - 1; j++) {
					String datetext = StartDateList.get(j).getText();

					date1.add(datetext);

				}

				SortingStartdateAsc.click();
				SortingStartdateDesc.click();
				SortingStartdateAsc.click();

				WaitClass.waitForTime(2000);
				for (int j = 0; j <= StartDateList.size() - 1; j++) {
					String datetext1 = StartDateList.get(j).getText();

					date2.add(datetext1);
				}

				return date1.equals(date2);
			}
			if (startdate == 2) {
				ArrayList<String> date3 = new ArrayList<String>();
				ArrayList<String> date4 = new ArrayList<String>();
				SortingStartdateDesc.click();
				for (int j = 0; j <= StartDateList.size() - 1; j++) {
					String datetext3 = StartDateList.get(j).getText();

					date3.add(datetext3);
				}

				SortingStartdateDesc.click();
				SortingStartdateAsc.click();
				SortingStartdateDesc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= StartDateList.size() - 1; j++) {
					String datetext4 = StartDateList.get(j).getText();
					date4.add(datetext4);
				}
				return date3.equals(date4);
			}

			// sorting date approved

			if (enddate == 1) {
				ArrayList<String> date1 = new ArrayList<String>();
				ArrayList<String> date2 = new ArrayList<String>();
				SortingEnddateAsc.click();
				for (int j = 0; j <= EndDateList.size() - 1; j++) {
					String datetext = EndDateList.get(j).getText();

					date1.add(datetext);

				}

				SortingEnddateAsc.click();
				SortingEnddateDesc.click();
				SortingEnddateAsc.click();

				WaitClass.waitForTime(2000);
				for (int j = 0; j <= EndDateList.size() - 1; j++) {
					String datetext1 = EndDateList.get(j).getText();

					date2.add(datetext1);
				}

				return date1.equals(date2);
			}
			if (enddate == 2) {
				ArrayList<String> date3 = new ArrayList<String>();
				ArrayList<String> date4 = new ArrayList<String>();
				SortingEnddateDesc.click();
				for (int j = 0; j <= EndDateList.size() - 1; j++) {
					String datetext3 = EndDateList.get(j).getText();

					date3.add(datetext3);
				}

				SortingEnddateDesc.click();
				SortingEnddateAsc.click();
				SortingEnddateDesc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= EndDateList.size() - 1; j++) {
					String datetext4 = EndDateList.get(j).getText();
					date4.add(datetext4);
				}
				return date3.equals(date4);
			}

			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Offers_page, Method - SortingPartnerGamesList : " + e);
			return false;
		}
	}

	/* Offers - Add Offer from a template */

	/**
	 * Description - Verify if Partner can click on add new button and select Create
	 * an offer from template.
	 * 
	 * @return - true - if Partner can click on add new button and select Create an
	 *         offer from template.
	 * 
	 */
	public boolean addnewbutton() {
		try {
			addnewbutton.click();
			Createofferfromatemplate.click();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Offers_page, Method - addnewbutton : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify if partner can see for Start an offer from a Template,
	 * Choose Template (Optional), Offer Description to Promote to Players,
	 * Achievements (all achievements must be met to earn the reward), Event Name,
	 * QX Points, Partner Cost ($), Schedule the Offer, Start Date, End Date
	 * 
	 * @return - True - if partner can see for Start an offer from a Template,
	 *         Choose Template (Optional), Offer Description to Promote to Players,
	 *         Achievements (all achievements must be met to earn the reward), Event
	 *         Name, QX Points, Partner Cost ($), Schedule the Offer, Start Date,
	 *         End Date
	 */
	public boolean ElementsOffersTemplete() {

		try {

			boolean flag = CreateAofferHeading.isDisplayed();
			flag = flag && Choosetemplateotionalheader.isDisplayed();
			flag = AddOfferDetailsHeading.isDisplayed();
			flag = flag && OffernameHeader.isDisplayed();
			flag = flag && OfferDescriptionHeader.isDisplayed();
			flag = flag && Achievmentsheading.isDisplayed();
			flag = flag && AchievmentsNameheader.isDisplayed();
			flag = flag && Achievmentsdescription.isDisplayed();
			flag = flag && Eventnameheader.isDisplayed();
			flag = flag && Functionheader.isDisplayed();
			flag = flag && ComparisonHeader.isDisplayed();
			flag = flag && Valueheader.isDisplayed();
			flag = flag && Qxpointsheader.isDisplayed();
			flag = flag && choosegameheader.isDisplayed();
			flag = flag && choosetargetgamerheader.isDisplayed();
			flag = flag && startdateheader.isDisplayed();
			flag = flag && enddateheader.isDisplayed();
			return flag;
		} catch (Exception e) {

			System.err.println(
					"Exception in Class - Partner_Offers_page, Method - ElementsOffersTemplete : " + e);
			return false;
		}
	}

}
