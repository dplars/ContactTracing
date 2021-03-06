/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.Iterator;
import java.util.List;
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

    @PersistenceContext private EntityManager em;
    
    public DBBean() {
    }
    
    public String getTestBurgernaam(int testnr) {
        System.out.println("zoek burger van test");
        Test t;
        Burger b;
        try {
            // met testnr de persoon id opzoeken en daarmee de naam van de persoon weergeven
            t = (Test) (em.createNamedQuery("Test.findByTid").setParameter("tid", testnr).getSingleResult());
            System.out.println("Test gevonden "+t.toString());
            System.out.println("Persoon nummer = "+t.getPid().toString());
            em.merge(t);
            
            
            }
        catch (NoResultException e) {
            System.out.println("Geen Test gevonden");
            System.out.println(e);
            return "Geen test";
        }
        catch (Exception e) {
            System.out.println("Een fout opgetreden in getTestBurgernaam");
            System.out.println(e);
            return null;
        }
        try {
            // burger zoeken
            b = (Burger) (em.createNamedQuery("Burger.findByBid").setParameter("bid", t.getPid()).getSingleResult());
            System.out.println("Burger gevonden "+b.toString());
            
            return b.getNaam();
            }
        catch (NoResultException e) {
            System.out.println("Geen burger gevonden");
            System.out.println(e);
            return "Geen burger";
        }
        catch (Exception e) {
            System.out.println("Een fout opgetreden in getTestBurgernaam");
            System.out.println(e);
            return null;
        }    
    }
    
    public Boolean schrijfTestWeg(int testnr, String testresultaat) {
        int res = 0;
        if(testresultaat.equals("positief")) {
            res = 1;
        }
        else {
            res = 2;
        }
        Test t;
        try {
            t = (Test) (em.createNamedQuery("Test.findByTid").setParameter("tid", testnr).getSingleResult());
            t.setTestresultaat(res);
            return true;
        }
        catch (NoResultException e) {
            System.out.println("Geen test gevonden");
            System.out.println(e);
            return false;
        }
        catch (Exception e) {
            System.out.println("Grote fout");
            System.out.println(e);
            return false;
        }
    }
    
    public Boolean testEmpty(int testnr) {
        Test t;
        try {
            t = (Test) (em.createNamedQuery("Test.findByTid").setParameter("tid", testnr).getSingleResult());
            if(t.getTestresultaat() == 0) {
                return true;
            }
            else {
                return false;
            }
        }
        catch (NoResultException e) {
            System.out.println("Geen test gevonden");
            System.out.println(e);
            return false;
        }
        catch (Exception e) {
            System.out.println("Grote fout");
            System.out.println(e);
            return false;
        }
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
    public List getSortedBid() {
        return em.createNamedQuery("Burger.findSortedBid").getResultList();
    }
    public List getBurgersNaam() {
        return em.createNamedQuery("Burger.findAllNaam").getResultList();
    }
    public List getBurgersTele() {
        return em.createNamedQuery("Burger.findAllTele").getResultList();
    }
    public void nieuwContact(int id1,int id2,int type) {
        int ncid = 1;
        try{
            Integer lknr = (Integer)em.createNamedQuery("Contact.laatsteKnr").getSingleResult();
            ncid = lknr.intValue() + 1;
        }catch(Exception e){
            
        }
        System.out.println("data:");
        System.out.println(ncid);
        System.out.println(id1);
        System.out.println(id2);
        System.out.println(type);
        Contact res = new Contact(ncid);
        //res.setCid(ncid);
        res.setPersoon1(id1);
        res.setPersoon2(id2);
        res.setType(type);
        
        em.persist(res);   
    }
}
