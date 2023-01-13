import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {
	

	static WebDriver driver;
	public static void main(String[] args) {
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\14van\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		
//		WebDriver driver = new ChromeDriver();
//		
//		driver.get("https:\\www.facebook.com");
//		
//		String title = driver.getTitle();
//		
//		System.out.println(title);
//		
//		if(title.equals(title)) {
//			System.out.println("Correct Title");
//		}else {
//			System.out.println("Incorrect Title");
//		}
//		
//		
//		driver.close();
		
		System.out.println("Enter the broswer name: ");
		Scanner sc = new Scanner(System.in);
		String browser = sc.next();
		
	
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\14van\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "edge":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\14van\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\14van\\Downloads\\geckodriver-v0.32.0-win-aarch64\\geckodriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			System.out.println("Please pass the right broswer: " + browser);
			break;
		}
		driver.get("https:\\www.facebook.com");
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		if(title.equals(title)) {
			System.out.println("Correct Title");
		}else {
			System.out.println("Incorrect Title");
		}
		
		
		driver.close();
		
		

		
		
	}

}
