/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author larsdepauw
 */
@Local
public interface DBBeanLocal {
    
    public String getTestBurgernaam(int testnr);
    
    public void nieuweTest(int pid);
    
    public List getBurgerTests(int pid);

    public int getScore(int id);
    
    public int getMelding(int id);
    
    public boolean setMelding(int id,int val);
    
    public Boolean schrijfTestWeg(int testnr, String testresultaat);
    
    public Boolean testEmpty(int testnr);

    public List alleContacten(int id);
    
    public List getSortedBurgers();

    public void nieuwContact(int id1,int id2,int type);

    public int getBid(String name);

    public void nieuwAccount(String type, String unaam, String naam, String telnr, String password);
    
}
