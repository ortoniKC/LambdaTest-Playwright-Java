package frames;

import java.util.List;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnFrames {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		Page page = browserType.launch(new LaunchOptions().setHeadless(false)).newPage();
		page.navigate("https://the-internet.herokuapp.com/iframe");
		FrameLocator frameLocator = page.frameLocator("#mce_0_ifr");
		Locator bodyLocator = frameLocator.locator("body");
//		bodyLocator.click();
		bodyLocator.clear();
		bodyLocator.fill("Hey, subscribe to LambdaTest!");
//		page.close();
		
		page.navigate("https://letcode.in/frame");
		List<Frame> frames = page.frames();
		System.out.println("No.of frames available: "+frames.size());
//		frames.forEach(frame -> System.out.println(frame.url()));
		
		FrameLocator firstFrame = page.frameLocator("#firstFr");
		firstFrame.getByPlaceholder("Enter name").type("Koushik");
		FrameLocator nestedFrame = firstFrame.frameLocator("iframe.has-background-white");
		nestedFrame.getByPlaceholder("Enter email").type("koushik@mail.com");
		
		firstFrame.getByPlaceholder("Enter name").fill("Koushik Chatterjee");
		
		// Another way
//		Frame frame = page.frame("");
//		frame.locator("").fill("");
		playwright.close();
		
		
	}

}






