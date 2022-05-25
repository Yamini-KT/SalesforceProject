package com.tekarch.common.tests;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SalesforceProjectTest {

	public static void main(String[] args) throws InterruptedException, AWTException {

		WebDriver driver = null;


		System.setProperty("webdriver.chrome.driver", "/Users/mahenyamini/Downloads/chromedriver 4");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		//		testCase1(driver);
				testCase2(driver);
		//		testCase3(driver);
		//		testCase4a(driver);
		//		testCase4b(driver);
		//		testCase5(driver);
		//		testCase6(driver);
		//		testCase7(driver);
		//   	testCase8(driver);
		//		testCase9(driver);
		//		testCase10(driver);
		//		testCase11(driver);
		//		testCase12(driver);
		//		testCase13(driver);
		//      testCase14(driver);
		//		testCase15(driver);
		//		testCase16(driver); 
		//		testCase17(driver);
		//		testCase18(driver);
		//		testCase19(driver);
		//		testCase20(driver);
		//		testCase21(driver);
		//		testCase22(driver);
		//		testCase23(driver);
		//		testCase24(driver);
		//		testCase25(driver);
		//		testCase26(driver);
		//		testCase27(driver);
		//      testCase28(driver);
		//      testCase29(driver);
		//      testCase30(driver);
		//      testCase31(driver);
		//      testCase32(driver);
		//      testCase33(driver);
		//      testCase34(driver);
		//	    testCase35(driver);
		//		testCase36(driver);
		//      testCase37(driver);

		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}


	static void testCase1(WebDriver driver) {
		//TestCase 1:

		driver.get("https://login.salesforce.com/");		
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("Login")).click();

		WebElement error =  driver.findElement(By.id("error"));

		System.out.println(error.getText());
	}

	static void testCase2(WebDriver driver) {
		//TestCase 2:
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
	}

	static void testCase3(WebDriver driver) throws InterruptedException {
		//TestCase 3:
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("rememberUn")).click();
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.id("userNavLabel")).click();
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		WebElement userNameID = driver.findElement(By.id("idcard-identity"));
		System.out.println(userNameID.getText());
	}

	static void testCase4a(WebDriver driver) {
		//TestCase 4a:

		driver.get("https://login.salesforce.com/");

		driver.findElement(By.linkText("Forgot Your Password?")).click();
		driver.findElement(By.name("un")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("continue")).click();
		WebElement forgotPwdMsg = driver.findElement(By.xpath("//*[@id=\"forgotPassForm\"]/div"));
		System.out.println(forgotPwdMsg.getText());

	}

	static void testCase4b(WebDriver driver) throws InterruptedException {
		//TestCase 4b:
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("123");
		driver.findElement(By.id("password")).sendKeys("22131");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		WebElement incorrectDetails = driver.findElement(By.id("error"));
		System.out.println(incorrectDetails.getText());

	}

	static void testCase5(WebDriver driver) {
		//TestCase 5:
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.id("userNavLabel")).click();
		WebElement userMenu = driver.findElement(By.id("userNav-menuItems"));
		System.out.println(userMenu.getText());


	}

	static void testCase6(WebDriver driver) throws InterruptedException {

		//TestCase 6:
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.id("userNavLabel")).click();
		driver.findElement(By.linkText("My Profile")).click();

		Thread.sleep(5000);

		Actions action = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a")));

		WebElement editPen = driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		action.moveToElement(editPen).click().build().perform();


		Thread.sleep(5000);
		driver.switchTo().frame("contactInfoContentId");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"aboutTab\"]/a")));

		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"aboutTab\"]/a"))).click().build().perform();


		WebElement lastNameField = driver.findElement(By.id("lastName"));
		lastNameField.clear();
		lastNameField.sendKeys("lastName");
		driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]")).click();



		//	Click on post link

		driver.findElement(By.xpath("//*[@id=\"publisherAttachTextPost\"]/span[1]")).click();

		driver.switchTo().frame(0);

		driver.findElement(By.xpath("/html/body")).sendKeys("Hello world");

		driver.switchTo().parentFrame();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("publishersharebutton")));
		action.moveToElement(driver.findElement(By.id("publishersharebutton"))).click().build().perform();

		Thread.sleep(5000);

		//Code to upload file

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//*[@id=\"publisherAttachContentPost\"]/span[1]")).click();


		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"chatterUploadFileAction\"]"))).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chatterFile")));

		WebElement chatterfile = driver.findElement(By.id("chatterFile"));


		Thread.sleep(3000);

		//using direct file path and send keys
		chatterfile.sendKeys("/Users/mahenyamini/Downloads/profile.jpeg");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("publishersharebutton")));
		action.moveToElement(driver.findElement(By.id("publishersharebutton"))).click().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(5000);

		// Code to update profile pic
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"uploadLink\"]")));
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"uploadLink\"]"))).click().build().perform();

		driver.switchTo().frame("uploadPhotoContentId");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"j_id0:uploadFileForm:uploadInputFile\"]")));

		WebElement uploadfile = driver.findElement(By.xpath("//*[@id=\"j_id0:uploadFileForm:uploadInputFile\"]"));
		Thread.sleep(2000);
		uploadfile.sendKeys("/Users/mahenyamini/Downloads/profile.jpeg");
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"j_id0:uploadFileForm:uploadBtn\"]"))).click().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"j_id0:j_id7:save\"]"))).click().build().perform();

		Thread.sleep(10000);

	}

	static void testCase7(WebDriver driver) throws InterruptedException {

		// TestCase 7:
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.id("userNavLabel")).click();
		driver.findElement(By.linkText("My Settings")).click();
		Thread.sleep(5000);
		//Personal info:
		Actions action = new Actions(driver);

		//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"PersonalInfo\"]/a/span[3]")));

		WebElement personalBtn  = driver.findElement(By.id("PersonalInfo_font"));
		action.moveToElement(personalBtn).click().build().perform();

		driver.findElement(By.id("LoginHistory_font")).click();

		driver.findElement(By.xpath("//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")).click();
		//Display and layout:
		Thread.sleep(3000);

		WebElement displayLayout  = driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout\"]/a/span[3]"));
		action.moveToElement(displayLayout).click().build().perform();

		//driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout\"]/a/span[3]")).click();

		driver.findElement(By.id("CustomizeTabs_font")).click();

		Select customIcon = new Select(driver.findElement(By.id("p4")));

		customIcon.selectByVisibleText("Salesforce Chatter");

		Select availableTab = new Select(driver.findElement(By.id("duel_select_0")));

		availableTab.selectByVisibleText("Reports");

		driver.findElement(By.id("duel_select_0_right")).click();

		//Email:
		driver.findElement(By.id("EmailSetup_font")).click();
		driver.findElement(By.id("EmailSettings_font")).click();

		WebElement emailName =	driver.findElement(By.id("sender_name"));
		emailName.click();
		emailName.clear();
		emailName.sendKeys("Aana");

		WebElement emailAdd = driver.findElement(By.id("sender_email"));
		emailAdd.click();
		emailAdd.clear();
		emailAdd.sendKeys("yamini.thukaram@gmail.com");

		driver.findElement(By.id("auto_bcc1")).click();
		driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();


		//Calendar & Remainder:
		driver.findElement(By.id("CalendarAndReminders_font")).click();
		driver.findElement(By.id("Reminders_font")).click();

		driver.findElement(By.id("testbtn")).click();
		Thread.sleep(3000);

		// store the win ids in set of string. capture it using the method getWindowHandles()
		Set<String> winids = driver.getWindowHandles();
		System.out.println(winids);

		WebDriver popup = driver;
		Set<String> windowIterator = driver.getWindowHandles();

		System.err.println("No of windows :  " + windowIterator.size());

		for (String s : windowIterator) {
			String windowHandle = s;
			popup = driver.switchTo().window(windowHandle);
			System.out.println("Window Title : " + popup.getTitle());
			System.out.println("Window Url : " + popup.getCurrentUrl());

			if (popup.getCurrentUrl().contains("activity/ActivityReminderPage")) {
				System.out.println("Selected Window Title : " + popup.getTitle());
				//driver = popup;
				Thread.sleep(1000);
				popup.findElement(By.xpath("//*[@id=\"dismiss_all\"]")).click();
				break;
			}
		}

		driver.switchTo().window(windowIterator.toArray()[0].toString());

	}

	static void testCase8(WebDriver driver) throws InterruptedException {

		//		//TestCase 8:
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.id("userNavLabel")).click();
		driver.findElement(By.linkText("Developer Console")).click();

		Thread.sleep(3000);

		WebDriver popup = driver;
		Set<String> windowIterator = driver.getWindowHandles();

		System.err.println("No of windows :  " + windowIterator.size());

		for (String s : windowIterator) {
			String windowHandle = s;
			popup = driver.switchTo().window(windowHandle);
			System.out.println("Window Title : " + popup.getTitle());
			System.out.println("Window Url : " + popup.getCurrentUrl());

			if (popup.getTitle().contains("Developer Console")) {
				System.out.println("Selected Window Title : " + popup.getTitle());
				//driver = popup;
				Thread.sleep(1000);
				popup.close();
				break;
			}
		}

		driver.switchTo().window(windowIterator.toArray()[0].toString());

	}

	static void testCase9(WebDriver driver) {

		//TestCase 9:
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.id("userNavLabel")).click();
		driver.findElement(By.linkText("Logout")).click();	

	}

	static void testCase10(WebDriver driver) throws InterruptedException {

		//TestCase 10:
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Accounts")).click();

		Actions action = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement editPen = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		action.moveToElement(editPen).click().build().perform();

		//*[@id="lexNoThanks"]
		//driver.findElement(By.id("tryLexDialogX")).click();
		driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("acc2")).sendKeys("united");
		driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]")).click();



		Thread.sleep(5000);


		driver.findElement(By.id("userNavLabel")).click();
		driver.findElement(By.linkText("Logout")).click();	

	}

	static void testCase11(WebDriver driver) throws InterruptedException {

		//TestCase 11:
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Accounts")).click();
		Actions action = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUp = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		action.moveToElement(popUp).click().build().perform();	

		WebElement createNewViewBtn = driver.findElement(By.linkText("Create New View"));
		action.moveToElement(createNewViewBtn).click().build().perform();

		driver.findElement(By.id("fname")).sendKeys("Abcd");
		driver.findElement(By.id("devname")).click();
		driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]")).click();

		Thread.sleep(5000);

	}

	static void testCase12(WebDriver driver) throws InterruptedException {
		//TestCase 12: (check)
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Accounts")).click();
		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	

		Thread.sleep(3000);

		Select viewBtn = new Select(driver.findElement(By.id("fcf")));
		viewBtn.selectByVisibleText("Abcd");

		WebElement createEditBtn = driver.findElement(By.linkText("Edit"));
		actions.moveToElement(createEditBtn).click().build().perform();

		WebElement editViewName = driver.findElement(By.id("fname"));
		editViewName.click();
		editViewName.clear();
		editViewName.sendKeys("abcde");

		Select acctField = new Select(driver.findElement(By.id("fcol1")));
		acctField.selectByVisibleText("Account Name");

		Select operatorBtn = new Select(driver.findElement(By.id("fop1")));
		operatorBtn.selectByVisibleText("contains");

		driver.findElement(By.id("fval1")).sendKeys("a");

		//check if "Last Activity" alreay selected, then remove it before adding agian
		for (WebElement sfield : new Select(driver.findElement(By.id("colselector_select_1"))).getOptions()) {
			if (sfield.getText().equalsIgnoreCase("Last Activity")) {
				Select last_act = new Select(driver.findElement(By.id("colselector_select_1")));
				last_act.selectByVisibleText("Last Activity");
				driver.findElement(By.id("colselector_select_0_left")).click();
			}
		}

		// Add "Last Activity" to the selected fields
		Select field = new Select(driver.findElement(By.id("colselector_select_0")));
		field.selectByVisibleText("Last Activity");


		driver.findElement(By.id("colselector_select_0_right")).click();

		driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]")).click();


	}

	static void testCase13(WebDriver driver) throws InterruptedException {

		//TestCase 13:   (check)

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Accounts")).click();
		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	


		WebElement mergeLink =driver.findElement(By.linkText("Merge Accounts"));
		actions.moveToElement(mergeLink).click().build().perform();

		Thread.sleep(3000);

		driver.findElement(By.id("srch")).sendKeys("united");
		driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]")).click();

		driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[2]")).click();

		String msg = driver.switchTo().alert().getText();
		System.out.println(msg);

		driver.switchTo().alert().accept();

	}

	static void testCase14(WebDriver driver) throws InterruptedException {

		//TestCase 14:  (check)
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Accounts")).click();
		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	

		WebElement reportActivity =driver.findElement(By.linkText("Accounts with last activity > 30 days"));
		actions.moveToElement(reportActivity).click().build().perform();	

		Thread.sleep(3000);


		// date field
		driver.findElement(By.cssSelector("#filterPanel_sfp table form div div:nth-child(1)>img")).click();

		// created date
		driver.findElement(By.cssSelector("div[id^='ext-gen'][class=x-combo-list-inner] div.dateColumnCategory:first-child ~ div:nth-child(3)")).click();


		// FromDate
		driver.findElement(By.cssSelector("#filterPanel_sfp table form div div:nth-child(5)>img")).click();	
		driver.findElement(By.cssSelector("div.x-date-menu:not(.x-hide-offsets) div.x-date-picker table tbody tr:last-child td table tbody")).click();

		//ToDate
		driver.findElement(By.cssSelector("#filterPanel_sfp table form div div:nth-child(7)>img")).click();
		driver.findElement(By.cssSelector("div.x-date-menu:not(.x-hide-offsets) div.x-date-picker table tbody tr:last-child td table tbody")).click();

		driver.findElement(By.cssSelector("#saveReportBtn tbody tr:nth-child(2) button")).click();

		Thread.sleep(3000);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_HHmmss");
		String datestr = dateFormat.format(new Date());

		driver.findElement(By.id("saveReportDlg_reportNameField")).sendKeys("report_" + datestr);
		driver.findElement(By.id("saveReportDlg_DeveloperName")).click();

		//save button
		driver.findElement(By.xpath("//*[@id=\"dlgSaveReport\"]/tbody/tr[2]/td[2]/em/button")).click();



	}

	static void testCase15(WebDriver driver) {

		//TestCase 15: 
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Opportunities")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	

		driver.findElement(By.id("fcf")).click();

		WebElement opptDropdown = driver.findElement(By.id("fcf"));
		System.out.println(opptDropdown.getText());


	}

	static void testCase16(WebDriver driver) throws InterruptedException {
		//TestCase 16: (check)

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Opportunities")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	

		driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();

		Thread.sleep(3000);

		driver.findElement(By.id("opp3")).sendKeys("abc");
		driver.findElement(By.id("opp4")).sendKeys("United Oil & Gas Corp.");
		driver.findElement(By.id("opp9")).sendKeys("5/28/2022");
		Select drpdown = new Select(driver.findElement(By.id("opp11")));
		drpdown.selectByVisibleText("Needs Analysis");
		driver.findElement(By.id("opp12")).click();

		Select leadS = new Select(driver.findElement(By.id("opp6")));
		leadS.selectByVisibleText("Phone Inquiry");

		driver.findElement(By.id("opp17")).sendKeys("DM Campaign to Top Customers - Nov 12-23, 2001");


		driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]")).click();


	}

	static void testCase17(WebDriver driver) throws InterruptedException {
		//TestCase 17: 	

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();


		driver.findElement(By.linkText("Opportunities")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	

		WebElement opptPipeline = driver.findElement(By.linkText("Opportunity Pipeline"));
		actions.moveToElement(opptPipeline).click().build().perform();	

		Thread.sleep(3000);

		System.out.println(driver.getTitle());

	}

	static void testCase18(WebDriver driver) throws InterruptedException {

		//TestCase 18: 

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Opportunities")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	

		WebElement stuckOppt = driver.findElement(By.linkText("Stuck Opportunities"));
		actions.moveToElement(stuckOppt).click().build().perform();

		Thread.sleep(3000);


		System.out.println(driver.getTitle());


	}

	static void testCase19(WebDriver driver) throws InterruptedException {
		//TestCase 19: 

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Opportunities")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	

		Select quarterlyLink = new Select(driver.findElement(By.id("quarter_q")));
		quarterlyLink.selectByVisibleText("Current FQ");

		Select include = new Select(driver.findElement(By.id("open")));
		include.selectByVisibleText("All Opportunities");

		driver.findElement(By.xpath("//*[@id=\"lead_summary\"]/table/tbody/tr[3]/td/input")).click();

		Thread.sleep(3000);


		System.out.println(driver.getTitle());


	}

	static void testCase20(WebDriver driver) {

		//		TestCase 20:

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Leads")).click();


	}

	static void testCase21(WebDriver driver) {

		// Test Case 21:

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Leads")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	

		WebElement leadsMenu = driver.findElement(By.id("fcf"));
		System.out.println(leadsMenu.getText());



	}

	static void testCase22(WebDriver driver) throws InterruptedException {

		// Test Case 22:	

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Leads")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	

		Select selectLeads = new Select(driver.findElement(By.id("fcf")));
		selectLeads.selectByVisibleText("Today's Leads");

		driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input")).click();

		Thread.sleep(3000);

		driver.findElement(By.id("userNavLabel")).click();
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input")).click();

		System.out.println("The default \"Today's View\" was selected when GO button was clicled");


	}

	static void testCase23(WebDriver driver) {

		// Test Case 23:

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Leads")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	

		Select selectLeads = new Select(driver.findElement(By.id("fcf")));
		selectLeads.selectByVisibleText("Today's Leads");


	}

	static void testCase24(WebDriver driver) throws InterruptedException {
		// Test Case 24:

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Leads")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	

		driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("name_lastlea2")).sendKeys("ABCD");
		driver.findElement(By.id("lea3")).sendKeys("ABCD");
		driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]")).click();


	}

	static void testCase25(WebDriver driver) {

		// Test Case 25:

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Contacts")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	

		driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();

		driver.findElement(By.id("name_lastcon2")).sendKeys("lastname");
		driver.findElement(By.id("con4")).sendKeys("Test");
		driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]")).click();


	}

	static void testCase26(WebDriver driver) throws InterruptedException {

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Contacts")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	

		WebElement newView = driver.findElement(By.linkText("Create New View"));
		actions.moveToElement(newView).click().build().perform();

		Thread.sleep(3000);

		driver.findElement(By.id("fname")).sendKeys("view name");
		driver.findElement(By.id("devname")).click();
		driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]")).click();

	}

	static void testCase27(WebDriver driver) {

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Contacts")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	

		Select recentContact = new Select(driver.findElement(By.id("hotlist_mode")));
		recentContact.selectByVisibleText("Recently Created");

		System.out.println("Recently created contacts was displayed");

	}

	static void testCase28(WebDriver driver) {

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Contacts")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();


		Select myView = new Select(driver.findElement(By.id("fcf")));
		myView.selectByVisibleText("My Contacts");

		System.out.println("My contacts view was displayed");

	}

	static void testCase29(WebDriver driver) {

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Contacts")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();

		WebElement contactName =driver.findElement(By.linkText("Gonzalez, Rose"));
		actions.moveToElement(contactName).click().build().perform();

		System.out.println("Contact page related to the contact name was displayed");
	}

	static void testCase30(WebDriver driver) throws InterruptedException {

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Contacts")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	

		WebElement newView = driver.findElement(By.linkText("Create New View"));
		actions.moveToElement(newView).click().build().perform();

		Thread.sleep(3000);

		driver.findElement(By.id("devname")).sendKeys("EFGH");

		driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]")).click();

		WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/div[2]"));

		System.out.println("The error message was displayed as: "+ errorMsg.getText());
	}

	static void testCase31(WebDriver driver) throws InterruptedException {
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Contacts")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();	

		WebElement newView = driver.findElement(By.linkText("Create New View"));
		actions.moveToElement(newView).click().build().perform();

		Thread.sleep(3000);

		driver.findElement(By.id("fname")).sendKeys("ABCD");

		driver.findElement(By.id("devname")).sendKeys("EFGH");

		driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[2]")).click();

		System.out.println("The new contact was not created as cancel button was clicked");

	}


	static void testCase32(WebDriver driver) throws InterruptedException {

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Contacts")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();

		driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();

		Thread.sleep(3000);

		driver.findElement(By.id("name_lastcon2")).sendKeys("Indian");

		driver.findElement(By.id("con4")).sendKeys("Global Media");

		driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[2]")).click();

		WebElement error = driver.findElement(By.id("errorDiv_ep"));

		System.out.println("The error message was displayed as: " + error.getText() );
	}

	static void testCase33(WebDriver driver) throws InterruptedException {

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Contacts")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();

		driver.findElement(By.linkText("Home")).click();
		;
		Thread.sleep(3000);

		WebElement fnameLname = driver.findElement(By.linkText("Aana lastName"));
		actions.moveToElement(fnameLname).click().build().perform();

		System.out.println(driver.getTitle());


	}

	static void testCase34(WebDriver driver) throws InterruptedException {

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Contacts")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();

		driver.findElement(By.linkText("Home")).click();

		Thread.sleep(3000);

		WebElement fnameLname = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
		actions.moveToElement(fnameLname).click().build().perform();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a")));

		WebElement editPen = driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		actions.moveToElement(editPen).click().build().perform();

		Thread.sleep(3000);

		driver.switchTo().frame("contactInfoContentId");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"aboutTab\"]/a")));

		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"aboutTab\"]/a"))).click().build().perform();


		WebElement lastNameField = driver.findElement(By.id("lastName"));
		lastNameField.clear();
		lastNameField.sendKeys("Abcd");
		driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]")).click();

		System.out.println("The last name was updated in the profile");
	}

	static void testCase35(WebDriver driver) throws InterruptedException {

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Contacts")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();

		driver.findElement(By.linkText("Home")).click();

		driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img")).click();

		driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/table/tbody/tr/td[2]/input")).click();

		Select customizeTabAdd = new Select(driver.findElement(By.id("duel_select_0")));

		customizeTabAdd.selectByVisibleText("Subscriptions");

		driver.findElement(By.id("duel_select_0_right")).click();

		Select customizeTabRemove = new Select(driver.findElement(By.id("duel_select_1")));

		customizeTabRemove.selectByVisibleText("Subscriptions");

		driver.findElement(By.id("duel_select_0_left")).click();

		driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();

		driver.findElement(By.id("userNavButton")).click();	
		driver.findElement(By.linkText("Logout")).click();

		Thread.sleep(3000);

		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();

	}

	static void testCase36(WebDriver driver) throws InterruptedException {

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Contacts")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();

		driver.findElement(By.linkText("Home")).click();

		Thread.sleep(3000);


		WebElement dateLink = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		actions.moveToElement(dateLink).click().build().perform();

		WebElement eightPM = driver.findElement(By.id("p:f:j_id25:j_id61:28:j_id64"));
		actions.moveToElement(eightPM).click().build().perform();

		driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a")).click();

		//click on the combo box and inspect the open new window and select other
		// store the win ids in set of string. capture it using the method getWindowHandles()
		Set<String> winids = driver.getWindowHandles();
		System.out.println(winids);

		WebDriver popup = driver;
		Set<String> windowIterator = driver.getWindowHandles();

		System.err.println("No of windows :  " + windowIterator.size());

		driver.switchTo().window(windowIterator.toArray()[1].toString());
		actions.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/ul/li[5]/a"))).click().build().perform();

		driver.switchTo().window(windowIterator.toArray()[0].toString());

		//click on end time and select 9.00 PM
		driver.findElement(By.id("EndDateTime_time")).clear();
		driver.findElement(By.id("EndDateTime_time")).sendKeys("9:00 PM");


		//save button click:
		driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]")).click();
	}

	static void testCase37(WebDriver driver) throws InterruptedException {


		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("aanay@tekarch.com");
		driver.findElement(By.id("password")).sendKeys("yamini1990");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Contacts")).click();

		Actions actions = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

		WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		actions.moveToElement(popUpBtn).click().build().perform();

		driver.findElement(By.linkText("Home")).click();

		WebElement dateLink = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		actions.moveToElement(dateLink).click().build().perform();

		WebElement fourPM = driver.findElement(By.id("p:f:j_id25:j_id61:20:j_id64"));
		actions.moveToElement(fourPM).click().build().perform();

		//subject combo icon click:
		driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a")).click();

		//click on the combo box and inspect the open new window and select other
		// store the win ids in set of string. capture it using the method getWindowHandles()
		Set<String> winids = driver.getWindowHandles();
		System.out.println(winids);

		WebDriver popup = driver;
		Set<String> windowIterator = driver.getWindowHandles();

		System.err.println("No of windows :  " + windowIterator.size());

		driver.switchTo().window(windowIterator.toArray()[1].toString());
		actions.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/ul/li[5]/a"))).click().build().perform();

		driver.switchTo().window(windowIterator.toArray()[0].toString());


		//click on end time and select 7.00 PM
		driver.findElement(By.id("EndDateTime_time")).clear();
		driver.findElement(By.id("EndDateTime_time")).sendKeys("7:00 PM");

		//check reoccurence
		driver.findElement(By.id("IsRecurrence")).click();

		//select weekly radiobutton
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("rectypeftw")).click();

		//enter end date select 2 weeks from then
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


		int noOfDays = 14; 
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, noOfDays);
		Date date = cal.getTime();

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		String datestr = dateFormat.format(date);

		driver.findElement(By.id("RecurrenceEndDateOnly")).clear();
		driver.findElement(By.id("RecurrenceEndDateOnly")).sendKeys(datestr);


		//save button click:
		driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]")).click();

		//click monthly view icon:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//*[@id=\"bCalDiv\"]/div/div[2]/span[2]/a[3]/img")).click();
	}


}


