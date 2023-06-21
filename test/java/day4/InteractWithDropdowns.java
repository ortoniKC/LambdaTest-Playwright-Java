package day4;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.List;

public class InteractWithDropdowns {

	public static void main(String[] args) {
		String selectURL = "https://www.lambdatest.com/selenium-playground/select-dropdown-demo";
		String jqueryURL = "https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo";
		
		// launch browser
		Page page = Playwright.create().chromium().launch(
				new LaunchOptions().setHeadless(false)
				).newPage();
		page.navigate(selectURL);
		
		Locator dayLocator = page.locator("select#select-demo");
		
		// select by value
		dayLocator.selectOption("Wednesday");
		Locator result = page.locator("p.selected-value");
		assertThat(result).containsText("Wednesday");
		
		// Select by label
		
		dayLocator.selectOption(new SelectOption().setValue("Friday"));
		System.out.println(result.textContent());
		assertThat(result).containsText("Friday");
		
		// Select by index
		dayLocator.selectOption(new SelectOption().setIndex(2));
		
		
		// Select multiple
		
		Locator states = page.locator("select[name='States']");
		states.selectOption(new String[] {"New Jersey", "Texas"});
		
		Locator options = states.locator("option");
		System.out.println(options.count());
		List<String> allInnerTexts = options.allInnerTexts();
		allInnerTexts.forEach(option -> System.out.println(option));
		
		// Select Jquery
		page.navigate(jqueryURL);
		Locator country = page.locator("span.select2-container").first();
		country.click();
		Locator list = page.locator("span.select2-results ul li",
				new Page.LocatorOptions().setHasText("Denmark"));
		list.click();
		Locator files = page.locator("select[name='files']");
		files.selectOption("Ruby");
		
		
		

	}

}
