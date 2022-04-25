package wk8;

public class Car {
	private String make, model;
	private int year;
	private double mpg, milesDriven;
	private double fuelCapacity, fuelRemaining;

	public Car(String make, String model, int year, double mpg,
			double milesDriven, double fuelCapacity, double fuelRemaining) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.mpg = mpg;
		this.milesDriven = milesDriven;
		this.fuelCapacity = fuelCapacity;
		this.fuelRemaining = fuelRemaining;
	}

	public void fillTank(double g) {
		double sum = fuelRemaining + g;
		fuelRemaining = sum > fuelCapacity ? fuelCapacity : sum;
	}

	public void drive(double m) {
		milesDriven += m;
		fuelRemaining -= (m / mpg);
	}

	@Override
	public String toString() {
		return String.format(
				"%d %s %s\nMPG: %.2f, Fuel Capacity: %.2f\nMileage: %.1f, Fuel Remaining: %.2f",
				year, make, model, mpg, fuelCapacity, milesDriven,
				fuelRemaining);
	}

	public double getFuelRemaining() {
		return fuelRemaining;
	}
}
