package com.descorp.view;

import java.text.ParseException;
import javax.swing.JFrame;

/**
 *
 * @author David
 * @author Giovanni
 */
public class MainWindow extends JFrame {
    
    
    public MainWindow(int w, int h) throws ParseException {
        
        this.setSize(w, h);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(new FormStaff(this));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
