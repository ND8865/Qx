package BaseClass;


import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import UtilityClass.EventListeners;
import UtilityClass.Utility;
import UtilityClass.WaitClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverClass {
	
  public static WebDriver eDriver = null;
  public static WebDriver driver = null;
  
  
  /**
   * Method to open a browser instance and redirect to the website.
   * @param browser - The browser to open - chrome, safari, firefox
   * @param site - admin, partner, gamer
   * @return - WebDriver instance when the website is opened.
   */
  public static WebDriver setDriver(String browser , String site){
	  if(browser.equals("chrome")){
		  WebDriverManager.chromedriver().setup();
		  ChromeOptions  ob = new ChromeOptions();
		 ob.setPageLoadStrategy(PageLoadStrategy.NONE);
		  eDriver = new ChromeDriver(ob);
		  eDriver.manage().window().maximize();
		  WebDriverListener listener = new EventListeners();
		  driver = new EventFiringDecorator(listener).decorate(eDriver); 
		  
	  }
	  else if(browser.equals("safari")){
		  eDriver = new SafariDriver();
		  eDriver.manage().window().maximize();
		  WebDriverListener listener = new EventListeners();
		  driver = new EventFiringDecorator(listener).decorate(eDriver); 
	  }
	  else if(browser.contentEquals("firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		  FirefoxOptions ob = new FirefoxOptions();
		  ob.setPageLoadStrategy(PageLoadStrategy.NONE);
		  eDriver = new FirefoxDriver(ob);
		  eDriver.manage().window().maximize();
		  WebDriverListener listener = new EventListeners();
		  driver = new EventFiringDecorator(listener).decorate(eDriver); 
	  }
	  try {
		  if(site.equals("admin")) {
			  driver.get(Utility.getPropertiesFile("link","admin"));
			  WaitClass.waitForTime(8000);
			  try {
				  driver.findElement(By.xpath("//input[@name = 'username']")).isDisplayed();
			  }
			  catch(Exception e) {
				  driver.get(Utility.getPropertiesFile("link","admin"));
				  WaitClass.waitForTime(8000);
			  }
		  }
		  else if(site.equals("partner")) {
			  driver.get(Utility.getPropertiesFile("link","partner"));
			  WaitClass.waitForTime(8000);
			  try {
				  driver.findElement(By.xpath("//input[@name = 'username']")).isDisplayed();
			  }
			  catch(Exception e) {
				  driver.get(Utility.getPropertiesFile("link","partner"));
				  WaitClass.waitForTime(8000);
			  }
		  }
		  else if(site.equals("gamer")) {
			  driver.get(Utility.getPropertiesFile("link","gamer"));
			  WaitClass.waitForTime(15000);
			  try {
				  driver.findElement(By.xpath("//input[@name = 'username']")).isDisplayed();
			  }
			  catch(Exception e) {
				  driver.get(Utility.getPropertiesFile("link","gamer"));
				  WaitClass.waitForTime(8000);
			  }
		  }
		  else {
			  driver.get(site);
		  }
	  }catch(Exception e) {}
	  
	  return driver;
  }
  
}
