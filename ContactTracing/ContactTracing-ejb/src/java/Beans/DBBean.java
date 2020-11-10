/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
        /*
        opgelot:
        .getSingleResult() geeft een NoresultException als er niks is
        Gebruik:
        List<Test> ... = ... .getResultList();
        of try - catch
        
        */
        // met testnr de persoon id opzoeken en daarmee de naam van de persoon weergeven
        Test t = (Test) em.createNamedQuery("Test.FindByTid").setParameter("tid", testnr).getSingleResult();
       
        // burger zoeken
        Burger b = (Burger) em.createNamedQuery("Burger.FindByBID").setParameter("bid", t.getTid()).getSingleResult();
        
        return b.getNaam();
    }
    public int getScore(int id){
        System.out.println("Zoek score van burger met id:");
        System.out.println(id);
        try{
            Integer score = (Integer)(em.createNamedQuery("Burger.findScoreByBid").setParameter("bid", id).getSingleResult());
            System.out.println("Score gevonden ");
            return score;
        } catch(NoResultException e) {
            System.out.println("Geen burger ");
            return 100;
        }
    }
    public boolean isArts(int id){
        System.out.println("Zoek arts met id:");
        System.out.println(id);
        try{
            Object a = (em.createNamedQuery("Arts.findByAid").setParameter("aid", id).getSingleResult());
            System.out.println("Arts gevonden ");
            return true;
        } catch(NoResultException e) {
            System.out.println("Geen arts ");
            return false;
        }
    }
    public boolean isBurger(int id) {
        System.out.println("Zoek burger met id:");
        System.out.println(id);
            
        try{
            Object a = em.createNamedQuery("Burger.findByBid").setParameter("bid", id).getSingleResult();
            System.out.println("Burger gevonden ");
            return true;
        } catch(NoResultException e) {
            System.out.println("Geen Burber ");
            return false;
        }
    }
}
