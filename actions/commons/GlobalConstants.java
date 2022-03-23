package commons;

import java.io.File;

public class GlobalConstants {
	// hằng số dùng chung cho tất cả các class của project
	public static final String PORTAL_DEV_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_DEV_URL = "https://admin-demo.nopcommerce.com/";

	public static final String PORTAL_TESTING_URL = "https://admin-demo.nopcommerce.com/";
	public static final String ADMIN_TESTING_URL = "https://admin-demo.nopcommerce.com/";

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_AND_DROP_HTML5 = PROJECT_PATH + File.separator + "autoITScripts";
	public static final String REPORTNG_IMAGESs = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;

	public static final String DB_DEV_URL = "32.18.252.185:9860";
	public static final String DB_DEV_USER = "automationfc";
	public static final String DB_DEV_PASS = "P@sswor1d11";

	public static final String DB_TEST_URL = "32.18.252.185:9860";
	public static final String DB_TEST_USER = "automationfc";
	public static final String DB_TEST_PASS = "P@sswor1d11";

	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 10;
	public static final long RETRY_TEST_FAIL = 3;
	public static final String JAVA_VERSION = System.getProperty("java.version");

}
