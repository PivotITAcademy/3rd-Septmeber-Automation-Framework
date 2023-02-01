package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class MonitorsPage extends Page {

	String pageUrl = "/opencart/index.php?route=product/category&path=25_28";

	private String getPageUrlAfterVerification(String pageUrl) {
		if (pageUrl.contains("/category&path=")) {
			return pageUrl;
		}
		return null;
	}

	private final String PAGE_URL = getPageUrlAfterVerification(pageUrl);

	public MonitorsPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	public static final By firstProductAddToWishlistButton = By.cssSelector("button[onclick*=\"wishlist.add('42')\"]");

	public static final By wishListLink = By.cssSelector("ul.list-inline>li:nth-of-type(3) span");

	public void addToWishListFirstMonitor() {
		((ProxyDriver) wd).click(firstProductAddToWishlistButton);
	}

	public MyWishListPage clickWishlistLink() {
		((ProxyDriver) wd).click(wishListLink);
		return new MyWishListPage(wd, true);
	}

	@Override
	protected void isLoaded() {

		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}

	@Override
	public MonitorsPage get() {
		return (MonitorsPage) super.get();
	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

}
