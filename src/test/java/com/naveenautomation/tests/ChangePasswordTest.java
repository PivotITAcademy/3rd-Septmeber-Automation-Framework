package com.naveenautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;

public class ChangePasswordTest extends TestBase {
	AccountLoginPage accountLoginPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLoginPage = new AccountLoginPage(driver,true).get();
	}

	

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
