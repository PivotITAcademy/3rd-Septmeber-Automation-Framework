package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.naveenautomation.Base.TestBase;

public class ContactUsFormPage extends TestBase {

	public ContactUsFormPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#input-name")
	WebElement yourName;

	@FindBy(css = "input[name='email']")
	WebElement email;

	@FindBy(css = "textarea[name='enquiry']")
	WebElement enquiry;

	@FindBy(css = "input[type='submit']")
	WebElement submit;

	@FindBy(css = "#content>p")
	WebElement successMessage;

	public void enquiryField() {
		enquiry.sendKeys("this is sample text");
	}

	public String validateSuccessMessage() {
		return successMessage.getText();
	}

	public void contactUsForm() {
		enquiryField();
		submit.click();
	}

}
