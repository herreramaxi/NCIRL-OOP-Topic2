/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapp.Mediator;

import quizapp.Interfaces.IObserver;
import javax.swing.SwingUtilities;

/**
 *
 * @author Maximiliano Herrera
 */
public class UIComponentObserver implements IObserver {

    private final Runnable _function;

    public UIComponentObserver(Runnable function) {
        _function = function;
    }

    @Override
    public void update() {
        SwingUtilities.invokeLater(_function);
    }
}
