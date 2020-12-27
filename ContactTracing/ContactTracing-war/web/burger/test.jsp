<%-- 
    Document   : test
    Created on : Nov 3, 2020, 5:44:12 PM
    Author     : dehan
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
        
    <title> 
        Test
    </title> 
</head> 
  
<body> 
    <div class="container" style="margin-top: 10%">
    <div class="row">
		<div class="span12">
                    <div id="legend">
			      <legend class="">Test</legend>
                    </div>
        <div id="aanvragen"></div>
        
        <br>
        <select name="TestTid" id = "TestTid" onChange="resultaat()">
            <c:forEach var="test" items="${applicationScope.testLijst}" >
                <option value="${test.tid}"> ${test.tid} </option> 
            </c:forEach>                    
        </select>
        
        <label id = "TestResultaat"> </label>
        
        
        <script>
        var Ttid = [];
        var Tres = [];
        <c:forEach items="${testLijst}" var="test">
            Ttid.push("${test.tid}");
            Tres.push("${test.testresultaat}");
        </c:forEach>
        function resultaat() { 
            tid = (document.getElementById('TestTid').value);
    
            var arrayLength = Ttid.length;
            
            entry = 'Nog geen testen';
            for (var i = 0; i < arrayLength; i++) {
                if(tid == Ttid[i]){
                    if(Tres[i]==1){
                        entry = "Negatief";
                    }
                    else if(Tres[i]==2){
                        entry = "Positief";
                    }
                    else{
                        entry = "In behandeling";
                    }
                   
                    break;
                }
                
            }
            document.getElementById('TestResultaat').innerHTML  = entry;
        } 
        resultaat();
         </script>
         <script>
             s = ""
             
             if(Tres[0] != 0){
                s +=  "<h1>Vraag een nieuwe test aan:</h1>";
                s +="<form action='../ResController' method='Post'>  ";
                s +="<input type='hidden' name='sub' value='nieuweTest'>";
                s+="<input type='Submit' value='Nieuwe test'>";
                s+="</form>";
         
             }
             else{
                 s +="<h1>Vorige test (Testnummer:"+Ttid[0]+") is nog in behandeling</h1>"; 
             }
             document.getElementById('aanvragen').innerHTML  = s;
       
      
        </script>
         <script>
        function updateMelding(){
            if (${sessionScope.melding} == null) {
            } else {
                if (${sessionScope.melding} == 0) {
                    //alert("Niets te melden");
                }
                else if(${sessionScope.melding} == 1){
                    alert("Status is gewijzigd");
                }
                else if(${sessionScope.melding} == 2){
                    alert("Testresultaat beschikbaar");
                }
            }
        }
        updateMelding();
    </script> 
        <br><br>
        <form action="../ResController" method="Post">       
                <input type="hidden" name="sub" value="burger">
                <input type="Submit" value="Terug">
        </form>
        <jsp:include page="../footer.jsp"/>
                </body>
    
    
    </div></div></div>
</html>
