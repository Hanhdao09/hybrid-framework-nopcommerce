package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest_Nopcommerce;
import pageObjects.nopcommerce.AddressPageObject;
import pageObjects.nopcommerce.CustomerInfoPageObject;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.MyProductReviewPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;
import pageObjects.nopcommerce.RewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest_Nopcommerce {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerInfoPageObject customerInfoPage;
	private AddressPageObject addressPage;
	private MyProductReviewPageObject myproductReviewPage;
	private RewardPointPageObject rewardPointPage;

	private String firstName, lastName, email, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		firstName = "Hanh";
		lastName = "Dao";
		email = "afc" + getRandomNumber() + "@gmail.net";
		password = "12345678@Abc";
	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.clickToLoginLink();
		loginPage.InputToEmailTextbox(email);
		loginPage.InputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_CustomerInfo() {
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPage.isCustomerInfoDisplayed());
	}

	@Test
	public void User_04_Switch_Page() {
		// CustomerInfo -> MyAddress
		addressPage = customerInfoPage.openAddressLinkMyAccount(driver);
		// MyAddress -> My Product Review
		myproductReviewPage = addressPage.openMyproducReviewLinkMyAccount(driver);
		// My Product Review -> Reward Point
		rewardPointPage = myproductReviewPage.openRewardPointLinkMyAccount(driver);
		// Reward Point -> MyAddress
		addressPage = rewardPointPage.openAddressLinkMyAccount(driver);
		// MyAddress -> Reward Point
		rewardPointPage = addressPage.openRewardPointLinkMyAccount(driver);
		// Reward Point -> My Product Review
		myproductReviewPage = rewardPointPage.openMyproducReviewLinkMyAccount(driver);
	}

	@Test
	public void User_05_Switch_Role() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
