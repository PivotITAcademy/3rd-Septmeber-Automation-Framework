package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountCreatedPage;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.RegisterAccountPage;

public class AccountCreatedTest extends TestBase {
	//this is account class
	AccountLoginPage accountLoginPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLoginPage = new AccountLoginPage(driver,true).get();
	}

	@Test @Ignore
	public void VerifyUserIsAbleToSignUpSuccessFully() {

		RegisterAccountPage registerAccountPage = accountLoginPage.clickContinueButton();

		AccountCreatedPage accountCreated = registerAccountPage.signUp("Jasmeet", "Kaur", "Jassi1234@gmail.com",
				"6472152994", "Password1", "Password1").get();

		Assert.assertEquals(accountCreated.getSuccessAccountCreatedTxt(), AccountCreatedPage.RegisterAccountText.ACCOUNT_CREATED_TXT,
				"Account not created");

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
