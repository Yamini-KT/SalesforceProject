

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tekarch.utility.GenerateReports;
import com.tekarch.utility.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	protected static WebDriver driver;
	protected static WebDriverWait wait;


	@BeforeMethod
	@Parameters("browser")
	public static void setUp(Method method, String browser) {
		System.out.println("Base Class before method started");
		String url=CommonUtilities.getApplicationProperty("url");
		String userName=CommonUtilities.getApplicationProperty("username");
		String passwrd=CommonUtilities.getApplicationProperty("password");
		getDriver(browser);
		gotoUrl(url);
		if (!method.getName().equalsIgnoreCase("testcase1") && !method.getName().equalsIgnoreCase("testcase3") && !method.getName().equalsIgnoreCase("testcase4a") && !method.getName().equalsIgnoreCase("testcase4b")){
			login(userName,passwrd);
		}

	}


	@AfterMethod
	public static void tearDown() {
		System.out.println("Base Class after method started");
		closeAllDriver();
	}

	public static void getDriver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		driver.manage().window().maximize();

	}
	public static void gotoUrl(String url) {
		driver.get(url);
	}

	public static void login(String userName,String password) {

		WebElement usernameElm= driver.findElement(By.id("username"));
		waitUntilVisible(usernameElm,"user name");
		enterText(usernameElm, userName,"user name");

		WebElement passwordElm=driver.findElement(By.id("password"));
		clearElement(passwordElm, "password");
		enterText(passwordElm, password,"password");

		WebElement login=driver.findElement(By.id("Login"));
		clickElement(login,"login button");


	}

	public static void closeDriver() {
		driver.close();
	}

	public static void closeAllDriver() {
		driver.quit();
	}
	
	public static WebDriver getDriverInstance() {
		return driver;
	}

	public static void enterText(WebElement element,String text,String objName) {
		if(element.isDisplayed()) {
			clearElement(element,objName);
			element.sendKeys(text);
		}
		else {
			System.out.println("fail: "+objName+" element not displayed");
		}
	}
	public static void clickElement(WebElement element,String objName) {
		if(element.isDisplayed()) {
			element.click();
			System.out.println("pass:"+objName+" element clicked");
		}
		else {
			System.out.println("fail:"+objName+"  element not displayed");
		}
	}

	public static void clearElement(WebElement element,String objName) {
		if(element.isDisplayed()) {
			element.clear();
			System.out.println("pass:"+objName+"  element cleared");
		}
		else {
			System.out.println("fail:"+objName+" element not displayed");
		}
	}

	public static void waitUntilVisible(WebElement element,String objName) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public static void waitUntilvisibilityOfElementLocated(By locator,String objName) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));


	}

}
