package com.naveenautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.SpecialsPage;

public class SpecialsPageTest extends TestBase {

	private SoftAssert softAssert = new SoftAssert();
	private AccountLoginPage accountLoginPage;
	private MyAccountPage myAccountPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLoginPage = new AccountLoginPage(driver, true).get();
		myAccountPage = accountLoginPage.login("parul.verma421@gmail.com", "Parul4");

	}

	@Test
	public void verifyUserIsAbleToAddItemFromSpecials() {
		SpecialsPage specialPage = myAccountPage.clickOnSpeacialInExtras();
		specialPage.clickOnAddToWishlist();

		// softAssert.assertEquals("Success: You have added Apple Cinema 30\" to your
		// wish list!\n" + "×";

		softAssert.assertEquals("Success: You have added Apple Cinema 30\" to your wish list!\n",
				specialPage.getSuccessBannerText(), "Invalid Banner Text");
		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();

	}

}
