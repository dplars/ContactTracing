<%-- 
    Document   : burger
    Created on : Nov 3, 2020, 5:04:10 PM
    Author     : dehan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.List"%>
<%@page import = "java.util.Iterator"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html> 
<html> 
  
<head> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
       <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        
    <title> 
        Burger
    </title> 
</head> 
  
<body> 
    
    <div class="container" style="margin-top: 10%">
    <div class="row">
		<div class="span12">
                    <div id="legend">
			      <legend class="">Burger</legend>
                    </div>
        
    <h2>Status raadplegen</h2>
    
    <form action="../ResController" method="Post">      
        <input type="hidden" name="sub" value="burgerStatus">
        <input type="Submit" value="Status">
    </form>   
    
    <h2>Nieuw contact</h2>
    
    <form action="../ResController" method="Post">      
        <input type="hidden" name="sub" value="burgerContact">
        <input type="Submit" value="Contact">
    </form>  
    
    <h2>Test aanvragen of raadplegen</h2>
    
    <form action="../ResController" method="Post">      
        <input type="hidden" name="sub" value="burgerTest">
        <input type="Submit" value="Test">
    </form>
    
  
    <jsp:include page="../footer.jsp"/>
                </div></div></div>
</body> 
    
    
</html>       
