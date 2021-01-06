/* Loic Dehan Lars De Pauw
 */
package Controller;
import Beans.DBBeanLocal;
import Beans.Test;
import java.util.ArrayList;


import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * @author r0714500
 */
public class ResController extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @EJB private DBBeanLocal dbbean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }    
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    HttpSession sessie = request.getSession(true);    
    System.out.println("In resController doPost");

    int id; 
    int testnr = 0;
    
    String testResultaat;
    String msg;
    //SessionContext ctx = null;
    switch (request.getParameter("sub")) {
            
            // hoofd pagina index.jsp
            case "registreer":    
                gotoPage("registreer.jsp",request,response);
                break;
            case "burger":  
                gotoPage("burger/burger.jsp",request,response);
                break;
            case "arts":   
                gotoPage("arts/arts.jsp",request,response);
                break;
            
            // arts.jsp
            case "doorgaan": // komende van arts.jsp, gaande naar bevestig.jsp
                testnr = Integer.parseInt(request.getParameter("testnr"));
                testResultaat = request.getParameter("testresultaat");
                
                // gegevens opslaan in session variabelen
                sessie.setAttribute("testnr", testnr); 
                sessie.setAttribute("testResultaat", testResultaat);
                
                System.out.println("testnummer "+testnr);
                if(dbbean.testEmpty(testnr)) {
                    String burgernaam = dbbean.getTestBurgernaam(testnr);
                    if (burgernaam != null) {

                        if (burgernaam.equals("Geen burger")) {
                            String err = "Geen geldige burger gevonden";
                            sessie.setAttribute("error", err);
                            gotoPage("arts/arts.jsp",request, response);
                        }
                        else if (burgernaam.equals("Geen test")) {
                            String err = "Geen geldige test nummer ingegeven";
                            sessie.setAttribute("error", err);
                            gotoPage("arts/arts.jsp",request, response);
                        }
                        else {
                            //request.setAttribute("burgernaam", burgernaam); 
                            sessie.setAttribute("burgernaam", burgernaam);
                            System.out.println("burgernaam "+ burgernaam);
                            gotoPage("arts/bevestig.jsp", request, response);
                        }
                    }
                    else {
                        // er is een grotere fout gebeurt
                        String err = "Een grote fout gebeurt!";
                            sessie.setAttribute("error", err);
                            gotoPage("arts/arts.jsp",request, response);
                    }
                }
                else {
                    // Test is niet leeg
                    String err = "Deze test is al ingevuld!";
                    sessie.setAttribute("error", err);
                    gotoPage("arts/arts.jsp",request, response);
                }
                System.out.println("einde van doorgaan");
                break;
            // bevestig.jsp
            case "ntcorrect":
                msg = "Vul testresultaat opnieuw in";
                sessie.setAttribute("msg", msg);
                sessie.setAttribute("testnr", testnr);
                gotoPage("arts/arts.jsp", request, response);
                break;
            case "correct":
                testResultaat = (String) sessie.getAttribute("testResultaat");
                testnr = (int) sessie.getAttribute("testnr");
                
                if(dbbean.schrijfTestWeg(testnr, testResultaat)) {
                    msg = "Test "+testnr+" correct weggeschreven!";
                    request.setAttribute("msg", msg);
                }
                else {
                    String err = "Kon test "+testnr+" niet wegschrijven!";
                    request.setAttribute("error", err);
                    request.setAttribute("testnr", testnr);
                }
                gotoPage("arts/arts.jsp", request, response);
                break;
                
            // burger.jsp
            case "burgerContact":
                setSessionId(request);
                setMelding(request);
                gotoPage("burger/contact.jsp", request, response);
                break;   
            case "NieuwContact": 
                //Contact toevoegen tussen ingelogde persoon, geselecteerde burger en type
                int ID1 = (int) sessie.getAttribute("id");
                int contactId = Integer.parseInt(request.getParameter("Sburger"));  // id van de gezochte contactpersoon ophalen
                int typeContact = Integer.parseInt(request.getParameter("typeContact"));
                System.out.println("Gegeven:\n"+"\tType:"+typeContact+"\tContactID:"+contactId+"\tEigenID:"+ID1);
                dbbean.nieuwContact(ID1,contactId,typeContact);     // contact toevoegen aan database

                setMelding(request);
                gotoPage("burger/contact.jsp", request, response);
                break;
                
            // op burger status pagina op nieuwe test geklikt
            case "nieuweTest":
                id = (int)sessie.getAttribute("id");
                dbbean.nieuweTest(id);
                gotoBurgerTest(request, response);
                break;
                
            // burger.jsp
            case "burgerTest":
                setSessionId(request);
                gotoBurgerTest(request, response);
                break;
            case "burgerStatus":
                setSessionId(request);  
                gotoBurgerStatus(request, response);
                break;
                
            // index.jsp
            case "nieuwAccount":
                
                String type = request.getParameter("type");
                String unaam = request.getParameter("unaam");
                String naam = request.getParameter("naam");
                String telnr = request.getParameter("nr");
                String password = request.getParameter("pw");
            
                // gegevens verwerken en gebruiker aanmaken. 
                dbbean.nieuwAccount(type, unaam, naam, telnr, password);
                System.out.println("Einde nAccount2");
                
                List burgerLijst = dbbean.getSortedBurgers();
                getServletContext().setAttribute("burgerLijst",burgerLijst);
        
                response.sendRedirect("index.jsp");
                break;
                
            // in footer op terug geklikt
            case "afbreken":  
                sessie.invalidate();
                response.sendRedirect("index.jsp");
                break;
        }
    }
    public void setMelding(HttpServletRequest request){
        HttpSession sessie = request.getSession(true);    
        int id = (int)sessie.getAttribute("id");
        int melding = dbbean.getMelding(id);    // kijken in de database of er meldingen zijn voor de gebruiker
        sessie.setAttribute("melding",melding);
        dbbean.setMelding(id,0);    // melding is gegeven, melding terug op 0 zetten
    }
    public void setSessionId(HttpServletRequest request){
        System.out.println("Start setSessionId");
        HttpSession sessie = request.getSession(true);    
        Principal user;
        user = request.getUserPrincipal();
        System.out.println("naam: "+user.getName());
        int id = dbbean.getBid(user.getName());
        System.out.println("Gevonden id:"+id);
        sessie.setAttribute("id", id);
        sessie.setAttribute("naam", user.getName());
    }
    public void gotoBurgerTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // eerst testen ophalen voor naar de test pagina te gaan
        HttpSession sessie = request.getSession(true);
        int id = (int)sessie.getAttribute("id");
        List<Test> testLijst = dbbean.getBurgerTests(id);
        for(Test t:testLijst){
            System.out.println("tid:"+t.getTid());
        }
        getServletContext().setAttribute("testLijst",testLijst);
        
        setMelding(request);
        gotoPage("burger/test.jsp", request, response);
    }
    public void gotoBurgerStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // eerst contacten ophalen dan naar de status pagina gaan
        setMelding(request);
        HttpSession sessie = request.getSession(true);
        int id = (int) sessie.getAttribute("id");
        int score = dbbean.getScore(id);
        sessie.setAttribute("score", score); 
        
        List contacten = dbbean.alleContacten(id);
        sessie.setAttribute("contacten", contacten); 
        gotoPage("burger/status.jsp",request,response);
    }
    public void gotoPage(String page,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        System.out.println("Ga naar:"+page);
        response.sendRedirect(page);        // send redirect om login te laten werken
        //RequestDispatcher view = request.getRequestDispatcher(page);
        //view.forward(request,response);
    }   
    public void init(){        
        System.out.println("init");
        List burgerLijst = dbbean.getSortedBurgers();
        getServletContext().setAttribute("burgerLijst",burgerLijst); 
    }    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
