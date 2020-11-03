<%-- 
    Document   : arts
    Created on : Nov 3, 2020, 5:09:57 PM
    Author     : dehan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Artsen</title>
    </head>
    <body>
        <h1>Dit is de arts pagina</h1>
        <form method="POST" action="ResController">
            <label for="testnr">Nummer van de test</label>
            <input type="number" id="testnr" name="testnr"/>
            
            <label for="testpositief">Positief</label>
            <input type="radio" id="testpositief" name="testresultaat" value="positief"/>
            <label for="testnegatief">Negatief</label>
            <input type="radio" id="testnegatief" name="testresultaat" value="negatief"/>
            
            <input type="submit" name="sub" value="doorgaan"/>
        </form>
    </body>
    
    <jsp:include page="footer.jsp"/>
</html>
