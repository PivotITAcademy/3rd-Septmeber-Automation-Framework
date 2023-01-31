package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class ContactPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=information/contact";

	public ContactPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By enquiryField = By.cssSelector("#input-enquiry");
	private static final By nameField = By.cssSelector("#input-name");
	private static final By emailField = By.cssSelector("#input-email");
	private static final By submitBtn = By.cssSelector("input.btn.btn-primary");
	private static final By successText = By.cssSelector("#content>p");

	public String getSuccessText() {
		return ((ProxyDriver) wd).getText(successText, 20);
	}

	private void enterNameField(String name) {
		((ProxyDriver) wd).sendKeys(nameField, name);
	}

	private void enterEmailField(String email) {
		((ProxyDriver) wd).sendKeys(emailField, email);
	}

	private void enterEnquiryField(String enquiryText) {
		((ProxyDriver) wd).sendKeys(enquiryField, enquiryText);
	}

	public void submitContactForm(String name, String email, String enquiry) {
		enterNameField(name);
		enterEmailField(email);
		enterEnquiryField(enquiry);
		((ProxyDriver) wd).submit(submitBtn);
	}

	@Override
	protected void isLoaded() {

		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

	@Override
	public ContactPage get() {
		return (ContactPage) super.get();
	}

}
