<%-- 
    Document   : keuze
    Created on : Nov 9, 2020, 9:14:42 PM
    Author     : dehan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Inloggen als:</h1>
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
</html>
