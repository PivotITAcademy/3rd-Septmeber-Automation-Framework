package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class ShoppingCartPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=checkout/cart";

	public ShoppingCartPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By estimateShippingAndTaxesLink = By.cssSelector("div.panel-group>div:nth-of-type(2) a");
	private static final By countryDropDown = By.id("input-country");
	private static final By regionDropDown = By.id("input-zone");
	private static final By postalCodeInputBox = By.cssSelector("input#input-postcode");
	private static final By getQuotesBtn = By.cssSelector("button#button-quote");
	private static final By shippingRateRadioBtn = By.cssSelector("input[type='radio']");
	private static final By alertBanner = By.cssSelector("div.alert");

	public void expandEstimateShippingTaxes() {
		((ProxyDriver) wd).click(estimateShippingAndTaxesLink);
	}

	public String getTitle() {
		return ((ProxyDriver) wd).getTitle();
	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

	private void selectCountryFromDropDown(String countryValue) {
		((ProxyDriver) wd).selectFromDropDown(((ProxyDriver) wd).findElement(countryDropDown), countryValue);
	}

	private void selectRegionFromDropDown(String regionValue) {
		((ProxyDriver) wd).selectFromDropDown(((ProxyDriver) wd).findElement(regionDropDown), regionValue);
	}

	private void inputPostalCode(String pinCode) {
		((ProxyDriver) wd).sendKeys(postalCodeInputBox, pinCode);
	}

	private ShoppingCartShippingModalWindowPage switchToModalShippingWindow() {
		((ProxyDriver) wd).click(getQuotesBtn);
		((ProxyDriver) wd).switchToNewTab(shippingRateRadioBtn);
		return new ShoppingCartShippingModalWindowPage(wd, true);

	}

	public String getTextAlert() {
		return ((ProxyDriver) wd).getText(alertBanner);

	}

	public ShoppingCartShippingModalWindowPage getShippingandTaxesQuote(String countryValue, String regionValue,
			String pinCode) {
		expandEstimateShippingTaxes();
		selectCountryFromDropDown(countryValue);
		selectRegionFromDropDown(regionValue);
		inputPostalCode(pinCode);
		switchToModalShippingWindow();
		return new ShoppingCartShippingModalWindowPage(wd, true);
	}

	@Override
	protected void isLoaded() {
		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}

	@Override
	public ShoppingCartPage get() {
		return (ShoppingCartPage) super.get();
	}

}
