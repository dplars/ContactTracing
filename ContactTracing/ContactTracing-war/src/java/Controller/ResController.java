/* Loic Dehan Lars De Pauw
 */
package Controller;
import Beans.DBBeanLocal;
import java.util.ArrayList;


import java.io.IOException;
import java.io.PrintWriter;
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
    
    int id; 
    switch (request.getParameter("sub")) {        
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
                    gotoBurger(id,"burger.jsp",request,response);
                }
                else{
                    gotoPage("registreer.jsp",request,response);
                }
                break;
            case "registreer":    
                gotoPage("registreer.jsp",request,response);
                break;
            case "burger":   
                id = 3;
                sessie.setAttribute("id", id);             
                gotoBurger(id,"burger.jsp",request,response);
                break;
            case "arts":    
                gotoPage("arts.jsp",request,response);
                break;
            case "doorgaan":
                // komende van arts.jsp, gaande naar bevestig.jsp
                String testnr = request.getParameter("testnr");
                String resultaat = request.getParameter("testresultaat");
                // gegevens opslaan in session variabelen
               
                sessie.setAttribute("testnr", testnr); 
                
                String burgernaam = dbbean.getTestBurgernaam(Integer.parseInt(testnr));
                request.setAttribute("burgernaam", burgernaam);
                // naar klant.jsp gaan in plaats van naar reserveer.jsp
                goToPage("bevestig.jsp", request, response);
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
    public void gotoBurger(int id,String page,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int score = dbbean.getScore(id);
        HttpSession sessie = request.getSession(true);
        sessie.setAttribute("score", score); 
        System.out.println("Score: "+score);
        gotoPage("burger.jsp",request,response);
    }
    public void gotoPage(String page,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        RequestDispatcher view = request.getRequestDispatcher(page);
        view.forward(request,response);
    }   
    public void init(){
        
        
    }    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void goToPage(String jspPage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // encode url om ook een session id te sturen wanneer geen cookies toegelaten zijn
        RequestDispatcher view = request.getRequestDispatcher(response.encodeURL(jspPage));
        view.forward(request, response);
    }
    
}

