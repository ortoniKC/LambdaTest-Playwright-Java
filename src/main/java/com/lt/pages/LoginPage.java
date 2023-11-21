package com.lt.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private Page page = null;
	public LoginPage(Page page) {
		this.page = page;
	}
	
	public void loginAsUser(String email, String password) {
		page.getByLabel("E-Mail Address").fill(email);
		page.getByLabel("Password").fill(password);
		page.locator("//input[@value='Login']").click();
	}
}
