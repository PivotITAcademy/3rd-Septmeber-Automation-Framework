package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naveenautomation.Base.TestBase;

public class AccountLoginPage extends TestBase {

	public AccountLoginPage() {

	}

	WebElement emailInputField = driver.findElement(By.cssSelector("form div.form-group:first-of-type input"));
	WebElement passwordInputField = driver.findElement(By.cssSelector("form div.form-group:last-of-type input"));
	WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit']"));
	WebElement alertBanner = driver.findElement(By.cssSelector("div.alert"));

	public void enterEmailInputField(String email) {
		emailInputField.sendKeys(email);
	}

	public void enterPasswordInputField(String password) {
		passwordInputField.sendKeys(password);
	}

	public void login(String email, String password) {
		enterEmailInputField(email);
		enterPasswordInputField(password);
		loginBtn.submit();
	}

	public String getTextFromAlertBanner() {
		return alertBanner.getText();
	}

}
