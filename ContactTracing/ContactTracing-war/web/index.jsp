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
         
        <h2>Burger?</h2>
         <form action="ResController" method="Post">       
                <input type="hidden" name="verstopt" value="burger">
                <input type="Submit" value="Burger?">
        </form>
        </form> 
        <h2>Arts?</h2>
         <form action="ResController" method="Post">       
                <input type="hidden" name="verstopt" value="arts">
                <input type="Submit" value="Arts?">
        </form>
        </form> 
        <h2>Registreer?</h2>
         <form action="ResController" method="Post">       
                <input type="hidden" name="verstopt" value="registreer">
                <input type="Submit" value="registreer?">
        </form>
        
    </body>
    
    <jsp:include page="footer.jsp"/>
</html>
