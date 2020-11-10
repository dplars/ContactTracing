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

    public boolean isArts(int id);

    public boolean isBurger(int id);

    public int getScore(int id);
    
    public Boolean schrijfTestWeg(int testnr, String testresultaat);
    
    public Boolean testEmpty(int testnr);

    public List getBurgersNaam();
    public List getBurgersTele();
    public List getSortedBid();
    public void nieuwContact(int id1,int id2,int type);

}
