<%-- 
    Document   : bevestig
    Created on : Nov 3, 2020, 5:44:28 PM
    Author     : dehan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        Was de test: <a <c:if test="${param.testresultaat == 'positief'}">style="color:red"></c:if>
                        <c:if test="${param.testresultaat == 'negatief'}">style="color:green"></c:if>                                               
            ${param.testresultaat}
        </a><br>
        Kloppen deze gegevens?
        <form id="bevestigform" action="ResController" method="POST">
            <button type="submit" value="ntcorrect" name="sub">Deze gegevens zijn niet correct</button>
            <button type="submit" value="correct" name="sub">Deze gegevens zijn correct</button>
        </form>
        
    </body>
    
</html>
