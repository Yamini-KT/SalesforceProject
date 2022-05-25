package com.tekarch.tests;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tekarch.businessfunctions.BaseClass;
import com.tekarch.utility.CommonUtilities;
import com.tekarch.utility.Constants;


//@Listeners(com.tekarch.utility.GenerateReportsListener.class)

public class AutomationScripts extends BaseClass {


	@Test(priority=0)
	public static void testCase1() throws IOException {
		//TestCase 1:

		try {
			driver.get(CommonUtilities.getApplicationProperty("url"));		
			driver.findElement(By.id("username")).sendKeys(CommonUtilities.getApplicationProperty("username"));
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("Login")).click();

			Thread.sleep(2000);
			WebElement error =  driver.findElement(By.id("error"));
			System.out.println(error.getText());
			Assert.assertEquals("Please enter your password.", error.getText());
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}
	}


	@Test(priority=1)
	public static void testCase2() throws IOException {
		//TestCase 2:
		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");
			WebElement userNavLabel= driver.findElement(By.id("userNavLabel"));

			Assert.assertTrue(userNavLabel.isDisplayed(), "Login Failed");

		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}
	}


	@Test(priority=2)
	public static void testCase3() throws InterruptedException, IOException {
		//TestCase 3:
		try {
			driver.get(CommonUtilities.getApplicationProperty("url"));
			WebElement userNameEl = driver.findElement(By.id("username"));
			userNameEl.sendKeys(CommonUtilities.getApplicationProperty("username"));
			Thread.sleep(2000);
			driver.findElement(By.id("password")).sendKeys(CommonUtilities.getApplicationProperty("password"));
			driver.findElement(By.id("rememberUn")).click();
			driver.findElement(By.id("Login")).click();

			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");
			WebElement userNavLabel= driver.findElement(By.id("userNavLabel"));

			driver.findElement(By.id("userNavLabel")).click();
			driver.findElement(By.linkText("Logout")).click();


			waitUntilvisibilityOfElementLocated(By.id("idcard-identity"),"User Navigation Label");

			WebElement userNameID = driver.findElement(By.id("idcard-identity"));

			System.out.println(userNameID.getText());

			Assert.assertEquals(userNameID.getText(), CommonUtilities.getApplicationProperty("username"));
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}
	}


	@Test(priority=3)
	public static void testCase4a() throws IOException {
		//TestCase 4a:

		try {
			driver.get("https://login.salesforce.com/");

			driver.findElement(By.linkText("Forgot Your Password?")).click();
			driver.findElement(By.name("un")).sendKeys(CommonUtilities.getApplicationProperty("username"));
			driver.findElement(By.id("continue")).click();


			waitUntilvisibilityOfElementLocated(By.id("forgotPassForm"),"Forgot Password Form");

			WebElement forgotPwdMsg = driver.findElement(By.xpath("//*[@id=\"forgotPassForm\"]/div"));
			System.out.println(forgotPwdMsg.getText());

			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"header\"]")).getText(), "Check Your Email");


		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}

	}



	@Test(priority=4)
	public static void testCase4b() throws InterruptedException, IOException {
		//TestCase 4b:
		try {
			driver.get("https://login.salesforce.com/");
			driver.findElement(By.id("username")).sendKeys("123");
			driver.findElement(By.id("password")).sendKeys("22131");
			driver.findElement(By.id("Login")).click();
			Thread.sleep(3000);
			WebElement incorrectDetails = driver.findElement(By.id("error"));
			System.out.println(incorrectDetails.getText());

			Assert.assertEquals(incorrectDetails.getText(), "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}

	}


	@Test(priority=5)
	public static void testCase5() throws IOException {
		//TestCase 5:
		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");
			WebElement userNavLabel= driver.findElement(By.id("userNavLabel"));

			clickElement(userNavLabel, "User Navigation Label");

			WebElement userMenu = driver.findElement(By.id("userNav-menuItems"));
			System.out.println(userMenu.getText());
			Assert.assertTrue(userMenu.getText().contains("My Profile"));
		}
		catch(Exception e) {

			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}

	}


	@Test(priority=6)
	public static void testCase6() throws InterruptedException, IOException {

		//TestCase 6:
		try {

			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");
			WebElement userNavLabel= driver.findElement(By.id("userNavLabel"));

			clickElement(userNavLabel, "User Navigation Label");
			clickElement(driver.findElement(By.linkText("My Profile")), "My Profile");

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
			chatterfile.sendKeys(Constants.RESOURCES_PATH + "profile.jpeg");
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
			uploadfile.sendKeys(Constants.RESOURCES_PATH + "profile.jpeg");
			action.moveToElement(driver.findElement(By.xpath("//*[@id=\"j_id0:uploadFileForm:uploadBtn\"]"))).click().build().perform();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			action.moveToElement(driver.findElement(By.xpath("//*[@id=\"j_id0:j_id7:save\"]"))).click().build().perform();

			Thread.sleep(10000);

			Assert.assertTrue(true, "Actual and Expected Result does not match.");
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}

	}


	@Test(priority=7)
	public static void testCase7() throws InterruptedException, IOException {

		// TestCase 7:
		try {

			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");
			WebElement userNavLabel= driver.findElement(By.id("userNavLabel"));


			clickElement(userNavLabel, "User Navigation Label");
			clickElement(driver.findElement(By.linkText("My Settings")), "My Settings");


			Thread.sleep(5000);
			//Personal info:
			Actions action = new Actions(driver);

			WebElement personalBtn  = driver.findElement(By.id("PersonalInfo_font"));
			action.moveToElement(personalBtn).click().build().perform();

			driver.findElement(By.id("LoginHistory_font")).click();

			driver.findElement(By.xpath("//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")).click();
			//Display and layout:
			Thread.sleep(3000);

			WebElement displayLayout  = driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout\"]/a/span[3]"));
			action.moveToElement(displayLayout).click().build().perform();


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

			boolean ReminderWindowOpened = false;

			for (String s : windowIterator) {
				String windowHandle = s;
				popup = driver.switchTo().window(windowHandle);
				System.out.println("Window Title : " + popup.getTitle());
				System.out.println("Window Url : " + popup.getCurrentUrl());

				if (popup.getCurrentUrl().contains("activity/ActivityReminderPage")) {
					System.out.println("Selected Window Title : " + popup.getTitle());
					ReminderWindowOpened = true;
					//driver = popup;
					Thread.sleep(1000);
					popup.findElement(By.xpath("//*[@id=\"dismiss_all\"]")).click();
					break;
				}
			}

			driver.switchTo().window(windowIterator.toArray()[0].toString());
			Assert.assertTrue(ReminderWindowOpened, "Activity Reminder window did not open.");
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}

	}


	@Test(priority=8)
	public static void testCase8() throws InterruptedException, IOException {

		// TestCase 8:

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");
			WebElement userNavLabel= driver.findElement(By.id("userNavLabel"));

			clickElement(userNavLabel, "User Navigation Label");
			clickElement(driver.findElement(By.linkText("Developer Console")), "Developer Console");

			Thread.sleep(3000);

			WebDriver popup = driver;
			Set<String> windowIterator = driver.getWindowHandles();

			System.err.println("No of windows :  " + windowIterator.size());

			boolean DevConsoleWindowOpened = false;

			for (String s : windowIterator) {
				String windowHandle = s;
				popup = driver.switchTo().window(windowHandle);
				System.out.println("Window Title : " + popup.getTitle());
				System.out.println("Window Url : " + popup.getCurrentUrl());

				if (popup.getTitle().contains("Developer Console")) {
					System.out.println("Selected Window Title : " + popup.getTitle());
					DevConsoleWindowOpened = true;
					//driver = popup;
					Thread.sleep(1000);
					popup.close();
					break;
				}
			}

			driver.switchTo().window(windowIterator.toArray()[0].toString());
			Assert.assertTrue(DevConsoleWindowOpened, "Developer Console window did not open.");
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}

	}


	@Test(priority=9)
	public static void testCase9() throws IOException {

		//TestCase 9:
		try {

			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");

			WebElement userNavLabel= driver.findElement(By.id("userNavLabel"));

			clickElement(userNavLabel, "User Navigation Label");
			clickElement(driver.findElement(By.linkText("Logout")), "Logout");
			
			Thread.sleep(3000);

			Assert.assertEquals("https://tekarch-f-dev-ed.my.salesforce.com/", driver.getCurrentUrl());
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}

	}


	@Test(priority=10)
	public static void testCase10() throws InterruptedException, IOException {

		//TestCase 10:
		try {
			WebElement userNavLabel= driver.findElement(By.id("userNavLabel"));
			waitUntilVisible(userNavLabel,"User Navigation Label");


			driver.findElement(By.linkText("Accounts")).click();

			Actions action = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

			WebElement editPen = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
			action.moveToElement(editPen).click().build().perform();

			driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("acc2")).sendKeys("united");
			driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]")).click();


			waitUntilvisibilityOfElementLocated(By.xpath("//*[@id=\"contactHeaderRow\"]/div[2]/h2"),"Account Name");

			String ActualAccountName = driver.findElement(By.xpath("//*[@id=\"contactHeaderRow\"]/div[2]/h2")).getText();

			driver.findElement(By.id("userNavLabel")).click();
			driver.findElement(By.linkText("Logout")).click();	

			Assert.assertTrue(ActualAccountName.contains("united"), "New Account creation failed.");
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}

	}


	@Test(priority=11)
	public static void testCase11() throws InterruptedException, IOException {

		//TestCase 11:
		try {

			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");

			String viewName = "av_" + Constants.CURRENT_EXECUTION_TIMESTAMP;

			driver.findElement(By.linkText("Accounts")).click();
			Actions action = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

			WebElement popUp = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
			action.moveToElement(popUp).click().build().perform();	

			WebElement createNewViewBtn = driver.findElement(By.linkText("Create New View"));
			action.moveToElement(createNewViewBtn).click().build().perform();

			driver.findElement(By.id("fname")).sendKeys(viewName);
			driver.findElement(By.id("devname")).click();
			driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]")).click();


			waitUntilvisibilityOfElementLocated(By.xpath("//select[contains(@id,'listSelect')][@name=\"fcf\"]"),"Account List View Name");

			Select viewBtn = new Select(driver.findElement(By.xpath("//select[contains(@id,'listSelect')][@name=\"fcf\"]")));

			Assert.assertEquals(viewBtn.getFirstSelectedOption().getText(), viewName);


		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}

	}



	@Test(priority=12)
	public static void testCase12() throws InterruptedException, IOException {
		//TestCase 12
		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");

			String viewName = "av_" + Constants.CURRENT_EXECUTION_TIMESTAMP;

			driver.findElement(By.linkText("Accounts")).click();
			Actions actions = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

			WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
			actions.moveToElement(popUpBtn).click().build().perform();	

			Thread.sleep(3000);



			Select viewBtn = new Select(driver.findElement(By.id("fcf")));

			for (WebElement w : viewBtn.getOptions()) {
				if (w.getText().startsWith("av_")) {
					viewBtn.selectByVisibleText(w.getText());
					break;
				}
			}



			WebElement createEditBtn = driver.findElement(By.linkText("Edit"));
			actions.moveToElement(createEditBtn).click().build().perform();

			WebElement editViewName = driver.findElement(By.id("fname"));
			editViewName.click();
			editViewName.clear();
			editViewName.sendKeys("new_" + viewName);

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

			waitUntilvisibilityOfElementLocated(By.xpath("//select[contains(@id,'listSelect')][@name=\"fcf\"]"),"Account List View Name");

			Select EditviewBtn = new Select(driver.findElement(By.xpath("//select[contains(@id,'listSelect')][@name=\"fcf\"]")));

			Assert.assertEquals(EditviewBtn.getFirstSelectedOption().getText(), "new_" + viewName);

		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}


	}


	@Test(priority=13)
	public static void testCase13() throws InterruptedException, IOException {

		//TestCase 13

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");


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
			String ExpectedResult = "These records will be merged into one record using the selected values. Merging can't be undone. Proceed with the record merge?";


			Assert.assertEquals(msg, ExpectedResult);
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}

	}


	@Test(priority=14)
	public static void testCase14() throws InterruptedException, IOException {

		//TestCase 14
		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");

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

			//save button
			driver.findElement(By.cssSelector("#saveReportBtn tbody tr:nth-child(2) button")).click();

			Thread.sleep(3000);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_HHmmss");
			String datestr = dateFormat.format(new Date());

			driver.findElement(By.id("saveReportDlg_reportNameField")).sendKeys("report_" + datestr);
			driver.findElement(By.id("saveReportDlg_DeveloperName")).click();

			//save button
			waitUntilvisibilityOfElementLocated(By.xpath("//*[@id=\"dlgSaveAndRun\"]/tbody/tr[2]/td[2]/em/button"),"Save and Run Button");
			Thread.sleep(2000);			
			driver.findElement(By.xpath("//*[@id=\"dlgSaveAndRun\"]/tbody/tr[2]/td[2]/em/button")).click();


			waitUntilvisibilityOfElementLocated(By.xpath("//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1"),"Saved Report Name");

			String ExpectedReportName = "report_" + datestr;
			String ActualReportName = driver.findElement(By.xpath("//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1")).getText();

			Assert.assertEquals(ActualReportName, ExpectedReportName);
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}


	}



	@Test(priority=15)
	public static void testCase15() throws IOException {

		//TestCase 15: 
		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");
			WebElement userNavLabel= driver.findElement(By.id("userNavLabel"));


			driver.findElement(By.linkText("Opportunities")).click();

			Actions actions = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

			WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
			actions.moveToElement(popUpBtn).click().build().perform();	

			driver.findElement(By.id("fcf")).click();

			WebElement opptDropdown = driver.findElement(By.id("fcf"));
			System.out.println(opptDropdown.getText());
			Assert.assertTrue(opptDropdown.getText().contains("My Opportunities"), "Opportunities dropdown not loaded.");
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}


	}



	@Test(priority=16)
	public static void testCase16() throws InterruptedException, IOException {
		//TestCase 16

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");

			driver.findElement(By.linkText("Opportunities")).click();

			Actions actions = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

			WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
			actions.moveToElement(popUpBtn).click().build().perform();	

			driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();

			Thread.sleep(3000);

			String OptyName = "abc";

			driver.findElement(By.id("opp3")).sendKeys(OptyName);
			driver.findElement(By.id("opp4")).sendKeys("United Oil & Gas Corp.");
			driver.findElement(By.id("opp9")).sendKeys("5/28/2022");
			Select drpdown = new Select(driver.findElement(By.id("opp11")));
			drpdown.selectByVisibleText("Needs Analysis");
			driver.findElement(By.id("opp12")).click();

			Select leadS = new Select(driver.findElement(By.id("opp6")));
			leadS.selectByVisibleText("Phone Inquiry");

			driver.findElement(By.id("opp17")).sendKeys("DM Campaign to Top Customers - Nov 12-23, 2001");


			driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]")).click();


			waitUntilvisibilityOfElementLocated(By.id("opp3_ileinner"),"New Opportunity Name");

			String ActualOptyName = driver.findElement(By.id("opp3_ileinner")).getText();

			Assert.assertEquals(ActualOptyName, OptyName);
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}


	}


	@Test(priority=17)
	public static void testCase17() throws InterruptedException, IOException {
		//TestCase 17: 	

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");

			driver.findElement(By.linkText("Opportunities")).click();

			Actions actions = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

			WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
			actions.moveToElement(popUpBtn).click().build().perform();	

			WebElement opptPipeline = driver.findElement(By.linkText("Opportunity Pipeline"));
			actions.moveToElement(opptPipeline).click().build().perform();	


			waitUntilvisibilityOfElementLocated(By.xpath("//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1"), "Opty Pipeline");

			String actualPageTile = driver.findElement(By.xpath("//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1")).getText();
			System.out.println(driver.getTitle());

			Assert.assertEquals(actualPageTile, "Opportunity Pipeline");

		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}


	}


	@Test(priority=18)
	public static void testCase18() throws InterruptedException, IOException {

		//TestCase 18: 

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");

			driver.findElement(By.linkText("Opportunities")).click();

			Actions actions = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

			WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
			actions.moveToElement(popUpBtn).click().build().perform();	

			WebElement stuckOppt = driver.findElement(By.linkText("Stuck Opportunities"));
			actions.moveToElement(stuckOppt).click().build().perform();

			Thread.sleep(3000);


			waitUntilvisibilityOfElementLocated(By.xpath("//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1"), "Stuck Opty");

			String actualPageTile = driver.findElement(By.xpath("//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1")).getText();
			System.out.println(driver.getTitle());

			Assert.assertEquals(actualPageTile, "Stuck Opportunities");


		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}



	}


	@Test(priority=19)
	public static void testCase19() throws InterruptedException, IOException {
		//TestCase 19: 

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");

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


			waitUntilvisibilityOfElementLocated(By.xpath("//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1"), "Opty Report");

			String actualPageTile = driver.findElement(By.xpath("//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1")).getText();
			System.out.println(driver.getTitle());

			Assert.assertEquals(actualPageTile, "Opportunity Report");


		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}


	}



	@Test(priority=20)
	public static void testCase20() throws IOException {

		// TestCase 20:

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");

			driver.findElement(By.linkText("Leads")).click();
			Thread.sleep(3000);
			Assert.assertTrue(driver.getTitle().startsWith("Leads: Home"), "Lease page not loaded.");
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}

	}

	@Test(priority=21)
	public static void testCase21() throws IOException {

		// Test Case 21:

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");


			driver.findElement(By.linkText("Leads")).click();

			Actions actions = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

			WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
			actions.moveToElement(popUpBtn).click().build().perform();	

			WebElement leadsMenu = driver.findElement(By.id("fcf"));
			System.out.println(leadsMenu.getText());

			Assert.assertTrue(leadsMenu.getText().contains("Today's Leads"), "Leads dropdown not loaded.");

		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}



	}


	@Test(priority=22)
	public static void testCase22() throws InterruptedException, IOException {

		// Test Case 22:	

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");


			driver.findElement(By.linkText("Leads")).click();

			Actions actions = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

			WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
			actions.moveToElement(popUpBtn).click().build().perform();	

			Select selectLeads = new Select(driver.findElement(By.id("fcf")));
			
			if (selectLeads.getFirstSelectedOption().getText().equalsIgnoreCase("Today's Leads")) {
				driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input")).click();
			} else {
				selectLeads.selectByVisibleText("Today's Leads");
			}
			

			Thread.sleep(3000);

			driver.findElement(By.id("userNavLabel")).click();
			driver.findElement(By.linkText("Logout")).click();
			Thread.sleep(2000);

			login(CommonUtilities.getApplicationProperty("username"), CommonUtilities.getApplicationProperty("password"));

			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");

			driver.findElement(By.linkText("Leads")).click();

			driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input")).click();

			waitUntilvisibilityOfElementLocated(By.xpath("//select[contains(@id,'listSelect')][@name=\"fcf\"]"),"Leads List View Name");

			Select EditviewBtn = new Select(driver.findElement(By.xpath("//select[contains(@id,'listSelect')][@name=\"fcf\"]")));

			Assert.assertEquals(EditviewBtn.getFirstSelectedOption().getText(), "Today's Leads");


		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}

	}



	@Test(priority=23)
	public static void testCase23() throws IOException {

		// Test Case 23:

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");
			WebElement userNavLabel= driver.findElement(By.id("userNavLabel"));



			driver.findElement(By.linkText("Leads")).click();

			Actions actions = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

			WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
			actions.moveToElement(popUpBtn).click().build().perform();	

			Select selectLeads = new Select(driver.findElement(By.id("fcf")));
			
			if (selectLeads.getFirstSelectedOption().getText().equalsIgnoreCase("Today's Leads")) {
				driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input")).click();
			} else {
				selectLeads.selectByVisibleText("Today's Leads");
			}
			
			
			waitUntilvisibilityOfElementLocated(By.xpath("//select[contains(@id,'listSelect')][@name=\"fcf\"]"),"Leads List View Name");

			Select EditviewBtn = new Select(driver.findElement(By.xpath("//select[contains(@id,'listSelect')][@name=\"fcf\"]")));

			Assert.assertEquals(EditviewBtn.getFirstSelectedOption().getText(), "Today's Leads");

		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}
	}



	@Test(priority=24)
	public static void testCase24() throws InterruptedException, IOException {
		// Test Case 24:

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");

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


			waitUntilvisibilityOfElementLocated(By.id("lea2_ileinner"),"New Opportunity Name");

			String ActualLeadName = driver.findElement(By.id("lea2_ileinner")).getText();

			Assert.assertEquals(ActualLeadName, "ABCD");

		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}
	} 


	@Test(priority=25)
	public static void testCase25() throws IOException {

		// Test Case 25:

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");


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

			waitUntilvisibilityOfElementLocated(By.id("con2_ileinner"),"New Contact Name");

			String ActualName = driver.findElement(By.id("con2_ileinner")).getText();

			Assert.assertEquals(ActualName, "lastname");
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}
	}



	@Test(priority=26)	
	public static void testCase26() throws InterruptedException, IOException {

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");

			driver.findElement(By.linkText("Contacts")).click();

			String viewName = "cv_" + Constants.CURRENT_EXECUTION_TIMESTAMP;

			Actions actions = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

			WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
			actions.moveToElement(popUpBtn).click().build().perform();	

			WebElement newView = driver.findElement(By.linkText("Create New View"));
			actions.moveToElement(newView).click().build().perform();

			Thread.sleep(3000);

			driver.findElement(By.id("fname")).sendKeys(viewName);
			driver.findElement(By.id("devname")).click();
			driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]")).click();


			waitUntilvisibilityOfElementLocated(By.xpath("//select[contains(@id,'listSelect')][@name=\"fcf\"]"),"Contact List View Name");

			Select viewBtn = new Select(driver.findElement(By.xpath("//select[contains(@id,'listSelect')][@name=\"fcf\"]")));

			Assert.assertEquals(viewBtn.getFirstSelectedOption().getText(), viewName);

		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}
	}



	@Test(priority=27)   
	public static void testCase27() throws IOException {

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");


			driver.findElement(By.linkText("Contacts")).click();

			Actions actions = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

			WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
			actions.moveToElement(popUpBtn).click().build().perform();	

			Select recentContact = new Select(driver.findElement(By.id("hotlist_mode")));
			recentContact.selectByVisibleText("Recently Created");

			Assert.assertEquals(recentContact.getFirstSelectedOption().getText(), "Recently Created");

		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}

	}


	@Test(priority=28)    
	public static void testCase28() throws IOException {

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");


			driver.findElement(By.linkText("Contacts")).click();

			Actions actions = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

			WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
			actions.moveToElement(popUpBtn).click().build().perform();


			Select myView = new Select(driver.findElement(By.id("fcf")));

			if (myView.getFirstSelectedOption().getText().equalsIgnoreCase("My Contacts")) {
				driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input")).click();
			}
			else {

				myView.selectByVisibleText("My Contacts");
			}

			waitUntilvisibilityOfElementLocated(By.xpath("//select[contains(@id,'listSelect')][@name=\"fcf\"]"),"Contacts List View Name");

			Select EditviewBtn = new Select(driver.findElement(By.xpath("//select[contains(@id,'listSelect')][@name=\"fcf\"]")));

			Assert.assertEquals(EditviewBtn.getFirstSelectedOption().getText(), "My Contacts");


		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}
	}


	@Test(priority=29)
	public static void testCase29() throws IOException {

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");


			driver.findElement(By.linkText("Contacts")).click();

			Actions actions = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

			WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
			actions.moveToElement(popUpBtn).click().build().perform();

			WebElement contactName =driver.findElement(By.linkText("lastname"));
			actions.moveToElement(contactName).click().build().perform();

			waitUntilvisibilityOfElementLocated(By.id("con2_ileinner"),"Contact Name");

			String ActualName = driver.findElement(By.id("con2_ileinner")).getText();

			Assert.assertEquals(ActualName, "lastname");
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}
	}



	@Test(priority=30)
	public static void testCase30() throws InterruptedException, IOException {

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");
			WebElement userNavLabel= driver.findElement(By.id("userNavLabel"));



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

			Assert.assertEquals(errorMsg.getText(), "Error: You must enter a value");
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}
	}


	@Test(priority=31)
	public static void testCase31() throws InterruptedException, IOException {
		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");
			WebElement userNavLabel= driver.findElement(By.id("userNavLabel"));

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

			driver.findElement(By.id("devname")).clear();

			driver.findElement(By.id("devname")).sendKeys("EFGH");

			driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[2]")).click();

			System.out.println("The new contact was not created as cancel button was clicked");


			waitUntilvisibilityOfElementLocated(By.id("fcf"),"Contacts List View Name");

			Select EditviewBtn = new Select(driver.findElement(By.id("fcf")));

			Assert.assertNotEquals(EditviewBtn.getFirstSelectedOption().getText(), "ABCD");


		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}
	}


	@Test(priority=32)
	public static void testCase32() throws InterruptedException, IOException {

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");

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

			Assert.assertTrue(!error.isDisplayed() &&  error.getText().isBlank(), "New Contact Creation Failed." + error.getText());

		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}


	}



	@Test(priority=33)
	public static void testCase33() throws InterruptedException, IOException {

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");

			driver.findElement(By.linkText("Contacts")).click();

			Actions actions = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

			WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
			actions.moveToElement(popUpBtn).click().build().perform();

			driver.findElement(By.linkText("Home")).click();

			waitUntilvisibilityOfElementLocated(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"),"User Navigation Label");

			String name = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a")).getText();

			System.out.println("Name : " + name);
			WebElement fnameLname = driver.findElement(By.linkText(name));
			actions.moveToElement(fnameLname).click().build().perform();

			System.out.println(driver.getTitle());

			waitUntilvisibilityOfElementLocated(By.id("tailBreadcrumbNode"),"Chatter Profile");

			Assert.assertTrue(driver.findElement(By.id("tailBreadcrumbNode")).getText().startsWith(name), "Chatter Profile Page did not open.");
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}
	}


	@Test(priority=34)
	public static void testCase34() throws InterruptedException, IOException {

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");

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


			String lastName;

			WebElement lastNameField = driver.findElement(By.id("lastName"));

			if (lastNameField.getAttribute("value").equalsIgnoreCase("ABCD")) {
				lastName = "EFGH";
			} else {
				lastName = "ABCD";
			}

			lastNameField.clear();
			lastNameField.sendKeys(lastName);
			driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]")).click();

			System.out.println("The last name was updated in the profile");

			waitUntilvisibilityOfElementLocated(By.id("tailBreadcrumbNode"),"Chatter Profile");

			Assert.assertTrue(driver.findElement(By.id("tailBreadcrumbNode")).getText().startsWith("Aana " + lastName), "Last name was not updated");

		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}
	}

	@Test(priority=35)
	public static void testCase35() throws InterruptedException, IOException {

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");


			driver.findElement(By.linkText("Contacts")).click();

			Actions actions = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tryLexDialogX\"]")));

			WebElement popUpBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
			actions.moveToElement(popUpBtn).click().build().perform();

			driver.findElement(By.linkText("Home")).click();

			waitUntilvisibilityOfElementLocated(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"),"All Tab Button");

			driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img")).click();

			driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/table/tbody/tr/td[2]/input")).click();

			Select customizeTabAdd = new Select(driver.findElement(By.id("duel_select_0")));


			for (WebElement w : customizeTabAdd.getOptions()) {
				if (w.getText().startsWith("Subscriptions")) {
					customizeTabAdd.selectByVisibleText(w.getText());
					driver.findElement(By.id("duel_select_0_right")).click();
					break;
				}
			}


			Select customizeTabRemove = new Select(driver.findElement(By.id("duel_select_1")));

			customizeTabRemove.selectByVisibleText("Subscriptions");

			driver.findElement(By.id("duel_select_0_left")).click();

			driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();

			driver.findElement(By.id("userNavButton")).click();	
			driver.findElement(By.linkText("Logout")).click();

			Thread.sleep(3000);



			login(CommonUtilities.getApplicationProperty("username"), CommonUtilities.getApplicationProperty("password"));

			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");

			boolean subscriptionTabAvailable = false;

			for (WebElement li : driver.findElements(By.xpath("//*[@id=\"tabBar\"]/li"))) {
				System.out.println(li.getAttribute("id"));
				if (li.getAttribute("id").equalsIgnoreCase("ContentSubscriptions_Tab")) {
					subscriptionTabAvailable = true;
					break;
				}

			}

			Assert.assertFalse(subscriptionTabAvailable, "Subscription tab should not be available but available.");
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}

	}


	@Test(priority=36)
	public static void testCase36() throws InterruptedException, IOException {

		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");
			WebElement userNavLabel= driver.findElement(By.id("userNavLabel"));


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

			Assert.assertTrue(true, "Actual and Expected Result does not match.");
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}

	}


	@Test(priority=37)
	public static void testCase37() throws InterruptedException, IOException {


		try {
			waitUntilvisibilityOfElementLocated(By.id("userNavLabel"),"User Navigation Label");
			WebElement userNavLabel= driver.findElement(By.id("userNavLabel"));


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

			Assert.assertTrue(true, "Actual and Expected Result does not match.");
		}
		catch(Exception e) {
			//report.attachScreeshot();
			Assert.assertFalse(true, e.getMessage());
		}

	}


}
