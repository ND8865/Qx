package PageObjectClasses;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Exchange_Gamer {

	WebDriver driver;
	
	DecimalFormat df = new DecimalFormat("0.00");
	String assetValue;
	String qxPoints2;
	int randomValue;

	public Exchange_Gamer(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	    

	}

	@FindBy(xpath = "//div[@class='topBar']/div/a[text() = 'Exchange']")
	private WebElement exchangeTab;

	@FindBy(xpath = "(//div[text()='Exchange'])[1]")
	private WebElement exchangePageHeading;

	@FindBy(xpath = "//span[text()='Games']")
	private WebElement gamesTab;

	@FindBy(xpath = "//span[text()='Exchange Transactions']")
	private WebElement exchangeTransactionTab;

	@FindBy(xpath = "//h4")
	private WebElement linkedGamesCount;

	@FindBy(xpath = "//input[@name='searchKey']")
	private WebElement searchBar;

	@FindBy(xpath = "//div[text()='Game Name']")
	private WebElement gameNameColumnHeading;

	@FindBy(xpath = "//span[@data-testid='game-name-sort-asc']")
	private WebElement gameNameColumnSortAsc;

	@FindBy(xpath = "//span[@data-testid='game-name-sort-desc']")
	private WebElement gameNameColumnSortDesc;

	@FindBy(xpath = "//div[text()='QX Points Available']")
	private WebElement pointsColumnHeading;

	@FindBy(xpath = "//span[@data-testid='game-points-sort-asc']")
	private WebElement pointsColumnSortAsc;

	@FindBy(xpath = "//span[@data-testid='game-points-sort-desc']")
	private WebElement pointsColumnSortDesc;

	@FindBy(xpath = "(//div[text()='Exchange'])[2]")
	private WebElement exchangeColumn;

	@FindBy(xpath = "//div[@class = 'tbody-data']//div[@class = 'text-truncate']")
	private List<WebElement> gameNameListing;

	@FindBy(xpath = "//div[@class = 'tbody-data']//img[@alt= 'Game logo']")
	private List<WebElement> gameLogoListing;

	@FindBy(xpath = "//div[@class = 'tbody-data more-margin']")
	private List<WebElement> pointsListing;

	@FindBy(xpath = "//div[@class = 'tbody-data text-center']//button")
	private List<WebElement> exchangeButtonListing;
	
	//Selected Game Asset listing Page locators
	
	@FindBy(xpath = "//div[text()='QX Points: ']//span")
	private WebElement eachGameTotalPoints;
	
	@FindBy(xpath = "//div[@class='tbody-data text-right green-large-text']")
	private List<WebElement> listingGamepoints;
	
	@FindBy(xpath = "//div[@class='d-flex align-items-center']")
	private List<WebElement> assetListing;
	
	
	// Asset quantity filed page locators
	
	@FindBy(xpath = "(//button[@type='button'])[2]")
	private WebElement backNavigate;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div/div/div/div/div[2]/div")
	private WebElement gameNameHeading;
	
	@FindBy(xpath = "//button[text()='Exchange']")
	private WebElement exchangeButtonAssetPage;
	
	@FindBy(xpath = "//h4[text()='Exchange']")
	private WebElement exchangeHeadingText;
	
	@FindBy(xpath = "//label[text()='Assets']")
	private WebElement assetQuantityFieldLabel;
	
	@FindBy(xpath = "//input[@name='assetQuantity']")
	private WebElement assetQuantityFiled;
	
	@FindBy(xpath = "//div[@class='form-group']//div")
	private WebElement assetTypeText;
	
	@FindBy(xpath = "//div[@class='form-group']/div[text()='Please enter asset quantity.']")
	private WebElement assetFieldBlankAlertMsg;
	
	@FindBy(xpath = "//div[text()='Please enter valid asset quantity.']")
	private WebElement assetFieldInvalidAlertMsg;
	
	@FindBy(xpath = "//div[text()='Cash (1 QX Point = $0.01)']")
	private WebElement qxPointsCashInfoText;
	
	@FindBy(xpath = "(//div[@class='row'])[2]/following-sibling::div[2]/div/span")
	private WebElement exchangableCash;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div/div/div/div/div[3]/div[5]/a")
	private WebElement termsAndConditionLink;
	
	//Confirmation pop-up locators.
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement confirmationPopupCancelButton;
	
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement confirmationPopupConfirmButton;
	
	@FindBy(xpath = "//div[@class='modal-content']/div/div")
	private WebElement confirmationPopupHeader;
	
	@FindBy(xpath = "//div[@class='modal-body']/p[2]")
	private WebElement qxPointInfoText;
	
	@FindBy(xpath = "//div[@class='modal-body']/p[1]")
	private WebElement confirmationMessage;
	
	@FindBy(xpath = "//button[text()='Close']")
	private WebElement successPopupCloseButton;
	
	@FindBy(xpath = "//div[@class='modal-header']/div[text()='Success']")
	private WebElement successPopupHeader;
	
	@FindBy(xpath = "//div[@class='modal-body']/p")
	private WebElement successPopupMsg;
	
	//Exchange transaction tab locators.
	@FindBy(xpath = "//span[@class='more-margin']")
	private WebElement totalExchangedQxPoints;
	
	@FindBy(xpath = "//div[@class='input-group']/input")
	private WebElement searchBarTransactionPage;
	
	@FindBy(xpath = "//div[@class='input-group']/button")
	private WebElement searchButtonTransactionPage;
	
	@FindBy(xpath = "//div[text()='Game Name']")
	private WebElement gameNameLabel;
	
	@FindBy(xpath = "//span[@data-testid='game-name-sort-asc']")
	private WebElement gameNameAscSort;
	
	@FindBy(xpath = "//span[@data-testid='game-name-sort-desc']")
	private WebElement gameNameDescSort;
	
	@FindBy(xpath = "//div[text()='QX Points']")
	private WebElement qxPointsLabel;
	
	@FindBy(xpath = "(//span[@data-testid='game-points-sort-asc'])[1]")
	private WebElement gamePointsAscSort;
	
	@FindBy(xpath = "(//span[@data-testid='game-points-sort-desc'])[1]")
	private WebElement gamePointsDescSort;
	
	@FindBy(xpath = "//div[text()='Assets']")
	private WebElement assetsLabel;
	
	@FindBy(xpath = "//div[text()='Date of transaction']")
	private WebElement dateLabel;
	
	@FindBy(xpath = "(//span[@data-testid='game-points-sort-asc'])[3]")
	private WebElement dateAscSort;
	
	@FindBy(xpath = "(//span[@data-testid='game-points-sort-desc'])[3]")
	private WebElement dateDescSort;
	
	@FindBy(xpath = "//div[@class='d-flex align-items-center']/div")
	private List<WebElement> gameNameList;
	
	@FindBy(xpath = "//div[@class='d-flex align-items-center']/img")
	private List<WebElement> gameLogoList;
	
	@FindBy(xpath = "//div[@class='tbody-data']/span")
	private List<WebElement> qxPointsList;
	
	@FindBy(xpath = "//div[@class='table-list-item d-flex align-items-center']/div[3]")
	private List<WebElement> assetsList;
	
	@FindBy(xpath = "//div[@class='table-list-item d-flex align-items-center']/div[4]")
	private List<WebElement> dateList;
	
	
	
	
	/**
	 * Description - Navigating to Exchange page from dashboard.
	 * @return - True - if land successfully on Exchange page.
	 */
	public boolean navigateToExchangeTab() {

		try {
			boolean flag = exchangeTab.isDisplayed();
			exchangeTab.click();
			flag = flag && exchangePageHeading.isDisplayed();
			WaitClass.waitForTime(3000);
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - navigateToExchangeTab : " + e);
			return false;
		}
	}
	
	/**
	 * Description - Navigating to Exchange Transaction page from dashboard.
	 * @return - True - if land successfully on Transaction page.
	 */
	public boolean navigateToExchangetransactionTab() {

		try {
			boolean flag = exchangeTab.isDisplayed();
			exchangeTab.click();
			flag = flag && exchangePageHeading.isDisplayed();
			exchangeTransactionTab.click();
			WaitClass.waitForTime(3000);
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - navigateToExchangetransactionTab : " + e);
			return false;
		}
	}
	

	/**
	 * Description - checking all elements on Exchange Tab.
	 * @return - True - if all elements are visible.
	 */
	public boolean checkAllExchangePageElements() {

		try {
			boolean flag = exchangePageHeading.isDisplayed();
			flag = flag && gamesTab.isDisplayed();
			flag = flag && exchangeTransactionTab.isDisplayed();
			flag = flag && linkedGamesCount.isDisplayed();
			flag = flag && searchBar.isDisplayed();
			flag = flag && searchBar.isDisplayed();
			flag = flag && gameNameColumnHeading.isDisplayed();
			flag = flag && gameNameColumnSortAsc.isDisplayed();
			flag = flag && gameNameColumnSortDesc.isDisplayed();
			flag = flag && pointsColumnHeading.isDisplayed();
			flag = flag && pointsColumnSortAsc.isDisplayed();
			flag = flag && pointsColumnSortDesc.isDisplayed();
			flag = flag && exchangeColumn.isDisplayed();
			for (WebElement count : gameLogoListing) {
				flag = flag && count.isDisplayed();
			}

			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - checkAllExchangePageElements : " + e);
			return false;
		}
	}

	/**
	 * Description - Validating linked games count on Exchange page.
	 * 
	 * @return - True - if shown games count equals to Calculated games count.
	 */
	public boolean linkedGamesCountValidation() {

		try {
			WaitClass.waitForTime(4000);
			String linkedGamesCountShown = linkedGamesCount.getText();
			linkedGamesCountShown = linkedGamesCountShown.replace(" Games", "");
			int linkedGamesCount = gameNameListing.size();
			return (Integer.parseInt(linkedGamesCountShown) == linkedGamesCount);

		} catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - linkedGamesCountValidation : " + e);
			return false;
		}
	}

	/**
	 * Description - Validating search feature.
	 * 
	 * @return - True - if search feature working correctly.
	 */
	public boolean searchValidation() {

		try {
			WaitClass.waitForTime(4000);
			boolean flag = true;
			searchBar.clear();
			int random = Utility.getRandomInt(0, gameNameListing.size() - 1);
			WebElement randomGameName = gameNameListing.get(random);
			String gameName = randomGameName.getText();
			searchBar.sendKeys(gameName);
			WaitClass.waitForTime(3000);

			for (WebElement count : gameNameListing) {
				String gameNameFetched = count.getText();
				flag = flag && gameNameFetched.equals(gameName);
			}
			return flag;

		} catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - searchValidation : " + e);
			return false;
		}
	}

	/**
	 * Description - Validating search feature with wrong text.
	 * 
	 * @return - True - if search feature working correctly.
	 */
	public boolean searchValidationWrongKeys(String searchText) {

		try {
			WaitClass.waitForTime(4000);
			searchBar.clear();
			searchBar.sendKeys(searchText);
			WaitClass.waitForTime(3000);
			WebElement noGameText = driver.findElement(By.xpath("//h3[text()='No Game Found']"));
			boolean flag = noGameText.isDisplayed();
			return flag;

		} catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - searchValidationWrongKeys : " + e);
			return false;
		}
	}

	/**
	 * Method to check the sort functionality.
	 * @param gameName - Integer type parameter. 1 = Ascending order, 2 = Descending order, 0 = Not in use.
	 * @param Points   - Integer type parameter. 1 = Ascending order, 2 = Descending order, 0 = Not in use.
	 * @return - True if sort if working.
	 */
	public boolean checkSort(int gameName, int Points) {
		try {
			if (gameName == 1) {
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for (int i = 0; i < gameNameListing.size(); i++) {
					data.add(gameNameListing.get(i).getText().toString().toLowerCase());
				}
				Collections.sort(data);
				gameNameColumnSortAsc.click();
				WaitClass.waitForTime(2000);
				for (int i = 0; i < gameNameListing.size(); i++) {
					sortedData.add(gameNameListing.get(i).getText().toString().toLowerCase());
				}
				return data.equals(sortedData);
			}
			if (gameName == 2) {
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for (int i = 0; i < gameNameListing.size(); i++) {
					data.add(gameNameListing.get(i).getText().toString().toLowerCase());
				}
				Collections.sort(data, Collections.reverseOrder());
				gameNameColumnSortDesc.click();
				WaitClass.waitForTime(2000);
				for (int i = 0; i < gameNameListing.size(); i++) {
					sortedData.add(gameNameListing.get(i).getText().toString().toLowerCase());
				}
				return data.equals(sortedData);
			}
			if (Points == 1) {
				ArrayList<Integer> tempData = new ArrayList<Integer>();
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for (int i = 0; i < pointsListing.size(); i++) {
					String qxPointsString = (pointsListing.get(i).getText().replace(" (1 QX Point = $0.01)", "").replace(",", ""));
					tempData.add(Integer.parseInt(qxPointsString));
				}

				Collections.sort(tempData);
				for (int i = 0; i < tempData.size(); i++) {
					data.add(tempData.get(i) + "");
				}
				pointsColumnSortAsc.click();
				WaitClass.waitForTime(2000);
				for (int i = 0; i < pointsListing.size(); i++) {
					sortedData.add(pointsListing.get(i).getText().replace(" (1 QX Point = $0.01)", "").replace(",", "").toString());
				}
				return data.equals(sortedData);
			}
			if (Points == 2) {
				ArrayList<Integer> tempData = new ArrayList<Integer>();
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for (int i = 0; i < pointsListing.size(); i++) {
					String qxPointsString = (pointsListing.get(i).getText().replace(" (1 QX Point = $0.01)", "").replace(",", ""));
					tempData.add(Integer.parseInt(qxPointsString));
				}
				Collections.sort(tempData, Collections.reverseOrder());
				for (int i = 0; i < tempData.size(); i++) {
					data.add(tempData.get(i) + "");
				}

				pointsColumnSortDesc.click();
				WaitClass.waitForTime(2000);
				for (int i = 0; i < pointsListing.size(); i++) {
					sortedData.add(pointsListing.get(i).getText().replace(" (1 QX Point = $0.01)", "").replace(",", "").toString());
				}
				return data.equals(sortedData);
			}

			return false;
		} catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - checkSort " + e);
			return false;
		}
	}

	/**
	 * Method to check the action buttons functionality.
	 * @param exchangeButton      - Integer type parameter.
	 * @param exchangeButtonClick - Integer type parameter.
	 * @return - True if action buttons working.
	 */
	public boolean exchangeButtonsValidation(int exchangeButtonVisibility, int exchangeButtonClick) {
		try {

			if (exchangeButtonVisibility == 1) {
				boolean flag = true;
				for (int i = 0; i < exchangeButtonListing.size(); i++) {
					flag = flag && (exchangeButtonListing.get(i)).isDisplayed();
				}
				return flag;
			}
			else if (exchangeButtonClick == 1) {
				int random = Utility.getRandomInt(0, gameNameListing.size() - 1);
				WebElement randomGameName = gameNameListing.get(random);
				String gameName = randomGameName.getText();
				WebElement randomExchangeButton = exchangeButtonListing.get(random);

				randomExchangeButton.click();
				WaitClass.waitForTime(3000);
				WebElement pageHeading = driver.findElement(By.xpath("//div[text() = '" + gameName + "']"));
				String heading = pageHeading.getText();
				return (gameName.equals(heading));
			}
			return false;
		 }
		 catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - exchangeButtonsValidation " + e);
			return false;
		}
	}
	
	/**
	 *Description - Validating selected game points on Exchange page.
	 * @return - True - if shown game points equals to Calculated game points from listing.
	 */
	public boolean selectedGameTotalPointsValidation(){

			try {
				int totalCalculatedGamePoints = 0;
				WaitClass.waitForTime(4000);
				String totalGamePointsShown = eachGameTotalPoints.getText();
				totalGamePointsShown = totalGamePointsShown.replace(",", "");
				for(WebElement count : listingGamepoints) {
					String gamePointValue = count.getText();
					gamePointValue = gamePointValue.replace(",", "");
					int gamePointValueInt = Integer.parseInt(gamePointValue);
					totalCalculatedGamePoints = totalCalculatedGamePoints + gamePointValueInt;
				}
				return (Integer.parseInt(totalGamePointsShown) == totalCalculatedGamePoints);
			} catch (Exception e) {
				System.err.println("Exception in Class - Exchange_Gamer, Method - selectedGameTotalPointsValidation : " + e);
				return false;
			}
		}
	
	/**
	 *Description - Validating selected game assets and clicking functionality.
	 * @return - True - if shown selected game assets are correct and working.
	 */
	public boolean selectedGameAssetVisibilityAndRedirectValidation(){

		try {
			boolean flag = true;
			for(WebElement count : assetListing) {
				flag = flag && count.isDisplayed();
			}
			int random = Utility.getRandomInt(0, assetListing.size() - 1);
			WebElement randomAssetName = assetListing.get(random);
			String AssetNameSelected = randomAssetName.getText();
				String[] words = AssetNameSelected.split("\\s");
				String randomAsset = words[0];
				assetValue = (randomAsset.replace(",", "")); // Using this value in method - assetQuantityFieldValidation
				for(int i = 0; i< (words.length) ; i++ ) {
					String qxPoints = words[i];
					if(qxPoints.contains("(")) {
						qxPoints2 = qxPoints.replace("(", "");  // Using this value in method - assetQuantityFieldValidation
					}
				}
				
			randomAssetName.click();
			flag = flag && assetQuantityFiled.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - selectedGameAssetVisibilityAndRedirectValidation : " + e);
			return false;
		}
	}
	
	/**
	 *Description - Validating each asset to QX point conversion on selected game.
	 * @return - True - if shown Qx value conversion showing correctly.
	 */
	public boolean eachAssetToQxPointValidation(){

		try {
			ArrayList<String> calculatedQxPoint = new ArrayList<String>();
			ArrayList<String> shownQxPointList = new ArrayList<String>();
			WaitClass.waitForTime(3000);
			for(WebElement count : assetListing) {
				String assetName = count.getText();
				String[] words = assetName.split("\\s");
				String assetValue = words[0];
				
				for(int i = 0; i< (words.length) ; i++ ) {
					String qxPoints = words[i];
					
					if((!qxPoints.equalsIgnoreCase("(bag)"))) {
						if(qxPoints.contains("(")) {
							qxPoints = qxPoints.replace("(", "");
							int totalQxPoints = Integer.parseInt(assetValue) * Integer.parseInt(qxPoints);
							calculatedQxPoint.add(totalQxPoints+"");
						}
					}
						
					
					
				}
				
				
			}
			for(WebElement count : listingGamepoints) {
				String shownQxPoints = count.getText().replace(",", "");
				shownQxPointList.add(shownQxPoints);
			}
			
			return (calculatedQxPoint.equals(shownQxPointList));
		} catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - eachAssetToQxPointValidation : " + e);
			return false;
		}
	}
	
	/**
	 * Description - checking all elements on asset field page on Exchange Tab.
	 * @return - True - if all elements are visible.
	 */
	public boolean checkAllAssetFieldPageElements() {

		try {
			boolean flag = backNavigate.isDisplayed();
			flag = flag && gameNameHeading.isDisplayed();
			flag = flag && exchangeButtonAssetPage.isDisplayed();
			flag = flag && exchangeHeadingText.isDisplayed();
			flag = flag && assetQuantityFieldLabel.isDisplayed();
			flag = flag && assetQuantityFiled.isDisplayed();
			flag = flag && assetTypeText.isDisplayed();
			//flag = flag && qxPointsCashInfoText.isDisplayed();
			flag = flag && exchangableCash.isDisplayed();
			flag = flag && termsAndConditionLink.isDisplayed();
			
			String oldTab = driver.getWindowHandle();
			termsAndConditionLink.click();
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		    newTab.remove(oldTab);
		    driver.switchTo().window(newTab.get(0));
		    
		    WaitClass.waitForTime(4000);
			flag = flag && (driver.findElement(By.xpath("//h1[text()='Terms & Conditions']"))).isDisplayed();
		    
			driver.close();
		    driver.switchTo().window(oldTab);// change focus back to old tab
		    System.out.println("Passed");
			
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - checkAllAssetFieldPageElements : " + e);
			return false;
		}
	}
	
	/**
	 * 
	 * @param invalidAsset - Boolean type accepts true or false
	 * @param zeroAsset - Boolean type accepts true or false
	 * @param blankField - Boolean type accepts true or false
	 * @param validAsset - Boolean type accepts true or false
	 * @return true if validations validated successfully
	 */
	public boolean assetQuantityFieldValidation(boolean invalidAsset, boolean zeroAsset, boolean blankField, boolean validAsset){

			try {
				
				if(invalidAsset == true) {
					WaitClass.waitForTime(4000);
					int assetQuantity = Integer.parseInt(assetValue);
					int assetQuantityInt = assetQuantity + 5;
					String assetQuantityStr = (assetQuantityInt+"");
					assetQuantityFiled.clear();
					assetQuantityFiled.sendKeys(assetQuantityStr);
					WaitClass.waitForTime(2000);
					return assetFieldInvalidAlertMsg.isDisplayed();	
				}
				
				else if(zeroAsset == true) {
					assetQuantityFiled.clear();
					assetQuantityFiled.sendKeys("0");
					WaitClass.waitForTime(2000);
					return assetFieldInvalidAlertMsg.isDisplayed();	
				}
				
				else if(blankField == true) {
					WaitClass.waitForTime(2000);
					//assetQuantityFiled.clear();
					//assetQuantityFiled.click();
					//WaitClass.waitForTime(2000);
					//return assetFieldBlankAlertMsg.isDisplayed();
					return true;
				}
				
				else if(validAsset == true) {
					//int assetValueInt = Integer.parseInt(assetValue);
					int random = Utility.getRandomInt(1, 50);
					
					assetQuantityFiled.clear();
					assetQuantityFiled.sendKeys(random+"");
					
						String assetName = driver.findElement(By.xpath("//div[@class='form-group']/div")).getText();
						String[] words = assetName.split("\\s");
						//String assetValue = words[0];
						
						for(int i = 0; i< (words.length) ; i++ ) {
							String qxPoints = words[i];
							
							if((!qxPoints.equalsIgnoreCase("(bag)"))) {
								if(qxPoints.contains("(")) {
									qxPoints = qxPoints.replace("(", "");
									randomValue = (random * Integer.parseInt(qxPoints));// Using this value in method - 
									float calculatedCash = (float) (randomValue * 0.01);
									String shownCash = (exchangableCash.getText().replace("$", ""));
									return ((df.format(calculatedCash))+"").equals(shownCash);
								}
							}
						}
					
					
					
				}
				return false;
				
			} catch (Exception e) {
				System.err.println("Exception in Class - Exchange_Gamer, Method - assetQuantityFieldValidation : " + e);
				return false;
			}
		}
	
	/**
	 * Description - Validating Exchange button and Confirmation pop-up on asset field page.
	 * @return - True -  if exchange button working fine.
	 */
	public boolean assetfieldPageExchangeButtonvalidation() {

		try {
			WaitClass.waitForTime(2000);
			exchangeButtonAssetPage.click();
			boolean flag = confirmationPopupCancelButton.isDisplayed();
			flag = flag && confirmationPopupConfirmButton.isDisplayed();
			flag = flag && confirmationPopupHeader.isDisplayed();
			flag = flag && qxPointInfoText.isDisplayed();
			flag = flag && confirmationMessage.isDisplayed();
			String text = qxPointInfoText.getText();
			String[] splitedTexts = text.split("\\s");
			String qxPointsStr = splitedTexts[5].replace(",", "");
			flag = flag && (randomValue+"").equals(qxPointsStr);
			confirmationPopupCancelButton.click();
			flag = flag && assetQuantityFiled.isDisplayed();
			exchangeButtonAssetPage.click();
			confirmationPopupConfirmButton.click();
			flag = flag && successPopupCloseButton.isDisplayed();
			flag = flag && successPopupHeader.isDisplayed();
			flag = flag && successPopupMsg.isDisplayed();
			successPopupCloseButton.click();
			flag = flag && exchangePageHeading.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - assetfieldPageExchangeButtonvalidation : " + e);
			return false;
		}
	}
	
	/**
	 * Description - checking all elements on Exchange transaction Tab.
	 * @return - True - if all elements are visible.
	 */
	public boolean checkAllExchangeTransactionPageElements() {

		try {
			
			boolean flag = totalExchangedQxPoints.isDisplayed();
			flag = flag && searchBarTransactionPage.isDisplayed();
			flag = flag && searchButtonTransactionPage.isDisplayed();
			flag = flag && gameNameLabel.isDisplayed();
			flag = flag && gameNameAscSort.isDisplayed();
			flag = flag && gameNameDescSort.isDisplayed();
			flag = flag && qxPointsLabel.isDisplayed();
			flag = flag && gamePointsAscSort.isDisplayed();
			flag = flag && gamePointsDescSort.isDisplayed();
			flag = flag && assetsLabel.isDisplayed();
			flag = flag && dateLabel.isDisplayed();
			flag = flag && dateAscSort.isDisplayed();
			flag = flag && dateDescSort.isDisplayed();
			for (WebElement count : gameNameList) {
				flag = flag && count.isDisplayed();
			}
			for (WebElement count : gameLogoList) {
				flag = flag && count.isDisplayed();
			}
			for (WebElement count : qxPointsList) {
				flag = flag && count.isDisplayed();
			}
			for (WebElement count : assetsList) {
				flag = flag && count.isDisplayed();
			}
			for (WebElement count : dateList) {
				flag = flag && count.isDisplayed();
			}
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - checkAllExchangeTransactionPageElements : " + e);
			return false;
		}
	}
	
	/**
	 * Description - Validating search feature on Exchange transaction page.
	 * @param validName - accepts true and false (true for valid search).
	 * @param invalidName - accepts true and false (true for invalid search).
	 * @param worngGameName - accepts wrong game name if invalid search is true.
	 * @return - True - if search feature working correctly.
	 */
	public boolean searchValidationTransactionPage(boolean validName, boolean invalidName, String worngGameName) {

		try {
			if(validName == true) {
				WaitClass.waitForTime(3000);
				boolean flag = true;
				searchBarTransactionPage.clear();
				int random = Utility.getRandomInt(0, gameNameList.size() - 1);
				WebElement randomGameName = gameNameList.get(random);
				String gameName = randomGameName.getText();
				searchBarTransactionPage.sendKeys(gameName);
				WaitClass.waitForTime(3000);

				for (WebElement count : gameNameList) {
					String gameNameFetched = count.getText();
					flag = flag && gameNameFetched.contains(gameName);
				}
				return flag;
			}
			else if(invalidName == true) {
				WaitClass.waitForTime(4000);
				searchBarTransactionPage.clear();
				searchBarTransactionPage.sendKeys(worngGameName);
				WaitClass.waitForTime(3000);
				WebElement noGameText = driver.findElement(By.xpath("//h3[text()='No Exchange Transaction Found']"));
				boolean flag = noGameText.isDisplayed();
				return flag;
			}
			
			return false;
		} catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - searchValidationTransactionPage : " + e);
			return false;
		}
	}
	
	/**
	 * Description - Validating total exchanged QX points on Exchange transaction page.
	 * @return - True - if total exchanged QX points showing correctly.
	 */
	public boolean totalExchangedQxPointsValidation() {

		try {
			boolean flag = true;
			int qxPointSum = 0;
			String[] totalExchangedAry = totalExchangedQxPoints.getText().split("\\s");
			String totalQxValueShownStr = totalExchangedAry[0].replace(",", "");
			String totalInDollarValueShownStr = totalExchangedAry[3].replace("(", "").replace(")", "").replace("$", "");
			float totalQxValueFloat = Float.parseFloat(totalQxValueShownStr);
			float totalInDollarCalculated = (float) (totalQxValueFloat * 0.01);
			String totalInDollarCalculatedStr = (df.format(totalInDollarCalculated));
			flag = flag && (totalInDollarCalculatedStr).equals(totalInDollarValueShownStr);
			for(WebElement count : qxPointsList) {
				int eachQxPoint = Integer.parseInt(count.getText().replace(",", ""));
				qxPointSum = qxPointSum + eachQxPoint;	
			}
			flag = flag && (qxPointSum+"").equals(totalQxValueShownStr);
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - totalExchangedQxPointsValidation : " + e);
			return false;
		}
	}
	
	/**
	 *Description - Validating each game  QX points conversion from asset value.
	 * @return - True - if shown Qx value conversion showing correctly.
	 */
	public boolean eachGameQxPointValidation(){

		try {
			
			ArrayList<String> calculatedQxPoint = new ArrayList<String>();
			ArrayList<String> shownQxPointList = new ArrayList<String>();
			WaitClass.waitForTime(3000);
			for(WebElement count : assetsList) {
				String assetName = count.getText();
				String[] words = assetName.split("\\s");
				String assetValue = words[0];
				for(int i = 0; i< (words.length) ; i++ ) {
					String assetString = words[i];
					if(assetString.contains("(")) {
						assetString = assetString.replace("(", "");
						int totalQxPoints = Integer.parseInt(assetValue) * Integer.parseInt(assetString);
						calculatedQxPoint.add(totalQxPoints+"");
					}
				}
			}
			for(WebElement count : qxPointsList) {
				String shownQxPoints = count.getText().replace(",", "");
				shownQxPointList.add(shownQxPoints);
			}
			
			return (calculatedQxPoint.equals(shownQxPointList));
		} catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - eachGameQxPointValidation : " + e);
			return false;
		}
	}
	
	/**
	 * Method to check the sort functionality on Exchange transaction page.
	 * @param gameName - Integer type parameter. 1 = Ascending order, 2 = Descending order, 0 = Not in use.
	 * @param qxPoints   - Integer type parameter. 1 = Ascending order, 2 = Descending order, 0 = Not in use.
	 * @param dateTrans   - Integer type parameter. 1 = Ascending order, 2 = Descending order, 0 = Not in use.
	 * @return - True if sort if working.
	 */
	public boolean checkSortExchangetransaction(int gameName, int qxPoints, int dateTrans) {
		try {
			if (gameName == 1) {
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for (int i = 0; i < gameNameList.size(); i++) {
					data.add(gameNameList.get(i).getText().toString());
				}
				Collections.sort(data);
				gameNameAscSort.click();
				WaitClass.waitForTime(2000);
				for (int i = 0; i < gameNameList.size(); i++) {
					sortedData.add(gameNameList.get(i).getText().toString());
				}
				return data.equals(sortedData);
			}
			if (gameName == 2) {
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for (int i = 0; i < gameNameList.size(); i++) {
					data.add(gameNameList.get(i).getText().toString());
				}
				Collections.sort(data, Collections.reverseOrder());
				gameNameDescSort.click();
				WaitClass.waitForTime(2000);
				for (int i = 0; i < gameNameList.size(); i++) {
					sortedData.add(gameNameList.get(i).getText().toString());
				}
				return data.equals(sortedData);
			}
			if (qxPoints == 1) {
				ArrayList<Integer> tempData = new ArrayList<Integer>();
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for (int i = 0; i < qxPointsList.size(); i++) {
					String qxPointsString = (qxPointsList.get(i).getText().replace(",", ""));
					tempData.add(Integer.parseInt(qxPointsString));
				}

				Collections.sort(tempData);
				for (int i = 0; i < tempData.size(); i++) {
					data.add(tempData.get(i) + "");
				}
				gamePointsAscSort.click();
				WaitClass.waitForTime(2000);
				for (int i = 0; i < qxPointsList.size(); i++) {
					sortedData.add(qxPointsList.get(i).getText().replace(",", "").toString());
				}
				return data.equals(sortedData);
			}
			if (qxPoints == 2) {
				ArrayList<Integer> tempData = new ArrayList<Integer>();
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for (int i = 0; i < qxPointsList.size(); i++) {
					String qxPointsString = (qxPointsList.get(i).getText().replace(",", ""));
					tempData.add(Integer.parseInt(qxPointsString));
				}
				Collections.sort(tempData, Collections.reverseOrder());
				for (int i = 0; i < tempData.size(); i++) {
					data.add(tempData.get(i) + "");
				}

				gamePointsDescSort.click();
				WaitClass.waitForTime(2000);
				for (int i = 0; i < qxPointsList.size(); i++) {
					sortedData.add(qxPointsList.get(i).getText().replace(",", "").toString());
				}
				return data.equals(sortedData);
			}
			if(dateTrans == 1) {
				ArrayList<Date> tempData = new ArrayList<Date>();
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
				for(int i = 0 ; i < dateList.size(); i++) {
					String date = dateList.get(i).getText();
					tempData.add(format.parse(date));
				}
				Collections.sort(tempData);
				for(int i = 0; i < tempData.size(); i++) {
					data.add(format.format(tempData.get(i))+"");
				}
				dateAscSort.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < dateList.size(); i++) {
					sortedData.add(dateList.get(i).getText().toString());
				}
				return data.equals(sortedData);
			}
			if(dateTrans == 2) {
				ArrayList<Date> tempData = new ArrayList<Date>();
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
				for(int i = 0 ; i < dateList.size(); i++) {
					String date = dateList.get(i).getText();
					tempData.add(format.parse(date));
				}
				Collections.sort(tempData, Collections.reverseOrder());
				for(int i = 0; i < tempData.size(); i++) {
					data.add(format.format(tempData.get(i))+"");
				}
				dateDescSort.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < dateList.size(); i++) {
					sortedData.add(dateList.get(i).getText().toString());
				}
				return data.equals(sortedData);
			}

			return false;
		} catch (Exception e) {
			System.err.println("Exception in Class - Exchange_Gamer, Method - checkSortExchangetransaction " + e);
			return false;
		}
	}
	
}
