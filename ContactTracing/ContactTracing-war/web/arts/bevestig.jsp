<%-- 
    Document   : bevestig
    Created on : Nov 3, 2020, 5:44:28 PM
    Author     : dehan
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
       <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" style="margin-top: 10%">
    <div class="row">
		<div class="span12">
                    <div id="legend">
			      <legend class="">Arts</legend>
                    </div>
        <h1>Overzicht voor </h1>
        <h2>Test nummer: ${sessionScope.testnr}</h2>
        Voor klant: ${sessionScope.burgernaam}<br>
        Was de test: <a <c:if test="${sessionScope.testResultaat == 'positief'}">style="color:red"></c:if>
                        <c:if test="${sessionScope.testResultaat == 'negatief'}">style="color:green"></c:if>                                               
            ${sessionScope.testResultaat}
        </a><br>
        Kloppen deze gegevens?
        <form id="bevestigform" action="../ResController" method="POST">
            <button type="submit" value="ntcorrect" name="sub">Deze gegevens zijn niet correct</button>
            <button type="submit" value="correct" name="sub">Deze gegevens zijn correct</button>
        </form>
                </div></div></div>
    </body>
    <jsp:include page="../footer.jsp"/>
</html>
