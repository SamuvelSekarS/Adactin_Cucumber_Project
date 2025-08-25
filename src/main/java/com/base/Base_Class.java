package com.base;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class Base_Class {

	public static WebDriver driver;

//	public static ExtentReports extentReports;
	
	public static File file;

	public static JavascriptExecutor javaScriptExecutor;


	protected static WebDriver launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
		} catch (Exception e) {
			Assert.fail("ERROR :  OCCUR DURING BROWSER LAUNCH");
		}
		driver.manage().window().maximize();
		return driver;
	}

	protected static WebDriver launchUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING URL LAUNCH");
		}
		return driver;
	}

	protected static void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING BROWSER CLOSE");
		}
	}

	protected static void terminateBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING TERMINATE BROWSER");
		}
	}

	protected static void passInput(WebElement element, String input) {
		try {
			element.sendKeys(input);

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING VALUE PASSING");
		}
	}

	protected static void navigatePage(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING NAVIGATE TO OTHER URL");
		}
	}

	protected static void elementClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING ELEMENT CLICK");
		}
	}

	protected static Select dropDownObject(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	protected static void selectByVisibleText(WebElement element, String text) {
		try {
			dropDownObject(element).selectByVisibleText(text);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING SELECT BY VISIBLE TEXT");
		}
	}

	protected static void selectByIndex(WebElement element, int num) {
		try {
			dropDownObject(element).selectByIndex(num);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING SELECT INDEX");
		}

	}

	protected static void validation(String actual, String excepected) {
		try {
			Assert.assertEquals(actual, excepected);
		} catch (Exception e) {

			Assert.fail("ERROR : OCCUR DURING VALIDATION");
		}
	}

	protected static void windowsHandles(int num) {
		try {
			List<String> allWindow = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(allWindow.get(num));

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING WINDO HANDLE");
		}
	}

	public static void implicitWait(int num) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));

	}

	protected static void localWait(int sec) throws InterruptedException {
		try {
			Thread.sleep(sec);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING ELEMENT WAIT");
		}
	}

	public static void extentReportStart(String location) {
//		extentReports = new ExtentReports();
		file = new File(location);
//		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
//		extentReports.attachReporter(sparkReporter);
//		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
//		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}

	public static void extentReportTearDown(String location) throws IOException {
		//extentReports.flush();
		file = new File(location);
		Desktop.getDesktop().browse((file).toURI());
	}

	public String takeScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("Screenshot\\.png" + "_" + timeStamp + ".png");
		FileHandler.copy(scrfile, destfile);
		return destfile.getAbsolutePath();
	}

	public static void javaScriptSenkeys(WebElement element, String value) {
		javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("arguments[0].value=arguments[1];", element, value);
	}

	public static void javaScriptClick(WebElement element) {
		javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("arguments[0].click();", element);
	}

	public static void scrollDown(int pixels) {
		javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.scrollBy(0," + pixels + ")", ""); // Scrolls down by the specified
	}

	// Method to scroll up the page by a specified number of pixels
	public static void scrollUp(int pixels) {
		javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.scrollBy(0,-" + pixels + ")", ""); // Scrolls up by the specified
																					// number of pixels
	}

	public static void horizontalRight(int pixels) {
		javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.scrollBy(arguments[0], 0)", pixels);
		; // Scrolls up by the specified
	}

	public static void calendarClick(WebElement datePickerElement) {
		try {
			// Open the calendar
			datePickerElement.click();

			// Get the current day
			LocalDate currentDate = LocalDate.now();
			int currentDay = currentDate.getDayOfMonth();

			List<WebElement> dateElements = driver.findElements(By.xpath("//table/tbody/tr/td"));
			// Iterate through the calendar dates and click on the current day
			for (WebElement dateElement : dateElements) {
				String day = dateElement.getText();
				if (!day.isEmpty() && Integer.parseInt(day) == currentDay) {
					dateElement.click();
					System.out.println("Selected date: " + currentDay);
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("Error selecting the current date: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void allTextGet(List<WebElement> Elements) {
		for (WebElement webElement : Elements) {
			String text = webElement.getText();
			System.out.println(text);
		}
	}

	protected static void selectOptions(WebElement element, String type, String value) {
		try {

			Select select = new Select(element);
			if (type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(value);
			} else if (type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			} else if (type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			} else {
				System.out.println("Invalid selection type. Use 'text', 'index', or 'value'.");
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING VALUE SELECT");
		}
	}

	protected static void deselectOption(WebElement element, String type, String value) {
		Select select = new Select(element);
		if (select.isMultiple()) {
			if (type.equalsIgnoreCase("text")) {
				select.deselectByVisibleText(value);
			} else if (type.equalsIgnoreCase("index")) {
				select.deselectByIndex(Integer.parseInt(value));
			} else if (type.equalsIgnoreCase("value")) {
				select.deselectByValue(value);
			} else {
				System.out.println("Invalid deselection type. Use 'text', 'index', or 'value'.");
			}
		} else {
			System.out.println("Deselect operation not supported for single-select dropdown.");
		}
	}

	protected static void switchToFrame(WebElement element, String frameType, int num) {
		try {
			
		if (frameType.equalsIgnoreCase("index")) {
			driver.switchTo().frame(Integer.parseInt(frameType));

		} else if (frameType.equalsIgnoreCase("name")) {
			driver.switchTo().frame(element);

		} else if (frameType.equalsIgnoreCase("element")) {
			driver.switchTo().frame(element);
		}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING SWITCH TO FRAME");
		}
	}
	
	
	
}
