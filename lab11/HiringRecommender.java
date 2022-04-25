package wk10;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Daniel Mogil
 * 04/18/22
 * Assignment 11. Hiring Recommender
 *
 * What criteria did you select? Why?
 * I reviewed applicants on two primary conditions: university and programming language. 
 * In my opinion, programming knowledge (language, etc.) does not define a good programmer. 
 * A good programmer has a passion for learning and the determination/maturity to do so.
 * Additionally, they are out of the box thinkers and quickly grasp new topics (my definition of intelligence).
 * Thus, I chose applicants from rigorous schools. My GPA requirement was low due to difficulty of study.
 * Lastly, I filtered out candidates who have no experience with OOP languages as these concepts take practice.
 * 
 * What sorts of candidates do we miss when we automate hiring decisions in this way?
 * Main flaw: filtering out intelligent applicants who did not have the maturity/drive in high school
 * to achieve placement at a top university or those who could not afford tuition.
 */

public class HiringRecommender {
	private ArrayList<Applicant> applicantPool = new ArrayList<>();

	// conditions
	private static final List<String> PREF_UNIVERSITIES = new ArrayList<>(
			List.of("Harvard University", "Princeton University",
					"Massachusetts Institute of Technology",
					"Stanford University", "Carnegie Mellon University",
					"Rice University", "Northwestern University",
					"Columbia University", "Swarthmore College"));
	private static final double MIN_GPA = 2.25;
	private static final String[] PREF_PROGRAMMING_LANGUAGE = new String[]{
			"Java", "C++", "C#", "Ruby", "Swift"};

	public HiringRecommender(File applicant_CSV) {
		try (Scanner sc = new Scanner(applicant_CSV)) {
			sc.nextLine(); // column titles
			while (sc.hasNextLine()) {
				String[] fields = sc.nextLine().split(",(?=[^\\s])");
				String lastName = fields[0], firstName = fields[1],
						phone = fields[2], email = fields[3],
						address = fields[4], zipcode = fields[5],
						region = fields[6], programmingLanguages = fields[7],
						gpa = fields[8], major = fields[9],
						university = fields[10];
				applicantPool.add(new Applicant(lastName, firstName, phone,
						email, address, zipcode, region, programmingLanguages,
						gpa, major, university));
			}
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	public void printTopApplicants(int numApplicants) {
		filterPool();
		int poolSize = applicantPool.size();
		if (numApplicants > poolSize) {
			Scanner STDIn = new Scanner(System.in);
			System.out.println(String.format(
					"Warning: only %d applicants meet your conditions.",
					poolSize));
			System.out.print("Continue? (yes, no) ");
			String in = STDIn.next();
			while (!in.equals("yes") && !in.equals("no")) {
				System.out.print("Continue? (yes, no) ");
				in = STDIn.next();
			}
			STDIn.close();
			if (in.equals("no"))
				return;
			numApplicants = poolSize;
		}
		System.out.println("Top applicants meeting your conditions: ");
		for (int i = 0; i < numApplicants; i++) {
			Applicant curr = applicantPool.get(i);
			System.out.println(String.format("%d) %s", i + 1, curr.name));
		}
	}

	private void filterPool() {
		applicantPool.removeIf(
				applicant -> !PREF_UNIVERSITIES.contains(applicant.university)
						|| applicant.gpa < MIN_GPA
						|| (!applicant.programmingLanguages
								.contains(PREF_PROGRAMMING_LANGUAGE[0])
								&& !applicant.programmingLanguages
										.contains(PREF_PROGRAMMING_LANGUAGE[1])
								&& !applicant.programmingLanguages
										.contains(PREF_PROGRAMMING_LANGUAGE[2])
								&& !applicant.programmingLanguages
										.contains(PREF_PROGRAMMING_LANGUAGE[3])
								&& !applicant.programmingLanguages.contains(
										PREF_PROGRAMMING_LANGUAGE[4])));
	}

	public static void main(String[] args) {
		var test = new HiringRecommender(new File("./src/applicant_data.csv"));
		test.printTopApplicants(20);
	}
}
