package com.naveenautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.ShoppingCartPage;

public class ShoppingCartTest extends TestBase {
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLoginPage = new AccountLoginPage(driver, true).get();
		myAccountPage = accountLoginPage.login("name1@gmail.com", "Password1");
	}

	@Test
	public void verifyUserAbleToApplyShippingAndTaxes() throws InterruptedException {
		ShoppingCartPage shoppingCartPage = myAccountPage.clickShoppingCartLink();
		shoppingCartPage.clickestimateShippingAndTaxesLink();
		shoppingCartPage.getShippingandTaxesQuote("India", "Delhi", "110001");
		softAssert.assertEquals(shoppingCartPage.getTextAlert(), "Success: Your shipping estimate has been applied!\n×",
				"Shipping Estimate not applied");
		softAssert.assertAll();

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}