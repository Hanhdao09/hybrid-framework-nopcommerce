package pageObjects.liveguru.admin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.liveguru.user.PageGeneratorManager;
import pageUIs.liveguru.admin.AdminHomePageUI;

public class AdminHomePageObject extends BasePage {
	WebDriver driver;

	public AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closePopUp() {
		waitForElementVisible(driver, AdminHomePageUI.POPUP);
		clickToElement(driver, AdminHomePageUI.POPUP);
	}

	public void enterToHeaderTextboxByLabel(String columnName, String value) {
		int columnIndex = getElementSize(driver, AdminHomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, AdminHomePageUI.SEARCH_TEXTBOX_BY_COLUMN_INDEX, String.valueOf(columnIndex));
		sendkeyToElement(driver, AdminHomePageUI.SEARCH_TEXTBOX_BY_COLUMN_INDEX, value, String.valueOf(columnIndex));
		pressKeyToElement(driver, AdminHomePageUI.SEARCH_TEXTBOX_BY_COLUMN_INDEX, Keys.ENTER,
				String.valueOf(columnIndex));
	}

	public boolean isCustomerInfoDisplayed(String email) {
		waitForElementVisible(driver, AdminHomePageUI.NAME_SEARCH_RESULT, email);
		return isElementDisplayed(driver, AdminHomePageUI.NAME_SEARCH_RESULT, email);
	}

	public void selectRowByNameValue(String email) {
		waitForElementClickable(driver, AdminHomePageUI.SELECT_ROW_BY_NAMEVALUE, email);
		checkToDefaultCheckboxOrRadio(driver, AdminHomePageUI.SELECT_ROW_BY_NAMEVALUE, email);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, AdminHomePageUI.SUBMIT_BUTTON);
		clickToElement(driver, AdminHomePageUI.SUBMIT_BUTTON);
	}

	public void selectActionDropdown(String action) {
		waitForElementClickable(driver, AdminHomePageUI.ACTION_DROPDOWN);
		selectItemInDefauldDropdown(driver, AdminHomePageUI.ACTION_DROPDOWN, action);
	}

	public AdminLoginPageObject clickToLogoutLinkAtAdminPage() {
		waitForElementClickable(driver, AdminHomePageUI.LOGOUTLINK);
		clickToElement(driver, AdminHomePageUI.LOGOUTLINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

}
