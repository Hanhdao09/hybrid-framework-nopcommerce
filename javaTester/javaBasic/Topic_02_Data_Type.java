package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	static int number;
	String addressHome = "Ho Chi Minh";
	/*------------------------------------------------*/
	//Data Type
	
	//1. Primitive type: Kiểu dữ liệu nguyên thuỷ
	//Kiểu số Nguyên
	static byte bNumber;
	static short sNumber;
	static int iNumber;
	static long lNumber;
	//Kiểu số thực (Có phần thập phân)
	static float fNumber;
	static double dNumber;
	//Kiểu ký tự
	static char cChar;
	//Kiểu đúng/sai
	static boolean bStatus;
	
	//2. Reference type: Kiểu dữ liệu tham chiếu
	
	//Array
	String[] studentAddress = {"Ha Noi", "Ho Chi Minh", "Da Nang"};
	Integer[] studenNumber = {15, 20, 50};
	
	//String
	String address = "Ho Chi Minh";
	
	//Class
	Topic_02_Data_Type topic;
	
	//Interface
	WebDriver driver;
	
	//Object
	Object object;
	
	//Collection
	//List, Set, Queue, Map
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	Set<String> allWindows = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>();
	
	/*Sự khác nhau giữa kiểu dữ liệu nguyên thuỷ và kiểu dữ liệu tham chiếu
	 * - 1. Kiểu dữ liệu nguyên thuỷ thì ko có function nào đi kèm
	 * - 2. Khác nhau ở cách thức lưu trữ dữ liệu*/

	public static void main(String[] args) {
		int studentNumber = 1;
		byte bNumber = 50;
		short sNumber = 500;
		int iNumber = 1000;
		long lNumber = 10000;
		//Kiểu số thực (Có phần thập phân)
		float fNumber = 15.98f;
		double dNumber = 19.89d;
		//Kiểu ký tự
		char cChar = '1';
		//Kiểu đúng/sai
		boolean bStatus = false;
		
		System.out.println(number);
		System.out.println("Giá trị khởi tạo của kiểu byte:" + bNumber);
		System.out.println("Giá trị khởi tạo của kiểu short:" + sNumber);
		System.out.println("Giá trị khởi tạo của kiểu int:" + iNumber);
		System.out.println("Giá trị khởi tạo của kiểu long:" + lNumber);
		System.out.println("Giá trị khởi tạo của kiểu float:" + fNumber);
		System.out.println("Giá trị khởi tạo của kiểu double:" + dNumber);
		System.out.println("Giá trị khởi tạo của kiểu char:" + cChar);
		System.out.println("Giá trị khởi tạo của kiểu boolean:" + bStatus);
		
		System.out.println(studentNumber);
		
		//khởi tạo 1 object
		Topic_02_Data_Type topic = new Topic_02_Data_Type();
		//truy cập thông qua object đã khởi tạo thì mới dùng được biến
		System.out.println(topic.address);
		

	}

}
