package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.naveenautomation.Base.TestBase;

import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.PurchaseGiftCertificatePage;
import com.naveenautomation.Pages.PurchaseGiftCertificateSuccessPage;
import com.naveenautomation.Pages.ShoppingCartPage;

public class PurchaseGiftCertificateTest extends TestBase {
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLoginPage = new AccountLoginPage(driver, true).get();
		myAccountPage = accountLoginPage.login("harinder21@gmail.com", "Password1");
	}

	@Test
	public void verifyUserAbleToPurchaseGiftCertificate() {

		myAccountPage.clickGiftCertificateLink();
		PurchaseGiftCertificatePage giftPurchase = new PurchaseGiftCertificatePage(driver, true);
		Assert.assertEquals(giftPurchase.getTitle(), "Purchase a Gift Certificate", "Wrong title");
		PurchaseGiftCertificateSuccessPage giftPurchaseSucess = new PurchaseGiftCertificateSuccessPage(driver, true);
		giftPurchaseSucess = giftPurchase.purchaseGiftCertificate("KaurRaj", "rkaler456@gmail.com", "Happy Birthday",
				"5");
		ShoppingCartPage shoopingCart = giftPurchaseSucess.clickContinueBtn();
		Assert.assertEquals(shoopingCart.getTitle(), "Shopping Cart", "WrongTitle");
		

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
