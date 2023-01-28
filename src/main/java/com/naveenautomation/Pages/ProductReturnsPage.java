package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class ProductReturnsPage extends Page{
	
	private static final String PAGE_URL = "/return/add";

	public ProductReturnsPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	
	}
	private static final By  orderID=By.id("input-order-id");
	private static final By orderDate=By.id("input-date-ordered");
	private static final By productName=By.id("input-product");
	private static final By productCode=By.id("input-model");
	private static final By quantity=By.id("input-quantity");
	private static final By reasonForReturn=By.xpath("//input[@value='3']");
	private static final By submitBtn=By.cssSelector("input[value='Submit']");
	private static final By successTextForProductReturn=By.cssSelector("#content>p:first-of-type");
	private void enterOrderID(String id) {
		((ProxyDriver) wd).sendKeys(orderID, id);
	}
	private void enterOrderDate(String date) {
		((ProxyDriver) wd).sendKeys(orderDate, date);
	}
	private void enterProductName(String pName) {
		((ProxyDriver) wd).sendKeys(productName, pName);
	}
	private void enterProductCode(String pCode) {
		((ProxyDriver) wd).sendKeys(productCode, pCode);
	}
	private void enterQuantity(String quant) {
		((ProxyDriver) wd).sendKeys(quantity, quant);
	}
	private void selectReasonForReturn(String value) {
		((ProxyDriver) wd).click(reasonForReturn);;
	}
	public String getSuccessTextForProductReturnConfirmation() {
		return ((ProxyDriver)wd).getText(successTextForProductReturn, 10);
	}
	public void submitProductReturnBtn(String id,String date,String pName,String pCode,String quant,String value) {
		enterOrderID(id);
		enterOrderDate(date);
		enterProductName(pName);
		enterProductCode(pCode);
		enterQuantity(quant);
		selectReasonForReturn(value);
		((ProxyDriver)wd).click(submitBtn);
	}
	
	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

	@Override
	public AccountLoginPage get() {
		return (AccountLoginPage) super.get();
	}
	@Override
	protected void isLoaded() {

		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
		
	}

}
