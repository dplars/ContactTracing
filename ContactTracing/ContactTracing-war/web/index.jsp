<%-- 
    Document   : index
    Created on : 28-sep-2020, 13:53:48
    Author     : r0714500 (Loic Dehan)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="<c:url value='ResController'/>" method="Post">
             
            Geef hieronder uw accountnummer<br>
            Nummer <input type="text" name="accountnummer" value=""><br>
            <input type="hidden" name="sub" value="burger">
            <input type="Submit" value="Volgend">

        </form> 
        
        </form> 
        <h2>Registreer?</h2>
         <form action="ResController" method="Post">       
                <input type="hidden" name="sub" value="registreer">
                <input type="Submit" value="registreer?">
        </form>
        
        Tijdelijke shortcuts naar arts/burgerpagina?
        Moet op basis van klantnummer naar juiste gaan
         <form action="ResController" method="Post">       
                <input type="hidden" name="sub" value="burger">
                <input type="Submit" value="Burger?">
        </form>
        </form> 
        
         <form action="ResController" method="Post">       
                <input type="hidden" name="sub" value="arts">
                <input type="Submit" value="Arts?">
        </form>
    </body>
    
    <jsp:include page="footer.jsp"/>
</html>
