package TestAutomation;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil{
	WebDriver driver = null;
	public WebDriver launchBroswer(String browser) {		
		
		switch (browser.toLowerCase()) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\14van\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "edge":
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\14van\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new EdgeDriver();
			break;
		case "firefox":
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\14van\\Downloads\\geckodriver-v0.32.0-win-aarch64\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Please pass the right broswer: " + browser);
			break;
		}
		return driver;

	}
	
	public void launchUrl(String url) {	
		driver.get(url);
	}

	public void launchUrl(URL url) {		
		String strUrl = String.valueOf(url);
		driver.get(strUrl);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void CloseBrowser() {
		driver.close();
	}
	
	public void QuitBrowser() {
		driver.quit();
	}
	
}
