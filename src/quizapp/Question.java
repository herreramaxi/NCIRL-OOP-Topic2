/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapp;

/**
 *
 * @author Maximiliano Herrera
 */
public class Question {

    protected String questionText;
    protected String correctAnswer;
    protected int mark;
    protected String Answer;

    public Question(String questionText, String correctAnswer, int mark) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.mark = mark;
    }

    public String getTypeName() {
        return QuestionType.Question.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question type: ").append(this.getTypeName()).append("\n");
        sb.append("questionText: ").append(this.questionText).append("\n");
        sb.append("correctAnswer: ").append(this.correctAnswer).append("\n");
        sb.append("mark: ").append(this.mark).append("\n");
        
        return sb.toString();
    }

}
