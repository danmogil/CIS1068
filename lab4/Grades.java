package wk4;
import java.util.Scanner;

/*
 * Daniel Mogil
 * 02/07/22
 * Assignment 4. Grades
 *
 * Calculates a student's course grade based on standard input
 */

public class Grades {

	private static double getHW_score(double HW_weight, int numAssignments,
			double avgHW_grade, int numLateDays, int labsAttended) {

		final int pointsPerHomework = 10, pointsPerLab = 4;
		int numLabs = numAssignments;

		if (numAssignments <= 0) {
			return HW_weight;
		}

		if (avgHW_grade > 100)
			avgHW_grade = 100;

		double maxScore = (pointsPerHomework * numAssignments
				+ pointsPerLab * numLabs);

		double pointsEarned = (avgHW_grade * numAssignments
				+ labsAttended * pointsPerLab);
		double rawScore = pointsEarned / maxScore;

		if (numLateDays > (numAssignments / 2)) {
			rawScore *= .9;
		} else if (numLateDays == 0 && rawScore != maxScore) {
			if (maxScore - 5 <= rawScore)
				rawScore = maxScore;
			else
				rawScore += 5;
		}

		double weightedScore = rawScore * HW_weight;

		printScore(pointsEarned, maxScore, weightedScore);

		return weightedScore;
	}

	private static double getExamScore(double examWeight, double rawScore,
			double curve) {
		final int maxScore = 100;

		double curvedScore = rawScore + curve > 100 ? 100 : rawScore + curve;
		double weightedScore = examWeight * (curvedScore / maxScore);

		printScore(rawScore, maxScore, weightedScore);

		return weightedScore;
	}

	private static void printScore(double score, double maxScore,
			double weightedScore) {
		System.out.println(
				String.format("Total points = %.1f / %.1f", score, maxScore));
		System.out
				.println(String.format("Weighted score = %.2f", weightedScore));
	}

	public static void main(String[] args) {
		try (Scanner STDIn = new Scanner(System.in)) {

			System.out.print("Homework weight? ");
			double HW_weight = STDIn.nextDouble();

			System.out.print("Exam 1 weight? ");
			double exam1Weight = STDIn.nextDouble();

			double exam2Weight = 100 - (HW_weight + exam1Weight);
			if (exam2Weight < 0)
				throw new Exception("Invalid assignment weights!");

			System.out.println(String.format("Using weights of %.1f %.1f %.1f",
					HW_weight, exam1Weight, exam2Weight));

			System.out.print("Homework:\nNumber of assignments? ");
			int numAssignments = STDIn.nextInt();

			System.out.print("Average homework grade? ");
			double avgHW_grade = STDIn.nextDouble();

			System.out.print("Number of late days used? ");
			int numLateDays = STDIn.nextInt();

			System.out.print("Labs attended? ");
			int labsAttended = STDIn.nextInt();

			double HW_score = getHW_score(HW_weight, numAssignments,
					avgHW_grade, numLateDays, labsAttended);

			System.out.print("Exam 1:\nScore? ");
			double exam1RawScore = STDIn.nextDouble();

			System.out.print("Curve? ");
			double exam1Curve = STDIn.nextDouble();

			double exam1Score = getExamScore(exam1Weight, exam1RawScore,
					exam1Curve);

			System.out.print("Exam 2:\nScore? ");
			double exam2RawScore = STDIn.nextDouble();

			System.out.print("Curve? ");
			double exam2Curve = STDIn.nextDouble();

			double exam2Score = getExamScore(exam2Weight, exam2RawScore,
					exam2Curve);

			double courseGrade = HW_score + exam1Score + exam2Score;

			System.out.println(String.format("Course grade =\u001B[32m %.2f",
					courseGrade));

		} catch (Exception e) {
			System.out.println("\u001B[31m" + e.getMessage());
		}
	}
}
