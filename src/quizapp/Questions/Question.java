/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapp.Questions;

import quizapp.Enums.QuestionType;

/**
 *
 * @author Maximiliano Herrera
 */
public class Question {

    protected String questionText;
    protected String correctAnswer;
    protected int mark;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getMark() {
        return mark;
    }

    public Question(String questionText, String correctAnswer, int mark) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.mark = mark;
    }

    public String getTypeName() {
        return QuestionType.Question.toString();
    }

    public Validation Validate() {
        Validation validation = new Validation();

        return correctAnswer.isEmpty() || questionText.isEmpty() || mark < 0
                ? validation.SetAsFailed("Please fill mandatory fields: Question, Correct Answer and Mark")
                : validation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question type: ").append(this.getTypeName()).append("\n");
        sb.append("Question: ").append(this.questionText).append("\n");
        sb.append("Correct answer: ").append(this.correctAnswer).append("\n");
        sb.append("Mark: ").append(this.mark).append("\n");

        return sb.toString();
    }

}
