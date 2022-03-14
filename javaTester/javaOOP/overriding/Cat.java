package javaOOP.overriding;

public class Cat implements IClimbable, IAnimal {

	@Override
	public void eat() {
		System.out.println("The Cat eats fish ");

	}

	@Override
	public void sleep() {
		System.out.println("The Cat sleeps all day");

	}

	@Override
	public void climb() {
		System.out.println("The Cat climb the tree");

	}

}
