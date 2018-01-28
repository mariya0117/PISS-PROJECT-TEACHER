package piss.teacher.requests;

import java.util.List;

public class AddQuestionRequest {

	private String questionText;
	private List<AnswerRequest> answers;

	public AddQuestionRequest() {
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String question) {
		this.questionText = question;
	}

	public List<AnswerRequest> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerRequest> answers) {
		this.answers = answers;
	}

	public static class AnswerRequest {
		private String answerText;
		private Boolean isCorrect;

		public AnswerRequest() {
		}

		public String getAnswerText() {
			return answerText;
		}

		public void setAnswerText(String answer) {
			this.answerText = answer;
		}

		public Boolean isCorrect() {
			return isCorrect;
		}

		public void setCorrect(Boolean isCorrect) {
			this.isCorrect = isCorrect;
		}

	}
}
