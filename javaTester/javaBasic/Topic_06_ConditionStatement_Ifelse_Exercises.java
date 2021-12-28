package javaBasic;

import java.util.Scanner;

public class Topic_06_ConditionStatement_Ifelse_Exercises {

	public static void main(String[] args) {
		//Ex.01
		Scanner input = new Scanner(System.in);
		System.out.println("-----------Kiểm tra số chẵn số lẻ----------");
		System.out.println("Enter the number: ");
		int a = input.nextInt();
		if (a % 2 ==0) {
			System.out.println(a + " là số chẵn");
		} else {
			System.out.println(a + " là số lẻ");
		}
		//Ex.02
		Scanner input1 = new Scanner(System.in);
		System.out.println("--------So sánh 2 số-----------");
		System.out.println("Enter the number: ");
		int x = input.nextInt();
		int y = input.nextInt();
		if (x > y) {
			System.out.println(x + " lớn hơn " + y);
		} else if (x == y) {
			System.out.println(x + " bằng " + y);
		} else {
			System.out.println(x + " nhỏ hơn " + y);
		}
		//Ex.03
		Scanner input2 = new Scanner(System.in);
		System.out.println("---------Kiểm tra xem 2 người có trùng tên---------");
		System.out.println("Enter your name: ");
		String name1 = input.next();
		String name2 = input.next();
		if (name1.equals(name2)) {
			System.out.println("2 người là cùng tên");
		} else {
			System.out.println("2 người là khác tên");
		}
		//Ex.04
		Scanner input3 = new Scanner(System.in);
		System.out.println("-------Kiểm tra số lớn nhất--------");
		System.out.println("Enter the number: ");
		int no1 = input.nextInt();
		int no2 = input.nextInt();
		int no3 = input.nextInt();
		if (no1 > no2 && no1 > no3) {
			System.out.println("Số lớn nhất là: " + no1);
		} else if (no2 > no1 && no2 > no3) {
			System.out.println("Số lớn nhất là: " + no2);
		} else if (no3 > no1 && no3 > no2){
			System.out.println("Số lớn nhất là: " + no3);
		} else {
			System.out.println("3 số bằng nhau");
		}
		//Ex.05
		Scanner input4 = new Scanner(System.in);
		System.out.println("------Kiểm tra số có nằm trong khoảng 10-100 không-------");
		System.out.println("Enter the number: ");
		int m = input.nextInt();
		if (10 < m && m < 100) {
			System.out.println(m + "nằm trong khoảng 10-100");
		} else {
			System.out.println(m + "nằm không nằm trong khoảng 10-100");
		}
		//Ex.06
		Scanner input5 = new Scanner(System.in);
		System.out.println("-----Xếp hạng điểm------");
		System.out.println("Enter the score: ");
		float n = input.nextFloat();
		if (0 < n && n < 5) {
			System.out.println("Điểm D");
		} else if (5 <= n && n < 7.5) {
			System.out.println("Điểm C");
		} else if (7.5 <= n && n < 8.5) {
			System.out.println("Điểm B");
		} else if (8.5 <= n && n <= 10) {
			System.out.println("Điểm A");
		} else {
			System.out.println("Nhập điểm đúng");
		}
		//Ex.07
		Scanner input6 = new Scanner(System.in);
		System.out.println("---Hiển thị số ngày của 1 tháng");
		System.out.println("Enter the month: ");
		int month = input.nextInt();
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("Tháng đã nhập có 31 ngày");
		} else if (month == 2) {
			System.out.println("Tháng đã nhập có 28 hoặc 29 ngày");
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("Tháng đã nhập có 30 ngày");
		} else {
			System.out.println("Nhập tháng đúng");
		}
		input.close();
		input1.close();
		input2.close();
		input3.close();
		input4.close();
		input5.close();
		input6.close();
	}
	
}
