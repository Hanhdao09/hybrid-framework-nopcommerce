package javaBasic;

import java.util.Scanner;

public class Topic_07_ConditionStatement_switchcase_Exercises {

	public static void main(String[] args) {
		//Ex.01
		Scanner input = new Scanner(System.in);
		System.out.println("-----------In ra tên các chữ số nhập vào bằng tiếng anh----------");
		System.out.println("Enter the number: ");
		int a = input.nextInt();
		switch (a) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nine");
			break;
		case 10:
			System.out.println("Ten");
			break;
			
		}
		//Ex.02
		Scanner input1 = new Scanner(System.in);
		System.out.println("-----------Tính tổng hiệu tích thương của 2 số nhập vào----------");
		System.out.println("Enter the number: ");
		int x = input1.nextInt();
		String operator = input1.next();
		int y = input1.nextInt();
		switch (operator) {
		case "+":
			System.out.println("A + B= " + (x + y));
			break;
		case "-":
			System.out.println("A - B= " + (x - y));
			break;
		case "*":
			System.out.println("A * B= " + (x * y));
			break;
		case "/":
			System.out.println("A / B= " + (x / y));
			break;
		case "%":
			System.out.println("A % B= " + (x % y));
			break;
		}
		//Ex.03
		Scanner input2 = new Scanner(System.in);
		System.out.println("-----------Hiển thị số ngày của 1 tháng----------");
		System.out.println("Enter the month: ");
		int month = input1.nextInt();
		switch (month) {
		case 1, 3, 5, 7, 8, 10, 12:
			System.out.println("Tháng vừa nhập có 31 ngày");
		break;
		case 2:
			System.out.println("Tháng vừa nhập có 28 hoặc 29 ngày");
		break;
		case 4, 6, 9, 11:
			System.out.println("Tháng vừa nhập có 30 ngày");
			break;
		}
		input.close();
		input1.close();
		input2.close();
	}
	
}
