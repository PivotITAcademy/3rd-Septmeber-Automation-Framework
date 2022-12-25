package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccountText;

	@FindBy(css = "#column-right a:nth-of-type(3)")
	WebElement changePasswordLink;

	@FindBy(css = "div.alert-success")
	WebElement passwordChangesSuccessBanner;

	public String getMyAccountText() {
		return myAccountText.getText();
	}

	public ChangePasswordPage clickChangePassword() {
		changePasswordLink.click();
		return new ChangePasswordPage();
	}

	public String getPasswordChangeSuccessMessage() {
		return passwordChangesSuccessBanner.getText();
	}
}
