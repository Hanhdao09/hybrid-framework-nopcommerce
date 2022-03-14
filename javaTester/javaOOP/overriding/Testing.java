package javaOOP.overriding;

public class Testing {

	public static void main(String[] args) {
		// Th1: 1 class extend 1 normal class
		HuskyDog husky = new HuskyDog();
		husky.bark();
		husky.bit();
		husky.hunting();
		husky.eat();
		husky.sleep();
		// Th2: 1 class implement nhiều interface
		Cat cat = new Cat();
		cat.climb();
		cat.eat();
		cat.sleep();
		// Th3: Downcasting

	}

}
