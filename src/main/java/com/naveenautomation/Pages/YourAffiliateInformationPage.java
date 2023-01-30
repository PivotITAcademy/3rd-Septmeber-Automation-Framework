package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class YourAffiliateInformationPage extends Page {

	private static final String PAGE_URL = "/affiliate/add";

	public YourAffiliateInformationPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static By companyInputField = By.id("input-company");
	private static By websiteInputField = By.id("input-website");
	private static By taxIDInputField = By.id("input-tax");
	private static By chequePayeeNameInputField = By.id("input-cheque");
	private static By agreeCheckBox = By.name("agree");
	private static By continueBtn = By.cssSelector("input[value='Continue']");

	public void enterCompanyInputField(String company) {
		((ProxyDriver) wd).sendKeys(companyInputField, company);
	}

	public void enterWebsiteInputField(String website) {
		((ProxyDriver) wd).sendKeys(websiteInputField, website);
	}

	public void enterTaxIDInputField(String taxID) {
		((ProxyDriver) wd).sendKeys(taxIDInputField, taxID);
	}

	public void enterChequePayeeNameInputField(String chequePayeeName) {
		((ProxyDriver) wd).sendKeys(chequePayeeNameInputField, chequePayeeName);
	}

	public void clickAgreeCheckBox() {
		((ProxyDriver) wd).click(agreeCheckBox);
	}

	public RegisterAccountPage clickContinueBtn() {
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
	public YourAffiliateInformationPage get() {
		return (YourAffiliateInformationPage) super.get();
	}

}
