package quizapp.UI;

import quizapp.Enums.OptionType;
import quizapp.Enums.QuestionType;
import quizapp.Questions.Question;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import quizapp.Mediator.UIMediator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maximiliano Herrera
 */
public class QuizJFrame extends javax.swing.JFrame {

    private UIMediator mediator;

    /**
     * Creates new form QuizJFrame
     */
    public QuizJFrame() {
        initComponents();

        mediator = new UIMediator(this, jTable1);       

        for (String q : QuestionType.getEnumDescriptions()) {
            jComboBoxQuestionType.addItem(q);
        }
        for (OptionType t : OptionType.values()) {
            jComboBoxCorrectAnswer.addItem(t.toString());
        }

        setEnabledCorrectAnswerControls(true);
        setEnabledMultipelChoiceControls(false);
        setEnabledMaxWordCountControls(false);
        jButtonPrint.setEnabled(false);
        jButtonDelete.setEnabled(false);
        jButtonAnswer.setEnabled(false);
        this.initializeControlValues();

        //Only enable buttons when row is selected, I took the idea from below
        //@Reference: https://stackoverflow.com/questions/38336113/jtable-if-any-row-is-selected
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                jButtonAnswer.setEnabled(jTable1.getSelectedRow() >= 0);
                jButtonPrint.setEnabled(jTable1.getSelectedRow() >= 0);
                jButtonDelete.setEnabled(jTable1.getSelectedRow() >= 0);
            }
        });
    }

    public void setEnabledMaxWordCountControls(Boolean visible) {
        jLabelMaxWordCount.setEnabled(visible);
        jTextFieldMaxWordCount.setEnabled(visible);
    }

    public void setEnabledCorrectAnswerControls(Boolean visible) {
        jScrollPane2.setEnabled(visible);
        jLabelCorrectAnswer.setEnabled(visible);
        jTextAreaCorrectAnswer.setEnabled(visible);
    }

    public void setEnabledMultipelChoiceControls(Boolean visible) {
        jLabelMultipleChoiceAnswers.setEnabled(visible);
        jLabelOptionA.setEnabled(visible);
        jTextFieldOptionA.setEnabled(visible);
        jLabelOptionB.setEnabled(visible);
        jTextFieldOptionB.setEnabled(visible);
        jLabelOptionC.setEnabled(visible);
        jTextFieldOptionC.setEnabled(visible);
        jLabelMultipleChoiceCorrectOptions.setEnabled(visible);
        jComboBoxCorrectAnswer.setEnabled(visible);
    }

    public QuestionType getQuestionType() {
        String questionTypeDescription = jComboBoxQuestionType.getSelectedItem().toString();

        QuestionType qt = QuestionType.getEnum(questionTypeDescription);

        return qt;
    }

    public String getQuestionText() {
        return jTextFieldQuestion.getText();
    }

    public String getCorrectAnswer() {
        return jTextAreaCorrectAnswer.getText();
    }

    public int getMark() {
        String markString = jTextFieldMark.getText();

        return markString.isEmpty() ? -1 : Integer.parseInt(markString);
    }

    public int getMaxWordCount() {
        String maxWordCount = jTextFieldMaxWordCount.getText();

        return maxWordCount.isEmpty() ? -1 : Integer.parseInt(maxWordCount);
    }

    public OptionType getMultipleChoiceOption() {
        String optionString = jComboBoxCorrectAnswer.getSelectedItem().toString();

        OptionType option = OptionType.valueOf(optionString);
        return option;
    }

    public String getOptionAText() {
        return jTextFieldOptionA.getText();
    }

    public String getOptionBText() {
        return jTextFieldOptionB.getText();
    }

    public String getOptionCText() {
        return jTextFieldOptionC.getText();
    }

    public void initializeControlValues() {
        jComboBoxQuestionType.setSelectedItem(QuestionType.getEnumDescription(QuestionType.Question));
        jTextFieldQuestion.setText("");
        jTextAreaCorrectAnswer.setText("");
        jTextFieldMark.setText("");
        jTextFieldMaxWordCount.setText("250");
        jComboBoxCorrectAnswer.setSelectedItem(OptionType.A);
        jTextFieldOptionA.setText("");
        jTextFieldOptionB.setText("");
        jTextFieldOptionC.setText("");
    }

    public String getSearchFilter() {
        return jTextFieldSearch.getText();
    }

    public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void showErrorMessageDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Dialog",
                JOptionPane.WARNING_MESSAGE);
    }

    public void cleanSearchFilter() {
        jTextFieldSearch.setText("");
    }

    private void FilterNumbersOnTextField(KeyEvent evt) {
        char input = evt.getKeyChar();

        try {
            Integer parseInt = Integer.parseInt(String.valueOf(input));
        } catch (Exception exception) {
            evt.consume();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxQuestionType = new javax.swing.JComboBox<>();
        jLabelQuestionText = new javax.swing.JLabel();
        jTextFieldQuestion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaCorrectAnswer = new javax.swing.JTextArea();
        jLabelCorrectAnswer = new javax.swing.JLabel();
        jLabelMark = new javax.swing.JLabel();
        jTextFieldMark = new javax.swing.JTextField();
        jTextFieldMaxWordCount = new javax.swing.JTextField();
        jLabelMaxWordCount = new javax.swing.JLabel();
        jLabelMultipleChoiceCorrectOptions = new javax.swing.JLabel();
        jComboBoxCorrectAnswer = new javax.swing.JComboBox<>();
        jButtonDelete = new javax.swing.JButton();
        jButtonPrint = new javax.swing.JButton();
        jLabelMultipleChoiceAnswers = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jTextFieldOptionA = new javax.swing.JTextField();
        jTextFieldOptionB = new javax.swing.JTextField();
        jTextFieldOptionC = new javax.swing.JTextField();
        jLabelOptionA = new javax.swing.JLabel();
        jLabelOptionB = new javax.swing.JLabel();
        jLabelOptionC = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jButtonAnswer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quiz App");

        jLabel1.setText("Question type");

        jComboBoxQuestionType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxQuestionTypeActionPerformed(evt);
            }
        });

        jLabelQuestionText.setText("Question");

        jTextAreaCorrectAnswer.setColumns(20);
        jTextAreaCorrectAnswer.setRows(5);
        jScrollPane2.setViewportView(jTextAreaCorrectAnswer);

        jLabelCorrectAnswer.setText("Correct answer");

        jLabelMark.setText("Mark");

        jTextFieldMark.setColumns(10);
        jTextFieldMark.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMarkKeyTyped(evt);
            }
        });

        jTextFieldMaxWordCount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMaxWordCountKeyTyped(evt);
            }
        });

        jLabelMaxWordCount.setText("Max word count");

        jLabelMultipleChoiceCorrectOptions.setText("Correct answer options");

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonPrint.setText("Print");
        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        jLabelMultipleChoiceAnswers.setText("Multiple choice options");

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jTextFieldOptionA.setText("Option A");

        jTextFieldOptionB.setText("Option B");

        jTextFieldOptionC.setText("Option C");

        jLabelOptionA.setText("Option A");
        jLabelOptionA.setToolTipText("");

        jLabelOptionB.setText("Option B");
        jLabelOptionB.setToolTipText("");

        jLabelOptionC.setText("Option C");
        jLabelOptionC.setToolTipText("");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Question type", "Question"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(30);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(1).setMinWidth(100);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jButtonAnswer.setText("Answer");
        jButtonAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnswerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMaxWordCount)
                                    .addComponent(jLabelMark)
                                    .addComponent(jLabelMultipleChoiceCorrectOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldMark, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldMaxWordCount, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxCorrectAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jComboBoxQuestionType, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextFieldOptionA, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelCorrectAnswer)
                                        .addComponent(jLabelQuestionText))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                                        .addComponent(jTextFieldQuestion)))))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMultipleChoiceAnswers, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelOptionA, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelOptionB, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelOptionC, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(46, 46, 46)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldOptionB)
                                        .addComponent(jTextFieldOptionC, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPrint)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonAnswer)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabelQuestionText))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxQuestionType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCorrectAnswer)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMark)
                    .addComponent(jTextFieldMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMaxWordCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMaxWordCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCorrectAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMultipleChoiceCorrectOptions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelMultipleChoiceAnswers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldOptionA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOptionA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldOptionB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOptionB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldOptionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOptionC))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonPrint)
                    .addComponent(jButtonDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch)
                    .addComponent(jButtonAnswer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(jScrollPane2);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jComboBoxQuestionTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxQuestionTypeActionPerformed
        Object item = jComboBoxQuestionType.getSelectedItem();
        QuestionType questionType = QuestionType.getEnum(item.toString());

        mediator.SelectQuestion(questionType);
    }//GEN-LAST:event_jComboBoxQuestionTypeActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        this.mediator.AddQuestion();
    }//GEN-LAST:event_jButtonAddActionPerformed

    //The idea is from https://youtu.be/YA88rtqqtz0
    //But I simplified
    private void jTextFieldMarkKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMarkKeyTyped
        FilterNumbersOnTextField(evt);
    }//GEN-LAST:event_jTextFieldMarkKeyTyped

    private void jTextFieldMaxWordCountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMaxWordCountKeyTyped
        FilterNumbersOnTextField(evt);
    }//GEN-LAST:event_jTextFieldMaxWordCountKeyTyped

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        int rowIndex = jTable1.getSelectedRow();
        if (rowIndex < 0) {
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int questionId = (int) model.getValueAt(rowIndex, 0);

        mediator.deleteRow(questionId);
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
        int questionId = getSelectedQuestionId();
        if (questionId < 0) {
            return;
        }

        mediator.printQuestion(questionId);
    }//GEN-LAST:event_jButtonPrintActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        String searchText = jTextFieldSearch.getText();
        mediator.SearchQuestions(searchText);
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnswerActionPerformed
        int questionId = getSelectedQuestionId();
        if (questionId < 0) {
            return;
        }

        mediator.answerQuestion(questionId);
    }//GEN-LAST:event_jButtonAnswerActionPerformed

    private int getSelectedQuestionId() {
        int rowIndex = jTable1.getSelectedRow();
        if (rowIndex < 0) {
            return -1;
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int questionId = (int) model.getValueAt(rowIndex, 0);

        return questionId;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuizJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAnswer;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox<String> jComboBoxCorrectAnswer;
    private javax.swing.JComboBox<String> jComboBoxQuestionType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCorrectAnswer;
    private javax.swing.JLabel jLabelMark;
    private javax.swing.JLabel jLabelMaxWordCount;
    private javax.swing.JLabel jLabelMultipleChoiceAnswers;
    private javax.swing.JLabel jLabelMultipleChoiceCorrectOptions;
    private javax.swing.JLabel jLabelOptionA;
    private javax.swing.JLabel jLabelOptionB;
    private javax.swing.JLabel jLabelOptionC;
    private javax.swing.JLabel jLabelQuestionText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaCorrectAnswer;
    private javax.swing.JTextField jTextFieldMark;
    private javax.swing.JTextField jTextFieldMaxWordCount;
    private javax.swing.JTextField jTextFieldOptionA;
    private javax.swing.JTextField jTextFieldOptionB;
    private javax.swing.JTextField jTextFieldOptionC;
    private javax.swing.JTextField jTextFieldQuestion;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables

}
