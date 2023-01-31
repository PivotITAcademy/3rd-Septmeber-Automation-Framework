package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class AccountCreatedPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/success";

	public AccountCreatedPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By accountCreationSuccessTxt = By.cssSelector("#content h1");

	public String getSuccessAccountCreatedTxt() {
		return ((ProxyDriver) wd).getText(accountCreationSuccessTxt, 10);
	}

	public static class RegisterAccountText {

		public static final String ACCOUNT_CREATED_TXT = "Your Account Has Been Created!";
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
	public AccountCreatedPage get() {
		return (AccountCreatedPage) super.get();
	}

}
