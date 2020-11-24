
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RemoteBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dehan
 */
@Stateless
public class clientDBboon implements clientDBboonRemote {

   @PersistenceContext private EntityManager em;
//hoeveel burgers het systeem gebruiken
   public long aantalBurgers(){
       long aant = 0;
       try{
           aant =(long) em.createNamedQuery("Burger.findAantal").getSingleResult();
       }
       catch(Exception e){
        }
       return aant;
   }
//hoeveel contacten van elke soort er zijn ingegeven
   public long aantalContacten(int Type){
       long aant = 0;
       try{
       aant =(long) em.createNamedQuery("Contact.aantalCont").setParameter("type", Type).getSingleResult();
        System.out.println("aantalContacten Type "+Type +"=>"+aant);
       }
       catch(Exception e){
           System.out.println("Error:"+e);
       }
       
       
       return aant;
   }
//hoeveel tests er al zijn aangevraagd.
   public long aantalTesten(){
       long aant = 0;
       try{
           aant =(long) em.createNamedQuery("Test.findAantal").getSingleResult();
           System.out.println("aantalContacten Type "+aant);
       }
       catch(Exception e){
           System.out.println("Error:"+e);
       }
       return aant;
   }
}

