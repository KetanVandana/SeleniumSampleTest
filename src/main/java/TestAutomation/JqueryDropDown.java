package TestAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDropDown {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.findElement(By.id("justAnInputBox")).click();

		By choiceLocator = By.xpath("//span[@class='comboTreeItemTitle']");

		doSelectChoices(choiceLocator, "All");
		

	}

	public static void doSelectChoices(By locator, String... choice) {

		List<WebElement> list = driver.findElements(locator);

		int count = 0;

		if (!choice[0].equalsIgnoreCase("all")) {
			for (int i = 0; i < choice.length; i++) {
				for (WebElement e : list) {
					String txt = e.getText();

					if (txt.equals(choice[i])) {
						e.click();
						count++;
						break;
					}
				}
			}
		}else try {
			for( WebElement e: list) {
				e.click();
			}
		}catch (Exception e){
			 
		}
		System.out.println(count + ": choice has been selected");
		
	}

}
