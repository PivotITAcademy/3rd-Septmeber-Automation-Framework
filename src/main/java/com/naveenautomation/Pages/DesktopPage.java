package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class DesktopPage extends Page {

	public DesktopPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		// TODO Auto-generated constructor stub
	}

	private static final String PAGE_URL = "/category";

	private static final By macBookCompareButton = By
			.cssSelector("#content>div div:nth-of-type(7) button:nth-of-type(3)");

	private static final By succesText = By.cssSelector("div.alert");

	public void clickCompareButton() {
		((ProxyDriver) wd).click(macBookCompareButton);
	}

	public String getText() {
		return ((ProxyDriver) wd).getText(succesText);
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

}
