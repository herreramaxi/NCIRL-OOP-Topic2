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
            OptionType correctAnswer, 
            int mark,
            String optionA, 
            String optionB,
            String optionC) {
        super(questionText,correctAnswer.toString(), mark);
        
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
    }
    
     public String getTypeName(){
        return QuestionType.MultipleChoice.toString();
    }

     
    @Override
    public String toString() {
        String superString = super.toString();
        StringBuilder sb = new StringBuilder(superString);
        sb.append("optionA: " + this.optionA).append("\n");
        sb.append("optionB: " + this.optionB).append("\n");
        sb.append("optionC: " + this.optionC).append("\n");

        return sb.toString();
    }
    
}
