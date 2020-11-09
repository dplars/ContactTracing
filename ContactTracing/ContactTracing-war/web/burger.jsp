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
        
    
    <h1 style="margin-bottem:10px;"> 
        Huidige score: ${sessionScope.score}
        
 
        Huidige status: <label id = "STATUS"><p id = "STATUS" style="color:green;display:inline;">Veilig </p></label> 
    </h1> 
    <br> 
    <h2>
        Nieuw contact
    </h2>
    Naam van contactpersoon:<br>
    <input id="naam" type="text" name="naam" value="Test"><br> 
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
    <script>
        function updateStatus(){
            if(${sessionScope.score}>0){
                document.getElementById('STATUS').innerHTML  = "<p style='color:red;display:inline;'>Onveilig </p>";
            }
            else{
                document.getElementById('STATUS').innerHTML = "<p style='color:green;display:inline;'>Veilig</p>"
            }
        }
        updateStatus();
    </script> 
    <br>
    <label id = "GFG"> 
        
    </label> 
</body> 

    <jsp:include page="footer.jsp"/>
</html>       
