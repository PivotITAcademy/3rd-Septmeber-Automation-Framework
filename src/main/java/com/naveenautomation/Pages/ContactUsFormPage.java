package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.naveenautomation.Base.TestBase;

public class ContactUsFormPage extends TestBase {

	public ContactUsFormPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='name']")
	WebElement yourName;

	@FindBy(css = "input[name='email']")
	WebElement email;

	@FindBy(css = "textarea[name='enquiry']")
	WebElement enquiry;

	@FindBy(css = "input[type='submit']")
	WebElement submit;

	@FindBy(css = "#content>p")
	WebElement successMessage;

	public void yourNameField() {
		yourName.sendKeys("jas");
	}

	public void emailField() {
		yourName.sendKeys("jas@gmail.com");
	}

	public void enquiryField() {
		yourName.sendKeys("this is sample text");
	}

	public String validateSuccessMessage() {
		return successMessage.getText();
	}

	public String contactUsForm() {

		yourNameField();
		emailField();
		enquiryField();
		submit.click();
		return validateSuccessMessage();

	}

}
