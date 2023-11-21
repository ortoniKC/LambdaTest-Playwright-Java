package com.lt.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HeaderSection {
	
	private Page page = null;
	
	public HeaderSection(Page page) {
		this.page = page;
	}
	
	private Locator getMyAccount() {
		return this.page.locator("//a[contains(.,'My account')]").last();
	}
	
	public void clickLogin() {
		this.getMyAccount().hover();
		this.page.locator("//span[text()[normalize-space()='Login']]").click();
	}
	
	public void clickRegister() {
		this.getMyAccount().hover();
		this.page.locator("//span[text()[normalize-space()='Register']]").click();
	}

}
