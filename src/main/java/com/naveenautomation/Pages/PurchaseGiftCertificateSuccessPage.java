package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class PurchaseGiftCertificateSuccessPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/voucher/success";

	public PurchaseGiftCertificateSuccessPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static final By continueBtn = By.cssSelector("div.buttons a");

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

	public ShoppingCartPage clickContinueBtn() {
		((ProxyDriver) wd).click(continueBtn);
		return new ShoppingCartPage(wd, true);
	}
	
	@Override
	public PurchaseGiftCertificateSuccessPage get() {
		return (PurchaseGiftCertificateSuccessPage) super.get();
	}
}
