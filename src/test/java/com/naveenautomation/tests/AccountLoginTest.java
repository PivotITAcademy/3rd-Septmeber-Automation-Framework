package com.naveenautomation.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Utils.ExcelUtils;

public class AccountLoginTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}

	@Ignore
	@Test(dataProvider = "LoginDataProvider")
	public void verifyAlertBannerForInvalidLoginCredentials(String userName, String password) {
		AccountLoginPage accountLoginPage = new AccountLoginPage(driver,true).get();
		accountLoginPage.login(userName, password);
		Assert.assertEquals(accountLoginPage.getTextFromAlertBanner(),
				"Warning: No match for E-Mail Address and/or Password.", "Alert text doesn't match");
	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] provideLoginData() throws IOException {
		String filePath = "./TestData\\LoginDetails.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet1", rowCount);
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet1", i, j);
			}
		}
		return loginData;

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
