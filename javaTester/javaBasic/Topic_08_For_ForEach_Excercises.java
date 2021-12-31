package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_For_ForEach_Excercises {
	Scanner scanner = new Scanner(System.in);

	@Test
	public void Ex_01() {
		System.out.println("----In số từ 1->10----");
		for (int i = 1; i <= 10; i++) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

	@Test
	public void Ex_02() {
		System.out.println(" ");
		System.out.println("----In số từ m->n----");
		System.out.println("Nhập vào 2 số m và n: ");
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		for (int i = m; i <= n; i++) {
			System.out.println(i);
		}
	}

	@Test
	public void Ex_03() {
		System.out.println("----------In ra tổng các số nguyên chẵn từ 1->10---------");
		int i = 0;
		int m = 10;
		for (int j = 0; j <= m; j++) {
			if (j % 2 == 0) {
				i += j;
			}
		}
		System.out.println("Tổng các số chẵn từ 0->10 là: " + i);
	}

	@Test
	public void Ex_04() {
		System.out.println("----------In ra tổng các số nguyên từ a tới b---------");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int j = 0;
		for (int i = a; i <= b; i++) {
			j += i;
		}
		System.out.println("Tổng các số nguyên từ a tới b là: " + j);
	}

	@Test
	public void Ex_05() {
		System.out.println("----------In ra tổng các số lẻ từ 0 tới z---------");
		int z = scanner.nextInt();
		int j = 0;
		for (int i = 0; i <= z; i++) {
			if (i % 2 != 0) {
				j += i;
			}
		}
		System.out.println("Tổng các số lẻ từ 0 tới z là: " + j);
	}

	@Test
	public void Ex_06() {
		System.out.println("----------Hiển thị ra các số từ a->b mà chia hết cho 3---------");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		for (int i = a; i <= b; i++) {
			if (i % 3 == 0) {
				System.out.println(i);
			}
		}

	}

	@Test
	public void Ex_07() {
		System.out.println("----------Hiển thị ra màn hình n!---------");
		int j = 1;
		int n = scanner.nextInt();
		for (int i = 1; i <= n; i++) {
			j *= i;
		}
		System.out.println(j);
	}
}
