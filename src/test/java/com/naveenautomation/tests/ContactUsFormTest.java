package com.naveenautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.ContactUsFormPage;
import com.naveenautomation.Pages.MyAccountPage;

public class ContactUsFormTest extends TestBase {
	SoftAssert sf;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	ContactUsFormPage contactUsFormPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf = new SoftAssert();
	}

	@Test
	public void validateContactUsForm() {
		accountLoginPage = new AccountLoginPage(driver, true).get();
		myAccountPage = accountLoginPage.login("khehrajass@gmail.com", "Qwerty");
		sf.assertEquals(myAccountPage.getMyAccountText(), "My Account", "Login Failed");
		contactUsFormPage = myAccountPage.clickContactUs();
		contactUsFormPage.contactUsForm();
		sf.assertEquals(contactUsFormPage.validateSuccessMessage(),
				"Your enquiry has been successfully sent to the store owner!", "Message does not match");
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
