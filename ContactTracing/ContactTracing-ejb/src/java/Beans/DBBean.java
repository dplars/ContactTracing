/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author larsdepauw
 */
@Stateless
public class DBBean implements DBBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext private EntityManager em;
    
    public DBBean() {
        
    }
    
    public String getTestBurgernaam(int testnr) {
        
        // met testnr de persoon id opzoeken en daarmee de naam van de persoon weergeven
        Test t = (Test) em.createNamedQuery("Test.FindByTid").setParameter("tid", testnr).getSingleResult();
       
        // burger zoeken
        Burger b = (Burger) em.createNamedQuery("Burger.FindByBID").setParameter("bid", t.getTid()).getSingleResult();
        
        return b.getNaam();
    }
}
