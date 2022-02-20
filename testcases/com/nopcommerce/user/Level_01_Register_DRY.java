package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Register_DRY {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstname = "Hanh";
	String lastname = "Dao Thi";
	String email = "afc" + getRandomemailNumber() + "@gmail.com";
	String dayofbirth = "6";
	String monthofbirth = "January";
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
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='First name is required.']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Last name is required.']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Email is required.']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Password is required.']")).isDisplayed());
		Assert.assertTrue(
				driver.findElement(By.xpath("//span[@id='ConfirmPassword-error' and text()='Password is required.']"))
						.isDisplayed());
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastname);
		Select daydropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		daydropdown.selectByValue(dayofbirth);
		Select monthdropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		monthdropdown.selectByValue(monthofbirth);
		Select yeardropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		yeardropdown.selectByValue(yearofbirth);
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(companyname);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")), "Wrong email");
	}

	@Test
	public void TC_03_Register_Already_Exit_Email() {
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastname);
		Select daydropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		daydropdown.selectByValue(dayofbirth);
		Select monthdropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		monthdropdown.selectByValue(monthofbirth);
		Select yeardropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		yeardropdown.selectByValue(yearofbirth);
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("hanhdao@gmail.com");
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(companyname);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//li[text()='The specified email already exists']")).isDisplayed());
	}

	@Test
	public void TC_04_Register_Pass_Fewer6Character() {
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastname);
		Select daydropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		daydropdown.selectByValue(dayofbirth);
		Select monthdropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		monthdropdown.selectByValue(monthofbirth);
		Select yeardropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		yeardropdown.selectByValue(yearofbirth);
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(companyname);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//li[text()='The specified email already exists']")).isDisplayed());
	}

	@Test
	public void TC_05_Register_FailConfirmPassword() {
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastname);
		Select daydropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		daydropdown.selectByValue(dayofbirth);
		Select monthdropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		monthdropdown.selectByValue(monthofbirth);
		Select yeardropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		yeardropdown.selectByValue(yearofbirth);
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(companyname);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(),
				"The password and confirmation password do not match.");
	}

	@Test
	public void TC_06_Register_With_ValidInformation() {
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastname);
		Select daydropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		daydropdown.selectByValue(dayofbirth);
		Select monthdropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		monthdropdown.selectByValue(monthofbirth);
		Select yeardropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		yeardropdown.selectByValue(yearofbirth);
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(companyname);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Your registration completed']")).isDisplayed());
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
