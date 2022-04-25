package wk9;

public class FillInTheBlankQuestion extends ObjectiveQuestion {
	public FillInTheBlankQuestion(double points, int difficulty,
			int answerSpace, String questionText, String correctAnswer) {
		super(points, difficulty, answerSpace, questionText, correctAnswer);
	}

	@Override
	public String getAnswered() {
		// assume 1 blank per question
		return questionText.replaceFirst("_+",
				String.format("___%s___", correctAnswer));
	}
}
