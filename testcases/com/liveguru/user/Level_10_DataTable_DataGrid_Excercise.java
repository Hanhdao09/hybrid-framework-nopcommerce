package com.liveguru.user;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest_Liveguru;
import commons.GlobalConstants_liveguru;
import pageObject.liveguru.user.MydashboardPageObject;
import pageObject.liveguru.user.PageGeneratorManager;
import pageObject.liveguru.user.UserHomePageObject;
import pageObject.liveguru.user.UserLoginPageObject;
import pageObject.liveguru.user.UserRegisterPageObject;
import pageObjects.liveguru.admin.AdminHomePageObject;
import pageObjects.liveguru.admin.AdminLoginPageObject;

public class Level_10_DataTable_DataGrid_Excercise extends BaseTest_Liveguru {
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	UserLoginPageObject userLoginPage;
	MydashboardPageObject mydashboardPage;
	AdminLoginPageObject adminLoginPage;
	AdminHomePageObject adminHomePage;
	String firstName, lastName, email, password, Adminuser, Adminpassword;

	@Parameters("browser")
	@BeforeClass
	public void BeforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getHomePage(driver);
		firstName = "Hanh";
		lastName = "Dao";
		email = "hanhdao" + getRandomNumber() + "@gmail.com";
		password = "12345678@Abc";

		Adminuser = "user01";
		Adminpassword = "guru99com";
	}

	@Test
	public void TC_01_Create_An_User() {
		userLoginPage = userHomePage.clickToMyAccountLink();
		userRegisterPage = userLoginPage.clickToCreateAccountButton();
		userRegisterPage.inputToFirstnameTextbox(firstName);
		userRegisterPage.inputToLastnameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(email);
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		mydashboardPage = userRegisterPage.clickToRegisterButton();
		Assert.assertTrue(mydashboardPage.isSuccesfullMessageDisplayed());
		userHomePage = mydashboardPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_Login_To_Admin_Page() {
		userHomePage.openPageUrl(driver, GlobalConstants_liveguru.ADMIN_DEV_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminLoginPage.inputToUsernameTextbox(Adminuser);
		adminLoginPage.inputToPasswordTextbox(Adminpassword);
		adminHomePage = adminLoginPage.clickToLoginButton();
		adminHomePage.sleepinSecond(3);
		adminHomePage.closePopUp();
	}

	@Test
	public void TC_03_Search_Customer_At_Admin_Page() {
		adminHomePage.enterToHeaderTextboxByLabel("Name", firstName);
		adminHomePage.sleepinSecond(3);
		adminHomePage.enterToHeaderTextboxByLabel("Email", email);
		adminHomePage.sleepinSecond(3);
		Assert.assertTrue(adminHomePage.isCustomerInfoDisplayed(email));
	}

	@Test
	public void TC_04_Delete_Customer() {
		adminHomePage.selectRowByNameValue(email);
		adminHomePage.selectActionDropdown("Delete");
		adminHomePage.clickToSubmitButton();
		adminHomePage.acceptAlert(driver);
	}

	@Test
	public void TC_05_Logout_At_Admin_Page() {
		adminLoginPage = adminHomePage.clickToLogoutLinkAtAdminPage();
	}

	@Test
	public void TC_06_Login_At_User_Page() {
		adminLoginPage.openPageUrl(driver, GlobalConstants_liveguru.PORTAL_DEV_URL);
		userHomePage = PageGeneratorManager.getHomePage(driver);
		userLoginPage = userHomePage.clickToMyAccountLink();
		userLoginPage.inputToEmailTextbox(email);
		userLoginPage.inputToPasswordTextbox(password);
		userLoginPage.clickToLoginButton();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
