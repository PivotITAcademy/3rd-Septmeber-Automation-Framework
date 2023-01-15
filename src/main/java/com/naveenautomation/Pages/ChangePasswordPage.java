package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class ChangePasswordPage extends Page {

	
	private static final String PAGE_URL="/password";
	public ChangePasswordPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By password = By.id("input-password");
	private static final By confirmPwd = By.id("input-confirm");;
	private static final By continueBtn = By.xpath("//input[@value='Continue']");

	public MyAccountPage updatePassword(String pwd, String cPwd) {

		((ProxyDriver) wd).sendKeys(password, pwd);
		((ProxyDriver) wd).sendKeys(confirmPwd, cPwd);
		((ProxyDriver) wd).submit(continueBtn);
		return new MyAccountPage(wd, true);
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
