package com.naveenautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.ChangePasswordPage;
import com.naveenautomation.Pages.MyAccountPage;

public class ChangePasswordTest extends TestBase {
	AccountLoginPage accountLoginPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLoginPage = new AccountLoginPage();
	}

	

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
