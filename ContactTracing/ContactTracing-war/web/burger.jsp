<%-- 
    Document   : burger
    Created on : Nov 3, 2020, 5:04:10 PM
    Author     : dehan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html> 
  
<head> 
    <title> 
        How to change the text of 
        a label using JavaScript ? 
    </title> 
</head> 
  
<body> 
      
 
    Naam van contactpersoon:<br>
    <input id="naam" type="text" name="naam" value="Test"><br> 
    
  
    <br> 
    <input type="radio" id="Type1" name="typeContact" value="Type1" checked="checked">
    <label for="Type1">Type1</label><br>
    <input type="radio" id="Type2" name="typeContact" value="Type2">
    <label for="Type2">Type2</label> <br>
    <input type="radio" id="Type3" name="typeContact" value="Type3">
    <label for="Type3">Type3</label>
     <br>
                
      
    <button onclick="zoek()"> 
        Zoek
    </button> 
  
    <script> 
        function zoek() { 
            document.getElementById('GFG').innerHTML  = document.getElementById('naam').value; 
        } 
    </script> 
    <br>
    <label id = "GFG"> 
        
    </label> 
</body> 

    <jsp:include page="footer.jsp"/>
</html>       
