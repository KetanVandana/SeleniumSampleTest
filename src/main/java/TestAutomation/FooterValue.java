package TestAutomation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterValue {
	static WebDriver driver;
	public static void main(String[] args) {
		
		
		/**
		 * Launch chrome browser
		 * open freshworks.com
		 * Validate Freshdesk footer link
		 */
		
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		By footerLocator = By.xpath("//div[contains(@class,'footer-left-section')]//a");
		
		List<String> elementTxtList = doGetFooterLinks(footerLocator);
		
		System.out.println(elementTxtList.toString());
		
		System.out.println("No of element in footer: "+elementTxtList.size());
		
		System.out.println("=============Validation===========================");
		if(elementTxtList.contains("Freshdesk")) {
			System.out.println("Pass");
		}
		
		By imgLocator = By.xpath("//img[contains(@class,'logo-fworks')]");
		
		boolean flag = driver.findElement(imgLocator).isDisplayed();
		if(flag == true) {
			System.out.println("Logo is displayed!");
		}else {
			System.out.println("Logo is not displayed!"
					);
			
		}
		
		isImgDisplayed(imgLocator);
		
		driver.close();

	}
	
	public static void isImgDisplayed(By locator) {
		int size;
		
		size = driver.findElements(locator).size();
		if (size > 0) {
			System.out.println("Total Number of Img Displayed is : "+ size);
		}else {
			System.out.println("Img is Not Displayed!");
		}
		
		
	}
	public static List<WebElement> getElement(By locator) {
		return driver.findElements(locator);
	}
	
	public static List<String> doGetFooterLinks(By locator) {
		
		List<WebElement> elementList = getElement(locator);
		List<String> elementTxtList	= new ArrayList<String>();
		
		for(WebElement e : elementList) {
			String txt = e.getText();
			elementTxtList.add(txt);
		}
		return elementTxtList;
	}

}
