import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * Daniel Mogil
 * 03/14/22
 * Assignment 7. Southie Styles
 *
 * Applies a Southie accent to Jaws movie script.
 * Extra credit: preserve spacing, unit tests
 */

public class Southie {

	public static String alterLine(String line) {
		line = line.toLowerCase();
		line = line.replaceAll("very", "wicked");
		line = line.replaceAll("(?<=oo)r(?=[,.\"'?!| \n])", "wah");
		line = line.replaceAll("(?<=ee|i)r(?=[,.\"'?!| \n])", "yah");
		line = line.replaceAll("(?<=[aeiou])r", "h");
		line = line.replaceAll("(?<=\\w)a(?=[,.\"'?!| \n])", "ar");
		return line;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new File("./src/jaws.txt"))) {
			PrintStream out = new PrintStream("./src/alteredJaws.txt");
			while (sc.hasNextLine()) {
				String alteredLine = alterLine(sc.nextLine());
				out.print(alteredLine + "\n");
			}
			out.close();
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
