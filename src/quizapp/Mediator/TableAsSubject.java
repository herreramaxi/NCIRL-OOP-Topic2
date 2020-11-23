/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapp.Mediator;

import quizapp.Interfaces.ISubject;
import quizapp.Interfaces.IObserver;
import quizapp.Questions.Question;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maximiliano Herrera
 */
public class TableAsSubject implements ISubject {

    private final JTable table;
    private ArrayList<IObserver> observers;

    public TableAsSubject(JTable table) {
        this.observers = new ArrayList<IObserver>();
        this.table = table;
    }

    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void Notify() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }

    public int getRowCount() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        return model.getRowCount();
    }

    public void updateModel(ArrayList<Question> questions) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[3];
        model.setRowCount(0);
        for (int i = 0; i < questions.size(); i++) {
            row[0] = questions.get(i).getId();
            row[1] = questions.get(i).getTypeName();
            row[2] = questions.get(i).getQuestionText();
            model.addRow(row);
        }

        this.Notify();
    }
}
