package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Browsers.ProxyDriver;

public class AccountLoginPage extends Page {

	private static final String PAGE_URL = "/login";

	public AccountLoginPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		// TODO Auto-generated constructor stub
	}

	private static By emailInputField = By.cssSelector("form div.form-group:first-of-type input");
	private static By passwordInputField = By.cssSelector("form div.form-group:last-of-type input");
	private static By loginBtn = By.cssSelector("input[type='submit']");
	private static By alertBanner = By.cssSelector("div.alert");
	private static By continueBtn = By.xpath("//a[text()='Continue']");

	public void enterEmailInputField(String email) {
		((ProxyDriver) wd).sendKeys(emailInputField, email);
	}

	public void enterPasswordInputField(String password) {
		((ProxyDriver) wd).sendKeys(passwordInputField, password);
	}

	public MyAccountPage login(String email, String password) {

		enterEmailInputField(email);
		enterPasswordInputField(password);
		((ProxyDriver) wd).submit(loginBtn);
		return new MyAccountPage(wd, true);

	}

	public String getTextFromAlertBanner() {
		return ((ProxyDriver) wd).getText(alertBanner);
	}

	public RegisterAccountPage clickContinueButton() {
		((ProxyDriver) wd).click(continueBtn);
		return new RegisterAccountPage(wd, true);
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
	public AccountLoginPage get() {
		// TODO Auto-generated method stub
		return (AccountLoginPage) super.get();
	}

}
