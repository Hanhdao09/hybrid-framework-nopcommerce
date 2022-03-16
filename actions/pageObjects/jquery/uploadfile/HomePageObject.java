package pageObjects.jquery.uploadfile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.uploadfile.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileNameDisplayed(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_DISPLAYED, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_DISPLAYED, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> allStartButtons = getListWebElement(driver, HomePageUI.ALL_START_BUTTON);
		for (WebElement startButton : allStartButtons) {
			startButton.click();
			sleepinSecond(2);
		}
	}

	public boolean isFileLoadedSuccess(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_LOADED, fileName);
	}

	public boolean isPictureLoadedSuccess(String fileName) {
		waitForElementVisible(driver, HomePageUI.PICTURE_LOADED, fileName);
		return isImageLoaded(driver, HomePageUI.PICTURE_LOADED, fileName);
	}
}
