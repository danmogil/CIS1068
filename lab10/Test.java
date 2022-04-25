package wk9;

/*
 * Daniel Mogil
 * 04/12/22
 * Assignment 10. Test Papers
 *
 * Create tests and answer keys
 * Extra Credit: send to a file
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
	private ObjectiveQuestion[] questions;
	protected double totalPoints = 0;

	public Test(ObjectiveQuestion[] questions) {
		this.questions = questions;
		for (int i = 0; i < questions.length; i++)
			totalPoints += questions[i].points;
	}

	@Override
	public String toString() {
		var sb = new StringBuilder();
		sb.append(String.format("Total Points: %s\n\n", totalPoints));
		for (int i = 1; i <= questions.length; i++) {
			var question = questions[i - 1];
			sb.append(String.format("%d) %s", i, question));
			for (int j = 0; j <= question.answerSpace; j++)
				sb.append("\n");
		}
		return sb.toString();
	}

	public String getAnswered() {
		var sb = new StringBuilder();
		sb.append(String.format("Total Points: %s\n\n", totalPoints));
		for (int i = 0; i < questions.length; i++)
			sb.append(questions[i].getAnswered() + "\n\n");
		return sb.toString();
	}

	public void printToFile() {
		System.out.print("File name: ");
		try (Scanner sc = new Scanner(System.in);
				FileWriter fw = new FileWriter("./" + sc.next())) {
			fw.write(toString());
			System.out.println("success");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	public void printToFileAnswered() {
		System.out.print("File name: ");
		try (Scanner sc = new Scanner(System.in);
				FileWriter fw = new FileWriter("./" + sc.next())) {
			fw.write(getAnswered());
			System.out.println("success");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	public static void main(String[] args) {
		var a = new ObjectiveQuestion(10, 5, 1, "2 + 4 =", "5");
		String[] possibleAnswers = {"Peter Griffin", "Scooby Doo", "Spongebob",
				"Eric Cartman"};
		var b = new MultipleChoiceQuestion(10, 2, 2,
				"Who lives in a pineapple under the sea?", possibleAnswers,
				"Spongebob");
		var c = new FillInTheBlankQuestion(25, 4, 2,
				"______ was the 16th US President.", "Abraham Lincoln");
		ObjectiveQuestion[] questions = {a, b, c};
		Test t = new Test(questions);
		// t.printToFile();
		t.printToFileAnswered();
	}
}
