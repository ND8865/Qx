package PageObjectClasses;

import java.net.URI;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.command.WaitContainerResultCallback;

import UtilityClass.WaitClass;

public class Offers_Admin {

	private WebDriver driver;

	public Offers_Admin(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//a[contains(@href, 'offers')]//parent::li")
	private WebElement offersTab;
	
	@FindBy(xpath = "//h4[@class = 'page-heading']")
	private WebElement offersPageHeading;

	@FindBy(xpath = "//div[@class = 'table-head']")
	private WebElement offersTableHeaders;
	
	@FindBy(xpath = "//input[@name = 'searchKey']")
	private WebElement searchBar;

	@FindBy(xpath = "//label[text() = 'Status']//following-sibling::div/button")
	private WebElement statusDropdown;
	
	@FindBy(xpath = "//label[@for = 'custom-switch']")
	private WebElement enabledLabel;
	
	@FindBy(id = "custom-switch")
	private WebElement enabledCheckbox;
	
	@FindBy(xpath = "//div[@class='modal-content']")
	private WebElement popupWindow;
	
	@FindBy(xpath = "//div[@class='modal-header']/h2")
	private WebElement popupHeading;
	
	@FindBy(xpath = "//button[text() = 'Confirm']")
	private WebElement confirmButton;
	
	@FindBy(xpath = "//button[text() = 'Cancel']")
	private WebElement cancelButton;
	
	@FindBy(xpath = "//div[contains(@class, 'rrt-success')]")
	private WebElement alertDialog;
	
	@FindBy(xpath = "//div[contains(@id, 'dialogTitle')]")
	private WebElement alertMessage;
	
	@FindBy(xpath = "//button[text() = 'Back']")
	private WebElement backButton;
	
	@FindBy(xpath = "//button[@data-testid = 'addOfferKey']")
	private WebElement addOfferTemplate;
	
	@FindBy(xpath = "//input[@name = 'offerName']")
	private WebElement templateName;
	
	@FindBy(xpath = "//label[contains(text(), 'Offer Description')]//following-sibling::div//div[@contenteditable = 'true']")
	private WebElement offerDescription;
	
	@FindBy(xpath = "//input[@name = 'name']")
	private WebElement achievementName;
	
	@FindBy(xpath = "//label[text() = 'Description']//following-sibling::div//div[@contenteditable = 'true']")
	private WebElement achievementDescription;
	
	@FindBy(xpath = "//label[text() = 'Event Name']//following-sibling::div/div/div[1]")
	private WebElement eventNameDropdown;
	
	@FindBy(xpath = "//label[text() = 'Function']//following-sibling::div/div/div[1]")
	private WebElement functionDropdown;
	
	@FindBy(xpath = "//label[text() = 'Comparison']//following-sibling::div/div/div[1]")
	private WebElement ComparisonDropdown;
	
	@FindBy(xpath = "//input[@name = 'value']")
	private WebElement valueField;
	
	@FindBy(xpath = "//button[text() = 'Add Achievement']")
	private WebElement addAchievement;
	
	@FindBy(xpath = "//input[@name = 'qxPoint']")
	private WebElement qxPoints;
	
	@FindBy(xpath = "//label[contains(text(), 'Partner Cost')]//following-sibling::input")
	private WebElement partnerCost;
	
	@FindBy(xpath = "//button[text() = 'Submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//button[text() = 'Save as Draft']")
	private WebElement saveAsDraftButton;
	
	@FindBy(xpath = "//button[contains(@class, 'm-0')]")
	private WebElement actionButton;
	
	@FindBy(xpath = "//span[text() = 'Delete']//parent::a")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//span[text() = 'View']//parent::a")
	private WebElement viewOption;
	
	@FindBy(xpath = "//button[text() = 'Reject']")
	private WebElement rejectButton;
	
	@FindBy(xpath = "//button[text() = 'Approve']")
	private WebElement approveButton;
	
	@FindBy(xpath = "//textarea[@name = 'rejectionReason']")
	private WebElement  rejectionReason;
	
	public boolean gotoOffers() {
		try {
			explicitWait(driver, offersTab, 10, true);
			offersTab.click();
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - gotoOffers");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateOffersPageHeading() {
		try {
			return offersPageHeading.getText().contains("Offers");
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateOffersPageHeading");
			e.printStackTrace();
			return false;
		}
	}

	public boolean validateColumnHeaders() {
		try {
			WebElement offerName = offersTableHeaders.findElement(By.xpath("//div[contains(@class, 'th')][1]"));
			WebElement description = offersTableHeaders.findElement(By.xpath("//div[contains(@class, 'th')][2]"));
			WebElement game = offersTableHeaders.findElement(By.xpath("//div[contains(@class, 'th')][3]"));
			WebElement partner = offersTableHeaders.findElement(By.xpath("//div[contains(@class, 'th')][4]"));
			WebElement status = offersTableHeaders.findElement(By.xpath("//div[contains(@class, 'th')][5]"));
			WebElement action = offersTableHeaders.findElement(By.xpath("//div[contains(@class, 'th')][6]"));

			boolean flag = offerName.isDisplayed() && description.isDisplayed() && game.isDisplayed()
					&& partner.isDisplayed() && status.isDisplayed() && action.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateColumnHeaders");
			e.printStackTrace();
			return false;
		}
	}
	
//	#######################################################################################################################
//	Offers - Sorting
	
	public boolean sortList(boolean byOfferName, boolean byGame, boolean byPartner, boolean asc, boolean desc) {
		try {
			WebElement targetColumn = null;
			WebElement sortBy = null;
			if (byOfferName) {
				targetColumn = driver.findElement(By.xpath("//div[@class = 'table-head']//div[contains(@class , 'th')][1]"));
			} else if (byGame) {
				targetColumn = driver.findElement(By.xpath("//div[@class = 'table-head']//div[contains(@class , 'th')][3]"));
			} else if (byPartner) {
				targetColumn = driver.findElement(By.xpath("//div[@class = 'table-head']//div[contains(@class , 'th')][4]"));
			}
			
			if (asc) {
				sortBy = targetColumn.findElement(By.xpath("//span[@class = 'icon-up-arrow']"));
			} else if (desc) {
				sortBy = targetColumn.findElement(By.xpath("//span[@class = 'icon-down-arrow']"));
			}
			sortBy.click();
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - sortList");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateQueryParamters(boolean byOfferName, boolean byGame, boolean byPartner, boolean asc, boolean desc) {
		try {
			String urlString = driver.getCurrentUrl();
			URI currentUri = new URI(urlString);
			String query = currentUri.getQuery();
			boolean flag = false;
			if (byOfferName) {
				flag = query.contains("name");
			} else if (byGame) {
				flag = query.contains("game");
			} else if (byPartner) {
				flag = query.contains("partner");
			}
			
			if (asc) {
				flag = query.contains("ASC");
			} else if (desc) {
				flag = query.contains("DESC");
			}
			return flag;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateQueryParamters");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateSortedList(boolean byOfferName, boolean byGame, boolean byPartner, boolean asc, boolean desc) {
		try {
			
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateSortedList");
			e.printStackTrace();
			return false;
		}
	}
	
//	#######################################################################################################################
//	Offers - Search
	public boolean isSearchBarPresent() {
		try {
			return searchBar.isDisplayed();
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - isSearchBarPresent");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateSearchResult(String searchInput) {
		try {
			if (getNumberOfSearchResults() > 0) {
				List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class = 'table-row']"));
				boolean flag = true;
				int i = 1;
				int numOfResults = searchResults.size();
				while (i < numOfResults) {
					WebElement current = searchResults.get(i);
					WebElement currentOfferName = current.findElement(By.xpath("//div[@class = 'td'][1]"));
					WebElement currentOfferDesc = current.findElement(By.xpath("//div[@class = 'td'][2]"));
					WebElement currentOfferGame = current.findElement(By.xpath("//div[@class = 'td'][3]"));
					WebElement currentOfferPartner = current.findElement(By.xpath("//div[@class = 'td'][4]"));
					
					boolean doesNotMatchName = !currentOfferName.getText().contains(searchInput);
					boolean doesNotMatchDesc = !currentOfferDesc.getText().contains(searchInput);
					boolean doesNotMatchGame = !currentOfferGame.getText().contains(searchInput);
					boolean doesNotMatchPartner = !currentOfferPartner.getText().contains(searchInput);
					
					if (doesNotMatchName && doesNotMatchDesc && doesNotMatchGame && doesNotMatchPartner) {
						flag = false;
						break;
					} else {
						i++;
					}
				}
				return flag;
			}
			return false;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateSearchResultByOfferName");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateRestoreListForSeach(String input) {
		try {
			explicitWait(driver, searchBar, 10, false);
			searchBar.sendKeys(input);
			WaitClass.waitForTime(3000);
			int numberOfSearchResults = getNumberOfSearchResults();
			searchBar.clear();
			WaitClass.waitForTime(3000);
			int numberOfResultsAfterClearing = getNumberOfSearchResults();
			if (numberOfResultsAfterClearing == numberOfSearchResults) {
				return false;
			}
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateRestoreListForSeach");
			e.printStackTrace();
			return false;
		}
	}
	
	private int getNumberOfSearchResults() {
		try {
			int count = 0;
			List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class = 'table-row']"));
			WaitClass.waitForTime(3000);
			count = searchResults.size() - 1;
			return count;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - getNumberOfSearchResults");
			e.printStackTrace();
			return 0;
		}
	}
	
//  #######################################################################################################################
//	Offers - Approve/Reject
	
	public boolean clickViewOption() {
		try {
			filterByStatus(1);
			WaitClass.waitForTime(2000);
			actionButton.click();
			WaitClass.waitForTime(500);
			viewOption.click();
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateViewOption");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean validateInReviewFields() {
		try {
			List<WebElement> allFields = driver.findElements(By.xpath("//div[contains(@class, 'content-des')]"));
			boolean flag = false;
			JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
			for (WebElement field : allFields) {
				if ((boolean)jsDriver.executeScript("return arguments[0].isContentEditable", field)) {
					flag = true;
				}
			}
			return !flag;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateInReviewFields");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickButton(boolean approve, boolean reject, boolean confirm, boolean cancel) {
		try {
			if (approve) {
				explicitWait(driver, approveButton, 10, true);
				approveButton.click();
			} else if (reject) {
				explicitWait(driver, rejectButton, 10, true);
				rejectButton.click();
			} else if (confirm) {
				explicitWait(driver, confirmButton, 10, true);
				confirmButton.click();
			} else if (cancel) {
				explicitWait(driver, cancelButton, 10, true);
				cancelButton.click();
			}
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - clickButton");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateApproveButton() {
		try {
			explicitWait(driver, approveButton, 10, false);
			return approveButton.isDisplayed();
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateApproveButton");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateRejectButton() {
		try {
			explicitWait(driver, rejectButton, 10, false);
			return rejectButton.isDisplayed();
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateRejectButton");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateApprovePopupHeading() {
		try {
			boolean flag = false;
			if (popupWindow.isDisplayed()) {
				flag = popupHeading.getText().equalsIgnoreCase("Approve Offer?");
			}
			return flag;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateApprovePopupHeading");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateApprovedOfferToast() {
		try {
			String expectedToastMessage = "Offer approved successfully";
			String actualMessage = alertMessage.getText();
			return actualMessage.equalsIgnoreCase(expectedToastMessage);
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateApprovedOfferToast");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateReasonToReject() {
		try {
			return rejectionReason.isDisplayed();
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateReasonToReject");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean fillReasonToReject(String reason) {
		try {
			rejectionReason.sendKeys(reason);
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateReasonToReject");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateRejectedOfferToast() {
		try {
			String expectedToastMessage = "Offer rejected successfully";
			String actualMessage = alertMessage.getText();
			return actualMessage.equalsIgnoreCase(expectedToastMessage);
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateRejectedOfferToast");
			e.printStackTrace();
			return false;
		}
	}
	
//	#######################################################################################################################
// Offers - Autosave
	public boolean clickAddOfferTemplate() {
		try {
			explicitWait(driver, addOfferTemplate, 10, true);
			addOfferTemplate.click();
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - clickAddOfferTemplate");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateAutoSaveOnBack() {
		try {
			explicitWait(driver, backButton, 10, true);
			backButton.click();
			String toastMessage = alertMessage.getText();
			if (toastMessage.equalsIgnoreCase(toastMessage)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateAutoSaveOnBack");
			e.printStackTrace();
			return false;
		}
	}
	
	
	
//	#######################################################################################################################
//	Offers - Delete
	
	public boolean createDraftOffer(String templateNameString, String descriptionString, String achievementNameString, 
			String achievementDescriptionString, String eventNameString, String functionString, String comparisonString,
			String valueString) {
		try {
			explicitWait(driver, addOfferTemplate, 10, true);
			addOfferTemplate.click();
			WaitClass.waitForTime(3000);
			fillOfferTemplate(templateNameString, descriptionString, 
					achievementNameString, achievementDescriptionString, 
					eventNameString, functionString, comparisonString, valueString);
			explicitWait(driver, saveAsDraftButton, 10, true);
			saveAsDraftButton.click();
			clickButton(false, false, true, false);
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - createDraftOffer");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean createOfferTemplate(String templateNameString, String descriptionString, String achievementNameString, 
			String achievementDescriptionString, String eventNameString, String functionString, String comparisonString,
			String valueString) {
		try {
			explicitWait(driver, addOfferTemplate, 10, true);
			addOfferTemplate.click();
			WaitClass.waitForTime(3000);
			fillOfferTemplate(templateNameString, descriptionString, 
					achievementNameString, achievementDescriptionString, 
					eventNameString, functionString, comparisonString, valueString);
			explicitWait(driver, submitButton, 10, true);
			submitButton.click();
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - createOfferTemplate");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean fillOfferTemplate(String templateNameString, String descriptionString, String achievementNameString, 
			String achievementDescriptionString, String eventNameString, String functionString, String comparisonString,
			String valueString) {
		try {
			if (templateNameString != null) {
				templateName.clear();
				templateName.sendKeys(templateNameString);
			}
			if (descriptionString != null) {
				offerDescription.clear();
				offerDescription.sendKeys(descriptionString);
			}
			if (achievementNameString != null) {
				achievementName.clear();
				achievementName.sendKeys(achievementNameString);
			}
			if (achievementDescriptionString != null) {
				achievementDescription.clear();
				achievementDescription.sendKeys(achievementDescriptionString);
			}
			if (eventNameString != null) {
				selectFromDropdown(eventNameDropdown, eventNameString);
			}
			if (functionString != null) {
				selectFromDropdown(functionDropdown, functionString);
			}
			if (comparisonString != null) {
				selectFromDropdown(ComparisonDropdown, comparisonString);
			}
			if (valueString != null) {
				valueField.clear();
				valueField.sendKeys(valueString);
			}
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - fillOfferTemplate");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean selectFromDropdown(WebElement dropdown, String option) {
		try {
			String dropdownPattern = "//div[contains(@id, 'option')]";
			explicitWait(driver, dropdown, 10, false);
			dropdown.click();
			List<WebElement> options = driver.findElements(By.xpath(dropdownPattern));
			for (WebElement currentOption : options) {
				if (currentOption.getText().equalsIgnoreCase(option)) {
					explicitWait(driver, currentOption, 10, true);
					currentOption.click();
					WaitClass.waitForTime(2000);
					break;
				}
			}
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - selectFromDropdown");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateActionButton() {
		try {
			explicitWait(driver, actionButton, 10, true);
			actionButton.click();
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateActionButton");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean searchOffer(String offer) {
		try {
			explicitWait(driver, searchBar, 10, true);
			searchBar.clear();
			searchBar.sendKeys(offer);
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - searchOffer");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateCancelDelete() {
		try {
			explicitWait(driver, actionButton, 10, true);
			actionButton.click();
			WaitClass.waitForTime(2000);
			deleteButton.click();
			if (popupWindow.isDisplayed()) {
				explicitWait(driver, cancelButton, 10, true);
				cancelButton.click();
				return true;
			}
			return false;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateCancelButton");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteOffer() {
		try {
			explicitWait(driver, actionButton, 10, true);
			actionButton.click();
			deleteButton.click();
			if (popupWindow.isDisplayed()) {
				explicitWait(driver, confirmButton, 10, true);
				confirmButton.click();
				return true;
			}
			return false;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - deleteOffer");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateOfferNotFound() {
		try {
			WebElement notFoundElement = driver.findElement(By.xpath("//div[@class = 'no-record']"));
			return notFoundElement.isDisplayed();
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateOfferNotFound");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateOfferFound() {
		try {
			WaitClass.waitForTime(3000);
			if (getNumberOfSearchResults() > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateOfferFound");
			e.printStackTrace();
			return false;
		}
	}
//	#######################################################################################################################
//	Offers - Enable/Disable

	public boolean viewApprovedOffer() {
		try {
			filterByStatus(2);
			WaitClass.waitForTime(3000);
			List<WebElement> allRows = driver.findElements(By.xpath("//div[@class = 'table-row']"));
			if (allRows.size() > 1) {
				WebElement firstRow = allRows.get(1);	//0th row is headers
				WebElement threeDots = firstRow.findElement(By.tagName("button"));
				explicitWait(driver, threeDots, 10, true);
				threeDots.click();
				WebElement viewButton = driver.findElement(By.xpath("//span[text() = 'View']"));
				explicitWait(driver, viewButton, 4, true);
				viewButton.click();
				WaitClass.waitForTime(3000);
			} else {
				return false;
			}
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - viewApprovedOffer");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isEnabledSwitchPresent() {
		try {
			return enabledLabel.isDisplayed();
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - isEnabledSwitchPresent");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isOfferEnabled() {
		try {
			return enabledCheckbox.isSelected();
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - isOfferEnabled");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 
	 * @param forEnabled true if verifying for enabled offer
	 * @param forDisabled true if verifying for disbaled offer
	 * @return true, if successfully validated
	 */
	public boolean validateEnabledSwitchPopupHeading(boolean forEnabled, boolean forDisabled) {
		try {
			String expectedHeading = "";
			if (forDisabled) {
				expectedHeading = "Activate Offer?";
			} else if (forEnabled) {
				expectedHeading = "Deactivate Offer?";
			}
			enabledCheckbox.click();
			boolean flag = false;
			explicitWait(driver, popupWindow, 10, false);
			if (popupWindow.isDisplayed()) {
				flag = popupHeading.getText().contains(expectedHeading);
			}
			explicitWait(driver, cancelButton, 10, true);
			cancelButton.click();
			return flag;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateEnabledSwitchPopupHeading");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateEnabledOfferAlertMessage(boolean isOfferEnabled) {
		try {
			boolean flag = true;
			enabledLabel.click();
			explicitWait(driver, popupWindow, 10, false);
			if (popupWindow.isDisplayed()) {
				explicitWait(driver, confirmButton, 10, true);
				confirmButton.click();
				String message = alertMessage.getText();
				if (isOfferEnabled) {
					flag = message.contains("Offer disabled successfully.");												
				} else if (!isOfferEnabled) {
					flag = message.contains("Offer enabled successfully.");						
				}
				return flag;
			} else {
				flag = false;
			}
			return false;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateEnabledOfferAlertMessage");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateCancelButton() {
		try {
			enabledLabel.click();
			explicitWait(driver, cancelButton, 10, true);
			cancelButton.click();
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - validateCancelButton");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickBackButton() {
		try {
			explicitWait(driver, backButton, 10, true);
			backButton.click();
			WaitClass.waitForTime(3000);
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - clickBackButton");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * filter list by status
	 * 
	 * @param value 1 - In Review, 2 - Approved, 3 - Rejected, 4 - Offer template, 5
	 *              - Draft, 6 - Current, 7 - Expired, 8 - Disabled
	 * @return true, if successful
	 */
	public boolean filterByStatus(int value) {
		try {
			explicitWait(driver, statusDropdown, 10, true);
			statusDropdown.click();
			WebElement status = driver.findElement(By.xpath("//div[contains(@id, 'option')][" + value + "]"));
			status.click();
			Thread.sleep(3000);
			Actions actions = new Actions(driver);
			int retry = 3;
			while (retry > 0) {
				try {
					explicitWait(driver, searchBar, 10, true);
					actions.moveToElement(searchBar).doubleClick().build().perform();
					break;
				} catch (Exception e) {
					retry--;
					System.out.println("Retrying, retry left : " + retry);
				}
			}
			return true;
		} catch (Exception e) {
			System.err.println("Class - Offers_Admin and Method - filterByStatus");
			e.printStackTrace();
			return false;
		}
	}
	
//	##############################################################################################################

	/**
	 * 
	 * @param driver
	 * @param element
	 * @param seconds
	 * @param isClickable
	 * @return explicit wait
	 */
	private WebDriverWait explicitWait(WebDriver driver, WebElement element, int seconds, boolean isClickable) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		if (isClickable) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} else {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		return wait;
	}
}
