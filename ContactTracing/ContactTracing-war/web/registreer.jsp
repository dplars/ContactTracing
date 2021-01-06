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
        <!--<h1>Registreren:</h1>  style="width:200px; margin-left: auto; margin-right: auto"-->
                <form class="form-horizontal" action="<c:url value='ResController'/>" method="Post">
                    <fieldset>
                        <div class="control-group">
                            <label class="control-label" for="burger">Burger</label>
                                <input type="radio" id="burger" name="type" value="burger" checked="checked" style="margin-left: 30px"><br>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="dokter">Dokter</label>
                                <input type="radio" id="arts" name="type" value="arts" style="margin-left: 30px"><br>
                        </div>

                        <div class="control-group">
                            <label class="control-label" for="unaam">Gebruikersnaam</label>
                            <div class="controls">
                                <input type="text" name="unaam" value="" class="input-xlarge"><br>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="naam">Naam</label>
                            <div class="controls">
                                <input type="text" name="naam" value="" class="input-xlarge"><br>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="nr">Telefoonnr</label>
                            <div class="controls">
                                <input type="text" name="nr" value="" class="input-xlarge"><br>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="pw" >Wachtwoord</label>
                            <div class="controls">
                                <input type="password" name="pw" class="input-xlarge">
                            </div>
                        </div>


                        <div class="control-group">
                            <div class="controls">
                                <input type="hidden" name="sub" value="nieuwAccount"><br>
                                <input type="Submit" value="Ok">
                            </div>
                        </div>
                        
                    </fieldset>
                </form> 
            <form action="ResController" method="Post" >       
                                    <input type="hidden" name="sub" value="afbreken">
                                    <input type="Submit" value="Terug">
                        </form>


            
                </div></div></div>
    </body>

</html>
