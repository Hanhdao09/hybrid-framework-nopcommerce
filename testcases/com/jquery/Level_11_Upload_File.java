package com.jquery;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.uploadfile.HomePageObject;
import pageObjects.jquery.uploadfile.PageGeneratorManager;

public class Level_11_Upload_File extends BaseTest {
	HomePageObject homePage;
	String hueName = "Hue.jpg";
	String dalatName = "Dalat.jpg";
	String sapaName = "Sapa.jpg";
	String[] mutilpleFileNames = { hueName, dalatName, sapaName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomepage(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, hueName);
		homePage.uploadMultipleFiles(driver, dalatName);
		homePage.uploadMultipleFiles(driver, sapaName);

		Assert.assertTrue(homePage.isFileNameDisplayed(hueName));
		Assert.assertTrue(homePage.isFileNameDisplayed(dalatName));
		Assert.assertTrue(homePage.isFileNameDisplayed(sapaName));

		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLoadedSuccess(hueName));
		Assert.assertTrue(homePage.isFileLoadedSuccess(dalatName));
		Assert.assertTrue(homePage.isFileLoadedSuccess(sapaName));

		Assert.assertTrue(homePage.isPictureLoadedSuccess(hueName));
		Assert.assertTrue(homePage.isPictureLoadedSuccess(sapaName));
		Assert.assertTrue(homePage.isPictureLoadedSuccess(dalatName));
	}

	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);
		homePage.uploadMultipleFiles(driver, mutilpleFileNames);
		homePage.sleepinSecond(3);
		Assert.assertTrue(homePage.isFileNameDisplayed(hueName));
		Assert.assertTrue(homePage.isFileNameDisplayed(dalatName));
		Assert.assertTrue(homePage.isFileNameDisplayed(sapaName));

		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLoadedSuccess(hueName));
		Assert.assertTrue(homePage.isFileLoadedSuccess(dalatName));
		Assert.assertTrue(homePage.isFileLoadedSuccess(sapaName));

		Assert.assertTrue(homePage.isPictureLoadedSuccess(hueName));
		Assert.assertTrue(homePage.isPictureLoadedSuccess(sapaName));
		Assert.assertTrue(homePage.isPictureLoadedSuccess(dalatName));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
