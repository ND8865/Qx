package PageObjectClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class LinkGames_Gamer {
	
	private WebDriver driver;
	
	public LinkGames_Gamer(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//h4")
	private WebElement totalGames;
	
	@FindBy(xpath = "//input[@name = 'searchKey']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//div[text() = 'No Game Found']")
	private WebElement noResultsFound;
	
	@FindBy(xpath = "//div[@class = 'card-row box']//ul")
	private List<WebElement> gridGames;
	
	@FindBy(xpath = "(//div[@class = 'custom-multiselect form-group']//button)[1]")
	private WebElement gameNameDropdown;
	
	@FindBy(xpath = "(//div[@class = 'custom-multiselect form-group']//button)[2]")
	private WebElement statusDropdown;
	
	@FindBy(xpath = "(//div[@class = 'custom-multiselect form-group']//input)[1]")
	private WebElement dropdownField;
	
	@FindBy(xpath = "//label[text() = 'Game Name']/parent::div//div[@title= 'Clear all']")
	private WebElement clearGameFilter;
	
	@FindBy(xpath = "//label[text() = 'Status']/parent::div//div[@title= 'Clear all']")
	private WebElement clearStatusFilter;
	
	@FindBy(css = "button.link-btn svg.MuiSvgIcon-root")
	private List<WebElement> notLinkedIcon;
	
	@FindBy(css = "button.link-btn svg circle")
	private List<WebElement> linkedIcon;
	
	@FindBy(xpath = "//div[@class = 'sort-dropdown ']//button")
	private WebElement sortBtn;
	
	@FindBy(xpath = "//span[contains(@class , 'game-title')]")
	private List<WebElement> allGameNames;
	
	@FindBy(xpath = "(//div[contains(@class , 'sort-dropdown ')]/following-sibling::div/div)[1]")
	private WebElement gridViewBtn;
	
	@FindBy(xpath = "(//div[contains(@class , 'sort-dropdown ')]/following-sibling::div/div)[2]")
	private WebElement listViewBtn;
	
	@FindBy(xpath = "//div[@class = 'card-row list']//ul")
	private List<WebElement> listGames;
	
	@FindBy(xpath = "//button[text() = 'Close']")
	private WebElement closeBtn;
	
	@FindBy(xpath = "//h6[text() = \"How to 'link' this game to QX\"]")
	private WebElement howToLinkGameHeading;
	
	@FindBy(xpath = "//p[text() = 'You link the game to QX from inside the game. So, download the game and start playing. Look in the game for \"Link to QX\" button or menu item and tap it.']")
	private WebElement howToLinkGameDesc;
	
	
	/**
	 * Method to verify the number of games shown over the game page.
	 * @param expected - String type parameter. The expected number to match the actual shown.
	 * @return - True if matches.
	 */
	public boolean verifyNumberOfGames(String expected) {
		try {
			String total[] = totalGames.getText().trim().split(" ");
			return total[0].equals(expected);
		}
		catch(Exception e) {
			System.err.println("Exception in Method - verifyNumberOfGames, Class - LinkGames_Gamer : "+e);
			return false;
		}
	}
	
	/**
	 * Method to use search.
	 * @param text - String type parameter. Actual text to enter.
	 * @param result - Boolean type parameter. true if expected some results, false if no results are expected.
	 * @return - True if follows.
	 */
	public boolean searchGames(String text, boolean result) {
		try {
			searchBar.clear();
			searchBar.sendKeys(text);
			if(result == true) {
				return driver.findElement(By.xpath("//*[contains(text() , \""+text+"\")]")).isDisplayed();
			}
			else {
				return noResultsFound.isDisplayed();
			}
		}
		catch(Exception e) {
			System.err.println("Exception in Method - searchGames, Class - LinkGames_Gamer : "+e);
			return false;
		}
	}
	
	/**
	 * Method to apply filter.
	 * @param gridView - Boolean type parameter. true if grid view, false if list view.
	 * @param gameName - String type ArrayList parameter. List of game names. Blank if do not want to use this filter.
	 * @param status - Integer type parameter. 1 = Linked 2 = Unlinked and 0 = Do not want to use this filter
	 * @param clearFilter - Integer type parameter. 1 = Game, 2 = Status, 3 = Both and 0 = None
	 * @return - True if follows.
	 */
	public boolean applyFilters(boolean gridView, ArrayList<String> gameName, int status, int clearFilter) {
		try {
			if(gridView == false) {
				listViewBtn.click();
			}
			if(gameName.size()>0) {
				gameNameDropdown.click();
				for(int i = 0; i < gameName.size(); i++) {
					dropdownField.clear();
					dropdownField.sendKeys(gameName.get(i));
					driver.findElement(By.xpath("//div[text() = '"+gameName.get(i)+"']//input")).click();
					
				}
				driver.findElement(By.xpath("//div")).click();
			}
			if(status != 0) {
				statusDropdown.click();
				if(status == 1) {
					dropdownField.sendKeys("Linked");
					driver.findElement(By.xpath("//div[text() = 'Linked']//input")).click();
				}
				else {
					dropdownField.sendKeys("Not Linked");
					driver.findElement(By.xpath("//div[text() = 'Not Linked']//input")).click();
				}
				driver.findElement(By.xpath("//div")).click();
			}
			if(clearFilter != 0) {
				if(clearFilter == 1) {
					clearGameFilter.click();
				}
				else if(clearFilter == 2) {
					clearStatusFilter.click();
				}
				else if(clearFilter == 3) {
					clearGameFilter.click();
					clearStatusFilter.click();
				}
			}
			return true;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - applyFilters, Class - LinkGames_Gamer : "+e);
			return false;
		}
	}
	
	/**
	 * Method to validate filters in grid view.
	 * @param gameName - String type ArrayList parameter. List of game names. Blank if do not want to use this filter.
	 * @param status - Integer type parameter. 1 = Linked 2 = Unlinked and 0 = Do not want to use this filter
	 * @return - True if follows.
	 */
	public boolean validateFilterInGrid(ArrayList<String> gameName, int status) {
		try {
			if(gameName.size()>0) {
				for(int i = 0; i < gameName.size(); i++) {
					if(driver.findElement(By.xpath("//span[text() = '"+gameName.get(i)+"']")).isDisplayed() == false) {
						return false;
					}
				}
			}
			if(status != 0) {
				if(status == 1) {
					if(gridGames.size() != linkedIcon.size()) {
						return false;
					}
				}
				else {
					if(gridGames.size() != notLinkedIcon.size()) {
						return false;
					}
				}
			}
			return true;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - validateFilterInGrid, Class - LinkGames_Gamer : "+e);
			return false;
		}
	}
	
	/**
	 * Method to check the sort action on the data.
	 * @return - True if working fine.
	 */
	public boolean checkSortBtn() {
		try {
			sortBtn.click();
			WaitClass.waitForTime(2000);
			ArrayList<String> names = new ArrayList<String>();
			ArrayList<String> temp = new ArrayList<String>();
			for(int i=0; i<allGameNames.size(); i++) {
				names.add(allGameNames.get(i).getText().trim());
			}
			temp = names;
			Collections.sort(temp, Collections.reverseOrder());
			boolean flag = temp.equals(names);
			sortBtn.click();
			WaitClass.waitForTime(2000);
			names.clear();
			for(int i=0; i<allGameNames.size(); i++) {
				names.add(allGameNames.get(i).getText().trim());
			}
			Collections.sort(temp);
			flag = flag && names.equals(temp);
			return flag;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - checkSortBtn, Class - LinkGames_Gamer : "+e);
			return false;
		}
	}
	
	/**
	 * Method to check the view buttons
	 * @return - True if follows.
	 */
	public boolean checkViewBtns() {
		try {
			boolean flag = gridGames.size()>0;
			listViewBtn.click();
			flag = flag && listGames.size()>0;
			gridViewBtn.click();
			flag = flag && gridGames.size()>0;
			return flag;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - checkViewBtns, Class - LinkGames_Gamer : "+e);
			return false;
		}
	}
	
	/**
	 * Method to validate filters in List view.
	 * @param gameName - String type ArrayList parameter. List of game names. Blank if do not want to use this filter.
	 * @param status - Integer type parameter. 1 = Linked 2 = Unlinked and 0 = Do not want to use this filter
	 * @return - True if follows.
	 */
	public boolean validateFilterInList(ArrayList<String> gameName, int status) {
		try {
			if(gameName.size()>0) {
				for(int i = 0; i < gameName.size(); i++) {
					if(driver.findElement(By.xpath("//span[text() = '"+gameName.get(i)+"']")).isDisplayed() == false) {
						return false;
					}
				}
			}
			if(status != 0) {
				if(status == 1) {
					if(listGames.size() != linkedIcon.size()) {
						return false;
					}
				}
				else {
					if(listGames.size() != notLinkedIcon.size()) {
						return false;
					}
				}
			}
			return true;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - validateFilterInList, Class - LinkGames_Gamer : "+e);
			return false;
		}
	}
	
	/**
	 * Method to check the details of the game.
	 * @param isListView - Boolean type parameter. true if checking in list view, false otherwise.
	 * @param gameName - String type parameter. 
	 * @param descriptionText - String type parameter.
	 * @param description - String type parameter.
	 * @param downloadUrl - String type parameter.
	 * @return - true if validated, false otherwise.
	 */
	public boolean checkGameData(boolean isListView, String gameName, String descriptionText, String description, String downloadUrl) {
		try {
			boolean flag = true;
			if(isListView == true) {
				listViewBtn.click();
			}
			WaitClass.waitForTime(2000);
			searchBar.clear();
			searchBar.sendKeys(gameName);
			WaitClass.waitForTime(2000);
			if(gameName.length()>0) {
				flag = flag && driver.findElement(By.xpath("//span[text() = '"+gameName+"']")).isDisplayed();
			}
			if(descriptionText.length()>0) {
				flag = flag && driver.findElement(By.xpath("//p[text() = '"+descriptionText+"']")).isDisplayed();
			}
			if(description.length()>0) {
				driver.findElement(By.xpath("//span[text() = '"+gameName+"']")).click();
				flag = flag && driver.findElement(By.xpath("//p[text() = '"+gameName+"']")).isDisplayed();
				flag = flag && driver.findElement(By.xpath("//p[text() = '"+description+"']")).isDisplayed();
				closeBtn.click();
				
			}
			if(downloadUrl.length()>0) {
				driver.findElement(By.xpath("//span[text() = '"+gameName+"']")).click();
				flag = flag && driver.findElement(By.xpath("//p[text() = '"+gameName+"']")).isDisplayed();
				flag = flag && driver.findElement(By.xpath("//p[text() = '"+downloadUrl+"']")).isDisplayed();
				closeBtn.click();
			}
			return flag;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - checkGameData, Class - LinkGames_Gamer : "+e);
			return false;
		}
	}
	
	/**
	 * Method to check the how to link steps in a game description.
	 * @return  - true if found, else false.
	 */
	public boolean checkHowToLink() {
		try {
			int index = Utility.getRandomInt(0, allGameNames.size()-1);
			allGameNames.get(index).click();
			boolean flag = howToLinkGameDesc.isDisplayed();
			flag = flag && howToLinkGameHeading.isDisplayed();
			return flag;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - checkHowToLink, Class - LinkGames_Gamer : "+e);
			return false;
		}
	}

}
