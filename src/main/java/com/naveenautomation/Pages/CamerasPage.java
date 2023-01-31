package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class CamerasPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=product/category&path=33";

	public CamerasPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static By addToWishListBtn = By
			.cssSelector("div.row div.product-layout:nth-of-type(2) button:nth-of-type(2)");
	private static By AddToWishListSuccessBanner = By.cssSelector("div.alert-success");

	public void clickOnAddToWishListBtn() {
		((ProxyDriver) wd).click(addToWishListBtn);
	}

	public String getAddToWishListSuccessBannerText() {
		return ((ProxyDriver) wd).getText(AddToWishListSuccessBanner, 10);
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
	public CamerasPage get() {
		return (CamerasPage) super.get();
	}

}