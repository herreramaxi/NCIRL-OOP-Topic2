/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapp;

import java.util.ArrayList;

/**
 *
 * @author Maximiliano Herrera
 */
public class UIMediator {

    private final QuizJFrame mainFrame;
    private final ArrayList<Question> questions;

    UIMediator(QuizJFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.mainFrame.initializeControlValues();
        questions = new ArrayList<>();
    }

    public void SelectQuestion(QuestionType questionType) {
        switch (questionType) {
            case Question: {
                this.mainFrame.setVisibleMaxWordCountControls(false);
                this.mainFrame.setVisibleCorrectAnswerControls(true);
                this.mainFrame.setVisibleMultipleChoiceControls(false);
            }
            break;
            case MultipleChoice: {
                this.mainFrame.setVisibleMaxWordCountControls(false);
                this.mainFrame.setVisibleCorrectAnswerControls(false);
                this.mainFrame.setVisibleMultipleChoiceControls(true);
            }
            break;
            case Essay: {
                this.mainFrame.setVisibleMaxWordCountControls(true);
                this.mainFrame.setVisibleCorrectAnswerControls(true);
                this.mainFrame.setVisibleMultipleChoiceControls(false);
            }
            break;
        }
    }

    public void SubmitQuestion() {
        QuestionType questionType = this.mainFrame.getQuestionType();
        String questionText = this.mainFrame.getQuestionText();
        String correctAnswer = this.mainFrame.getCorrectAnswer();
        int mark = this.mainFrame.getMark();
        Question question;

        switch (questionType) {
            case MultipleChoice: {
                String optionA = this.mainFrame.getOptionAText();
                String optionB = this.mainFrame.getOptionBText();
                String optionC = this.mainFrame.getOptionCText();
                OptionType multipleChoiceOption = this.mainFrame.getMultipleChoiceOption();

                question = new MultipleChoiceQuestion(questionText, multipleChoiceOption, mark, optionA, optionB, optionC);
            }
            break;
            case Essay: {
                int maxWordCount = this.mainFrame.getMaxWordCount();
                question = new EssayQuestion(questionText, correctAnswer, mark, maxWordCount);
            }
            break;
            case Question:
            default: {
                question = new Question(questionText, correctAnswer, mark);
            }
            break;
        }

        this.mainFrame.initializeControlValues();
        
        questions.add(question);
        System.out.println("Queston added: ");
        System.out.println(question);
    }
}
