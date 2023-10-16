package base;
import com.google.gson.JsonObject;

public class LTCapability {
	public static JsonObject getDefaultTestCapability() {
		JsonObject capabilities1 = new JsonObject();
		JsonObject ltOptions1 = new JsonObject();

		String user = "koushik350";
		String accessKey = "GhnFCYUK4IWo9j4f38tr2RoS3rwmJxaR0AozKsHvRjigNBDzlJ";

		capabilities1.addProperty("browserName", "Chrome"); // Browsers allowed: `Chrome`, `MicrosoftEdge`, `pw-chromium`, `pw-firefox` and `pw-webkit`
		capabilities1.addProperty("browserVersion", "latest");
		ltOptions1.addProperty("platform", "Windows 10");
		ltOptions1.addProperty("name", "Playwright Test");
		ltOptions1.addProperty("build", "Playwright TestNG Build");
		ltOptions1.addProperty("user", user);
		ltOptions1.addProperty("accessKey", accessKey);
		capabilities1.add("LT:Options", ltOptions1);
		
		return capabilities1;
	}
}