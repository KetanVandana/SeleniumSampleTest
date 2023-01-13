import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class CalendarHandling {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		selectDate("6", "March 2028");

	}

	public static void selectDate(String day, String MMYY) {
		if (Integer.parseInt(day) > 31 && Integer.parseInt(day) < 1) {
			System.out.println("Wrong Day Passed !");
			return;
		}
		String monthYear[] = MMYY.split(" ");
		int year = Integer.parseInt(monthYear[1]);

		if ((year % 4 == 0 || year % 100 != 0 && year % 400 == 0) && MMYY.equalsIgnoreCase("February")
				&& Integer.parseInt(day) > 29) {
			System.out.println("Its Leap year...");
			System.out.println("Wrong Day passed !");
			return;

		} else if (MMYY.equalsIgnoreCase("February") && Integer.parseInt(day) > 28) {
			System.out.println("Wrong Day passed !");
			return;
		}

		By datePickerLocator = By.id("datepicker");
		doClick(datePickerLocator);
		By datePickerTitleLocator = By.xpath("//div[@class='ui-datepicker-title']");
		String actMonth = getElement(datePickerTitleLocator).getText();
		
		System.out.println(actMonth);
		while (!(actMonth.equalsIgnoreCase(MMYY))) {
			By nextBtnLocator = By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']");
			doClick(nextBtnLocator);
			actMonth = getElement(datePickerTitleLocator).getText();
		}
		By dayLocator = By.xpath("//a[text()='" + day + "']");
		doClick(dayLocator);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doClick(By locator) {
		getElement(locator).click();

	}
}
