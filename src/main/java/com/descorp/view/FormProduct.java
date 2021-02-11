package com.descorp.view;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author David
 * @author Giovanni
 */
public class FormProduct extends JPanel {
    
    
    public FormProduct(JFrame parent) {
        this.setSize(parent.getSize().width, parent.getSize().height);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        JLabel nameLabel = new JLabel("Nome");
        JTextField nameField = new JTextField();
        nameField.setSize(300, 100);

        JLabel priceLabel = new JLabel("Preço");
        JTextField priceField = new JTextField();
        nameField.setSize(300, 100);
        
        JComponent a[] = {nameLabel, nameField, priceLabel, priceField};
        this.append(a);
    }

    private void append(JComponent arr[]){
        
        if(arr != null){
            
            for(int i =0; i < arr.length; i++) {
                this.add(arr[i]);
            }
        }

    }
}
