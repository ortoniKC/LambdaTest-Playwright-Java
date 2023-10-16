package runningOnCloud;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import base.Driver;
import base.PlaywrightConnection;

public class TestNGDemoTest extends PlaywrightConnection{
	Driver driver;
	@BeforeMethod
	public void setUp() throws Exception {
			driver = super.createConnection();
	}
	@AfterMethod
	public void tearDown() {
		super.closeConnection(driver);
	}
	
	@Test
	public void login() {
		Page page = driver.getPage();
		try {
			page.navigate("https://www.duckduckgo.com");
			Locator locator = page.locator("[name=\"q\"]");
			locator.click();
			locator.fill("LambdaTest");
			page.keyboard().press("Enter");
			String title = page.title();

			if (title.equals("LambdaTest at")) {
				// Use the following code to mark the test status.
				super.setTestStatus("passed", "Title matched", page);
			} else {
				super.setTestStatus("failed", "Title not matched", page);
			}

		} catch (Exception err) {
			super.setTestStatus("failed", err.getMessage(), page);
			err.printStackTrace();
		}
	}

}
