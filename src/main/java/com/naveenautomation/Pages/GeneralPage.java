package com.naveenautomation.Pages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class GeneralPage extends LoadableComponent<GeneralPage> {

	protected WebDriver wd;
	private static final int DEFAULT_TIME_FOR_PAGE_LOAD = 60;

	public GeneralPage(WebDriver wd, boolean waitForPageToLoad) {
		this.wd = wd;
		if (waitForPageToLoad) {
			this.waitForDocumentCompleteState();
		}
	}

	@Override
	protected void load() {
		String pageURL = getPageUrl();

		wd.get(pageURL);

	}

	protected abstract String getPageUrl();

	@Override
	protected abstract void isLoaded();

	public boolean waitForDocumentCompleteState() {
		return new WebDriverWait(wd, DEFAULT_TIME_FOR_PAGE_LOAD).until((ExpectedCondition<Boolean>) p -> {
			while (true) {
				String documentState = getDocumentReadyState();
				if (documentState.equals("complete")) {
					return true;
				}
			}
		});
	}

	public String getDocumentReadyState() {
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		return jse.executeScript("return document.readyState").toString();
	}

	@Override
	public GeneralPage get() {
		return super.get();
	}

	protected boolean urlContains(String url) {

		try {
			String pageUrl = getPageUrl();
			URL pageUrlObject = new URL(pageUrl);
			URL urlObject = new URL(url);
			String pageUrlHost = pageUrlObject.getHost();
			String urlHost = urlObject.getHost();
			if (pageUrlHost.equalsIgnoreCase(urlHost)) {
				String pageUrlExclHost = pageUrl.substring(pageUrl.indexOf(pageUrlHost) + pageUrlHost.length());
				String urlExclHost = url.substring(url.indexOf(urlHost) + urlHost.length());
				return urlExclHost.toLowerCase().contains(pageUrlExclHost.toLowerCase());
			}
		} catch (MalformedURLException e) {

		}
		return false;
	}

}
