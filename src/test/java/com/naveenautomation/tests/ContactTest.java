package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.ContactPage;
import com.naveenautomation.Pages.MyAccountPage;

public class ContactTest extends TestBase {
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	ContactPage contactPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLoginPage = new AccountLoginPage(driver, true).get();
		myAccountPage = accountLoginPage.login("iron.man@gmail.com", "Password2");
	}

	@Test
	public void VerifyUserIsAbleToSubmitContactFormSuccessFully() {
		contactPage = myAccountPage.clickPhoneLink();
		contactPage.submitContactForm("ironman", "iron.man@gmail.com",
				"This is test to verify submission of contact form");
		Assert.assertEquals(contactPage.getSuccessText(), "Your enquiry has been successfully sent to the store owner!",
				"Ivalid text");

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
