package com.naveenautomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistoryPage extends Page {

	private static final String PAGE_URL="account/order";
	
	public OrderHistoryPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		// TODO Auto-generated constructor stub
	}

	public WebElement getElementFromTheTable(String orderID, OrderHistory column) {

		int columnIndex = getIndexForColumn(column);

		List<WebElement> rowsInTable = wd
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] tbody tr"));

		for (int i = 0; i < rowsInTable.size(); i++) {
			List<WebElement> cells = rowsInTable.get(i).findElements(By.cssSelector("td"));
			String orderIdText = cells.get(0).getText();
			if (orderIdText.equals(orderID)) {
				return cells.get(columnIndex);
			}

		}

		System.out.println("Column name was not found!!!");
		return null;
	}

	public int getIndexForColumn(OrderHistory column) {
		List<WebElement> headers = wd
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] thead tr td"));

		for (WebElement webElement : headers) {
			String headerText = webElement.getText();
			if (headerText.equals(column.getName())) {
				return headers.indexOf(webElement);
			}

		}
		System.out.println("Column does not exist.....");
		return -1;
	}

	public enum OrderHistory {

		ORDERID("Order ID"), 
		CUSTOMER("Customer"), 
		NOOFPRODUCTS("No. of Products"), 
		STATUS("Status"), 
		TOTAL("Total"),
		DATAADDED("Date Added");

		String name;

		private OrderHistory(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
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
