package UtilityClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaitClass {

	
	public static void waitForElement(WebElement element, WebDriver driver, int time){
		try{
			long currentTime = System.currentTimeMillis();
			long end = currentTime+time;
			while(System.currentTimeMillis() < end){
				try{
					if(element.isDisplayed() == true) {
						if(element.isEnabled() == true) {
							try {
								//driver.findElement(By.xpath("//div[@class = 'spinner-border']"));				//UPDATE CODE FOR LOADER IF ANY
							}
							catch(Exception e) {
								break;
							}
						}
					}
				}
				catch(Exception e){}
			}
		}
		catch(Exception e){
			System.err.println("Exception in class - WaitClass, in method - waitForElement :"+e);
		}
	}
	
	public static void waitForElement(By locator, WebDriver driver, int time){
		try{
			long currentTime = System.currentTimeMillis();
			long end = currentTime+time;
			while(System.currentTimeMillis() < end){
				try{
					List <WebElement> oo = driver.findElements(locator);
					if(oo.size() > 0) {
						if(driver.findElement(locator).isDisplayed() == true) {
							try {
								//driver.findElement(By.xpath("//div[@class = 'spinner-border']"));				//UPDATE CODE FOR LOADER IF ANY
							}
							catch(Exception e) {
								break;
							}
						}
					}
				}
				catch(Exception e){}
			}
		}
		catch(Exception e){
			System.err.println("Exception in class - WaitClass, in method - waitForElement - locator :"+e);
		}
	}
	
	public static void waitForTime(int time){
		try{
			long currentTime = System.currentTimeMillis();
			long end = currentTime+time;
			while(System.currentTimeMillis() < end){
				
			}
		}
		catch(Exception e){
			System.err.println("Exception in class - WaitClass, in method - waitForElement :"+e);
		}
	}
	
	
}
