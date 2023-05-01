package day3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InteractWithInputs {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		page.locator("input#user-message").type("Hey Tester");
		page.locator("id=showInput").click();
		String message = page.locator("#message").textContent();
		System.out.println(message);
		assertThat(page.locator("#message")).hasText("Hey Tester");
		
//		// type vs fill
//		
//		page.navigate("https://www.lambdatest.com/selenium-playground/generate-file-to-download-demo");
//		page.locator("#textbox").fill("The HTML input input is an input element to enter an array of different values. Eash input type checkbox has value attribute which is used to define the value submitted by the checkbox.");
		
		// get input values
		
		/*
		 * page.navigate("https://letcode.in/edit"); String inputValue =
		 * page.locator("#getMe").inputValue(); System.out.println(inputValue);
		 * 
		 * String placeholderValue =
		 * page.locator("#fullName").getAttribute("placeholder");
		 * System.out.println(placeholderValue);
		 * 
		 * Locator fullNamelocator = page.locator("#fullName");
		 * assertThat(fullNamelocator).hasAttribute("placeholder",
		 * "Enter first & last name");
		 * 
		 * page.locator("id=clearMe").clear();
		 */
		
		
		page.navigate("https://www.lambdatest.com/selenium-playground/checkbox-demo");
		Locator isAge = page.locator("#isAgeSelected");
		assertThat(isAge).isChecked();
		isAge.check();
		assertThat(isAge).isChecked();
		
		playwright.close();
		
		

	}

}
