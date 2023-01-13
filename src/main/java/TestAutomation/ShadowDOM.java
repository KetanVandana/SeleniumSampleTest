package TestAutomation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.asm.Advice.Return;

public class ShadowDOM {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//document.querySelector("#snacktime").shadowRoot.querySelector("#tea")
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(3000);
		driver.switchTo().frame("pact");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = (WebElement) js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
		ele.sendKeys("Masala Tea");

	}

}
