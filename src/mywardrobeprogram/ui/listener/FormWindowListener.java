/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mywardrobeprogram.ui.listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Natalia Luiz
 */
public class FormWindowListener implements WindowListener{

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
        we.getComponent().setVisible(false);
    }

    @Override
    public void windowClosed(WindowEvent we) {
        we.getComponent().setVisible(false);
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }
    
}
