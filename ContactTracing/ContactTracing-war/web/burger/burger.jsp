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
    <title> 
        Burger
    </title> 
</head> 
  
<body> 
    <h2>Status raadplegen</h2>
    
    <form action="ResController" method="Post">      
        <input type="hidden" name="sub" value="burgerStatus">
        <input type="Submit" value="Status">
    </form>   
    
    <h2>Nieuw contact</h2>
    
    <form action="ResController" method="Post">      
        <input type="hidden" name="sub" value="burgerContact">
        <input type="Submit" value="Contact">
    </form>  
    
    <h2>Test aanvragen of raadplegen</h2>
    
    <form action="ResController" method="Post">      
        <input type="hidden" name="sub" value="burgerTest">
        <input type="Submit" value="Test">
    </form>
    
</body> 
    <jsp:include page="../footer.jsp"/>
    
</html>       
