package com.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest_Facebook;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Topic_13_Verify_Undisplayed_Element extends BaseTest_Facebook {
	WebDriver driver;
	LoginPageObject loginPage;
	String emailAddress;

	@Parameters({ "browser", "url" })
	@BeforeClass()
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		emailAddress = "hanhdao" + getRandomNumber() + "@gmail.com";
	}

	@Test
	public void TC_01_Element_isDisplayed_InDOM_OrNotInDOM() {
		loginPage.clickToCreateNewAccountLink();
		loginPage.senkeyToEmailAddressTextbox(emailAddress);
		verifyTrue(loginPage.isConfirmEmailAddressDisplayed());
	}

	@Test
	public void TC_02_Element_isUnDisplayed_InDOM() {
		loginPage.senkeyToEmailAddressTextbox("");
		verifyTrue(loginPage.isConfirmEmailAddressUnDisplayed());
	}

	@Test
	public void TC_03_Element_isUnDisplayed_NotInDOM() {
		loginPage.closeSinUpForm();
		verifyTrue(loginPage.isConfirmEmailAddressUnDisplayed());
	}

	@AfterClass()
	public void afterClass() {
		driver.quit();
	}

}
