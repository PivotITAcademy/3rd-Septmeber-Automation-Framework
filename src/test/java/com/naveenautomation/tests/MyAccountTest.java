package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.ChangePasswordPage;
import com.naveenautomation.Pages.MyAccountInformationPage;
import com.naveenautomation.Pages.MyAccountPage;

public class MyAccountTest extends TestBase {

	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLoginPage = new AccountLoginPage(driver, true).get();
		myAccountPage = accountLoginPage.login("neethu123@gmail.com", "password@01");
	}

	@Test
	public void verifyLogin() {
		Assert.assertEquals(myAccountPage.getMyAccountText(), "My Account", "Login Failed");
	}

	@Test
	public void validateUserIsAbleToEditAccount() {

		MyAccountInformationPage accountInformationPage = myAccountPage.clickEditAccountLink().get();
		accountInformationPage.clickContinueAfterEditingTheAccount("1123456780");
		Assert.assertEquals(myAccountPage.getSuccessMessageText(),
				"Success: Your account has been successfully updated.", "Phone number is not updated");

	}

	@Ignore
	@Test
	public void verifyAlertBannerForInvalidLoginCredentials() {
		ChangePasswordPage changePasswordPage = myAccountPage.clickChangePassword();
		changePasswordPage.updatePassword("Password2", "Password2");
		Assert.assertEquals(myAccountPage.getSuccessMessageText(),
				"Success: Your password has been successfully updated.", "Password update failed");
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
