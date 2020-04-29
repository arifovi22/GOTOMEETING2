package allPages;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class MasterPage {

	public WebDriver driver;


	@Parameters({"browser"})
	@BeforeTest
	public void openBrowser(String browser, String url) {
		if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Arif\\eclipse project\\GOTOMEETING2\\Browser\\chromedriver.exe" );
			driver = new ChromeDriver();
		}else if (browser.contains("fireFox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Arif\\eclipse project\\GOTOMEETING2\\Browser\\geckodriver.exe" );
			driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
	}

	public void clickOnElement(String locator) {
		if (locator.contains("xpath")) {
			driver.findElement(By.xpath(locator.split(":")[1])).click();
		} else if (locator.contains("cssSelector")) {
			driver.findElement(By.cssSelector(locator.split(":")[1])).click();
		}
	}
	//04/26/2020
	public String getText(String locator) {
		String actual = "";
		if (locator.contains("xpath")) {
			actual = driver.findElement(By.xpath(locator.split(":")[1])).getText();
		} else if (locator.contains("cssSelector")) {
			actual =	driver.findElement(By.cssSelector(locator.split(":")[1])).getText();
		}
		return actual;
	}

	public void typeOnElement(String locator, String value) {
		if (locator.contains("xpath")) {
			driver.findElement(By.xpath(locator.split(":")[1])).sendKeys(value,Keys.ENTER);
		} else if (locator.contains("cssSelector")) {
			driver.findElement(By.cssSelector(locator.split(":")[1])).sendKeys(value, Keys.ENTER);
		}
	}

	public void takeScreenshors(String filename) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File getTypeFile = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File("C:\\Users\\Arif\\eclipse project\\GOTOMEETING2\\ScreenShort\\"+filename+".png");
		FileUtils.copyFile(getTypeFile, file);
	}
	//04/26/2020
	public void switchFrame(int index) {
		driver.switchTo().frame(index);
	}

	public void scrollDown(int wide, int length) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+wide+","+length+")");
	}
	public void mouseHover(WebElement target) {
		Actions actions = new Actions(driver);
		actions.moveToElement(target).build().perform();
	}
	public WebElement webElement(String locator) {
		WebElement element = null;
		if (locator.contains("xpath")) {
			element = driver.findElement(By.xpath(locator.split(":")[1]));
		} else if (locator.contains("cssSelector")) {
			element = driver.findElement(By.cssSelector(locator.split(":")[1]));
		}
		return element;
	}
	//04/29/2020
	public String alertHandel() throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		Thread.sleep(5000);
		alert.accept();
		return alertText;
	}
}
