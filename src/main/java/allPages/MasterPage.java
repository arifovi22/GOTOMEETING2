package allPages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class MasterPage {
	WebDriver driver;

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
		driver.get(url);
	}

	public void clickOnElement(String locator) {
		if (locator.contains("xpath")) {
			driver.findElement(By.xpath(locator.split(":")[1])).click();
		} else if (locator.contains("cssSelector")) {
			driver.findElement(By.cssSelector(locator.split(":")[1])).click();
		}
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

}
