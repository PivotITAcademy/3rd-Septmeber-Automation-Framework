package com.naveenautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.DesktopPage;
import com.naveenautomation.Pages.MyAccountPage;

public class DesktopTest extends TestBase {

	AccountLoginPage accountLoginPage;
	MyAccountPage accountPage;
	DesktopPage desktopPage;

	SoftAssert sf;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLoginPage = new AccountLoginPage(driver, true).get();
		accountPage = accountLoginPage.login("daman@gmail.com", "Daman1231");
		sf = new SoftAssert();
	}

	@Test
	public void verifyMacBookIsAddedToProductComparison() {
		desktopPage = accountPage.showAllDesktop();
		desktopPage.clickCompareButton();
		sf.assertEquals(desktopPage.getText(), "Success: You have added MacBook to your product comparison!\n×", "MacBook not Added Succesfully.....");
		sf.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}
