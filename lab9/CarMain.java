package wk8;

public class CarMain {
	public static void main(String[] args) {
		Car a = new Car("Ford", "Pinto", 1972, 17.5, 132480, 12, 8);
		System.out.println(a.toString());
		System.out.print("\nEDIT\n\n");
		a.fillTank(10);
		System.out.println("Fill Tank: +10g");
		System.out.println("Fuel Remaining: " + a.getFuelRemaining() + "\n");
		a.drive(100.5);
		System.out.println(a.toString());
	}
}
