<%-- 
    Document   : klant
    Created on : 5-okt-2020, 13:52:54
    Author     : r0714500
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
        <h1>Registreren:</h1>
            <form action="<c:url value='ResController'/>" method="Post">
               
                <input type="radio" id="male" name="type" value="burger" checked="checked">
                <label for="burger">Burger</label><br>
                <input type="radio" id="female" name="type" value="dokter">
                <label for="dokter">Dokter</label><br>

                
                
            Naam:<input type="text" name="naam" value=""><br>
            Adres:<input type="text" name="Adres" value=""><br>
            Gemeente:<input type="text" name="GemeenteID" value="">
            <input type="text" name="Gemeente" value=""><br>
            <input type="hidden" name="verstopt" value="nieuwAccount"><br>
            <input type="Submit" value="Ok">
            
            


    </form> 
       
    </body>
    <jsp:include page="footer.jsp"/>
</html>
