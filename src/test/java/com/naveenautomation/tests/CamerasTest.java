package com.naveenautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.CamerasPage;
import com.naveenautomation.Pages.MyAccountPage;

public class CamerasTest extends TestBase {
	private AccountLoginPage accountLoginPage;
	private MyAccountPage myAccountPage;
	private SoftAssert sf;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLoginPage = new AccountLoginPage(driver, true).get();
		myAccountPage = accountLoginPage.login("sg1@gmail.com", "Admin@123");
		sf = new SoftAssert();
	}

	@Test
	public void verifyUserIsAbleToAddCameraToWishList() {
		CamerasPage cameraPage = myAccountPage.clickCameraLink().get();
		cameraPage.clickOnAddToWishListBtn();
		sf.assertEquals("Success: You have added Nikon D300 to your wish list!\n" + "×",
				cameraPage.getAddToWishListSuccessBannerText(), "Invalid Page!");
		sf.assertAll();

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
