package wk3;

/*
 * Daniel Mogil
 * 01/29/22
 * Assignment 3. ASCII Art
 *
 * Prints an ASCII representation of a house with a displaced roof.
 */

public class AsciiArt {

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";

	static final int SIZE = 10;
	static char[] ROOF_CHARS = {'/', '\\'};
	static char WALL_CHAR = '|';
	static char FLOOR_CHAR = '^';

	public static void main(String args[]) {
		for (int roofRow = 0; roofRow <= SIZE; roofRow++) {
			int outerSpaceCount = SIZE - roofRow;

			for (int i = 0; i < outerSpaceCount; i++) {
				for (int j = 0; j < SIZE; j++) {
					System.out.print(ANSI_RED + "." + ANSI_RESET); // displace
				}
				System.out.print(' ');
			}

			System.out.print(ROOF_CHARS[0]);

			for (int i = 0; i < roofRow * 2; i++) {
				System.out.print(' ');
			}

			System.out.print(ROOF_CHARS[1]);
			System.out.println();
		}

		for (int wallRow = 0; wallRow < SIZE; wallRow++) {
			System.out.print(WALL_CHAR);

			for (int j = 0; j < SIZE * 2; j++)
				System.out.print(' ');

			System.out.println(WALL_CHAR);
		}
		for (int i = 0; i < (SIZE * 2) + 2; i++)
			System.out.print(FLOOR_CHAR);
	}
}
