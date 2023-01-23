package PageObjectClasses;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class MyRewards_Gamer {
	
	int totalCount1;
	int totalcount2;
	int totalCount3;
	int totalcount4;
	
	int totalExchangecount1;
	int totalExchangecount2;
	int totalExchangecount3;
	int totalExchangecount4;
	

	WebDriver driver;
	public MyRewards_Gamer(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	@FindBy(xpath = "(//a[text()='My Rewards'])[2]")
	private WebElement myRewardTab;

	
	@FindBy(xpath = "//div[text()='My Rewards']")
	private WebElement pageHeadingText;
	
	@FindBy(xpath = "//span[text()=' QX Points']")
	private WebElement totalQxPoints;
	
	@FindBy(xpath = "//div[text()=' when exchanged and redeemed)']")
	private WebElement exchangeAndRedeemText;
	
	@FindBy(xpath = "//h4[text()='  Games']")
	private WebElement gamesCount;
	
	@FindBy(xpath = "//input[@name='searchKey']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//label[text()='Game Name']")
	private WebElement gameNameFilterLabel;
	
	@FindBy(xpath = "//span[text()='Select']")
	private WebElement gameNamefilterDropdown;
	
	@FindBy(xpath = "(//div[@class = 'filter-mobile-container offer-filter rewards-filter remove-filter']//input)[1]")
	private WebElement gameNamefilterDropdownSearchBar;
	
	@FindBy(xpath = "//label[text()='Points']")
	private WebElement pointsSliderLabel;
	
	@FindBy(xpath = "(//span[@class='MuiSlider-root MuiSlider-colorPrimary'])[1]")
	private WebElement pointsSlider;
	
	@FindBy(xpath = "(//label[text()='Exchange Value'])[1]")
	private WebElement exchangeValueSliderLabel;
	
	@FindBy(xpath = "(//span[@class='MuiSlider-root MuiSlider-colorPrimary'])[2]")
	private WebElement exchangeValueSlider;
	
	@FindBy(xpath = "//div[text()='Game Name']")
	private WebElement gameNameColumn;
	
	@FindBy(xpath = "(//span[@data-testid='game-name-sort-asc'])")
	private WebElement gameNameSortAsc;
	
	@FindBy(xpath = "(//span[@data-testid='game-name-sort-desc'])")
	private WebElement gameNameSortDesc;
	
	@FindBy(xpath = "(//div[text()='QX Points'])[1]")
	private WebElement qxPointCoulmn;
	
	@FindBy(xpath = "(//span[@data-testid='game-points-sort-asc'])[1]")
	private WebElement qxPointSortAsc;
	
	@FindBy(xpath = "(//span[@data-testid='game-points-sort-desc'])[1]")
	private WebElement qxPointSortdesc;
	
	@FindBy(xpath = "(//div[text()='Exchange Value'])")
	private WebElement exchangeValueCoulmn;
	
	@FindBy(xpath = "(//span[@data-testid='game-points-sort-asc'])[2]")
	private WebElement exchangeValueSortAsc;
	
	@FindBy(xpath = "(//span[@data-testid='game-points-sort-desc'])[2]")
	private WebElement exchangeValueSortDesc;
	
	@FindBy(xpath = "(//div[text()='Action'])")
	private WebElement actionColumn;
	
	@FindBy(xpath = "(//img[@alt=\"Game logo\"])[1]")
	private WebElement qxLogo;
	
	@FindBy(xpath = "(//div[text()='QX Points'])[2]")
	private WebElement qxPointText;
	
	@FindBy(xpath = "(//div[@class='tbody'])/div[1]/div[2]")
	private WebElement availableRedeemPoints;
	
	@FindBy(xpath = "(//div[@class='tbody'])/div[1]/div[3]/span")
	private WebElement availableExchangedValue;
	
	@FindBy(xpath = "//button[text()='Redeem']")
	private WebElement redeemButton;
	
	@FindBy(xpath = "//div[@title='Clear all']")
	private WebElement clearAllfilter;
	
	@FindBy(xpath = "//div[@class='table-list-item d-flex align-items-center']/div[1]")
	private List<WebElement> listing;
	
	@FindBy(xpath = "//div[@class='table-list-item d-flex align-items-center']/div[2]")
	private List<WebElement> listingQxPoint;
	
	@FindBy(xpath = "//div[@class='table-list-item d-flex align-items-center']/div[3]")
	private List<WebElement> listingExchangeValue;
	
	@FindBy(xpath = "//button[@class='btn btn-primary btn btn-primary']")
	private List<WebElement> listingActionButtons;
	
	
	
	/**
	 * Description - checking all elements on My Rewards.
	 * @return - True - if all elements are visible.
	 */
	public boolean checkAllMyRewardsPageElements(){

			try {
				boolean flag = pageHeadingText.isDisplayed();
				flag = flag && totalQxPoints.isDisplayed();
				flag = flag && exchangeAndRedeemText.isDisplayed();
				flag = flag && gamesCount.isDisplayed();
				flag = flag && searchBar.isDisplayed();
				flag = flag && searchButton.isDisplayed();
				flag = flag && gameNameFilterLabel.isDisplayed();
				flag = flag && gameNamefilterDropdown.isDisplayed();
				flag = flag && pointsSliderLabel.isDisplayed();
				flag = flag && pointsSlider.isDisplayed();
				flag = flag && exchangeValueSliderLabel.isDisplayed();
				flag = flag && exchangeValueSlider.isDisplayed();
				flag = flag && gameNameColumn.isDisplayed();
				flag = flag && gameNameSortAsc.isDisplayed();
				flag = flag && gameNameSortDesc.isDisplayed();
				flag = flag && qxPointCoulmn.isDisplayed();
				flag = flag && qxPointSortAsc.isDisplayed();
				flag = flag && qxPointSortdesc.isDisplayed();
				flag = flag && exchangeValueCoulmn.isDisplayed();
				flag = flag && exchangeValueSortAsc.isDisplayed();
				flag = flag && exchangeValueSortDesc.isDisplayed();
				flag = flag && qxLogo.isDisplayed();
				flag = flag && qxPointText.isDisplayed();
				flag = flag && availableRedeemPoints.isDisplayed();
				flag = flag && availableExchangedValue.isDisplayed();
				flag = flag && redeemButton.isDisplayed();
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - MyRewards_Gamer, Method - checkAllMyRewardsPageElements : " + e);
				return false;
			}
		}
	
	/**
	 *Description - Navigating to my reward page from dashboard.
	 * @return - True - if land successfully on my reward page.
	 */
	public boolean navigateToMyRewardTab(){

			try {
				boolean flag = myRewardTab.isDisplayed();
				myRewardTab.click();
				flag = flag && pageHeadingText.isDisplayed();
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - MyRewards_Gamer, Method - checkAllMyRewardsPageElements : " + e);
				return false;
			}
		}
	
	/**
	 *Description - Validating total QX points on My Reward page.
	 * @return - True - if shown QX points equals to Calculated QX points.
	 */
	public boolean totalQxPointsValidation(){

			try {
				int totalCalculatedQxPoints = 0;
				WaitClass.waitForTime(4000);
				String totalQxPointsShown = totalQxPoints.getText();
				totalQxPointsShown = totalQxPointsShown.replace(" QX Points","").replace(",", "");
				for(WebElement count : listingQxPoint) {
					String qxPointValue = count.getText();
					qxPointValue = qxPointValue.replace(",", "");
					int qxPointValueInt = Integer.parseInt(qxPointValue);
					totalCalculatedQxPoints = totalCalculatedQxPoints + qxPointValueInt;
					
				}
				return (Integer.parseInt(totalQxPointsShown) == totalCalculatedQxPoints);
			} catch (Exception e) {
				System.err.println("Exception in Class - MyRewards_Gamer, Method - totalQxPointsValidation : " + e);
				return false;
			}
		}
	
	/**
	 *Description - Validating total Exchange value on My Reward page.
	 * @return - True - if shown Exchange value equals to Calculated Exchange value.
	 */
	public boolean totalExchangeValueValidation(){

			try {
				int totalCalculatedExchangeValue = 0;
				WaitClass.waitForTime(4000);
				String totalExchangeValueShown = exchangeAndRedeemText.getText();
				String totalQxPointsShown = totalQxPoints.getText();
				totalExchangeValueShown = totalExchangeValueShown.replace(totalQxPointsShown,"").replace(" (","").replace(" when exchanged and redeemed)","").replace("$","").replace(",", "").replace(".00", "");
				
				for(WebElement count : listingExchangeValue) {
					String exchangeValue = count.getText();
					exchangeValue = exchangeValue.replace(",", "").replace("$", "");
					int qxPointValueInt = Integer.parseInt(exchangeValue);
					totalCalculatedExchangeValue = totalCalculatedExchangeValue + qxPointValueInt;
					
				}
				return (Integer.parseInt(totalExchangeValueShown) == totalCalculatedExchangeValue);
			} catch (Exception e) {
				System.err.println("Exception in Class - MyRewards_Gamer, Method - totalExchangeValueValidation : " + e);
				return false;
			}
		}
	
	/**
	 *Description - Validating total games count on My Reward page.
	 * @return - True - if shown games count equals to Calculated games count.
	 */
	public boolean totalGamesCountValidation(){

			try {
				WaitClass.waitForTime(4000);
				String totalGamesCountShown = gamesCount.getText();
				totalGamesCountShown = totalGamesCountShown.replace(" Games","");
				int gamesCount = listing.size();
				return (Integer.parseInt(totalGamesCountShown) == gamesCount);
				
			} catch (Exception e) {
				System.err.println("Exception in Class - MyRewards_Gamer, Method - totalGamesCountValidation : " + e);
				return false;
			}
		}
	
	/**
	 *Description - Validating search feature.
	 * @return - True - if search feature working correctly.
	 */
	public boolean searchValidation(){

			try {
				WaitClass.waitForTime(4000);
				boolean flag = true;
				searchBar.clear();
				int random = Utility.getRandomInt(0, listing.size()-1);
                WebElement randomGameName = listing.get(random);
                String gameName = randomGameName.getText();
				searchBar.sendKeys(gameName);
				WaitClass.waitForTime(3000);
                
				for(WebElement count : listing) {
					String gameNameFetched = count.getText();
					flag = flag && gameNameFetched.equals(gameName);		
				}
				return flag;
				
			} catch (Exception e) {
				System.err.println("Exception in Class - MyRewards_Gamer, Method - searchValidation : " + e);
				return false;
			}
		}
	
	/**
	 *Description - Validating search feature with wrong text.
	 * @return - True - if search feature working correctly.
	 */
	public boolean searchValidationWrongKeys(String searchText){

			try {
				WaitClass.waitForTime(4000);
				searchBar.clear();
				searchBar.sendKeys(searchText);
				WaitClass.waitForTime(3000);
				WebElement noGameText = driver.findElement(By.xpath("//h3[text()='No Games']"));
				boolean flag = noGameText.isDisplayed();
				return flag;
				
			} catch (Exception e) {
				System.err.println("Exception in Class - MyRewards_Gamer, Method - searchValidationWrongKeys : " + e);
				return false;
			}
		}
	
	/**
	 *Description - Validating for game name filter Drop-down.
	 * @return - True - if game name filter Drop-down correctly.
	 */
	public boolean gameNameDropdownFilter(){

			try {
				WaitClass.waitForTime(4000);
				boolean flag = true;
				gameNamefilterDropdown.click();
				int random = Utility.getRandomInt(0, listing.size()-1);
                WebElement randomGameName = listing.get(random);
                String gameName = randomGameName.getText();
                gameNamefilterDropdownSearchBar.clear();
				WaitClass.waitForTime(4000);
				gameNamefilterDropdownSearchBar.sendKeys(gameName);
				WaitClass.waitForTime(3000);
			    driver.findElement(By.xpath("//div[text() = '"+gameName+"']//input")).click();
			    
				for(WebElement count : listing) {
					String gameNameFetched = count.getText();
					flag = flag && gameNameFetched.equals(gameName);		
				}
				driver.findElement(By.xpath("//div")).click();
				WaitClass.waitForTime(2000);
				clearAllfilter.click();
				return flag;
				
			} catch (Exception e) {
				System.err.println("Exception in Class - MyRewards_Gamer, Method - gameNameDropdownFilter : " + e);
				return false;
			}
		}
	
	/**
	 * Method to check the sort functionality.
	 * @param gameName - Integer type parameter. 1 = Ascending order, 2 = Descending order, 0 = Not in use.
	 * @param qaPoints - Integer type parameter. 1 = Ascending order, 2 = Descending order, 0 = Not in use.
	 * @param exchangeValue - Integer type parameter. 1 = Ascending order, 2 = Descending order, 0 = Not in use.
	 * @return - True if sort if working.
	 */
	public boolean checkSort(int gameName, int qxPoints, int exchangeValue) {
		try {
			if(gameName == 1) {
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for(int i = 0 ; i < listing.size(); i++) {
					data.add(listing.get(i).getText().toString().toLowerCase());
				}
				Collections.sort(data);
				gameNameSortAsc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listing.size(); i++) {
					sortedData.add(listing.get(i).getText().toString().toLowerCase());
				}
				return data.equals(sortedData);
			}
			if(gameName == 2) {
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for(int i = 0 ; i < listing.size(); i++) {
					data.add(listing.get(i).getText().toString().toLowerCase());
				}
				Collections.sort(data, Collections.reverseOrder());
				gameNameSortDesc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listing.size(); i++) {
					sortedData.add(listing.get(i).getText().toString().toLowerCase());
				}
				return data.equals(sortedData);
			}
			if(qxPoints == 1) {
				ArrayList<Integer> tempData = new ArrayList<Integer>();
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for(int i = 0 ; i < listingQxPoint.size(); i++) {
					String qxPointsString = (listingQxPoint.get(i).getText().replace(",", ""));
					tempData.add(Integer.parseInt(qxPointsString));
				}
				
				Collections.sort(tempData);
				for(int i = 0; i < tempData.size(); i++) {
					data.add(tempData.get(i)+"");
				}
				qxPointSortAsc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listingQxPoint.size(); i++) {
					sortedData.add(listingQxPoint.get(i).getText().replace(",", "").toString());
				}
				return data.equals(sortedData);
			}
			if(qxPoints == 2) {
				ArrayList<Integer> tempData = new ArrayList<Integer>();
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for(int i = 0 ; i < listingQxPoint.size(); i++) {
					String qxPointsString = (listingQxPoint.get(i).getText().replace(",", ""));
					tempData.add(Integer.parseInt(qxPointsString));
				}
				Collections.sort(tempData, Collections.reverseOrder());
				for(int i = 0; i < tempData.size(); i++) {
					data.add(tempData.get(i)+"");
				}
				
				qxPointSortdesc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listingQxPoint.size(); i++) {
					sortedData.add(listingQxPoint.get(i).getText().toString());
				}
				return data.equals(sortedData);
			}
			
			if(exchangeValue == 1) {
				ArrayList<Integer> tempData = new ArrayList<Integer>();
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for(int i = 0 ; i < listingExchangeValue.size(); i++) {
					String qxPointsString = (listingExchangeValue.get(i).getText().replace("$", "").replace(",", ""));
					tempData.add(Integer.parseInt(qxPointsString));
				}
				Collections.sort(tempData);
				for(int i = 0; i < tempData.size(); i++) {
					data.add("$"+tempData.get(i));
				}
				exchangeValueSortAsc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listingExchangeValue.size(); i++) {
					sortedData.add(listingExchangeValue.get(i).getText().replace(",", "").toString());
				}
				return data.equals(sortedData);
			}
			if(exchangeValue == 2) {
				ArrayList<Integer> tempData = new ArrayList<Integer>();
				ArrayList<String> data = new ArrayList<String>();
				ArrayList<String> sortedData = new ArrayList<String>();
				for(int i = 0 ; i < listingExchangeValue.size(); i++) {
					String qxPointsString = (listingExchangeValue.get(i).getText().replace("$", "").replace(",", ""));
					tempData.add(Integer.parseInt(qxPointsString));
				}
				Collections.sort(tempData, Collections.reverseOrder());
				for(int i = 0; i < tempData.size(); i++) {
					data.add("$"+tempData.get(i));
				}
				exchangeValueSortDesc.click();
				WaitClass.waitForTime(2000);
				for(int i = 0 ; i < listingExchangeValue.size(); i++) {
					sortedData.add(listingExchangeValue.get(i).getText().toString());
				}
				return data.equals(sortedData);
			}


			return false;
		}
		catch(Exception e) {
			System.err.println("Exception in Class - MyRewards_Gamer, Method - checkSort "+e);
			return false;
		}
	}
	
	/**
	 * Method to check the action buttons functionality.
	 * @param redeemButton - Integer type parameter.
	 * @param exchangeButton - Integer type parameter.
	 * @param exchangeButtonClick - Integer type parameter.
	 * @return - True if action buttons working.
	 */
	public boolean exchangeAndRedeemButtonsValidation(int redeemButton, int exchangeButton, int exchangeButtonClick ) {
		try {
			if(redeemButton == 1) {
				WebElement redeem = driver.findElement(By.xpath("(//button[@class='btn btn-primary btn btn-primary'])[1]"));
				boolean flag = redeem.isDisplayed();
				redeem.click();
				flag = flag && driver.findElement(By.xpath("//div[text()='Redeem']")).isDisplayed();
				driver.navigate().back();
				return flag;
				
			}
			
			else if(exchangeButton == 1) {
				List<WebElement> exchangeButtons = driver.findElements(By.xpath("//button[@class='btn btn-primary btn btn-primary']"));
				boolean flag = true;
				for(int i = 0 ; i < exchangeButtons.size(); i++) {
					flag = flag && (exchangeButtons.get(i)).isDisplayed();
				} 
				
				return flag;
			}
			
			else if(exchangeButtonClick == 1) {
				int random = Utility.getRandomInt(1, listing.size()-1);
				WebElement randomGameName = listing.get(random);
				String gameName = randomGameName.getText();
				WebElement randomExchangeButton = listingActionButtons.get(random);
				
				randomExchangeButton.click();
				WaitClass.waitForTime(3000);
				WebElement pageHeading = driver.findElement(By.xpath("//div[text() = '"+gameName+"']"));
				String heading = pageHeading.getText();
				return (gameName.equals(heading));
				
			}
				
				return false;
			}
		catch(Exception e) {
			System.err.println("Exception in Class - MyRewards_Gamer, Method - exchangeAndRedeemButtonsValidation "+e);
			return false;
		}
	}
	
	/**
	 * *Description - Validating for points slider filter.
	 * @param lowerSlider - takes integer value , 1 - true , 0 -false.
	 * @param upperSlider - takes integer value , 1 - true , 0 -false.
	 * @return - True - if points slider filter correctly.
	 */
	/*
	public boolean pointsSliderFilter(int lowerSlider, int upperSlider){
		
			try {
				int sliderYAxisValue = Integer.parseInt(Utility.getPropertiesFile("primaryLogin", "yAxisvalue"));
				int sliderLowerXAxisValue = Integer.parseInt(Utility.getPropertiesFile("primaryLogin", "xAxisPointsValueLower"));
				int sliderUpperXAxisValue = Integer.parseInt(Utility.getPropertiesFile("primaryLogin", "xAxisPointsValueUpper"));
				if(lowerSlider == 1) {
				int count1 = 0;
				int count2 = 0;
				WaitClass.waitForTime(4000);
				WebElement slider = driver.findElement(By.xpath("(//span[@class='MuiSlider-root MuiSlider-colorPrimary'])[1]/span[3]"));
				String minValue = slider.getAttribute("aria-valuemin");
				for(int i = 0; i<listingQxPoint.size(); i++) {
					String pointsListingStr = listingQxPoint.get(i).getText().replace(",", "");
					boolean flag = minValue.equals(pointsListingStr);
					if(flag == true) {
						    totalCount1 = count1 + 1;
					}
				}
				String countBeforeFilter = totalCount1+"";
				Actions move =new Actions(driver);
				slider.click();
			    move.dragAndDropBy(slider, sliderLowerXAxisValue, sliderYAxisValue).perform();
			    for(int i = 0; i<listingQxPoint.size(); i++) {
					String pointsListingStr = listingQxPoint.get(i).getText().replace(",", "");
					boolean flag = minValue.equals(pointsListingStr);
					if(flag == true) {
						
						 totalcount2 = count2 + 1;
					}
					else {
						totalcount2 = 0;
					}
				}
			    String countafterFilter = totalcount2+"";
			    if((countBeforeFilter.equals(countafterFilter))) {
			    	 return false;
			    }
			    else if(totalcount2 == 0) {
			    	return true;
			    }
			    else {
			    	return false;
			      }
				}
				if(upperSlider == 1) {
					driver.findElement(By.xpath("(//a[@href='#/inner/redeemCash'])[2]")).click();
					myRewardTab.click();
					int count1 = 0;
					int count2 = 0;
					WebElement slider = driver.findElement(By.xpath("(//span[@class='MuiSlider-root MuiSlider-colorPrimary'])[1]/span[4]"));
					String maxValue = slider.getAttribute("aria-valuemax");
					for(int i = 0; i<listingQxPoint.size(); i++) {
						String pointsListingStr = listingQxPoint.get(i).getText().replace(",", "");
						boolean flag = maxValue.equals(pointsListingStr);
						if(flag == true) {
							    totalCount3 = count1 + 1;
						}
					}
					String countBeforeFilter = totalCount3+"";
					Actions move =new Actions(driver);
					slider.click();
				    move.dragAndDropBy(slider, sliderUpperXAxisValue, sliderYAxisValue).perform();
				    for(int i = 0; i<listingQxPoint.size(); i++) {
						String pointsListingStr = listingQxPoint.get(i).getText().replace(",", "");
						boolean flag = maxValue.equals(pointsListingStr);
						if(flag == true) {
							
							 totalcount4 = count2 + 1;
						}
						else {
							totalcount4 = 0;
						}
					}
				    String countafterFilter = totalcount4+"";
				    if((countBeforeFilter.equals(countafterFilter))) {
				    	 return false;
				    }
				    else if(totalcount4 == 0) {
				    	return true;
				    }
				    else {
				    	return false;
				      }
					}
				return false;
			} catch (Exception e) {
				System.err.println("Exception in Class - MyRewards_Gamer, Method - pointsSliderFilter : " + e);
				return false;
			}
		}
		*/
	
	/**
	 * *Description - Validating for points slider filter.
	 * @return - True - if points slider filter correctly.
	 */
	public boolean pointsSliderFilter() {
		try {
			ArrayList<String> lista = new ArrayList<String>();

			float datavalue = 0;
			boolean flag = false;
			WaitClass.waitForTime(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//label[text()='Points']/following-sibling::div/span/span)[3]")));
			WaitClass.waitForTime(3000);
			WebElement low = driver
					.findElement(By.xpath("(//label[text()='Points']/following-sibling::div/span/span)[3]"));
			WaitClass.waitForTime(3000);
			int xwidth = low.getSize().width;
			WaitClass.waitForTime(3000);
			Actions act = new Actions(driver);
			WaitClass.waitForTime(3000);
			act.clickAndHold(low).moveByOffset(xwidth * 3, 0).release().build().perform();
			WaitClass.waitForTime(3000);
			List<WebElement> li = driver.findElements(By.xpath("//div[@class='table-list-item d-flex align-items-center']/div[2]"));
			float lowvalue = Float.parseFloat(low.getText());
			for (int i = 0; i <= li.size() - 1; i++) {
				String listvalue = li.get(i).getText();
				String amvalue = listvalue.replace("$", "").replace(",", "");
				lista.add(amvalue);
			}

			String data = lista.get(0);
			datavalue = Float.parseFloat(data);
			if (datavalue > lowvalue) {
				flag = true;
			}
			Assert.assertTrue(flag, "Value is not Matching");
			WaitClass.waitForTime(3000);
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait1.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//label[text()='Points']/following-sibling::div/span/span)[4]")));
			WaitClass.waitForTime(3000);
			WebElement high = driver
					.findElement(By.xpath("(//label[text()='Points']/following-sibling::div/span/span)[4]"));
			WaitClass.waitForTime(3000);
			int Ywidth = high.getSize().width;
			WaitClass.waitForTime(3000);
			Actions act1 = new Actions(driver);
			WaitClass.waitForTime(3000);
			act1.clickAndHold(high).moveByOffset(-Ywidth * 3, 0).release().build().perform();
			WaitClass.waitForTime(5000);
			act1.clickAndHold(high).moveByOffset(Ywidth * 5, 0).release().build().perform();
			return true;

		}

		catch (Exception e) {

			System.err.println("Exception in Class - MyRewards_Gamer, Method - pointsSliderFilter : " + e);
			return false;
		}

	}
	
	/**
	 * *Description - Validating for Exchange Value slider filter.
	 * @param lowerSlider - takes integer value , 1 - true , 0 -false.
	 * @param upperSlider - takes integer value , 1 - true , 0 -false.
	 * @return - True - if Exchange value slider filter correctly.
	 *//*
	public boolean exchangeValueSliderFilter(int lowerSlider, int upperSlider){
		
			try {
				int sliderYAxisValue = Integer.parseInt(Utility.getPropertiesFile("primaryLogin", "yAxisvalue"));
				int sliderLowerXAxisValue = Integer.parseInt(Utility.getPropertiesFile("primaryLogin", "xAxisExchangeValueLower"));
				int sliderUpperXAxisValue = Integer.parseInt(Utility.getPropertiesFile("primaryLogin", "xAxisExchangeValueUpper"));
				driver.findElement(By.xpath("(//a[@href='#/inner/redeemCash'])[2]")).click();
				myRewardTab.click();
				if(lowerSlider == 1) {
				int count1 = 0;
				int count2 = 0;
				WaitClass.waitForTime(4000);
				WebElement slider = driver.findElement(By.xpath("(//span[@class='MuiSlider-root MuiSlider-colorPrimary'])[2]/span[3]"));
				String minValue = slider.getAttribute("aria-valuemin");
				for(int i = 0; i<listingExchangeValue.size(); i++) {
					String pointsListingStr = listingExchangeValue.get(i).getText().replace(",", "").replace("$", "");
					boolean flag = minValue.equals(pointsListingStr);
					if(flag == true) {
						totalExchangecount1 = count1 + 1;
					}
				}
				String countBeforeFilter = totalExchangecount1+"";
				Actions move =new Actions(driver);
				slider.click();
			    move.dragAndDropBy(slider, sliderLowerXAxisValue, sliderYAxisValue).perform();
			    for(int i = 0; i<listingExchangeValue.size(); i++) {
					String pointsListingStr = listingExchangeValue.get(i).getText().replace(",", "").replace("$", "");
					boolean flag = minValue.equals(pointsListingStr);
					if(flag == true) {
						
						totalExchangecount2 = count2 + 1;
					}
					else {
						totalExchangecount2 = 0;
					}
				}
			    String countafterFilter = totalExchangecount2+"";
			    if((countBeforeFilter.equals(countafterFilter))) {
			    	 return false;
			    }
			    else if(totalExchangecount2 == 0) {
			    	return true;
			    }
			    else {
			    	return false;
			    }
				}
				
				if(upperSlider == 1) {
					driver.findElement(By.xpath("(//a[@href='#/inner/redeemCash'])[2]")).click();
					myRewardTab.click();
					WaitClass.waitForTime(3000);
					int count1 = 0;
					int count2 = 0;
					WebElement slider = driver.findElement(By.xpath("(//span[@class='MuiSlider-root MuiSlider-colorPrimary'])[2]/span[4]"));
					String maxValue = slider.getAttribute("aria-valuemax");
					for(int i = 0; i<listingExchangeValue.size(); i++) {
						String pointsListingStr = listingExchangeValue.get(i).getText().replace(",", "").replace("$", "");
						boolean flag = maxValue.equals(pointsListingStr);
						if(flag == true) {
							totalExchangecount3 = count1 + 1;
						}
					}
					String countBeforeFilter = totalExchangecount3+"";
					Actions move =new Actions(driver);
					slider.click();
				    move.dragAndDropBy(slider, sliderUpperXAxisValue, sliderYAxisValue).perform();
				    for(int i = 0; i<listingExchangeValue.size(); i++) {
						String pointsListingStr = listingExchangeValue.get(i).getText().replace(",", "").replace("$", "");
						boolean flag = maxValue.equals(pointsListingStr);
						if(flag == true) {
							
							totalExchangecount4 = count2 + 1;
						}
						else {
							totalExchangecount4 = 0;
						}
					}
				    String countafterFilter = totalExchangecount4+"";
				    if((countBeforeFilter.equals(countafterFilter))) {
				    	 return false;
				    }
				    else if(totalExchangecount4 == 0) {
				    	return true;
				    }
				    else {
				    	return false;
				    }
				}
				return false;
			} catch (Exception e) {
				System.err.println("Exception in Class - MyRewards_Gamer, Method - exchangeValueSliderFilter : " + e);
				return false;
			}
		}
	*/
	/**
	 * *Description - Validating for Exchange Value slider filter.
	 * @return - True - if Exchange value slider filter correctly.
	 */
	public boolean exchangeValueSliderFilter() {
		try {
			ArrayList<String> lista = new ArrayList<String>();

			float datavalue = 0;
			boolean flag = false;
			WaitClass.waitForTime(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//label[text()='Exchange Value']/following-sibling::div/span/span)[3]")));
			WaitClass.waitForTime(3000);
			WebElement low = driver
					.findElement(By.xpath("(//label[text()='Exchange Value']/following-sibling::div/span/span)[3]"));
			WaitClass.waitForTime(3000);
			int xwidth = low.getSize().width;
			WaitClass.waitForTime(3000);
			Actions act = new Actions(driver);
			WaitClass.waitForTime(3000);
			act.clickAndHold(low).moveByOffset(xwidth * 3, 0).release().build().perform();
			WaitClass.waitForTime(3000);
			List<WebElement> li = driver.findElements(By.xpath("//div[@class='table-list-item d-flex align-items-center']/div[3]"));
			float lowvalue = Float.parseFloat(low.getText());
			for (int i = 0; i <= li.size() - 1; i++) {
				String listvalue = li.get(i).getText();
				String amvalue = listvalue.replace("$", "").replace(",", "");
				lista.add(amvalue);
			}

			String data = lista.get(0);
			datavalue = Float.parseFloat(data);
			if (datavalue > lowvalue) {
				flag = true;
			}
			Assert.assertTrue(flag, "Value is not Matching");
			WaitClass.waitForTime(3000);
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait1.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//label[text()='Exchange Value']/following-sibling::div/span/span)[4]")));
			WaitClass.waitForTime(3000);
			WebElement high = driver
					.findElement(By.xpath("(//label[text()='Exchange Value']/following-sibling::div/span/span)[4]"));
			WaitClass.waitForTime(3000);
			int Ywidth = high.getSize().width;
			WaitClass.waitForTime(3000);
			Actions act1 = new Actions(driver);
			WaitClass.waitForTime(3000);
			act1.clickAndHold(high).moveByOffset(-Ywidth * 3, 0).release().build().perform();
			WaitClass.waitForTime(5000);
			act1.clickAndHold(high).moveByOffset(Ywidth * 5, 0).release().build().perform();
			return true;

		}

		catch (Exception e) {

			System.err.println("Exception in Class - MyRewards_Gamer, Method - exchangeValueSliderFilter : " + e);
			return false;
		}

	}
}

	

