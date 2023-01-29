package com.naveenautomation.Listeners;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Utils.Log;

public class WebdriverEvents extends TestBase implements WebDriverEventListener {

	Logger log=Log.getLoggerData(this.getClass().getName());
	@Override
	public void beforeAlertAccept(WebDriver driver) {
		log.info("About to accept an alert");
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		log.info("Alert has been accepted");
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		log.info("Alert has been dismissed");
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		log.info("navigating to" + url);
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		log.info("Navigated to" + url);
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		log.info("Page Refreshed");
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		log.info("Finding element" + by );
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		log.info("Elelement Found" + by );
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		log.info("clicking on" + element );
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		log.info("clicked on" + element );
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		log.info("Switching to window text from " +windowName);
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		log.info("Switched to window text from " +windowName);
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		log.info("getting text from " +element);
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		log.info("Got text from " +element);
		
	}

}
