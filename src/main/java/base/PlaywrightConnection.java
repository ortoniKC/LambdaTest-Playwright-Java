package base;
import java.net.URLEncoder;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightConnection {

	protected Driver createConnection() throws Exception {
		try {
			Playwright playwright = Playwright.create();
			String caps = URLEncoder.encode(LTCapability.getDefaultTestCapability().toString(), "utf-8");
			String cdpUrl = "wss://cdp.lambdatest.com/playwright?capabilities=" + caps;
			Browser browser = playwright.chromium().connect(cdpUrl);
			Page page = browser.newPage();
			return new Driver(playwright, browser,page);
		}
		catch (Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	protected void closeConnection(Driver driver){
		driver.getPage().close();
		driver.getBrowser().close();
		driver.getPlaywright().close();
	}

	protected void setTestStatus(String status, String remark,Page page) {
		page.evaluate("_ => {}", "lambdatest_action: { \"action\": \"setTestStatus\", \"arguments\": { \"status\": \"" + status + "\", \"remark\": \"" + remark + "\"}}");
	}
}