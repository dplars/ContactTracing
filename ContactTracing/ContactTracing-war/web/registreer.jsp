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
			      <legend class="">Registreren</legend>
                    </div>
        <!--<h1>Registreren:</h1>-->
            <form action="<c:url value='ResController'/>" method="Post">
               
                <input type="radio" id="burger" name="type" value="burger" checked="checked">
                <label for="burger">Burger</label><br>
                <input type="radio" id="arts" name="type" value="dokter">
                <label for="dokter">Dokter</label><br>

                
            Gebruikersnaam: <input type="text" name="unaam" value=""><br>
            Naam:<input type="text" name="naam" value=""><br>
            Telefoonnr.<input type="text" name="nr" value="">
            Wachtwoord:<input type="password" name="pw">
            <input type="hidden" name="sub" value="nieuwAccount"><br>
            <input type="Submit" value="Ok">
            
            


    </form> 
                </div></div></div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
