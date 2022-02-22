package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_03_Page_Object extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	BasePage basePage;
	String firstname = "Hanh";
	String lastname = "Dao Thi";
	String email = "afc" + getRandomemailNumber() + "@gmail.com";
	String dayofbirth = "6";
	String monthofbirth = "October";
	String yearofbirth = "1991";
	String companyname = "AFC School";
	String password = "12345678@Abc";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		waitForAllElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		waitForAllElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"),
				"First name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"Password is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//input[@id='gender-female']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firstname);
		sendkeyToElement(driver, "//input[@id='LastName']", lastname);
		selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthDay']", dayofbirth);
		selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthMonth']", monthofbirth);
		selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthYear']", yearofbirth);
		sendkeyToElement(driver, "//input[@id='Email']", "123");
		sendkeyToElement(driver, "//input[@id='Company']", companyname);
		sendkeyToElement(driver, "//input[@id='Password']", password);
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//input[@id='gender-female']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firstname);
		sendkeyToElement(driver, "//input[@id='LastName']", lastname);
		selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthDay']", dayofbirth);
		selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthMonth']", monthofbirth);
		selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthYear']", yearofbirth);
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Company']", companyname);
		sendkeyToElement(driver, "//input[@id='Password']", password);
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertTrue(basePage.getWebElement(driver, "//div[text()='Your registration completed']").isDisplayed());

	}

	@Test
	public void TC_04_Register_Already_Exit_Email() {
		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//input[@id='gender-female']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firstname);
		sendkeyToElement(driver, "//input[@id='LastName']", lastname);
		selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthDay']", dayofbirth);
		selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthMonth']", monthofbirth);
		selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthYear']", yearofbirth);
		sendkeyToElement(driver, "//input[@id='Email']", "hanhdao@gmail.com");
		sendkeyToElement(driver, "//input[@id='Company']", companyname);
		sendkeyToElement(driver, "//input[@id='Password']", password);
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertTrue(
				basePage.getWebElement(driver, "//li[text()='The specified email already exists']").isDisplayed());
	}

	@Test
	public void TC_05_Register_Pass_Fewer6Character() {
		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//input[@id='gender-female']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firstname);
		sendkeyToElement(driver, "//input[@id='LastName']", lastname);
		selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthDay']", dayofbirth);
		selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthMonth']", monthofbirth);
		selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthYear']", yearofbirth);
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Company']", companyname);
		sendkeyToElement(driver, "//input[@id='Password']", "12345");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertTrue(
				basePage.getWebElement(driver, "//p[text()='Password must meet the following rules: ']").isDisplayed());
		Assert.assertTrue(
				basePage.getWebElement(driver, "//li[text()='must have at least 6 characters']").isDisplayed());
	}

	@Test
	public void TC_06_Register_FailConfirmPassword() {
		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//input[@id='gender-female']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firstname);
		sendkeyToElement(driver, "//input[@id='LastName']", lastname);
		selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthDay']", dayofbirth);
		selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthMonth']", monthofbirth);
		selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthYear']", yearofbirth);
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Company']", companyname);
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"The password and confirmation password do not match.");
	}

	public int getRandomemailNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
