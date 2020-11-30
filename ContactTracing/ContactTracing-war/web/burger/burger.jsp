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
        
    
    <h1 style="margin-bottem:10px;"> 
        Huidige score: ${sessionScope.score}
        
        Huidige status: <label id = "STATUS"><p id = "STATUS" style="color:green;display:inline;">Veilig </p></label> 
    </h1> 
    <br> 
    <h2>
        Nieuw contact
    </h2>
    Zoek contactpersoon(Op basis van deel van naam of telefoonnummer):<br>
    <input id="naam" type="text" name="naam" value=""><br> 
    
    <button onclick="zoek()"> 
        Zoek
    </button> 
    <br>
    
    
    <form action="ResController" method="Post">   
        
        <select id = "burgers" name="Sburger"><%--aangevuld met zoek()--%></select>
    <br>
    <input type="radio" id="Type1" name="typeContact" value="1" checked="checked">
    <label for="Type1">1: Een nauw contact (afstand werd niet bewaard)</label><br>
    <input type="radio" id="Type2" name="typeContact" value="2">
    <label for="Type2">2: Een gewoon contact (afstand van 1,5m werd gerespecteerd)</label> <br>
    <input type="radio" id="Type3" name="typeContact" value="3">
    <label for="Type3">3: Een veilig contact (minder dan 15 minuten met afstand).</label>
     <br>
                
        
        <input type="hidden" name="sub" value="NieuwContact">
        <input type="Submit" value="Nieuw contact">
    </form>
    
  
    <script> 
        var namen = []; 
        var Teles = [];
        var bids = [];
        <c:forEach items="${burgersNaam}" var="naam">
            namen.push("${naam}");
        </c:forEach>
        
        <c:forEach items="${burgersTele}" var="Tele">
            Teles.push("${Tele}");
        </c:forEach>
        <c:forEach items="${burgersBid}" var="naam">
            bids.push("${naam}");
        </c:forEach>
        function zoek() { 
            naam = (document.getElementById('naam').value).toLowerCase();;
            
            var options = "";
            var arrayLength = namen.length;
            
            for (var i = 0; i < arrayLength; i++) {
                entry = namen[i] +":"+ Teles[i];
                if(((entry.toLowerCase()).indexOf(naam) !== -1) && (${id} !=bids[i])){
                    options+=("<option value = '"+bids[i]+ "'>"+entry+"</option>");
                }
            }
            document.getElementById('burgers').innerHTML  = options; 
        } 
        zoek();
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
                </div></div></div>
</body> 
    <jsp:include page="../footer.jsp"/>
    
</html>       
