package com.naveenautomation.Pages;

import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class ShoppingCartPage extends Page {

	private static final String PAGE_URL = "checkout/cart";

	public ShoppingCartPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}
	public String getTitle() {
		return((ProxyDriver) wd).getTitle();
		
	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

	@Override
	protected void isLoaded() {
		// TODO Auto-generated method stub

	}

}
