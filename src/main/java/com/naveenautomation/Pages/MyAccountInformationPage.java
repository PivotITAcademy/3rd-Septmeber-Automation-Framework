package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class MyAccountInformationPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/edit";

	public MyAccountInformationPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By telephoneInputField = By.id("input-telephone");
	private static final By continueBtn = By.cssSelector("input[type='Submit']");

	private void changingPhoneNumber(String phoneNum) {
		((ProxyDriver) wd).clear(telephoneInputField);
		((ProxyDriver) wd).sendKeys(telephoneInputField, phoneNum);
	}

	public MyAccountPage clickContinueAfterEditingTheAccount(String phoneNum) {
		changingPhoneNumber(phoneNum);
		((ProxyDriver) wd).submit(continueBtn);
		return new MyAccountPage(wd, true);
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
	public MyAccountInformationPage get() {
		return (MyAccountInformationPage) super.get();
	}

}
