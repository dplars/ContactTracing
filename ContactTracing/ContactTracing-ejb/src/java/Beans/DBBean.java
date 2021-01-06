/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import static java.lang.Integer.min;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Contact Tracing
 * Loic Dehan en Lars de Pauw
 */
@Stateless
public class DBBean implements DBBeanLocal {

    @PersistenceContext private EntityManager em;
    
    public DBBean() {}
    
    public String getTestBurgernaam(int testnr) {
        System.out.println("zoek burger van test");
        Test t;
        Burger b;
        try {
            // met testnr de persoon id opzoeken en daarmee de naam van de persoon weergeven
            t = (Test) (em.createNamedQuery("Test.findByTid").setParameter("tid", testnr).getSingleResult());
            System.out.println("Test gevonden "+t.toString());
            System.out.println("Persoon nummer = " + t.getPid());
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
            res = 2;
        }
        else{
            res = 1;
        }

        Test t;
        try {
            t = (Test) (em.createNamedQuery("Test.findByTid").setParameter("tid", testnr).getSingleResult());
            t.setTestresultaat(res);
            int pid = t.getPid();
            Burger b = (Burger) (em.createNamedQuery("Burger.findByBid").setParameter("bid", pid).getSingleResult());
            if (res == 2) {
                // positief, burger en contacten aanpassen
                // scores van alle nauwe contacten op 1 zetten (type 1 en type 2) bij positief resultaat
                // get alle contacten;
                List<Contact> contacten = alleContacten(b.getBid());    // geeft volledige contact terug
                for(Contact c: contacten) {
                    int pers1 = c.getPersoon1();
                    Burger b1 = (Burger) (em.createNamedQuery("Burger.findByBid").setParameter("bid", pers1).getSingleResult());
                    b1.setScore(b1.getScore()+1);    // verhoog score met 1
                    em.persist(b1);
                }
                
                b.setScore(b.getScore()+1);
                em.persist(b);
                
            }
            else {
                // negatief, burger op negatief zetten
                b.setScore(0);
                em.persist(b);
            }
            setMelding(pid,2);//2 -> uw testresultaat is beschikbaar
            //b.setScore(res);
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
    public void nieuweTest(int pid){
        int testnr = 0;
        int testRes = 0;
        try{
            testnr = (int) em.createNamedQuery("Test.laatsteTid").getSingleResult();
        }
        catch(Exception e){
            
        }
        testnr +=1;
        System.out.println("nieuwe Test:"+testnr+"->"+pid+":"+testRes);
        
        Test res = new Test();
        res.setTid(testnr);
        res.setTestresultaat(testRes);
        res.setPid(pid);
        System.out.println(res.toString());
        em.persist(res);   
        
    }
    public List getBurgerTests(int pid){
        System.out.println("zoek tests van pid:"+pid);
        return em.createNamedQuery("Test.findBurgerTests").setParameter("pid", pid).getResultList();
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
    public int getMelding(int id){
        System.out.println("Zoek Melding van burger met id:");
        System.out.println(id);
        try{
            Integer melding = (Integer)(em.createNamedQuery("Burger.findMeldingByBid").setParameter("bid", id).getSingleResult());
            System.out.println("Melding gevonden:"+melding);
            return melding;
        } catch(NoResultException e) {
            System.out.println("Geen burger ");
            return 0;
        }
    }
    public boolean setMelding(int id,int val){
        try{
            Burger b1 = (Burger) (em.createNamedQuery("Burger.findByBid").setParameter("bid", id).getSingleResult());
            b1.setMelding(val);
            em.persist(b1);
            return true;
        }
        catch(NoResultException e){
            System.out.println("Geen test gevonden");
            System.out.println(e);
            return false;
        }
        catch(Exception e){
            System.out.println("Grote fout");
            System.out.println(e);
            return false;
        }
    }
    public List getSortedBurgers(){
        return em.createNamedQuery("Burger.findSortedBurgers").getResultList();
    }
    public void nieuwContact(int id1,int id2,int type) {
        //Zoek volgende contactId
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
        res.setPersoon1(id1);
        res.setPersoon2(id2);
        res.setType(type);
        
        em.persist(res);   
        //contact toegevoegd
        //mogelijk score aanpassen:
        Burger contactPersoon = (Burger) (em.createNamedQuery("Burger.findByBid").setParameter("bid", id2).getSingleResult());
        int score = contactPersoon.getScore();
        System.out.println("Score van contactpersoon:"+score);
        if(score>0 && (type == 1 || type == 2)){   
            System.out.println("Gevaar");
            Burger b = (Burger) (em.createNamedQuery("Burger.findByBid").setParameter("bid", id1).getSingleResult());
            b.setScore(b.getScore()+1);     // score van de burger die contact heeft aangemaakt verhogen als de contactpersoon besmet was 
            em.persist(b);
            setMelding(id1,1);
        }
    }
    
    public List alleContacten(int id) {
        //Zoek alle contacten van de gegeven burgerId
        List res = null;
        try{
            res = em.createNamedQuery("Contact.findByPersoon1").setParameter("persoon1", id).getResultList();
        }catch(Exception e){
            
        }
        return res;
    }

    public int getBid(String name) {
        //Zoek de burgerId op basis van de loginNaam
        System.out.println("Start getBid(");
        int bid = 0;
        try{
            Gebruikers g = (Gebruikers) em.createNamedQuery("Gebruikers.findByGebruikersnaam").setParameter("gebruikersnaam", name).getSingleResult();
            bid = (int) em.createNamedQuery("Burger.getBid").setParameter("gebruikersnaam", g).getSingleResult();
        }catch(Exception e){
            System.out.println("Exception"+e);
        }
        System.out.println("Gevonden bid:"+bid);
        return bid;
    }
    
    public void nieuwAccount(String type, String unaam, String naam, String telnr, String password) {
        // gebruiker toevoegen aan Gebruikers
        System.out.println("passwoord meegegeven aan voeg gebruiker toe: "+password);
        Gebruikers gebr = voegGebruikerToe(unaam, password);
        System.out.println("Gebruiker toegevoegd: "+gebr);
        
        // gebruiker toevoegen aan groep
        voegToeAanGroep(unaam, type);
        System.out.println("Gebruiker aan groep toegevoegd: Type/"+type);
        if (type.equals("arts")) {
            int prevAid = (int) em.createNamedQuery("Arts.laatsteAid").getSingleResult();
            int newAid = prevAid +1;
            Arts a = new Arts();
            a.setAid(newAid);
            a.setNaam(newAid);
            em.persist(a);
        }
        else {
            voegBurgerToe(gebr, naam, telnr);
            System.out.println("Burger toegevoegd: ");
        }
    }
    
    // private omdat dit niet apart mag uitgevoerd worden, dan klopt het database systeem niet meer
    private Gebruikers voegGebruikerToe(String unaam, String password) {
        // nieuwe gebruiker aanmaken
        Gebruikers g = new Gebruikers();
        g.setGebruikersnaam(unaam);
        System.out.println("passwoord ingeven: "+password);
        g.setPaswoord(password);
        // gebruiker aan database toevoegen
        em.persist(g);
        return g;
    }
    
    private void voegToeAanGroep(String unaam, String groep) {
        // nieuwe groep entry aanmaken
        Groepen g = new Groepen();
        g.setGebruikersnaam(unaam);
        g.setGroep(groep);
        // voeg gebruiker toe aan groep in database
        em.persist(g);
    }
    
    private void voegBurgerToe(Gebruikers unaam, String naam, String telnr) {
        // zoek hoogste bid om een nieuw bid toe te wijzen
        int prevBid = (int) em.createNamedQuery("Burger.laatsteBid").getSingleResult();
        int newBid = prevBid+1;
        Burger b = new Burger();
        b.setGebruikersnaam(unaam);
        b.setBid(newBid);
        b.setNaam(naam);
        b.setScore(0);
        b.setTelefoonnummer(telnr);
        b.setMelding(0);
        
        em.persist(b);
    }
}
