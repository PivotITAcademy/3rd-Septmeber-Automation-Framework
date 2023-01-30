package com.naveenautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.YourAffiliateInformationPage;

public class YourAffiliateInformationTest extends TestBase {

	SoftAssert softAssert = new SoftAssert();
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	YourAffiliateInformationPage yourAffiliateInformationPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLoginPage = new AccountLoginPage(driver, true).get();
		myAccountPage = accountLoginPage.login("nav.jot26@gmail.com", "Navjot13");
	}

	@Test
	public void verifyUserIsAbleToCreateAffiliateAccount() {
		yourAffiliateInformationPage = myAccountPage.clickRegisterForAnAffiliateAccount();
		yourAffiliateInformationPage.enterCompanyInputField("Amazon");
		yourAffiliateInformationPage.enterWebsiteInputField("Amazon.com");
		yourAffiliateInformationPage.enterTaxIDInputField("12345RT00001");
		yourAffiliateInformationPage.enterChequePayeeNameInputField("Amazon");
		yourAffiliateInformationPage.clickAgreeCheckBox();
		yourAffiliateInformationPage.clickContinueBtn();
		softAssert.assertEquals(myAccountPage.getAffiliateAccountCreationSuccessText(),
				"Success: Your account has been successfully updated.", "Affiliate Account creation failed");
		softAssert.assertAll();
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
