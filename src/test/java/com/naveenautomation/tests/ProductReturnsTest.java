package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.ChangePasswordPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.ProductReturnsPage;

public class ProductReturnsTest extends TestBase{
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLoginPage = new AccountLoginPage(driver,true).get();
		myAccountPage = accountLoginPage.login("iron.man@gmail.com", "Password2");
	}
	@Test
	public void verifyUserIsAbleTORequestForProductReturn() {
		ProductReturnsPage productReturn= myAccountPage.clickaddToReturnLink();
		productReturn.submitProductReturnBtn("5678","2022-11-29","Mackbook","12345","1","3"); 
		Assert.assertEquals(productReturn.getSuccessTextForProductReturnConfirmation(),
				"Thank you for submitting your return request. Your request has been sent to the relevant department for processing.", "Failed to return the item");
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
