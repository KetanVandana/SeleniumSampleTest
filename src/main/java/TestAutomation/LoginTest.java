package TestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest {

	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil browser = new BrowserUtil();
		driver = browser.launchBroswer("chrome");

		browser.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		String title = browser.getPageTitle();
		if (title.equals("Register Account")) {
			System.out.println("Correct Browser" + title);
		} else {
			System.out.println("In-Correct Browser" + title);
		}

		By fName = By.id("input-firstname");
		By lName = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmPassword = By.id("input-confirm");

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(fName, "Vandana");
		eleUtil.doSendKeys(lName, "Patel");
		eleUtil.doSendKeys(email, "1487vandana353085@gmail.com");
		eleUtil.doSendKeys(telephone, "732-319-7211");
		eleUtil.doSendKeys(password, "Vandana123");
		eleUtil.doSendKeys(confirmPassword, "Vandana123");
		
		By chkBoxPolicy = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
		By btnContinue = By.cssSelector("#content > form > div > div > input.btn.btn-primary");
		By header = By.tagName("h1");
		
		eleUtil.doElementClick(chkBoxPolicy);
		eleUtil.doElementClick(btnContinue);
		
		String headerName= eleUtil.getElementText(header);
		
		if(headerName.equals("Your Account Has Been Created!")) {
			System.out.println("Congratulations! Your new account has been successfully created!");
		}else {
			System.out.println("Registration not completed please enter right values...");
		}
		
		By btnContinue1 = By.xpath("//*[@id=\"content\"]/div/div/a");
		eleUtil.doElementClick(btnContinue1);

		browser.CloseBrowser();

	}

}
