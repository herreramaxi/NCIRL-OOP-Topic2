/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapp.Mediator;

import quizapp.Questions.Validation;
import quizapp.UI.QuizJFrame;
import quizapp.Enums.OptionType;
import quizapp.Enums.QuestionType;
import quizapp.Questions.EssayQuestion;
import quizapp.Questions.Question;
import quizapp.Questions.MultipleChoiceQuestion;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maximiliano Herrera
 */
public class UIMediator {

    private final ArrayList<Question> questions;
    private final QuizJFrame mainFrame;
    private final JTable jTable;

    public UIMediator(QuizJFrame mainFrame, JTable jTable) {
        this.mainFrame = mainFrame;
        this.jTable = jTable;
        this.questions = new ArrayList<Question>();
    }

    public void SelectQuestion(QuestionType questionType) {
        switch (questionType) {
            case Question: {
                this.mainFrame.setEnabledMaxWordCountControls(false);
                this.mainFrame.setEnabledCorrectAnswerControls(true);
                this.mainFrame.setEnabledMultipelChoiceControls(false);
            }
            break;
            case MultipleChoice: {
                this.mainFrame.setEnabledMaxWordCountControls(false);
                this.mainFrame.setEnabledCorrectAnswerControls(false);
                this.mainFrame.setEnabledMultipelChoiceControls(true);
            }
            break;
            case Essay: {
                this.mainFrame.setEnabledMaxWordCountControls(true);
                this.mainFrame.setEnabledCorrectAnswerControls(true);
                this.mainFrame.setEnabledMultipelChoiceControls(false);
            }
            break;
        }
    }

    public void AddQuestion() {
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
                question = new Question(questionText, correctAnswer, mark);
                break;
            default: {
                throw new IllegalArgumentException();
            }
        }

        Validation validation = question.Validate();

        if (!validation.successful()) {
            this.mainFrame.showErrorMessageDialog(validation.getErrorMessage());
            return;
        }

        Question q = questions.stream().max(Comparator.comparing(Question::getId)).orElse(null);
        int id = q == null ? 1 : q.getId() + 1;

        question.setId(id);
        questions.add(question);

        this.mainFrame.initializeControlValues();
        this.mainFrame.cleanSearchFilter();
        this.updateTableModel(questions);

        System.out.println("Queston added: ");
        System.out.println(question);
    }

    public void deleteRow(int id) {
        Question question = questions.stream()
                .filter((q) -> q.getId() == id)
                .findFirst()
                .orElse(null);

        if (question != null) {
            this.questions.remove(question);
            String searchText = this.mainFrame.getSearchFilter();

            ArrayList<Question> filteredQuestions = this.filterQuestionsBy(searchText);

            this.updateTableModel(filteredQuestions);
        }
    }

    public void SearchQuestions(String searchText) {
        ArrayList<Question> filteredQuestions = this.filterQuestionsBy(searchText);
        this.updateTableModel(filteredQuestions);
    }

    public void printQuestion(int id) {
        Question question = questions.stream()
                .filter((q) -> q.getId() == id)
                .findFirst()
                .orElse(null);

        if (question != null) {
            mainFrame.showMessageDialog(question.toString());
        } else {
            mainFrame.showErrorMessageDialog("Error: question not found");
        }
    }

    public void answerQuestion(int questionId) {
        Question question = questions.stream()
                .filter((q) -> q.getId() == questionId)
                .findFirst()
                .orElse(null);

        if (question != null) {
            String answer = getUserAnswer(question);
            boolean result = question.answer(answer);
            String message = result
                    ? "Your answer is correct, mark awarded: " + question.getMark()
                    : "Incorrect answer";

            mainFrame.showMessageDialog(message);
        } else {
            mainFrame.showErrorMessageDialog("Error: question not found");
        }
    }

    private ArrayList<Question> filterQuestionsBy(String filter) {
        List<Question> filteredQuestions = questions.stream()
                .filter((q) -> q.getQuestionText().toLowerCase().contains(filter.toLowerCase()))
                .collect(Collectors.toList());

        return new ArrayList<>(filteredQuestions);
    }

    private void updateTableModel(ArrayList<Question> questions) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        Object[] row = new Object[3];
        model.setRowCount(0);
        for (int i = 0; i < questions.size(); i++) {
            row[0] = questions.get(i).getId();
            row[1] = questions.get(i).getQuestionType();
            row[2] = questions.get(i).getQuestionText();
            model.addRow(row);
        }
    }

    private String getUserAnswer(Question question) {
        if (question.getQuestionType() == QuestionType.MultipleChoice) {
            Object[] possibleValues = OptionType.values();
            Object input = JOptionPane.showInputDialog(null,
                    "Select correct option", "Select correct option",
                    JOptionPane.INFORMATION_MESSAGE, null,
                    possibleValues, possibleValues[0]);

            return input == null ? null : input.toString();
        } else {
            return JOptionPane.showInputDialog("Please enter answer");
        }
    }
}
