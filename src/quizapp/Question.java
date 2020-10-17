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

    public Question(String questionText, String correctAnswer, int mark, String Answer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.mark = mark;
        this.Answer = Answer;
    }   
}
