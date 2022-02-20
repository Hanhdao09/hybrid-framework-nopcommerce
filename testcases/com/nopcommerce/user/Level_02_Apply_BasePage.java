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

public class Level_02_Apply_BasePage {
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
		basePage = new BasePage();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		basePage.waitForAllElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.waitForAllElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

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
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//input[@id='gender-female']");
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", firstname);
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", lastname);
		basePage.selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthDay']", dayofbirth);
		basePage.selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthMonth']", monthofbirth);
		basePage.selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthYear']", yearofbirth);
		basePage.sendkeyToElement(driver, "//input[@id='Email']", "123");
		basePage.sendkeyToElement(driver, "//input[@id='Company']", companyname);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", password);
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);
		basePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}

	@Test
	public void TC_03_Register_Already_Exit_Email() {
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//input[@id='gender-female']");
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", firstname);
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", lastname);
		basePage.selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthDay']", dayofbirth);
		basePage.selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthMonth']", monthofbirth);
		basePage.selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthYear']", yearofbirth);
		basePage.sendkeyToElement(driver, "//input[@id='Email']", "hanhdao@gmail.com");
		basePage.sendkeyToElement(driver, "//input[@id='Company']", companyname);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", password);
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);
		basePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertTrue(
				basePage.getWebElement(driver, "//li[text()='The specified email already exists']").isDisplayed());
	}

	@Test
	public void TC_04_Register_Pass_Fewer6Character() {
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//input[@id='gender-female']");
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", firstname);
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", lastname);
		basePage.selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthDay']", dayofbirth);
		basePage.selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthMonth']", monthofbirth);
		basePage.selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthYear']", yearofbirth);
		basePage.sendkeyToElement(driver, "//input[@id='Email']", email);
		basePage.sendkeyToElement(driver, "//input[@id='Company']", companyname);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "12345");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");
		basePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertTrue(
				basePage.getWebElement(driver, "//p[text()='Password must meet the following rules: ']").isDisplayed());
		Assert.assertTrue(
				basePage.getWebElement(driver, "//li[text()='must have at least 6 characters']").isDisplayed());
	}

	@Test
	public void TC_05_Register_FailConfirmPassword() {
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//input[@id='gender-female']");
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", firstname);
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", lastname);
		basePage.selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthDay']", dayofbirth);
		basePage.selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthMonth']", monthofbirth);
		basePage.selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthYear']", yearofbirth);
		basePage.sendkeyToElement(driver, "//input[@id='Email']", email);
		basePage.sendkeyToElement(driver, "//input[@id='Company']", companyname);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");
		basePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"The password and confirmation password do not match.");
	}

	@Test
	public void TC_06_Register_With_ValidInformation() {
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//input[@id='gender-female']");
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", firstname);
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", lastname);
		basePage.selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthDay']", dayofbirth);
		basePage.selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthMonth']", monthofbirth);
		basePage.selectItemInDefauldDropdown(driver, "//select[@name='DateOfBirthYear']", yearofbirth);
		basePage.sendkeyToElement(driver, "//input[@id='Email']", email);
		basePage.sendkeyToElement(driver, "//input[@id='Company']", companyname);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", password);
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);
		basePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertTrue(basePage.getWebElement(driver, "//div[text()='Your registration completed']").isDisplayed());

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
