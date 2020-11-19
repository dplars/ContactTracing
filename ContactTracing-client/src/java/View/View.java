
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
import javax.ejb.EJB;
import RemoteBeans.clientDBboonRemote;
/**
 *
hoeveel burgers het systeem gebruiken
hoeveel contacten van elke soort er zijn ingegeven
hoeveel tests er al zijn aangevraagd.

 * @author student
 */
public class View extends JFrame  implements ActionListener{
    //@EJB private static ClientDBboonRemote DBboon;
    
    private Container pane;
    private JButton knop;
    private JLabel label;
    private JLabel aantalBurgers,burgersVeld,aantalContacten,aantalTest,testVeld;
    Contacten contactenVeld;
    private JTextField textveld,textveld2;
    private Main main;
    
    private final clientDBboonRemote DBboon;
    public View(clientDBboonRemote DBboon){
        this.DBboon = DBboon;
        
        pane = this.getContentPane();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        knop = new JButton("Update");
        this.initKnop();
        label = new JLabel("");
        
        aantalBurgers = new JLabel("Aantal burgers:");
        burgersVeld = new JLabel("x");
        aantalContacten = new JLabel("Aantal Contacten:");
        
        contactenVeld = new Contacten();

        aantalTest = new JLabel("Aantal Tests:");
        testVeld = new JLabel("x");
        GridLayout g = new GridLayout(5,2);
        g.setHgap(10);
        pane.setLayout(g);
        
        pane.add(aantalBurgers);pane.add(burgersVeld);
        pane.add(aantalContacten);pane.add(contactenVeld);
        pane.add(aantalTest);pane.add(testVeld);
        pane.add(label);pane.add(knop);
        pane.setVisible(true);
        this.setVisible(true);
        this.pack();
     
        this.setSize(500,500);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.knop)
        {
            long aantalBurgers = DBboon.aantalBurgers();
            
            this.burgersVeld.setText(Long.toString(aantalBurgers));
                 
            long aant1 = DBboon.aantalContacten(1);
            long aant2 = DBboon.aantalContacten(2);
            long aant3 = DBboon.aantalContacten(3);
            
            contactenVeld.updateTypes(aant1,aant2,aant3);
            
            long aantTesten = DBboon.aantalTesten();
            this.testVeld.setText(Long.toString(aantTesten));
           
        }
    }
    private void initKnop(){
        this.knop.addActionListener(this);
    }
 }   