package PageObjectClasses;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Partner_Games_Page {
	WebDriver driver;
	SoftAssert softassert;
	Actions action;

	public Partner_Games_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		softassert = new SoftAssert();
		action = new Actions(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Enter your username']")
	private WebElement EnterUserName;
	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	private WebElement EnterPassword;
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement SignInButton;
	@FindBy(xpath = "//h4[contains(text(),'Games')]")
	private WebElement GamesButton;
	@FindBy(xpath = "//input[@placeholder='Search by Game Name...']")
	private WebElement Serachfield;
	@FindBy(xpath = "//div[@class='games-grid-box-body']/strong")
	private List<WebElement> GameNamelist;
	@FindBy(xpath = "//span[contains(@class,'des-text')]")
	private List<WebElement> DescriptionList;
	@FindBy(xpath = "//span[@class='games-text']")
	private List<WebElement> StatusList;
	@FindBy(xpath = "//span[contains(@class,'date-text')][1]")
	private List<WebElement> DateSubmitedList;
	@FindBy(xpath = "//span[contains(@class,'date-text')][2]")
	private List<WebElement> DateModifiedList;
	@FindBy(xpath = "//span[contains(@class,'date-text')][3]")
	private List<WebElement> DateApprovedList;
	@FindBy(xpath = "//span[contains(@class, 'icon-list-view')]")
	private WebElement Listbutton;
	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root'])[2]")
	private WebElement GameActionButton;
	@FindBy(xpath = "//button[contains(text(),'Back')]")
	private WebElement Backbutton;
	@FindBy(xpath = "(//span[contains(text(),'Select')])[1]")
	private WebElement SelectfilterGmaename;
	@FindBy(xpath = "//*[contains(text(),'Game')]//preceding-sibling::input")
	private WebElement SearchDropdownValuegamename;
	@FindBy(xpath = "//label[text()='Game Name']")
	private WebElement GamenameHeader;
	@FindBy(xpath = "(//span[contains(text(),'Select')])[2]")
	private WebElement SelectfilterStatus;
	@FindBy(xpath = "//*[text()='In-Development']//preceding-sibling::input")
	private WebElement SearchDropdownValuestatus;
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M19 6.41L1')]")
	private WebElement DropDownCross;
	@FindBy(xpath = "//*[text()='In-Development']//preceding-sibling::input")
	private WebElement SearchDropdownIndevelopment;
	@FindBy(xpath = "//*[text()='Submit for Approval']//preceding-sibling::input")
	private WebElement SearchDropdownsubmitforApproval;
	@FindBy(xpath = "//*[text()='Rejected']//preceding-sibling::input")
	private WebElement SearchDropdownReject;
	@FindBy(xpath = "//*[text()='Disabled']//preceding-sibling::input")
	private WebElement SearchDropdownDisaled;

	@FindBy(xpath = "//h3[@class='main-heading']")
	private WebElement GamesUsername;
	@FindBy(xpath = "//h4[contains(text(),'Games')]")
	private WebElement GamesHeading;
	@FindBy(xpath = "//label[contains(text(),'Game Name')]")
	private WebElement GamesNameHeader;
	@FindBy(xpath = "//label[contains(text(),'Status')]")
	private WebElement GamesStatusHeader;
	@FindBy(xpath = "//button[text()='Add Game']")
	private WebElement AddGamebutton;
	@FindBy(xpath = "//div[text()='Game Icon']")
	private WebElement GameIconHeader;
	@FindBy(xpath = "//div[text()='Game Name']")
	private WebElement GameNameHeader;
	@FindBy(xpath = "//div[text()='Description']")
	private WebElement GameDescriptionHeader;
	@FindBy(xpath = "//div[text()='Status']")
	private WebElement GameStatusHeader;
	@FindBy(xpath = "//div[text()='Date Submitted']")
	private WebElement GameDateSubmitedHeader;
	@FindBy(xpath = "//div[text()='Date Modified']")
	private WebElement GameDateModifiedHeader;
	@FindBy(xpath = "//div[text()='Date Approved']")
	private WebElement GameDateApprovedHeader;
	@FindBy(xpath = "//div[text()='Action']")
	private WebElement GameActionHeader;
	@FindBy(xpath = "//span[contains(@class, 'icon-grid-view')]")
	private WebElement GridViewButton;

	/* Partner | Games - Add New */

	@FindBy(xpath = "//button[contains(text(),'Back')]")
	private WebElement Backbuttonnew;
	@FindBy(xpath = "//h4[contains(text(),'Add Game')]")
	private WebElement AddnewGameHeading;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement Cancelbutton;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement Submitbutton;
	@FindBy(xpath = "//strong[contains(text(),'Game Icon')]")
	private WebElement GameiconHeader;
	@FindBy(xpath = "//span[contains(text(),'browse')]")
	private WebElement Uploadimagebutton;
	@FindBy(xpath = "//label[contains(text(),'Game Name')]")
	private WebElement GameNameHeaderNew;
	@FindBy(xpath = "//input[@placeholder='Enter Game Name']")
	private WebElement GameNameField;
	@FindBy(xpath = "//label[contains(text(),'Download URLs')]")
	private WebElement DownloadurlHeader;
	@FindBy(xpath = "//input[@placeholder='Enter Download URL']")
	private WebElement DownloadurlField;
	@FindBy(xpath = "(//span[@class='icon-circle-plus-green icon'])[1]")
	private WebElement DownloadUrlplusbutton;
	@FindBy(xpath = "//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
	private WebElement DescriptionField;
	@FindBy(xpath = "//h4[contains(text(),'Exchangeable Assets (Optional)')]")
	private WebElement ExchangeableAssets;
	@FindBy(xpath = "//label[contains(text(),'Asset Name')]")
	private WebElement AssetName;
	@FindBy(xpath = "//input[@placeholder='Enter Asset Name']")
	private WebElement AssetNameField;
	@FindBy(xpath = "//label[contains(text(),'Unit Value - QX Points')]")
	private WebElement UnitValueHeader;
	@FindBy(xpath = "//input[@placeholder='Enter Value']")
	private WebElement UnitValueField;
	@FindBy(xpath = "//span[contains(text(),'(Gamer value: 1 QX Point = $0.01: Partner cost: 1 QX Point = $0.012)')]")
	private WebElement UnitValueFieldText;
	@FindBy(xpath = "//div[contains(text(),'Game added successfully')]")
	private WebElement ToastMessageGameadd;
	@FindBy(xpath = "//div[contains(text(),'Game name already exists.')]")
	private WebElement ToastMessageAlreadyexists;
	@FindBy(xpath = "//h4[@class='page-heading my-5']")
	private WebElement DashboardUsername;
	@FindBy(xpath = "//div[@class='amplify-alert__body']")
	private WebElement UserDisabledPartner;
	@FindBy(xpath = "//h2[contains(text(),'Application Rejected')]")
	private WebElement ApplicationReject;
	@FindBy(xpath = "//p[contains(text(),'Automation testing')]")
	private WebElement ApplicationRejectReason;
	@FindBy(xpath = "//button[contains(text(),'Apply Again')]")
	private WebElement ApplyAgainbutton;
	@FindBy(xpath = "//h4[contains(text(),'General Information')]")
	private WebElement Generalinformationrejectpartner;
	/* Partner | Games - Sorting */
	@FindBy(xpath = "//span[@data-testid='game-name-sort-asc']")
	private WebElement SortingGamenameAsc;
	@FindBy(xpath = "//span[@data-testid='game-name-sort-desc']")
	private WebElement SortingGamenameDesc;
	@FindBy(xpath = "//span[@data-testid='date-submitted-sort-asc']")
	private WebElement SortingDateSubmittedAsc;
	@FindBy(xpath = "//span[@data-testid='date-submitted-sort-desc']")
	private WebElement SortingDateSubmittedDesc;
	@FindBy(xpath = "//span[@data-testid='date-modified-sort-asc']")
	private WebElement SortingDateModifiedAsc;
	@FindBy(xpath = "//span[@data-testid='date-modified-sort-desc']")
	private WebElement SortingDateModifiedDesc;
	@FindBy(xpath = "//span[@data-testid='date-approved-sort-asc']")
	private WebElement SortingDateApprovedAsc;
	@FindBy(xpath = "//span[@data-testid='date-approved-sort-desc']")
	private WebElement SortingDateApprovedDesc;
	@FindBy(xpath = "//select[@name='status']")
	private WebElement SetStatusas;
	@FindBy(xpath = "//option[contains(text(),'Submit for Approval')]")
	private WebElement SubmitForApprovel;
	@FindBy(xpath = "//div[@class='games-grid-wrapper no-scrollbar games-list-wrapper']//div[1]//div[1]//div[2]//div[1]//span[1]//*[name()='svg']")
	private WebElement Actionbutton;
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	private WebElement UpdateButtoneditgame;
	@FindBy(xpath = "//*[text()='Approved']//preceding-sibling::input")
	private WebElement SearchDropdownApprovedGame;
	
//	Partner - Game -Edit
	@FindBy(xpath = "//span[@class = 'rounded']")
	private WebElement editButton;
	@FindBy(xpath = "//select[@name = 'status']")
	private WebElement setStatusDropDown;
	@FindBy(xpath = "//a[text()= 'Comments']")
	private WebElement commentsButton;
	@FindBy(xpath = "//a[text()= 'Details']")
	private WebElement detailsButton;	
	@FindBy(xpath = "//input[@name= 'comment']")
	private WebElement commentField;
	@FindBy(xpath = "//button[text()= 'Send']")
	private WebElement sendButton;
	@FindBy(xpath = "//h3[@class = 'main-heading']")
	private WebElement userGreeting;
	@FindBy(xpath = "//h4[@class = 'page-heading']")
	private WebElement gamesPageHeading;
	@FindBy(xpath = "//div[@role = 'textbox']")
	private WebElement descriptionText;
	@FindBy(xpath = "//input[@data-testid = 'search']")
	private WebElement searchElement;
	/**
	 * Description - Verify that user is able to Click on Games button.
	 * 
	 * @return - true - If user is able to Click on Games button.
	 */
	public boolean GamesButton() {
		try {
			action.moveToElement(GamesButton).click().perform();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - GamesButton : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify that user is able to click on search bar field.
	 * 
	 * @return - true - if user is success for the click on Search bar field.
	 */
	public boolean SearchField() {
		try {
			action.moveToElement(Serachfield).click().perform();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - SearchField : " + e);
			return false;
		}
	}
	

	/**
	 * Description - Verify that user can search the games through the game name and
	 * game description.
	 * 
	 * @return - true - if user can search the games through the game name and game
	 *         description.
	 */
	public boolean SearchGames() {
		try {

			WaitClass.waitForTime(2000);
			boolean flag = true;
			Serachfield.clear();
			WaitClass.waitForTime(2000);
			WebElement list = GameNamelist.get(0);
			String searchdetails = list.getText();
			Serachfield.sendKeys(searchdetails);
			WaitClass.waitForTime(3000);
			for (WebElement data : GameNamelist) {
				String dataverify = data.getText();
				flag = flag && dataverify.equals(searchdetails);
			}
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - SearchGames : " + e);
			return false;
		}
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
			System.err.println("Exception in Class - Partner_Games_Page, Method - Listbutton : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify that user can search the games through the game
	 * description.
	 * 
	 * @return - true - if user can search the games through the game description.
	 */
	public boolean SearchGamesdescription() {
		try {

			WaitClass.waitForTime(2000);
			boolean flag = true;
			Serachfield.clear();
			WaitClass.waitForTime(2000);
			int random = Utility.getRandomInt(0, DescriptionList.size() - 1);
			WebElement list = DescriptionList.get(random);
			String searchdetails = list.getText();
			Serachfield.sendKeys(searchdetails);
			WaitClass.waitForTime(3000);
			for (WebElement data : DescriptionList) {
				String dataverify = data.getText();
				flag = flag && dataverify.equals(searchdetails);
			}
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - SearchGamesdescription : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify that user is able to enter the game name in search field
	 * and clear it , check all games are still showing in game name list.
	 * 
	 * @return - true - if all game are present in game list after clear the search
	 *         box.
	 */
	public boolean viewallgamenamelist() {
		try {
			boolean flag = false;
			Serachfield.click();
			Serachfield.sendKeys("Game");
			Utility.clearField(driver, Serachfield);
			if (GameNamelist.size() != 0) {
				flag = true;

			} else {

				System.err.println("Element is not present in the list");
			}

			return true&&flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - viewallgamenamelist : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify that user is able to click on the any game's action
	 * button go to redirect edit game dashboard click on back button and find same
	 * result on search bar.
	 * 
	 * @return - true - if click on the any game's action button go to redirect edit
	 *         game dashboard click on back button and find same result on search
	 *         bar.
	 */
	public boolean Validatesearchfield() {
		try {
			Utility.clearField(driver, Serachfield);
			Serachfield.sendKeys("Game");
			GameActionButton.click();
			WaitClass.waitForTime(4000);
			Backbutton.click();
			WaitClass.waitForTime(4000);
			return true;
//			if (textvalue.equals("Aspect1")) {
//				flag = true;
//			}
			

		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - Validatesearchfield : " + e);
			return false;
		}
	}

	/* Partner Games Filter */

	/**
	 * Description - Verify that user can filter the data according to game name and
	 * status.
	 * 
	 * @return - true - if user can filter the data according to game name and
	 *         status.
	 * 
	 * 
	 */
	public boolean GamesFilter() {
		try {
			/* Filter via game name */
			boolean flag = false;
			SelectfilterGmaename.click();
			WaitClass.waitForTime(1000);
			SearchDropdownValuegamename.click();
			WaitClass.waitForTime(2000);
			Actions action = new Actions(driver);
			action.moveToElement(GamenameHeader).click().perform();
			WaitClass.waitForTime(2000);
			String gametext = driver.findElement(By.xpath("//span[contains(text(),'Game')]/ancestor::button"))
					.getText();
			String gametexttext = GameNamelist.get(0).getText();
			if (gametext.contains(gametexttext)) {
				flag = true;
			}
			/* Filter via status */
			action.moveToElement(DropDownCross).click().perform();
			SelectfilterStatus.click();
			WaitClass.waitForTime(1000);
			SearchDropdownValuestatus.click();
			WaitClass.waitForTime(2000);
			Actions actiona = new Actions(driver);
			actiona.moveToElement(GamenameHeader).click().perform();
			WaitClass.waitForTime(2000);
			String Statustext = driver.findElement(By.xpath("//span[contains(text(),'In-Development')]/ancestor::button"))
					.getText();
			String Statustexta = StatusList.get(0).getText();
			if (Statustext.contains(Statustexta)) {
				flag = true;
			}
			action.moveToElement(DropDownCross).click().perform();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - GamesFilter : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify if Partner is able to enter text in search box of
	 * filters and result can be Multi-selected
	 * 
	 * @return - true - if Verify if Partner is able to enter text in search box of
	 *         filters and result can be multi-selected.
	 */
	public boolean StatusMultiselected() {
		try {
			Utility.clearField(driver, Serachfield);
			Serachfield.sendKeys(Utility.getPropertiesFile("primaryLogin", "GameName"));
			SelectfilterStatus.click();
			WaitClass.waitForTime(1000);
			SearchDropdownIndevelopment.click();
			WaitClass.waitForTime(1000);
			SearchDropdownsubmitforApproval.click();
			WaitClass.waitForTime(1000);
			SearchDropdownReject.click();
			WaitClass.waitForTime(1000);
			SearchDropdownDisaled.click();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - StatusMultiselected : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify if Partner removes the filter by clicking on cross icon,
	 * then the full listing will again appear.
	 * 
	 * @return - true - Verify if Partner removes the filter by clicking on cross
	 *         icon, then the full listing will again appear.
	 */
	public boolean CrossButton() {
		try {
			boolean flag = false;
			action.moveToElement(GamenameHeader).click().perform();
			action.moveToElement(DropDownCross).click().perform();

			if (GameNamelist.size() != 0) {
				flag = true;

			} else {

				System.err.println("Element is not present in the list");
			}
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - CrossButton : " + e);
			return false;
		}
	}

	/* Partner | Games - Grid / List view */

	/**
	 * Description - Checking all Elements are present on Partner Games. Dash-board.
	 * 
	 * @return - True - if all Elements are present on Partner Games Dash-board.
	 */
	public boolean ElementsvisiblityPartnerGames() {

		try {
			Listbutton.click();
			boolean flag = GamesUsername.isDisplayed();
			flag = flag && GamesHeading.isDisplayed();
			flag = GamesNameHeader.isDisplayed();
			flag = flag && GamesStatusHeader.isDisplayed();
			flag = flag && AddGamebutton.isDisplayed();
			flag = flag && GameIconHeader.isDisplayed();
			flag = flag && GameNameHeader.isDisplayed();
			flag = flag && GameDescriptionHeader.isDisplayed();
			flag = flag && GameStatusHeader.isDisplayed();
			flag = flag && GameDateSubmitedHeader.isDisplayed();
			flag = flag && GameDateModifiedHeader.isDisplayed();
			flag = flag && GameDateApprovedHeader.isDisplayed();
			flag = flag && GameActionHeader.isDisplayed();
			flag = flag && GridViewButton.isDisplayed();

			return flag;
		} catch (Exception e) {

			System.err
					.println("Exception in Method - ElementsvisiblityPartnerGames, Class - Partner_Games_Page : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify if partner is able to see all the games created by him
	 * only in the grid view by default.
	 * 
	 * @return - true - if partner is able to see all the games created by him only
	 *         in the grid view by default. box.
	 */
	public boolean ValidateGamesinlist() {
		try {
			boolean flag = false;

			if (GameNamelist.size() != 0) {
				flag = true;

			} else {

				System.err.println("Games is not present in the list");
			}

			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - ValidateGamesinlist : " + e);
			return false;
		}
	}

	/**
	 * Description -Verify if partner is able to toggle between list view and grid
	 * view
	 * 
	 * 
	 * @return - true - if partner is able to toggle between list view and grid view
	 * 
	 */
	public boolean ToggleGridandList() {
		try {
			boolean flag = false;
			Utility.javaScriptClick(GridViewButton, driver);
			if (GridViewButton.isEnabled()) {
				flag = true;

			} else {

				System.err.println("Grid view button is enebled.");
			}
			Utility.javaScriptClick(Listbutton, driver);
			if (Listbutton.isEnabled()) {
				flag = true;

			} else {

				System.err.println("List view button is enebled.");
			}
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - ToggleGridandList : " + e);
			return false;
		}
	}

	/* Partner | Games - Add New */

	/**
	 * Description - Verify that user can click on add new games.
	 * 
	 * @return - true - If Verify that user can click on add new games.
	 * 
	 */
	public boolean AddnewGamebutton() {
		try {
			Utility.javaScriptClick(AddGamebutton, driver);
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - AddnewGamebutton : " + e);
			return false;
		}
	}

	/**
	 * Description - Checking all Elements are present on Partner New Add Games.
	 * 
	 * @return - True - if all Elements are present on Partner New Add Games.
	 */
	public boolean ElementsvisiblityPartnerAddNewGames() {

		try {

			boolean flag = Backbuttonnew.isDisplayed();
			flag = flag && AddnewGameHeading.isDisplayed();
			flag = Cancelbutton.isDisplayed();
			flag = flag && Submitbutton.isDisplayed();
			flag = flag && GameiconHeader.isDisplayed();
			flag = flag && Uploadimagebutton.isDisplayed();
			flag = flag && GameNameHeaderNew.isDisplayed();
			flag = flag && GameNameField.isDisplayed();
			flag = flag && DownloadurlHeader.isDisplayed();
			flag = flag && DownloadurlField.isDisplayed();
			flag = flag && DownloadUrlplusbutton.isDisplayed();
			flag = flag && DescriptionField.isDisplayed();
			flag = flag && ExchangeableAssets.isDisplayed();
			flag = flag && AssetName.isDisplayed();
			flag = flag && AssetNameField.isDisplayed();
			flag = flag && UnitValueHeader.isDisplayed();
			flag = flag && UnitValueField.isDisplayed();
			flag = flag && UnitValueFieldText.isDisplayed();
			return flag;
		} catch (Exception e) {

			System.err.println(
					"Exception in Method - ElementsvisiblityPartnerAddNewGames , Class - Partner_Games_Page : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify if partner can click on the Submit button by entering
	 * all mandatory fields: Game icon, Game Name, Download URLs, Description &
	 * Exchangeable Assets (Optional).
	 * 
	 * @return - true - if partner can click on the Submit button by entering all
	 *         mandatory fields: Game icon, Game Name, Download URLs, Description &
	 *         Exchangeable Assets (Optional).
	 * 
	 */
	public boolean UploadGameIcon() {
		try {
			WaitClass.waitForTime(4000);
			WebElement element = driver.findElement(By.xpath("//label[@for = 'imageUpload']/preceding::input"));
			File file = new File("src/test/resources/TestData/chicken.jpeg");
			element.sendKeys(file.getAbsolutePath());
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - UploadGameIcon : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify if partner can click on the Submit button by entering
	 * all mandatory fields: Game icon, Game Name, Download URLs, Description &
	 * Exchangeable Assets (Optional).
	 * 
	 * @return - true - if partner can click on the Submit button by entering all
	 *         mandatory fields: Game icon, Game Name, Download URLs, Description &
	 *         Exchangeable Assets (Optional).
	 * 
	 */
	public boolean AddNewGame(String gameName) {
		try {
			GameNameField.sendKeys(gameName);
			DownloadurlField.sendKeys("https://www.google.com");
			DescriptionField.sendKeys("Description");
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - AddNewGame : " + e);
			return false;
		}
	}
	
	/**
	 * searches recently created game and clicks edit
	 * @return true, if partner is able to click edit button successfully
	 */
	public boolean editRecentlyCreatedGame(String game) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(searchElement));
			searchElement.clear();
			WaitClass.waitForTime(3000);			
			searchElement.sendKeys(game);
			WaitClass.waitForTime(2000);
			editButton.click();
			WaitClass.waitForTime(3000);
			return true;
		} catch (Exception e) {
			System.err.println("Class - Partner_Games_Page and Method - editRecentlyCreatedGame");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * edits game details
	 * @param gameName new game name 
	 * @param DownloadURL new download url
	 * @param description new game description
	 * @param assetName new asset name
	 * @param qxPoints new qx points
	 * @return true if successfully filled
	 */
	public boolean editGameDetails(String gameName, String DownloadURL, String description, String assetName, String qxPoints) {
		try {
			if (gameName != null) {
				Utility.clearField(driver, GameNameField);
				GameNameField.sendKeys(gameName);				
			}
			if (DownloadURL !=null) {
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait1.until(ExpectedConditions.visibilityOf(DownloadurlField));
				Utility.clearField(driver, DownloadurlField);
				DownloadurlField.sendKeys(DownloadURL);				
			}
			if (description != null) {
				WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait2.until(ExpectedConditions.elementToBeClickable(descriptionText));
				descriptionText.clear();
				descriptionText.sendKeys(description);
			}
			if (assetName != null) {
				WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait3.until(ExpectedConditions.visibilityOf(AssetNameField));
				Utility.clearField(driver, AssetNameField);
				AssetNameField.sendKeys(assetName);
			}
			if (qxPoints != null) {
				WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait4.until(ExpectedConditions.visibilityOf(UnitValueField));
				Utility.clearField(driver, UnitValueField);
				UnitValueField.sendKeys(qxPoints);				
			}
			WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait5.until(ExpectedConditions.visibilityOf(Backbutton));
			return true;
		} catch (Exception e) {
			System.err.println("Class - Partner_Games_Page and Method - editGameDetails");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * validate if exchangeableassets are disabled or not
	 * @return true, if disabled
	 */
	public boolean validateExchangeableAssets() {
		try {
			return !(AssetNameField.isEnabled() && UnitValueField.isEnabled()); 
		} catch (Exception e) {
			System.err.println("Class - Partner_Games_Page and Method - validateExchangeableAssets");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Creates a new game
	 * @return true, if successfully created a new game
	 */
	public boolean createNewGame(String gameName) {
		try {
			GamesButton();
			AddnewGamebutton();
			UploadGameIcon();
			AddNewGame(gameName);
			SubmitButton();
			ToastMessage();
			return true;
		} catch (Exception e) {
			System.err.println("Class - Partner_Games_Page and Method - createNewGame");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * clicks on back button
	 * @return true, if successfully clicked on back button
	 */
	public boolean clickBackButton() {
		try {
			Backbutton.click();
			Thread.sleep(3000);
			return true;
		} catch (Exception e) {
			System.err.println("Class - Partner_Games_Page and Method - clickBackButton");
			e.printStackTrace();
			return false;
		}
	}
	 /**
	  * checks if details are not saved 
	  * @param gameName
	  * @param DownloadURL
	  * @param description
	  * @param assetName
	  * @param qxPoints
	  * @return true, if details not saved
	  */
	public boolean validateGameDetailsNotSaved(String gameName, String DownloadURL, String description, String assetName, String qxPoints) {
		try {
			String actualGameName = GameNameField.getAttribute("value");
			String actualDownloadURL = DownloadurlField.getAttribute("value");
			String actualDescription = descriptionText.getText();
			String actualAssetName = AssetNameField.getAttribute("value");
			String actualQXPoints = UnitValueField.getAttribute("value");
			
			boolean flag = true;
			flag = actualGameName.equals(gameName) ? true : false;
			System.out.println("1");
			if (flag) return false;
			flag = actualDownloadURL.equals(DownloadURL) ? true : false;
			System.out.println("2");
			if (flag) return false;
			flag = actualDescription.equals(description) ? true : false;
			if (flag) return false;
			flag = actualAssetName.equals(assetName) ? true : false;
			System.out.println("3");
			if (flag) return false;
			flag = actualQXPoints.equals(qxPoints) ? true : false;
			if (flag) return false;
			else return true;
		} catch (Exception e) {
			System.err.println("Class - Partner_Games_Page and Method - validateGameDetails");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * changes status to Submit for Approval
	 * @return true, if successful
	 */
	public boolean selectSubmitForApproval() {
		try {
			Select dropdown = new Select(setStatusDropDown);
			dropdown.selectByValue("2");
			WaitClass.waitForTime(2000);
			return true;
		} catch (Exception e) {
			System.err.println("Class - Partner_Games_Page and Method - selectSubmitForApproval");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Description- User can click on submit button after filled the all details for
	 * add new game.
	 * 
	 * @return- true - if user can click on the submit button.
	 */
	public boolean SubmitButton() {
		try {
			Utility.javaScriptClick(Submitbutton, driver);
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - SubmitButton : " + e);
			return false;
		}
	}
	
	public boolean addComments(String comment) {
		try {
			commentsButton.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(commentField));
			commentField.sendKeys(comment);
			sendButton.click();
			return true;
		} catch (Exception e) {
			System.err.println("Class - partner_Games_Page and Method - addComments");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickDetails() {
		try {
			detailsButton.click();
			WaitClass.waitForTime(2000);
			return true;
		} catch (Exception e) {
			System.err.println("Class - Partner_Games_Page and Method - clickDetails");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateGamesPage() {
		try {
			boolean isUserGreetingPresent =  userGreeting.getText().equals("Hi, Stage Partner100");
			System.out.println(isUserGreetingPresent);
			boolean isGameHeadingPresent = gamesPageHeading.getText().equals("Games");
			System.out.println(isGameHeadingPresent);
			return  isUserGreetingPresent && isGameHeadingPresent;
		} catch (Exception e) {
			System.err.println("Class - Partner_Games_Page and Method - validateGamesPage");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean approveRecentlyCreatedGame() {
		try {
			String mainWindow = driver.getWindowHandle();
			String adminUrl = Utility.getPropertiesFile("link", "admin");
			String username = Utility.getPropertiesFile("primaryLogin", "superAdminUsername");
			String password = Utility.getPropertiesFile("primaryLogin", "superAdminPassword");
			String recentGame = Utility.getPropertiesFile("primaryLogin", "GameName") + 
					Utility.getPropertiesFile("testDataVariables", "gamename");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.navigate().to(adminUrl);
			SignIn_Admin_Pages adminSignIn = new SignIn_Admin_Pages(driver);
			Games_Admin_Page gamesAdmin = new Games_Admin_Page(driver);
			WaitClass.waitForTime(5000);
			adminSignIn.signinActionAdmin(username, password);
			WaitClass.waitForTime(2000);
			gamesAdmin.clickGames();
			WaitClass.waitForTime(2000);
			gamesAdmin.approveGame(recentGame);
			WaitClass.waitForTime(3000);
			driver.close();
			driver.switchTo().window(mainWindow);
			WaitClass.waitForTime(3000);
			return true;
		} catch (Exception e) {
			System.err.println("Class - Partner_Games_Page and method - approveGame");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Description- User can verify that toast message is appearing after submit the
	 * add new game.
	 * 
	 * @return- true - if toast message is appearing after click on the submit
	 *          button.
	 */
	public boolean ToastMessage() {
		try {
			String toast = Utility.getalerttext(driver, ToastMessageGameadd);
			String toastmessage = "Game added successfully";
			softassert.assertEquals(toastmessage, toast);
			softassert.assertAll();
			System.out.println(toast);
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - ToastMessage : " + e);
			return false;
		}
	}

	/**
	 * Description- Verify after submitting the game, game is visible in both
	 * list/grid view with status as in-development.
	 * 
	 * @return- true - if after submitting the game, game is visible in both
	 *          list/grid view with status as in-development
	 */
	public boolean validatenewgame(String game) {
		try {
			WaitClass.waitForTime(4000);
			Serachfield.click();
			WaitClass.waitForTime(2000);
			Serachfield.sendKeys(game);
			Serachfield.clear();
			Serachfield.sendKeys(game);
			String indev = StatusList.get(0).getText();
			String expected = "In-Development";
			softassert.assertEquals(indev, expected);
			softassert.assertAll();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - validatenewgame : " + e);
			return false;
		}
	}

	/**
	 * Description- Verify that same partner cannot add two or more games with the
	 * same game name.
	 * 
	 * @return- true - if same partner cannot add two or more games with the same
	 *          game name.
	 */
	public boolean AddnewGameWithSamename(String game) {
		try {

			GameNameField.sendKeys(game);
			DownloadurlField.sendKeys("https://www.google.com");
			DescriptionField.sendKeys("Description");
			Utility.javaScriptClick(Submitbutton, driver);
			String toast = Utility.getalerttext(driver, ToastMessageAlreadyexists);
			String toastmessage = "Game name already exists.";
			softassert.assertEquals(toastmessage, toast);
			softassert.assertAll();
			System.out.println(toast);
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - AddnewGameWithSamename : " + e);
			return false;
		}
	}

	/**
	 * Description- Verify if Partner is approved he should be able to login and see
	 * the dashboard.
	 * 
	 * @return- true - if Partner is approved he should be able to login and see the
	 *          dashboard.
	 */
	public boolean ValidateDashboard() {
		try {
			String usernameondashboard = DashboardUsername.getText();
			String expected = "Hi, Stage Partner100";
			softassert.assertEquals(usernameondashboard, expected);
			softassert.assertAll();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - ValidateDashboard : " + e);
			return false;
		}
	}

	/* Partner | Enable/Disable */

	/**
	 * Description- Verify if Partner is approved/enabled, he is able to login and
	 * see the dashboard.
	 * 
	 * @return- true - if Partner is approved/enabled, he is able to login and see
	 *          the dashboard.
	 * 
	 */
	public boolean ValidateDashboardEnableUser() {
		try {
			String usernameondashboard = DashboardUsername.getText();
			String expected = "Hi, nishant20";
			softassert.assertEquals(usernameondashboard, expected);
			softassert.assertAll();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - ValidateDashboardEnableUser : " + e);
			return false;
		}
	}

	/**
	 * Description- Verify if Partner is disabled, partner will not be able to sign
	 * in with a message "User is disabled".
	 * 
	 * @return- true - if Partner is disabled, partner will not be able to sign in
	 *          with a message "User is disabled".
	 * 
	 */
	public boolean Disabledpartner() {
		try {
			String userisdisabledactual = UserDisabledPartner.getText();
			String userisdisabledexpected = "User is disabled.";
			softassert.assertEquals(userisdisabledactual, userisdisabledexpected);
			softassert.assertAll();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - Disabledpartner : " + e);
			return false;
		}
	}

	/* Partner | Reject */

	/**
	 * Description- Verify if Partner is rejected by the ADmin then after login, the
	 * partner can see a screen which says Profile Rejected along with the rejection
	 * reason given by ADmin.
	 * 
	 * @return- true - Verify if Partner is rejected by the ADmin then after login,
	 *          the partner can see a screen which says Profile Rejected along with
	 *          the rejection reason given by ADmin.
	 */
	public boolean RejectedPartner() {
		try {

			String rejectpartneractual = ApplicationReject.getText();
			String rejectpartnerexpected = "Application Rejected";
			String rejectionreason = ApplicationRejectReason.getText();
			String rejectionreasonex = "Automation testing";
			softassert.assertEquals(rejectpartneractual, rejectpartnerexpected);
			softassert.assertEquals(rejectionreason, rejectionreasonex);
			softassert.assertAll();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - RejectedPartner : " + e);
			return false;
		}
	}

	/**
	 * Description- Verify if partner is able to click on the button (Apply Again).
	 * 
	 * @return- true - if partner is able to click on the button (Apply Again).
	 * 
	 */
	public boolean ClickonApplybutton() {
		try {
			WaitClass.waitForTime(4000);
			Utility.javaScriptClick(ApplyAgainbutton, driver);
			boolean geninfo = Generalinformationrejectpartner.isDisplayed();
			String geninfotext = Generalinformationrejectpartner.getText();
			String geninfotextex = "General Information";
			softassert.assertEquals(geninfotext, geninfotextex);
			softassert.assertTrue(geninfo);
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - ClickonApplybutton : " + e);
			return false;
		}
	}

	/* Partner | Games - Sorting */

	/**
	 * Description- Verify if user can view the games in the grid view by default.
	 * 
	 * @return- true - if user can view the games in the grid view by default.
	 * 
	 */
	public boolean GamesinGridview() {
		try {
			boolean flag = false;

			if (GameNamelist.size() != 0) {
				flag = true;

			} else {

				System.err.println("Games is not present in the Grid list");
			}

			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - GamesinGridview : " + e);
			return false;
		}
	}

	/**
	 * Description- Verify if user can sort the games in the ascending/descending
	 * order according to the Games name, Date submitted, Date Modified, Date
	 * Approved in both grid and list view.
	 * 
	 * @return- true - if user can sort the games in the ascending/descending order
	 *          according to the Games name, Date submitted, Date Modified, Date
	 *          Approved in both grid and list view
	 * 
	 */
	public boolean SortingPartnerGames(int gamename, int datesubmit, int datemodified, int dateapproved) {
		try {
			// Sorting Game Name
			if (gamename == 1) {
				ArrayList<String> gamename1 = new ArrayList<String>();
				ArrayList<String> gamename2 = new ArrayList<String>();
				SortingGamenameAsc.click();
				for (int j = 0; j <= GameNamelist.size() - 1; j++) {
					String gamenametext = GameNamelist.get(j).getText();
					String gamenameac = gamenametext.replaceAll("[0-9]", "");
					gamename1.add(gamenameac);

				}

				SortingGamenameAsc.click();
				SortingGamenameDesc.click();
				SortingGamenameAsc.click();

				WaitClass.waitForTime(2000);
				for (int j = 0; j <= GameNamelist.size() - 1; j++) {
					String gamenametext2 = GameNamelist.get(j).getText();
					String gamenameac = gamenametext2.replaceAll("[0-9]", "");
					gamename2.add(gamenameac);
				}

				return gamename1.equals(gamename2);
			}
			if (gamename == 2) {
				ArrayList<String> gamename3 = new ArrayList<String>();
				ArrayList<String> gamename4 = new ArrayList<String>();
				SortingGamenameDesc.click();
				for (int j = 0; j <= GameNamelist.size() - 1; j++) {
					String gamenametext3 = GameNamelist.get(j).getText();
					String gamenameac = gamenametext3.replaceAll("[0-9]", "");
					gamename3.add(gamenameac);
				}

				SortingGamenameDesc.click();
				SortingGamenameAsc.click();
				SortingGamenameDesc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= GameNamelist.size() - 1; j++) {
					String gamenametext4 = GameNamelist.get(j).getText();
					String gamenameac = gamenametext4.replaceAll("[0-9]", "");
					gamename4.add(gamenameac);
				}
				return gamename3.equals(gamename4);
			}

			// sorting date submit

			if (datesubmit == 1) {
				ArrayList<String> date1 = new ArrayList<String>();
				ArrayList<String> date2 = new ArrayList<String>();
				SortingDateSubmittedAsc.click();
				for (int j = 0; j <= DateSubmitedList.size() - 1; j++) {
					String datetext = DateSubmitedList.get(j).getText();

					date1.add(datetext);

				}

				SortingDateSubmittedAsc.click();
				SortingDateSubmittedDesc.click();
				SortingDateSubmittedAsc.click();

				WaitClass.waitForTime(2000);
				for (int j = 0; j <= DateSubmitedList.size() - 1; j++) {
					String datetext1 = DateSubmitedList.get(j).getText();

					date2.add(datetext1);
				}

				return date1.equals(date2);
			}
			if (datesubmit == 2) {
				ArrayList<String> date3 = new ArrayList<String>();
				ArrayList<String> date4 = new ArrayList<String>();
				SortingDateSubmittedDesc.click();
				for (int j = 0; j <= DateSubmitedList.size() - 1; j++) {
					String datetext3 = DateSubmitedList.get(j).getText();

					date3.add(datetext3);
				}

				SortingDateSubmittedDesc.click();
				SortingDateSubmittedAsc.click();
				SortingDateSubmittedDesc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= DateSubmitedList.size() - 1; j++) {
					String datetext4 = DateSubmitedList.get(j).getText();
					date4.add(datetext4);
				}
				return date3.equals(date4);
			}

			// sorting date modified

			if (datemodified == 1) {
				ArrayList<String> date1 = new ArrayList<String>();
				ArrayList<String> date2 = new ArrayList<String>();
				SortingDateModifiedAsc.click();
				for (int j = 0; j <= DateModifiedList.size() - 1; j++) {
					String datetext = DateModifiedList.get(j).getText();

					date1.add(datetext);

				}

				SortingDateModifiedAsc.click();
				SortingDateModifiedDesc.click();
				SortingDateModifiedAsc.click();

				WaitClass.waitForTime(2000);
				for (int j = 0; j <= DateModifiedList.size() - 1; j++) {
					String datetext1 = DateModifiedList.get(j).getText();

					date2.add(datetext1);
				}

				return date1.equals(date2);
			}
			if (datemodified == 2) {
				ArrayList<String> date3 = new ArrayList<String>();
				ArrayList<String> date4 = new ArrayList<String>();
				SortingDateModifiedDesc.click();
				for (int j = 0; j <= DateModifiedList.size() - 1; j++) {
					String datetext3 = DateModifiedList.get(j).getText();

					date3.add(datetext3);
				}

				SortingDateModifiedDesc.click();
				SortingDateModifiedAsc.click();
				SortingDateModifiedDesc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= DateModifiedList.size() - 1; j++) {
					String datetext4 = DateModifiedList.get(j).getText();
					date4.add(datetext4);
				}
				return date3.equals(date4);
			}

			// sorting date approved

			if (dateapproved == 1) {
				ArrayList<String> date1 = new ArrayList<String>();
				ArrayList<String> date2 = new ArrayList<String>();
				SortingDateApprovedAsc.click();
				for (int j = 0; j <= DateApprovedList.size() - 1; j++) {
					String datetext = DateApprovedList.get(j).getText();

					date1.add(datetext);

				}

				SortingDateApprovedAsc.click();
				SortingDateApprovedDesc.click();
				SortingDateApprovedAsc.click();

				WaitClass.waitForTime(2000);
				for (int j = 0; j <= DateApprovedList.size() - 1; j++) {
					String datetext1 = DateApprovedList.get(j).getText();

					date2.add(datetext1);
				}

				return date1.equals(date2);
			}
			if (dateapproved == 2) {
				ArrayList<String> date3 = new ArrayList<String>();
				ArrayList<String> date4 = new ArrayList<String>();
				SortingDateApprovedDesc.click();
				for (int j = 0; j <= DateApprovedList.size() - 1; j++) {
					String datetext3 = DateApprovedList.get(j).getText();

					date3.add(datetext3);
				}

				SortingDateApprovedDesc.click();
				SortingDateApprovedAsc.click();
				SortingDateApprovedDesc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= DateApprovedList.size() - 1; j++) {
					String datetext4 = DateApprovedList.get(j).getText();
					date4.add(datetext4);
				}
				return date3.equals(date4);
			}

			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - SortingPartnerGames : " + e);
			return false;
		}
	}

	/* Partner | Game - Status */

	/**
	 * Description- Verify if Partner is able to click on edit to change the status
	 * to Submit for approval to get approval from ADMIN.
	 * 
	 * @return- true - if Partner is able to click on edit to change the status to
	 *          Submit for approval to get approval from ADMIN.
	 * 
	 */
	public boolean ChangeStatus() {
		try {

			SelectfilterStatus.click();
			WaitClass.waitForTime(1000);
			SearchDropdownIndevelopment.click();
			WaitClass.waitForTime(2000);
			Actions actiona = new Actions(driver);
			actiona.moveToElement(GamenameHeader).click().perform();
			Actionbutton.click();

			Select sel = new Select(SetStatusas);
			sel.selectByValue("2");

			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - ChangeStatus : " + e);
			return false;
		}
	}

	/**
	 * Description- Verify if Partner can click on update button after change the
	 * status to Submit for approval .
	 * 
	 * @return- true - if Partner can click on update button after change the status
	 *          to Submit for approval .
	 * 
	 * 
	 */
	public boolean Updatebutton() {
		try {
			Utility.javaScriptClick(UpdateButtoneditgame, driver);

			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - Updatebutton : " + e);
			return false;
		}
	}

	/**
	 * Description- Verify if partner clicks on Approved game, he can edit game
	 * details except for approved assets. He can change the status to
	 * in-development /Submit for approval status.
	 *
	 * @return- true - if partner clicks on Approved game, he can edit game details
	 *          except for approved assets. He can change the status to
	 *          in-development /Submit for approval status.
	 */
	public boolean ChangeStatusApprovedGame() {
		try {

			SelectfilterStatus.click();
			WaitClass.waitForTime(1000);
			SearchDropdownApprovedGame.click();
			WaitClass.waitForTime(2000);
			Actions actiona = new Actions(driver);
			actiona.moveToElement(GamenameHeader).click().perform();
			Actionbutton.click();

			Select sel = new Select(SetStatusas);
			sel.selectByValue("2");

			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class - Partner_Games_Page, Method - ChangeStatusApprovedGame : " + e);
			return false;
		}
	}

}
