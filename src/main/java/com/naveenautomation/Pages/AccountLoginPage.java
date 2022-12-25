package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class AccountLoginPage extends TestBase {

	public AccountLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "form div.form-group:first-of-type input")
	WebElement emailInputField;

	@FindBy(css = "form div.form-group:last-of-type input")
	WebElement passwordInputField;

	@FindBy(css = "input[type='submit']")
	WebElement loginBtn;

	@FindBy(css = "div.alert")
	WebElement alertBanner;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtn;

	public void enterEmailInputField(String email) {
		emailInputField.sendKeys(email);
	}

	public void enterPasswordInputField(String password) {
		passwordInputField.sendKeys(password);
	}

	public MyAccountPage login(String email, String password) {
		enterEmailInputField(email);
		enterPasswordInputField(password);
		loginBtn.submit();
		return new MyAccountPage();

	}

	public String getTextFromAlertBanner() {
		return alertBanner.getText();
	}

	public RegisterAccountPage clickContinueButton() {
		continueBtn.click();
		return new RegisterAccountPage();
	}

}
