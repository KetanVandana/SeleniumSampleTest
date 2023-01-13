package TestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
public class RelativeLocatorsHomeWork {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.linkText("Joe.Root"));
		
		driver.findElement(with(By.tagName("td")).toLeftOf(ele)).click();
		System.err.println(ele.getText());
		System.out.println(driver.findElement(with(By.tagName("td")).toRightOf(ele)).getText());
		System.out.println(driver.findElement(with(By.tagName("td")).above(ele)).getText());
		
		System.out.println(driver.findElement(with(By.tagName("td")).below(ele)).getText());
		
		

	}

}
