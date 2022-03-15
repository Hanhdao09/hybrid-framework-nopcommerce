package pageUIs.jquery;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text'and text()='%s']/parent::div/following-sibling::input";
	public static final String PAGINATION_PAGE_ACTIVE_BY_NUMBER = "xpath//li[@class='qgrd-pagination-page']/a[contains(@class,'active') and text()='%s']";
	public static final String TOTAL_PAGINATION = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page']";
	public static final String PAGINATION_PAGE_BY_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALLROW_EACH_PAGE = "xpath=//tbody/tr";
	public static final String ALLROW_COUNTRY_EACH_PAGE = "xpath=//tbody/tr/td[@data-key='country']";

	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/td[text()='%s']/preceding-sibling::td";
	public static final String ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/select";
	public static final String BUTON_LOAD = "id=btnLoad";
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input[@type='checkbox']";

	public static final String ICON_BY_ROW_INDEX = "xpath=//tbody/tr[%s]//button[@title='%s']";
}
