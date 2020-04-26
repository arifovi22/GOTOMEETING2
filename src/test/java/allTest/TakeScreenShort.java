package allTest;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import allPages.MasterPage;


public class TakeScreenShort {

	MasterPage masterPage = new MasterPage();
	//@Test
	public void screenShort() throws IOException {
		masterPage.openBrowser("chrome","https://jqueryui.com/selectable/");
		masterPage.takeScreenshors("take1");
		masterPage.driver.close();
		
	}
	//@Test //04/26/2020
	public void validateColour() throws IOException, InterruptedException {
		String button = "xpath://button[@id='button']";
		String text  = "xpath://p[contains(text(),'Etiam libero neque')]";
		masterPage.openBrowser("chrome","https://jqueryui.com/animate/");
		masterPage.switchFrame(0);
		masterPage.clickOnElement(button);
		Thread.sleep(2000);
		String actual = masterPage.getText(text);
		Assert.assertEquals(actual,
		"Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.");
		masterPage.driver.close();
	}
	@Test
	public void mouseHover() {
		String item = "xpath://div[@id='ui-id-17']";
		masterPage.openBrowser("chrome","https://jqueryui.com/themeroller/");
		masterPage.scrollDown(0,2500);

		WebElement element = masterPage.webElement(item);
		masterPage.mouseHover(element);
		
		
	}
	
	
	

}
