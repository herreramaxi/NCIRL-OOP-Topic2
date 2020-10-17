package quizapp;


import quizapp.Question;

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
            String Answer,
            int maxWordCount) {
        super(questionText, correctAnswer, mark, Answer);
        this.maxWordCount = maxWordCount;
    }

}
