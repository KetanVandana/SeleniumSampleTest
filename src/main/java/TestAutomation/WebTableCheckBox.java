package TestAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableCheckBox {

	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.findElement(By.xpath(getXpath("Garry.White"))).click();
		driver.findElement(By.xpath(getXpath("Joe.Root"))).click();
		
	}

	public static String getXpath(String headerName) {
		
		return "//a[text()='"+headerName+"']/parent::td/preceding-sibling::td/input";
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
}
