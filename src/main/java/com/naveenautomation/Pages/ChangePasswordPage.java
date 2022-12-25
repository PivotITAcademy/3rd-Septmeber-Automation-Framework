package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class ChangePasswordPage extends TestBase {

	public ChangePasswordPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-password")
	WebElement password;

	@FindBy(id = "input-confirm")
	WebElement confirmPwd;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueBtn;

	public MyAccountPage updatePassword(String pwd, String cPwd) {
		password.sendKeys(pwd);
		confirmPwd.sendKeys(cPwd);
		continueBtn.submit();
		return new MyAccountPage();
	}

}
