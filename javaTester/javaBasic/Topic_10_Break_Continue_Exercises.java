package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_10_Break_Continue_Exercises {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);

	@Test
	public void TC_01() {
		String[] browserNames = { "chrome", "firefox", "edge", "IE", "safari", "opera" };
		for (String browserName : browserNames) {
			if (browserName.equals("IE")) {
				continue;
			}
			System.out.println(browserName);
		}
	}

	@Test
	public void TC_02() {
		System.out.println("Enter the month: ");
		int month = scanner.nextInt();
		switch (month) {
		case 1:
			System.out.println("JAN");
			break;
		case 2:
			System.out.println("FEB");
			break;
		case 3:
			System.out.println("MAR");
			break;
		case 4:
			System.out.println("APR");
			break;
		case 5:
			System.out.println("MAY");
			break;
		case 6:
			System.out.println("JUN");
			break;
		case 7:
			System.out.println("JUL");
			break;
		case 8:
			System.out.println("AUG");
			break;
		case 9:
			System.out.println("SEP");
			break;
		case 10:
			System.out.println("OCT");
			break;
		case 11:
			System.out.println("NOV");
			break;
		case 12:
			System.out.println("DEC");
			break;
		}
	}
}
