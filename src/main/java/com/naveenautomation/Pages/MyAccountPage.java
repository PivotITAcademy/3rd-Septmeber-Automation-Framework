package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class MyAccountPage extends Page {

	private static final String PAGE_URL="/account";

	public MyAccountPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By  myAccountText=By.xpath("//h2[text()='My Account']");
	private static final By changePasswordLink=By.cssSelector("#column-right a:nth-of-type(3)");
	private static final By passwordChangesSuccessBanner=By.cssSelector("div.alert-success");
	private static final By orderHistoryLink=By.cssSelector("div.list-group a:nth-of-type(6)");

	public String getMyAccountText() {
		return ((ProxyDriver)wd).getText(myAccountText, 10);
	}

	public ChangePasswordPage clickChangePassword() {
		((ProxyDriver)wd).click(changePasswordLink);
		return new ChangePasswordPage(wd,true);
	}

	public String getPasswordChangeSuccessMessage() {
		return ((ProxyDriver)wd).getText(passwordChangesSuccessBanner, 10);
	}
	
	public OrderHistoryPage clickOrderHistoryLink() {
		((ProxyDriver)wd).click(orderHistoryLink);
		return new OrderHistoryPage(wd,true);
	}

	@Override
	protected void isLoaded() {

		if(!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}
	
	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}
}
