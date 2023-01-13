package TestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SvgElement {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("laptop");
		
		By locator = By.xpath("//*[local-name()='svg']");
		WebElement e = driver.findElement(locator);
		
		Actions act = new Actions(driver);
		
		act.click(e).build().perform();
	}

}
