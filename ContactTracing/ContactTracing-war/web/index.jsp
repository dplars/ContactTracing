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
        <title>Index Pagina</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
       <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    </head>
    <body>
        <div class="container" style="margin-top: 10%">
    <div class="row">
		<div class="span12">
                    <div id="legend">
			      <legend class="">Index</legend>
                    </div>
             Burger: Jef en jos
                Tim score 1
             Arts: louis

        
        </form> 
        <h2>Registreer? (moet misschien niet?)</h2>
         <form action="ResController" method="Post">       
                <input type="hidden" name="sub" value="registreer">
                <input type="Submit" value="registreer?">
        </form>
        
        Inloggen als:
         <form action="ResController" method="Post">       
                <input type="hidden" name="sub" value="burger">
                <input type="Submit" value="Burger?">
        </form>
        </form> 
        
         <form action="ResController" method="Post">       
                <input type="hidden" name="sub" value="arts">
                <input type="Submit" value="Arts?">
        </form>
                </div></div></div>
    </body>
   

    








</html>
