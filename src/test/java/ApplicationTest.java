import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApplicationTest {
static WebDriver driver;
	@BeforeMethod
	public static void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");		
	}
	
	@Test
	public static void validateRegisterPage() {
		boolean result = validateTitle("Register Account");
		Assert.assertEquals(result, true);
	}
	@Test
	public static void validateLogo() {
		By logoLocator = By.xpath("//img[@class='img-responsive']");
		boolean result = getElement(logoLocator).isDisplayed();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public static void fillRegistrationForm() {
		
		Random ran = new Random();
		
		By fNameLocator = By.id("input-firstname");
		By lNameLocator = By.id("input-lastname");
		By emailLocator = By.id("input-email");
		By telephoneLocator = By.id("input-telephone");
		By passLocator = By.id("input-password");
		By confirmPassLocator = By.id("input-confirm");
		By checkBoxLocator = By.xpath("//input[@name='agree']");
		By submitButtonLocator = By.xpath("//input[@class='btn btn-primary']");
		By confirmMsgLocator = By.xpath("//div[@class='col-sm-9']/h1");
		
		doSendKeys(fNameLocator, "Vandana918"+ran.nextInt());
		doSendKeys(lNameLocator, "Patel918"+ran.nextInt());
		doSendKeys(emailLocator, ran.nextInt()+"1487vandana918@gmail.com");
		doSendKeys(telephoneLocator, "9876545210");
		doSendKeys(passLocator, "vandana9180");
		doSendKeys(confirmPassLocator, "vandana9180");
		doClick(checkBoxLocator);
		doClick(submitButtonLocator);
		String txt = getElement(confirmMsgLocator).getText();
		System.out.println(txt);
		Assert.assertEquals(txt, "Your Account Has Been Created!");
		
		By contButtonLocator = By.xpath("//a[text()='Continue']");
		doClick(contButtonLocator);
		
		
		boolean result = validateTitle("My Account");	
		Assert.assertEquals(result, true);
		
	}
	
	@AfterMethod
	public static void tearDown() {
		driver.quit();
	}
	
	
	public static WebElement getElement(By locator) {
	 return driver.findElement(locator);	
	}
	public static void doSendKeys(By locator, String value) {
		 getElement(locator).sendKeys(value);	
	}
	public static void doClick(By locator) {
		 getElement(locator).click();	
	}
	public static boolean validateTitle(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.titleContains(value));
	}
}
