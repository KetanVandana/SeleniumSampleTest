package WaitConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitWait {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		/**
		 * Wait Concept
		 * 2 Type of Wait
		 * 1) Static Wait -> Thread.sleep(2000);
		 * 2) Dynamic Wait
		 * 		a)Implicit Wait
		 * 			If we have a implicit wait of 10 sec and ele found in 2 secs 8 sec will be ignored.
		 * 			Its a global wait, if we want to modify the timeout we have to override it.
		 * 			Its only applicable for web elements not applicable for non web elements like Alerts, Title, URL etc.
		 * 		    driver.manage().timeout().implicitlyWait(Duration.ofSeconds(10));
		 * 		b)Explicit Wait
		 * 			Its not a global wait, can be applied for a specific element
		 * 			Can be used for non web element like Alerts, Title and URL.
		 * 			i)WeDriver Wait
		 * 			ii)Fluent Wait
		 * 
		 */

		By locator = By.id("userId");
		By checkoutLocator = By.xpath("//button[text()='Checkout here']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//An expectation for checking that an element is present on the DOM of a page. This does not necessarily mean that the element is visible
		wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys("Vandana");
		
		//VisibilityofElementLocated means the ele is not only displayed but also has height and width > 0.		
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutLocator)).click();
		
		
		
		
		
	}

}
