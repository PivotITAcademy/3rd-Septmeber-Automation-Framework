package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class SpecialsPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=product/special";

	public SpecialsPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	public static By addAppleCinemaToWishlist = By.cssSelector("div.button-group button:nth-of-type(2)");

	private static By AddToWishListSuccessBanner = By.cssSelector("div.alert-success");

	public void clickOnAddToWishlist() {
		((ProxyDriver) wd).click(addAppleCinemaToWishlist);

	}

	public String getSuccessBannerText() {

		String regex = "\n×";
		return ((ProxyDriver) wd).getText(AddToWishListSuccessBanner, 10).replace(regex, "");

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
	public SpecialsPage get() {
		return (SpecialsPage) super.get();
	}

}
