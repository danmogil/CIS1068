package wk9;

import java.util.Arrays;

public class MultipleChoiceQuestion extends ObjectiveQuestion {
	protected String[] possibleAnswers;

	public MultipleChoiceQuestion(double points, int difficulty,
			int answerSpace, String questionText, String[] possibleAnswers,
			String correctAnswer) {
		super(points, difficulty, answerSpace, questionText, correctAnswer);
		// assert possibleAnswers contains correctAnswer
		if (Arrays.binarySearch(possibleAnswers, correctAnswer) == -1) {
			throw new IllegalArgumentException(
					"possibleAnswers must include correctAnswer");
		}
		this.possibleAnswers = possibleAnswers;
	}

	@Override
	public String toString() {
		var sb = new StringBuilder();
		sb.append(questionText + "\n");
		for (int i = 1; i <= possibleAnswers.length; i++)
			sb.append(String.format("\t%d. %s\n", i, possibleAnswers[i - 1]));
		return sb.toString();
	}

	@Override
	public String getAnswered() {
		return toString().replace(correctAnswer,
				String.format("***%s***", correctAnswer));
	}
}
