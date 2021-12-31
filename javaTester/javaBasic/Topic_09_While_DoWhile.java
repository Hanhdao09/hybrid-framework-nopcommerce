package javaBasic;

public class Topic_09_While_DoWhile {
	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			System.out.println("For: " + i);
		}
		int i = 0;
		while (i < 5) {
			System.out.println("while: " + i);
			i++;
		}

		do {
			System.out.println("do-while: " + i);
			i++;
		} while (i < 5);
	}
}
