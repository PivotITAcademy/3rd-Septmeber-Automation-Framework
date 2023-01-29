package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class MonitorsPage extends Page{

	
	private static final String PAGE_URL="/category&path=25_28";

	
	public MonitorsPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	
	
	public static final By firstProductAddToWishlistButton = By
			.cssSelector("button[onclick*=\"wishlist.add('42')\"]");
	
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
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

}
