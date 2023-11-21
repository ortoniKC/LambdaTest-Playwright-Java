package com.lt.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByLabelOptions;

public class RegisterAccountPage {
	private Page page = null;
	public RegisterAccountPage(Page page) {
		this.page = page;
	}

	public void clickContinue() {
		page.locator("input[value='Continue']").click();
	}

	public boolean isWarningVisible() {
		return page.locator("div.alert.alert-danger").isVisible();
	}

	public int isMandatoryWarningMessageVisible() {
		return page.locator("div.text-danger").count();
	}

	public void registerUserAccount(String firstName, String lastName, String emial, String telephone, 
			String password) {
		page.getByLabel("First Name").fill(firstName);
		page.getByLabel("Last Name").fill(lastName);
		page.getByLabel("E-Mail").fill(emial);
		page.getByLabel("Telephone").fill(telephone);
		page.getByLabel("Password", 
				new GetByLabelOptions().setExact(true)).fill(password);
		page.getByLabel("Password Confirm").fill(password);
		page.locator("label[for='input-agree']").click();
		this.clickContinue();
	}
	public String isRegistterSuccess() {
		return page.locator("div#content>h1").textContent().trim();
	}

}
