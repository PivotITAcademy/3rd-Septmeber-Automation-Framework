package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;

public class AccountLoginTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}

	@Test
	public void verifyAlertBannerForInvalidLoginCredentials() {
		AccountLoginPage accountLoginPage = new AccountLoginPage();
		accountLoginPage.login("iron.man@gmail.com", "a-vengers.com");
		Assert.assertEquals(accountLoginPage.getTextFromAlertBanner(),
				"Warning: No match for E-Mail Address and/or Password.","Alert text doesn't match");
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
