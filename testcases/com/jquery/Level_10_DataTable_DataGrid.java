package com.jquery;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.datatable.HomePageObject;
import pageObjects.jquery.datatable.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
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

	public void Table_03_Enter_To_Header() {
		// Hàm đọc dữ liệu của file country.txt=> Sau đó lưu vào 1 List<String>=> CHính
		// là expectedValue
		actualallValueRowAtAllPage = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualallValueRowAtAllPage, expectedallValueRowAtAllPage);
	}

	@Test
	public void Table_04_Action_To_Textbox_At_Any_Row() {
		// click to Load Button
		homePage.clickToLoadButton();
		homePage.sleepinSecond(2);
		// sendkey
		homePage.enterToTextboxByColumnNameAtRowNumber("Album", "2", "Dearest");
		homePage.enterToTextboxByColumnNameAtRowNumber("Artist", "4", "Rihana");
		homePage.enterToTextboxByColumnNameAtRowNumber("Year", "3", "2012");
		homePage.enterToTextboxByColumnNameAtRowNumber("Price", "1", "150");

		// dropdown list
		homePage.selectDropdownByColumnNameAtRowNuber("Origin", "5", "Japan");
		homePage.sleepinSecond(4);
		homePage.selectDropdownByColumnNameAtRowNuber("Origin", "1", "Hong Kong");
		homePage.sleepinSecond(4);
		homePage.selectDropdownByColumnNameAtRowNuber("Origin", "1", "Korea");
		homePage.sleepinSecond(4);
		// check to checkbox
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "3");
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "5");

		homePage.unCheckToCheckboxByColumnNameAtRowNumber("With Poster?", "1");
		homePage.unCheckToCheckboxByColumnNameAtRowNumber("With Poster?", "2");
		homePage.unCheckToCheckboxByColumnNameAtRowNumber("With Poster?", "4");
		// Insert Row Above
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.clickToIconByRowNumber("3", "Move Up");
		homePage.clickToIconByRowNumber("4", "Move Down");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
