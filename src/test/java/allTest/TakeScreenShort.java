package allTest;

import java.io.IOException;

import org.testng.annotations.Test;

import allPages.MasterPage;

public class TakeScreenShort {
	@Test
	public void screenShort() throws IOException {
		MasterPage masterPage = new MasterPage();
		masterPage.openBrowser("chrome","https://jqueryui.com/selectable/");
		masterPage.takeScreenshors("take1");
		
	}

}
