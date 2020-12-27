<%-- 
    Document   : loginError
    Created on : Nov 16, 2020, 6:23:45 PM
    Author     : larsdepauw
--%>

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
			      <legend class="">Foutje</legend>
                    </div>
                    <form action="../ResController" method="Post">       
                                    <input type="hidden" name="sub" value="afbreken">
                                    <input type="Submit" value="Terug">
                    </form>
                </div></div></div>
    </body>
</html>
