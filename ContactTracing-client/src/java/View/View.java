/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author r0714500
 */

import javax.swing.*;
import java.awt.*;
import contacttracingclient.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
hoeveel burgers het systeem gebruiken
hoeveel contacten van elke soort er zijn ingegeven
hoeveel tests er al zijn aangevraagd.

 * @author student
 */
public class View extends JFrame  implements ActionListener{
    private Container pane;
    private JButton knop;
    private JLabel label;
    private JLabel aantalBurgers,burgersVeld,aantalContacten,contactenVeld,aantalTest,testVeld;
    private JTextField textveld,textveld2;
    private Main main;
 
    
    public View(){
      
        
        pane = this.getContentPane();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        knop = new JButton("Ok");
        this.initKnop();
        label = new JLabel("Update");
        textveld = new JTextField();
        textveld2 = new JTextField();
        
        aantalBurgers = new JLabel("Aantal burgers:");
        burgersVeld = new JLabel("x");
        aantalContacten = new JLabel("Aantal Contacten:");
        
        Contacten contactenVeld = new Contacten();
        //contactenVeld = new JLabel("x");
        
        
        aantalTest = new JLabel("Aantal Tests:");
        testVeld = new JLabel("x");
        GridLayout g = new GridLayout(5,2);
        g.setHgap(10);
        pane.setLayout(g);
        
        pane.add(label);
        pane.add(knop);
        
        pane.add(textveld);
        pane.add(textveld2);
        pane.add(aantalBurgers);
        pane.add(burgersVeld);
        pane.add(aantalContacten);
       
        pane.add(contactenVeld);
        pane.add(aantalTest);
        pane.add(testVeld);
        pane.setVisible(true);
        this.setVisible(true);
        this.pack();
     
        this.setSize(500,500);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.getKnop())
        {
            this.updateTextveld("Updated");
            
        }
    }
    private void initKnop(){
        this.knop.addActionListener(this);
    }

    public int getAantalDagen(){
        return Integer.parseInt(this.textveld.getText());
    }
    
    public void updateTextveld(String value){
        this.label.setText(value);
    }
    
    public Container getPane() {
        return pane;
    }

    public void setPane(Container pane) {
        this.pane = pane;
    }

    public JButton getKnop() {
        return knop;
    }

    public void setKnop(JButton knop) {
        this.knop = knop;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel labeltje) {
        this.label = labeltje;
    }

    public JTextField getTextveld() {
        return textveld;
    }

    public void setTextveld(JTextField textveld) {
        this.textveld = textveld;
    }

}