package pageUIs.liveguru.admin;

public class AdminHomePageUI {
	public static final String POPUP = "xpath=//div[@id='message-popup-window']//span[text()='close']";

	public static final String COLUMN_INDEX_BY_NAME = "xpath=//span[text()='%s']/ancestor::th/preceding-sibling::th";
	public static final String SELECT_ROW_BY_NAMEVALUE = "xpath=//tbody//td[contains(text(),'%s')]/preceding-sibling::td/input[@type='checkbox']";
	public static final String SEARCH_TEXTBOX_BY_COLUMN_INDEX = "xpath=//thead/tr[@class='filter']//th[%s]//input[@type='text']";

	public static final String NAME_SEARCH_RESULT = "xpath=//td[contains(text(),'%s')]";

	public static final String ACTION_DROPDOWN = "xpath=//select[@id='customerGrid_massaction-select']";

	public static final String SUBMIT_BUTTON = "xpath=//button[@title='Submit']";

	public static final String LOGOUTLINK = "xpath=//a[text()='Log Out']";
}
