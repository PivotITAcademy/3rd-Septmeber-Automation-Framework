package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class RegisterAccountPage extends Page {

	private static final String PAGE_URL = "account/register";

	public RegisterAccountPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By fName = By.id("input-firstname");;
	private static final By lName = By.id("input-lastname");;
	private static final By email = By.id("input-email");;
	private static final By telephone = By.id("input-telephone");;
	private static final By password = By.id("input-password");;
	private static final By confirmPassword = By.id("input-confirm");
	private static final By privacyPolicyCheckBox = By.xpath("//input[@type='checkbox']");
	private static final By continueBtn = By.xpath("//input[@type='submit']");

	private void enterFirstName(String fname) {
		((ProxyDriver) wd).sendKeys(fName, fname);
	}

	private void enterLastName(String lname) {
		((ProxyDriver) wd).sendKeys(lName, lname);
	}

	private void enterEmail(String emailInput) {
		((ProxyDriver) wd).sendKeys(email, emailInput);
	}

	private void enterPhoneNumber(String phone) {
		((ProxyDriver) wd).sendKeys(telephone, phone);
	}

	private void enterPassword(String pwd) {
		((ProxyDriver) wd).sendKeys(password, pwd);
	}

	private void enterConfirmPwd(String cPwd) {
		((ProxyDriver) wd).sendKeys(confirmPassword, cPwd);
	}

	private void clickPrivacyPolicy() {
		((ProxyDriver) wd).click(privacyPolicyCheckBox);
	}

	public AccountCreatedPage signUp(String fname, String lname, String emailInput, String phone, String pwd,
			String cPwd) {
		enterFirstName(fname);
		enterLastName(lname);
		enterEmail(emailInput);
		enterPhoneNumber(phone);
		enterPassword(pwd);
		enterConfirmPwd(cPwd);
		clickPrivacyPolicy();
		((ProxyDriver) wd).click(continueBtn);
		return new AccountCreatedPage(wd, true);
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
