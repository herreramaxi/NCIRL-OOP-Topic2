package quizapp.Questions;

import quizapp.Questions.Question;
import quizapp.Enums.QuestionType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maximiliano Herrera
 */
public class EssayQuestion extends Question {

    private final int maxWordCount;

    public EssayQuestion(String questionText,
            String correctAnswer,
            int mark,
            int maxWordCount) {
        super(questionText, correctAnswer, mark);
        this.maxWordCount = maxWordCount;
    }

    public QuestionType getQuestionType() {
        return QuestionType.Essay;
    }

    @Override
    public Validation Validate() {
        Validation validation = new Validation();

        boolean mandatoryFieldsNotFilled = correctAnswer.isEmpty()
                || questionText.isEmpty()
                || mark < 0
                || maxWordCount <= 0;

        validation = mandatoryFieldsNotFilled
                ? validation.SetAsFailed("Please fill mandatory fields: Question, Correct Answer, Mark and Max words count")
                : validation;

        if (!mandatoryFieldsNotFilled) {
            int wordsCount = correctAnswer.trim().split("\\s+").length;

            if (wordsCount > maxWordCount) {
                validation.SetAsFailed("The quantity of words entered exceed the max word count limit, quantity of words: " + wordsCount);
            }
        }

        return validation;
    }

    @Override
    public String toString() {
        String superString = super.toString();
        StringBuilder sb = new StringBuilder(superString);
        sb.append("Max words count: ").append(this.maxWordCount);

        return sb.toString();
    }

}
