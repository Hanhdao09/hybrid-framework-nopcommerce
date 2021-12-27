package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_Data_Type2_Exercises {

	
	@Test
	public void TC01_int() {
		int a = 6;
		int b = 2;
		System.out.println("Tổng của a và b là: " + (a + b));
		System.out.println("Hiệu của a và b là: " + (a - b));
		System.out.println("Tích của a và b là: " + (a * b));
		System.out.println("Thương của a và b là: " + (a / b));
	}
	
	@Test
	public void TC02_float() {
		float height = 7.5f;
		float width = 3.8f;
		System.out.println("Area = " + (height * width));
	}

	@Test
	public void TC03_String() {
		String name = "Automation Testing";
		System.out.println("Hello " + name);
		
	}
	}


