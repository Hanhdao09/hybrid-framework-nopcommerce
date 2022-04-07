package pageUIs.nopcommerce.user;

public class UserBasePageUI {
	public static final String ADDRESS_LINK = "xpath=//a[text()='Addresses']";
	public static final String CUSTOMERINFO_LINK = "xpath=//a[text()='Customer info']";
	public static final String MYPRODUCTREVIEW_LINK = "xpath=//a[text()='My product reviews']";
	public static final String REWARDPOINT_LINK = "xpath=//a[text()='Reward points']";
	public static final String DYNAMIC_MYACCOUNT_PAGE = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String LOGOUT_LINK_AT_USER_PAGE = "css=a.ico-logout";

	public static final String DYNAMIC_TEXBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_HEADER_LINK_BY_TEXT = "xpath=//a[text()='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input[@type='radio']";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(), '%s')]/following-sibling::input[@type='checkbox']";
}
