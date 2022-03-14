package com.jquery.datatable;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest_Nopcommerce;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest_Nopcommerce {
	HomePageObject homePage;
	List<String> actualallValueRowAtAllPage;
	List<String> expectedallValueRowAtAllPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepinSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("10"));
		homePage.openPagingByPageNumber("20");
		homePage.sleepinSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("20"));
		homePage.openPagingByPageNumber("7");
		homePage.sleepinSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("7"));
		homePage.openPagingByPageNumber("18");
		homePage.sleepinSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("18"));
	}

	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);
		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxByLabel("Females", "338282");
		homePage.enterToHeaderTextboxByLabel("Males", "349238");
		homePage.enterToHeaderTextboxByLabel("Total", "687522");
		homePage.sleepinSecond(3);
		homePage.enterToHeaderTextboxByLabel("Country", "Angola");
		homePage.enterToHeaderTextboxByLabel("Females", "276880");
		homePage.enterToHeaderTextboxByLabel("Males", "276472");
		homePage.enterToHeaderTextboxByLabel("Total", "553353");
		homePage.sleepinSecond(3);
	}

	@Test
	public void Table_03_Enter_To_Header() {
		// Hàm đọc dữ liệu của file country.txt=> Sau đó lưu vào 1 List<String>=> CHính
		// là expectedValue
		actualallValueRowAtAllPage = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualallValueRowAtAllPage, expectedallValueRowAtAllPage);
	}

	@Test
	public void Table_04() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
