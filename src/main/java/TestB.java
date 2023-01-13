import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestB {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\14van\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		WebDriver driver2 = new ChromeDriver();
		WebDriver driver3 = new ChromeDriver();
		
		driver1.get("http://www.amazon.com");
		driver1 = driver2;
		driver2.get("http://www.walmart.com");
		driver2 = driver3;
		driver3.get("http://www.target.com");
		driver3 = driver1;

		
		System.out.println("--------------");
		System.out.println("Driver 1 Title: " + driver1.getTitle());
		System.out.println("Driver 2 Title: " + driver2.getTitle());
		System.out.println("Driver 3 Title: " + driver3.getTitle());
		
		

	}

}
