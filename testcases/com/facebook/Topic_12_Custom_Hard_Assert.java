package com.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest_Facebook;

public class Topic_12_Custom_Hard_Assert extends BaseTest_Facebook {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@Parameters({ "browser", "url" })
	@BeforeClass()
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		// Login Page Url matching
		String loginPageUrl = driver.getCurrentUrl();
		System.out.println("Assert01");
		verifyEquals(loginPageUrl, "https://www.facebook.com/");

		// Login Page title
		String loginPageTitle = driver.getTitle();
		System.out.println("Assert02");
		verifyEquals(loginPageTitle, "Facebook - Đăng nhập hoặc đăng ký");

		// Login form displayed
		System.out.println("Assert03");
		verifyTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}