<%-- 
    Document   : contact
    Created on : Nov 3, 2020, 5:43:59 PM
    Author     : dehan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>
        Nieuw contact
    </h2>
    Zoek contactpersoon(Op basis van deel van naam of telefoonnummer):<br>
    <input id="naam" type="text" name="naam" value="" >     
    <button onclick="zoek()"> 
        Zoek
    </button> 
    <br>
    
    
    <form action="ResController" method="Post">   
        
        <select id = "burgers" name="Sburger"><%--aangevuld met zoek()--%></select>
    <br>
    <h3>
        Type contact:
    </h3>
    <input type="radio" id="Type1" name="typeContact" value="1" checked="checked">
    <label for="Type1">1: Een nauw contact (afstand werd niet bewaard)</label><br>
    <input type="radio" id="Type2" name="typeContact" value="2">
    <label for="Type2">2: Een gewoon contact (afstand van 1,5m werd gerespecteerd)</label> <br>
    <input type="radio" id="Type3" name="typeContact" value="3">
    <label for="Type3">3: Een veilig contact (minder dan 15 minuten met afstand).</label>
    
    <br>     
    <br>    
        <input type="hidden" name="sub" value="NieuwContact">
        <input type="Submit" value="Nieuw contact">
    </form>
        
        <br>
        <form action="ResController" method="Post">       
                <input type="hidden" name="sub" value="burger">
                <input type="Submit" value="Terug">
        </form>
        
        <script> 
        var namen = []; 
        var Teles = [];
        var bids = [];
        <c:forEach items="${burgerLijst}" var="b">
            namen.push("${b.naam}");
            Teles.push("${b.telefoonnummer}");
            bids.push("${b.bid}");
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
    </body>
    
    <jsp:include page="../footer.jsp"/>
</html>
