package com.naveenautomation.Pages;

import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class ShoppingCartPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=checkout/cart";

	public ShoppingCartPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	public String getTitle() {
		return ((ProxyDriver) wd).getTitle();
	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

	@Override
	protected void isLoaded() {
		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}

	@Override
	public ShoppingCartPage get() {
		return (ShoppingCartPage) super.get();
	}

}
