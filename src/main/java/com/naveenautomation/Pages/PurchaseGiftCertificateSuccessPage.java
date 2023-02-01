package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomation.Browsers.ProxyDriver;

public class PurchaseGiftCertificateSuccessPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/voucher/success";

	private static final By continueBtn = By.cssSelector("div.buttons a");

	public PurchaseGiftCertificateSuccessPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

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

	public void getEstimatedShipping() {
		((ProxyDriver) wd).click(continueBtn);

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
