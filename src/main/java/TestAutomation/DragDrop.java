package TestAutomation;

import java.util.Set;
import java.util.Iterator;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.collect.Iterators;

public class DragDrop {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
//		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
//		
//		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\14van\\Desktop\\Interface Assignment.docx");
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//a[contains(@href,'linkedin')]")).click();
		
		String webPage = "Facebook";
		
		switch (webPage.toLowerCase()) {
		case "linkedin":
			By linkedinLocator = By.xpath("//a[contains(@href,'linkedin')]");
			doClickonElement(linkedinLocator);			
			break;
		case "facebook":
			By facebookLocator = By.xpath("//a[contains(@href,'facebook')]");
			doClickonElement(facebookLocator);			
			break;
		case "twitter":
			By twitterLocator = By.xpath("//a[contains(@href,'twitter')]");
			doClickonElement(twitterLocator);			
			break;
		case "youtube":
			By youtubeLocator = By.xpath("//a[contains(@href,'youtube')]");
			doClickonElement(youtubeLocator);			
			break;

		default:
			System.out.println("Please pass the right options...");
			break;
		}
		
//		Set<String> handler = driver.getWindowHandles();

//		
//		String parentWindowId = it.next();
//		String childWindowId = it.next();
//		
//		driver.switchTo().window(childWindowId);
//		
//		System.out.println(driver.getCurrentUrl());
//		
//		driver.switchTo().window(parentWindowId);
//		System.out.println(driver.getCurrentUrl());
		
		
//		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
//		
//		Actions act = new Actions(driver);
//		
//		By souceLocator = By.id("draggable");
//		By destinationLocator = By.id("droppable");
//		
//		WebElement sourceElement = getElement(souceLocator);
//		WebElement destinationElemet = getElement(destinationLocator);
//		
//		act.clickAndHold(sourceElement).release(destinationElemet).build().perform();
//		
//		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//		
//		Thread.sleep(200);
//		
//		
//		By jsAlert = By.xpath("//button[text()='Click for JS Alert']");
//		By jsConfirm = By.xpath("//button[text()='Click for JS Confirm']");
//		By jsPrompt = By.xpath("//button[text()='Click for JS Prompt']");
//			
//		doHandlePopups(jsAlert, "alert");
//		
//		doHandlePopups(jsConfirm, "confirm");
//		
//		doHandlePopups(jsPrompt, "Prompt");
//	
	}
	
	public static void doClickonElement(By locator) {
		
		doClick(locator);
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		
		String parentWindowId = it.next();
		String childWindowId = it.next();
		
		driver.switchTo().window(childWindowId);
		
		System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getCurrentUrl());
	}
	
	public static void doHandlePopups(By locatorElement, String type) throws InterruptedException {
		getElement(locatorElement).click();
		Alert alert = driver.switchTo().alert();
		String txt1 = alert.getText();
		System.out.println(txt1);
		if(type.equalsIgnoreCase("prompt")) {
			alert.sendKeys("Vandana");
		}
		Thread.sleep(200);
		alert.accept();
		
	}
	public static void doClick(By locatorElement) {
		
		getElement(locatorElement).click();
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
