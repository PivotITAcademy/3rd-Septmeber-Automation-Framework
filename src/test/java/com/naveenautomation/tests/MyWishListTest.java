package com.naveenautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.MonitorsPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.MyWishListPage;
import com.naveenautomation.Pages.MyWishListPage.WishList;

public class MyWishListTest extends TestBase {

	SoftAssert softAssert;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	MonitorsPage monitorsPage;
	MyWishListPage myWishListPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		softAssert = new SoftAssert();
		accountLoginPage = new AccountLoginPage(driver, true).get();
		myAccountPage = accountLoginPage.login("harinder21@gmail.com", "Password1");

	}

	@Test
	public void validateTitle() {
		// validating title of my wishlist page
		softAssert.assertEquals(driver.getTitle(), "My Wish List", "Title doesn't match");
		softAssert.assertAll();
	}

	@Test(priority = 1)
	public void verifyProductName() {
		myAccountPage.hoverOnComponents();
		monitorsPage = myAccountPage.clickMonitors();
		monitorsPage.addToWishListFirstMonitor();
		myWishListPage = monitorsPage.clickWishlistLink();
		// validating name of monitor added to the wishlist
		softAssert.assertEquals(myWishListPage.getElementFromTheTable("Apple Cinema 30\"", WishList.PRODUCTNAME).getText(),
				"Apple Cinema 30\"", "Monitor name doesn't match");

		softAssert.assertAll();
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
