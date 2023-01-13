package TestAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDowmCheckBox {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.findElement(By.id("justAnInputBox")).click();

		By choiceLocator = By.xpath("//span[@class='comboTreeItemTitle']");

		String choice = "aLL";
		
		switch (choice.toLowerCase()) {
		case "single":
			 doSelectSingleChoices(choiceLocator, "choice 1");
			 break;
		case "multiple":
			 doSelectMultipleChoices(choiceLocator, "choice 1", "choice 2", "choice 4");
			 break;
		case "all":
			 doSelectAllChoices(choiceLocator);
			 break;

		default:
			System.out.println("Please pass right selection...");
			break;
		}

		//driver.close();
	}

	public static void doSelectSingleChoices(By locator, String choice) {

		List<WebElement> list = driver.findElements(locator);
		boolean flag = false;
		for (WebElement e : list) {
			String txt = e.getText();

			if (txt.equals(choice)) {
				e.click();
				flag = true;
				break;
			}
		}
		if(flag == false) {
			System.out.println("No Selection has been made..." + choice);
		}else {
			System.out.println("Choice has been selected: " + choice);
		}
		
	}

	public static void doSelectMultipleChoices(By locator, String... choice) {

		List<WebElement> list = driver.findElements(locator);

		int count = 0;

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

		System.out.println(count + ": choice has been selected");

	}

	public static void doSelectAllChoices(By locator) {

		List<WebElement> list = driver.findElements(locator);
		int count = 0;
		for (WebElement e : list) {
			e.click();
			count++;
		}
		System.out.println(count + ": choice has been selected");
	}
}
