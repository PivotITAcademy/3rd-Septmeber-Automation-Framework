package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class contactUsPage extends TestBase {

	public contactUsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[name='name']")
	WebElement yourName;
	
	@FindBy(xpath = "input[name='email']")
	WebElement email;
	
	@FindBy(xpath = "textarea[name='enquiry']")
	WebElement enquiry;
	
	public void yourNameField(String name) {
		yourName.sendKeys("jas");
	}
	
	public void emailField(String email) {
		yourName.sendKeys("jas@gmail.com");
	}
	
	public void enquiryField(String message) {
		yourName.sendKeys("sample text");
	}
	
	
}
