package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountCreated;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.RegisterAccountPage;

public class AccountCreatedTest extends TestBase {

	AccountLoginPage accountLoginPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLoginPage = new AccountLoginPage();
	}

	@Test
	public void VerifyUserIsAbleToSignUpSuccessFully() {

		RegisterAccountPage registerAccountPage = accountLoginPage.clickContinueButton();

		AccountCreated accountCreated = registerAccountPage.signUp("Jasmeet", "Kaur", "Jassi123@gmail.com",
				"6472152994", "Password1", "Password1");

		Assert.assertEquals(accountCreated.getSuccessAccountCreatedTxt(), "Your Account Has Been Created!",
				"Account not created");

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
