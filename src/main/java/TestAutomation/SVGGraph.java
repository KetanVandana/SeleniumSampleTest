package TestAutomation;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGGraph {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
		
		System.out.println(driver.getCurrentUrl());
		
		By locator = By.xpath("//*[local-name()='svg' and @id ='map-svg']//*[name()='g' and @id='regions']//*[name()='path']");
		
		List<WebElement> list = driver.findElements(locator);
		
		System.out.println("Total number of states : "+list.size());
		Actions act = new Actions(driver);
		for(WebElement e: list) {		
			String txt = e.getAttribute("name");
			//act.moveToElement(e).build().perform();
			System.out.println(txt);
			if(txt.equalsIgnoreCase("New Jersey")) {
				System.out.println("My State: "+txt);
				act.click(e).build().perform();
				break;
			}
		}
		
		driver.switchTo().defaultContent();

	}

}

