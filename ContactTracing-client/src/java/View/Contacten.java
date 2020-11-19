/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import contacttracingclient.Main;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dehan
 */
public class Contacten extends JPanel{
    private Container pane;

    private JLabel aantalType1,type1Veld,aantalType2,type2Veld,aantalType3,type3Veld;
    
    public Contacten(){
        
        aantalType1 = new JLabel("Aantal Type1:");
        type1Veld = new JLabel("x");
        aantalType2 = new JLabel("Aantal Type2:");
        type2Veld = new JLabel("x");
        aantalType3 = new JLabel("Aantal Type3:");
        type3Veld = new JLabel("x");
       
        setLayout( new GridLayout(3,2));
    
        add(aantalType1);
        add(type1Veld);
        add(aantalType2);
        add(type2Veld);
        add(aantalType3);
        add(type3Veld);

 
    }
    public void updateTypes(long aant1,long aant2,long aant3){
         this.type1Veld.setText(Long.toString(aant1));
         this.type2Veld.setText(Long.toString(aant2));
         this.type3Veld.setText(Long.toString(aant3));
    }   
   

}
