package com.naveenautomation.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.OrderHistoryPage;
import com.naveenautomation.Pages.OrderHistoryPage.OrderHistory;

public class OrderHistoryTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}

	@Ignore
	@Test
	public void verifyPriceForOrder() {
		AccountLoginPage accountLoginPage = new AccountLoginPage(driver,true).get();
		MyAccountPage myAccountPage=accountLoginPage.login("iron.man@gmail.com", "Password2").get();
		OrderHistoryPage orderHistoryPage=myAccountPage.clickOrderHistoryLink();
		WebElement priceElement=orderHistoryPage.getElementFromTheTable("#2539", OrderHistory.CUSTOMER);
		Assert.assertEquals(priceElement.getText(), "priceElement.getText()");
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
