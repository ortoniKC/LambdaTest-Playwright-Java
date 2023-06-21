package browserContext;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.options.AriaRole;

public class LearnBrowserContext {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
		page.getByLabel("E-Mail Address").type("koushik350@gmail.com");
		page.getByLabel("Password").type("Pass123$");
		page.getByRole(AriaRole.BUTTON, 
				new GetByRoleOptions().setName("Login")).click();
		Locator myAccount = page.getByText("Edit your account information");
		assertThat(myAccount).isVisible();
		Page newTab = page.context().newPage();
		newTab.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/account");
		assertThat(myAccount).isVisible();
		newTab.close();
		context.close();
		
		
		BrowserContext context2 = browser.newContext();
		Page userPage = context2.newPage();
		userPage.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/account");
		
		BrowserType firefox = playwright.firefox();
		Page fp = firefox.launch(new LaunchOptions().setHeadless(false)).newPage();
		
		playwright.close();

		
		
	}

}
