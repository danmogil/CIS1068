package wk8;

public class Fraction {
	private int numerator, denominator;

	public Fraction(int n, int d) {
		if (d == 0)
			throw new ArithmeticException();
		numerator = n;
		denominator = d;
	}

	public int getNum() {
		return numerator;
	}

	public int getDenom() {
		return denominator;
	}

	public void setNum(int n) {
		numerator = n;
	}

	public void setDenom(int d) {
		if (d == 0)
			throw new ArithmeticException();
		denominator = d;
	}

	public Fraction add(Fraction a) {
		int n = (numerator * a.denominator + a.numerator * denominator);
		int d = denominator * a.denominator;
		int gcd = getGCD(n, d);
		return new Fraction(n / gcd, d / gcd);
	}

	public boolean equals(Fraction a) {
		double val = numerator / denominator;
		double aVal = a.numerator / a.denominator;
		return val == aVal;
	}

	@Override
	public String toString() {
		return String.format("%d/%d", numerator, denominator);
	}

	private int getGCD(int n, int d) {
		if (d == 0)
			return n;
		return getGCD(d, n % d);
	}

}
