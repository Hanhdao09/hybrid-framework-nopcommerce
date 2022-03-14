package javaOOP.knowledge;

public class Topic05_This_Super {
	private int firstNumber;
	private int secondNumber;

	public Topic05_This_Super(int firstNumber, int secondNumber) {
		super();
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	public void sumNumber() {
		System.out.println(firstNumber + secondNumber);
	}

	public static void main(String[] args) {
		Topic05_This_Super topic05 = new Topic05_This_Super(15, 7);
		topic05.sumNumber();
	}

}
