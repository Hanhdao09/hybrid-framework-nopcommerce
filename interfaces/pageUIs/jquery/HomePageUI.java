package pageUIs.jquery;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text'and text()='%s']/parent::div/following-sibling::input";
	public static final String PAGINATION_PAGE_ACTIVE_BY_NUMBER = "xpath//li[@class='qgrd-pagination-page']/a[contains(@class,'active') and text()='%s']";
	public static final String TOTAL_PAGINATION = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page']";
	public static final String PAGINATION_PAGE_BY_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALLROW_EACH_PAGE = "xpath=//tbody/tr";
	public static final String ALLROW_COUNTRY_EACH_PAGE = "xpath=//tbody/tr/td[@data-key='country']";
}
