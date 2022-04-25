package wk9;

public class ObjectiveQuestion extends Question {
	protected String correctAnswer;

	public ObjectiveQuestion(double points, int difficulty, int answerSpace,
			String questionText, String correctAnswer) {
		super(points, difficulty, answerSpace, questionText);
		this.correctAnswer = correctAnswer;
	}

	public String getAnswered() {
		return String.format("%s *%s*", questionText, correctAnswer);
	}
}
