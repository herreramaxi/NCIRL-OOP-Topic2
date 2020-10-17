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
public class MultipleChoiceQuestion extends Question {

    private final String optionA;
    private final String optionB;
    private final String optionC;
    
    public MultipleChoiceQuestion(String questionText,
            String correctAnswer, 
            int mark,
            String Answer,
            String optionA, 
            String optionB,
            String optionC) {
        super(questionText, correctAnswer, mark, Answer);
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
    }

}
