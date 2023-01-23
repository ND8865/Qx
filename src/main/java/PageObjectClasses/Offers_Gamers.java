package PageObjectClasses;

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

import UtilityClass.WaitClass;

public class Offers_Gamers {
	
	private WebDriver driver;
	
	public Offers_Gamers(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//h4")
	private WebElement totalOffers;
	
	@FindBy(xpath = "//div[contains(@class, 'table-list-item')]")
	private List<WebElement> offerLists;
	
	@FindBy(xpath = "//input[@name = 'searchKey']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//div[text() = 'No Offer Found.']")
	private WebElement noResultsFound;
	
	@FindBy(xpath = "(//div[@class = 'custom-multiselect mb-0 form-group']//button)[1]")
	private WebElement offerNameDropdown;
	
	@FindBy(xpath = "(//div[@class = 'custom-multiselect mb-0 form-group']//button)[2]")
	private WebElement gameNameDropdown;
	
	@FindBy(xpath = "(//div[@class = 'custom-multiselect mb-0 form-group']//button)[3]")
	private WebElement statusDropdown;
	
	@FindBy(xpath = "(//div[@class = 'react-datepicker__input-container']/input)[1]")
	private WebElement startDateField;
	
	@FindBy(xpath = "(//div[@class = 'react-datepicker__input-container']/input)[2]")
	private WebElement endDateField;
	
	@FindBy(xpath = "(//div[@class = 'custom-multiselect mb-0 form-group']//input)[1]")
	private WebElement dropdownField;
	
	@FindBy(xpath = "//label[text() = 'Offer Name']/parent::div//div[@title= 'Clear all']")
	private WebElement clearOfferFilter;
	
	@FindBy(xpath = "//label[text() = 'Game Name']/parent::div//div[@title= 'Clear all']")
	private WebElement clearGameFilter;
	
	@FindBy(xpath = "//label[text() = 'Status']/parent::div//div[@title= 'Clear all']")
	private WebElement clearStatusFilter;
	
	@FindBy(xpath = "//label[text() = 'Start Date']/parent::div//button[@aria-label = 'Close']")
	private WebElement clearStartDateFilter;
	
	@FindBy(xpath = "//label[text() = 'End Date']/parent::div//button[@aria-label = 'Close']")
	private WebElement clearEndDateFilter;
	
	@FindBy(xpath = "//div[text() = 'Offer Name']/span/span[contains(@class, 'asc')]")
	private WebElement offerNameSortAsc;
	
	@FindBy(xpath = "//div[text() = 'Offer Name']/span/span[contains(@class, 'desc')]")
	private WebElement offerNameSortDesc;
	
	@FindBy(xpath = "//div[text() = 'Game']/span/span[contains(@class, 'asc')]")
	private WebElement gameNameSortAsc;
	
	@FindBy(xpath = "//div[text() = 'Game']/span/span[contains(@class, 'desc')]")
	private WebElement gameNameSortDesc;
	
	@FindBy(xpath = "//div[text() = 'Start Date']/span/span[contains(@class, 'asc')]")
	private WebElement startDateSortAsc;
	
	@FindBy(xpath = "//div[text() = 'Start Date']/span/span[contains(@class, 'desc')]")
	private WebElement startDateSortDesc;
	
	@FindBy(xpath = "//div[text() = 'End Date']/span/span[contains(@class, 'asc')]")
	private WebElement endDateSortAsc;
	
	@FindBy(xpath = "//div[text() = 'End Date']/span/span[contains(@class, 'desc')]")
	private WebElement endDateSortDesc;
	
	@FindBy(xpath = "//div[text() = 'Progress']/span/span[contains(@class, 'asc')]")
	private WebElement progressSortAsc;
	
	@FindBy(xpath = "//div[text() = 'Progress']/span/span[contains(@class, 'desc')]")
	private WebElement progressSortDesc;
	
	@FindBy(xpath = "//div[text() = 'Status']/span/span[contains(@class, 'asc')]")
	private WebElement statusSortAsc;
	
	@FindBy(xpath = "//div[text() = 'Status']/span/span[contains(@class, 'desc')]")
	private WebElement statusSortDesc;
	
	@FindBy(xpath = "//div[@class = 'tbody']//label[text() = 'Offer Name']/following-sibling::div")
	private List<WebElement> listOfOfferNames;
	
	@FindBy(xpath = "//div[@class = 'tbody']//label[text() = 'Game']/parent::div")
	private List<WebElement> listOfGameNames;
	
	@FindBy(xpath = "//div[@class = 'tbody']//label[text() = 'Start Date']/parent::div")
	private List<WebElement> listOfStartDates;
	
	@FindBy(xpath = "//div[@class = 'tbody']//label[text() = 'End Date']/parent::div")
	private List<WebElement> listOfEndDates;
	
	@FindBy(xpath = "//div[@class = 'tbody']//label[text() = 'Progress']/parent::div")
	private List<WebElement> listOfProgress;
	
	@FindBy(xpath = "//div[@class = 'tbody']//label[text() = 'Status']/parent::div")
	private List<WebElement> listOfStatus;
	
	
	
	/**
	 * Method to verify the number of offers shown over the offer page.
	 * @param expected - String type parameter. The expected number to match the actual shown.
	 * @return - True if matches.
	 */
	public boolean verifyNumberOfOffers(String expected) {
		try {
			String total[] = totalOffers.getText().trim().split(" "); 
			return total[0].equals(expected);
		}
		catch(Exception e) {
			System.err.println("Exception in Method - verifyNumberOfOffers, Class - Offers_Gamers : "+e);
			return false;
		}
	}
	
	/**
	 * Method to use search.
	 * @param text - String type parameter. Actual text to enter.
	 * @param result - Boolean type parameter. true if expected some results, false if no results are expected.
	 * @return - True if follows.
	 */
	public boolean searchOffer(String text, boolean result) {
		try {
			searchBar.clear();
			searchBar.sendKeys(text);
			if(result == true) {
				return driver.findElement(By.xpath("//*[contains(text() , '"+text+"')]")).isDisplayed();
			}
			else {
				return noResultsFound.isDisplayed();
			}
		}
		catch(Exception e) {
			System.err.println("Exception in Method - searchOffer, Class - Offers_Gamers : "+e);
			return false;
		}
	}
	
	
	/**
	 * Method to apply filter.
	 * @param offerName - String type array list parameter. List of offer names. Blank if do not want to use this filter.
	 * @param gameName - String type ArrayList parameter. List of game names. Blank if do not want to use this filter.
	 * @param startDate - String type parameter. The start date. Blank if do not want to use this parameter.
	 * @param endDate - String type parameter. The end date. Blank if do not want to use this parameter.
	 * @param status - Integer type parameter. 1 = Current 2 = Expired, 3 = Approved and 0 = Do not want to use this filter
	 * @param clearFilter - Integer type parameter. 1 = Offer Name, 2 = Game Name, 3 = Start Date, 4 = End Date, 5 = Status, 6 = All available and 0 = None
	 * @return - True if follows.
	 */
	public boolean applyFilters(ArrayList<String> offerName, ArrayList<String> gameName, String startDate, String endDate, int status, int clearFilter) {
		try {
			if(offerName.size()>0) {
				offerNameDropdown.click();
				for(int i = 0; i < offerName.size(); i++) {
					dropdownField.clear();
					dropdownField.sendKeys(offerName.get(i));
					driver.findElement(By.xpath("//div[text() = '"+offerName.get(i)+"']//input")).click();
					
				}
				driver.findElement(By.xpath("//div")).click();
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
			if(startDate.length()>0) {
				startDateField.sendKeys(startDate);
				totalOffers.click();
			}
			if(endDate.length()>0) {
				endDateField.sendKeys(endDate);
				totalOffers.click();
			}
			if(status != 0) {
				statusDropdown.click();
				if(status == 1) {
					dropdownField.sendKeys("Current");
					driver.findElement(By.xpath("//div[text() = 'Current']//input")).click();
				}
				else if(status == 2) {
					dropdownField.sendKeys("Expired");
					driver.findElement(By.xpath("//div[text() = 'Expired']//input")).click();
				}
				else {
					dropdownField.sendKeys("Approved");
					driver.findElement(By.xpath("//div[text() = 'Approved']//input")).click();
				}
				driver.findElement(By.xpath("//div")).click();
			}
			if(clearFilter != 0) {
				if(clearFilter == 1) {
					clearOfferFilter.click();
				}
				else if(clearFilter == 2) {
					clearGameFilter.click();
				}
				else if(clearFilter == 3) {
					clearStartDateFilter.click();
				}
				else if(clearFilter == 4) {
					clearEndDateFilter.click();
				}
				else if(clearFilter == 5) {
					clearStatusFilter.click();
				}
				else if(clearFilter == 6) {
					List<WebElement> close1 = driver.findElements(By.xpath("//div[@title = 'Clear all']"));
					List<WebElement> close2 = driver.findElements(By.xpath("//button[@aria-label = 'Close']"));
					
					for(int i = 0; i < close1.size(); i++) {
						driver.findElement(By.xpath("//div[@title = 'Clear all']")).click();
					}
					for(int i = 0; i < close2.size(); i++) {
						driver.findElement(By.xpath("//button[@aria-label = 'Close']")).click();
					}
				}
			}
			return true;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - applyFilters, Class - Offers_Gamers : "+e);
			return false;
		}
	}
	
	/**
	 * Method to validate filters in grid view.
	 * @param offerName - String type ArrayList parameter. List of offer names. Blank if do not want to use this filter.
	 * @param gameName - String type ArrayList parameter. List of game names. Blank if do not want to use this filter.
	 * @param startDate - String type parameter. The start date. Blank if do not want to use this parameter.
	 * @param endDate - String type parameter. The end date. Blank if do not want to use this parameter.
	 * @param status - Integer type parameter. 1 = Current 2 = Expired, 3 = Approved and 0 = Do not want to use this filter
	 * @return - True if follows.
	 */
	public boolean validateFilter(ArrayList<String> offerName, ArrayList<String> gameName, String startDate, String endDate, int status) {
		try {
			WaitClass.waitForTime(2000);
			if(offerName.size()>0) {
				for(int i = 0; i < offerName.size(); i++) {
					if(driver.findElement(By.xpath("//div[text() = '"+offerName.get(i)+"']")).isDisplayed() == false) {
						return false;
					}
				}
			}
			if(gameName.size()>0) {
				for(int i = 0; i < gameName.size(); i++) {
					if(driver.findElement(By.xpath("//div[text() = '"+gameName.get(i)+"']")).isDisplayed() == false) {
						return false;
					}
				}
			}
			if(startDate.length()>0) {
				return offerLists.size()>0;
			}
			if(endDate.length()>0) {
				return offerLists.size()>0;
			}
			if(status != 0) {
				String total[] = totalOffers.getText().trim().split(" "); 
				return total[0].equals(offerLists.size()+"");
			}
			return true;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - validateFilter, Class - Offers_Gamers : "+e);
			return false;
		}
	}
	
	/**
	 * Method to check the details of the game.
	 * @param offerName - String type parameter.
	 * @param gameName - String type parameter. 
	 * @param descriptionText - String type parameter.
	 * @param startDate - String type parameter.
	 * @param endDate - String type parameter.
	 * @return - true if validated, false otherwise.
	 */
	public boolean checkOfferListView(String offerName, String gameName, String descriptionText, String startDate, String endDate) {
		try {
			boolean flag = true;
			if(offerName.length()>0) {
				flag = flag && driver.findElement(By.xpath("//div[text() = '"+offerName+"']")).isDisplayed();
			}
			if(gameName.length()>0) {
				flag = flag && driver.findElement(By.xpath("//div[text() = '"+gameName+"']")).isDisplayed();
			}
			SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
			Date d = format.parse(startDate);
			if(startDate.length()>0) {
				flag = flag && driver.findElement(By.xpath("//div[text() = '"+format.format(d)+"']")).isDisplayed();
			}
			d = format.parse(endDate);
			if(endDate.length()>0) {
				flag = flag && driver.findElement(By.xpath("//div[text() = '"+format.format(d)+"']")).isDisplayed();
			}
			return flag;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - checkOfferListView, Class - Offers_Gamers : "+e);
			return false;
		}
	}
	
	/**
	 * Method to check the detail view of the offer.
	 * @param offerName - String type parameter.
	 * @param offerDescription - String type parameter.
	 * @param achievementName - String type parameter.
	 * @param achievementDescription - String type parameter.
	 * @param reward - String type parameter.
	 * @param gameName - String type parameter.
	 * @param startDate - String type parameter.
	 * @param endDate - String type parameter.
	 * @return - True if validated.
	 */
	public boolean checkDetailedViewData(String offerName, String offerDescription, String achievementName, String achievementDescription, String reward, String gameName, String startDate, String endDate) {
		try {
			driver.findElement(By.xpath("//*[text() = '"+offerName+"']/parent::div/following-sibling::div/button")).click();
			boolean flag = true;
			flag = flag && driver.findElement(By.xpath("//*[text() = '"+offerName+"']")).isDisplayed();
			String offerD[] = offerDescription.split("\n");
			for(int i = 0 ; i < offerD.length; i++) {
				flag = flag && driver.findElement(By.xpath("//*[contains(text() , '"+offerD[i]+"')]")).isDisplayed();
			}
			flag = flag && driver.findElement(By.xpath("//*[text() = '"+achievementName+"']")).isDisplayed();
			String achievementD[] = achievementDescription.split("\n");
			for(int i = 0 ; i < achievementD.length; i++) {
				flag = flag && driver.findElement(By.xpath("//*[contains(text() , '"+achievementD[i]+"')]")).isDisplayed();
			}
			flag = flag && driver.findElement(By.xpath("//*[text() = '"+reward+"']")).isDisplayed();
			flag = flag && driver.findElement(By.xpath("//*[text() = '"+gameName+"']")).isDisplayed();
			SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
			Date d = format.parse(startDate);
			flag = flag && driver.findElement(By.xpath("//*[text() = '"+format.format(d)+"']")).isDisplayed();
			d = format.parse(endDate);
			flag = flag && driver.findElement(By.xpath("//*[text() = '"+format.format(d)+"']")).isDisplayed();
			return flag;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - checkDetailedViewData, Class - Offers_Gamers : "+e);
			return false;
		}
	}
	
	/**
	 * Method to check the sort functionality.
	 * @param offer - Integer type parameter. 1 = Ascending order, 2 = Descending order, 0 = Not in use.
	 * @param game - Integer type parameter. 1 = Ascending order, 2 = Descending order, 0 = Not in use.
	 * @param startDate - Integer type parameter. 1 = Ascending order, 2 = Descending order, 0 = Not in use.
	 * @param endDate - Integer type parameter. 1 = Ascending order, 2 = Descending order, 0 = Not in use.
	 * @param progress - Integer type parameter. 1 = Ascending order, 2 = Descending order, 0 = Not in use.
	 * @param status - Integer type parameter. 1 = Ascending order, 2 = Descending order, 0 = Not in use.
	 * @return - True if sort if working.
	 */
	public boolean checkSort(int offer, int game, int startDate, int endDate, int progress, int status) {
		try {
			if(offer == 1) 
			{
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for(int i = 0 ; i < listOfOfferNames.size(); i++) {
					data.add(listOfOfferNames.get(i).getText().toString().toLowerCase());
				}
				Collections.sort(data);
				offerNameSortAsc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listOfOfferNames.size(); i++) {
					sortedData.add(listOfOfferNames.get(i).getText().toString().toLowerCase());
				}
				return data.equals(sortedData);
			}
			
			if(offer == 2) 
			{
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for(int i = 0 ; i < listOfOfferNames.size(); i++) {
					data.add(listOfOfferNames.get(i).getText().toString().toLowerCase());
				}
				Collections.sort(data, Collections.reverseOrder());
				offerNameSortDesc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listOfOfferNames.size(); i++) {
					sortedData.add(listOfOfferNames.get(i).getText().toString().toLowerCase());
				}
				return data.equals(sortedData);
			}
			if(game == 1) {
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for(int i = 0 ; i < listOfGameNames.size(); i++) {
					data.add(listOfGameNames.get(i).getText().toString().toLowerCase());
				}
				Collections.sort(data);
				gameNameSortAsc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listOfGameNames.size(); i++) {
					sortedData.add(listOfGameNames.get(i).getText().toString().toLowerCase());
				}
				return data.equals(sortedData);
			}
			if(game == 2) {
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for(int i = 0 ; i < listOfGameNames.size(); i++) {
					data.add(listOfGameNames.get(i).getText().toString().toLowerCase());
				}
				Collections.sort(data, Collections.reverseOrder());
				gameNameSortDesc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listOfGameNames.size(); i++) {
					sortedData.add(listOfGameNames.get(i).getText().toString().toLowerCase());
				}
				return data.equals(sortedData);
			}
			if(startDate == 1) {
				ArrayList<Date> tempData = new ArrayList<Date>();
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
				for(int i = 0 ; i < listOfStartDates.size(); i++) {
					String date = listOfStartDates.get(i).getText();
					tempData.add(format.parse(date));
				}
				Collections.sort(tempData);
				for(int i = 0; i < tempData.size(); i++) {
					data.add(format.format(tempData.get(i))+"");
				}
				startDateSortAsc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listOfStartDates.size(); i++) {
					sortedData.add(listOfStartDates.get(i).getText().toString());
				}
				return data.equals(sortedData);
			}
			if(startDate == 2) {
				ArrayList<Date> tempData = new ArrayList<Date>();
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
				for(int i = 0 ; i < listOfStartDates.size(); i++) {
					String date = listOfStartDates.get(i).getText();
					tempData.add(format.parse(date));
				}
				Collections.sort(tempData, Collections.reverseOrder());
				for(int i = 0; i < tempData.size(); i++) {
					data.add(format.format(tempData.get(i))+"");
				}
				startDateSortDesc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listOfStartDates.size(); i++) {
					sortedData.add(listOfStartDates.get(i).getText().toString());
				}
				return data.equals(sortedData);
			}
			if(endDate == 1) {
				ArrayList<Date> tempData = new ArrayList<Date>();
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
				for(int i = 0 ; i < listOfEndDates.size(); i++) {
					String date = listOfEndDates.get(i).getText();
					tempData.add(format.parse(date));
				}
				Collections.sort(tempData);
				for(int i = 0; i < tempData.size(); i++) {
					data.add(format.format(tempData.get(i))+"");
				}
				endDateSortAsc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listOfEndDates.size(); i++) {
					sortedData.add(listOfEndDates.get(i).getText().toString());
				}
				return data.equals(sortedData);
			}
			if(endDate == 2) {
				ArrayList<Date> tempData = new ArrayList<Date>();
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
				for(int i = 0 ; i < listOfEndDates.size(); i++) {
					String date = listOfEndDates.get(i).getText();
					tempData.add(format.parse(date));
				}
				Collections.sort(tempData, Collections.reverseOrder());
				for(int i = 0; i < tempData.size(); i++) {
					data.add(format.format(tempData.get(i))+"");
				}
				endDateSortDesc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listOfEndDates.size(); i++) {
					sortedData.add(listOfEndDates.get(i).getText().toString());
				}
				return data.equals(sortedData);
			}
			if(progress == 1) {
				ArrayList<Integer> tempData = new ArrayList<Integer>();
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for(int i = 0 ; i < listOfProgress.size(); i++) {
					String num = listOfProgress.get(i).getText().replace("%", "");
					tempData.add(Integer.parseInt(num));
				}
				Collections.sort(tempData);
				for(int i = 0; i < tempData.size(); i++) {
					data.add(tempData.get(i)+"%");
				}
				progressSortAsc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listOfProgress.size(); i++) {
					sortedData.add(listOfProgress.get(i).getText().toString());
				}
				return data.equals(sortedData); 
			}
			if(progress == 2) {
				ArrayList<Integer> tempData = new ArrayList<Integer>();
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for(int i = 0 ; i < listOfProgress.size(); i++) {
					String num = listOfProgress.get(i).getText().replace("%", "");
					tempData.add(Integer.parseInt(num));
				}
				Collections.sort(tempData, Collections.reverseOrder());
				for(int i = 0; i < tempData.size(); i++) {
					data.add(tempData.get(i)+"%");
				}
				progressSortDesc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listOfProgress.size(); i++) {
					sortedData.add(listOfProgress.get(i).getText().toString());
				}
				return data.equals(sortedData);
			}
			if(status == 1) {
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for(int i = 0 ; i < listOfStatus.size(); i++) {
					data.add(listOfStatus.get(i).getText().toString());
				}
				Collections.sort(data);
				statusSortAsc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listOfStatus.size(); i++) {
					sortedData.add(listOfStatus.get(i).getText().toString());
				}
				return data.equals(sortedData);
			}
			if(status == 2) {
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for(int i = 0 ; i < listOfStatus.size(); i++) {
					data.add(listOfStatus.get(i).getText().toString());
				}
				Collections.sort(data, Collections.reverseOrder());
				statusSortDesc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listOfStatus.size(); i++) {
					sortedData.add(listOfStatus.get(i).getText().toString());
				}
				return data.equals(sortedData);
			}
			return false;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - checkSort, Class - Offers_Gamers : "+e);
			return false;
		}
	}

}
