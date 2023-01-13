package TestAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CRMWebTable {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");
		//driver.findElement(By.xpath(getXpath("Garry.White"))).click();
		//driver.findElement(By.xpath(getXpath("Joe.Root"))).click();
		Thread.sleep(2000);
		//a[text()='Kishore Venkat']/parent::td/preceding-sibling::td/input
		
		By userName = By.xpath("//input[@name='username']");
		By password = By.xpath("//input[@name='password']");
		By btnLogin = By.xpath("//input[@value='Login']");
		
		
		doSendKeys(userName, "newautomation");
		doSendKeys(password, "selenium@12345");
		doClick(btnLogin);
		
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);
		By contacts = By.linkText("CONTACTS");
		//driver.findElement(By.linkText("CONTACTS")).click();
		doClick(contacts);
		
		String name = "deepti gupta";
		
		By nameLocator = By.xpath(getXpath(name));
		doClick(nameLocator);
		
		By compLocator = By.xpath(getCompanyXpath(name));
		String companyName = getElement(compLocator).getText();
		
		By phoneLocator = By.xpath(getPhoneXpath(name));
		String phoneNumber = getElement(phoneLocator).getText();
		
		
		By homePhoneLocator = By.xpath(getHomePhoneXpath(name));
		String homePhone = getElement(homePhoneLocator).getText();
		
		
		By mobileLocator = By.xpath(getMobileXpath(name));
		String mobileNumber = getElement(mobileLocator).getText();
		
		By emailLocator = By.xpath(getEmailXpath(name));
		String email = getElement(emailLocator).getText();
		
		By optionLocator = By.xpath(getOptionXpath(name));
		List<WebElement> options = getElements(optionLocator);
		
		System.out.println(options.size());
		for(WebElement e: options) {
			
			System.out.println(e.getAttribute("href"));
		}
		
		
		System.out.println("===========================================================");
		System.out.println("Company Name || Phone Number || Home Phone || Mobile Number || Email");
		System.out.println(companyName+" ||           "+phoneNumber+" ||    "+homePhone+"     || "+mobileNumber+"     || "+email);
	}
	
	public static String getOptionXpath(String headerName) {
		
		return "//a[text()='"+headerName+"']/parent::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/a";
		
	}

	public static String getEmailXpath(String headerName) {
		
		return "//a[text()='"+headerName+"']/parent::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td";
		
	}
	
	public static String getHomePhoneXpath(String headerName) {
		
		return "//a[text()='"+headerName+"']/parent::td/following-sibling::td/following-sibling::td/following-sibling::td";
		
	}
	
	public static String getMobileXpath(String headerName) {
		
		return "//a[text()='"+headerName+"']/parent::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td";
		
	}
	
	public static String getPhoneXpath(String headerName) {
		
		return "//a[text()='"+headerName+"']/parent::td/following-sibling::td/following-sibling::td";
		
	}
	public static String getCompanyXpath(String headerName) {
		
		return "//a[text()='"+headerName+"']/parent::td/following-sibling::td/a";
		
	}

	public static String getXpath(String headerName) {
		
		return "//a[text()='"+headerName+"']/parent::td/preceding-sibling::td/input";
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	

}
