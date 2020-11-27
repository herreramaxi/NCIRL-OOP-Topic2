/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapp.Questions;

import quizapp.Enums.OptionType;
import quizapp.Enums.QuestionType;

/**
 *
 * @author Maximiliano Herrera
 */
public class MultipleChoiceQuestion extends Question {

    private final String optionA;
    private final String optionB;
    private final String optionC;

    public MultipleChoiceQuestion(String questionText,
            OptionType correctAnswer,
            int mark,
            String optionA,
            String optionB,
            String optionC) {
        super(questionText, correctAnswer.toString(), mark);

        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
    }

    public QuestionType getQuestionType() {
        return QuestionType.MultipleChoice;
    }

    @Override
    public Validation Validate() {
        Validation validation = new Validation();

        return correctAnswer.isEmpty()
                || questionText.isEmpty()
                || mark < 0
                || optionA.isEmpty()
                || optionB.isEmpty()
                || optionC.isEmpty()
                ? validation.SetAsFailed("Please fill mandatory fields: Question, Correct Answer, Mark, Option A, Option B and Option C")
                : validation;
    }

    @Override
    public String toString() {
        String superString = super.toString();
        StringBuilder sb = new StringBuilder(superString);
        sb.append("Option A: " + this.optionA).append("\n");
        sb.append("Option B: " + this.optionB).append("\n");
        sb.append("Option C: " + this.optionC).append("\n");

        return sb.toString();
    }

}
