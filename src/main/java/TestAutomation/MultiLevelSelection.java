package TestAutomation;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultiLevelSelection {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		
		driver.get("https://www.bigbasket.com");
		Thread.sleep(2000);
		
	//	doMultiLevelSelection("a", "Fruits & Vegetables", "Fresh Vegetables", "Potato, Onion & Tomato");
		By level1Menulocator = By.xpath("//*[@id=\"navBarMegaNav\"]//a");
		By level2Menulocator = By.xpath("(//div[@class='col-md-3 pad-rt-0 desgn-fix'])[2]//a");
		By level3Menulocator = By.xpath("(//div[@class='col-md-4 col-sm-6 col-xs-12 pad-0 change-wid'])[2]//a");
		
		doMultiLevelSelectionPrint(level1Menulocator, level2Menulocator, level3Menulocator);

	}
	
	public static WebElement GetElement(By locator) {
		return driver.findElement(locator);
	}
	public static List<WebElement> GetElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void doClick(By locator) {
		GetElement(locator).click();
	}
	
	
	public static void doMultiLevelSelectionPrint(By level1Menulocator, By level2Menulocator, By level3Menulocator) {

		By parentMenu = By.xpath("//a[@qa='categoryDD']");

		WebElement parentMenuElement = GetElement(parentMenu);
		Actions act = new Actions(driver);
		act.moveToElement(parentMenuElement).build().perform();
		

		List<WebElement> level1MenuElements = GetElements(level1Menulocator);
		int counter1 = 0;
		Actions actLevel1 = new Actions(driver);
		Actions actLevel21 = new Actions(driver);
		
		for (WebElement e2 : level1MenuElements) {		
			//actLevel1.moveToElement(level1MenuElements.get(counter1)).build().perform();
			actLevel1.moveToElement(e2).build().perform();
			counter1++;
			List<WebElement> level2MenuElements = GetElements(level2Menulocator);
			int counter = 0;
			for (WebElement e : level2MenuElements) {
				actLevel21.moveToElement(e).build().perform();
				counter++;

				List<WebElement> level3MenuElement = GetElements(level3Menulocator);
				int counter3 = 0;
				List<String> level3MenuElementTxt = new ArrayList<String>();
				for (WebElement e1 : level3MenuElement) {
					String txt = e1.getText();
					counter3++;
					level3MenuElementTxt.add(txt);
				}
				System.out.println("Total count: " + counter3 + level3MenuElementTxt.toString());

			}
			System.out.println("Total count: " + counter + level2MenuElements.toString());
		}
		System.out.println("Total count: " + counter1 + level1MenuElements.toString());

	}

	public static void doMultiLevelSelection(String htmlTag, String level1Locator, String level2Locator, String level3Locator) {
		
        By parentMenu = By.xpath("//a[@qa='categoryDD']");
		
		WebElement parentMenuElement = GetElement(parentMenu);
		Actions act = new Actions(driver);
		act.moveToElement(parentMenuElement).build().perform();
		
		By level1Menu = By.xpath("(//"+htmlTag+"[text()='"+level1Locator+"'])[2]");
		WebElement level1MenuElement =GetElement(level1Menu);
		Actions actLevel1 = new Actions(driver);
		actLevel1.moveToElement(level1MenuElement).build().perform();

		By level2Menu = By.xpath("(//"+htmlTag+"[text()='"+level2Locator+"'])[2]");
		WebElement level2MenuElement =GetElement(level2Menu);
		Actions actLevel2 = new Actions(driver);
		actLevel2.moveToElement(level2MenuElement).build().perform();
		
		By level3Menu = By.xpath("(//"+htmlTag+"[text()='"+level3Locator+"'])[2]");
		doClick(level3Menu);
		

//		
//		By level3Menulocator = By.xpath("(//div[@class='col-md-4 col-sm-6 col-xs-12 pad-0 change-wid'])[2]//a");
//		List<WebElement> level3MenuElement = GetElements(level3Menulocator);
//		int count3 = 0;
//		List<String> level3MenuElementTxt = new ArrayList<String>();
//		for(WebElement e: level3MenuElement) {
//			String txt = e.getText();
//			count3++;
//			level3MenuElementTxt.add(txt);
//		}
//		System.out.println("Total count: "+count3+ level3MenuElementTxt.toString());

		
//		By level3Menulocator = By.xpath("(//div[@class='col-md-4 col-sm-6 col-xs-12 pad-0 change-wid'])[2]//a");
//		List<WebElement> level3MenuElement = GetElements(level3Menulocator);
//		int count3 = 0;
//		List<String> level3MenuElementTxt = new ArrayList<String>();
//		for(WebElement e: level3MenuElement) {
//			String txt = e.getText();
//			count3++;
//			level3MenuElementTxt.add(txt);
//		}
//		System.out.println("Total count: "+count3+ level3MenuElementTxt.toString());

		
//		
//		By level2Menulocator = By.xpath("(//div[@class='col-md-3 pad-rt-0 desgn-fix'])[2]//a");
//		List<WebElement> level2MenuElements = GetElements(level2Menulocator);
//		int count2 = 0;
//		List<String> level2MenuElementTxt = new ArrayList<String>();
//		for(WebElement e: level2MenuElements) {
//			String txt = e.getText();
//			count2++;
//			level2MenuElementTxt.add(txt);
//		}
//		System.out.println("Total count: "+count2+ level2MenuElementTxt.toString());
//		
//
//		
//		By level1Menulocator = By.xpath("//*[@id=\"navBarMegaNav\"]//a");
//		List<WebElement> level1MenuElements = GetElements(level1Menulocator);
//		int count1 = 0;
//		List<String> level1MenuElementTxt = new ArrayList<String>();
//		for(WebElement e: level1MenuElements) {
//			String txt = e.getText();
//			count1++;
//			level1MenuElementTxt.add(txt);
//		}
//		System.out.println("Total count: "+count1+ level1MenuElementTxt.toString());
		

		
		
	}

	
}
