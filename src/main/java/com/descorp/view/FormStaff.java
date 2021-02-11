package com.descorp.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author David
 * @author Giovanni
 */
public class FormStaff extends JPanel {
    
    
    public FormStaff(JFrame parent) throws ParseException {
        
        //this.setSize(parent.getSize().width, parent.getSize().height);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(10, 10, 10, 10);
        
        JLabel nameLabel = new JLabel("Nome");
        JTextField nameField = new JTextField(30);
        nameField.setSize(300, 100);
        
        JLabel docLabel = new JLabel("CPF");
        MaskFormatter docMask = new MaskFormatter("###.###.###-##");

        JFormattedTextField  docField = new JFormattedTextField (docMask);
        docField.setSize(300, 100);
        
        JLabel phoneLabel = new JLabel("Telefone");
        MaskFormatter phoneMask = new MaskFormatter("(##) #####-####");
        JFormattedTextField phoneField = new JFormattedTextField(phoneMask);
        phoneField.setSize(300, 100);
        
        JButton btn = new JButton("Cadastrar");
        
        //TODO refactor
//        JComponent a[] = {nameLabel, nameField, docLabel, docField, phoneLabel, phoneField};;
//        this.append(a, gc);
        
        gc.gridx = 0;
        gc.gridy = 0;
        this.add(nameLabel, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        this.add(nameField, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        this.add(docLabel, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        this.add(docField, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        this.add(phoneLabel, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        this.add(phoneField, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        this.add(btn, gc);
    }
    
    private void append(JComponent arr[], GridBagConstraints gc){
        
        if(arr != null){
            
            for(int i =0; i < arr.length; i++) {
                this.add(arr[i]);
            }
        }
    }
}
