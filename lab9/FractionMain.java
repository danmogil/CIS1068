package wk8;

public class FractionMain {
	public static void main(String[] args) {
		var a = new Fraction(2, 5);
		var b = new Fraction(16, 4);
		var c = a.add(b);
		System.out.println(String.format("%s + %s = %s\n", a, b, c));
		a.setNum(12);
		a.setDenom(18);
		c = a.add(b);
		System.out.println(String.format("%s + %s = %s\n", a, b, c));
		var d = new Fraction(c.getNum() * 13, c.getDenom() * 13);
		System.out.println(String.format("%s == %s = %s", c, d, c.equals(d)));
	}
}
