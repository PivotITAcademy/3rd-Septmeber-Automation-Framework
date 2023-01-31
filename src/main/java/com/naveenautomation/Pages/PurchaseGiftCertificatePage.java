package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Browsers.ProxyDriver;

public class PurchaseGiftCertificatePage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/voucher";

	public PurchaseGiftCertificatePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By recepitNameInputField = By.cssSelector("input[name='to_name']");
	private static final By recepitEmailInputField = By.cssSelector("input[name='to_email']");
	private static final By senderNameInputField = By.cssSelector("input[name='from_name']");
	private static final By senderEmailInputField = By.cssSelector("");
	private static By textMessageInput = By.cssSelector("textarea[name='message']");
	private static By amountInputField = By.cssSelector("input[name='amount']");
	private static By GiftCertificatetThemeradioBtnBirthdayOption = By.cssSelector("input[value='7']");
	private static By GiftCertificatetThemeradioBtnChristmasOption = By.cssSelector("input[value='6']");
	private static By GiftCertificatetThemeradioGeneralOption = By.cssSelector("input[value='8']");
	private static By checkBox = By.cssSelector("input[type='checkbox']");
	private static By continueBtn = By.cssSelector("input[type='submit']");

	private void enterrecepitName(String recepitNameInputField1) {
		((ProxyDriver) wd).sendKeys(recepitNameInputField, recepitNameInputField1);
	}

	private void enterrecepitEmail(String recepitEmailInputField1) {
		((ProxyDriver) wd).sendKeys(recepitEmailInputField, recepitEmailInputField1);
	}

	private void entertextMessageInput(String textMessageInput1) {

		((ProxyDriver) wd).sendKeys(textMessageInput, textMessageInput1);
	}

	private void entersenderEmail(String senderEmailInputField1) {

		((ProxyDriver) wd).sendKeys(senderEmailInputField, senderEmailInputField1);
	}

	private void entersenderName(String senderNameInputField1) {
		((ProxyDriver) wd).sendKeys(senderNameInputField, senderNameInputField1);
	}

	private void enteramountInputField(String amountInputField1) {
		((ProxyDriver) wd).sendKeys(amountInputField, amountInputField1);
	}

	private void clickCheckBox() {
		((ProxyDriver) wd).click(checkBox);
	}

	private void clickRadioOption() {
		((ProxyDriver) wd).click(GiftCertificatetThemeradioBtnChristmasOption);
	}

	private void continueBtn() {
		((ProxyDriver) wd).click(continueBtn);
	}

	public PurchaseGiftCertificateSuccessPage purchaseGiftCertificate(String recepitNameInputField1,
			String recepitEmailInputField1, String textMessageInput1, String amountInputField1) {
		enterrecepitName(recepitNameInputField1);
		enterrecepitEmail(recepitEmailInputField1);
		clickRadioOption();
		entertextMessageInput(textMessageInput1);
		enteramountInputField(amountInputField1);
		clickCheckBox();
		continueBtn();

		return new PurchaseGiftCertificateSuccessPage(wd, true);
	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

	@Override
	protected void isLoaded() {
		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}

	public String getTitle() {
		return ((ProxyDriver) wd).getTitle();
	}

	@Override
	public PurchaseGiftCertificatePage get() {
		return (PurchaseGiftCertificatePage) super.get();
	}

}
