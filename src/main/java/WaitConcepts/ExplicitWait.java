package WaitConcepts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		By locator = By.xpath("//button[text()='Click for JS Prompt']");
		
		driver.findElement(locator).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		
//		String txt =  alert.getText();
//		System.out.println(txt);
//		alert.accept();
		System.out.println(getTextAlert(10));
		enterValueAlert("vandana", 10);
		acceptAlert(10);
		
		
//		driver.get("https://www.amazon.com/");
//		By locator = By.xpath("//a[text()='Amazon Newsletter']");
//
//		driver.findElement(locator).click();
//		String result = waitForUrlContains("https://email.aboutamazon.com/l/637851/2020-10-29/pd87g?Traffic_Source=Blog&Module=hat", 10);
//		System.out.println(result);
		
		
		}
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
//		boolean result = wait.until(ExpectedConditions.titleContains("Register"));
//
//		if(result == true) {
//			System.out.println("Register page is loaded...");
//		}else {
//			System.out.println("Expected page is not loaded...");
//		}
		
	public static Alert waitForAlertPresent(int timeout){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void acceptAlert (int timeout){
		 waitForAlertPresent(timeout).accept();
	}
	public static void dismissAlert (int timeout){
		 waitForAlertPresent(timeout).dismiss();
	}
	public static void enterValueAlert(String value, int timeout){
		 waitForAlertPresent(timeout).sendKeys(value);
	}
	public static String getTextAlert(int timeout){
		 return waitForAlertPresent(timeout).getText();
	}
	public static String waitForTitleContains(String titleFractionValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.titleContains(titleFractionValue))) {
			return driver.getCurrentUrl();
		}else {
			System.out.println("Expected browser is not launched...");
			return null;
		}
	}

	public static String waitForTitleIs(String titleFractionValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleIs(titleFractionValue))) {
			return driver.getCurrentUrl();
		} else {
			System.out.println("Expected browser is not launched...");
			return null;
		}
	}
	public static String waitForUrlContains(String titleFractionValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlContains(titleFractionValue))) {
			return driver.getCurrentUrl();
		} else {
			System.out.println("Expected browser is not launched...");
			return null;
		}

	}
	public static String waitForUrlToBe(String titleFractionValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlToBe(titleFractionValue))) {
			return driver.getCurrentUrl();
		} else {
			System.out.println("Expected browser is not launched...");
			return null;
		}

	}

}
