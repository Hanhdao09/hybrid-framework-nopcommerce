package javaOOP;

public class CarPOP {
	static String carCompany;
	static String carType;
	static String fuelType;
	static Float mileAge;
	static Double carPrice;

	public static void main(String[] agrs) {
		carCompany = "Honda";
		carType = "City";
		fuelType = "Petrol";
		mileAge = 120f;
		carPrice = 3000000d;
		System.out.println("Car Company= " + carCompany);
		System.out.println("Car Type= " + carType);
		System.out.println("Car Fuel Type= " + fuelType);
		System.out.println("Car Mile Age= " + mileAge);
		System.out.println("Car Price= " + carPrice);

		carCompany = "Toyota";
		carType = "Camry";
		fuelType = "Diesel";
		mileAge = 200f;
		carPrice = 6000000d;
		System.out.println("Car Company= " + carCompany);
		System.out.println("Car Type= " + carType);
		System.out.println("Car Fuel Type= " + fuelType);
		System.out.println("Car Mile Age= " + mileAge);
		System.out.println("Car Price= " + carPrice);
	}
}
