package javaBasic;

import java.util.Scanner;

public class Topic_04_Operator_Excercises {

	public static void main(String[] args) {
	//Ex.01
	Scanner input = new Scanner(System.in);
	 System.out.println("Enter your name:");
	 String name = input.nextLine();
	 System.out.println("Enter your age:");
	 int age = input.nextInt();
	 System.out.println("After 15 year, " + "age of " + name + " wil be " + (age + 15));
	 //Ex.02
		int a = 3, b = 4;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("After swapping then, a = " + a + ", b = " + b);
	//Ex.03
		Scanner input1 = new Scanner(System.in);
		 System.out.println("Enter number");
		 int number1 = input.nextInt();
		 int number2 = input.nextInt();
		 if (number1 > number2) {
			 System.out.println("True");
		} else {
			System.out.println("False");
		}
		input.close();
		input1.close();
	}

}
