package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_While_DoWhile_Excercises {
	Scanner scanner = new Scanner(System.in);

	@Test
	public void Ex_01() {
		System.out.println("-----------Hiển thị số chẵn đến 100------------");
		System.out.println("Enter the number: ");
		int n = scanner.nextInt();
		while (n < 100) {
			if (n % 2 == 0) {
				System.out.println(n);
			}
			n++;
		}
	}

	@Test
	public void Ex_02() {
		System.out.println("---------Hiển thị số chia hết cho cả 3 và 5----------");
		System.out.println("Enter the number: ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		while (a < b) {
			if (a % 3 == 0 && a % 5 == 0) {
				System.out.println(a);
			}
			a++;
		}
	}

	@Test
	public void Ex_03() {
		System.out.println("---------Cộng các số lẻ------------");
		System.out.println("Enter the number: ");
		int z = scanner.nextInt();
		int i = 0;
		while (z > 0) {
			if (z % 2 != 0) {
				i += z;
			}
			z--;
		}
		System.out.println(i);
	}

	@Test
	public void Ex_04() {
		System.out.println("Enter the number: ");
		System.out.println("------------Hiển thị số chia hết cho 3---------");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		while (x < y) {
			if (x % 3 == 0) {
				System.out.println(x);
			}
			x++;
		}
	}

	@Test
	public void Ex_05() {
		System.out.println("------Hiển thị tích các số liên tiếp từ 1 đếm m------");
		System.out.println("Enter the number: ");
		int j = 1;
		int m = scanner.nextInt();
		while (1 <= m) {
			j *= m;
			m--;
		}
		System.out.println(j);
	}

	@Test
	public void Ex_06() {
		System.out.println("---------Cộng các số chắn từ 1->10------------");
		System.out.println("Cộng các số chẵn từ 1-> 10 là: ");
		int i = 0;
		int z = 10;
		while (z > 0 && z <= 10) {
			if (z % 2 == 0) {
				i += z;
			}
			z--;
		}
		System.out.println(i);
	}
}
