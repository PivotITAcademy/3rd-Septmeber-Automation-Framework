package com.naveenautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.ShoppingCartPage;
import com.naveenautomation.Pages.ShoppingCartShippingModalWindowPage;

public class ShoppingCartTest extends TestBase {
	private AccountLoginPage accountLoginPage;
	private MyAccountPage myAccountPage;
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
		ShoppingCartShippingModalWindowPage shoppingCartShippingModalWindowPage = shoppingCartPage
				.getShippingandTaxesQuote("India", "Delhi", "110001");
		ShoppingCartPage shoppingCartPageReloaded = shoppingCartShippingModalWindowPage.applyShippingRates();
		softAssert.assertEquals(shoppingCartPageReloaded.getTextAlert(),
				"Success: Your shipping estimate has been applied!\n×", "Shipping Estimate not applied");
		softAssert.assertAll();

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}