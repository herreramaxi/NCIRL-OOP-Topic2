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
            int maxWordCount) {
        super(questionText, correctAnswer, mark);
        this.maxWordCount = maxWordCount;
    }

    public String getTypeName() {
        return QuestionType.Essay.toString();
    }

    @Override
    public String toString() {
        String superString = super.toString();
        StringBuilder sb = new StringBuilder(superString);
        sb.append("maxWordCount: ").append(this.maxWordCount);

        return sb.toString();
    }

}
