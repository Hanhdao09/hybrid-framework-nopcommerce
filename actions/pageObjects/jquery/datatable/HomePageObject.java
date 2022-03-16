package pageObjects.jquery.datatable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.datatable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String valueSearch) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, valueSearch, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActive(String pageNumber) {
		waitForAllElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size=" + totalPage);

		List<String> allRowValuesAllPage = new ArrayList<String>();

		// Duyệt qua tất cả các pageNumber
		for (int index = 1; index < totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
			sleepinSecond(1);

			// Get text của all row mỗi page đưa vào ArrayList
			List<WebElement> allRowEachPage = getListWebElement(driver, HomePageUI.ALLROW_COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowEachPage) {
				allRowValuesAllPage.add(eachRow.getText());
			}
		}
		// in tất cả giá trị của row ra ở tất cả các Page
		for (String value : allRowValuesAllPage) {
			System.out.println(value);
		}
		return allRowValuesAllPage;
	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber,
				String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAtRowNuber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(columnIndex));
		selectItemInDefauldDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber,
				String.valueOf(columnIndex));
	}

	public void clickToLoadButton() {
		waitForElementClickable(driver, HomePageUI.BUTON_LOAD);
		clickToElement(driver, HomePageUI.BUTON_LOAD);
	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(columnIndex));
	}

	public void unCheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(columnIndex));
		uncheckToDefaultCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(columnIndex));

	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver, HomePageUI.ICON_BY_ROW_INDEX, rowNumber, iconName);
		clickToElement(driver, HomePageUI.ICON_BY_ROW_INDEX, rowNumber, iconName);
	}

}
