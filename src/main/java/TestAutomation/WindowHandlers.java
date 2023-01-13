package TestAutomation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlers {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String pwID = driver.getWindowHandle();
		
		By liLocator = By.xpath("//a[contains(@href,'linkedin')]");
		By fbLocator = By.xpath("//a[contains(@href,'facebook')]");
		By twLocator = By.xpath("//a[contains(@href,'twitter')]");
		By youLocator = By.xpath("//a[contains(@href,'youtube')]");
		
		ArrayList<By> locators = new ArrayList<>();
		
		locators.add(liLocator);
		locators.add(fbLocator);
		locators.add(twLocator);
		locators.add(youLocator);
		
		for(int i=0; i<locators.size(); i++) {			
			doClick(locators.get(i));
		}
			
		Set<String> handlers = driver.getWindowHandles(); 
		//Iterator<String> it = handlers.iterator();
		
		
		//Convert set to List
		List<String> listHandlers = new ArrayList<>(handlers);
		Iterator<String> it = listHandlers.iterator();
		
		while(it.hasNext()) {
			String cwId = it.next();
			driver.switchTo().window(cwId);
			System.out.println("Child Window Id: "+ cwId);
			System.out.println(driver.getCurrentUrl());
			
			if(!pwID.equals(cwId)){
				driver.close();
				System.err.println("Child Window gets closed...");
			}else {
				System.out.println("Its Parent Window, Please dont close it!");
			}	
			
		}

	}

	public static WebElement doGetElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doClick(By locator) {
		WebElement ele = doGetElement(locator);
		ele.click();	
	}
}
