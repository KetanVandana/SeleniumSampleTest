package TestAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class NumberOfLinksInPage {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		

		driver.get("http://www.target.com");

//		By linkTag = By.tagName("a");
//		List<WebElement> linkList = getElement(linkTag);
//		System.out.println("Total link available in Target Website: " + linkList.size());
//		printLinks(linkList);
//
//		By imgTag = By.tagName("img");
//		List<WebElement> imgList = getElement(imgTag);
//		System.out.println("Total Image available in Target Website: " + imgList.size());
//		doGetAttribute(imgList);

//		driver = new ChromeDriver();
//
//		driver.get("http://www.target.com");
		// Custom Xpath
		// By footerLink = By.xpath("//div[@ class = 'styles__LegalContainer-sc-vbvkc1-3 cneeOb h-display-flex h-flex-align-center h-flex-wrap h-text-hd5']/a");

		Thread.sleep(2000);
		System.out.println("-------------------------------------------------------------------------------------------------");
		By footerLink = By.xpath("//div[contains(@class,'styles__LegalContainer')]/a");
		List<WebElement> listFooter = getElement(footerLink);
		System.out.println("Total number of links in Footer: " + listFooter.size());
		doGetFooter(listFooter);

	}

	public static List<WebElement> getElement(By locator) {
		return driver.findElements(locator);
	}

	public static void doGetAttribute(List<WebElement> imgList) {
		for (WebElement e : imgList) {
			String srcImg = e.getAttribute("src");
			String altImg = e.getAttribute("alt");

			if ((!(srcImg == null)) && (!(altImg == null))) {
				System.out.println(srcImg + " || " + altImg);
			}

		}

	}

	public static void doGetFooter(List<WebElement> linkList) {
		int count = 0;
		for (WebElement e : linkList) {
			String linkText = e.getText();
			String href = e.getAttribute("href");
			count++;

			System.out.println(count + " || " + linkText + " || " + href);

		}
	}

	public static void printLinks(List<WebElement> linkList) {
		int count = 0;
		for (WebElement e : linkList) {
			String linkText = e.getText();
			String href = e.getAttribute("href");
			count++;
			if (!(linkText.length() == 0) && !(linkText == null)) {
				System.out.println(count + " || " + href + " || " + linkText);
			}
		}
	}

}
