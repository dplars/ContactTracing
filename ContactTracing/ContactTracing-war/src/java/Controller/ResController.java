/* Loic Dehan Lars De Pauw
 */
package Controller;
import java.util.ArrayList;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
        
        switch (request.getParameter("sub")) {
            case "doorgaan":
                // komende van arts.jsp, gaande naar artsoverzicht.jsp
                String testnr = request.getParameter("testnr");
                // gegevens opslaan in session variabelen
                request.getSession(true).setAttribute("testnr", testnr);
                // naar klant.jsp gaan in plaats van naar reserveer.jsp
                goToPage("artsoverzicht.jsp", request, response);
                break;
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
    String verstopt = request.getParameter("verstopt");
    if(verstopt.equals("naarReserveer") || verstopt.equals("nieuwReserveer")){
        if (sessie.getAttribute("klantnummer") == null) //de klant bestaat nog niet in de sessie
            {
                String klantnummer = request.getParameter("klantnummer");
                sessie.setAttribute("klantnummer",klantnummer);
            }
   
        gotoPage("reserveer.jsp",request,response);
     
    }
    else if(verstopt.equals("registreer")){
        sessie.setAttribute("klantnummer",99999);
        gotoPage("registreer.jsp",request,response);
      
    }
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

