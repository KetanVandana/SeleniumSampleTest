package TestAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleXpath {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		Thread.sleep(2000);
		//input[@id='input-password']/following-sibling::a
		//div[text()='Get to Know Us']/following-sibling::ul//a
		
		String xpath = getXpath("Make Money with Us");
		By locator = By.xpath(xpath);
		List<WebElement> list = getElements(locator);
		
		System.out.println(list.size());
		
		for(WebElement e: list) {
			String txt = e.getText();
			System.out.println(txt);
		}
		
	}

	
	public static String getXpath(String headerName) {
		
		return "//div[text()='"+headerName+"']/following-sibling::ul//a";
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
}
