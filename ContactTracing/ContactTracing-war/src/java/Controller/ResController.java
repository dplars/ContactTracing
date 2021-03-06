/* Loic Dehan Lars De Pauw
 */
package Controller;
import Beans.DBBeanLocal;
import java.util.ArrayList;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
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
    String testResultaat;
    int testnr = 0;
    String msg;
    switch (request.getParameter("sub")) {
            /*
            er staat hier wel vaak  gotoPage("arts/arts.jsp"
            valt misschien te reduceren
            */
            case "ingelogd": 
                id = Integer.parseInt(request.getParameter("id"));
                sessie.setAttribute("id", id);
                if(dbbean.isArts(id)&& dbbean.isBurger(id)){
                    System.out.println("Is beide");
                    gotoPage("keuze.jsp",request,response);
                    //naar een keuze pagina 
                }
                else if(dbbean.isArts(id)){
                    gotoPage("arts.jsp",request,response);
                }
                else if(dbbean.isBurger(id)){

                    gotoBurger(request,response);
                }
                else{
                    gotoPage("registreer.jsp",request,response);
                }
                break;
            case "registreer":    
                gotoPage("registreer.jsp",request,response);
                break;
            case "burger":                

                gotoBurger(request,response);
                break;
            case "arts":    
                gotoPage("arts.jsp",request,response);
                break;
            case "doorgaan":
                // komende van arts.jsp, gaande naar bevestig.jsp
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
                            request.setAttribute("error", err);
                            gotoPage("arts/arts.jsp",request, response);
                        }
                        else if (burgernaam.equals("Geen test")) {
                            String err = "Geen geldige test nummer ingegeven";
                            request.setAttribute("error", err);
                            gotoPage("arts/arts.jsp",request, response);
                        }
                        else {
                            request.setAttribute("burgernaam", burgernaam);

                            System.out.println("burgernaam "+ burgernaam);

                            gotoPage("arts/bevestig.jsp", request, response);
                        }
                    }
                    else {
                        // er is een grotere fout gebeurt
                        String err = "Een grote fout gebeurt!";
                            request.setAttribute("error", err);
                            gotoPage("arts/arts.jsp",request, response);
                    }
                }
                else {
                    // Test is niet leeg
                    String err = "Deze test is al ingevuld!";
                    request.setAttribute("error", err);
                    gotoPage("arts/arts.jsp",request, response);
                }
                
                break;
            case "ntcorrect":
                msg = "Vul testresultaat opnieuw in";
                //if (testnr == 0) {
                //    testnr =  Integer.parseInt((String) sessie.getAttribute("testnr"));
                //}
                
                request.setAttribute("msg", msg);
                request.setAttribute("testnr", testnr);
                //gotoPage("arts.jsp",request, response);
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
            
                
            case "NieuwContact":
                int ID1 = (int) sessie.getAttribute("id");
                int typeContact = Integer.parseInt(request.getParameter("typeContact"));
                int contactId = Integer.parseInt(request.getParameter("Sburger"));
                System.out.println("Gegeven:\n"+"\tType:"+typeContact+"\tContactID:"+contactId+"\tEigenID:"+ID1);
                dbbean.nieuwContact(ID1,contactId,typeContact);
                response.sendRedirect("burger.jsp");
                break;
            case "nieuwAccount":
                response.sendRedirect("index.jsp");
                break;
            case "afbreken":  
                sessie.invalidate();
                response.sendRedirect("index.jsp");
                break;
        }
  
    }
    public void gotoBurger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession sessie = request.getSession(true);
        int id = (int) sessie.getAttribute("id");
        int score = dbbean.getScore(id);
        sessie.setAttribute("score", score); 
        System.out.println("Score: "+score);
        gotoPage("burger.jsp",request,response);
    }
    public void gotoPage(String page,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        System.out.println("Ga naar:"+page);
        response.sendRedirect(page);
        //https://stackoverflow.com/questions/2047122/requestdispatcher-forward-vs-httpservletresponse-sendredirect#:~:text=The%20main%20important%20difference%20between,and%20it's%20visible%20to%20client.
        
        //RequestDispatcher view = request.getRequestDispatcher(page);
        //view.forward(request,response);
    }   
    public void init(){
                
        System.out.println("init");
        List naamLijst = dbbean.getBurgersNaam();
        List teleLijst = dbbean.getBurgersTele();
        List bidLijst = dbbean.getSortedBid();
        getServletContext().setAttribute("burgersNaam",naamLijst);
        getServletContext().setAttribute("burgersTele",teleLijst);
        getServletContext().setAttribute("burgersBid",bidLijst);
        
        System.out.println("Einde init");
         
    }    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

