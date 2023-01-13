package TestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.linkText("Kamloops, Canada"));
		
		String rightIndexValue = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		String leftIndexValue = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		String belowIndexValue = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		String aboveIndexvalue = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		
		System.out.println(ele.getText() + aboveIndexvalue +belowIndexValue+ leftIndexValue +rightIndexValue);

	}

}
