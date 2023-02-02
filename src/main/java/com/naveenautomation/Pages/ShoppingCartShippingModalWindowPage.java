package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class ShoppingCartShippingModalWindowPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=checkout/cart";

	public ShoppingCartShippingModalWindowPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By shippingRateRadioBtn = By.cssSelector("input[type='radio']");
	private static final By applyShippingBtn = By.cssSelector("input#button-shipping");

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

	public ShoppingCartPage applyShippingRates() {
		((ProxyDriver) wd).click(shippingRateRadioBtn);
		((ProxyDriver) wd).click(applyShippingBtn);
		return new ShoppingCartPage(wd, true);
	}

	@Override
	protected void isLoaded() {
		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}

	@Override
	public ShoppingCartShippingModalWindowPage get() {
		return (ShoppingCartShippingModalWindowPage) super.get();
	}

}
