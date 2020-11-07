<%-- 
    Document   : bevestig
    Created on : Nov 3, 2020, 5:44:28 PM
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
        <h1>Overzicht voor </h1>
        <h2>Test nummer: ${sessionScope.testnr}</h2>
        
        Voor klant: ${requestScope.burgernaam}<br>
        Was de test: ${requestScope.testresultaat}
        Kloppen deze gegevens?
        <form id="bevestigform">
            <button type="submit" value="ntcorrect" name="ntcorrect">Deze gegevens zijn niet correct</button>
            <button type="submit" value="correct" name="correct">Deze gegevens zijn correct</button>
            
        </form>
    </body>
</html>
