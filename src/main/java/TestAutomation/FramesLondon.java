package TestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesLondon {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();		
		driver.get("http://londonfreelance.org/courses/frames/index.html");
		
		System.out.println(driver.findElements(By.tagName("frame")).size());
		
		String pageObject = driver.getWindowHandle();
		System.out.println(pageObject);
		
		driver.switchTo().frame("main");
		
		String txt = driver.findElement(By.tagName("h2")).getText();
		System.out.println(txt);
			
		driver.switchTo().defaultContent();
		System.out.println(driver.findElements(By.tagName("frame")).size());
		System.out.println(driver.getCurrentUrl());
		

	}

}
