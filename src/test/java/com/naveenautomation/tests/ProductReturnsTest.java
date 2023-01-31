package com.naveenautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.ProductReturnsPage;

public class ProductReturnsTest extends TestBase {
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLoginPage = new AccountLoginPage(driver, true).get();
		myAccountPage = accountLoginPage.login("PeterLois@familyguy.com", "StewieisOG");
	}

	@Test
	public void verifyUserIsAbleTORequestForProductReturn() {
		ProductReturnsPage productReturn = myAccountPage.clickaddToReturnLink();
		productReturn.submitProductReturnBtn("5678", "2022-11-29", "Mackbook", "12345", "1", "3");
		softAssert.assertEquals(productReturn.getSuccessTextForProductReturnConfirmation(),
				"Thank you for submitting your return request. Your request has been sent to the relevant department for processing.",
				"Failed to return the item");
		softAssert.assertAll();
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
