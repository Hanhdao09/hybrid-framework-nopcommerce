package javaOOP.overriding;

public class Dog implements IAnimal {

	public void bark() {
		System.out.println("The dog barks");
	}

	public void bit() {
		System.out.println("The dog bits");
	}

	@Override
	public void eat() {
		System.out.println("The Dog eats bone");
	}

	@Override
	public void sleep() {
		System.out.println("The Dog sleep fewer than Cat");

	}

}
