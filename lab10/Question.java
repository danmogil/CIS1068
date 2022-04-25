package wk9;

public class Question {
	public static final int MIN_DIFFICULTY = 1;
	public static final int MAX_DIFFICULTY = 5;
	protected double points;
	protected int difficulty;
	protected int answerSpace;
	protected String questionText;

	public Question(double points, int difficulty, int answerSpace,
			String questionText) {
		this.points = points;
		this.difficulty = difficulty;
		this.answerSpace = answerSpace;
		this.questionText = questionText;
	}

	@Override
	public String toString() {
		return questionText;
	}
}
