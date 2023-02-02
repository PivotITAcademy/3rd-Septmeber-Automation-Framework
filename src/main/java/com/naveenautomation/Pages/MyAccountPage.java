package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class MyAccountPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/account";

	public MyAccountPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By phonelink = By.cssSelector("i.fa.fa-phone");
	private static final By GiftCertificatesLink = By
			.cssSelector("footer div.row div.col-sm-3:nth-of-type(3) ul li:nth-of-type(2) a");
	private static final By myAccountText = By.xpath("//h2[text()='My Account']");
	private static final By changePasswordLink = By.cssSelector("#column-right a:nth-of-type(3)");
	private static final By successBanner = By.cssSelector("div.alert-success");
	private static final By orderHistoryLink = By.cssSelector("div.list-group a:nth-of-type(6)");
	private static final By editAccountLink = By.xpath("//a[text()='Edit Account']");
	private static final By registerForAnAffiliateAccount = By.cssSelector("a[href$='affiliate/add']");
	private static final By affiliateAccountCreationSuccessText = By.cssSelector("div.alert");
	private static final By componentsHoverButton = By.cssSelector("li.dropdown:nth-of-type(3) a.dropdown-toggle");
	public static final By monitorsLink = By.cssSelector(" ul li.dropdown:nth-of-type(3) li:nth-of-type(2) a");
	private static final By cameraLink = By.cssSelector("div.navbar-collapse ul>li:nth-of-type(7) a");
	private static final By addToReturnLink = By.xpath("(//a[text()='Returns']) [2]");
	private static final By clickOnSpecialsLink = By.xpath("//a[text()=\"Specials\"]");
	private static final By passwordChangesSuccessBanner = By.cssSelector("div.alert-success");
	private static final By desktop = By.cssSelector("ul.nav>li:first-of-type>a");
	private static final By showAllDesktop = By.xpath("//a[text()='Show All Desktops']");

	public ProductReturnsPage clickaddToReturnLink() {
		((ProxyDriver) wd).click(addToReturnLink);
		return new ProductReturnsPage(wd, true);
	}

	public ContactPage clickPhoneLink() {
		((ProxyDriver) wd).click(phonelink);
		return new ContactPage(wd, true);
	}

	private void clickDesktop() {
		((ProxyDriver) wd).click(desktop);
	}

	public DesktopPage showAllDesktop() {
		clickDesktop();
		((ProxyDriver) wd).click(showAllDesktop);
		return new DesktopPage(wd, true);
	}

	public PurchaseGiftCertificatePage clickGiftCertificateLink() {
		((ProxyDriver) wd).click(GiftCertificatesLink);
		return new PurchaseGiftCertificatePage(wd, true);

	}

	public String getMyAccountText() {
		return ((ProxyDriver) wd).getText(myAccountText, 10);
	}

	public ChangePasswordPage clickChangePassword() {
		((ProxyDriver) wd).click(changePasswordLink);
		return new ChangePasswordPage(wd, true);
	}

	public String getPasswordChangeSuccessMessage() {
		return ((ProxyDriver) wd).getText(passwordChangesSuccessBanner, 10);
	}

	public String getSuccessMessageText() {
		return ((ProxyDriver) wd).getText(successBanner, 10);

	}

	public OrderHistoryPage clickOrderHistoryLink() {
		((ProxyDriver) wd).click(orderHistoryLink);
		return new OrderHistoryPage(wd, true);

	}

	public void hoverOnComponents() {
		((ProxyDriver) wd).mouseHover(componentsHoverButton);
	}

	public MonitorsPage clickMonitors() {
		((ProxyDriver) wd).click(monitorsLink);
		return new MonitorsPage(wd, true);

	}

	public MyAccountInformationPage clickEditAccountLink() {
		((ProxyDriver) wd).click(editAccountLink);
		return new MyAccountInformationPage(wd, true);
	}

	public YourAffiliateInformationPage clickRegisterForAnAffiliateAccount() {
		((ProxyDriver) wd).click(registerForAnAffiliateAccount);
		return new YourAffiliateInformationPage(wd, true);
	}

	public String getAffiliateAccountCreationSuccessText() {
		return ((ProxyDriver) wd).getText(affiliateAccountCreationSuccessText, 10);

	}

	public CamerasPage clickCameraLink() {
		((ProxyDriver) wd).click(cameraLink);
		return new CamerasPage(wd, true);
	}

	public SpecialsPage clickOnSpeacialInExtras() {
		((ProxyDriver) wd).click(clickOnSpecialsLink);
		return new SpecialsPage(wd, true);

	}

	@Override
	protected void isLoaded() {

		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

	@Override
	public MyAccountPage get() {
		return (MyAccountPage) super.get();
	}

}
